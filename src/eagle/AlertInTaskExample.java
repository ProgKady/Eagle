package eagle;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;
import java.util.concurrent.CountDownLatch;

public class AlertInTaskExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button startButton = new Button("Start Task");

        startButton.setOnAction(e -> {
            // Alert 1 (progress/info alert)
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Alert 1");
            alert1.setHeaderText("Task Running...");
            alert1.setContentText("Please wait...");
            alert1.initOwner(primaryStage);

            Task<Void> backgroundTask = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    // Show Alert 1 on UI thread
                    Platform.runLater(alert1::show);

                    // Simulate doing some work
                    Thread.sleep(2000);

                    // At this point, we need user input
                    CountDownLatch latch = new CountDownLatch(1);
                    final String[] userInput = new String[1];

                    Platform.runLater(() -> {
                        TextInputDialog dialog = new TextInputDialog();
                        dialog.setTitle("Alert 2");
                        dialog.setHeaderText("Enter a value");
                        dialog.setContentText("Input:");

                        Optional<String> result = dialog.showAndWait();
                        userInput[0] = result.orElse("No input");
                        latch.countDown(); // Resume task
                    });

                    latch.await(); // Wait until user responds

                    // Use user input in some way
                    System.out.println("User entered: " + userInput[0]);

                    // Simulate final work
                    Thread.sleep(1000);

                    // Close alert 1
                    Platform.runLater(() -> {
                        alert1.setContentText("Task completed with input: " + userInput[0]);
                        alert1.getButtonTypes().setAll(ButtonType.OK);
                    });

                    return null;
                }
            };

            new Thread(backgroundTask).start();
        });

        VBox root = new VBox(10, startButton);
        root.setStyle("-fx-padding: 20");
        Scene scene = new Scene(root, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Alert Flow Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
