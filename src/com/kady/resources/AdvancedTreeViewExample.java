package com.kady.resources;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.nio.file.*;
import java.io.*;

public class AdvancedTreeViewExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the TreeView with file icons
        TreeView<Path> projectTree = new TreeView<>();
        TreeItem<Path> rootItem = new TreeItem<>(Paths.get("Project"));
        projectTree.setRoot(rootItem);

        // Add some files and directories to the tree (for demonstration purposes)
        addProjectFiles(rootItem);

        // Set up context menu for right-click actions
        ContextMenu contextMenu = new ContextMenu();
        MenuItem renameItem = new MenuItem("Rename");
        MenuItem deleteItem = new MenuItem("Delete");
        contextMenu.getItems().addAll(renameItem, deleteItem);

        // Handle right-click (context menu)
        projectTree.setContextMenu(contextMenu);

        // On right-click, show the context menu for file operations
        projectTree.setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
                if (selectedItem != null && Files.isRegularFile(selectedItem.getValue())) {
                    contextMenu.show(projectTree, event.getScreenX(), event.getScreenY());
                }
            }
        });

        // Double-click to open file
        projectTree.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
                if (selectedItem != null && Files.isRegularFile(selectedItem.getValue())) {
                    loadFileToEditor(selectedItem.getValue());
                }
            }
        });

        // Action for Rename
        renameItem.setOnAction(e -> {
            TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
            if (selectedItem != null && Files.isRegularFile(selectedItem.getValue())) {
                // Rename logic here
                renameFile(selectedItem.getValue());
            }
        });

        // Action for Delete
        deleteItem.setOnAction(e -> {
            TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
            if (selectedItem != null && Files.isRegularFile(selectedItem.getValue())) {
                deleteFile(selectedItem.getValue());
            }
        });

        // Layout
        VBox layout = new VBox(10, projectTree);
        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setTitle("Advanced TreeView Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addProjectFiles(TreeItem<Path> rootItem) {
        Path file1 = Paths.get("Project", "index.html");
        Path file2 = Paths.get("Project", "style.css");
        Path file3 = Paths.get("Project", "script.js");

        TreeItem<Path> fileItem1 = createFileTreeItem(file1);
        TreeItem<Path> fileItem2 = createFileTreeItem(file2);
        TreeItem<Path> fileItem3 = createFileTreeItem(file3);

        rootItem.getChildren().addAll(fileItem1, fileItem2, fileItem3);
    }

    private TreeItem<Path> createFileTreeItem(Path filePath) {
        Image icon = new Image("file:icons/file-icon.png"); // Add your own file icon here
        ImageView iconView = new ImageView(icon);
        iconView.setFitWidth(16);
        iconView.setFitHeight(16);

        TreeItem<Path> item = new TreeItem<>(filePath);
        item.setGraphic(iconView);
        return item;
    }

    private void loadFileToEditor(Path filePath) {
        // Logic to load file contents into the editor (e.g., open in a TextArea)
        System.out.println("Loading file: " + filePath);
    }

    private void renameFile(Path filePath) {
        // Logic to rename the file
        System.out.println("Renaming file: " + filePath);
    }

    private void deleteFile(Path filePath) {
        try {
            Files.delete(filePath);
            System.out.println("File deleted: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
