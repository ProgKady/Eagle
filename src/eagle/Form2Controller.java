
package eagle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author KADY
 */
public class Form2Controller implements Initializable {
   
    @FXML
    private JFXTextArea aboutarea;

    @FXML
    private JFXTextArea detailslist;

    @FXML
    private JFXTextField topiclist;
    
    @FXML
    private JFXTextArea services;

    @FXML
    private JFXButton addone;

    @FXML
    void addoneact(ActionEvent event) {

        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }    
    
}
