// MultiMediaDropper.java
// (uses format with cover, source, favorited)

import com.jfoenix.controls.JFXTextArea;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.util.*;

public class MultiMediaDropper extends Application {

    private final JFXTextArea jsonOutput = new JFXTextArea();

    @Override
    public void start(Stage primaryStage) {
        Label dropLabel = new Label("🎵 Drag and drop audio + image files below");
        dropLabel.setFont(Font.font("Arial", 18));
        dropLabel.setTextFill(Color.web("#333"));

        jsonOutput.setPromptText("Scripts will be generated here...");
        jsonOutput.setLabelFloat(true);
        jsonOutput.setPrefHeight(300);
        jsonOutput.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 13px;");

        VBox root = new VBox(20, dropLabel, jsonOutput);
        root.setStyle("-fx-background-color: #F9F9F9;");
        root.setPadding(new Insets(40));

        root.setOnDragOver(this::handleDragOver);
        root.setOnDragDropped(this::handleDrop);

        primaryStage.setScene(new Scene(root, 700, 450));
        primaryStage.setTitle("Media Script Generator");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void handleDragOver(DragEvent e) {
        if (e.getDragboard().hasFiles()) {
            e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        e.consume();
    }

    private void handleDrop(DragEvent e) {
        Dragboard db = e.getDragboard();
        boolean success = false;

        if (db.hasFiles()) {
            List<File> images = new ArrayList<>();
            List<File> audios = new ArrayList<>();

            for (File file : db.getFiles()) {
                String name = file.getName().toLowerCase();
                if (name.endsWith(".jpg") || name.endsWith(".png")) images.add(file);
                if (name.endsWith(".mp3") || name.endsWith(".wav")) audios.add(file);
            }

            StringBuilder sb = new StringBuilder();
            int count = Math.min(images.size(), audios.size());

            for (int i = 0; i < count; i++) {
                File img = images.get(i), audio = audios.get(i);
                String title = MP3MetadataUtil.getTitle(audio);
                String artist = MP3MetadataUtil.getArtist(audio);

                sb.append("{\n")
                  .append("  name: \"").append(title).append("\",\n")
                  .append("  artist: \"").append(artist).append("\",\n")
                  .append("  cover: \"images/").append(img.getName()).append("\",\n")
                  .append("  source: \"songs/").append(audio.getName()).append("\",\n")
                  .append("  favorited: false\n},\n\n");
            }

            jsonOutput.setText(count == 0 ? "❗ No valid files found." : sb.toString());
            success = true;
        }

        e.setDropCompleted(success);
        e.consume();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
