package eagle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import static eagle.CreateDesktopController.IconPath;
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
import javafx.scene.image.Image;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class JAR2EXEController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField jar;

    @FXML
    private JFXTextField jdk;

    @FXML
    private JFXTextField exe;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField ico;

    @FXML
    private JFXTextField version;

    @FXML
    private JFXButton browse1;

    @FXML
    private JFXButton browse2;

    @FXML
    private JFXButton browse3;

    @FXML
    private JFXButton browse4;

    @FXML
    private JFXButton create;

    @FXML
    void browse1act(ActionEvent event) {
  
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("JAR Files", new String[]{"*.jar"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      jar.setText(dirpathe);
      
    }

    @FXML
    void browse2act(ActionEvent event) {

      DirectoryChooser fcho = new DirectoryChooser();
      fcho.setTitle("Kady Choose");
      File f = fcho.showDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      exe.setText(dirpathe);
    }

    @FXML
    void browse3act(ActionEvent event) {

      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("ICO Image Files", new String[]{"*.ico"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      ico.setText(dirpathe);
    }

    @FXML
    void browse4act(ActionEvent event) {

      DirectoryChooser fcho = new DirectoryChooser();
      fcho.setTitle("Kady Choose");
      File f = fcho.showDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      jdk.setText(dirpathe);
    }

    @FXML
    void createact(ActionEvent event) {

        String jarpath,exepath,icopath,jdkpath,ver,nam;
        jarpath=jar.getText();
        exepath=exe.getText(); //dir
        icopath=ico.getText();
        jdkpath=jdk.getText();
        ver=version.getText();
        nam=name.getText();
        
        
        File batfile66 = new File(exepath + "\\config.xml");

      try {
         batfile66.createNewFile();
      } catch (IOException var1231) {
         
      }
      
      try {
         PrintWriter pwwwwn = new PrintWriter(new FileWriter(batfile66));
         pwwwwn.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
"<launch4jConfig>\n" +
"  <dontWrapJar>false</dontWrapJar>\n" +
"  <headerType>gui</headerType>\n" +
"  <jar>"+jarpath+"</jar>\n" +
"  <outfile>"+exepath+"\\"+nam+".exe"+"</outfile>\n" +
"  <errTitle>Eagle, Java Environment Error</errTitle>\n" +
"  <cmdLine></cmdLine>\n" +
"  <chdir>.</chdir>\n" +
"  <priority>normal</priority>\n" +
"  <downloadUrl>http://java.com/download</downloadUrl>\n" +
"  <supportUrl></supportUrl>\n" +
"  <stayAlive>false</stayAlive>\n" +
"  <restartOnCrash>false</restartOnCrash>\n" +
"  <manifest></manifest>\n" +
"  <icon>"+icopath+"</icon>\n" +
"  <jre>\n" +
"    <path>"+jdkpath+"</path>\n" +
"    <bundledJre64Bit>true</bundledJre64Bit>\n" +
"    <bundledJreAsFallback>false</bundledJreAsFallback>\n" +
"    <minVersion></minVersion>\n" +
"    <maxVersion></maxVersion>\n" +
"    <jdkPreference>preferJre</jdkPreference>\n" +
"    <runtimeBits>64/32</runtimeBits>\n" +
"  </jre>\n" +
"  <versionInfo>\n" +
"    <fileVersion>"+ver+"</fileVersion>\n" +
"    <txtFileVersion>"+ver+"</txtFileVersion>\n" +
"    <fileDescription>Created by Eagle for creating Web Projects, Android and Desktop Applications. Download Eagle.exe Now!.</fileDescription>\n" +
"    <copyright>All Rights Reserved @ Kadysoft 2019 - 2022.</copyright>\n" +
"    <productVersion>"+ver+"</productVersion>\n" +
"    <txtProductVersion>"+ver+"</txtProductVersion>\n" +
"    <productName>"+nam+"</productName>\n" +
"    <companyName>Kadysoft</companyName>\n" +
"    <internalName>"+nam+"</internalName>\n" +
"    <originalFilename>"+nam+".exe"+"</originalFilename>\n" +
"    <trademarks></trademarks>\n" +
"    <language>ENGLISH_US</language>\n" +
"  </versionInfo>\n" +
"</launch4jConfig>");
         pwwwwn.close();
      } catch (IOException var1230) {
         
      }
        
        try {
            Process var5 = Runtime.getRuntime().exec("cmd /c "+System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\jar2exe\\launch4j.exe"+" "+exepath + "\\config.xml");
        } catch (IOException ex) {
            Logger.getLogger(JAR2EXEController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Stage stge = (Stage)this.jar.getScene().getWindow();
        stge.close();
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(JAR2EXEController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File nv=new File (exepath + "\\config.xml");
        nv.delete();
      
      
      
      Desktop desk = Desktop.getDesktop();
        try {
         //   desk.open(new File(exepath));
            desk.open(new File(exepath+"\\"+nam+".exe"));
        } catch (IOException ex) {
            Logger.getLogger(JAR2EXEController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
         
        
    }

    @FXML
    void getpathact(ActionEvent event) {

       String jdkpath= System.getProperty("java.home").replace("\\jre","");
       jdk.setText(jdkpath);
    }

    @FXML
    void png2icoact(ActionEvent event) {

      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", new String[]{"*.png","*.jpg","*.jpeg","*.gif"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
        try {
            Process var55 = Runtime.getRuntime().exec("cmd /c mspaint "+dirpathe);
        } catch (IOException ex) {
            Logger.getLogger(JAR2EXEController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    @FXML
    void png2icoact1(ActionEvent event) {

      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", new String[]{"*.png","*.jpg","*.jpeg","*.gif"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
        try {
            Process var55 = Runtime.getRuntime().exec("cmd /c "+System.getProperty("user.home")+"/AppData/Roaming/resources/data/png2ico/Greenshot.exe"+" "+dirpathe);
        } catch (IOException ex) {
            Logger.getLogger(JAR2EXEController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    @FXML
    void initialize() {
        assert jar != null : "fx:id=\"jar\" was not injected: check your FXML file 'JAR2EXE.fxml'.";
        assert jdk != null : "fx:id=\"jdk\" was not injected: check your FXML file 'JAR2EXE.fxml'.";
        assert exe != null : "fx:id=\"exe\" was not injected: check your FXML file 'JAR2EXE.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'JAR2EXE.fxml'.";
        assert ico != null : "fx:id=\"ico\" was not injected: check your FXML file 'JAR2EXE.fxml'.";
        assert version != null : "fx:id=\"version\" was not injected: check your FXML file 'JAR2EXE.fxml'.";
        assert browse1 != null : "fx:id=\"browse1\" was not injected: check your FXML file 'JAR2EXE.fxml'.";
        assert browse2 != null : "fx:id=\"browse2\" was not injected: check your FXML file 'JAR2EXE.fxml'.";
        assert browse3 != null : "fx:id=\"browse3\" was not injected: check your FXML file 'JAR2EXE.fxml'.";
        assert browse4 != null : "fx:id=\"browse4\" was not injected: check your FXML file 'JAR2EXE.fxml'.";
        assert create != null : "fx:id=\"create\" was not injected: check your FXML file 'JAR2EXE.fxml'.";

    }
}