package eagle;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlEditorDebugger extends Application {

    private static final String[] HTML_TAGS = { "html", "head", "body", "div", "span", "script", "style", "h1", "p", "a", "img" };
    private static final String[] CSS_PROPERTIES = { "color", "background", "margin", "padding", "border", "font-size", "display" };
    private static final String[] JS_KEYWORDS = { "function", "var", "let", "const", "if", "else", "return", "for", "while" };

    private static final Pattern PATTERN = Pattern.compile(
            "(?i)(<[^>]+>)|" +                  // HTML tags
            "\\b(function|var|let|const|return|if|else|for|while)\\b|" + // JS keywords
            "#[a-zA-Z0-9_-]+|" +                // CSS IDs
            "\\.[a-zA-Z0-9_-]+"                 // CSS classes
    );

    private CodeArea codeArea;
    private ContextMenu suggestionsPopup = new ContextMenu();

    @Override
    public void start(Stage primaryStage) {
        codeArea = new CodeArea();
        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));

        codeArea.textProperty().addListener((obs, oldText, newText) ->
                codeArea.setStyleSpans(0, computeHighlighting(newText)));

        codeArea.addEventHandler(KeyEvent.KEY_RELEASED, e -> {
            String prefix = getCurrentWord();
            if (!prefix.isEmpty()) {
                showSuggestions(prefix);
            } else {
                suggestionsPopup.hide();
            }
        });

        codeArea.replaceText("<html>\n  <head><style>.myClass { color: red; }</style></head>\n" +
                "  <body><script>function test() { return true; }</script></body>\n</html>");

        BorderPane root = new BorderPane(codeArea);
        Scene scene = new Scene(root, 800, 600);

        // Apply your custom CSS
        scene.getStylesheets().add(getClass().getResource("/eagle/editor.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("HTML/CSS/JS Editor with Autocomplete");
        primaryStage.show();
    }

    private String getCurrentWord() {
        int caretPos = codeArea.getCaretPosition();
        String text = codeArea.getText().substring(0, caretPos);
        int lastSpace = Math.max(text.lastIndexOf(' '), text.lastIndexOf('\n'));
        return text.substring(lastSpace + 1).trim();
    }

    private void showSuggestions(String prefix) {
        List<String> suggestions = getSuggestions(prefix);
        if (suggestions.isEmpty()) {
            suggestionsPopup.hide();
            return;
        }

        List<CustomMenuItem> menuItems = new ArrayList<>();
        for (String suggestion : suggestions) {
            Label entryLabel = new Label(suggestion);
            CustomMenuItem item = new CustomMenuItem(entryLabel, true);
            item.setOnAction(e -> {
                replaceCurrentWord(suggestion);
                suggestionsPopup.hide();
            });
            menuItems.add(item);
        }

        suggestionsPopup.getItems().setAll(menuItems);

        // Try to show popup near the caret
        codeArea.requestFocus();
        codeArea.getCaretBounds().ifPresent(bounds -> {
            Point2D screenPos = codeArea.localToScreen(bounds.getMaxX(), bounds.getMaxY());
            if (screenPos != null) {
                suggestionsPopup.show(codeArea, screenPos.getX(), screenPos.getY() + 20);
            }
        });
    }

    private void replaceCurrentWord(String suggestion) {
        int caretPos = codeArea.getCaretPosition();
        String textUpToCaret = codeArea.getText().substring(0, caretPos);
        int lastSpace = Math.max(textUpToCaret.lastIndexOf(' '), textUpToCaret.lastIndexOf('\n'));
        codeArea.replaceText(lastSpace + 1, caretPos, suggestion);
    }

    private List<String> getSuggestions(String prefix) {
        List<String> all = new ArrayList<>();
        Collections.addAll(all, HTML_TAGS);
        Collections.addAll(all, JS_KEYWORDS);
        Collections.addAll(all, CSS_PROPERTIES);

        String lower = prefix.toLowerCase();
        List<String> result = new ArrayList<>();
        for (String s : all) {
            if (s.toLowerCase().startsWith(lower)) {
                result.add(s);
            }
        }
        Collections.sort(result);
        return result;
    }

    private StyleSpans<Collection<String>> computeHighlighting(String text) {
        Matcher matcher = PATTERN.matcher(text);
        StyleSpansBuilder<Collection<String>> spansBuilder = new StyleSpansBuilder<>();

        int lastKwEnd = 0;
        while (matcher.find()) {
            String styleClass =
                    matcher.group(1) != null ? "html-tag" :
                    matcher.group(2) != null ? "js-keyword" :
                    matcher.group(3) != null ? "css-id" :
                    matcher.group(4) != null ? "css-class" :
                    null;

            spansBuilder.add(Collections.emptyList(), matcher.start() - lastKwEnd);
            spansBuilder.add(Collections.singleton(styleClass), matcher.end() - matcher.start());
            lastKwEnd = matcher.end();
        }

        spansBuilder.add(Collections.emptyList(), text.length() - lastKwEnd);
        return spansBuilder.create();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
