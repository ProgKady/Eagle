package eagle;

import com.gluonhq.charm.glisten.animation.PulseTransition;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class CreateMusicApkOneController implements Initializable {
   @FXML
   private ResourceBundle resources;
   @FXML
   private URL location;
   @FXML
   private JFXTextField zipfile;
   @FXML
   private Label pathlabel;
   @FXML
   private JFXTextArea tarea;
   @FXML
   private JFXButton bs;
   @FXML
   private JFXButton bi;
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
   void genscript(MouseEvent event) {
     
       MultiMediaDropper11 mmd=new MultiMediaDropper11();
       mmd.start(new Stage());
       
   }

   @FXML
   void imgviewact(MouseEvent event) {
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new ExtensionFilter("Image Files", new String[]{"*.png"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      this.imgview.setImage(new Image((new File(dirpathe)).toURI().toString()));
      this.pathlabel.setText(dirpathe);
      this.browse1.setDisable(false);
   }
   
    @FXML
   void bsact(ActionEvent event) {
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new ExtensionFilter("Music Files", new String[]{"*.mp3"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getName().toString();
      if (tarea.getText().isEmpty()==true) {
          tarea.appendText("{\n" +
"    backgroundImage: \"assets/images/1.jpg\",\n" +
"    posterUrl: \"assets/images/1.jpg\",\n" +
"    title: \"Title Of Song\",\n" +
"    album: \"Album Name\",\n" +
"    year: 2025,\n" +
"    artist: \"Artist Name\",\n" +
"    musicPath: \"assets/music/"+dirpathe+"\",\n" +
"  },\n");
      }
      else {
          tarea.appendText("{\n" +
"    backgroundImage: \"assets/images/1.jpg\",\n" +
"    posterUrl: \"assets/images/1.jpg\",\n" +
"    title: \"Title Of Song\",\n" +
"    album: \"Album Name\",\n" +
"    year: 2025,\n" +
"    artist: \"Artist Name\",\n" +
"    musicPath: \"assets/music/"+dirpathe+"\",\n" +
"  },\n");
      }
      bi.setDisable(false);
      bs.setDisable(true);
   }
   @FXML
   void biact(ActionEvent event) {
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new ExtensionFilter("Image Files", new String[]{"*.png"}));
      fcho.getExtensionFilters().add(new ExtensionFilter("Image Files", new String[]{"*.jpg"}));
      fcho.getExtensionFilters().add(new ExtensionFilter("Image Files", new String[]{"*.jpeg"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getName().toString();
      String gt=tarea.getText().replace("1.jpg",dirpathe);
      tarea.setText(gt);
      bi.setDisable(true);
      bs.setDisable(false);
   }

   @FXML
   void createact(ActionEvent event) throws IOException, InterruptedException {
      String apknam = this.apkname.getText();
      String apkpkg = this.packagename.getText();
      String apkico = this.pathlabel.getText();
      String apksource = this.htmlfile.getText();
      String apkresource = this.zipfile.getText();
      String cooode=tarea.getText();
      String apkresourcee =System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\musicone.zip";
      
      
      
      
      
      
       
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
         Process var10 = Runtime.getRuntime().exec("cmd /c copy " + System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Cordova.kady " + projectfolder + "\\Cordova.apk");
      } catch (IOException var1252) {
         ;
      }

      File batfile1 = new File(projectfolder + "\\kady1.bat");

      try {
         batfile1.createNewFile();
      } catch (IOException var1251) {
         ;
      }

      try {
         PrintWriter pw = new PrintWriter(new FileWriter(batfile1));
         pw.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\apktool.bat d -f " + projectfolder + "\\Cordova.apk -o " + projectfolder + "\\Cordova");
         pw.close();
      } catch (IOException var1250) {
         ;
      }

      File framwork = new File(projectfolder + "\\kady2.bat");

      try {
         framwork.createNewFile();
      } catch (IOException var1249) {
         ;
      }

      try {
         PrintWriter pwq = new PrintWriter(new FileWriter(framwork));
         pwq.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\apktool.bat if " + projectfolder + "\\Cordova.apk");
         pwq.close();
      } catch (IOException var1248) {
         ;
      }

      
      
//      
//      File htmlbat2 = new File(projectfolder + "\\kady3.bat");
//
//      try {
//         htmlbat2.createNewFile();
//      } catch (IOException var1247) {
//         ;
//      }
//
//      try {
//         PrintWriter lcv = new PrintWriter(new FileWriter(htmlbat2));
//         lcv.println("cd " + projectfolder + "\\Cordova\\assets\\www\\assets\\songs");
//         lcv.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\7z.exe x -y " + apksource);
//         lcv.close();
//      } catch (IOException var1246) {
//         ;
//      }
//
//      File htmlbat300 = new File(projectfolder + "\\kady300.bat");
//
//      try {
//         htmlbat300.createNewFile();
//      } catch (IOException var1247) {
//         ;
//      }
//
//      try {
//         PrintWriter lcv = new PrintWriter(new FileWriter(htmlbat300));
//         lcv.println("cd " + projectfolder + "\\Cordova\\assets\\www\\assets\\images");
//         lcv.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\7z.exe x -y " + apkresource);
//         lcv.close();
//      } catch (IOException var1246) {
//         ;
//      }


//      File htmlbat1 = new File(projectfolder + "\\kady4.bat");
//
//      try {
//         htmlbat1.createNewFile();
//      } catch (IOException var1245) {
//         ;
//      }
//
//      try {
//         PrintWriter lcv = new PrintWriter(new FileWriter(htmlbat1));
//         lcv.println("cd " + projectfolder + "\\Cordova\\assets\\www");
//         lcv.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\7z.exe x -y " + apkresourcee);
//         lcv.close();
//      } catch (IOException var1244) {
//         ;
//      }

      File htmlbat11 = new File(projectfolder + "\\kady9.bat");

      try {
         htmlbat11.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat11));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-hdpi");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-hdpi\\ic_launcher.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

File htmlbat1110 = new File(projectfolder + "\\kady910.bat");

      try {
         htmlbat1110.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat1110));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-ldpi");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-ldpi\\ic_launcher.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
      
      File htmlbat11100 = new File(projectfolder + "\\kady9100.bat");

      try {
         htmlbat11100.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat11100));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-mdpi");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-mdpi\\ic_launcher.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
      File htmlbat111000 = new File(projectfolder + "\\kady91000.bat");

      try {
         htmlbat111000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat111000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xxhdpi");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xxhdpi\\ic_launcher.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
      
      File htmlbat1110000 = new File(projectfolder + "\\kady910000.bat");

      try {
         htmlbat1110000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat1110000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xxxhdpi");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xxxhdpi\\ic_launcher.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
//////////////////////////////////////////////////////////////////////////////////////////////////////////
 
      File htmlbat11100000 = new File(projectfolder + "\\kady9100000.bat");

      try {
         htmlbat11100000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat11100000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-hdpi-v26");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-hdpi-v26\\ic_launcher_foreground.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
       
      File htmlbat111000000 = new File(projectfolder + "\\kady91000000.bat");

      try {
         htmlbat111000000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat111000000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-ldpi-v26");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-ldpi-v26\\ic_launcher_foreground.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
       
      File htmlbat1110000000 = new File(projectfolder + "\\kady910000000.bat");

      try {
         htmlbat1110000000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat1110000000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-mhdpi-v26");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-mhdpi-v26\\ic_launcher_foreground.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
       
      File htmlbat11100000000 = new File(projectfolder + "\\kady9100000000.bat");

      try {
         htmlbat11100000000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat11100000000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xhdpi-v26");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xhdpi-v26\\ic_launcher_foreground.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
       
      File htmlbat111000000000 = new File(projectfolder + "\\kady91000000000.bat");

      try {
         htmlbat111000000000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat111000000000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xxhdpi-v26");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xxhdpi-v26\\ic_launcher_foreground.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
       
      File htmlbat1110000000000 = new File(projectfolder + "\\kady910000000000.bat");

      try {
         htmlbat1110000000000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat1110000000000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xxxhdpi-v26");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xxxhdpi-v26\\ic_launcher_foreground.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      File htmlbat111 = new File(projectfolder + "\\kady10.bat");

      try {
         htmlbat111.createNewFile();
      } catch (IOException var1241) {
         ;
      }

      try {
         PrintWriter lcvvv = new PrintWriter(new FileWriter(htmlbat111));
         lcvvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xhdpi");
         lcvvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xhdpi\\ic_launcher.png");
         lcvvv.close();
      } catch (IOException var1240) {
         ;
      }

      File batfile3 = new File(projectfolder + "\\kady5.bat");

      try {
         batfile3.createNewFile();
      } catch (IOException var1239) {
         ;
      }

      try {
         PrintWriter pww = new PrintWriter(new FileWriter(batfile3));
         pww.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\apktool.bat b -f " + projectfolder + "\\Cordova");
         pww.close();
      } catch (IOException var1238) {
         ;
      }

      File batfile5 = new File(projectfolder + "\\kady6.bat");

      try {
         batfile5.createNewFile();
      } catch (IOException var1237) {
         ;
      }

      try {
         PrintWriter pwwu = new PrintWriter(new FileWriter(batfile5));
         pwwu.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\zipalign.exe -v 4 " + projectfolder + "\\Cordova\\dist\\Cordova.apk " + projectfolder + "\\newApk.apk");
         pwwu.close();
      } catch (IOException var1236) {
         ;
      }

      File batfile4 = new File(projectfolder + "\\kady7.bat");

      try {
         batfile4.createNewFile();
      } catch (IOException var1235) {
         ;
      }

      try {
         PrintWriter pwww = new PrintWriter(new FileWriter(batfile4));
         //pwww.println("cd " + System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data");
         pwww.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk.bat " + projectfolder + "\\newApk.apk");
         pwww.close();
      } catch (IOException var1234) {
         ;
      }

      File batfile6 = new File(projectfolder + "\\kady8.bat");

      try {
         batfile6.createNewFile();
      } catch (IOException var1233) {
         ;
      }

      try {
         PrintWriter pwwww = new PrintWriter(new FileWriter(batfile6));
         pwwww.println("copy " + projectfolder + "\\newApk_Eagle_Kadysoft.apk " + System.getProperty("user.home") + "\\desktop");
         pwwww.close();
      } catch (IOException var1232) {
         ;
      }

      File batfile66 = new File(projectfolder + "\\strings.xml");

      try {
         batfile66.createNewFile();
      } catch (IOException var1231) {
         ;
      }

      try {
         PrintWriter pwwwwn = new PrintWriter(new FileWriter(batfile66));
         pwwwwn.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
"<resources>\n" +
"    <string name=\"activity_name\">@string/launcher_name</string>\n" +
"    <string name=\"app_name\">"+apknam+"</string>\n" +
"    <string name=\"launcher_name\">@string/app_name</string>\n" +
"</resources>");
         pwwwwn.close();
      } catch (IOException var1230) {
         ;
      }
      /////////////////////////////////////////////////////////////////////
      
      File batfile6600 = new File(projectfolder + "\\AndroidManifest.xml");

      try {
         batfile6600.createNewFile();
      } catch (IOException var1231) {
         
      }

      try {
         PrintWriter pwwwwn00 = new PrintWriter(new FileWriter(batfile6600));
         pwwwwn00.println("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?><manifest xmlns:android=\"http://schemas.android.com/apk/res/android\" android:compileSdkVersion=\"28\" android:compileSdkVersionCodename=\"9\" android:hardwareAccelerated=\"true\" package=\"com.zib.apache.cordova.browser\" platformBuildVersionCode=\"10000\" platformBuildVersionName=\"1.0.0\">\n" +
"    <supports-screens android:anyDensity=\"true\" android:largeScreens=\"true\" android:normalScreens=\"true\" android:resizeable=\"true\" android:smallScreens=\"true\" android:xlargeScreens=\"true\"/>\n" +
"    <uses-permission android:name=\"android.permission.INTERNET\"/>\n" +
"    <application android:hardwareAccelerated=\"true\" android:icon=\"@mipmap/ic_launcher\" android:label=\"@string/app_name\" android:supportsRtl=\"true\">\n" +
"        <activity android:configChanges=\"keyboard|keyboardHidden|locale|orientation|screenLayout|screenSize|smallestScreenSize|uiMode\" android:label=\"@string/activity_name\" android:launchMode=\"singleTop\" android:name=\"com.zib.apache.cordova.browser.MainActivity\" android:theme=\"@android:style/Theme.DeviceDefault.NoActionBar\" android:windowSoftInputMode=\"adjustResize\">\n" +
"            <intent-filter android:label=\"@string/launcher_name\">\n" +
"                <action android:name=\"android.intent.action.MAIN\"/>\n" +
"                <category android:name=\"android.intent.category.LAUNCHER\"/>\n" +
"            </intent-filter>\n" +
"        </activity>\n" +
"        <meta-data android:name=\"com.android.vending.derived.apk.id\" android:value=\"1\"/>\n" +
"    </application>\n" +
"</manifest>");
         pwwwwn00.close();
      } catch (IOException var1230) {
         
      }
      
     //////////////////////////////////////////////////////////////////////
      File batfile666 = new File(projectfolder + "\\apktool.yml");

      try {
         batfile666.createNewFile();
      } catch (IOException var1229) {
         ;
      }

      try {
         PrintWriter pwwwwnx = new PrintWriter(new FileWriter(batfile666));
         pwwwwnx.println("!!brut.androlib.meta.MetaInfo\n" +
"apkFileName: Cordova.apk\n" +
"compressionType: false\n" +
"doNotCompress:\n" +
"- arsc\n" +
"- png\n" +
"isFrameworkApk: false\n" +
"packageInfo:\n" +
"  forcedPackageId: '127'\n" +
"  renameManifestPackage: com.eagle."+apkpkg+"\n" +
"sdkInfo:\n" +
"  minSdkVersion: '19'\n" +
"  targetSdkVersion: '28'\n" +
"sharedLibrary: false\n" +
"sparseResources: false\n" +
"unknownFiles: {}\n" +
"usesFramework:\n" +
"  ids:\n" +
"  - 1\n" +
"  tag: null\n" +
"version: 2.3.4\n" +
"versionInfo:\n" +
"  versionCode: '10000'\n" +
"  versionName: 1.0.0");
         pwwwwnx.close();
      } catch (IOException var1228) {
         ;
      }

      File batfile65 = new File(projectfolder + "\\kady11.bat");

      try {
         batfile65.createNewFile();
      } catch (IOException var1227) {
         ;
      }

      try {
         PrintWriter pwwwwm = new PrintWriter(new FileWriter(batfile65));
         pwwwwm.println("copy /Y " + projectfolder + "\\strings.xml " + projectfolder + "\\Cordova\\res\\values\\strings.xml");
         pwwwwm.close();
      } catch (IOException var1226) {
         ;
      }
      /////////////////////////////////////////////////////////////////////////////
      
      File batfile650 = new File(projectfolder + "\\kady1100.bat");

      try {
         batfile650.createNewFile();
      } catch (IOException var1227) {
         
      }

      try {
         PrintWriter pwwwwm0 = new PrintWriter(new FileWriter(batfile650));
         pwwwwm0.println("copy /Y " + projectfolder + "\\AndroidManifest.xml " + projectfolder + "\\Cordova\\AndroidManifest.xml");
         pwwwwm0.close();
      } catch (IOException var1226) {
         
      }
      
      /////////////////////////////////////////////////////////////////////////////

      File batfile655 = new File(projectfolder + "\\kady12.bat");

      try {
         batfile655.createNewFile();
      } catch (IOException var1225) {
         ;
      }

      try {
         PrintWriter pwwwwmmm = new PrintWriter(new FileWriter(batfile655));
         pwwwwmmm.println("copy /Y " + projectfolder + "\\apktool.yml " + projectfolder + "\\Cordova\\apktool.yml");
         pwwwwmmm.close();
      } catch (IOException var1224) {
         ;
      }

      ProcessBuilder pb1 = new ProcessBuilder(new String[]{projectfolder + "\\kady1.bat"});
      pb1.redirectError();

      try {
         Process b1 = pb1.start();
         InputStream inputStream = b1.getInputStream();
         Throwable var27 = null;

         try {
            boolean var28 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1297) {
            var27 = var1297;
            throw var1297;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b1.waitFor());
      } catch (IOException var1299) {
         ;
      } catch (InterruptedException var1300) {
         ;
      }

      ProcessBuilder pb2 = new ProcessBuilder(new String[]{projectfolder + "\\kady2.bat"});
      pb2.redirectError();

      try {
         Process b2 = pb2.start();
         InputStream inputStream = b2.getInputStream();
         Throwable var1322 = null;

         try {
            boolean var29 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1293) {
            var1322 = var1293;
            throw var1293;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b2.waitFor());
      } catch (IOException var1295) {
         ;
      } catch (InterruptedException var1296) {
         ;
      }
      
      
      
      
      
try {
    File zipFile = new File(apkresourcee); // The ZIP or APK file you want to extract
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


      
        
      //////////////////////////////////////////////////////////////////////
  
      PrintWriter pwz;
      pwz=new PrintWriter (new FileWriter (projectfolder + "\\Cordova\\assets\\www\\assets\\js\\script.js")); 
      pwz.write("'use strict';\n" +
"\n" +
"/**\n" +
" * all music information\n" +
" */\n" +
"const musicData = [\n" +
"  \n" +
" "+cooode+" \n" +
"  \n" +
"  \n" +
"];\n" +
"\n" +
"/**\n" +
" * add eventListener on all elements that are passed\n" +
" */\n" +
"const addEventOnElements = function (elements, eventType, callback) {\n" +
"  for (let i = 0, len = elements.length; i < len; i++) {\n" +
"    elements[i].addEventListener(eventType, callback);\n" +
"  }\n" +
"}\n" +
"\n" +
"/**\n" +
" * PLAYLIST\n" +
" * add all music in playlist, from 'musicData'\n" +
" */\n" +
"const playlist = document.querySelector(\"[data-music-list]\");\n" +
"\n" +
"for (let i = 0, len = musicData.length; i < len; i++) {\n" +
"  playlist.innerHTML += `\n" +
"  <li>\n" +
"    <button class=\"music-item ${i === 0 ? \"playing\" : \"\"}\" data-playlist-toggler data-playlist-item=\"${i}\">\n" +
"      <img src=\"${musicData[i].posterUrl}\" width=\"800\" height=\"800\" alt=\"${musicData[i].title} Album Poster\" class=\"img-cover\">\n" +
"      <div class=\"item-icon\">\n" +
"        <img src=\"assets/icons/equalizer.svg\" width=\"36\" height=\"36\" alt=\"Equalizer icon\">\n" +
"      </div>\n" +
"    </button>\n" +
"  </li>\n" +
"  `;\n" +
"}\n" +
"\n" +
"/**\n" +
" * PLAYLIST MODAL SIDEBAR TOGGLE\n" +
" */\n" +
"const playlistSideModal = document.querySelector(\"[data-playlist]\");\n" +
"const playlistTogglers = document.querySelectorAll(\"[data-playlist-toggler]\");\n" +
"const overlay = document.querySelector(\"[data-overlay]\");\n" +
"\n" +
"const togglePlaylist = function () {\n" +
"  playlistSideModal.classList.toggle(\"active\");\n" +
"  overlay.classList.toggle(\"active\");\n" +
"  document.body.classList.toggle(\"modalActive\");\n" +
"}\n" +
"\n" +
"addEventOnElements(playlistTogglers, \"click\", togglePlaylist);\n" +
"\n" +
"/**\n" +
" * PLAYLIST ITEM\n" +
" */\n" +
"const playlistItems = document.querySelectorAll(\"[data-playlist-item]\");\n" +
"\n" +
"let currentMusic = 0;\n" +
"let lastPlayedMusic = 0;\n" +
"\n" +
"const changePlaylistItem = function () {\n" +
"  playlistItems[lastPlayedMusic].classList.remove(\"playing\");\n" +
"  playlistItems[currentMusic].classList.add(\"playing\");\n" +
"}\n" +
"\n" +
"addEventOnElements(playlistItems, \"click\", function () {\n" +
"  lastPlayedMusic = currentMusic;\n" +
"  currentMusic = Number(this.dataset.playlistItem);\n" +
"  changePlaylistItem();\n" +
"});\n" +
"\n" +
"/**\n" +
" * PLAYER\n" +
" */\n" +
"const playerBanner = document.querySelector(\"[data-player-banner]\");\n" +
"const playerTitle = document.querySelector(\"[data-title]\");\n" +
"const playerAlbum = document.querySelector(\"[data-album]\");\n" +
"const playerYear = document.querySelector(\"[data-year]\");\n" +
"const playerArtist = document.querySelector(\"[data-artist]\");\n" +
"\n" +
"const audioSource = new Audio(musicData[currentMusic].musicPath);\n" +
"\n" +
"const changePlayerInfo = function () {\n" +
"  playerBanner.src = musicData[currentMusic].posterUrl;\n" +
"  playerBanner.setAttribute(\"alt\", `${musicData[currentMusic].title} Album Poster`);\n" +
"  document.body.style.backgroundImage = `url(${musicData[currentMusic].backgroundImage})`;\n" +
"  playerTitle.textContent = musicData[currentMusic].title;\n" +
"  playerAlbum.textContent = musicData[currentMusic].album;\n" +
"  playerYear.textContent = musicData[currentMusic].year;\n" +
"  playerArtist.textContent = musicData[currentMusic].artist;\n" +
"\n" +
"  audioSource.src = musicData[currentMusic].musicPath;\n" +
"\n" +
"  audioSource.addEventListener(\"loadeddata\", updateDuration);\n" +
"  playMusic();\n" +
"}\n" +
"\n" +
"addEventOnElements(playlistItems, \"click\", changePlayerInfo);\n" +
"\n" +
"/** update player duration */\n" +
"const playerDuration = document.querySelector(\"[data-duration]\");\n" +
"const playerSeekRange = document.querySelector(\"[data-seek]\");\n" +
"\n" +
"const getTimecode = function (duration) {\n" +
"  const minutes = Math.floor(duration / 60);\n" +
"  const seconds = Math.ceil(duration - (minutes * 60));\n" +
"  const timecode = `${minutes}:${seconds < 10 ? \"0\" : \"\"}${seconds}`;\n" +
"  return timecode;\n" +
"}\n" +
"\n" +
"const updateDuration = function () {\n" +
"  playerSeekRange.max = Math.ceil(audioSource.duration);\n" +
"  playerDuration.textContent = getTimecode(Number(playerSeekRange.max));\n" +
"}\n" +
"\n" +
"audioSource.addEventListener(\"loadeddata\", updateDuration);\n" +
"\n" +
"/**\n" +
" * PLAY MUSIC\n" +
" */\n" +
"const playBtn = document.querySelector(\"[data-play-btn]\");\n" +
"\n" +
"let playInterval;\n" +
"\n" +
"const playMusic = function () {\n" +
"  if (audioSource.paused) {\n" +
"    audioSource.play();\n" +
"    playBtn.classList.add(\"active\");\n" +
"    playInterval = setInterval(updateRunningTime, 500);\n" +
"  } else {\n" +
"    audioSource.pause();\n" +
"    playBtn.classList.remove(\"active\");\n" +
"    clearInterval(playInterval);\n" +
"  }\n" +
"}\n" +
"\n" +
"playBtn.addEventListener(\"click\", playMusic);\n" +
"\n" +
"/** update running time while playing music */\n" +
"const playerRunningTime = document.querySelector(\"[data-running-time]\");\n" +
"\n" +
"const updateRunningTime = function () {\n" +
"  playerSeekRange.value = audioSource.currentTime;\n" +
"  playerRunningTime.textContent = getTimecode(audioSource.currentTime);\n" +
"\n" +
"  updateRangeFill();\n" +
"  isMusicEnd();\n" +
"}\n" +
"\n" +
"/**\n" +
" * RANGE FILL WIDTH\n" +
" */\n" +
"const ranges = document.querySelectorAll(\"[data-range]\");\n" +
"const rangeFill = document.querySelector(\"[data-range-fill]\");\n" +
"\n" +
"const updateRangeFill = function () {\n" +
"  let element = this || ranges[0];\n" +
"  const rangeValue = (element.value / element.max) * 100;\n" +
"  element.nextElementSibling.style.width = `${rangeValue}%`;\n" +
"}\n" +
"\n" +
"addEventOnElements(ranges, \"input\", updateRangeFill);\n" +
"\n" +
"/**\n" +
" * SEEK MUSIC\n" +
" */\n" +
"const seek = function () {\n" +
"  audioSource.currentTime = playerSeekRange.value;\n" +
"  playerRunningTime.textContent = getTimecode(playerSeekRange.value);\n" +
"}\n" +
"\n" +
"playerSeekRange.addEventListener(\"input\", seek);\n" +
"\n" +
"/**\n" +
" * END MUSIC\n" +
" */\n" +
"const isMusicEnd = function () {\n" +
"  if (audioSource.ended) {\n" +
"    playBtn.classList.remove(\"active\");\n" +
"    audioSource.currentTime = 0;\n" +
"    playerSeekRange.value = audioSource.currentTime;\n" +
"    playerRunningTime.textContent = getTimecode(audioSource.currentTime);\n" +
"    updateRangeFill();\n" +
"  }\n" +
"}\n" +
"\n" +
"/**\n" +
" * SKIP TO NEXT MUSIC\n" +
" */\n" +
"const playerSkipNextBtn = document.querySelector(\"[data-skip-next]\");\n" +
"\n" +
"const skipNext = function () {\n" +
"  lastPlayedMusic = currentMusic;\n" +
"\n" +
"  if (isShuffled) {\n" +
"    shuffleMusic();\n" +
"  } else {\n" +
"    currentMusic >= musicData.length - 1 ? currentMusic = 0 : currentMusic++;\n" +
"  }\n" +
"\n" +
"  changePlayerInfo();\n" +
"  changePlaylistItem();\n" +
"}\n" +
"\n" +
"playerSkipNextBtn.addEventListener(\"click\", skipNext);\n" +
"\n" +
"/**\n" +
" * SKIP TO PREVIOUS MUSIC\n" +
" */\n" +
"const playerSkipPrevBtn = document.querySelector(\"[data-skip-prev]\");\n" +
"\n" +
"const skipPrev = function () {\n" +
"  lastPlayedMusic = currentMusic;\n" +
"\n" +
"  if (isShuffled) {\n" +
"    shuffleMusic();\n" +
"  } else {\n" +
"    currentMusic <= 0 ? currentMusic = musicData.length - 1 : currentMusic--;\n" +
"  }\n" +
"\n" +
"  changePlayerInfo();\n" +
"  changePlaylistItem();\n" +
"}\n" +
"\n" +
"playerSkipPrevBtn.addEventListener(\"click\", skipPrev);\n" +
"\n" +
"/**\n" +
" * SHUFFLE MUSIC\n" +
" */\n" +
"const getRandomMusic = () => Math.floor(Math.random() * musicData.length);\n" +
"\n" +
"const shuffleMusic = () => currentMusic = getRandomMusic();\n" +
"\n" +
"const playerShuffleBtn = document.querySelector(\"[data-shuffle]\");\n" +
"let isShuffled = false;\n" +
"\n" +
"const shuffle = function () {\n" +
"  playerShuffleBtn.classList.toggle(\"active\");\n" +
"  isShuffled = !isShuffled;\n" +
"}\n" +
"\n" +
"playerShuffleBtn.addEventListener(\"click\", shuffle);\n" +
"\n" +
"/**\n" +
" * REPEAT MUSIC\n" +
" */\n" +
"const playerRepeatBtn = document.querySelector(\"[data-repeat]\");\n" +
"\n" +
"const repeat = function () {\n" +
"  if (!audioSource.loop) {\n" +
"    audioSource.loop = true;\n" +
"    this.classList.add(\"active\");\n" +
"  } else {\n" +
"    audioSource.loop = false;\n" +
"    this.classList.remove(\"active\");\n" +
"  }\n" +
"}\n" +
"\n" +
"playerRepeatBtn.addEventListener(\"click\", repeat);\n" +
"\n" +
"/**\n" +
" * MUSIC VOLUME\n" +
" */\n" +
"const playerVolumeRange = document.querySelector(\"[data-volume]\");\n" +
"const playerVolumeBtn = document.querySelector(\"[data-volume-btn]\");\n" +
"\n" +
"const changeVolume = function () {\n" +
"  audioSource.volume = playerVolumeRange.value;\n" +
"  audioSource.muted = false;\n" +
"\n" +
"  const volumeIcon = playerVolumeBtn.querySelector(\".volume-icon\");\n" +
"  if (audioSource.volume <= 0.1) {\n" +
"    volumeIcon.src = \"assets/icons/volume_mute.svg\";\n" +
"  } else if (audioSource.volume <= 0.5) {\n" +
"    volumeIcon.src = \"assets/icons/volume_down.svg\";\n" +
"  } else {\n" +
"    volumeIcon.src = \"assets/icons/volume_up.svg\";\n" +
"  }\n" +
"}\n" +
"\n" +
"playerVolumeRange.addEventListener(\"input\", changeVolume);\n" +
"\n" +
"/**\n" +
" * MUTE MUSIC\n" +
" */\n" +
"const muteVolume = function () {\n" +
"  if (!audioSource.muted) {\n" +
"    audioSource.muted = true;\n" +
"    playerVolumeBtn.querySelector(\".volume-icon\").src = \"assets/icons/volume_off.svg\";\n" +
"  } else {\n" +
"    changeVolume();\n" +
"  }\n" +
"}\n" +
"\n" +
"playerVolumeBtn.addEventListener(\"click\", muteVolume);");
             
      pwz.close(); 
      
      
      
      
      
       PrintWriter pwzi;
      pwzi=new PrintWriter (new FileWriter (projectfolder + "\\Cordova\\assets\\www\\index.html")); 
      pwzi.write("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"\n" +
"<head>\n" +
"  <meta charset=\"UTF-8\">\n" +
"  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"\n" +
"  <!-- \n" +
"    - primary meta tags\n" +
"  -->\n" +
"  <title></title>\n" +
"  <meta name=\"title\" content=\"Music Player\">\n" +
"  <meta name=\"description\" content=\"A web music player html template made by codewithsadee\">\n" +
"\n" +
"  <!-- \n" +
"    - favicon\n" +
"  -->\n" +
"  <link rel=\"shortcut icon\" href=\"\" type=\"image/svg+xml\">\n" +
"\n" +
"  <!-- \n" +
"    - google font link\n" +
" \n" +
"  <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +
"  <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +
"  <link href=\"https://fonts.googleapis.com/css2?family=Inter:wght@400;500&display=swap\" rel=\"stylesheet\">\n" +
" -->\n" +
"  <!-- \n" +
"    - material icon font\n" +
" \n" +
"  <link rel=\"stylesheet\"\n" +
"    href=\"https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@24,400,0,-25\" />\n" +
"  -->\n" +
"  <!-- \n" +
"    - custom css link\n" +
"  -->\n" +
"  <link rel=\"stylesheet\" href=\"./assets/css/style.css\">\n" +
"\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"\n" +
"  <!-- \n" +
"    - #TOP APP BAR\n" +
"  -->\n" +
"\n" +
"  <div class=\"top-bar wrapper\">\n" +
"\n" +
"    <div class=\"logo wrapper\">\n" +
"     <img src=\"assets/icons/graphic_eq.svg\" width=\"24\" height=\"24\" alt=\"Music icon\">\n" +
"\n" +
"      <h1 class=\"title-lg\">"+apknam+"</h1>\n" +
"    </div>\n" +
"\n" +
"    <div class=\"top-bar-actions\">\n" +
"      <button class=\"btn-icon\" data-playlist-toggler>\n" +
"       <img src=\"assets/icons/queue_music.svg\" width=\"24\" height=\"24\" alt=\"Playlist icon\">\n" +
"      </button>\n" +
"    </div>\n" +
"\n" +
"  </div>\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"  <main>\n" +
"    <article>\n" +
"\n" +
"      <!-- \n" +
"        - #PLAYER\n" +
"      -->\n" +
"	  \n" +
"  <!-- \n" +
"       ----------------------------------------------------------------------------------------------------------------------\n" +
"      -->\n" +
"\n" +
"      <div class=\"player\">\n" +
"        <div class=\"container\">\n" +
"\n" +
"          <figure class=\"music-banner\">\n" +
"            <img src=\"./assets/images/poster-1.jpg\" width=\"800\" height=\"800\" alt=\"Happy Moments (Master) Album Poster\"\n" +
"              class=\"img-cover\" data-player-banner>\n" +
"          </figure>\n" +
"\n" +
"          <div class=\"music-content\">\n" +
"\n" +
"            <h2 class=\"headline-sm\" data-title>Song Name</h2>\n" +
"\n" +
"            <p class=\"label-lg label-wrapper wrapper\">\n" +
"              <span data-album>Album Name</span>\n" +
"\n" +
"              <span data-year>2025</span>\n" +
"            </p>\n" +
"\n" +
"            <p class=\"label-md artist\" data-artist>Artist Name</p>\n" +
"\n" +
"            <div class=\"seek-control\">\n" +
"\n" +
"              <div>\n" +
"                <div class=\"range-wrapper\">\n" +
"                  <input type=\"range\" step=\"1\" max=\"60\" value=\"0\" class=\"range\" data-range data-seek>\n" +
"\n" +
"                  <div class=\"range-fill\" data-range-fill></div>\n" +
"                </div>\n" +
"\n" +
"\n" +
"  <!-- \n" +
"       ----------------------------------------------------------------------------------------------------------------------\n" +
"      -->\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"                <div class=\"duration-label wrapper\">\n" +
"                  <span class=\"label-md\" data-running-time>0:00</span>\n" +
"\n" +
"                  <span class=\"label-md\" data-duration>1:00</span>\n" +
"                </div>\n" +
"              </div>\n" +
"\n" +
"              <div class=\"volume\">\n" +
"                <button class=\"btn-icon\" data-volume-btn>\n" +
"                 <img src=\"assets/icons/volume_up.svg\" width=\"24\" height=\"24\" alt=\"Volume icon\" class=\"volume-icon\">\n" +
"                </button>\n" +
"\n" +
"                <div class=\"range-wrapper\">\n" +
"                  <input type=\"range\" step=\"0.05\" max=\"1\" value=\"1\" class=\"range\" data-range data-volume>\n" +
"\n" +
"                  <div class=\"range-fill\" data-range-fill></div>\n" +
"                </div>\n" +
"              </div>\n" +
"\n" +
"            </div>\n" +
"\n" +
"            <div class=\"player-control wrapper\">\n" +
"\n" +
"              <button class=\"btn-icon toggle\" data-repeat>\n" +
"                <img src=\"assets/icons/repeat.svg\" width=\"24\" height=\"24\" alt=\"Repeat icon\" class=\"default-icon\">\n" +
"            <img src=\"assets/icons/repeat_one.svg\" width=\"24\" height=\"24\" alt=\"Repeat one icon\" class=\"active-icon\">\n" +
"              </button>\n" +
"\n" +
"              <button class=\"btn-icon\" data-skip-prev>\n" +
"                <img src=\"assets/icons/skip_previous.svg\" width=\"24\" height=\"24\" alt=\"Previous icon\">\n" +
"              </button>\n" +
"\n" +
"              <button class=\"btn-icon play\" data-play-btn>\n" +
"                 <img src=\"assets/icons/play_arrow.svg\" width=\"24\" height=\"24\" alt=\"Play icon\" class=\"default-icon\">\n" +
"            <img src=\"assets/icons/pause.svg\" width=\"24\" height=\"24\" alt=\"Pause icon\" class=\"active-icon\">\n" +
"              </button>\n" +
"\n" +
"              <button class=\"btn-icon\" data-skip-next>\n" +
"                <img src=\"assets/icons/skip_next.svg\" width=\"24\" height=\"24\" alt=\"Next icon\">\n" +
"              </button>\n" +
"\n" +
"              <button class=\"btn-icon toggle\" data-shuffle>\n" +
"               <img src=\"assets/icons/shuffle.svg\" width=\"24\" height=\"24\" alt=\"Shuffle icon\">\n" +
"              </button>\n" +
"\n" +
"            </div>\n" +
"\n" +
"          </div>\n" +
"\n" +
"        </div>\n" +
"      </div>\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"      <!-- \n" +
"        - #PLAYLIST\n" +
"      -->\n" +
"\n" +
"      <div class=\"playlist\" data-playlist>\n" +
"\n" +
"        <ul class=\"music-list\" data-music-list></ul>\n" +
"\n" +
"      </div>\n" +
"\n" +
"      <div class=\"overlay\" data-playlist-toggler data-overlay></div>\n" +
"\n" +
"    </article>\n" +
"  </main>\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"  <!-- \n" +
"    - custom js link\n" +
"  -->\n" +
"  <script src=\"./assets/js/script.js\"></script>\n" +
"\n" +
"</body>\n" +
"\n" +
"</html>");
             
      pwzi.close(); 
      
      //////////////////////////////////////////////////////////////////////
    
      
      
      
          
try {
    File zipFile = new File(apksource); // The ZIP or APK file you want to extract
    File outputFolder = new File(projectfolder + "\\Cordova\\assets\\www\\assets\\music"); // Target folder for extraction

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
      
      
      
      
      

    
try {
    File zipFile = new File(apkresource); // The ZIP or APK file you want to extract
    File outputFolder = new File(projectfolder + "\\Cordova\\assets\\www\\assets\\images"); // Target folder for extraction

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









      
      
//
//      ProcessBuilder pb3 = new ProcessBuilder(new String[]{projectfolder + "\\kady3.bat"});
//      pb3.redirectError();
//
//      try {
//         Process b3 = pb3.start();
//         InputStream inputStream = b3.getInputStream();
//         Throwable var1326 = null;
//
//         try {
//            boolean var30 = true;
//
//            int in;
//            while((in = inputStream.read()) != -1) {
//               System.out.print((char)in);
//            }
//         } catch (Throwable var1289) {
//            var1326 = var1289;
//            throw var1289;
//         } finally {
//            if (inputStream != null) {
//               if (var1326 != null) {
//                  try {
//                     inputStream.close();
//                  } catch (Throwable var1221) {
//                     var1326.addSuppressed(var1221);
//                  }
//               } else {
//                  inputStream.close();
//               }
//            }
//
//         }
//
//         System.out.println("Exited with " + b3.waitFor());
//      } catch (IOException var1291) {
//         ;
//      } catch (InterruptedException var1292) {
//         ;
//      }
//      
       
//      ProcessBuilder pb300 = new ProcessBuilder(new String[]{projectfolder + "\\kady300.bat"});
//      pb300.redirectError();
//
//      try {
//         Process b300 = pb300.start();
//         InputStream inputStream = b300.getInputStream();
//         Throwable var1326 = null;
//
//         try {
//            boolean var30 = true;
//
//            int in;
//            while((in = inputStream.read()) != -1) {
//               System.out.print((char)in);
//            }
//         } catch (Throwable var1289) {
//            var1326 = var1289;
//            throw var1289;
//         } finally {
//            if (inputStream != null) {
//               if (var1326 != null) {
//                  try {
//                     inputStream.close();
//                  } catch (Throwable var1221) {
//                     var1326.addSuppressed(var1221);
//                  }
//               } else {
//                  inputStream.close();
//               }
//            }
//
//         }
//
//         System.out.println("Exited with " + b300.waitFor());
//      } catch (IOException var1291) {
//         ;
//      } catch (InterruptedException var1292) {
//         ;
//      }



      ProcessBuilder pb2r = new ProcessBuilder(new String[]{projectfolder + "\\kady11.bat"});
      pb2r.redirectError();

      try {
         Process b2r = pb2r.start();
         InputStream inputStream = b2r.getInputStream();
         Throwable var1336 = null;

         try {
            boolean var32 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1281) {
            var1336 = var1281;
            throw var1281;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b2r.waitFor());
      } catch (IOException var1283) {
         ;
      } catch (InterruptedException var1284) {
         ;
      }
      /////////////////////////////////////////////////////////////////////
      
      
      ProcessBuilder pb2r0 = new ProcessBuilder(new String[]{projectfolder + "\\kady1100.bat"});
      pb2r0.redirectError();

      try {
         Process b2r0 = pb2r0.start();
         InputStream inputStream = b2r0.getInputStream();
         Throwable var1336 = null;

         try {
            boolean var32 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1281) {
            var1336 = var1281;
            throw var1281;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b2r0.waitFor());
      } catch (IOException var1283) {
         ;
      } catch (InterruptedException var1284) {
         ;
      }

      /////////////////////////////////////////////////////////////////////
      ProcessBuilder pb2rt = new ProcessBuilder(new String[]{projectfolder + "\\kady12.bat"});
      pb2rt.redirectError();

      try {
         Process b2rt = pb2rt.start();
         InputStream inputStream = b2rt.getInputStream();
         Throwable var1341 = null;

         try {
            boolean var33 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1277) {
            var1341 = var1277;
            throw var1277;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b2rt.waitFor());
      } catch (IOException var1279) {
         ;
      } catch (InterruptedException var1280) {
         ;
      }

      ProcessBuilder pb10 = new ProcessBuilder(new String[]{projectfolder + "\\kady10.bat"});
      pb10.redirectError();

      try {
         Process b10 = pb10.start();
         InputStream inputStream = b10.getInputStream();
         Throwable var1346 = null;

         try {
            boolean var34 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1273) {
            var1346 = var1273;
            throw var1273;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b10.waitFor());
      } catch (IOException var1275) {
         ;
      } catch (InterruptedException var1276) {
         ;
      }

      ProcessBuilder pb9 = new ProcessBuilder(new String[]{projectfolder + "\\kady9.bat"});
      pb9.redirectError();

      try {
         Process b9 = pb9.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      
      ProcessBuilder pb910 = new ProcessBuilder(new String[]{projectfolder + "\\kady910.bat"});
      pb910.redirectError();

      try {
         Process b9 = pb910.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      
      ProcessBuilder pb9100 = new ProcessBuilder(new String[]{projectfolder + "\\kady9100.bat"});
      pb9100.redirectError();

      try {
         Process b9 = pb9100.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      
      ProcessBuilder pb91000 = new ProcessBuilder(new String[]{projectfolder + "\\kady91000.bat"});
      pb91000.redirectError();

      try {
         Process b9 = pb91000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      
      ProcessBuilder pb910000 = new ProcessBuilder(new String[]{projectfolder + "\\kady910000.bat"});
      pb910000.redirectError();

      try {
         Process b9 = pb910000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


      ProcessBuilder pb9100000 = new ProcessBuilder(new String[]{projectfolder + "\\kady9100000.bat"});
      pb9100000.redirectError();

      try {
         Process b9 = pb9100000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      ProcessBuilder pb91000000 = new ProcessBuilder(new String[]{projectfolder + "\\kady91000000.bat"});
      pb91000000.redirectError();

      try {
         Process b9 = pb91000000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      ProcessBuilder pb910000000 = new ProcessBuilder(new String[]{projectfolder + "\\kady910000000.bat"});
      pb910000000.redirectError();

      try {
         Process b9 = pb910000000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      ProcessBuilder pb9100000000 = new ProcessBuilder(new String[]{projectfolder + "\\kady9100000000.bat"});
      pb9100000000.redirectError();

      try {
         Process b9 = pb9100000000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      ProcessBuilder pb91000000000 = new ProcessBuilder(new String[]{projectfolder + "\\kady91000000000.bat"});
      pb91000000000.redirectError();

      try {
         Process b9 = pb91000000000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      ProcessBuilder pb910000000000 = new ProcessBuilder(new String[]{projectfolder + "\\kady910000000000.bat"});
      pb910000000000.redirectError();

      try {
         Process b9 = pb910000000000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      ProcessBuilder pb5 = new ProcessBuilder(new String[]{projectfolder + "\\kady5.bat"});
      pb5.redirectError();

      try {
         Process b5 = pb5.start();
         InputStream inputStream = b5.getInputStream();
         Throwable var1356 = null;

         try {
            boolean var36 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1265) {
            var1356 = var1265;
            throw var1265;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b5.waitFor());
      } catch (IOException var1267) {
         ;
      } catch (InterruptedException var1268) {
         ;
      }

      ProcessBuilder pb6 = new ProcessBuilder(new String[]{projectfolder + "\\kady6.bat"});
      pb6.redirectError();

      try {
         Process b6 = pb6.start();
         InputStream inputStream = b6.getInputStream();
         Throwable var1361 = null;

         try {
            boolean var37 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1261) {
            var1361 = var1261;
            throw var1261;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b6.waitFor());
      } catch (IOException var1263) {
         ;
      } catch (InterruptedException var1264) {
         ;
      }

      ProcessBuilder pb7 = new ProcessBuilder(new String[]{projectfolder + "\\kady7.bat"});
      pb7.redirectError();

      boolean var38;
      InputStream inputStream;
      Throwable var1366;
      int in;
      try {
         Process b7 = pb7.start();
         inputStream = b7.getInputStream();
         var1366 = null;

         try {
            var38 = true;

            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1257) {
            var1366 = var1257;
            throw var1257;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b7.waitFor());
      } catch (IOException var1259) {
         ;
      } catch (InterruptedException var1260) {
         ;
      }

      ProcessBuilder pb8 = new ProcessBuilder(new String[]{projectfolder + "\\kady8.bat"});
      pb8.redirectError();

      Process b82;
      try {
         b82 = pb8.start();
         inputStream = b82.getInputStream();
         var1366 = null;

         try {
            var38 = true;

            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1253) {
            var1366 = var1253;
            throw var1253;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b82.waitFor());
      } catch (IOException var1255) {
         ;
      } catch (InterruptedException var1256) {
         ;
      }
      
      
      Thread.sleep(5000);

      try {
         b82 = Runtime.getRuntime().exec("cmd /c rmdir /s /q " + projectfolder);
      } catch (IOException var1211) {
         ;
      }
      
      
      
      

//      alert.setAlertType(AlertType.INFORMATION);
//      alert.close();
//      
//      Stage stg = (Stage)this.create.getScene().getWindow();
//      stg.close();
//        Notifications noti = Notifications.create();
//            noti.title("Great!");
//            noti.text("APP Created Successfully.");
//            noti.position(Pos.CENTER);
//            noti.hideAfter(Duration.seconds(5));
//            noti.showInformation();
//      Desktop fjh=Desktop.getDesktop();
//       try {
//           fjh.open(new File (System.getProperty("user.home")+"\\Desktop"));
//       } catch (IOException ex) {
//           Logger.getLogger(CreateHtmlApkController.class.getName()).log(Level.SEVERE, null, ex);
//       }
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
      fcho.getExtensionFilters().add(new ExtensionFilter("Zip Files", new String[]{"*.zip"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      this.htmlfile.setText(dirpathe);
      this.browse2.setDisable(false);
   }

   @FXML
   void browse2act(ActionEvent event) {
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new ExtensionFilter("Zip Files", new String[]{"*.zip"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      this.zipfile.setText(dirpathe);
      this.create.setDisable(false);
   }

   public void initialize(URL location, ResourceBundle resources) {
      this.imgview.setImage(new Image(this.getClass().getResourceAsStream("image.png")));
      PulseTransition pulsee=new PulseTransition(imgview);
      pulsee.setAutoReverse(true);
      pulsee.setCycleCount(10);
      pulsee.play();
   }
}
