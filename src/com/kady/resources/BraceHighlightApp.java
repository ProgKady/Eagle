package com.kady.resources;
import java.net.URL;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.StyleClassedTextArea;

import java.util.*;
import org.fxmisc.richtext.model.StyleSpansBuilder;

public class BraceHighlightApp extends Application {

    CodeArea codeArea = new CodeArea();

    @Override
    public void start(Stage stage) {
        codeArea.setStyle("-fx-font-family: 'Consolas'; -fx-font-size: 14px;-fx-background-color:#121212;-fx-font-color:white;");
        codeArea.replaceText("public class Example {\n    void method() {\n        if (true) {\n            System.out.println(\"Hello\");\n        }\n    }\n}");

        codeArea.caretPositionProperty().addListener((obs, oldPos, newPos) -> {
            highlightBraces(codeArea.getText(), newPos);
        });

        StackPane root = new StackPane(codeArea);
        Scene scene = new Scene(root, 600, 400);
       
       URL css = getClass().getResource("nord-dark.css");
if (css != null) {
    scene.getStylesheets().add(css.toExternalForm());
} else {
    System.out.println("❌ highlight.css not found!");
}


        stage.setScene(scene);
        stage.setTitle("Brace Highlighter");
        stage.show();
    }

    void highlightBraces(String text, int caretPos) {
        codeArea.setStyleSpans(0, codeArea.getStyleSpans(0, text.length())); // reset
        if (caretPos > 0 && caretPos <= text.length()) {
            char c = text.charAt(caretPos - 1);
            String pair = "{}[]()";
            int index = pair.indexOf(c);
            if (index != -1) {
                boolean forward = index % 2 == 0;
                char open = pair.charAt(index & ~1);
                char close = pair.charAt(index | 1);
                int match = findMatch(text, caretPos - 1, open, close, forward);
                if (match != -1) {
                    styleBraces(caretPos - 1, match);
                }
            }
        }
    }

    int findMatch(String text, int pos, char open, char close, boolean forward) {
        int depth = 0;
        int i = pos;
        while (i >= 0 && i < text.length()) {
            char c = text.charAt(i);
            if (c == open) depth++;
            if (c == close) depth--;
            if (depth == 0) return i;
            i += forward ? 1 : -1;
        }
        return -1;
    }

    void styleBraces(int pos1, int pos2) {
        int len = codeArea.getText().length();
        StyleSpansBuilder<Collection<String>> builder = new StyleSpansBuilder<>();
        int p1 = Math.min(pos1, pos2);
        int p2 = Math.max(pos1, pos2);
        builder.add(Collections.emptyList(), p1);
        builder.add(Collections.singleton("brace-highlight"), 1);
        builder.add(Collections.emptyList(), p2 - p1 - 1);
        builder.add(Collections.singleton("brace-highlight"), 1);
        builder.add(Collections.emptyList(), len - p2 - 1);
        codeArea.setStyleSpans(0, builder.create());
    }

    public static void main(String[] args) {
        launch();
    }
}
