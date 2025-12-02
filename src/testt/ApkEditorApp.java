import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApkEditorApp extends Application {

    private File apkFile;
    private File iconFile;
    private String decompiledPath;

    @Override
    public void start(Stage primaryStage) {
        // Main layout
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        // TabPane for different editing sections
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Tabs
        Tab generalTab = createGeneralTab();
        Tab adTab = createAdTab();
        Tab advancedTab = createAdvancedTab();
        tabPane.getTabs().addAll(generalTab, adTab, advancedTab);

        // Top bar with file chooser
        HBox topBar = new HBox(10);
        topBar.setAlignment(Pos.CENTER_LEFT);
        Button selectApkButton = new Button("Select APK");
        Label apkLabel = new Label("No APK selected");
        selectApkButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("APK Files", "*.apk"));
            apkFile = fileChooser.showOpenDialog(primaryStage);
            if (apkFile != null) {
                apkLabel.setText(apkFile.getName());
                //decompiledPath = "decompiled_" + UUID.randomUUID().toString();
                decompiledPath = "C:\\Users\\Ahmed.ElKady\\Desktop\\aaa";
            }
        });
        topBar.getChildren().addAll(selectApkButton, apkLabel);

        // Set layout
        root.setTop(topBar);
        root.setCenter(tabPane);

        // Scene with CSS
        Scene scene = new Scene(root, 800, 600);
        //scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("APK Editor Pro");
        //primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/icon.png")));
        primaryStage.show();
    }

    private Tab createGeneralTab() {
        Tab tab = new Tab("General");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER_LEFT);

        // App Name
        TextField nameField = new TextField();
        Button applyNameButton = new Button("Apply Name");
        applyNameButton.setOnAction(e -> updateAppName(nameField.getText()));

        // Package Name
        TextField packageField = new TextField();
        Button applyPackageButton = new Button("Apply Package");
        applyPackageButton.setOnAction(e -> updatePackageName(packageField.getText()));

        // Version
        TextField versionField = new TextField();
        Button applyVersionButton = new Button("Apply Version");
        applyVersionButton.setOnAction(e -> {
            try {
                updateVersion(versionField.getText());
            } catch (IOException ex) {
                Logger.getLogger(ApkEditorApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // Icon
        Button selectIconButton = new Button("Select Icon");
        Label iconLabel = new Label("No icon selected");
        selectIconButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.ico"));
            iconFile = fileChooser.showOpenDialog(null);
            if (iconFile != null) {
                iconLabel.setText(iconFile.getName());
            }
        });
        Button applyIconButton = new Button("Apply Icon");
        applyIconButton.setOnAction(e -> updateIcon());

        // Layout
        layout.getChildren().addAll(
                new Label("App Name:"), nameField, applyNameButton,
                new Label("Package Name:"), packageField, applyPackageButton,
                new Label("Version:"), versionField, applyVersionButton,
                new Label("Icon:"), selectIconButton, iconLabel, applyIconButton
        );
        tab.setContent(layout);
        return tab;
    }

    private Tab createAdTab() {
        Tab tab = new Tab("Ads");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER_LEFT);

        // AdMob Integration
        TextField adUnitIdField = new TextField();
        TextField adAppIdField = new TextField();
        Button applyAdButton = new Button("Add AdMob Banner Automatically");
        applyAdButton.setOnAction(e -> addAdMobBanner(adUnitIdField.getText(), adAppIdField.getText()));

        layout.getChildren().addAll(
                new Label("AdMob Ad Unit ID:"), adUnitIdField,
                new Label("AdMob App ID:"), adAppIdField,
                applyAdButton,
                new Label("Note: Ensure AdMob IDs are valid. Some manual setup may be required for complex APKs.")
        );
        tab.setContent(layout);
        return tab;
    }

    private Tab createAdvancedTab() {
        Tab tab = new Tab("Advanced");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER_LEFT);

        Button decompileButton = new Button("Decompile APK");
        decompileButton.setOnAction(e -> decompileApk());

        Button recompileButton = new Button("Recompile & Sign APK");
        recompileButton.setOnAction(e -> recompileApk());

        Button optimizeButton = new Button("Optimize APK");
        optimizeButton.setOnAction(e -> optimizeApk());

        Button uploadButton = new Button("Upload to Cloud");
        uploadButton.setOnAction(e -> uploadToCloud());

        layout.getChildren().addAll(decompileButton, recompileButton, optimizeButton, uploadButton);
        tab.setContent(layout);
        return tab;
    }

    private void decompileApk() {
        if (apkFile == null) {
            showAlert("Error", "Please select an APK file.");
            return;
        }
        try {
            ProcessBuilder pb = new ProcessBuilder( "C:\\Users\\Ahmed.ElKady\\Desktop\\apktool.bat", "d", "-f", apkFile.getAbsolutePath(), "-o", decompiledPath);
            pb.redirectErrorStream(true);
            Process process = pb.start();
            process.waitFor();
            showAlert("Success", "APK decompiled to " + decompiledPath);
        } catch (Exception e) {
            showAlert("Error", "Failed to decompile APK: " + e.getMessage());
        }
    }

    private void updateAppName(String newName) {
        if (decompiledPath == null || newName.isEmpty()) {
            showAlert("Error", "Decompile APK and enter a valid name.");
            return;
        }
        try {
            Path manifestPath = Paths.get(decompiledPath, "AndroidManifest.xml");
            String manifest = new String(Files.readAllBytes(manifestPath));
            manifest = manifest.replaceAll("android:label=\"[^\"]*\"", "android:label=\"" + newName + "\"");
            Files.write(manifestPath, manifest.getBytes());
            showAlert("Success", "App name updated to " + newName);
        } catch (IOException e) {
            showAlert("Error", "Failed to update app name: " + e.getMessage());
        }
    }

    private void updatePackageName(String newPackage) {
        if (decompiledPath == null || newPackage.isEmpty()) {
            showAlert("Error", "Decompile APK and enter a valid package name.");
            return;
        }
        try {
            Path manifestPath = Paths.get(decompiledPath, "AndroidManifest.xml");
            String manifest = new String(Files.readAllBytes(manifestPath));
            manifest = manifest.replaceAll("package=\"[^\"]*\"", "package=\"" + newPackage + "\"");
            Files.write(manifestPath, manifest.getBytes());
            showAlert("Success", "Package name updated to " + newPackage);
        } catch (IOException e) {
            showAlert("Error", "Failed to update package name: " + e.getMessage());
        }
    }

    private void updateVersion(String newVersion) throws IOException {
        if (decompiledPath == null || newVersion.isEmpty()) {
            showAlert("Error", "Decompile APK and enter a valid version.");
            return;
        }
        try {
            Path manifestPath = Paths.get(decompiledPath, "AndroidManifest.xml");
            String manifest = new String(Files.readAllBytes(manifestPath));
            manifest = manifest.replaceAll("android:versionName=\"[^\"]*\"", "android:versionName=\"" + newVersion + "\"");
            Files.write(manifestPath, manifest.getBytes());
            showAlert("Success", "Version updated to " + newVersion);
        } catch (IOException e) {
            showAlert("Error", "Failed to update version: " + e.getMessage());
        }
    }

    private void updateIcon() {
        if (decompiledPath == null || iconFile == null) {
            showAlert("Error", "Decompile APK and select an icon.");
            return;
        }
        try {
            Path iconDest = Paths.get(decompiledPath, "res", "mipmap-hdpi", "ic_launcher.png");
            Files.copy(iconFile.toPath(), iconDest, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            showAlert("Success", "Icon updated.");
        } catch (IOException e) {
            showAlert("Error", "Failed to update icon: " + e.getMessage());
        }
    }

    private void addAdMobBanner(String adUnitId, String adAppId) {
        if (decompiledPath == null || adUnitId.isEmpty() || adAppId.isEmpty()) {
            showAlert("Error", "Decompile APK and enter valid Ad Unit ID and App ID.");
            return;
        }
        try {
            // Step 1: Update build.gradle to include AdMob SDK
            Path gradlePath = Paths.get(decompiledPath, "app", "build.gradle");
            if (Files.exists(gradlePath)) {
                String gradleContent = new String(Files.readAllBytes(gradlePath));
                if (!gradleContent.contains("com.google.android.gms:play-services-ads")) {
                    gradleContent = gradleContent.replace(
                            "dependencies {",
                            "dependencies {\n    implementation 'com.google.android.gms:play-services-ads:23.0.0'"
                    );
                    Files.write(gradlePath, gradleContent.getBytes());
                }
            } else {
                showAlert("Warning", "build.gradle not found. You may need to add AdMob SDK manually.");
            }

            // Step 2: Update AndroidManifest.xml with permissions and metadata
            Path manifestPath = Paths.get(decompiledPath, "AndroidManifest.xml");
            String manifestContent = new String(Files.readAllBytes(manifestPath));
            if (!manifestContent.contains("android.permission.INTERNET")) {
                manifestContent = manifestContent.replace(
                        "<manifest",
                        "<manifest\n    <uses-permission android:name=\"android.permission.INTERNET\"/>"
                );
            }
            if (!manifestContent.contains("com.google.android.gms.ads.APPLICATION_ID")) {
                manifestContent = manifestContent.replace(
                        "<application",
                        "<application\n        <meta-data android:name=\"com.google.android.gms.ads.APPLICATION_ID\" android:value=\"" + adAppId + "\"/>"
                );
            }
            Files.write(manifestPath, manifestContent.getBytes());

            // Step 3: Add banner ad to main activity layout
            Path layoutPath = Paths.get(decompiledPath, "res", "layout", "activity_main.xml");
            String layoutContent;
            if (Files.exists(layoutPath)) {
                layoutContent = new String(Files.readAllBytes(layoutPath));
            } else {
                // Create a basic layout if none exists
                layoutContent = "<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\" android:layout_width=\"match_parent\" android:layout_height=\"match_parent\" android:orientation=\"vertical\"></LinearLayout>";
                Files.createDirectories(layoutPath.getParent());
            }
            String adView = "<com.google.android.gms.ads.AdView android:id=\"@+id/adView\" android:layout_width=\"wrap_content\" android:layout_height=\"wrap_content\" ads:adSize=\"BANNER\" ads:adUnitId=\"" + adUnitId + "\" xmlns:ads=\"http://schemas.android.com/apk/res-auto\"/>";
            if (!layoutContent.contains("com.google.android.gms.ads.AdView")) {
                layoutContent = layoutContent.replace("</LinearLayout>", adView + "</LinearLayout>");
                Files.write(layoutPath, layoutContent.getBytes());
            }

            // Step 4: Attempt to inject ad initialization code into main activity
            String mainActivityPath = findMainActivity();
            if (mainActivityPath != null) {
                // Check if it's a Java file (unlikely in decompiled APK) or Smali
                if (mainActivityPath.endsWith(".java")) {
                    Path javaPath = Paths.get(mainActivityPath);
                    String javaContent = new String(Files.readAllBytes(javaPath));
                    if (!javaContent.contains("AdView")) {
                        javaContent = javaContent.replace(
                                "setContentView(R.layout.activity_main);",
                                "setContentView(R.layout.activity_main);\n" +
                                "        com.google.android.gms.ads.AdView adView = findViewById(R.id.adView);\n" +
                                "        com.google.android.gms.ads.AdRequest adRequest = new com.google.android.gms.ads.AdRequest.Builder().build();\n" +
                                "        adView.loadAd(adRequest);"
                        );
                        javaContent = javaContent.replace(
                                "public class",
                                "import com.google.android.gms.ads.AdRequest;\nimport com.google.android.gms.ads.AdView;\npublic class"
                        );
                        Files.write(javaPath, javaContent.getBytes());
                    }
                } else {
                    showAlert("Warning", "Main activity is in Smali format. Manual initialization of AdView in Smali code is required.");
                }
            } else {
                showAlert("Warning", "Could not identify main activity. Manually initialize AdView in the appropriate activity.");
            }

            showAlert("Success", "AdMob banner added. Verify build.gradle, manifest, and activity code manually if errors occur.");
        } catch (IOException e) {
            showAlert("Error", "Failed to add AdMob banner: " + e.getMessage());
        }
    }

    private String findMainActivity() {
        try {
            Path manifestPath = Paths.get(decompiledPath, "AndroidManifest.xml");
            String manifestContent = new String(Files.readAllBytes(manifestPath));
            Pattern pattern = Pattern.compile("<activity[^>]+android:name=\"([^\"]+)\"[^>]*>[\\s\\S]*?<intent-filter>[\\s\\S]*?<action android:name=\"android.intent.action.MAIN\"/>");
            Matcher matcher = pattern.matcher(manifestContent);
            if (matcher.find()) {
                String activityName = matcher.group(1);
                // Convert activity name to potential file path (simplified)
                String packageName = manifestContent.split("package=\"")[1].split("\"")[0];
                String activityPath = activityName.replace(packageName + ".", "").replace(".", "/");
                // Check for Java or Smali
                Path javaPath = Paths.get(decompiledPath, "app", "src", "main", "java", activityPath + ".java");
                if (Files.exists(javaPath)) {
                    return javaPath.toString();
                }
                // Smali path
                Path smaliPath = Paths.get(decompiledPath, "smali", activityPath + ".smali");
                if (Files.exists(smaliPath)) {
                    return smaliPath.toString();
                }
            }
        } catch (IOException e) {
            showAlert("Error", "Failed to find main activity: " + e.getMessage());
        }
        return null;
    }

    private void recompileApk() {
        if (decompiledPath == null) {
            showAlert("Error", "Decompile APK first.");
            return;
        }
        try {
            ProcessBuilder pb = new ProcessBuilder( "C:\\Users\\Ahmed.ElKady\\Desktop\\apktool.bat", "b", "-f", decompiledPath);
            pb.redirectErrorStream(true);
            Process process = pb.start();
            process.waitFor();

            // Sign APK
            ProcessBuilder signPb = new ProcessBuilder("C:\\Users\\Ahmed.ElKady\\Desktop\\Build_Apk.bat", decompiledPath+"\\dist\\"+apkFile.getName());
            signPb.redirectErrorStream(true);
            signPb.start().waitFor();

            showAlert("Success", "APK recompiled and signed as modified.apk");
        } catch (Exception e) {
            showAlert("Error", "Failed to recompile APK: " + e.getMessage());
        }
    }

    private void optimizeApk() {
        if (!new File("modified.apk").exists()) {
            showAlert("Error", "Recompile APK first.");
            return;
        }
        try {
            ProcessBuilder pb = new ProcessBuilder("C:\\Users\\Ahmed.ElKady\\Desktop\\zipalign.exe", "-v", "4", decompiledPath+"\\dist\\"+apkFile.getName(), decompiledPath+"\\ddd.apk");
            pb.redirectErrorStream(true);
            Process process = pb.start();
            process.waitFor();
            showAlert("Success", "APK optimized as optimized.apk");
        } catch (Exception e) {
            showAlert("Error", "Failed to optimize APK: " + e.getMessage());
        }
    }

    private void uploadToCloud() {
        showAlert("Info", "Cloud upload not implemented. Use external tools like Dropbox CLI.");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}