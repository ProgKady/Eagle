
package eagle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
public class Form3Controller implements Initializable {
   
     @FXML
    private JFXTextArea edudata;

    @FXML
    private JFXTextField addedu;

    @FXML
    private JFXComboBox<?> edufrom;

    @FXML
    private JFXComboBox<?> eduto;

    @FXML
    private JFXButton eduaddbtn;

    @FXML
    private JFXTextArea exdata;

    @FXML
    private JFXTextArea skdata;

    @FXML
    private JFXTextField addex;

    @FXML
    private JFXButton exaddbtn;

    @FXML
    private JFXComboBox<?> exto;

    @FXML
    private JFXComboBox<?> exfrom;

    @FXML
    private JFXTextField addsk;

    @FXML
    private JFXButton skaddbtn;

    @FXML
    private JFXTextField picnum;

    @FXML
    private JFXTextField picpath;

    @FXML
    private JFXButton browse;

    @FXML
    void eduaddbtnact(ActionEvent event) {

    }

    @FXML
    void exaddbtnact(ActionEvent event) {

    }

    @FXML
    void skaddbtnact(ActionEvent event) {

    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }    
    
}
