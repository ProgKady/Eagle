package eagle;




import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;
import org.reactfx.Subscription;

import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;


public class ProfessionalCodeEditor extends BorderPane {

    private final CodeArea codeArea = new CodeArea();
    private final Label statusLabel = new Label("Ln 1, Col 1");
    private final ContextMenu suggestionsMenu = new ContextMenu();
    private boolean darkTheme = true;

    // Patterns
    private static final String[] KEYWORDS = {
        "abstract","assert","boolean","break","byte","case","catch","char","class","const","continue",
        "default","do","double","else","enum","extends","final","finally","float","for","goto","if","implements",
        "import","instanceof","int","interface","long","native","new","package","private","protected","public",
        "return","short","static","strictfp","super","switch","synchronized","this","throw","throws","transient",
        "try","void","volatile","while","true","false","null"
    };
    private static final String KEYWORD_PATTERN = "\\b(" + String.join("|", KEYWORDS) + ")\\b";
    private static final String PAREN_PATTERN = "\\(|\\)";
    private static final String BRACE_PATTERN = "\\{|\\}";
    private static final String BRACKET_PATTERN = "\\[|\\]";
    private static final String SEMICOLON_PATTERN = "\\;";
    private static final String STRING_PATTERN = "\"([^\"\\\\]|\\\\.)*\"";
    private static final String COMMENT_PATTERN = "//[^\\n]*|/\\*(.|\\R)*?\\*/";
    private static final Pattern PATTERN = Pattern.compile(
        "(?<KEYWORD>" + KEYWORD_PATTERN + ")"
        + "|(?<PAREN>" + PAREN_PATTERN + ")"
        + "|(?<BRACE>" + BRACE_PATTERN + ")"
        + "|(?<BRACKET>" + BRACKET_PATTERN + ")"
        + "|(?<SEMICOLON>" + SEMICOLON_PATTERN + ")"
        + "|(?<STRING>" + STRING_PATTERN + ")"
        + "|(?<COMMENT>" + COMMENT_PATTERN + ")"
    );

    private static final List<String> COMPLETIONS = Arrays.asList(
        "public","private","protected","class","interface","void","static",
        "if","else","for","while","return","new","try","catch"
    );

    public ProfessionalCodeEditor() {
        initializeEditor();
        initializeKeyBindings();
        initializeCompletion();
        setCenter(new VirtualizedScrollPane<>(codeArea));
        setBottom(statusLabel);
        applyTheme();
    }
    

    
    
    private void initializeEditor() {
    codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));

    Subscription cleanup = codeArea.multiPlainChanges()
        .successionEnds(java.time.Duration.ofMillis(300)) // JavaFX Duration for Java 8
        .supplyTask(() -> computeHighlightingAsync(codeArea.getText()))
        .awaitLatest(codeArea.multiPlainChanges())
        .filterMap(t -> {
            try {
                return Optional.of(t.get());
            } catch (Exception e) {
                e.printStackTrace();
                return Optional.empty();
            }
        })
        .subscribe(spans -> codeArea.setStyleSpans(0, spans));

    codeArea.addEventHandler(KeyEvent.KEY_PRESSED, this::handleAutoIndentAndBrackets);
    codeArea.caretPositionProperty().addListener((obs, oldP, newP) -> updateStatus());
}

   
    
    private Task<StyleSpans<Collection<String>>> computeHighlightingAsync(String text) {
    return new Task<StyleSpans<Collection<String>>>() {
        @Override
        protected StyleSpans<Collection<String>> call() {
            return computeHighlighting(text);
        }
    };
}

    

