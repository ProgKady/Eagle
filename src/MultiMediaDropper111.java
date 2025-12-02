import com.jfoenix.controls.JFXTextArea;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MultiMediaDropper111 extends Application {

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

        Scene scene = new Scene(root, 700, 450);
        primaryStage.setTitle("Media Script Generator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void handleDragOver(DragEvent event) {
        if (event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    private void handleDrop(DragEvent event) {
        Dragboard db = event.getDragboard();
        boolean success = false;

        if (db.hasFiles()) {
            success = true;

            List<File> imageFiles = new ArrayList<>();
            List<File> audioFiles = new ArrayList<>();

            for (File file : db.getFiles()) {
                String name = file.getName().toLowerCase();
                if (name.endsWith(".jpg") || name.endsWith(".png")) {
                    imageFiles.add(file);
                } else if (name.endsWith(".mp3") || name.endsWith(".wav")) {
                    audioFiles.add(file);
                }
            }

            StringBuilder scriptBuilder = new StringBuilder();
            int count = Math.min(imageFiles.size(), audioFiles.size());

            for (int i = 0; i < count; i++) {
                File audio = audioFiles.get(i);
                File image = imageFiles.get(i);

                String title = MP3MetadataUtil.getTitle(audio);
                String artist = MP3MetadataUtil.getArtist(audio);
                String imageNameOnly = stripExtension(image.getName());
                String audioNameOnly = stripExtension(audio.getName());

                scriptBuilder.append("{\n")
                        .append("  name: \"").append(title).append("\",\n")
                        .append("  artist: \"").append(artist).append("\",\n")
                        .append("  img: \"").append(imageNameOnly).append("\",\n")
                        .append("  src: \"").append(audioNameOnly).append("\"\n")
                        .append("},\n\n");
            }

            if (count == 0) {
                jsonOutput.setText("❗ No valid image/audio file pairs found.");
            } else {
                jsonOutput.setText(scriptBuilder.toString());
            }
        }

        event.setDropCompleted(success);
        event.consume();
    }

    private String stripExtension(String filename) {
        return filename.contains(".") ? filename.substring(0, filename.lastIndexOf('.')) : filename;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
