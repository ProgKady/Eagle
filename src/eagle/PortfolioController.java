/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eagle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author KADY
 */
public class PortfolioController implements Initializable {

    @FXML
    private ImageView p1;

    @FXML
    private ImageView p2;

    @FXML
    private ImageView p3;

    
    
    @FXML
    private JFXButton create;

    @FXML
    private JFXTextField path;
    
    @FXML
    private JFXButton create1;

    @FXML
    void p1act(MouseEvent event) {

        p1.setBlendMode(BlendMode.RED);
        p2.setBlendMode(BlendMode.SRC_OVER);
        p3.setBlendMode(BlendMode.SRC_OVER);
        

        path.setDisable(false);
        path.setText("PortfolioOne");
        create.setDisable(false);
    }

    @FXML
    void p2act(MouseEvent event) {

        p2.setBlendMode(BlendMode.RED);
        p1.setBlendMode(BlendMode.SRC_OVER);
        p3.setBlendMode(BlendMode.SRC_OVER);
        

        path.setDisable(false);
        path.setText("PortfolioTwo");
        create.setDisable(false);
    }

    @FXML
    void p3act(MouseEvent event) {

        p3.setBlendMode(BlendMode.RED);
        p2.setBlendMode(BlendMode.SRC_OVER);
        p1.setBlendMode(BlendMode.SRC_OVER);
        

        path.setDisable(false);
        path.setText("PortfolioThree");
        create.setDisable(false);
    }

    
    @FXML
    void createact(ActionEvent event) throws IOException {

        
        String fname=path.getText();
        
        if (fname.equals("PortfolioOne")) {
            
      ///////////////////////////////////////////////////////
       File fg = new File(System.getProperty("user.home")+"\\Desktop\\"+fname);
       fg.mkdir();
      //////////////Write Project...
      File htmlbat2 = new File(System.getProperty("user.home")+"\\Documents\\kadinio.bat");
      try {
         htmlbat2.createNewFile();
      } catch (IOException var1247) {
         ;
      }
      try {
         PrintWriter lcv = new PrintWriter(new FileWriter(htmlbat2));
         lcv.println("cd " +fg);
         lcv.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\7z.exe x -y " + System.getProperty("user.home")+"\\AppData\\Roaming\\resources\\data\\PortfolioOne.zip");
         lcv.close();
      } catch (IOException var1246) {
         ;
      }
      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("PortfolioSettings.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("CV Editor");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      create.setVisible(false);
      path.setVisible(false);
      create1.setVisible(true);
      ///////////////////true///////////
            ///////////////////////////////////////////////////////
            
        }
        else if (fname.equals("PortfolioTwo")) {
            
                 
      ///////////////////////////////////////////////////////
       File fg = new File(System.getProperty("user.home")+"\\Desktop\\"+fname);
       fg.mkdir();
      //////////////Write Project...
      File htmlbat2 = new File(System.getProperty("user.home")+"\\Documents\\kadinio.bat");
      try {
         htmlbat2.createNewFile();
      } catch (IOException var1247) {
         ;
      }
      try {
         PrintWriter lcv = new PrintWriter(new FileWriter(htmlbat2));
         lcv.println("cd " +fg);
         lcv.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\7z.exe x -y " + System.getProperty("user.home")+"\\AppData\\Roaming\\resources\\data\\PortfolioTwo.zip");
         lcv.close();
      } catch (IOException var1246) {
         ;
      }
      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("PortfolioSettings.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("CV Editor");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      create.setVisible(false);
      path.setVisible(false);
      create1.setVisible(true);
      ///////////////////true///////////
            ///////////////////////////////////////////////////////
      
            
        }
        else if (fname.equals("PortfolioThree")) {
            
            ///////////////////////////////////////////////////////
                  
      ///////////////////////////////////////////////////////
       File fg = new File(System.getProperty("user.home")+"\\Desktop\\"+fname);
       fg.mkdir();
      //////////////Write Project...
      File htmlbat2 = new File(System.getProperty("user.home")+"\\Documents\\kadinio.bat");
      try {
         htmlbat2.createNewFile();
      } catch (IOException var1247) {
         ;
      }
      try {
         PrintWriter lcv = new PrintWriter(new FileWriter(htmlbat2));
         lcv.println("cd " +fg);
         lcv.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\7z.exe x -y " + System.getProperty("user.home")+"\\AppData\\Roaming\\resources\\data\\PortfolioThree.zip");
         lcv.close();
      } catch (IOException var1246) {
         ;
      }
      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("PortfolioSettings.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("CV Editor");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      create.setVisible(false);
      path.setVisible(false);
      create1.setVisible(true);
      ///////////////////true///////////
            ///////////////////////////////////////////////////////
      
            
        }
        
        
    }
    
    @FXML
    void create1act(ActionEvent event) {

        
     
      ProcessBuilder pb7 = new ProcessBuilder(new String[]{System.getProperty("user.home")+"\\Documents"+"\\kadinio.bat"});
      pb7.redirectError();

      boolean var38;
      InputStream inputStream;
      Throwable var1366;
      int in;
      try {
         Process b7 = pb7.start();
         inputStream = b7.getInputStream();
         var1366 = null;

         try {
            var38 = true;

            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1257) {
            var1366 = var1257;
            throw var1257;
         } finally {
            if (inputStream != null) {
               if (var1366 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1213) {
                     var1366.addSuppressed(var1213);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b7.waitFor());
      } catch (IOException var1259) {
         ;
      } catch (InterruptedException var1260) {
         ;
      }

  
                 
       Stage stge = (Stage)this.create.getScene().getWindow();
       stge.close();

        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
