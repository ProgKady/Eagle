package eagle;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.zip.*;

public class Website2ApkBuilderFX extends Application {

    private static final String BASE_DATA_DIR = System.getProperty("user.home")
            + File.separator + "AppData" + File.separator + "Roaming"
            + File.separator + "Goyal Softech" + File.separator + "Website 2 APK Builder Pro";


    private static final String DEF_7ZA = "7za.exe";
    private static final String DEF_ZIPALIGN = "zipalign.exe";
    private static final String DEF_SIGNAPK_JAR = "signapk.jar";
    private static final String DEF_APKSIGNER_JAR = "apksigner.jar";
    private static final String DEF_APKTOOL_JAR = "apktool.jar"; // ?? ???? ?
    private static final String DEF_TESTPK8 = "testkey.pk8";
    private static final String DEF_TESTCERT = "testkey.x509.pem";

    // UI controls
    private TextField tfSiteFolder, tfOutputFolder, tfPackageName, tfAppTitle, tfAdMob;
    private ComboBox<String> cbTemplate;
    private CheckBox cbAdMob, cbPush, cbZoom, cbFullscreen;
    private TextArea logArea;
    private Button btnBuild;
    private File baseDir;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        baseDir = new File(BASE_DATA_DIR);

        primaryStage.setTitle("Website2APK Builder FX - (uses your Website 2 APK Builder Pro data)");

        // Top controls
        Label lblTemplate = new Label("Template:");
        cbTemplate = new ComboBox<>();
        populateTemplates();

        Button btnRefreshTemplates = new Button("Refresh");
        btnRefreshTemplates.setOnAction(e -> populateTemplates());

        HBox topBox = new HBox(8, lblTemplate, cbTemplate, btnRefreshTemplates);
        topBox.setPadding(new Insets(8));

        // Site folder chooser
        tfSiteFolder = new TextField();
        tfSiteFolder.setPrefWidth(480);
        Button btnChooseSite = new Button("Choose Site Folder");
        btnChooseSite.setOnAction(e -> {
            DirectoryChooser dc = new DirectoryChooser();
            dc.setTitle("Select local site folder (assets/www contents)");
            File f = dc.showDialog(primaryStage);
            if (f != null) tfSiteFolder.setText(f.getAbsolutePath());
        });

        // Output
        tfOutputFolder = new TextField(System.getProperty("user.home") + File.separator + "Desktop");
        tfOutputFolder.setPrefWidth(480);
        Button btnChooseOutput = new Button("Output Folder");
        btnChooseOutput.setOnAction(e -> {
            DirectoryChooser dc = new DirectoryChooser();
            dc.setTitle("Choose output folder");
            File f = dc.showDialog(primaryStage);
            if (f != null) tfOutputFolder.setText(f.getAbsolutePath());
        });

        // Basic app info
        tfPackageName = new TextField("com.example.website2apk");
        tfAppTitle = new TextField("My Web App");
        tfAdMob = new TextField("ca-app-pub-XXXX~YYYY");

        cbAdMob = new CheckBox("Enable AdMob");
        cbPush = new CheckBox("Enable Push (FCM)");
        cbZoom = new CheckBox("Support Zoom");
        cbFullscreen = new CheckBox("Fullscreen");

        GridPane grid = new GridPane();
        grid.setHgap(6);
        grid.setVgap(6);
        grid.setPadding(new Insets(8));
        grid.add(new Label("Site folder:"), 0, 0);
        grid.add(tfSiteFolder, 1, 0);
        grid.add(btnChooseSite, 2, 0);

        grid.add(new Label("Output folder:"), 0, 1);
        grid.add(tfOutputFolder, 1, 1);
        grid.add(btnChooseOutput, 2, 1);

        grid.add(new Label("Package name:"), 0, 2);
        grid.add(tfPackageName, 1, 2);
        grid.add(new Label("App title:"), 0, 3);
        grid.add(tfAppTitle, 1, 3);
        grid.add(new Label("AdMob ID:"), 0, 4);
        grid.add(tfAdMob, 1, 4);

        HBox flags = new HBox(8, cbAdMob, cbPush, cbZoom, cbFullscreen);
        grid.add(flags, 1, 5);

