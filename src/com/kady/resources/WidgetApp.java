package com.kady.resources;



import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WidgetApp extends Application {

    private Label timeLabel;
    private Label weatherLabel;
    private Text quoteLabel;

    @Override
    public void start(Stage primaryStage) {
        // Time Widget
        timeLabel = new Label();
        timeLabel.setFont(new Font("Arial", 30));
        timeLabel.setAlignment(Pos.CENTER);

        // Weather Widget (Simulated)
        weatherLabel = new Label("Weather: Sunny, 25°C");
        weatherLabel.setFont(new Font("Arial", 20));

        // Quote of the Day Widget
        quoteLabel = new Text("Quote of the day: \"Stay positive, work hard, make it happen!\"");
        quoteLabel.setFont(new Font("Arial", 16));

        // Layout for Widgets
        VBox vbox = new VBox(10, timeLabel, weatherLabel, quoteLabel);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: lightblue; -fx-padding: 20;");

        // Timeline for updating the time every second
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0), e -> updateTime()), // Initial update
                new KeyFrame(Duration.seconds(1), e -> updateTime()) // Update every second
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // Set up the scene and stage
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("JavaFX Widgets Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to update the current time
    private void updateTime() {
        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        timeLabel.setText("Current Time: " + time);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
