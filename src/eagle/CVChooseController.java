package eagle;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

//HIII

public class CVChooseController implements Initializable {
   @FXML
    private Label theme1;

    @FXML
    private Label theme2;

    @FXML
    void theme1act(MouseEvent event) throws IOException {

      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CV.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Create CV");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      //stg.setAlwaysOnTop(true);
      stg.show();
      Stage jk = (Stage)this.theme1.getScene().getWindow();
      jk.setIconified(true);
        
    }

    @FXML
    void theme2act(MouseEvent event) throws IOException {

      String userpath = System.getProperty("user.home");
              Desktop desky = Desktop.getDesktop();
          try {
              desky.open(new File("C:\\Program Files (x86)\\KADY\\Eagle\\tools\\KADY\\Index.html"));
          } catch (IOException ex) {
              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
          }
               Stage jk = (Stage)this.theme1.getScene().getWindow();
      jk.setIconified(true);
        
    }
   public void initialize(URL location, ResourceBundle resources) {
      theme1.setTooltip(new Tooltip("Create Static CV then convert it to PDF."));
      theme2.setTooltip(new Tooltip("Create Personalized CV then convert it to PDF."));
   }
}