private StyleSpans<Collection<String>> computeHighlighting(String text) {
    Matcher matcher = PATTERN.matcher(text);
    StyleSpansBuilder<Collection<String>> spansBuilder = new StyleSpansBuilder<>();
    int lastEnd = 0;

    while (matcher.find()) {
        String styleClass =
            matcher.group("KEYWORD") != null ? "keyword" :
            matcher.group("PAREN") != null ? "paren" :
            matcher.group("BRACE") != null ? "brace" :
            matcher.group("BRACKET") != null ? "bracket" :
            matcher.group("SEMICOLON") != null ? "semicolon" :
            matcher.group("STRING") != null ? "string" :
            matcher.group("COMMENT") != null ? "comment" : null;

        assert styleClass != null;
        spansBuilder.add(Collections.emptyList(), matcher.start() - lastEnd);
        spansBuilder.add(Collections.singleton(styleClass), matcher.end() - matcher.start());
        lastEnd = matcher.end();
    }

    spansBuilder.add(Collections.emptyList(), text.length() - lastEnd);
    return spansBuilder.create();
}


    
    
    
    private void initializeKeyBindings() {
        codeArea.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (new KeyCodeCombination(KeyCode.F, KeyCombination.CONTROL_DOWN).match(e)) {
                    showFindDialog();
                    e.consume();
                } else if (new KeyCodeCombination(KeyCode.SPACE, KeyCombination.CONTROL_DOWN).match(e)) {
                    showSuggestions();
                    e.consume();
                } else if (new KeyCodeCombination(KeyCode.T, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN).match(e)) {
                    darkTheme = !darkTheme;
                    applyTheme();
                    e.consume();
                }
            }
        });
    }

    private void initializeCompletion() {
        suggestionsMenu.setAutoHide(true);
        codeArea.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCharacter().matches("[A-Za-z]")) {
                    showSuggestions();
                }
            }
        });
    }

    private void showSuggestions() {
        suggestionsMenu.hide();
        String prefix = extractCurrentWord();
        if (prefix.length() == 0) return;
        suggestionsMenu.getItems().clear();
        for (String s : COMPLETIONS) {
            if (s.startsWith(prefix)) {
                MenuItem mi = new MenuItem(s);
                mi.setOnAction(a -> replaceCurrentWord(s));
                suggestionsMenu.getItems().add(mi);
            }
        }
        if (!suggestionsMenu.getItems().isEmpty()) {
            suggestionsMenu.show(codeArea, Side.BOTTOM, 0, 0);
        }
    }

    private void showFindDialog() {
        TextInputDialog dlg = new TextInputDialog();
        dlg.setTitle("Find");
        dlg.setHeaderText("Text to find:");
        Optional<String> res = dlg.showAndWait();
        if (res.isPresent()) {
            String find = res.get();
            String content = codeArea.getText();
            int pos = content.indexOf(find, codeArea.getCaretPosition());
            if (pos >= 0) {
                codeArea.selectRange(pos, pos + find.length());
                codeArea.requestFollowCaret();
            }
        }
    }

    private void handleAutoIndentAndBrackets(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER) {
            int pos = codeArea.getCaretPosition();
            String txt = codeArea.getText().substring(0, pos);
            String lastLine = txt.substring(txt.lastIndexOf('\n') + 1);
            String indent = lastLine.replaceFirst("\\S.*", "");
            Platform.runLater(new Runnable() {
                public void run() {
                    codeArea.insertText(pos, "\n" + indent);
                }
            });
        }
        String ch = e.getText();
        if ("([{\"'".contains(ch)) {
            char close = ch.equals("(") ? ')' : ch.equals("{") ? '}' :
                         ch.equals("[") ? ']' : ch.equals("\"") ? '"' :
                         ch.equals("'") ? '\'' : 0;
            if (close != 0) {
                final int caret = codeArea.getCaretPosition();
                codeArea.insertText(caret, String.valueOf(close));
                codeArea.moveTo(caret);
            }
        }
    }

    private void updateStatus() {
        int line = codeArea.getCurrentParagraph() + 1;
        int col = codeArea.getCaretColumn() + 1;
        statusLabel.setText("Ln " + line + ", Col " + col);
    }

    private String extractCurrentWord() {
        int pos = codeArea.getCaretPosition();
        String text = codeArea.getText();
        int start = pos;
        while (start > 0 && Character.isLetter(text.charAt(start - 1))) start--;
        return text.substring(start, pos);
    }

    private void replaceCurrentWord(String rep) {
        int pos = codeArea.getCaretPosition();
        String text = codeArea.getText();
        int start = pos;
        while (start > 0 && Character.isLetter(text.charAt(start - 1))) start--;
        codeArea.replaceText(start, pos, rep);
        codeArea.moveTo(start + rep.length());
    }

    private void applyTheme() {
        codeArea.getStylesheets().clear();
        String sheet = darkTheme ? "java-keywords.css" : "java-keywords.css";
        codeArea.getStylesheets().add(getClass().getResource(sheet).toExternalForm());
    }

    public CodeArea getCodeArea() {
        return codeArea;
    }
}
