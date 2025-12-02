package eagle;

import com.gluonhq.charm.glisten.animation.PulseTransition;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import static eagle.HTMLEditor.app_theme;
import static eagle.HTMLEditor.codearea_color;
import static eagle.HTMLEditor.codearea_syntax;
import static eagle.HTMLEditor.font_size;
import static eagle.HTMLEditor.font_sizee;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;

public class CreateHtmlProjectController implements Initializable {
   @FXML
   private ResourceBundle resources;
   @FXML
   private URL location;
   @FXML
   private Label pathlabel;
   @FXML
   private ImageView imgview;
   @FXML
   private JFXButton create;
   @FXML
   private JFXTextField proname;
   @FXML
   private JFXTextField prodes;
   @FXML
   private JFXButton browse;
   static String IconPath;
   static String ProjName;
   static String ProgDer;
   static File f1;
   static File f2;
   static File f3;

   @FXML
   void imgviewact(MouseEvent event) {
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new ExtensionFilter("Image Files", new String[]{"*.png"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      this.imgview.setImage(new Image((new File(dirpathe)).toURI().toString()));
      this.pathlabel.setText(dirpathe);
      this.browse.setDisable(false);
   }

   @FXML
   void createact(ActionEvent event) {
      IconPath = this.pathlabel.getText();
      ProjName = this.proname.getText();
      ProgDer = this.prodes.getText();
      File fg = new File(ProgDer + "\\" + ProjName);
      fg.mkdir();
      f1 = new File(ProgDer + "\\" + ProjName + "\\Index.html");

      try {
         f1.createNewFile();
      } catch (IOException var6) {
         ;
      }

      try {
         Process var3 = Runtime.getRuntime().exec("cmd /c copy " + IconPath + " " + ProgDer + "\\" + ProjName + "\\icon.png");
      } catch (IOException var5) {
         ;
      }

      try {   
    String userpathh = System.getProperty("user.home");
    BufferedReader buf=new BufferedReader (new FileReader (userpathh + "/AppData/Roaming/resources/data/Settings.kady"));
    codearea_color=buf.readLine().replace("CodeArea_Color=","");
    font_size=buf.readLine().replace("Font_Size=","");
    
    HTMLEditor.font_family=buf.readLine().replace("Font_Family=","");
    HTMLEditor.font_weight=buf.readLine().replace("Font_Weight=","");
    HTMLEditor.font_style=buf.readLine().replace("Font_Style=","");
    
    codearea_syntax=buf.readLine().replace("CodeArea_Syntax=","");
    app_theme=buf.readLine().replace("App_Theme=","");
    buf.close();
    font_sizee=Double.parseDouble(font_size);
    }
      
      catch (Exception j) {}
      
      
      HTMLEditor edit = new HTMLEditor();
      edit.start(new Stage());
      Stage stge = (Stage)this.pathlabel.getScene().getWindow();
      stge.close();
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
      this.imgview.setImage(new Image(this.getClass().getResourceAsStream("image.png")));
      PulseTransition pulsee=new PulseTransition(imgview);
      pulsee.setAutoReverse(true);
      pulsee.setCycleCount(10);
      pulsee.play();
   }
}