package com.kady.resources;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ReplaceImage {
    public static void main(String[] args) {
        // Path to the image you want to replace
        String originalImagePath = "C:\\Users\\Ahmed.ElKady\\Desktop\\kadysoft\\images\\kadysoft.png";

        // Path to the new image that will replace the old one
        String newImagePath = "C:\\Users\\Ahmed.ElKady\\Desktop\\mylogo.png";

        try {
            File originalImage = new File(originalImagePath);
            File newImage = new File(newImagePath);

            // Replace (copy and overwrite) the original image with the new one
            Files.copy(newImage.toPath(), originalImage.toPath(), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Image replaced successfully.");
        } catch (IOException e) {
            System.err.println("Error while replacing image: " + e.getMessage());
        }
    }
}
