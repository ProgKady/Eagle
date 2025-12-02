/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eagle;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Window;
//Save from web to file when writing
/**
 * FXML Controller class
 *
 * @author KADY
 */
public class CVLoaderController implements Initializable {

    @FXML
    WebView webview;
    
    MenuItem m1,m2,m3;
    static String pathy;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        m1=new MenuItem("Open CV");
        m1.setOnAction((ActionEvent uu) -> {
            
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Html Files", new String[]{"*.html"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      pathy = f.getAbsolutePath().toString();
      
      java.net.URI uri = java.nio.file.Paths.get(pathy).toAbsolutePath().toUri();

      webview.getEngine().load(uri.toString());
            
        });
        
        m2=new MenuItem("Open In Browser");
        m2.setOnAction((ActionEvent uu) -> {
            
             Desktop des = Desktop.getDesktop();

         try {
            des.open(new File(pathy));
         } catch (IOException var4) {
            Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var4);
         }
            
        });
        m3=new MenuItem("Exit");
        m3.setOnAction((ActionEvent uu) -> {
            
            System.exit(0);
            
        });
        
        ContextMenu cm=new ContextMenu();
        cm.getItems().addAll(m1,m2,m3);
        
        
        webview.setContextMenuEnabled(false);
        webview.setOnMousePressed(e -> {
          if  (e.getButton()==MouseButton.SECONDARY)  {
              cm.show(webview,e.getSceneX(),e.getSceneY());
          }
          else {
              cm.hide();
          }
        });
        
        webview.setOnKeyReleased(gg ->{
          String code=  (String) webview.getEngine().executeScript("document.documentElement.outerHTML");
          try {
            PrintWriter pw = new PrintWriter(new FileWriter(pathy));
            pw.println();
            pw.print(code);
            pw.close();
         } catch (IOException var4) {
           // Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var4);
         }
        });
        
    }    
    
}
