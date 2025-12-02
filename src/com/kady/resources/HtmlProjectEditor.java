package com.kady.resources;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import org.fxmisc.richtext.CodeArea;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Optional;

public class HtmlProjectEditor extends Application {

    private TreeView<Path> projectTree;
    private CodeArea codeArea;
    private Path projectRoot;

    @Override
    public void start(Stage primaryStage) {
        Button newProjectBtn = new Button("New HTML Project");
        Button openProjectBtn = new Button("Open Project");
        newProjectBtn.setOnAction(e -> createHtmlProject(primaryStage));
        
        
        
        openProjectBtn.setOnAction(e -> openExistingProject(primaryStage));
        ToolBar toolBar = new ToolBar(newProjectBtn, openProjectBtn);

        
        
        
        
        
        
        
        projectTree = new TreeView<>();
        projectTree.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
                if (selectedItem != null && Files.isRegularFile(selectedItem.getValue())) {
                    loadFileToEditor(selectedItem.getValue());
                }
            }
        });

        
        
        
        
        codeArea = new CodeArea();
        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(new ScrollPane(projectTree), new ScrollPane(codeArea));
        splitPane.setDividerPositions(0.3);
        BorderPane root = new BorderPane();
        root.setTop(toolBar);
        root.setCenter(splitPane);
        Scene scene = new Scene(root, 1000, 700);
        primaryStage.setTitle("HTML Project Editor");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    
    

    private void createHtmlProject(Stage stage) {
        
        
        
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select Location to Create Project");
        Path selectedDir = Optional.ofNullable(chooser.showDialog(stage))
                .map(File::toPath)
                .orElse(null);

        if (selectedDir != null) {
            TextInputDialog dialog = new TextInputDialog("MyHtmlProject");
            dialog.setTitle("Project Name");
            dialog.setHeaderText("Enter project name:");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(name -> {
                try {
                    projectRoot = selectedDir.resolve(name);
                    Files.createDirectories(projectRoot);
                    Files.write(projectRoot.resolve("index.html"),
                            "<!DOCTYPE html>\n<html>\n<head>\n<title>My Project</title>\n<link rel=\"stylesheet\" href=\"style.css\">\n</head>\n<body>\n<h1>Hello World!</h1>\n<script src=\"script.js\"></script>\n</body>\n</html>"
                                    .getBytes(StandardCharsets.UTF_8));
                    Files.write(projectRoot.resolve("style.css"),
                            "body { font-family: Arial; background-color: #f0f0f0; }"
                                    .getBytes(StandardCharsets.UTF_8));
                    Files.write(projectRoot.resolve("script.js"),
                            "console.log('Hello from JS!');"
                                    .getBytes(StandardCharsets.UTF_8));
                    refreshProjectTree();
                } catch (IOException ex) {
                    showAlert("Error", "Failed to create project: " + ex.getMessage());
                }
            });
        }
        
        
        
    }

    
    
    
    private void openExistingProject(Stage stage) {
        
        
        
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select Existing Project Folder");
        Path selectedDir = Optional.ofNullable(chooser.showDialog(stage))
                .map(File::toPath)
                .orElse(null);

        if (selectedDir != null) {
            projectRoot = selectedDir;
            refreshProjectTree();
        }
        
        
        
        
    }
    
    
    
    

    
    
    private void refreshProjectTree() {
        if (projectRoot != null) {
            TreeItem<Path> rootItem = createNode(projectRoot);
            projectTree.setRoot(rootItem);
        }
    }

    
    private TreeItem<Path> createNode(Path path) {
        TreeItem<Path> item = new TreeItem<>(path);
        if (Files.isDirectory(path)) {
            try {
                DirectoryStream<Path> dir = Files.newDirectoryStream(path);
                for (Path subPath : dir) {
                    item.getChildren().add(createNode(subPath));
                }
            } catch (IOException ignored) {
            }
        }
        return item;
    }

    
    private void loadFileToEditor(Path filePath) {
        try {
            String content = new String(Files.readAllBytes(filePath), StandardCharsets.UTF_8);
            codeArea.replaceText(content);
        } catch (IOException e) {
            showAlert("Error", "Failed to load file: " + e.getMessage());
        }
    }

    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    
    
    

    public static void main(String[] args) {
        launch(args);
    }
}
