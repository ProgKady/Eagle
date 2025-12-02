package com.kady.resources;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import org.json.JSONObject;

public class ImgurUploaderApp extends Application {

    // Your Imgur Client-ID (from your Imgur application)
    private static final String CLIENT_ID = "203da2f300125a1";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 250);

        // Button to upload image
        Button uploadButton = new Button("Upload Image");
        uploadButton.setOnAction(event -> uploadImage(primaryStage));

        root.getChildren().add(uploadButton);

        primaryStage.setTitle("Imgur Upload Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void uploadImage(Stage primaryStage) {
        // FileChooser to select image
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        if (selectedFile != null) {
            try {
                // Upload image to Imgur and get the URL
                String imageUrl = uploadImageToImgur(selectedFile.toPath());

                // Show the uploaded image URL in the console
                System.out.println("Image uploaded to Imgur: " + imageUrl);

                // Display the image in the JavaFX window
                Image image = new Image(imageUrl);
                ImageView imageView = new ImageView(image);
                StackPane root = new StackPane();
                root.getChildren().add(imageView);
                Scene scene = new Scene(root, 600, 400);
                primaryStage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String uploadImageToImgur(Path imagePath) throws IOException {
        // Create a new HttpURLConnection to Imgur API
        URL url = new URL("https://api.imgur.com/3/image");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Client-ID " + CLIENT_ID);
        connection.setDoOutput(true);

        // Prepare the image file for upload
        try (OutputStream outputStream = connection.getOutputStream();
             FileInputStream fileInputStream = new FileInputStream(imagePath.toFile())) {

            // Read the image file and send it as a multipart form
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }

        // Get the response from Imgur API
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse the JSON response to get the image URL
            JSONObject jsonResponse = new JSONObject(response.toString());
            return jsonResponse.getJSONObject("data").getString("link");
        } else {
            throw new IOException("Failed to upload image. HTTP response code: " + responseCode);
        }
    }
}
