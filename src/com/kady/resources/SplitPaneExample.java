package com.kady.resources;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class SplitPaneExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Left panel with a button
        Button leftButton = new Button("Left Panel");
        VBox leftPanel = new VBox(10, leftButton);
        
        
        
        // Right panel with a label
        Label rightLabel = new Label("Right Panel");
        VBox rightPanel = new VBox(10, rightLabel);
        
        
        
        // Center panel with a text field
        TextField centerField = new TextField("Center Panel");
        VBox centerPanel = new VBox(10, centerField);
        
        
        
        // Create SplitPane with left, center, and right sections
        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(leftPanel, centerPanel, rightPanel);
        
        // Layout and scene setup
        BorderPane layout = new BorderPane();
        layout.setCenter(splitPane);
        
        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setTitle("JavaFX SplitPane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
