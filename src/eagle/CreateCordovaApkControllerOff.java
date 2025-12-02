package eagle;

import com.gluonhq.charm.glisten.animation.PulseTransition;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;
import eagle.CreateCordovaApkController;
import eagle.CreateHtmlApkController;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class CreateCordovaApkControllerOff implements Initializable {
  @FXML
  private ResourceBundle resources;
  
  @FXML
  private URL location;
  
  @FXML
  private JFXTextField zipfile;
  
  @FXML
  private Label pathlabel;
  
  @FXML
  private JFXTextField apkname;
  
  @FXML
  private JFXButton browse2;
  
  @FXML
  private JFXTextField packagename;
  
  @FXML
  private JFXButton browse1;
  
  @FXML
  private JFXTextField htmlfile;
  
  @FXML
  private ImageView imgview;
  
  @FXML
  private JFXButton create;
  
  @FXML
  void imgviewact(MouseEvent event) {
    FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", new String[] { "*.png" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String dirpathe = f.getAbsolutePath().toString();
    this.imgview.setImage(new Image((new File(dirpathe)).toURI().toString()));
    this.pathlabel.setText(dirpathe);
    this.browse1.setDisable(false);
  }
  
  @FXML
  void createact(ActionEvent event) throws InterruptedException {
    String apknam = this.apkname.getText();
    String apkpkg = this.packagename.getText();
    String apkico = this.pathlabel.getText();
    String apksource = this.htmlfile.getText();
    String apkresource = this.zipfile.getText();
    
    
    
    
    
       
final Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Creating APK, Please wait ...");
String contentText = "Congratulations\n" +
"Task maybe takes 1 minute, you will find \"" + apknam + ".apk\"on your desktop after Finishing.\n" +
"Support Eagle and Kadysoft on Facebook.\n\nMade with L❤VE by Kadysoft.";
Label statusLabel = new Label(contentText);
JFXProgressBar progressBar = new JFXProgressBar(0);
progressBar.setPrefWidth(300);
VBox content = new VBox(10, statusLabel, progressBar);
alert.getDialogPane().setContent(content);
alert.setGraphic(imgview);
alert.setResizable(false);
alert.getDialogPane().getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
Platform.runLater(alert::show);

Task<Void> task = new Task<Void>() {
    @Override
    protected Void call() throws Exception {
        
        
        Random random = new Random();

        // Progress simulator
        for (int i = 0; i < 20; i++) {
            Thread.sleep(200 + random.nextInt(300)); // simulate work
            double simulatedProgress = Math.min(0.95, progressBar.getProgress() + 0.025 + random.nextDouble() * 0.05);
            double finalProgress = simulatedProgress;
            Platform.runLater(() -> progressBar.setProgress(finalProgress));
        }

    
    
    
    
    
    
    
    File projectfolder = new File(System.getProperty("user.home") + "\\appdata\\roaming\\HtmlProject");
    projectfolder.mkdir();
    try {
      Process process = Runtime.getRuntime().exec("cmd /c copy " + System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Cordova.kady " + projectfolder + "\\Cordova.apk");
    } catch (IOException iOException) {}
    File batfile1 = new File(projectfolder + "\\kady1.bat");
    try {
      batfile1.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter pw = new PrintWriter(new FileWriter(batfile1));
      pw.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\apktool.bat d -f " + projectfolder + "\\Cordova.apk -o " + projectfolder + "\\Cordova");
      pw.close();
    } catch (IOException iOException) {}
    File framwork = new File(projectfolder + "\\kady2.bat");
    try {
      framwork.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter pwq = new PrintWriter(new FileWriter(framwork));
      pwq.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\apktool.bat if " + projectfolder + "\\Cordova.apk");
      pwq.close();
    } catch (IOException iOException) {}
    File htmlbat2 = new File(projectfolder + "\\kady3.bat");
    try {
      htmlbat2.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter lcv = new PrintWriter(new FileWriter(htmlbat2));
      lcv.println("cd " + projectfolder + "\\Cordova\\assets\\www");
      lcv.println("copy " + apksource + " " + projectfolder + "\\Cordova\\assets\\www\\index.html");
      lcv.close();
    } catch (IOException iOException) {}
//    File htmlbat1 = new File(projectfolder + "\\kady4.bat");
//    try {
//      htmlbat1.createNewFile();
//    } catch (IOException iOException) {}
//    try {
//      PrintWriter lcv = new PrintWriter(new FileWriter(htmlbat1));
//      lcv.println("cd " + projectfolder + "\\Cordova\\assets\\www");
//      lcv.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\7z.exe x -y " + apkresource);
//      lcv.close();
//    } catch (IOException iOException) {}
    File htmlbat11 = new File(projectfolder + "\\kady9.bat");
    try {
      htmlbat11.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat11));
      lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-hdpi");
      lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-hdpi\\ic_launcher.png");
      lcvv.close();
    } catch (IOException iOException) {}
    File htmlbat1110 = new File(projectfolder + "\\kady910.bat");
    try {
      htmlbat1110.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat1110));
      lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-ldpi");
      lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-ldpi\\ic_launcher.png");
      lcvv.close();
    } catch (IOException iOException) {}
    File htmlbat11100 = new File(projectfolder + "\\kady9100.bat");
    try {
      htmlbat11100.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat11100));
      lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-mdpi");
      lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-mdpi\\ic_launcher.png");
      lcvv.close();
    } catch (IOException iOException) {}
    File htmlbat111000 = new File(projectfolder + "\\kady91000.bat");
    try {
      htmlbat111000.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat111000));
      lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xxhdpi");
      lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xxhdpi\\ic_launcher.png");
      lcvv.close();
    } catch (IOException iOException) {}
    File htmlbat1110000 = new File(projectfolder + "\\kady910000.bat");
    try {
      htmlbat1110000.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat1110000));
      lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xxxhdpi");
      lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xxxhdpi\\ic_launcher.png");
      lcvv.close();
    } catch (IOException iOException) {}
    File htmlbat11100000 = new File(projectfolder + "\\kady9100000.bat");
    try {
      htmlbat11100000.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat11100000));
      lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-hdpi-v26");
      lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-hdpi-v26\\ic_launcher_foreground.png");
      lcvv.close();
    } catch (IOException iOException) {}
    File htmlbat111000000 = new File(projectfolder + "\\kady91000000.bat");
    try {
      htmlbat111000000.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat111000000));
      lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-ldpi-v26");
      lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-ldpi-v26\\ic_launcher_foreground.png");
      lcvv.close();
    } catch (IOException iOException) {}
    File htmlbat1110000000 = new File(projectfolder + "\\kady910000000.bat");
    try {
      htmlbat1110000000.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat1110000000));
      lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-mhdpi-v26");
      lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-mhdpi-v26\\ic_launcher_foreground.png");
      lcvv.close();
    } catch (IOException iOException) {}
    File htmlbat11100000000 = new File(projectfolder + "\\kady9100000000.bat");
    try {
      htmlbat11100000000.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat11100000000));
      lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xhdpi-v26");
      lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xhdpi-v26\\ic_launcher_foreground.png");
      lcvv.close();
    } catch (IOException iOException) {}
    File htmlbat111000000000 = new File(projectfolder + "\\kady91000000000.bat");
    try {
      htmlbat111000000000.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat111000000000));
      lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xxhdpi-v26");
      lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xxhdpi-v26\\ic_launcher_foreground.png");
      lcvv.close();
    } catch (IOException iOException) {}
    File htmlbat1110000000000 = new File(projectfolder + "\\kady910000000000.bat");
    try {
      htmlbat1110000000000.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat1110000000000));
      lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xxxhdpi-v26");
      lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xxxhdpi-v26\\ic_launcher_foreground.png");
      lcvv.close();
    } catch (IOException iOException) {}
    File htmlbat111 = new File(projectfolder + "\\kady10.bat");
    try {
      htmlbat111.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter lcvvv = new PrintWriter(new FileWriter(htmlbat111));
      lcvvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xhdpi");
      lcvvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xhdpi\\ic_launcher.png");
      lcvvv.close();
    } catch (IOException iOException) {}
    File batfile3 = new File(projectfolder + "\\kady5.bat");
    try {
      batfile3.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter pww = new PrintWriter(new FileWriter(batfile3));
      pww.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\apktool.bat b -f " + projectfolder + "\\Cordova");
      pww.close();
    } catch (IOException iOException) {}
    File batfile5 = new File(projectfolder + "\\kady6.bat");
    try {
      batfile5.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter pwwu = new PrintWriter(new FileWriter(batfile5));
      pwwu.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\zipalign.exe -v 4 " + projectfolder + "\\Cordova\\dist\\Cordova.apk " + projectfolder + "\\newApk.apk");
      pwwu.close();
    } catch (IOException iOException) {}
    File batfile4 = new File(projectfolder + "\\kady7.bat");
    try {
      batfile4.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter pwww = new PrintWriter(new FileWriter(batfile4));
      //pwww.println("cd " + System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data");
      pwww.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk.bat " + projectfolder + "\\newApk.apk");
      pwww.close();
    } catch (IOException iOException) {}
    File batfile6 = new File(projectfolder + "\\kady8.bat");
    try {
      batfile6.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter pwwww = new PrintWriter(new FileWriter(batfile6));
      pwwww.println("copy " + projectfolder + "\\newApk_Eagle_Kadysoft.apk " + System.getProperty("user.home") + "\\desktop");
      pwwww.close();
    } catch (IOException iOException) {}
    File batfile66 = new File(projectfolder + "\\strings.xml");
    try {
      batfile66.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter pwwwwn = new PrintWriter(new FileWriter(batfile66));
      pwwwwn.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n    <string name=\"activity_name\">@string/launcher_name</string>\n    <string name=\"app_name\">" + apknam + "</string>\n    <string name=\"launcher_name\">@string/app_name</string>\n</resources>");
      pwwwwn.close();
    } catch (IOException iOException) {}
    File batfile6600 = new File(projectfolder + "\\AndroidManifest.xml");
    try {
      batfile6600.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter pwwwwn00 = new PrintWriter(new FileWriter(batfile6600));
      pwwwwn00.println("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?><manifest xmlns:android=\"http://schemas.android.com/apk/res/android\" android:compileSdkVersion=\"28\" android:compileSdkVersionCodename=\"9\" android:hardwareAccelerated=\"true\" package=\"com.zib.apache.cordova.browser\" platformBuildVersionCode=\"10000\" platformBuildVersionName=\"1.0.0\">\n    <supports-screens android:anyDensity=\"true\" android:largeScreens=\"true\" android:normalScreens=\"true\" android:resizeable=\"true\" android:smallScreens=\"true\" android:xlargeScreens=\"true\"/>\n    <uses-permission android:name=\"android.permission.INTERNET\"/>\n    <application android:hardwareAccelerated=\"true\" android:icon=\"@mipmap/ic_launcher\" android:label=\"@string/app_name\" android:supportsRtl=\"true\">\n        <activity android:configChanges=\"keyboard|keyboardHidden|locale|orientation|screenLayout|screenSize|smallestScreenSize|uiMode\" android:label=\"@string/activity_name\" android:launchMode=\"singleTop\" android:name=\"com.zib.apache.cordova.browser.MainActivity\" android:theme=\"@android:style/Theme.DeviceDefault.NoActionBar\" android:windowSoftInputMode=\"adjustResize\">\n            <intent-filter android:label=\"@string/launcher_name\">\n                <action android:name=\"android.intent.action.MAIN\"/>\n                <category android:name=\"android.intent.category.LAUNCHER\"/>\n            </intent-filter>\n        </activity>\n        <meta-data android:name=\"com.android.vending.derived.apk.id\" android:value=\"1\"/>\n    </application>\n</manifest>");
      pwwwwn00.close();
    } catch (IOException iOException) {}
    File batfile666 = new File(projectfolder + "\\apktool.yml");
    try {
      batfile666.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter pwwwwnx = new PrintWriter(new FileWriter(batfile666));
      pwwwwnx.println("!!brut.androlib.meta.MetaInfo\napkFileName: Cordova.apk\ncompressionType: false\ndoNotCompress:\n- arsc\n- png\nisFrameworkApk: false\npackageInfo:\n  forcedPackageId: '127'\n  renameManifestPackage: com.eagle." + apkpkg + "\nsdkInfo:\n  minSdkVersion: '19'\n  targetSdkVersion: '28'\nsharedLibrary: false\nsparseResources: false\nunknownFiles: {}\nusesFramework:\n  ids:\n  - 1\n  tag: null\nversion: 2.3.4\nversionInfo:\n  versionCode: '10000'\n  versionName: 1.0.0");
      pwwwwnx.close();
    } catch (IOException iOException) {}
    File batfile65 = new File(projectfolder + "\\kady11.bat");
    try {
      batfile65.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter pwwwwm = new PrintWriter(new FileWriter(batfile65));
      pwwwwm.println("copy /Y " + projectfolder + "\\strings.xml " + projectfolder + "\\Cordova\\res\\values\\strings.xml");
      pwwwwm.close();
    } catch (IOException iOException) {}
    File batfile650 = new File(projectfolder + "\\kady1100.bat");
    try {
      batfile650.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter pwwwwm0 = new PrintWriter(new FileWriter(batfile650));
      pwwwwm0.println("copy /Y " + projectfolder + "\\AndroidManifest.xml " + projectfolder + "\\Cordova\\AndroidManifest.xml");
      pwwwwm0.close();
    } catch (IOException iOException) {}
    File batfile655 = new File(projectfolder + "\\kady12.bat");
    try {
      batfile655.createNewFile();
    } catch (IOException iOException) {}
    try {
      PrintWriter pwwwwmmm = new PrintWriter(new FileWriter(batfile655));
      pwwwwmmm.println("copy /Y " + projectfolder + "\\apktool.yml " + projectfolder + "\\Cordova\\apktool.yml");
      pwwwwmmm.close();
    } catch (IOException iOException) {}
    ProcessBuilder pb1 = new ProcessBuilder(new String[] { projectfolder + "\\kady1.bat" });
    pb1.redirectError();
    try {
      Process b1 = pb1.start();
      InputStream inputStream = b1.getInputStream();
      Throwable var27 = null;
      try {
        boolean var28 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1297) {
        var27 = var1297;
        throw var1297;
      } finally {
        if (inputStream != null)
          if (var27 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1223) {
              var27.addSuppressed(var1223);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b1.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    ProcessBuilder pb2 = new ProcessBuilder(new String[] { projectfolder + "\\kady2.bat" });
    pb2.redirectError();
    try {
      Process b2 = pb2.start();
      InputStream inputStream = b2.getInputStream();
      Throwable var1322 = null;
      try {
        boolean var29 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1293) {
        var1322 = var1293;
        throw var1293;
      } finally {
        if (inputStream != null)
          if (var1322 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1222) {
              var1322.addSuppressed(var1222);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b2.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    ProcessBuilder pb3 = new ProcessBuilder(new String[] { projectfolder + "\\kady3.bat" });
    pb3.redirectError();
    try {
      Process b3 = pb3.start();
      InputStream inputStream = b3.getInputStream();
      Throwable var1326 = null;
      try {
        boolean var30 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1289) {
        var1326 = var1289;
        throw var1289;
      } finally {
        if (inputStream != null)
          if (var1326 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1221) {
              var1326.addSuppressed(var1221);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b3.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    
    
    
    
        
try {
    File zipFile = new File(apkresource); // The ZIP or APK file you want to extract
    File outputFolder = new File(projectfolder + "\\Cordova\\assets\\www"); // Target folder for extraction

    if (!outputFolder.exists()) {
        outputFolder.mkdirs();
    }

    byte[] buffer = new byte[1024];

    try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            File newFile = new File(outputFolder, entry.getName());

            // Security: prevent zip-slip attack
            String destDirPath = outputFolder.getCanonicalPath();
            String destFilePath = newFile.getCanonicalPath();
            if (!destFilePath.startsWith(destDirPath + File.separator)) {
                System.out.println("Skipping suspicious entry: " + entry.getName());
                continue;
            }

            if (entry.isDirectory()) {
                newFile.mkdirs();
            } else {
                new File(newFile.getParent()).mkdirs();

                try (FileOutputStream fos = new FileOutputStream(newFile)) {
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                }
            }
        }
    }

    System.out.println("Extraction complete.");

} catch (IOException e) {
    e.printStackTrace();
}

    
    
    
    
    
    
//    ProcessBuilder pb4 = new ProcessBuilder(new String[] { projectfolder + "\\kady4.bat" });
//    pb4.redirectError();
//    try {
//      Process b4 = pb4.start();
//      InputStream inputStream = b4.getInputStream();
//      Throwable var1331 = null;
//      try {
//        boolean var31 = true;
//        int in;
//        while ((in = inputStream.read()) != -1)
//          System.out.print((char)in); 
//      } catch (Throwable var1285) {
//        var1331 = var1285;
//        throw var1285;
//      } finally {
//        if (inputStream != null)
//          if (var1331 != null) {
//            try {
//              inputStream.close();
//            } catch (Throwable var1220) {
//              var1331.addSuppressed(var1220);
//            } 
//          } else {
//            inputStream.close();
//          }  
//      } 
//      System.out.println("Exited with " + b4.waitFor());
//    } catch (IOException iOException) {
//    
//    } catch (InterruptedException interruptedException) {}
    ProcessBuilder pb2r = new ProcessBuilder(new String[] { projectfolder + "\\kady11.bat" });
    pb2r.redirectError();
    try {
      Process b2r = pb2r.start();
      InputStream inputStream = b2r.getInputStream();
      Throwable var1336 = null;
      try {
        boolean var32 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1281) {
        var1336 = var1281;
        throw var1281;
      } finally {
        if (inputStream != null)
          if (var1336 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1219) {
              var1336.addSuppressed(var1219);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b2r.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    ProcessBuilder pb2r0 = new ProcessBuilder(new String[] { projectfolder + "\\kady1100.bat" });
    pb2r0.redirectError();
    try {
      Process b2r0 = pb2r0.start();
      InputStream inputStream = b2r0.getInputStream();
      Throwable var1336 = null;
      try {
        boolean var32 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1281) {
        var1336 = var1281;
        throw var1281;
      } finally {
        if (inputStream != null)
          if (var1336 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1219) {
              var1336.addSuppressed(var1219);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b2r0.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    ProcessBuilder pb2rt = new ProcessBuilder(new String[] { projectfolder + "\\kady12.bat" });
    pb2rt.redirectError();
    try {
      Process b2rt = pb2rt.start();
      InputStream inputStream = b2rt.getInputStream();
      Throwable var1341 = null;
      try {
        boolean var33 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1277) {
        var1341 = var1277;
        throw var1277;
      } finally {
        if (inputStream != null)
          if (var1341 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1218) {
              var1341.addSuppressed(var1218);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b2rt.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    ProcessBuilder pb10 = new ProcessBuilder(new String[] { projectfolder + "\\kady10.bat" });
    pb10.redirectError();
    try {
      Process b10 = pb10.start();
      InputStream inputStream = b10.getInputStream();
      Throwable var1346 = null;
      try {
        boolean var34 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1273) {
        var1346 = var1273;
        throw var1273;
      } finally {
        if (inputStream != null)
          if (var1346 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1217) {
              var1346.addSuppressed(var1217);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b10.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    ProcessBuilder pb9 = new ProcessBuilder(new String[] { projectfolder + "\\kady9.bat" });
    pb9.redirectError();
    try {
      Process b9 = pb9.start();
      InputStream inputStream = b9.getInputStream();
      Throwable var1351 = null;
      try {
        boolean var35 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1269) {
        var1351 = var1269;
        throw var1269;
      } finally {
        if (inputStream != null)
          if (var1351 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1216) {
              var1351.addSuppressed(var1216);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b9.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    ProcessBuilder pb910 = new ProcessBuilder(new String[] { projectfolder + "\\kady910.bat" });
    pb910.redirectError();
    try {
      Process b9 = pb910.start();
      InputStream inputStream = b9.getInputStream();
      Throwable var1351 = null;
      try {
        boolean var35 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1269) {
        var1351 = var1269;
        throw var1269;
      } finally {
        if (inputStream != null)
          if (var1351 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1216) {
              var1351.addSuppressed(var1216);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b9.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    ProcessBuilder pb9100 = new ProcessBuilder(new String[] { projectfolder + "\\kady9100.bat" });
    pb9100.redirectError();
    try {
      Process b9 = pb9100.start();
      InputStream inputStream = b9.getInputStream();
      Throwable var1351 = null;
      try {
        boolean var35 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1269) {
        var1351 = var1269;
        throw var1269;
      } finally {
        if (inputStream != null)
          if (var1351 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1216) {
              var1351.addSuppressed(var1216);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b9.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    ProcessBuilder pb91000 = new ProcessBuilder(new String[] { projectfolder + "\\kady91000.bat" });
    pb91000.redirectError();
    try {
      Process b9 = pb91000.start();
      InputStream inputStream = b9.getInputStream();
      Throwable var1351 = null;
      try {
        boolean var35 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1269) {
        var1351 = var1269;
        throw var1269;
      } finally {
        if (inputStream != null)
          if (var1351 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1216) {
              var1351.addSuppressed(var1216);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b9.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    ProcessBuilder pb910000 = new ProcessBuilder(new String[] { projectfolder + "\\kady910000.bat" });
    pb910000.redirectError();
    try {
      Process b9 = pb910000.start();
      InputStream inputStream = b9.getInputStream();
      Throwable var1351 = null;
      try {
        boolean var35 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1269) {
        var1351 = var1269;
        throw var1269;
      } finally {
        if (inputStream != null)
          if (var1351 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1216) {
              var1351.addSuppressed(var1216);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b9.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    ProcessBuilder pb9100000 = new ProcessBuilder(new String[] { projectfolder + "\\kady9100000.bat" });
    pb9100000.redirectError();
    try {
      Process b9 = pb9100000.start();
      InputStream inputStream = b9.getInputStream();
      Throwable var1351 = null;
      try {
        boolean var35 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1269) {
        var1351 = var1269;
        throw var1269;
      } finally {
        if (inputStream != null)
          if (var1351 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1216) {
              var1351.addSuppressed(var1216);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b9.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    ProcessBuilder pb91000000 = new ProcessBuilder(new String[] { projectfolder + "\\kady91000000.bat" });
    pb91000000.redirectError();
    try {
      Process b9 = pb91000000.start();
      InputStream inputStream = b9.getInputStream();
      Throwable var1351 = null;
      try {
        boolean var35 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1269) {
        var1351 = var1269;
        throw var1269;
      } finally {
        if (inputStream != null)
          if (var1351 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1216) {
              var1351.addSuppressed(var1216);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b9.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    ProcessBuilder pb910000000 = new ProcessBuilder(new String[] { projectfolder + "\\kady910000000.bat" });
    pb910000000.redirectError();
    try {
      Process b9 = pb910000000.start();
      InputStream inputStream = b9.getInputStream();
      Throwable var1351 = null;
      try {
        boolean var35 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1269) {
        var1351 = var1269;
        throw var1269;
      } finally {
        if (inputStream != null)
          if (var1351 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1216) {
              var1351.addSuppressed(var1216);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b9.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    ProcessBuilder pb9100000000 = new ProcessBuilder(new String[] { projectfolder + "\\kady9100000000.bat" });
    pb9100000000.redirectError();
    try {
      Process b9 = pb9100000000.start();
      InputStream inputStream = b9.getInputStream();
      Throwable var1351 = null;
      try {
        boolean var35 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1269) {
        var1351 = var1269;
        throw var1269;
      } finally {
        if (inputStream != null)
          if (var1351 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1216) {
              var1351.addSuppressed(var1216);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b9.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    ProcessBuilder pb91000000000 = new ProcessBuilder(new String[] { projectfolder + "\\kady91000000000.bat" });
    pb91000000000.redirectError();
    try {
      Process b9 = pb91000000000.start();
      InputStream inputStream = b9.getInputStream();
      Throwable var1351 = null;
      try {
        boolean var35 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1269) {
        var1351 = var1269;
        throw var1269;
      } finally {
        if (inputStream != null)
          if (var1351 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1216) {
              var1351.addSuppressed(var1216);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b9.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    ProcessBuilder pb910000000000 = new ProcessBuilder(new String[] { projectfolder + "\\kady910000000000.bat" });
    pb910000000000.redirectError();
    try {
      Process b9 = pb910000000000.start();
      InputStream inputStream = b9.getInputStream();
      Throwable var1351 = null;
      try {
        boolean var35 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1269) {
        var1351 = var1269;
        throw var1269;
      } finally {
        if (inputStream != null)
          if (var1351 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1216) {
              var1351.addSuppressed(var1216);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b9.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    ProcessBuilder pb5 = new ProcessBuilder(new String[] { projectfolder + "\\kady5.bat" });
    pb5.redirectError();
    try {
      Process b5 = pb5.start();
      InputStream inputStream = b5.getInputStream();
      Throwable var1356 = null;
      try {
        boolean var36 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1265) {
        var1356 = var1265;
        throw var1265;
      } finally {
        if (inputStream != null)
          if (var1356 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1215) {
              var1356.addSuppressed(var1215);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b5.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    ProcessBuilder pb6 = new ProcessBuilder(new String[] { projectfolder + "\\kady6.bat" });
    pb6.redirectError();
    try {
      Process b6 = pb6.start();
      InputStream inputStream = b6.getInputStream();
      Throwable var1361 = null;
      try {
        boolean var37 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1261) {
        var1361 = var1261;
        throw var1261;
      } finally {
        if (inputStream != null)
          if (var1361 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1214) {
              var1361.addSuppressed(var1214);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b6.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    ProcessBuilder pb7 = new ProcessBuilder(new String[] { projectfolder + "\\kady7.bat" });
    pb7.redirectError();
    try {
      Process b7 = pb7.start();
      InputStream inputStream = b7.getInputStream();
      Throwable var1366 = null;
      try {
        boolean var38 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1257) {
        var1366 = var1257;
        throw var1257;
      } finally {
        if (inputStream != null)
          if (var1366 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1213) {
              var1366.addSuppressed(var1213);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b7.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    ProcessBuilder pb8 = new ProcessBuilder(new String[] { projectfolder + "\\kady8.bat" });
    pb8.redirectError();
    try {
      Process b82 = pb8.start();
      InputStream inputStream = b82.getInputStream();
      Throwable var1366 = null;
      try {
        boolean var38 = true;
        int in;
        while ((in = inputStream.read()) != -1)
          System.out.print((char)in); 
      } catch (Throwable var1253) {
        var1366 = var1253;
        throw var1253;
      } finally {
        if (inputStream != null)
          if (var1366 != null) {
            try {
              inputStream.close();
            } catch (Throwable var1212) {
              var1366.addSuppressed(var1212);
            } 
          } else {
            inputStream.close();
          }  
      } 
      System.out.println("Exited with " + b82.waitFor());
    } catch (IOException iOException) {
    
    } catch (InterruptedException interruptedException) {}
    
    
    Thread.sleep(5000);
    
    
    
    try {
      Process b82 = Runtime.getRuntime().exec("cmd /c rmdir /s /q " + projectfolder);
    } catch (IOException iOException) {}
   
    
    
//    alert.setAlertType(Alert.AlertType.INFORMATION);
//    alert.close();
//    Stage stg = (Stage)this.create.getScene().getWindow();
//    stg.close();
//        Notifications noti = Notifications.create();
//            noti.title("Great!");
//            noti.text("APP Created Successfully.");
//            noti.position(Pos.CENTER);
//            noti.hideAfter(Duration.seconds(5));
//            noti.showInformation();
//    Desktop fjh = Desktop.getDesktop();
//    try {
//      fjh.open(new File(System.getProperty("user.home") + "\\Desktop"));
//    } catch (IOException ex) {
//      Logger.getLogger(CreateHtmlApkController.class.getName()).log(Level.SEVERE, (String)null, ex);
//    }
//    
    
      // Simulate delay (optional)
        Thread.sleep(1000);
        // Final progress to 100%
        Platform.runLater(() -> progressBar.setProgress(1.0));
        // Let progress bar show 100% before closing
        Thread.sleep(500);
        return null;
    }
    
    @Override
        protected void failed() {
            Platform.runLater(() -> {
                alert.close();
                Alert fail = new Alert(Alert.AlertType.ERROR, "❌ Error: " + getException().getMessage(), ButtonType.OK);
                fail.showAndWait();
            });
        }
   
    @Override
    protected void succeeded() {
        super.succeeded();
        Platform.runLater(() -> {
            alert.close(); // close the progress alert
            // Show the "done" alert
            Notifications noti = Notifications.create();
            noti.title("Great!");
            noti.text("✅ APK created successfully on your desktop!");
            noti.position(Pos.CENTER);
            noti.hideAfter(Duration.seconds(7));
            noti.showInformation();
            
        });
    }
};
// Start background thread
Thread backgroundThread = new Thread(task);
backgroundThread.setDaemon(true);
backgroundThread.start();

    
    
  }
  
  @FXML
  void browse1act(ActionEvent event) {
    FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Html Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String dirpathe = f.getAbsolutePath().toString();
    this.htmlfile.setText(dirpathe);
    this.browse2.setDisable(false);
  }
  
  @FXML
  void browse2act(ActionEvent event) {
    FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Zip Files", new String[] { "*.zip" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String dirpathe = f.getAbsolutePath().toString();
    this.zipfile.setText(dirpathe);
    this.create.setDisable(false);
  }
  
  public void initialize(URL location, ResourceBundle resources) {
    this.imgview.setImage(new Image(getClass().getResourceAsStream("image.png")));
    PulseTransition pulsee = new PulseTransition(this.imgview);
    pulsee.setAutoReverse(true);
    pulsee.setCycleCount(10);
    pulsee.play();
  }
}
