/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eagle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author KADY
 */
public class CVController implements Initializable {

    @FXML
    private ImageView b1;

    @FXML
    private ImageView b2;

    @FXML
    private ImageView b3;

    @FXML
    private ImageView a1;

    @FXML
    private ImageView a2;

    @FXML
    private ImageView a3;

    @FXML
    private ImageView a4;
    
    @FXML
    private JFXButton create;
    
    @FXML
    private JFXButton create1;

    @FXML
    private JFXTextField path;

    @FXML
    void a1act(MouseEvent event) {

        b1.setBlendMode(BlendMode.SRC_OVER);
        a2.setBlendMode(BlendMode.SRC_OVER);
        a3.setBlendMode(BlendMode.SRC_OVER);
        a4.setBlendMode(BlendMode.SRC_OVER);
        a1.setBlendMode(BlendMode.RED);
        b2.setBlendMode(BlendMode.SRC_OVER);
        b3.setBlendMode(BlendMode.SRC_OVER);

        path.setDisable(false);
        path.setText("AdvancedOne");
        create.setDisable(false);
    }

    @FXML
    void a2act(MouseEvent event) {

        a1.setBlendMode(BlendMode.SRC_OVER);
        b1.setBlendMode(BlendMode.SRC_OVER);
        a3.setBlendMode(BlendMode.SRC_OVER);
        a4.setBlendMode(BlendMode.SRC_OVER);
        a2.setBlendMode(BlendMode.RED);
        b2.setBlendMode(BlendMode.SRC_OVER);
        b3.setBlendMode(BlendMode.SRC_OVER);

        path.setDisable(false);
        path.setText("AdvancedTwo");
        create.setDisable(false);
    }

    @FXML
    void a3act(MouseEvent event) {

        a1.setBlendMode(BlendMode.SRC_OVER);
        a2.setBlendMode(BlendMode.SRC_OVER);
        b1.setBlendMode(BlendMode.SRC_OVER);
        a4.setBlendMode(BlendMode.SRC_OVER);
        a3.setBlendMode(BlendMode.RED);
        b2.setBlendMode(BlendMode.SRC_OVER);
        b3.setBlendMode(BlendMode.SRC_OVER);

        path.setDisable(false);
        path.setText("AdvancedThree");
        create.setDisable(false);
    }

    @FXML
    void a4act(MouseEvent event) {

        a1.setBlendMode(BlendMode.SRC_OVER);
        a2.setBlendMode(BlendMode.SRC_OVER);
        a3.setBlendMode(BlendMode.SRC_OVER);
        b1.setBlendMode(BlendMode.SRC_OVER);
        a4.setBlendMode(BlendMode.RED);
        b2.setBlendMode(BlendMode.SRC_OVER);
        b3.setBlendMode(BlendMode.SRC_OVER);

        path.setDisable(false);
        path.setText("AdvancedFour");
        create.setDisable(false);
    }

    @FXML
    void b1act(MouseEvent event) {
        a1.setBlendMode(BlendMode.SRC_OVER);
        a2.setBlendMode(BlendMode.SRC_OVER);
        a3.setBlendMode(BlendMode.SRC_OVER);
        a4.setBlendMode(BlendMode.SRC_OVER);
        b1.setBlendMode(BlendMode.RED);
        b2.setBlendMode(BlendMode.SRC_OVER);
        b3.setBlendMode(BlendMode.SRC_OVER);

        path.setDisable(false);
        path.setText("BasicOne");
        create.setDisable(false);
    }

    @FXML
    void b2act(MouseEvent event) {

        a1.setBlendMode(BlendMode.SRC_OVER);
        a2.setBlendMode(BlendMode.SRC_OVER);
        a3.setBlendMode(BlendMode.SRC_OVER);
        a4.setBlendMode(BlendMode.SRC_OVER);
        b2.setBlendMode(BlendMode.RED);
        b1.setBlendMode(BlendMode.SRC_OVER);
        b3.setBlendMode(BlendMode.SRC_OVER);

        path.setDisable(false);
        path.setText("BasicTwo");
        create.setDisable(false);
    }

