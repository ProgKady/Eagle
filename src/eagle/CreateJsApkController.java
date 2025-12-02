package eagle;

import com.gluonhq.charm.glisten.animation.PulseTransition;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
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
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.controlsfx.control.Notifications;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CreateJsApkController implements Initializable {
   @FXML
   private ResourceBundle resources;
   @FXML
   private URL location;
   @FXML
   private JFXTextField zipfile;
   @FXML
   private Label pathlabel;
   @FXML
   private JFXTextField jsfile;
   @FXML
   private JFXTextField apkname;
   @FXML
   private JFXButton browse2;
   @FXML
   private JFXTextField packagename;
   @FXML
   private JFXButton browse1;
   @FXML
   private ImageView imgview;
   @FXML
   private JFXButton create;
   
   
    private ListView<String> permissionListView;
    private ComboBox<String> permissionComboBox;
    public static File manifestFile;
    private Document xmlDoc;

    private static final List<String> COMMON_PERMISSIONS = Arrays.asList(
            // Normal Permissions
            "android.permission.ACCESS_CACHE_FILESYSTEM",
            "android.permission.ACCESS_LOCATION_EXTRA_COMMANDS",
            "android.permission.ACCESS_NETWORK_STATE",
            "android.permission.ACCESS_WIFI_STATE",
            "android.permission.BATTERY_STATS",
            "android.permission.BLUETOOTH",
            "android.permission.BLUETOOTH_ADMIN",
            "android.permission.BROADCAST_STICKY",
            "android.permission.CHANGE_NETWORK_STATE",
            "android.permission.CHANGE_WIFI_MULTICAST_STATE",
            "android.permission.CHANGE_WIFI_STATE",
            "android.permission.EXPAND_STATUS_BAR",
            "android.permission.FOREGROUND_SERVICE",
            "android.permission.GET_ACCOUNTS",
            "android.permission.GET_PACKAGE_SIZE",
            "android.permission.INSTALL_SHORTCUT",
            "android.permission.INTERNET",
            "android.permission.KILL_BACKGROUND_PROCESSES",
            "android.permission.MANAGE_OWN_CALLS",
            "android.permission.NFC",
            "android.permission.READ_SYNC_SETTINGS",
            "android.permission.READ_SYNC_STATS",
            "android.permission.RECEIVE_BOOT_COMPLETED",
            "android.permission.REORDER_TASKS",
            "android.permission.REQUEST_COMPANION_RUN_IN_BACKGROUND",
            "android.permission.REQUEST_COMPANION_USE_DATA_IN_BACKGROUND",
            "android.permission.SET_WALLPAPER",
            "android.permission.SET_WALLPAPER_HINTS",
            "android.permission.VIBRATE",
            "android.permission.WAKE_LOCK",
            "android.permission.WRITE_SYNC_SETTINGS",
            // Dangerous (Runtime) Permissions
            "android.permission.ACCEPT_HANDOVER",
            "android.permission.ACCESS_COARSE_LOCATION",
            "android.permission.ACCESS_FINE_LOCATION",
            "android.permission.ACCESS_MEDIA_LOCATION",
            "android.permission.ACTIVITY_RECOGNITION",
            "android.permission.ADD_VOICEMAIL",
            "android.permission.ANSWER_PHONE_CALLS",
            "android.permission.BODY_SENSORS",
            "android.permission.CALL_PHONE",
            "android.permission.CAMERA",
            "android.permission.PROCESS_OUTGOING_CALLS",
            "android.permission.READ_CALENDAR",
            "android.permission.READ_CALL_LOG",
            "android.permission.READ_CONTACTS",
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.READ_PHONE_NUMBERS",
            "android.permission.READ_PHONE_STATE",
            "android.permission.READ_SMS",
            "android.permission.RECEIVE_MMS",
            "android.permission.RECEIVE_SMS",
            "android.permission.RECEIVE_WAP_PUSH",
            "android.permission.RECORD_AUDIO",
            "android.permission.SEND_SMS",
            "android.permission.USE_SIP",
            "android.permission.WRITE_CALENDAR",
            "android.permission.WRITE_CALL_LOG",
            "android.permission.WRITE_CONTACTS",
            "android.permission.WRITE_EXTERNAL_STORAGE",
            // Special Permissions
            "android.permission.SYSTEM_ALERT_WINDOW",
            "android.permission.WRITE_SETTINGS",
            "android.permission.REQUEST_INSTALL_PACKAGES",
            "android.permission.PACKAGE_USAGE_STATS",
            "android.permission.ACCESS_NOTIFICATIONS",
            // Signature Permissions
            "android.permission.ACCESS_CHECKIN_PROPERTIES",
            "android.permission.ACCOUNT_MANAGER",
            "android.permission.BIND_ACCESSIBILITY_SERVICE",
            "android.permission.BIND_APPWIDGET",
            "android.permission.BIND_CARRIER_SERVICES",
            "android.permission.BIND_DEVICE_ADMIN",
            "android.permission.BIND_DREAM_SERVICE",
            "android.permission.BIND_INCALL_SERVICE",
            "android.permission.BIND_INPUT_METHOD",
            "android.permission.BIND_NFC_SERVICE",
            "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE",
            "android.permission.BIND_PRINT_SERVICE",
            "android.permission.BIND_REMOTEVIEWS",
            "android.permission.BIND_TEXT_SERVICE",
            "android.permission.BIND_TV_INPUT",
            "android.permission.BIND_VOICE_INTERACTION",
            "android.permission.BIND_VPN_SERVICE",
            "android.permission.BIND_WALLPAPER",
            "android.permission.BLUETOOTH_PRIVILEGED",
            "android.permission.CAPTURE_AUDIO_OUTPUT",
            "android.permission.CHANGE_COMPONENT_ENABLED_STATE",
            "android.permission.CLEAR_APP_CACHE",
            "android.permission.CONTROL_LOCATION_UPDATES",
            "android.permission.DELETE_CACHE_FILES",
            "android.permission.DELETE_PACKAGES",
            "android.permission.DIAGNOSTIC",
            "android.permission.DUMP",
            "android.permission.FACTORY_TEST",
            "android.permission.FORCE_STOP_PACKAGES",
            "android.permission.GET_TASKS",
            "android.permission.GLOBAL_SEARCH",
            "android.permission.INSTALL_LOCATION_PROVIDER",
            "android.permission.INSTALL_PACKAGES",
            "android.permission.MANAGE_ACCOUNTS",
            "android.permission.MANAGE_APP_TOKENS",
            "android.permission.MASTER_CLEAR",
            "android.permission.MEDIA_CONTENT_CONTROL",
            "android.permission.MODIFY_AUDIO_SETTINGS",
            "android.permission.MODIFY_PHONE_STATE",
            "android.permission.MOUNT_UNMOUNT_FILESYSTEMS",
            "android.permission.READ_LOGS",
            "android.permission.REBOOT",
            "android.permission.SET_ANIMATION_SCALE",
            "android.permission.SET_DEBUG_APP",
            "android.permission.SET_PROCESS_LIMIT",
            "android.permission.SET_TIME",
            "android.permission.SET_TIME_ZONE",
            "android.permission.SIGNAL_PERSISTENT_PROCESSES",
            "android.permission.STATUS_BAR",
            "android.permission.UPDATE_DEVICE_STATS",
            "android.permission.WRITE_APN_SETTINGS",
            "android.permission.WRITE_SECURE_SETTINGS"
    );

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
   void createact(ActionEvent event) throws InterruptedException {
      String apknam = this.apkname.getText();
      String apkpkg = this.packagename.getText();
      String apkico = this.pathlabel.getText();
      String apksource = this.jsfile.getText();
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

      
      
      File projectfolder = new File(System.getProperty("user.home") + "\\appdata\\roaming\\JsProject");
      projectfolder.mkdir();

      try {
         Process var10 = Runtime.getRuntime().exec("cmd /c copy " + System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Native\\Simba_Kady_N.kady " + projectfolder + "\\Simba_Kady_N.apk");
         System.out.println("Copied APK");
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
         pw.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\apktool.bat d -f " + projectfolder + "\\Simba_Kady_N.apk -o " + projectfolder + "\\Simba_Kady_N");
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
         pwq.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\apktool.bat if " + projectfolder + "\\Simba_Kady_N.apk");
         pwq.close();
      } catch (IOException var1248) {
         ;
      }

      File htmlbat2 = new File(projectfolder + "\\kady3.bat");

      try {
         htmlbat2.createNewFile();
      } catch (IOException var1247) {
         ;
      }

      try {
         PrintWriter lcv = new PrintWriter(new FileWriter(htmlbat2));
         lcv.println("cd " + projectfolder + "\\Simba_Kady_N\\assets\\user");
         lcv.println("copy " + apksource + " " + projectfolder + "\\Simba_Kady_N\\assets\\user\\_main_.js");
         lcv.close();
      } catch (IOException var1246) {
         ;
      }

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
//         lcv.println("cd " + projectfolder + "\\Simba_Kady_N\\assets\\user");
//         lcv.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\7z.exe x -y " + apkresource);
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
         lcvv.println("cd " + projectfolder + "\\Simba_Kady_N\\res\\drawable");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Simba_Kady_N\\res\\drawable\\icon.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }

      File htmlbat111 = new File(projectfolder + "\\kady10.bat");

      try {
         htmlbat111.createNewFile();
      } catch (IOException var1241) {
         ;
      }

      try {
         PrintWriter lcvvv = new PrintWriter(new FileWriter(htmlbat111));
         lcvvv.println("cd " + projectfolder + "\\Simba_Kady_N\\res\\drawable-xhdpi");
         lcvvv.println("copy /Y " + apkico + " " + projectfolder + "\\Simba_Kady_N\\res\\drawable-xhdpi\\icon.png");
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
         pww.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\apktool.bat b -f " + projectfolder + "\\Simba_Kady_N");
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
         pwwu.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\zipalign.exe -v 4 " + projectfolder + "\\Simba_Kady_N\\dist\\Simba_Kady_N.apk " + projectfolder + "\\newApk.apk");
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

      File batfile66 = new File(projectfolder + "\\AndroidManifest.xml");

      try {
         batfile66.createNewFile();
      } catch (IOException var1231) {
         ;
      }

      try {
         PrintWriter pwwwwn = new PrintWriter(new FileWriter(batfile66));
         pwwwwn.println("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?><manifest xmlns:android=\"http://schemas.android.com/apk/res/android\" android:compileSdkVersion=\"34\" android:compileSdkVersionCodename=\"14\" android:installLocation=\"auto\" package=\"com.smartphoneremote.androidscriptfree\" platformBuildVersionCode=\"34\" platformBuildVersionName=\"14\">\n" +
"    <uses-feature android:name=\"android.hardware.location.gps\" android:required=\"false\"/>\n" +
"    <uses-feature android:name=\"android.hardware.location.network\" android:required=\"false\"/>\n" +
"    <uses-feature android:name=\"android.hardware.location\" android:required=\"false\"/>\n" +
"    <uses-feature android:name=\"android.hardware.camera\" android:required=\"false\"/>\n" +
"    <uses-feature android:name=\"android.hardware.camera.front\" android:required=\"false\"/>\n" +
"    <uses-feature android:name=\"android.hardware.camera.autofocus\" android:required=\"false\"/>\n" +
"    <uses-feature android:name=\"android.hardware.camera.front.autofocus\" android:required=\"false\"/>\n" +
"    <uses-feature android:name=\"android.hardware.telephony\" android:required=\"false\"/>\n" +
"    <uses-feature android:name=\"android.hardware.wifi\" android:required=\"false\"/>\n" +
"    <uses-feature android:name=\"android.hardware.bluetooth\" android:required=\"false\"/>\n" +
"    <uses-feature android:name=\"android.hardware.microphone\" android:required=\"false\"/>\n" +
"    <uses-feature android:name=\"android.hardware.usb.host\" android:required=\"false\"/>\n" +
"    <uses-feature android:name=\"android.hardware.nfc\" android:required=\"false\"/>\n" +
"    <uses-feature android:name=\"android.software.live_wallpaper\" android:required=\"false\"/>\n" +
"    <uses-feature android:name=\"android.software.leanback\" android:required=\"false\"/>\n" +
"    <uses-feature android:name=\"android.hardware.touchscreen\" android:required=\"false\"/>\n" +
"    <queries>\n" +
"        <intent>\n" +
"            <action android:name=\"android.support.customtabs.action.CustomTabsService\"/>\n" +
"        </intent>\n" +
"        <intent>\n" +
"            <action android:name=\"android.speech.RecognitionService\"/>\n" +
"        </intent>\n" +
"        <intent>\n" +
"            <action android:name=\"android.intent.action.TTS_SERVICE\"/>\n" +
"        </intent>\n" +
"        <intent>\n" +
"            <action android:name=\"com.android.vending.billing.InAppBillingService.BIND\"/>\n" +
"        </intent>\n" +
"    </queries>\n" +
"    <application android:appComponentFactory=\"androidx.core.app.CoreComponentFactory\" android:banner=\"@drawable/banner\" android:extractNativeLibs=\"true\" android:hardwareAccelerated=\"true\" android:hasFragileUserData=\"true\" android:icon=\"@drawable/icon\" android:label=\""+apknam+"\" android:largeHeap=\"true\" android:testOnly=\"false\" android:usesCleartextTraffic=\"true\">\n" +
"        <activity android:configChanges=\"keyboard|keyboardHidden|orientation|screenSize\" android:directBootAware=\"true\" android:exported=\"true\" android:label=\""+apknam+"\" android:launchMode=\"singleTask\" android:name=\"com.smartphoneremote.androidscriptfree.AndroidScriptFree\" android:theme=\"@style/AppTheme\" android:windowSoftInputMode=\"adjustPan\">\n" +
"            <intent-filter>\n" +
"                <action android:name=\"android.intent.action.MAIN\"/>\n" +
"                <category android:name=\"android.intent.category.LAUNCHER\"/>\n" +
"                <category android:name=\"android.intent.category._HOME\"/>\n" +
"                <category android:name=\"android.intent.category.DEFAULT\"/>\n" +
"            </intent-filter>\n" +
"            <meta-data android:name=\"android.hardware.usb.action.USB_DEVICE_ATTACHED\" android:resource=\"@xml/device_filter\"/>\n" +
"            <meta-data android:name=\"android.hardware.usb.action.USB_ACCESSORY_ATTACHED\" android:resource=\"@xml/accessory_filter\"/>\n" +
"        </activity>\n" +
"        <activity android:configChanges=\"keyboard|keyboardHidden|orientation|screenSize\" android:directBootAware=\"true\" android:exported=\"true\" android:label=\"New Activity\" android:launchMode=\"singleTask\" android:name=\"com.smartphoneremote.ioioscript.NewActivity\" android:process=\":NewActivityProcess\" android:taskAffinity=\"\" android:theme=\"@style/AppTheme\" android:windowSoftInputMode=\"adjustPan\">\n" +
"            <intent-filter>\n" +
"                <action android:name=\"android.intent.action.VIEW\"/>\n" +
"                <category android:name=\"android.intent.category.LAUNCHER\"/>\n" +
"            </intent-filter>\n" +
"        </activity>\n" +
"        <activity android:configChanges=\"keyboard|keyboardHidden|orientation|screenSize\" android:directBootAware=\"true\" android:exported=\"true\" android:label=\"Transparent Activity\" android:launchMode=\"singleTask\" android:name=\"com.smartphoneremote.ioioscript.TransActivity\" android:process=\":TransActivityProcess\" android:taskAffinity=\"\" android:theme=\"@style/Theme.Transparent\" android:windowSoftInputMode=\"adjustPan\">\n" +
"            <intent-filter>\n" +
"                <action android:name=\"android.intent.action.VIEW\"/>\n" +
"                <category android:name=\"android.intent.category.LAUNCHER\"/>\n" +
"            </intent-filter>\n" +
"        </activity>\n" +
"        <activity android:configChanges=\"keyboard|keyboardHidden|orientation|screenSize\" android:directBootAware=\"true\" android:exported=\"true\" android:label=\"User Activity\" android:launchMode=\"singleTask\" android:name=\"com.smartphoneremote.ioioscript.UserActivity\" android:process=\":UserActivityProcess\" android:theme=\"@style/AppTheme\" android:windowSoftInputMode=\"adjustPan\">\n" +
"            <intent-filter>\n" +
"                <action android:name=\"android.intent.action.VIEW\"/>\n" +
"                <category android:name=\"android.intent.category.LAUNCHER\"/>\n" +
"            </intent-filter>\n" +
"        </activity>\n" +
"        <activity android:configChanges=\"keyboard|keyboardHidden|orientation|screenSize\" android:directBootAware=\"true\" android:exported=\"true\" android:label=\"Chrome Activity\" android:launchMode=\"singleTask\" android:name=\"com.smartphoneremote.ioioscript.ChromeActivity\" android:theme=\"@style/AppTheme\" android:windowSoftInputMode=\"adjustPan\">\n" +
"            <intent-filter>\n" +
"                <action android:name=\"android.intent.action.VIEW\"/>\n" +
"                <category android:name=\"android.intent.category.LAUNCHER\"/>\n" +
"            </intent-filter>\n" +
"        </activity>\n" +
"        <activity android:exported=\"true\" android:label=\"IOIOScript/ListViewAct\" android:name=\"com.smartphoneremote.ioioscript.ListViewAct\"/>\n" +
"        <activity android:exported=\"true\" android:label=\"IOIOScript\" android:name=\"com.smartphoneremote.ioioscript.NotifyClickAct\" android:theme=\"@android:style/Theme.Dialog\"/>\n" +
"        <activity android:configChanges=\"keyboard|keyboardHidden|orientation|screenSize\" android:exported=\"true\" android:label=\"@string/select_device\" android:name=\"com.smartphoneremote.ioioscript.DeviceListActivity\" android:theme=\"@android:style/Theme.Dialog\"/>\n" +
"        <meta-data android:name=\"com.google.android.gms.version\" android:value=\"11020000\"/>\n" +
"        <service android:exported=\"true\" android:foregroundServiceType=\"0x00000008\" android:icon=\"@drawable/icon\" android:label=\"DroidScript Service\" android:name=\"com.smartphoneremote.droidscript.ScriptService\" android:process=\":droidscript_service\"/>\n" +
"        <receiver android:exported=\"true\" android:name=\"com.smartphoneremote.ioioscript.MyServiceStarter\">\n" +
"            <intent-filter>\n" +
"                <action android:name=\"android.intent.action.BOOT_COMPLETED\"/>\n" +
"            </intent-filter>\n" +
"        </receiver>\n" +
"        <receiver android:exported=\"true\" android:name=\"com.smartphoneremote.ioioscript.AlarmReceiver\"/>\n" +
"        <provider android:authorities=\"com.kady.simba_kady_n.file.provider\" android:exported=\"false\" android:grantUriPermissions=\"true\" android:name=\"androidx.core.content.FileProvider\">\n" +
"            <meta-data android:name=\"android.support.FILE_PROVIDER_PATHS\" android:resource=\"@xml/file_paths\"/>\n" +
"        </provider>\n" +
"        <meta-data android:name=\"com.google.android.play.billingclient.version\" android:value=\"6.0.1\"/>\n" +
"        <activity android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|screenSize\" android:exported=\"false\" android:name=\"com.android.billingclient.api.ProxyBillingActivity\" android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"/>\n" +
"        <service android:exported=\"false\" android:name=\"com.google.android.datatransport.runtime.backends.TransportBackendDiscovery\">\n" +
"            <meta-data android:name=\"backend:com.google.android.datatransport.cct.CctBackendFactory\" android:value=\"cct\"/>\n" +
"        </service>\n" +
"        <service android:exported=\"false\" android:name=\"com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService\" android:permission=\"android.permission.BIND_JOB_SERVICE\"/>\n" +
"        <receiver android:exported=\"false\" android:name=\"com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver\"/>\n" +
"    </application>\n" +
"</manifest>");
                 pwwwwn.close();
      } catch (IOException var1230) {
         ;
      }

      File batfile666 = new File(projectfolder + "\\apktool.yml");

      try {
         batfile666.createNewFile();
      } catch (IOException var1229) {
         ;
      }

      try {
         PrintWriter pwwwwnx = new PrintWriter(new FileWriter(batfile666));
         pwwwwnx.println("!!brut.androlib.meta.MetaInfo\n" +
"apkFileName: Simba_Kady_N.apk\n" +
"compressionType: false\n" +
"doNotCompress:\n" +
"- arsc\n" +
"- png\n" +
"- mp3\n" +
"- res/-8.9.png\n" +
"- res/-q.9.png\n" +
"- res/-z.9.png\n" +
"- res/09.9.png\n" +
"- res/0e.9.png\n" +
"- res/0H.9.png\n" +
"- res/2C.9.png\n" +
"- res/2Q.9.png\n" +
"- res/33.9.png\n" +
"- res/4_.9.png\n" +
"- res/5j.9.png\n" +
"- res/5z.9.png\n" +
"- res/6W.9.png\n" +
"- res/6w.9.png\n" +
"- res/71.9.png\n" +
"- res/72.9.png\n" +
"- res/7F.9.png\n" +
"- res/7P.9.png\n" +
"- res/7T.9.png\n" +
"- res/7T1.9.png\n" +
"- res/7V.9.png\n" +
"- res/8V.9.png\n" +
"- res/8w.9.png\n" +
"- res/93.9.png\n" +
"- res/9X.9.png\n" +
"- res/AA.9.png\n" +
"- res/AB.9.png\n" +
"- res/Ac.9.png\n" +
"- res/AP.9.png\n" +
"- res/au.9.png\n" +
"- res/bK.9.png\n" +
"- res/bu.9.png\n" +
"- res/c-.9.png\n" +
"- res/CA.9.png\n" +
"- res/ca.9.png\n" +
"- res/Cg.9.png\n" +
"- res/cM.9.png\n" +
"- res/d1.9.png\n" +
"- res/dH.9.png\n" +
"- res/DT.9.png\n" +
"- res/Dt.9.png\n" +
"- res/dv.9.png\n" +
"- res/E2.9.png\n" +
"- res/e4.9.png\n" +
"- res/ea.9.png\n" +
"- res/Eb.9.png\n" +
"- res/eB.9.png\n" +
"- res/Ec.9.png\n" +
"- res/ei.9.png\n" +
"- res/eK.9.png\n" +
"- res/ER.9.png\n" +
"- res/F2.9.png\n" +
"- res/F8.9.png\n" +
"- res/fD.9.png\n" +
"- res/FM.9.png\n" +
"- res/fr.9.png\n" +
"- res/fv.9.png\n" +
"- res/Fx.9.png\n" +
"- res/Fx1.9.png\n" +
"- res/fZ.9.png\n" +
"- res/Gb.9.png\n" +
"- res/gb.9.png\n" +
"- res/gG.9.png\n" +
"- res/gL.9.png\n" +
"- res/gL1.9.png\n" +
"- res/Gu.9.png\n" +
"- res/gV.9.png\n" +
"- res/h0.9.png\n" +
"- res/hj.9.png\n" +
"- res/hO.9.png\n" +
"- res/hq.9.png\n" +
"- res/HS.9.png\n" +
"- res/ii.9.png\n" +
"- res/In.9.png\n" +
"- res/IO.9.png\n" +
"- res/j-.9.png\n" +
"- res/J6.9.png\n" +
"- res/J8.9.png\n" +
"- res/j9.9.png\n" +
"- res/jh.9.png\n" +
"- res/jK.9.png\n" +
"- res/jV.9.png\n" +
"- res/kK.9.png\n" +
"- res/Kp.9.png\n" +
"- res/Kv.9.png\n" +
"- res/kW.9.png\n" +
"- res/La.9.png\n" +
"- res/ld.9.png\n" +
"- res/LJ.9.png\n" +
"- res/Ll.9.png\n" +
"- res/Lq.9.png\n" +
"- res/m9.9.png\n" +
"- res/Ml.9.png\n" +
"- res/Mr.9.png\n" +
"- res/Mz.9.png\n" +
"- res/n9.9.png\n" +
"- res/NM.9.png\n" +
"- res/NP.9.png\n" +
"- res/O3.9.png\n" +
"- res/Of.9.png\n" +
"- res/Of1.9.png\n" +
"- res/oP.9.png\n" +
"- res/oR.9.png\n" +
"- res/OU.9.png\n" +
"- res/pF.9.png\n" +
"- res/Pi.9.png\n" +
"- res/Pq.9.png\n" +
"- res/pS.9.png\n" +
"- res/Q1.9.png\n" +
"- res/Q11.9.png\n" +
"- res/QD.9.png\n" +
"- res/qr.9.png\n" +
"- res/rb.9.png\n" +
"- res/Rs.9.png\n" +
"- res/s2.9.png\n" +
"- res/sA.9.png\n" +
"- res/sL.9.png\n" +
"- res/sm.9.png\n" +
"- res/Sn.9.png\n" +
"- res/st.9.png\n" +
"- res/sv.9.png\n" +
"- res/T2.9.png\n" +
"- res/TF.9.png\n" +
"- res/tj.9.png\n" +
"- res/Tl.9.png\n" +
"- res/Tl1.9.png\n" +
"- res/tM.9.png\n" +
"- res/tr.9.png\n" +
"- res/uB.9.png\n" +
"- res/UE.9.png\n" +
"- res/Uj.9.png\n" +
"- res/Us.9.png\n" +
"- res/V-.9.png\n" +
"- res/V-1.9.png\n" +
"- res/v3.9.png\n" +
"- res/v6.9.png\n" +
"- res/VK.9.png\n" +
"- res/vy.9.png\n" +
"- res/wi.9.png\n" +
"- res/wi1.9.png\n" +
"- res/wK.9.png\n" +
"- res/wL.9.png\n" +
"- res/ws.9.png\n" +
"- res/X3.9.png\n" +
"- res/x5.9.png\n" +
"- res/X7.9.png\n" +
"- res/Xp.9.png\n" +
"- res/Xs.9.png\n" +
"- res/Xs1.9.png\n" +
"- res/YH.9.png\n" +
"- res/yO.9.png\n" +
"- res/yR.9.png\n" +
"- res/Yt.9.png\n" +
"- res/zz.9.png\n" +
"- res/_6.9.png\n" +
"isFrameworkApk: false\n" +
"packageInfo:\n" +
"  forcedPackageId: '127'\n" +
"  renameManifestPackage: com."+apkpkg+".simba_kady_n\n" +
"sdkInfo:\n" +
"  minSdkVersion: '23'\n" +
"  targetSdkVersion: '34'\n" +
"sharedLibrary: false\n" +
"sparseResources: false\n" +
"unknownFiles:\n" +
"  billing.properties: '8'\n" +
"  dsn.mf: '8'\n" +
"  firebase-encoders-json.properties: '8'\n" +
"  firebase-encoders-proto.properties: '8'\n" +
"  firebase-encoders.properties: '8'\n" +
"  javamail.charset.map: '8'\n" +
"  javamail.default.address.map: '8'\n" +
"  javamail.default.providers: '8'\n" +
"  javamail.imap.provider: '8'\n" +
"  javamail.pop3.provider: '8'\n" +
"  javamail.smtp.address.map: '8'\n" +
"  javamail.smtp.provider: '8'\n" +
"  jetty-dir.css: '8'\n" +
"  mailcap: '8'\n" +
"  mailcap.default: '8'\n" +
"  mimetypes.default: '8'\n" +
"  transport-api.properties: '8'\n" +
"  transport-backend-cct.properties: '8'\n" +
"  transport-runtime.properties: '8'\n" +
"  com/sun/mail/dsn/mailcap: '8'\n" +
"  javax/servlet/LocalStrings.properties: '8'\n" +
"  javax/servlet/LocalStrings_fr.properties: '8'\n" +
"  javax/servlet/LocalStrings_ja.properties: '8'\n" +
"  javax/servlet/http/LocalStrings.properties: '8'\n" +
"  javax/servlet/http/LocalStrings_es.properties: '8'\n" +
"  javax/servlet/http/LocalStrings_fr.properties: '8'\n" +
"  javax/servlet/http/LocalStrings_ja.properties: '8'\n" +
"  javax/servlet/resources/datatypes.dtd: '8'\n" +
"  javax/servlet/resources/j2ee_1_4.xsd: '8'\n" +
"  javax/servlet/resources/j2ee_web_services_1_1.xsd: '8'\n" +
"  javax/servlet/resources/j2ee_web_services_client_1_1.xsd: '8'\n" +
"  javax/servlet/resources/javaee_5.xsd: '8'\n" +
"  javax/servlet/resources/javaee_6.xsd: '8'\n" +
"  javax/servlet/resources/javaee_web_services_1_2.xsd: '8'\n" +
"  javax/servlet/resources/javaee_web_services_1_3.xsd: '8'\n" +
"  javax/servlet/resources/javaee_web_services_client_1_2.xsd: '8'\n" +
"  javax/servlet/resources/javaee_web_services_client_1_3.xsd: '8'\n" +
"  javax/servlet/resources/web-app_2_2.dtd: '8'\n" +
"  javax/servlet/resources/web-app_2_3.dtd: '8'\n" +
"  javax/servlet/resources/web-app_2_4.xsd: '8'\n" +
"  javax/servlet/resources/web-app_2_5.xsd: '8'\n" +
"  javax/servlet/resources/web-app_3_0.xsd: '8'\n" +
"  javax/servlet/resources/web-common_3_0.xsd: '8'\n" +
"  javax/servlet/resources/web-fragment_3_0.xsd: '8'\n" +
"  javax/servlet/resources/xml.xsd: '8'\n" +
"  javax/servlet/resources/XMLSchema.dtd: '8'\n" +
"  org/apache/harmony/awt/internal/nls/messages.properties: '8'\n" +
"  org/eclipse/jetty/favicon.ico: '8'\n" +
"  org/eclipse/jetty/http/encoding.properties: '8'\n" +
"  org/eclipse/jetty/http/mime.properties: '8'\n" +
"  org/eclipse/jetty/http/useragents: '8'\n" +
"  org/eclipse/jetty/server/handler/jmx/AbstractHandler-mbean.properties: '8'\n" +
"  org/eclipse/jetty/server/handler/jmx/ContextHandler-mbean.properties: '8'\n" +
"  org/eclipse/jetty/server/handler/jmx/ContextHandlerCollection-mbean.properties: '8'\n" +
"  org/eclipse/jetty/server/handler/jmx/HandlerCollection-mbean.properties: '8'\n" +
"  org/eclipse/jetty/server/handler/jmx/HandlerWrapper-mbean.properties: '8'\n" +
"  org/eclipse/jetty/server/handler/jmx/StatisticsHandler-mbean.properties: '8'\n" +
"  org/eclipse/jetty/server/jmx/AbstractConnector-mbean.properties: '8'\n" +
"  org/eclipse/jetty/server/jmx/Connector-mbean.properties: '8'\n" +
"  org/eclipse/jetty/server/jmx/Handler-mbean.properties: '8'\n" +
"  org/eclipse/jetty/server/jmx/HandlerContainer-mbean.properties: '8'\n" +
"  org/eclipse/jetty/server/jmx/NCSARequestLog-mbean.properties: '8'\n" +
"  org/eclipse/jetty/server/jmx/Server-mbean.properties: '8'\n" +
"  org/eclipse/jetty/server/nio/jmx/SelectChannelConnector-mbean.properties: '8'\n" +
"  org/eclipse/jetty/server/session/jmx/AbstractSessionManager-mbean.properties: '8'\n" +
"  org/eclipse/jetty/servlet/jmx/FilterMapping-mbean.properties: '8'\n" +
"  org/eclipse/jetty/servlet/jmx/Holder-mbean.properties: '8'\n" +
"  org/eclipse/jetty/servlet/jmx/ServletContextHandler-mbean.properties: '8'\n" +
"  org/eclipse/jetty/servlet/jmx/ServletHandler-mbean.properties: '8'\n" +
"  org/eclipse/jetty/servlet/jmx/ServletHolder-mbean.properties: '8'\n" +
"  org/eclipse/jetty/servlet/jmx/ServletMapping-mbean.properties: '8'\n" +
"usesFramework:\n" +
"  ids:\n" +
"  - 1\n" +
"  tag: null\n" +
"version: 2.3.4\n" +
"versionInfo:\n" +
"  versionCode: '100'\n" +
"  versionName: '1.00'");
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
         pwwwwm.println("copy /Y " + projectfolder + "\\AndroidManifest.xml " + projectfolder + "\\Simba_Kady_N\\AndroidManifest.xml");
         pwwwwm.close();
      } catch (IOException var1226) {
         ;
      }

      File batfile655 = new File(projectfolder + "\\kady12.bat");

      try {
         batfile655.createNewFile();
      } catch (IOException var1225) {
         ;
      }

      try {
         PrintWriter pwwwwmmm = new PrintWriter(new FileWriter(batfile655));
         pwwwwmmm.println("copy /Y " + projectfolder + "\\apktool.yml " + projectfolder + "\\Simba_Kady_N\\apktool.yml");
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

      ProcessBuilder pb3 = new ProcessBuilder(new String[]{projectfolder + "\\kady3.bat"});
      pb3.redirectError();

      try {
         Process b3 = pb3.start();
         InputStream inputStream = b3.getInputStream();
         Throwable var1326 = null;

         try {
            boolean var30 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1289) {
            var1326 = var1289;
            throw var1289;
         } finally {
            if (inputStream != null) {
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

         }

         System.out.println("Exited with " + b3.waitFor());
      } catch (IOException var1291) {
         ;
      } catch (InterruptedException var1292) {
         ;
      }
      
      
      
      
      
try {
    File zipFile = new File(apkresource); // The ZIP or APK file you want to extract
    File outputFolder = new File(projectfolder + "\\Simba_Kady_N\\assets\\user"); // Target folder for extraction

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
//      ProcessBuilder pb4 = new ProcessBuilder(new String[]{projectfolder + "\\kady4.bat"});
//      pb4.redirectError();
//
//      try {
//         Process b4 = pb4.start();
//         InputStream inputStream = b4.getInputStream();
//         Throwable var1331 = null;
//
//         try {
//            boolean var31 = true;
//
//            int in;
//            while((in = inputStream.read()) != -1) {
//               System.out.print((char)in);
//            }
//         } catch (Throwable var1285) {
//            var1331 = var1285;
//            throw var1285;
//         } finally {
//            if (inputStream != null) {
//               if (var1331 != null) {
//                  try {
//                     inputStream.close();
//                  } catch (Throwable var1220) {
//                     var1331.addSuppressed(var1220);
//                  }
//               } else {
//                  inputStream.close();
//               }
//            }
//
//         }
//
//         System.out.println("Exited with " + b4.waitFor());
//      } catch (IOException var1287) {
//         ;
//      } catch (InterruptedException var1288) {
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
      
      
      
      
      
       // At this point, we need user input
      CountDownLatch latch = new CountDownLatch(1);
      final String[] userInput = new String[1];
      
        Platform.runLater(() -> {
        try {
            manifestFile=new File (projectfolder + "\\Simba_Kady_N\\AndroidManifest.xml");
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setNamespaceAware(true); // for android:name attribute
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            xmlDoc = dBuilder.parse(projectfolder + "\\Simba_Kady_N\\AndroidManifest.xml");
            xmlDoc.getDocumentElement().normalize();
            updatePermissionList();
        } catch (Exception ex) {
            //showAlert("Error", "Failed to load manifest: " + ex.getMessage());
        }    
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        permissionListView = new ListView<>();
        permissionComboBox = new ComboBox<>();
        permissionComboBox.getItems().addAll(COMMON_PERMISSIONS);
        permissionComboBox.setEditable(true);
        Stage ewew=new Stage ();
        JFXButton addButton = new JFXButton("Add Permission");
        JFXButton removeButton = new JFXButton("Remove Selected");
        HBox controlBox = new HBox(10, permissionComboBox, addButton, removeButton);
        VBox root = new VBox(10, permissionListView, controlBox);
        root.setMinSize(700, 400);
        root.setPadding(new Insets(10));
        addButton.setOnAction(e -> addPermission());
        removeButton.setOnAction(e -> removeSelectedPermission());
        //ewew.show();
      Alert laa=new Alert (Alert.AlertType.INFORMATION);
      laa.setHeaderText("");
      laa.setTitle("Permissions Control");
      laa.setResizable(true);
      laa.setContentText("");
      laa.setGraphic(root);
      laa.getDialogPane().getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      laa.showAndWait();
      //////////////////////////////////////////////////////////////////////////////////////////////////
      latch.countDown(); // Resume task
      });
      latch.await(); // Wait until user responds
      
      
      
      ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
       String basePath = projectfolder + "\\Simba_Kady_N\\res\\values";
       File publicXml = new File(basePath, "public.xml");
        Set<String> definedArrayNames = new HashSet<>();
        File[] valueFiles = new File(basePath).listFiles((dir, name) -> name.endsWith(".xml") && !name.equals("public.xml"));
        for (File file : valueFiles) {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            NodeList nodes = doc.getDocumentElement().getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    String tag = node.getNodeName();
                    if (tag.equals("array") || tag.equals("string-array") || tag.equals("integer-array")) {
                        Element element = (Element) node;
                        if (element.hasAttribute("name")) {
                            definedArrayNames.add(element.getAttribute("name"));
                        }
                    }
                }
            }
        }
        Document publicDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(publicXml);
        NodeList publicItems = publicDoc.getDocumentElement().getElementsByTagName("public");
        List<Node> toRemove = new ArrayList<>();
        for (int i = 0; i < publicItems.getLength(); i++) {
            Element item = (Element) publicItems.item(i);
            String type = item.getAttribute("type");
            String name = item.getAttribute("name");
            if ((type.equals("array") || type.equals("string-array") || type.equals("integer-array"))
                    && !definedArrayNames.contains(name)) {
                toRemove.add(item);
            }
        }
        for (Node node : toRemove) {
            node.getParentNode().removeChild(node);
        }

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(publicDoc), new StreamResult(publicXml));
        System.out.println("Removed from" + toRemove.size() + " public.xml");
        
        ////////////////////
        
        String manifestPath = projectfolder + "\\Simba_Kady_N\\AndroidManifest.xml";
        File xmlFile = new File(manifestPath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        Document doc = dbFactory.newDocumentBuilder().parse(xmlFile);
        doc.getDocumentElement().normalize();
        
        NodeList appList = doc.getElementsByTagName("application");
        if (appList.getLength() > 0) {
            Element app = (Element) appList.item(0);
            if (app.hasAttribute("android:hasFragileUserData")) {
                app.removeAttribute("android:hasFragileUserData");
                System.out.println("? Removed 'hasFragileUserData'");
            }
        }
        NodeList services = doc.getElementsByTagName("service");
        for (int i = 0; i < services.getLength(); i++) {
            Element service = (Element) services.item(i);
            if (service.hasAttribute("android:foregroundServiceType")) {
                service.removeAttribute("android:foregroundServiceType");
                System.out.println("? Removed 'foregroundServiceType'");
            }
        }
        Transformer transformerr = TransformerFactory.newInstance().newTransformer();
        transformerr.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(xmlFile);
        transformerr.transform(source, result);
        System.out.println("Manifest fixed and saved.");
        
      
      ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

//      ProcessBuilder pb9 = new ProcessBuilder(new String[]{projectfolder + "\\kady9.bat"});
//      pb9.redirectError();
//
//      try {
//         Process b9 = pb9.start();
//         InputStream inputStream = b9.getInputStream();
//         Throwable var1346 = null;
//
//         try {
//            boolean var34 = true;
//
//            int in;
//            while((in = inputStream.read()) != -1) {
//               System.out.print((char)in);
//            }
//         } catch (Throwable var1273) {
//            var1346 = var1273;
//            throw var1273;
//         } finally {
//            if (inputStream != null) {
//               if (var1346 != null) {
//                  try {
//                     inputStream.close();
//                  } catch (Throwable var1217) {
//                     var1346.addSuppressed(var1217);
//                  }
//               } else {
//                  inputStream.close();
//               }
//            }
//
//         }
//
//         System.out.println("Exited with " + b9.waitFor());
//      } catch (IOException var1275) {
//         ;
//      } catch (InterruptedException var1276) {
//         ;
//      }

      ProcessBuilder pb10 = new ProcessBuilder(new String[]{projectfolder + "\\kady10.bat"});
      pb10.redirectError();

      try {
         Process b10 = pb10.start();
         InputStream inputStream = b10.getInputStream();
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

         System.out.println("Exited with " + b10.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

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
//      Stage stg = (Stage)this.create.getScene().getWindow();
//      stg.close();
//      
//      
//           Notifications noti = Notifications.create();
//            noti.title("Great!");
//            noti.text("APP Created Successfully.");
//            noti.position(Pos.CENTER);
//            noti.hideAfter(Duration.seconds(5));
//            noti.showInformation();
//      
//      
//      
//      Desktop fjh=Desktop.getDesktop();
//       try {
//           fjh.open(new File (System.getProperty("user.home")+"\\Desktop"));
//       } catch (IOException ex) {
//         }
       
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
      fcho.getExtensionFilters().add(new ExtensionFilter("JavaScript Files", new String[]{"*.js"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      this.jsfile.setText(dirpathe);
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
   
   
   
   private void loadManifest(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open AndroidManifest.xml");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("XML Files", "*.xml")
        );

        manifestFile = fileChooser.showOpenDialog(stage);
        if (manifestFile == null) return;

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setNamespaceAware(true); // for android:name attribute
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            xmlDoc = dBuilder.parse(manifestFile);
            xmlDoc.getDocumentElement().normalize();
            updatePermissionList();
        } catch (Exception ex) {
            showAlert("Error", "Failed to load manifest: " + ex.getMessage());
        }
    }

    private void updatePermissionList() {
        permissionListView.getItems().clear();
        NodeList nodes = xmlDoc.getElementsByTagName("uses-permission");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);
            String permission = element.getAttribute("android:name");
            if (!permission.isEmpty()) {
                permissionListView.getItems().add(permission);
            }
        }
    }

    private void addPermission() {
        if (xmlDoc == null || manifestFile == null) return;

        String permission = permissionComboBox.getEditor().getText();
        if (permission == null || permission.trim().isEmpty()) return;

        if (permissionListView.getItems().contains(permission)) {
            showAlert("Info", "Permission already exists.");
            return;
        }

        Element newPerm = xmlDoc.createElement("uses-permission");
        newPerm.setAttribute("android:name", permission);

        Node manifestNode = xmlDoc.getDocumentElement();
        Node applicationNode = getFirstChildByName(manifestNode, "application");

        if (applicationNode != null) {
            manifestNode.insertBefore(newPerm, applicationNode);
        } else {
            manifestNode.appendChild(newPerm);
        }

        saveManifest();
        updatePermissionList();
    }

    private void removeSelectedPermission() {
        if (xmlDoc == null || manifestFile == null) return;

        String selectedPermission = permissionListView.getSelectionModel().getSelectedItem();
        if (selectedPermission == null) return;

        NodeList nodes = xmlDoc.getElementsByTagName("uses-permission");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);
            if (selectedPermission.equals(element.getAttribute("android:name"))) {
                xmlDoc.getDocumentElement().removeChild(element);
                break;
            }
        }

        saveManifest();
        updatePermissionList();
    }

    private Node getFirstChildByName(Node parent, String name) {
        NodeList children = parent.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (name.equals(child.getNodeName())) {
                return child;
            }
        }
        return null;
    }

    private void saveManifest() {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(xmlDoc);
            StreamResult result = new StreamResult(manifestFile);
            transformer.transform(source, result);
        } catch (Exception e) {
            showAlert("Error", "Failed to save manifest: " + e.getMessage());
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
   
   
   
   
   

   public void initialize(URL location, ResourceBundle resources) {
      this.imgview.setImage(new Image(this.getClass().getResourceAsStream("image.png")));
      PulseTransition pulsee=new PulseTransition(imgview);
      pulsee.setAutoReverse(true);
      pulsee.setCycleCount(10);
      pulsee.play();
   }
}