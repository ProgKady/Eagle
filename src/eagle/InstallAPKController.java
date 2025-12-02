package eagle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;

public class InstallAPKController {
   @FXML
   private ResourceBundle resources;
   @FXML
   private URL location;
   @FXML
   private JFXTextField pathtoapk;
   @FXML
   private JFXButton brobtn;
   @FXML
   private JFXButton instalbtn;

   @FXML
   void browseapk(ActionEvent event) {
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new ExtensionFilter("APK Files", new String[]{"*.apk"}));
      fcho.setInitialDirectory(new File(System.getProperty("user.home") + "\\Desktop"));
      fcho.setTitle("Choose APK...");
      File ff = fcho.showOpenDialog((Window)null);
      String pathtoicon = ff.getAbsolutePath().toString();
      this.instalbtn.setDisable(false);
      this.pathtoapk.setText(pathtoicon);
      this.brobtn.setDisable(true);
   }

   @FXML
   void installapk(ActionEvent event) {
      this.instalbtn.setText("Installing...");
      this.instalbtn.setDisable(true);
      String apkpat = this.pathtoapk.getText();
      if (apkpat.contains(" ")) {
         Alert al = new Alert(AlertType.ERROR);
         al.setTitle("APK Error!");
         al.setContentText("Please select another APK file without spaces in its name.");
         al.showAndWait();
      } else {
         String up = System.getProperty("user.home");
         File hhg = new File(up + "/comand.bat");
         if (hhg.exists()) {
            hhg.delete();
         } else {
            try {
               hhg.createNewFile();
            } catch (IOException var10) {
               ;
            }
         }

         try {
            hhg.createNewFile();
         } catch (IOException var9) {
            ;
         }

         try {
            PrintWriter pwn = new PrintWriter(new FileWriter(hhg));
            pwn.write(up + "\\AppData\\Roaming\\resources\\data\\adb.exe install " + this.pathtoapk.getText());
            pwn.close();
         } catch (IOException var8) {
            ;
         }

         try {
            Process p = Runtime.getRuntime().exec("cmd /c start /B " + hhg);
            p.waitFor();
         } catch (IOException var6) {
            
         } catch (InterruptedException var7) {
            
         }

         
         Stage stg = (Stage)this.instalbtn.getScene().getWindow();
      }
      this.instalbtn.setText("Install");
      this.instalbtn.setDisable(false);
   }

   @FXML
   void initialize() {
   }
}