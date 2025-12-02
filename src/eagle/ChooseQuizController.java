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
public class ChooseQuizController implements Initializable {
  
    
    

    @FXML
    void theme1act(MouseEvent event) throws IOException {

      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CreateQuiz1Apk.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Create Quiz APK (Teachers)");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
     
        
    }

    @FXML
    void theme2act(MouseEvent event) throws IOException {

      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CreateQuiz2Apk.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Create Quiz APK (Students)");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
        
    }
    
      @FXML
    void quiz3action(MouseEvent event) throws IOException {

      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CreateQuiz2Apk_1.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Create Quiz APK (Teachers)");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      
        
    }
    
    
    
   public void initialize(URL location, ResourceBundle resources) {
      
   }
}
