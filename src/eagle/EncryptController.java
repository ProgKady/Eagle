package eagle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class EncryptController {

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

    @FXML
    private JFXButton en;
    
    static String filename;

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
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Files types", new String[]{"*.png","*.jpeg","*.jpg","*.gif","*.exe","*.mp3","*.mp4"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      file.setText(dirpathe);
      filename=f.getName();
      
    }

    @FXML
    void enaction(ActionEvent event) throws FileNotFoundException, IOException, InterruptedException {

        String filepath=file.getText();
        String despath=des.getText();
        String filenam=filename;
        String newfilename=filenam.replace(".","");
        /*
        BufferedReader buff=new BufferedReader(new FileReader (filepath));
        PrintWriter pw=new PrintWriter (new BufferedWriter (new FileWriter (despath+"\\"+newfilename+".kady")));
        
        String line = buff.readLine();

                  while(line != null) {
                     line = buff.readLine();
                     pw.print(line);
                     pw.append("Kadysoft");
                  }

                  buff.close();
                  pw.close();
                  Stage jk = (Stage)this.file.getScene().getWindow();
                  jk.close();
*/

            Process p = Runtime.getRuntime().exec("cmd /c copy "+filepath+" "+despath+"\\"+newfilename+".kady");
            p.waitFor();
            
            BufferedReader buff=new BufferedReader(new FileReader (despath+"\\"+newfilename+".kady"));
            PrintWriter pw=new PrintWriter (new BufferedWriter (new FileWriter (despath+"\\"+newfilename+".kady")));
        
            String line = buff.readLine();

                  while(line != null) {
                     line = buff.readLine();
                     
                     
                  }
                     pw.append("Kadysoft");
                buff.close();
                     pw.close();
                     Stage jk = (Stage)this.file.getScene().getWindow();
                     jk.close();
        
    }

    @FXML
    void initialize() {
        assert browsefile != null : "fx:id=\"browsefile\" was not injected: check your FXML file 'Encrypt.fxml'.";
        assert file != null : "fx:id=\"file\" was not injected: check your FXML file 'Encrypt.fxml'.";
        assert des != null : "fx:id=\"des\" was not injected: check your FXML file 'Encrypt.fxml'.";
        assert en != null : "fx:id=\"en\" was not injected: check your FXML file 'Encrypt.fxml'.";
        assert browsedes != null : "fx:id=\"browsedes\" was not injected: check your FXML file 'Encrypt.fxml'.";

    }
}