package eagle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.sandsoft.acefx.AceEditor;


public class CreateJsProjectController implements Initializable {
   @FXML
   private ResourceBundle resources;
   @FXML
   private URL location;
   @FXML
   private JFXButton create;
   @FXML
   private JFXTextField proname;
   @FXML
   private JFXTextField prodes;
   @FXML
   private JFXButton browse;
   static String ProjName1;
   static String ProgDer1;
   public static File f1;
   public static File f2;
   public static File f3;

   @FXML
   void createact(ActionEvent event) {
      ProjName1 = this.proname.getText();
      ProgDer1 = this.prodes.getText();
      File fg = new File(ProgDer1 + "\\" + ProjName1);
      fg.mkdir();
      f1 = new File(ProgDer1 + "\\" + ProjName1 + "\\Main.js");

      try {
         f1.createNewFile();
      } catch (IOException var5) {
         ;
      }

      Stage stge = (Stage)this.create.getScene().getWindow();
      stge.close();
      
      
      org.sandsoft.tests.Main min=new org.sandsoft.tests.Main();
       try {
           min.start(stge);
           
           
           //   JsEditor edit = new JsEditor();
           //  edit.js_Editor();
       } catch (IOException ex) {
           Logger.getLogger(CreateJsProjectController.class.getName()).log(Level.SEVERE, null, ex);
       }
      // String FullPathh = CreateJsProjectController.f1.toString();
      
        
   }

   @FXML
   void browseact(ActionEvent event) {
      DirectoryChooser dcho = new DirectoryChooser();
      dcho.setInitialDirectory(new File(System.getProperty("user.home") + "/desktop"));
      dcho.setTitle("Kady Directory");
      File f = dcho.showDialog((Window)null);
      String dirpath = f.getAbsolutePath().toString();
      this.prodes.setText(dirpath);
      this.create.setDisable(false);
   }

   public void initialize(URL location, ResourceBundle resources) {
       
   }
}