        // Tools directory display & quick-check
        Label lblTools = new Label("Using data folder: " + baseDir.getAbsolutePath());
        Button btnOpenData = new Button("Open Data Folder");
        btnOpenData.setOnAction(e -> {
            try {
                java.awt.Desktop.getDesktop().open(baseDir);
            } catch (Exception ex) {
                appendLog("Cannot open data folder: " + ex.getMessage());
            }
        });

        HBox toolsBox = new HBox(8, lblTools, btnOpenData);
        toolsBox.setPadding(new Insets(8));

        // Log
        logArea = new TextArea();
        logArea.setEditable(false);
        logArea.setPrefRowCount(12);

        // Build button
        btnBuild = new Button("Build Android APK");
        btnBuild.setOnAction(e -> startBuild());

        VBox root = new VBox(8, topBox, grid, toolsBox, new Label("Logs:"), logArea, btnBuild);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root, 820, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        appendLog("Ready. Base data folder: " + baseDir.getAbsolutePath());
    }

    // populate templates from baseDir/templates if exists
    private void populateTemplates() {
        cbTemplate.getItems().clear();
        File templates = new File(baseDir, "templates");
        if (!templates.exists() || !templates.isDirectory()) {
            appendLog("Templates folder not found: " + templates.getAbsolutePath());
            return;
        }
        File[] list = templates.listFiles();
        if (list == null) list = new File[0];
        for (File f : list) {
            if (f.isDirectory() || f.getName().endsWith(".apk") || f.getName().endsWith(".zip")) {
                cbTemplate.getItems().add(f.getName());
            }
        }
        if (!cbTemplate.getItems().isEmpty()) cbTemplate.getSelectionModel().select(0);
        appendLog("Loaded templates: " + cbTemplate.getItems().size());
    }

    private void startBuild() {
        String siteFolder = tfSiteFolder.getText().trim();
        String outFolder = tfOutputFolder.getText().trim();
        String template = cbTemplate.getValue();
        String packageName = tfPackageName.getText().trim();
        String appTitle = tfAppTitle.getText().trim();
        String admobId = tfAdMob.getText().trim();

        if (siteFolder.isEmpty() || template == null || outFolder.isEmpty()) {
            appendLog("Please choose site folder, template and output folder.");
            return;
        }

        File siteDir = new File(siteFolder);
        if (!siteDir.exists() || !siteDir.isDirectory()) {
            appendLog("Site folder invalid.");
            return;
        }

        File outputDir = new File(outFolder);
        if (!outputDir.exists()) {
            if (!outputDir.mkdirs()) {
                appendLog("Cannot create output folder.");
                return;
            }
        }

        btnBuild.setDisable(true);
        appendLog("Starting build...");

        Task<Void> buildTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    File tempWork = Files.createTempDirectory("w2apk_build_").toFile();
                    appendLog("Working dir: " + tempWork.getAbsolutePath());

                    // 1) copy template to tempWork
                    File templateFile = new File(baseDir, "templates" + File.separator + template);
                    if (!templateFile.exists()) {
                        appendLog("Template not found: " + templateFile.getAbsolutePath());
                        throw new IOException("Template missing");
                    }
                    appendLog("Copying template...");
                    if (templateFile.isDirectory()) {
                        copyDirectory(templateFile.toPath(), tempWork.toPath());
                    } else {
                        // if it's an apk or zip, extract
                        if (templateFile.getName().endsWith(".apk") || templateFile.getName().endsWith(".zip")) {
                            // use 7za if available
                            File seven = new File(baseDir, DEF_7ZA);
                            if (seven.exists()) {
                                runCommand(new String[]{seven.getAbsolutePath(), "x", templateFile.getAbsolutePath(), "-o" + tempWork.getAbsolutePath()});
                            } else {
                                // fallback to unzip with java
                                unzipToDir(templateFile, tempWork);
                            }
                        } else {
                            appendLog("Unsupported template file type.");
                            throw new IOException("Template unsupported");
                        }
                    }

                    // 2) replace assets/www
                    File assetsWww = new File(tempWork, "assets" + File.separator + "www");
                    if (assetsWww.exists()) {
                        deleteDirectory(assetsWww.toPath());
                    }
                    appendLog("Copying site files to assets/www ...");
                    File destAssets = new File(tempWork, "assets");
                    destAssets.mkdirs();
                    copyDirectory(siteDir.toPath(), assetsWww.toPath());

                    // 3) modify config or manifest (simple text replacements)
                    performTextReplacements(tempWork, packageName, appTitle, admobId);

                    // 4) rebuild package: if apktool.jar exists in baseDir or tempWork, use it to build
                    File apktoolJar = new File(baseDir, DEF_APKTOOL_JAR);
                    File unsignedApk = new File(tempWork, "unsigned.apk");
                    if (apktoolJar.exists()) {
                        appendLog("Found apktool.jar � rebuilding with apktool...");
                        // many templates are smali folders produced by apktool; to rebuild use:
                        // java -jar apktool.jar b <project_dir> -o unsigned.apk
                        runCommand(new String[]{"java", "-jar", apktoolJar.getAbsolutePath(), "b", tempWork.getAbsolutePath(), "-o", unsignedApk.getAbsolutePath()});
                    } else {
                        // fallback: zip the tempWork contents to unsigned apk
                        appendLog("apktool.jar not found � zipping contents to unsigned APK (may fail if resources need rebuilding)...");
                        zipDirectory(tempWork.toPath(), unsignedApk.toPath());
                    }

                    // 5) zipalign
                    File zipalignExe = new File(baseDir, DEF_ZIPALIGN);
                    File alignedApk = new File(tempWork, "aligned.apk");
                    if (zipalignExe.exists()) {
                        appendLog("Running zipalign...");
                        runCommand(new String[]{zipalignExe.getAbsolutePath(), "-v", "4", unsignedApk.getAbsolutePath(), alignedApk.getAbsolutePath()});
                    } else {
                        appendLog("zipalign.exe not found. Skipping (APK might be unusable on Play).");
                        alignedApk = unsignedApk;
                    }

                    // 6) signing
                    File signJar = new File(baseDir, DEF_SIGNAPK_JAR);
                    File keyPk8 = new File(baseDir, DEF_TESTPK8);
                    File keyCert = new File(baseDir, DEF_TESTCERT);
                    File finalApk = new File(outputDir, appTitle.replaceAll("\\s+","_") + "-" + System.currentTimeMillis() + ".apk");

                    if (signJar.exists() && keyPk8.exists() && keyCert.exists()) {
                        appendLog("Signing with signapk.jar ...");
                        // command: java -jar signapk.jar cert.pem key.pk8 in.apk out.apk
                        runCommand(new String[]{"java", "-jar", signJar.getAbsolutePath(),
                                keyCert.getAbsolutePath(), keyPk8.getAbsolutePath(),
                                alignedApk.getAbsolutePath(), finalApk.getAbsolutePath()});
                    } else {
                        // try apksigner (jar) if present
                        File apksignerJar = new File(baseDir, DEF_APKSIGNER_JAR);
                        if (apksignerJar.exists()) {
                            appendLog("Signing with apksigner.jar ... (note: apksigner.jar may require specific args)");
                            // attempt: java -jar apksigner.jar sign --ks <keystore> --out final aligned.apk
                            // here we don't have a keystore; fallback: copy
                            appendLog("apksigner present but keystore not configured. Copying aligned apk as final (unsigned).");
                            Files.copy(alignedApk.toPath(), finalApk.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        } else {
                            appendLog("No signing tool found. Copying aligned apk as final (unsigned).");
                            Files.copy(alignedApk.toPath(), finalApk.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        }
                    }

                    appendLog("Build finished. Final APK: " + finalApk.getAbsolutePath());
                    // cleanup temp
                    // deleteDirectory(tempWork.toPath()); // comment out if debugging
                } catch (Throwable ex) {
                    appendLog("Build error: " + ex.getMessage());
                    ex.printStackTrace();
                } finally {
                    Platform.runLater(() -> btnBuild.setDisable(false));
                }
                return null;
            }
        };

        new Thread(buildTask).start();
    }

    // perform simple replacements in common files (AndroidManifest.xml, assets/config.json, etc.)
    private void performTextReplacements(File projectDir, String packageName, String appTitle, String admobId) {
        appendLog("Performing text replacements...");
        // scan for manifest and config files
        List<File> candidates = new ArrayList<>();
        findFilesRecursively(projectDir, candidates, f -> f.getName().toLowerCase().contains("manifest") || f.getName().toLowerCase().endsWith(".json") || f.getName().toLowerCase().endsWith(".xml"));
        for (File f : candidates) {
            try {
                String content = new String(Files.readAllBytes(f.toPath()), "UTF-8");
                String newC = content.replace("{{PACKAGE_NAME}}", packageName)
                        .replace("{{APP_TITLE}}", appTitle)
                        .replace("{{ADMOB_ID}}", admobId)
                        .replace("{{SUPPORT_ZOOM}}", cbZoom.isSelected() ? "true" : "false")
                        .replace("{{FULLSCREEN}}", cbFullscreen.isSelected() ? "true" : "false")
                        .replace("{{PUSH_ENABLED}}", cbPush.isSelected() ? "true" : "false");
                if (!content.equals(newC)) {
                    Files.write(f.toPath(), newC.getBytes("UTF-8"));
                    appendLog("Patched file: " + f.getAbsolutePath());
                }
            } catch (Exception ex) {
                appendLog("Failed replace in " + f.getAbsolutePath() + " : " + ex.getMessage());
            }
        }
    }

    // helper: find files matching predicate
    private void findFilesRecursively(File dir, List<File> out, java.util.function.Predicate<File> pred) {
        if (dir == null || !dir.exists()) return;
        File[] list = dir.listFiles();
        if (list == null) return;
        for (File f : list) {
            if (f.isDirectory()) findFilesRecursively(f, out, pred);
            else {
                if (pred.test(f)) out.add(f);
            }
        }
    }

    // run external command and stream stdout/stderr to log
    private void runCommand(String[] cmd) throws IOException, InterruptedException {
        appendLog("Running: " + Arrays.toString(cmd));
        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.redirectErrorStream(true);
        Process p = pb.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while ((line = r.readLine()) != null) {
            appendLog(line);
        }
        int code = p.waitFor();
        appendLog("Exit code: " + code);
        if (code != 0) {
            throw new IOException("Command failed: " + Arrays.toString(cmd) + " (code " + code + ")");
        }
    }

    // append log on FX thread
    private void appendLog(String s) {
        Platform.runLater(() -> {
            logArea.appendText("[" + new Date() + "] " + s + "\n");
        });
    }

    // copy folder recursively
    private void copyDirectory(Path source, Path target) throws IOException {
        if (!Files.exists(source)) throw new IOException("Source not found: " + source);
        Files.walk(source).forEach(src -> {
            try {
                Path rel = source.relativize(src);
                Path dest = target.resolve(rel);
                if (Files.isDirectory(src)) {
                    if (!Files.exists(dest)) Files.createDirectories(dest);
                } else {
                    Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        });
    }

    // delete dir recursively
    private void deleteDirectory(Path dir) throws IOException {
        if (!Files.exists(dir)) return;
        Files.walk(dir)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
    }

    // unzip helper (fallback)
    private void unzipToDir(File zip, File dest) throws IOException {
        byte[] buffer = new byte[4096];
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zip))) {
            ZipEntry ze;
            while ((ze = zis.getNextEntry()) != null) {
                File f = new File(dest, ze.getName());
                if (ze.isDirectory()) {
                    f.mkdirs();
                } else {
                    f.getParentFile().mkdirs();
                    try (FileOutputStream fos = new FileOutputStream(f)) {
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }
            }
        }
    }

    // zip a directory (fallback)
    private void zipDirectory(Path sourceDirPath, Path zipFilePath) throws IOException {
        try (ZipOutputStream zs = new ZipOutputStream(Files.newOutputStream(zipFilePath))) {
            Files.walk(sourceDirPath)
                    .filter(path -> !Files.isDirectory(path))
                    .forEach(path -> {
                        ZipEntry zipEntry = new ZipEntry(sourceDirPath.relativize(path).toString().replace("\\","/"));
                        try {
                            zs.putNextEntry(zipEntry);
                            Files.copy(path, zs);
                            zs.closeEntry();
                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                    });
        }
    }
}
