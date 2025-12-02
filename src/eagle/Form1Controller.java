
package eagle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author KADY
 */
public class Form1Controller implements Initializable {
            
    @FXML
     ImageView img;

    @FXML
     JFXTextField name;

    @FXML
     JFXTextField job;

    @FXML
     JFXTextField birthday;

    @FXML
     JFXTextField address;

    @FXML
     JFXTextField email;

    @FXML
     JFXTextField number;
    
    
    @FXML
    void imgact(MouseEvent event) {

      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", new String[]{"*.png"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      img.setImage(new Image((new File(dirpathe)).toURI().toString()));
    }


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }    
    
}