    @FXML
    void b3act(MouseEvent event) {

        a1.setBlendMode(BlendMode.SRC_OVER);
        a2.setBlendMode(BlendMode.SRC_OVER);
        a3.setBlendMode(BlendMode.SRC_OVER);
        a4.setBlendMode(BlendMode.SRC_OVER);
        b3.setBlendMode(BlendMode.RED);
        b2.setBlendMode(BlendMode.SRC_OVER);
        b1.setBlendMode(BlendMode.SRC_OVER);

        path.setDisable(false);
        path.setText("BasicThree");
        create.setDisable(false);
    }
    
    
    
    
    
    
    
    
//    @FXML
//    void createact(ActionEvent event) throws IOException {
//
//        String fname=path.getText();
//        
//        if (fname.equals("BasicOne")) {
//            
//      ///////////////////////////////////////////////////////
//       File fg = new File(System.getProperty("user.home")+"\\Desktop\\"+fname);
//       fg.mkdir();
//      //////////////Write Project...
//      File htmlbat2 = new File(System.getProperty("user.home")+"\\Documents\\kadinio.bat");
//      try {
//         htmlbat2.createNewFile();
//      } catch (IOException var1247) {
//         ;
//      }
//      try {
//         PrintWriter lcv = new PrintWriter(new FileWriter(htmlbat2));
//         lcv.println("cd " +fg);
//         lcv.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\7z.exe x -y " + System.getProperty("user.home")+"\\AppData\\Roaming\\resources\\data\\BasicOne.zip");
//         lcv.close();
//      } catch (IOException var1246) {
//         ;
//      }
//      Stage stg = new Stage();
//      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CVLoader.fxml"));
//      Scene sce = new Scene(root);
//      stg.setTitle("CV Editor");
//      stg.centerOnScreen();
//      stg.setResizable(false);
//      stg.setScene(sce);
//      stg.show();
//      create.setVisible(false);
//      path.setVisible(false);
//      create1.setVisible(true);
//      ///////////////////true///////////
//            ///////////////////////////////////////////////////////
//            
//        }
//        else if (fname.equals("BasicTwo")) {
//            
//                 
//      ///////////////////////////////////////////////////////
//       File fg = new File(System.getProperty("user.home")+"\\Desktop\\"+fname);
//       fg.mkdir();
//      //////////////Write Project...
//      File htmlbat2 = new File(System.getProperty("user.home")+"\\Documents\\kadinio.bat");
//      try {
//         htmlbat2.createNewFile();
//      } catch (IOException var1247) {
//         ;
//      }
//      try {
//         PrintWriter lcv = new PrintWriter(new FileWriter(htmlbat2));
//         lcv.println("cd " +fg);
//         lcv.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\7z.exe x -y " + System.getProperty("user.home")+"\\AppData\\Roaming\\resources\\data\\BasicTwo.zip");
//         lcv.close();
//      } catch (IOException var1246) {
//         ;
//      }
//      Stage stg = new Stage();
//      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CVLoader.fxml"));
//      Scene sce = new Scene(root);
//      stg.setTitle("CV Editor");
//      stg.centerOnScreen();
//      stg.setResizable(false);
//      stg.setScene(sce);
//      stg.show();
//      create.setVisible(false);
//      path.setVisible(false);
//      create1.setVisible(true);
//      ///////////////////true///////////
//            ///////////////////////////////////////////////////////
//      
//            
//        }
//        else if (fname.equals("BasicThree")) {
//            
//            ///////////////////////////////////////////////////////
//                  
//      ///////////////////////////////////////////////////////
//       File fg = new File(System.getProperty("user.home")+"\\Desktop\\"+fname);
//       fg.mkdir();
//      //////////////Write Project...
//      File htmlbat2 = new File(System.getProperty("user.home")+"\\Documents\\kadinio.bat");
//      try {
//         htmlbat2.createNewFile();
//      } catch (IOException var1247) {
//         ;
//      }
//      try {
//         PrintWriter lcv = new PrintWriter(new FileWriter(htmlbat2));
//         lcv.println("cd " +fg);
//         lcv.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\7z.exe x -y " + System.getProperty("user.home")+"\\AppData\\Roaming\\resources\\data\\BasicThree.zip");
//         lcv.close();
//      } catch (IOException var1246) {
//         ;
//      }
//      Stage stg = new Stage();
//      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CVLoader.fxml"));
//      Scene sce = new Scene(root);
//      stg.setTitle("CV Editor");
//      stg.centerOnScreen();
//      stg.setResizable(false);
//      stg.setScene(sce);
//      stg.show();
//      create.setVisible(false);
//      path.setVisible(false);
//      create1.setVisible(true);
//      ///////////////////true///////////
//            ///////////////////////////////////////////////////////
//      
//            
//        }
//        else if (fname.equals("AdvancedOne")) {
//            
//            ///////////////////////////////////////////////////////
//             File fg = new File(System.getProperty("user.home")+"\\Desktop\\"+fname);
//             fg.mkdir();
//             
//             FileChooser fcho = new FileChooser();
//             fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", new String[]{"*.png"}));
//             fcho.setTitle("Choose Image");
//             File f = fcho.showOpenDialog((Window)null);
//             String dirpathe = f.getAbsolutePath().toString();
//             
//             try {
//             Process var3 = Runtime.getRuntime().exec("cmd /c copy " + dirpathe + " " + fg +"\\me.png");
//             } catch (IOException var5) {
//             }
//      
//      //Write Project...
//      
//     
//      //////////////Write Project...
//      File htmlbat2 = new File(System.getProperty("user.home")+"\\Documents\\kadinio.bat");
//      try {
//         htmlbat2.createNewFile();
//      } catch (IOException var1247) {
//         ;
//      }
//      try {
//         PrintWriter lcv = new PrintWriter(new FileWriter(htmlbat2));
//         lcv.println("cd " +fg);
//         lcv.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\7z.exe x -y " + System.getProperty("user.home")+"\\AppData\\Roaming\\resources\\data\\AdvancedOne.zip");
//         lcv.close();
//      } catch (IOException var1246) {
//         ;
//      }
//      Stage stg = new Stage();
//      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CVLoader.fxml"));
//      Scene sce = new Scene(root);
//      stg.setTitle("CV Editor");
//      stg.centerOnScreen();
//      stg.setResizable(false);
//      stg.setScene(sce);
//      stg.show();
//      create.setVisible(false);
//      path.setVisible(false);
//      create1.setVisible(true);
//      ///////////////////true///////////
//      
//            ///////////////////////////////////////////////////////
//            
//        }
//        else if (fname.equals("AdvancedTwo")) {
//            
//            ///////////////////////////////////////////////////////
//             File fg = new File(System.getProperty("user.home")+"\\Desktop\\"+fname);
//             fg.mkdir();
//             
//             FileChooser fcho = new FileChooser();
//             fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", new String[]{"*.png"}));
//             fcho.setTitle("Choose Image");
//             File f = fcho.showOpenDialog((Window)null);
//             String dirpathe = f.getAbsolutePath().toString();
//             
//             try {
//             Process var3 = Runtime.getRuntime().exec("cmd /c copy " + dirpathe + " " + fg +"\\me.png");
//             } catch (IOException var5) {
//             }
//      
//      //Write Project...
//      //////////////Write Project...
//      File htmlbat2 = new File(System.getProperty("user.home")+"\\Documents\\kadinio.bat");
//      try {
//         htmlbat2.createNewFile();
//      } catch (IOException var1247) {
//         ;
//      }
//      try {
//         PrintWriter lcv = new PrintWriter(new FileWriter(htmlbat2));
//         lcv.println("cd " +fg);
//         lcv.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\7z.exe x -y " + System.getProperty("user.home")+"\\AppData\\Roaming\\resources\\data\\AdvancedTwo.zip");
//         lcv.close();
//      } catch (IOException var1246) {
//         ;
//      }
//      Stage stg = new Stage();
//      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CVLoader.fxml"));
//      Scene sce = new Scene(root);
//      stg.setTitle("CV Editor");
//      stg.centerOnScreen();
//      stg.setResizable(false);
//      stg.setScene(sce);
//      stg.show();
//      create.setVisible(false);
//      path.setVisible(false);
//      create1.setVisible(true);
//      ///////////////////true///////////
//      
//            ///////////////////////////////////////////////////////
//            
//        }
//        else if (fname.equals("AdvancedThree")) {
//            
//            ///////////////////////////////////////////////////////
//             File fg = new File(System.getProperty("user.home")+"\\Desktop\\"+fname);
//             fg.mkdir();
//             
//             FileChooser fcho = new FileChooser();
//             fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", new String[]{"*.png"}));
//             fcho.setTitle("Choose Image");
//             File f = fcho.showOpenDialog((Window)null);
//             String dirpathe = f.getAbsolutePath().toString();
//             
//             try {
//             Process var3 = Runtime.getRuntime().exec("cmd /c copy " + dirpathe + " " + fg +"\\me.png");
//             } catch (IOException var5) {
//             }
//      
//      //Write Project...
//      
//      //////////////Write Project...
//      File htmlbat2 = new File(System.getProperty("user.home")+"\\Documents\\kadinio.bat");
//      try {
//         htmlbat2.createNewFile();
//      } catch (IOException var1247) {
//         ;
//      }
//      try {
//         PrintWriter lcv = new PrintWriter(new FileWriter(htmlbat2));
//         lcv.println("cd " +fg);
//         lcv.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\7z.exe x -y " + System.getProperty("user.home")+"\\AppData\\Roaming\\resources\\data\\AdvancedThree.zip");
//         lcv.close();
//      } catch (IOException var1246) {
//         ;
//      }
//      Stage stg = new Stage();
//      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CVLoader.fxml"));
//      Scene sce = new Scene(root);
//      stg.setTitle("CV Editor");
//      stg.centerOnScreen();
//      stg.setResizable(false);
//      stg.setScene(sce);
//      stg.show();
//      create.setVisible(false);
//      path.setVisible(false);
//      create1.setVisible(true);
//      ///////////////////true///////////
//      
//            ///////////////////////////////////////////////////////
//            
//        }
//        else if (fname.equals("AdvancedFour")) {
//            
//            ///////////////////////////////////////////////////////
//             File fg = new File(System.getProperty("user.home")+"\\Desktop\\"+fname);
//             fg.mkdir();
//             
//             FileChooser fcho = new FileChooser();
//             fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", new String[]{"*.png"}));
//             fcho.setTitle("Choose Image");
//             File f = fcho.showOpenDialog((Window)null);
//             String dirpathe = f.getAbsolutePath().toString();
//             
//             try {
//             Process var3 = Runtime.getRuntime().exec("cmd /c copy " + dirpathe + " " + fg +"\\me.png");
//             } catch (IOException var5) {
//             }
//      
//      //Write Project...
//      
//      //////////////Write Project...
//      File htmlbat2 = new File(System.getProperty("user.home")+"\\Documents\\kadinio.bat");
//      try {
//         htmlbat2.createNewFile();
//      } catch (IOException var1247) {
//         ;
//      }
//      try {
//         PrintWriter lcv = new PrintWriter(new FileWriter(htmlbat2));
//         lcv.println("cd " +fg);
//         lcv.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\7z.exe x -y " + System.getProperty("user.home")+"\\AppData\\Roaming\\resources\\data\\AdvancedFour.zip");
//         lcv.close();
//      } catch (IOException var1246) {
//         ;
//      }
//      Stage stg = new Stage();
//      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CVLoader.fxml"));
//      Scene sce = new Scene(root);
//      stg.setTitle("CV Editor");
//      stg.centerOnScreen();
//      stg.setResizable(false);
//      stg.setScene(sce);
//      stg.show();
//      create.setVisible(false);
//      path.setVisible(false);
//      create1.setVisible(true);
//      ///////////////////true///////////
//      
//            ///////////////////////////////////////////////////////
//            
//        }
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//    }
//    
//    
//    
//    
    
    
    
    
    
    
    @FXML
void createact(ActionEvent event) throws IOException {
    
    String fname = path.getText();

    if (fname.equals("BasicOne") || fname.equals("BasicTwo") || fname.equals("BasicThree")
            || fname.equals("AdvancedOne") || fname.equals("AdvancedTwo")
            || fname.equals("AdvancedThree") || fname.equals("AdvancedFour")) {

        String userHome = System.getProperty("user.home");
        File fg = new File(userHome + "\\Desktop\\" + fname);
        fg.mkdir();

        // If Advanced, choose image
        if (fname.startsWith("Advanced")) {
            FileChooser fcho = new FileChooser();
            fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png"));
            fcho.setTitle("Choose Image");
            File f = fcho.showOpenDialog(null);
            if (f != null) {
                Files.copy(f.toPath(), new File(fg, "me.png").toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        }

        // Extract ZIP using Java
        String zipPath = userHome + "\\AppData\\Roaming\\resources\\data\\" + fname + ".zip";
        unzipFile(zipPath, fg.getAbsolutePath());

        // Load CV UI
        Stage stg = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("CVLoader.fxml"));
        Scene sce = new Scene(root);
        stg.setTitle("CV Editor");
        stg.centerOnScreen();
        stg.setResizable(false);
        stg.setScene(sce);
        stg.show();

        //create.setVisible(false);
        //path.setVisible(false);
        //create1.setVisible(true);
    }
}

    
    
    
    public void unzipFile(String zipFilePath, String destDirectory) throws IOException {
    byte[] buffer = new byte[1024];
    File destDir = new File(destDirectory);
    if (!destDir.exists()) {
        destDir.mkdirs();
    }
    ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath));
    ZipEntry zipEntry = zis.getNextEntry();
    while (zipEntry != null) {
        File newFile = new File(destDirectory, zipEntry.getName());
        if (zipEntry.isDirectory()) {
            newFile.mkdirs();
        } else {
            new File(newFile.getParent()).mkdirs();
            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();
        }
        zipEntry = zis.getNextEntry();
    }
    zis.closeEntry();
    zis.close();
}

    
    
    
    
    
    
   
   @FXML
   void createact1(ActionEvent event) throws IOException {
//
//     
//      ProcessBuilder pb7 = new ProcessBuilder(new String[]{System.getProperty("user.home")+"\\Documents"+"\\kadinio.bat"});
//      pb7.redirectError();
//
//      boolean var38;
//      InputStream inputStream;
//      Throwable var1366;
//      int in;
//      try {
//         Process b7 = pb7.start();
//         inputStream = b7.getInputStream();
//         var1366 = null;
//
//         try {
//            var38 = true;
//
//            while((in = inputStream.read()) != -1) {
//               System.out.print((char)in);
//            }
//         } catch (Throwable var1257) {
//            var1366 = var1257;
//            throw var1257;
//         } finally {
//            if (inputStream != null) {
//               if (var1366 != null) {
//                  try {
//                     inputStream.close();
//                  } catch (Throwable var1213) {
//                     var1366.addSuppressed(var1213);
//                  }
//               } else {
//                  inputStream.close();
//               }
//            }
//
//         }
//
//         System.out.println("Exited with " + b7.waitFor());
//      } catch (IOException var1259) {
//         ;
//      } catch (InterruptedException var1260) {
//         ;
//      }
//
//  
//                 
//       Stage stge = (Stage)this.create.getScene().getWindow();
//       stge.close();
//        
    }
//    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
