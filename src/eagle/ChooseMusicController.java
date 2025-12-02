package eagle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class ChooseMusicController implements Initializable {
  
    
    
    

    @FXML
    void theme1act(MouseEvent event) throws IOException {

      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CreateMusiccApk.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Create Music APK");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      
        
    }

    @FXML
    void theme2act(MouseEvent event) throws IOException {

      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CreateMusicApk.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Create Music APK");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      
        
    }
    
    @FXML
    void theme3act(MouseEvent event) throws IOException {

      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CreateMusicApkOne.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Create Music APK");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      
        
    }
    
    @FXML
    void theme4act(MouseEvent event) throws IOException {

      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CreateMusicApkTwo.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Create Music APK");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      
        
    }
    
    @FXML
    void theme5act(MouseEvent event) throws IOException {

      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CreateMusicApkThree.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Create Music APK");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      
        
    }
    
    
    
    
    
    
   public void initialize(URL location, ResourceBundle resources) {
      
   }
}
