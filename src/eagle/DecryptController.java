package eagle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import static eagle.EncryptController.filename;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class DecryptController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton browsefile;

    @FXML
    private JFXTextField file;

    @FXML
    private JFXTextField des;
    
    static String filename;

    @FXML
    private JFXButton de;

    @FXML
    private JFXButton browsedes;

    @FXML
    void browsedesaction(ActionEvent event) {

      DirectoryChooser fcho = new DirectoryChooser();
      fcho.setTitle("Kady Choose");
      File f = fcho.showDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      des.setText(dirpathe);
      
    }

    @FXML
    void browsefileaction(ActionEvent event) {

      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Encrypted Files", new String[]{"*.kady"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      file.setText(dirpathe);
      filename=f.getName();
    }

    @FXML
    void deaction(ActionEvent event) {

        String filepath=file.getText();
        String despath=des.getText();
        String filenam=filename;
        
    }

    @FXML
    void initialize() {
        assert browsefile != null : "fx:id=\"browsefile\" was not injected: check your FXML file 'Encrypt.fxml'.";
        assert file != null : "fx:id=\"file\" was not injected: check your FXML file 'Encrypt.fxml'.";
        assert des != null : "fx:id=\"des\" was not injected: check your FXML file 'Encrypt.fxml'.";
        assert de != null : "fx:id=\"de\" was not injected: check your FXML file 'Encrypt.fxml'.";
        assert browsedes != null : "fx:id=\"browsedes\" was not injected: check your FXML file 'Encrypt.fxml'.";

    }
}