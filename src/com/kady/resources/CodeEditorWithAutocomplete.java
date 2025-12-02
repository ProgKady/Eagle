package com.kady.resources;




import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import org.fxmisc.richtext.CodeArea;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CodeEditorWithAutocomplete extends Application {

    private final List<String> keywords = Arrays.asList(
            "public", "private", "class", "static", "void",
            "if", "else", "int", "String"
    );

    private final Popup suggestionPopup = new Popup();
    private final ListView<String> suggestionList = new ListView<>();

    @Override
    public void start(Stage primaryStage) {
        CodeArea codeArea = new CodeArea();

        // Setup suggestion popup
        suggestionPopup.getContent().add(suggestionList);
        suggestionPopup.setAutoHide(true);

        codeArea.setOnKeyTyped(event -> {
            String text = codeArea.getText();
            int caretPosition = codeArea.getCaretPosition();
            String word = getCurrentWord(text, caretPosition);

            if (!word.isEmpty()) {
                List<String> suggestions = keywords.stream()
                        .filter(k -> k.startsWith(word))
                        .collect(Collectors.toList());

                if (!suggestions.isEmpty()) {
                    suggestionList.getItems().setAll(suggestions);
                    suggestionList.getSelectionModel().selectFirst();

                    // Show popup near caret if position is available
                    if (codeArea.getCaretBounds().isPresent()) {
                        double x = codeArea.getCaretBounds().get().getMinX();
                        double y = codeArea.getCaretBounds().get().getMaxY();
                        suggestionPopup.show(codeArea,
                                codeArea.localToScreen(x, y).getX(),
                                codeArea.localToScreen(x, y).getY());
                    }
                } else {
                    suggestionPopup.hide();
                }
            } else {
                suggestionPopup.hide();
            }
        });

        codeArea.setOnKeyPressed(event -> {
            if (suggestionPopup.isShowing()) {
                if (event.getCode() == KeyCode.DOWN) {
                    suggestionList.getSelectionModel().selectNext();
                    event.consume();
                } else if (event.getCode() == KeyCode.UP) {
                    suggestionList.getSelectionModel().selectPrevious();
                    event.consume();
                } else if (event.getCode() == KeyCode.ENTER) {
                    String selected = suggestionList.getSelectionModel().getSelectedItem();
                    if (selected != null) {
                        int caret = codeArea.getCaretPosition();
                        String currentWord = getCurrentWord(codeArea.getText(), caret);
                        codeArea.replaceText(caret - currentWord.length(), caret, selected);
                        suggestionPopup.hide();
                        event.consume();
                    }
                }
            }
        });

        StackPane root = new StackPane(codeArea);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CodeArea with Autocomplete");
        primaryStage.show();
    }

    private String getCurrentWord(String text, int caretPosition) {
        int start = caretPosition - 1;
        while (start >= 0 && Character.isLetter(text.charAt(start))) {
            start--;
        }
        return text.substring(start + 1, caretPosition);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
