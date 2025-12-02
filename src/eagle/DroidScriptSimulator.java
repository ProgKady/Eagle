package eagle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DroidScriptSimulator extends Application {

    private VBox uiLayout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TextArea codeArea = new TextArea(
            "// Simulated DroidScript code\n" +
            "app.AddText(\"Welcome to DroidScript\")\n" +
            "app.AddButton(\"Click Me\")\n" +
            "app.AddTextEdit()\n" +
            "app.AddCheckBox(\"I agree\")"
        );

        Button runButton = new Button("Run Code");
        uiLayout = new VBox(10);
        uiLayout.setStyle("-fx-padding: 15; -fx-background-color: #f9f9f9;");

        runButton.setOnAction(e -> executeDroidScript(codeArea.getText()));

        VBox root = new VBox(10, new Label("DroidScript Code:"), codeArea, runButton, new Separator(), uiLayout);
        root.setStyle("-fx-padding: 10;");

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("DroidScript UI Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Parses and simulates DroidScript-style code
    private void executeDroidScript(String code) {
        uiLayout.getChildren().clear();
        String[] lines = code.split("\n");

        for (String line : lines) {
            line = line.trim();
            if (line.startsWith("app.AddText(")) {
                String text = extractString(line);
                uiLayout.getChildren().add(new Label(text));
            } else if (line.startsWith("app.AddButton(")) {
                String text = extractString(line);
                Button btn = new Button(text);
                uiLayout.getChildren().add(btn);
            } else if (line.startsWith("app.AddTextEdit(")) {
                TextField tf = new TextField();
                tf.setPromptText("TextEdit");
                uiLayout.getChildren().add(tf);
            } else if (line.startsWith("app.AddCheckBox(")) {
                String text = extractString(line);
                CheckBox cb = new CheckBox(text);
                uiLayout.getChildren().add(cb);
            }
        }
    }

    private String extractString(String line) {
        int firstQuote = line.indexOf("\"");
        int lastQuote = line.lastIndexOf("\"");
        if (firstQuote != -1 && lastQuote != -1 && lastQuote > firstQuote) {
            return line.substring(firstQuote + 1, lastQuote);
        }
        return "Unknown";
    }
}
