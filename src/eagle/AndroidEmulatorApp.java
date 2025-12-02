import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;

import java.io.*;

public class AndroidEmulatorApp extends Application {

    private Button btnStartEmulator;
    private Button btnConnectADB;
    private Button btnInstallAPK;

    @Override
    public void start(Stage primaryStage) {
        ProcessBuilder pb = new ProcessBuilder("C:\\Users\\Ahmed.ElKady\\Desktop\\platform-tools-latest-windows\\platform-tools\\adb.exe", "connect", "127.0.0.1:5555");
        btnStartEmulator = new Button("Start Android Emulator");
        btnConnectADB = new Button("Connect ADB");
        btnInstallAPK = new Button("Install APK");

        btnConnectADB.setDisable(true);
        btnInstallAPK.setDisable(true);

        btnStartEmulator.setOnAction(e -> startEmulator());
        btnConnectADB.setOnAction(e -> connectADB());
        btnInstallAPK.setOnAction(e -> installAPK(primaryStage));

        VBox root = new VBox(15, btnStartEmulator, btnConnectADB, btnInstallAPK);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #222; -fx-font-size: 14px;");
        for (Node node : root.getChildren()) {
            ((Button) node).setMaxWidth(Double.MAX_VALUE);
            ((Button) node).setStyle("-fx-background-color: #444; -fx-text-fill: white;");
        }

        primaryStage.setTitle("Android Emulator Launcher");
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }

    private void startEmulator() {
        try {
            File dir = new File("C:\\Users\\Ahmed.ElKady\\Desktop\\qemu"); // <-- Change this path
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "start_android.bat");
            pb.directory(dir);
            pb.start();
            showAlert("Emulator started. Wait until Android boots.\n\nThen press 'Connect ADB'.");
            btnConnectADB.setDisable(false);
        } catch (IOException ex) {
            showAlert("Failed to start emulator: " + ex.getMessage());
        }
    }

    private void connectADB() {
        try {
            ProcessBuilder pb = new ProcessBuilder("C:\\Users\\Ahmed.ElKady\\Desktop\\platform-tools-latest-windows\\platform-tools\\adb", "connect", "127.0.0.1:5555");
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }
            showAlert("ADB Response:\n" + response);
            if (response.toString().contains("connected")) {
                btnInstallAPK.setDisable(false);
            }
        } catch (IOException ex) {
            showAlert("Failed to connect ADB: " + ex.getMessage());
        }
    }

    private void installAPK(Stage stage) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Select APK File");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("APK Files", "*.apk"));
        File apkFile = fc.showOpenDialog(stage);

        if (apkFile != null) {
            try {
                ProcessBuilder pb = new ProcessBuilder("C:\\Users\\Ahmed.ElKady\\Desktop\\platform-tools-latest-windows\\platform-tools\\adb", "install", apkFile.getAbsolutePath());
                pb.redirectErrorStream(true);
                Process p = pb.start();

                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                StringBuilder output = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }

                showAlert("Install Result:\n" + output);
            } catch (IOException ex) {
                showAlert("Failed to install APK: " + ex.getMessage());
            }
        }
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
