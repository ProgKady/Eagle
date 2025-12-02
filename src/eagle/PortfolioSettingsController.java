
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
public class PortfolioSettingsController implements Initializable {

    @FXML
    private Label pre;

    @FXML
    private Label next;

    @FXML
    private BorderPane scrollpane;

   
            
    @FXML
    private ImageView img;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField job;

    @FXML
    private JFXTextField birthday;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField number;
    
    @FXML
    private JFXTextArea aboutarea;

    @FXML
    private JFXListView<?> detailslist;

    @FXML
    private JFXListView<?> topiclist;

    @FXML
    private JFXButton addone;

    @FXML
    void addoneact(ActionEvent event) {

    }

    @FXML
    void imgact(MouseEvent event) {

      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", new String[]{"*.png"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      img.setImage(new Image((new File(dirpathe)).toURI().toString()));
      
    }


    @FXML        
    void nextact(MouseEvent event) throws IOException {
       String ff=scrollpane.getChildren().get(0).getId();
       if (ff.equals("Form1")) {
           scrollpane.getChildren().clear();
           scrollpane.getChildren().add(FXMLLoader.load(getClass().getResource("Form2.fxml")));
           pre.setDisable(false);
       }
       else if (ff.equals("Form2")) {
           scrollpane.getChildren().clear();
           scrollpane.getChildren().add(FXMLLoader.load(getClass().getResource("Form3.fxml")));
       }
       else if (ff.equals("Form3")) {
           scrollpane.getChildren().clear();
           scrollpane.getChildren().add(FXMLLoader.load(getClass().getResource("Form4.fxml")));
           next.setDisable(true);
       }
            
            
            
        
    }

    @FXML
    void preact(MouseEvent event) throws IOException {

            String ff=scrollpane.getChildren().get(0).getId();
       if (ff.equals("Form4")) {
           scrollpane.getChildren().clear();
           scrollpane.getChildren().add(FXMLLoader.load(getClass().getResource("Form3.fxml")));
           next.setDisable(false);
       }
       else if (ff.equals("Form3")) {
           scrollpane.getChildren().clear();
           scrollpane.getChildren().add(FXMLLoader.load(getClass().getResource("Form2.fxml")));
       }
       else if (ff.equals("Form2")) {
           scrollpane.getChildren().clear();
           scrollpane.getChildren().add(FXMLLoader.load(getClass().getResource("Form1.fxml")));
           pre.setDisable(true);
       }
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
            next.setTooltip(new Tooltip("Next"));
            pre.setTooltip(new Tooltip("Previous"));
            
           
        
            scrollpane.getChildren().clear();
        try {
            scrollpane.getChildren().add(FXMLLoader.load(getClass().getResource("Form1.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(PortfolioSettingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    
    
}
