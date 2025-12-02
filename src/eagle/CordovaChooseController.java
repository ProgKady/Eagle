package eagle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class CordovaChooseController implements Initializable {
   @FXML
    private Label theme1;

   @FXML
    private Label theme11;

   
    @FXML
    private Label theme2;
    
    @FXML
    private Label theme3;

    @FXML
    void theme1act(MouseEvent event) throws IOException {

      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CreateCordovaApk.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Create Eagle APP");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      Stage jk = (Stage)this.theme1.getScene().getWindow();
      jk.close();
        
    }
    
    @FXML
    void theme11act(MouseEvent event) throws IOException {

      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CreateWebsiteApk.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Create Eagle APP For Website");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      Stage jk = (Stage)this.theme1.getScene().getWindow();
      jk.close();
        
    }

    @FXML
    void theme2act(MouseEvent event) throws IOException {

      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CreateCordovaApkOff.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Create Eagle Game");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      Stage jk = (Stage)this.theme2.getScene().getWindow();
      jk.close();
        
    }
    
    @FXML
    void theme3act(MouseEvent event) throws IOException {

      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("ChooseQuiz.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Create Eagle Quiz");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      Stage jk = (Stage)this.theme2.getScene().getWindow();
      jk.close();
        
        
    }
    
   public void initialize(URL location, ResourceBundle resources) {
      
   }
}
