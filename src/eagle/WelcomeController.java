package eagle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXButton.ButtonType;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import com.gluonhq.charm.glisten.animation.*;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
//import static eagle.HTMLEditor_Old.app_theme;
//import static eagle.HTMLEditor_Old.codearea_color;
//import static eagle.HTMLEditor_Old.codearea_syntax;
//import static eagle.HTMLEditor_Old.font_size;
//import static eagle.HTMLEditor_Old.font_sizee;
//
//import static eagle.HTMLEditor_Old.font_family;
//import static eagle.HTMLEditor_Old.font_style;
//import static eagle.HTMLEditor_Old.font_weight;

import static eagle.HTMLEditor.app_theme;
import static eagle.HTMLEditor.codearea_color;
import static eagle.HTMLEditor.codearea_syntax;
import static eagle.HTMLEditor.font_size;
import static eagle.HTMLEditor.font_sizee;

import io.github.palexdev.materialfx.controls.MFXButton;
import java.util.Optional;
import javafx.geometry.Insets;
import javafx.scene.control.DialogPane;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

public class WelcomeController implements Initializable {
    @FXML
    private ImageView app;

    @FXML
    private ComboBox set;

    @FXML
    private ImageView gm;

    @FXML
    private ImageView cls;
    
    @FXML
    private ImageView git;
    
    ////////////////////////////////////////
    
    @FXML
    private ImageView git1;
    @FXML
    private ImageView git2;
    @FXML
    private ImageView git3;
    @FXML
    private ImageView git4;
    @FXML
    private ImageView git5;
    @FXML
    private ImageView git6;
    @FXML
    private ImageView git7;
    @FXML
    private ImageView git8;
    @FXML
    private ImageView git9;
    @FXML
    private ImageView git10;
    @FXML
    private ImageView git11;
    
    ////////////////////////////////////////
    @FXML
    private ImageView fb;
    
   @FXML
   private ResourceBundle resources;
   @FXML
   private URL location;
   @FXML
   private Label desktop;
  
   @FXML
   private Label web;
   
   @FXML
   private HBox dock;
   
   @FXML
   private Pane panio;
   
   @FXML
    Label jsapk;
   
   @FXML
    private ImageView kadysofticon;
  
   @FXML
   private Label htmlapk;
   
   @FXML
   private Label htmlpro;
   @FXML
   private Label min;
   @FXML
   public Label jspro;
   
   
   
   @FXML
   private MediaView backvid;
   
   public static String windowsversion,MachineID;
  
   
   
   @FXML
   private Label web1;
   @FXML
   private Label web11;
   @FXML
   private Label web111;
   @FXML
   private Label web1111;
   @FXML
   private Label web11111;
   @FXML
   private Label web1111111;
   
   @FXML
   private Label cv;
   
   
   
   
   @FXML
   private Label web111111;
   
   @FXML
   private Label web11111111;
   @FXML
   private Label web111111111;
   @FXML
   private Label web1111111111;
   @FXML
   private Label web11111111111;
   @FXML
   private Label web111111111111;
   
   @FXML
   private Label web111111111112;
   
    @FXML
   private WebView buycoffee;
   
    @FXML
    private ImageView imgy;
   
    @FXML
   private Label mapk;
    @FXML
   private Label htmlapk1111;
  
   @FXML
   private Label htmlapk1;
   @FXML
   private Label htmlproo11;
   
  URL u;
   URLConnection urlc;
   
   private Label sellbl; // لتخزين الليبل المضغوط عليه
   
   @FXML
   private WebView hint;
   
   @FXML
   private JFXButton launch;
   
   
   
   
   @FXML
    void launchaction(ActionEvent event) throws IOException {
        
        if (sellbl==htmlpro) {
            
        Stage dialog = new Stage();
        dialog.initOwner(null);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initStyle(StageStyle.DECORATED); // Modern look

        Label label = new Label("Select an option:");
        label.getStyleClass().add("dialog-label");

        Button newProjectBtn = new Button("➕ New Project");
        Button openProjectBtn = new Button("📂 Open Project");

        newProjectBtn.getStyleClass().add("dialog-button");
        openProjectBtn.getStyleClass().add("dialog-button");

        newProjectBtn.setOnAction(e -> {
            dialog.close();
           
        ///////////////////////////////////////////////////////////////////    
            
            
        Stage dialog1 = new Stage();
        dialog1.initOwner(null);
        dialog1.initModality(Modality.APPLICATION_MODAL);
        dialog1.initStyle(StageStyle.DECORATED); // Modern look

        Label label1 = new Label("Select an option:");
        label1.getStyleClass().add("dialog-label");

        Button newProjectBtn1 = new Button("Single Page Project");
        Button openProjectBtn1 = new Button("Full Project");
        Button openProjectBtn11 = new Button("Full Blank Project");

        newProjectBtn1.getStyleClass().add("dialog-button");
        openProjectBtn1.getStyleClass().add("dialog-button");
        openProjectBtn11.getStyleClass().add("dialog-button");

        newProjectBtn1.setOnAction(ey -> {
            dialog1.close();
           
            //Single
               
      try {
          
      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CreateHtmlProject.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Create Html Project...");
      stg.centerOnScreen();
      //stg.initStyle(StageStyle.TRANSPARENT);
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      Stage jk = (Stage)this.desktop.getScene().getWindow();
      jk.setIconified(true);
          
      }
      
      catch (Exception m) {}
             
        });
        
        

        openProjectBtn1.setOnAction(ep -> {
            dialog1.close();
            
            //Full
           
    try {   
    String userpathh = System.getProperty("user.home");
    BufferedReader buf=new BufferedReader (new FileReader (userpathh + "/AppData/Roaming/resources/data/Settings.kady"));
    HTMLEditor_Old.codearea_color=buf.readLine().replace("CodeArea_Color=","");
    HTMLEditor_Old.font_size=buf.readLine().replace("Font_Size=","");
    
    HTMLEditor_Old.font_family=buf.readLine().replace("Font_Family=","");
    HTMLEditor_Old.font_weight=buf.readLine().replace("Font_Weight=","");
    HTMLEditor_Old.font_style=buf.readLine().replace("Font_Style=","");
    
    HTMLEditor_Old.codearea_syntax=buf.readLine().replace("CodeArea_Syntax=","");
    HTMLEditor_Old.app_theme=buf.readLine().replace("App_Theme=","");
    buf.close();
    HTMLEditor_Old.font_sizee=Double.parseDouble(HTMLEditor_Old.font_size);
    }
      
      catch (Exception j) {}
      
      
      HTMLEditor_Old edit = new HTMLEditor_Old();
      edit.start(new Stage());
             edit.newfullproject.fire();
             Stage jk = (Stage)this.desktop.getScene().getWindow();
             jk.setIconified(true);
                
             
            
        });
        
        
        openProjectBtn11.setOnAction(eop -> {
            dialog1.close();
            
            //Full
           
    try {   
    String userpathh = System.getProperty("user.home");
    BufferedReader buf=new BufferedReader (new FileReader (userpathh + "/AppData/Roaming/resources/data/Settings.kady"));
    HTMLEditor_Old.codearea_color=buf.readLine().replace("CodeArea_Color=","");
    HTMLEditor_Old.font_size=buf.readLine().replace("Font_Size=","");
    
    HTMLEditor_Old.font_family=buf.readLine().replace("Font_Family=","");
    HTMLEditor_Old.font_weight=buf.readLine().replace("Font_Weight=","");
    HTMLEditor_Old.font_style=buf.readLine().replace("Font_Style=","");
    
    HTMLEditor_Old.codearea_syntax=buf.readLine().replace("CodeArea_Syntax=","");
    HTMLEditor_Old.app_theme=buf.readLine().replace("App_Theme=","");
    buf.close();
    HTMLEditor_Old.font_sizee=Double.parseDouble(HTMLEditor_Old.font_size);
    }
      
      catch (Exception j) {}
      
      
      HTMLEditor_Old edit = new HTMLEditor_Old();
      edit.start(new Stage());
             edit.cococo();
             Stage jk = (Stage)this.desktop.getScene().getWindow();
             jk.setIconified(true);
                
             
            
        });
        

        VBox layout1 = new VBox(15, label1, newProjectBtn1, openProjectBtn1, openProjectBtn11);
        layout1.setAlignment(Pos.CENTER);
        layout1.setPadding(new Insets(30));
        layout1.getStyleClass().add("dialog-box");

        Scene scene1 = new Scene(layout1, 500, 500);
        scene1.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
        dialog1.setScene(scene1);
        dialog1.setTitle("Choose Project Type");
        dialog1.show();
       
            
            
        ///////////////////////////////////////////////////////////////////
            
      });

        openProjectBtn.setOnAction(e -> {
            dialog.close();
            System.out.println("Open Existing Project Selected");
          
    try {   
    String userpathh = System.getProperty("user.home");
    BufferedReader buf=new BufferedReader (new FileReader (userpathh + "/AppData/Roaming/resources/data/Settings.kady"));
    HTMLEditor_Old.codearea_color=buf.readLine().replace("CodeArea_Color=","");
    HTMLEditor_Old.font_size=buf.readLine().replace("Font_Size=","");
    
    HTMLEditor_Old.font_family=buf.readLine().replace("Font_Family=","");
    HTMLEditor_Old.font_weight=buf.readLine().replace("Font_Weight=","");
    HTMLEditor_Old.font_style=buf.readLine().replace("Font_Style=","");
    
    HTMLEditor_Old.codearea_syntax=buf.readLine().replace("CodeArea_Syntax=","");
    HTMLEditor_Old.app_theme=buf.readLine().replace("App_Theme=","");
    buf.close();
    HTMLEditor_Old.font_sizee=Double.parseDouble(HTMLEditor_Old.font_size);
    }
      
      catch (Exception j) {}
            
             HTMLEditor_Old editt = new HTMLEditor_Old();
             editt.start(new Stage());
             editt.codeArea.setDisable(true);
             editt.codee.setDisable(true);
             //editt.openf.fire();
             
             Stage jk = (Stage)this.desktop.getScene().getWindow();
             jk.setIconified(true);
            
//            try {
//          
//      Stage stg = new Stage();
//      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CreateHtmlProject.fxml"));
//      Scene sce = new Scene(root);
//      stg.setTitle("Create Html Project...");
//      stg.centerOnScreen();
//      //stg.initStyle(StageStyle.TRANSPARENT);
//      stg.setResizable(false);
//      stg.setScene(sce);
//      stg.show();
//      //com.sun.glass.ui.Window.getWindows().get(0).setUndecoratedMoveRectangle(30);
//      Stage jk = (Stage)this.desktop.getScene().getWindow();
//      jk.setIconified(true);
//          
//      }
//      
//      catch (Exception m) {}
            
            
        });

        VBox layout = new VBox(15, label, newProjectBtn, openProjectBtn);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));
        layout.getStyleClass().add("dialog-box");

        Scene scene = new Scene(layout, 500, 500);
        scene.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
        dialog.setTitle("Choose Project Method");
        dialog.setScene(scene);
        dialog.show();
       
            
        }
        
        
        
        
        if (sellbl==jspro) { //JS Project
            
      Stage stg = new Stage();
      
      org.sandsoft.tests.Main min=new org.sandsoft.tests.Main();
       try {
           min.start(stg);
           
           
            //  JsEditor edit = new JsEditor();
          //   edit.js_Editor();
       } catch (IOException ex) {
           Logger.getLogger(CreateJsProjectController.class.getName()).log(Level.SEVERE, null, ex);
       }
      // String FullPathh = CreateJsProjectController.f1.toString();
      
      Stage jk = (Stage)this.desktop.getScene().getWindow();
      jk.setIconified(true);
            
        }
        
        if (sellbl==jsapk) {  //JS Apk
            
            
            
Alert alertio = new Alert(Alert.AlertType.CONFIRMATION);
alertio.setTitle("Create JS APK");
alertio.setHeaderText("JS APK Choose:");
alertio.setContentText("What is the type you need?");
javafx.scene.control.ButtonType buttonTypeOne = new javafx.scene.control.ButtonType("Native");
javafx.scene.control.ButtonType buttonTypeCancel = new javafx.scene.control.ButtonType("HyBird");
alertio.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
DialogPane dialogPaneii = alertio.getDialogPane();
dialogPaneii.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<javafx.scene.control.ButtonType> results = alertio.showAndWait();
if (results.isPresent() && results.get() == buttonTypeOne) {
    
    //Native
             
      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CreateJsApk.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Create JS APK (Native)...");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      Stage jk = (Stage)this.desktop.getScene().getWindow();
      jk.setIconified(true);
    
}


else {
      

    //HyBird
    
             
      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CreateJsApkk.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Create JS APK (HyBird)...");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      Stage jk = (Stage)this.desktop.getScene().getWindow();
      jk.setIconified(true);

    
        }
            
            
            
   
            
        }
        
        if (sellbl==htmlapk1111) { //PDF Apk
            
      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CreateAPKPDF.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Create APK PDF APP...");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      Stage jk = (Stage)this.desktop.getScene().getWindow();
      jk.setIconified(true);
            
        }
        
        if (sellbl==htmlapk) { //HTML Aok
            
                
      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CreateHtmlApk.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Create Html APK...");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      Stage jk = (Stage)this.desktop.getScene().getWindow();
      jk.setIconified(true);
            
        }
        
        if (sellbl==mapk) { //Music Apk
            
      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("ChooseMusic.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Choose Music Theme");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      Stage jk = (Stage)this.desktop.getScene().getWindow();
      jk.setIconified(true);
            
        }
        
        if (sellbl==htmlapk1) { //Eagle Apk
            
      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CordovaChoose.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Choose Eagle App Type");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      Stage jk = (Stage)this.desktop.getScene().getWindow();
      jk.setIconified(true);
            
        }
        
        if (sellbl==desktop) { //Desktop web
            
      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CreateDesktop.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Create Desktop Program...");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      Stage jk = (Stage)this.desktop.getScene().getWindow();
      jk.setIconified(true);
            
        }
        
        if (sellbl==web) { //Desktop link
            
      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CreateWeb.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Create Web Program...");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      Stage jk = (Stage)this.desktop.getScene().getWindow();
      jk.setIconified(true);
            
        }
        
        else {}
        
        
        
    }
    
    
  public void webpage(String nam, String des) {
    String htmlcode = "<!DOCTYPE html>\n" +
    "<html lang='en'>\n" +
    "<head>\n" +
    "  <meta charset='UTF-8'>\n" +
    "  <title>Project Info</title>\n" +
    "  <link href='https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap' rel='stylesheet'>\n" +
    "  <style>\n" +
    "    body {\n" +
    "      background: #f9f9f9;\n" +
    "      display: flex;\n" +
    "      justify-content: center;\n" +
    "      align-items: center;\n" +
    "      height: 100vh;\n" +
    "      margin: 0;\n" +
    "      font-family: 'Poppins', sans-serif;\n" +
    "      color: #333;\n" +
    "      animation: fadeIn 1s ease;\n" +
    "    }\n" +
    "    @keyframes fadeIn {\n" +
    "      from { opacity: 0; transform: translateY(20px); }\n" +
    "      to { opacity: 1; transform: translateY(0); }\n" +
    "    }\n" +
    "    .card {\n" +
    "      background: #ffffff;\n" +
    "      border-radius: 16px;\n" +
    "      box-shadow: 0 8px 24px rgba(0, 0, 0, 0.1);\n" +
    "      padding: 30px;\n" +
    "      width: 360px;\n" +
    "      transition: 0.3s ease;\n" +
    "      animation: fadeIn 0.8s ease;\n" +
    "    }\n" +
    "    .card:hover {\n" +
    "      transform: translateY(-5px);\n" +
    "      box-shadow: 0 12px 32px rgba(0, 0, 0, 0.15);\n" +
    "    }\n" +
    "    .card-header {\n" +
    "      margin-bottom: 20px;\n" +
    "      border-bottom: 2px solid #eaeaea;\n" +
    "      padding-bottom: 10px;\n" +
    "    }\n" +
    "    .card-header h2 {\n" +
    "      font-size: 22px;\n" +
    "      color: #222;\n" +
    "      margin: 0;\n" +
    "    }\n" +
    "    .card-content p {\n" +
    "      font-size: 16px;\n" +
    "      line-height: 1.6;\n" +
    "      margin: 10px 0;\n" +
    "    }\n" +
    "    .card-content strong {\n" +
    "      color: #000;\n" +
    "    }\n" +
    "    .card-footer {\n" +
    "      margin-top: 20px;\n" +
    "      text-align: right;\n" +
    "    }\n" +
    "  </style>\n" +  // important fix here!
    "</head>\n" +
    "<body>\n" +
    "  <div class='card'>\n" +
    "    <div class='card-header'>\n" +
    "      <h2>Project Info</h2>\n" +
    "    </div>\n" +
    "    <div class='card-content'>\n" +
    "      <p><strong>Name:</strong> " + nam + "</p>\n" +
    "      <p><strong>Description:</strong> " + des + "</p>\n" +
    "      <p><strong>Version:</strong> 25.0.1</p>\n" +
    "    </div>\n" +
    "    <div class='card-footer'>\n" +
    "    </div>\n" +
    "  </div>\n" +
    "</body>\n" +
    "</html>";

    hint.getEngine().setJavaScriptEnabled(true);
    hint.getEngine().loadContent(htmlcode, "text/html");  // more explicit
}

   
   
   /////////////////////////////////////////////////////////////
   
    @FXML
    void fbact(MouseEvent event) {

      
       
       Desktop desk = Desktop.getDesktop();
        try {
            desk.browse(new URI("https://www.facebook.com/kadysoft"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
     @FXML
    void paniomc (MouseEvent event) {

      
       
      
    }
    
    

    @FXML
    void gitact(MouseEvent event) {

        Desktop desk = Desktop.getDesktop();
         try {
            desk.browse(new URI("https://kadysoftltd.github.io/kadysoft/"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //////////////////////////////////////////////////GITS//////////////////////////////////////////////////////////////////////////////////

     @FXML
    void git1act(MouseEvent event) {

        Desktop desk = Desktop.getDesktop();
         try {
            desk.browse(new URI("https://t.me/kadinio"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    void git2act(MouseEvent event) {

        Desktop desk = Desktop.getDesktop();
         try {
            desk.browse(new URI("https://www.instagram.com/Kadysoft_Ltd/"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    void git3act(MouseEvent event) {

        Desktop desk = Desktop.getDesktop();
         try {
            desk.browse(new URI("https://wa.me/+201555266002"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    void git4act(MouseEvent event) {

        Desktop desk = Desktop.getDesktop();
         try {
            desk.browse(new URI("https://www.linkedin.com/in/ahmed-elkady-9a4529162"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    void git5act(MouseEvent event) {

        Desktop desk = Desktop.getDesktop();
        try {
            desk.open(new File("C:\\Program Files (x86)\\Kadysoft\\Eagle IDE\\tools\\Rating\\Rating.html"));
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    void git6act(MouseEvent event) {

        Desktop desk = Desktop.getDesktop();
         try {
            desk.browse(new URI("https://www.youtube.com/@kadysoft"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    void git7act(MouseEvent event) {

        Desktop desk = Desktop.getDesktop();
         try {
            desk.browse(new URI("https://kadysoft.mystrikingly.com"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    void git8act(MouseEvent event) {

        Desktop desk = Desktop.getDesktop();
        try {
            desk.open(new File("C:\\Program Files (x86)\\Kadysoft\\Eagle IDE\\tools\\Asking\\Ask.html"));
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    void git9act(MouseEvent event) {

        Desktop desk = Desktop.getDesktop();
        try {
            desk.open(new File("C:\\Program Files (x86)\\Kadysoft\\Eagle IDE\\tools\\Bug\\Bug.html"));
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    void git10act(MouseEvent event) {

         Desktop desk = Desktop.getDesktop();
        try {
            desk.open(new File("C:\\Program Files (x86)\\Kadysoft\\Eagle IDE\\tools\\Message\\Message.html"));
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    void git11act(MouseEvent event) {

        Desktop desk = Desktop.getDesktop();
        try {
            desk.open(new File("C:\\Program Files (x86)\\Kadysoft\\Eagle IDE\\tools\\About\\About.html"));
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    void gmact(MouseEvent event) {

        Desktop desk = Desktop.getDesktop();
         try {
            desk.browse(new URI("https://kadysoft.mystrikingly.com"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    void appact(MouseEvent event) { //Upload it to Sourceforge and get the link

        Desktop desk = Desktop.getDesktop();
         try {
            desk.browse(new URI("https://drive.google.com/file/d/1PtqkMU1AjcSrfIxo8xFfHkXFJL0Zv0Qx/view?usp=drivesdk"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void clsact(MouseEvent event) {

        System.exit(0);
    }

    
   
   /////////////////////////////////////////////////////////////
   
   
    
    

   @FXML
   void htmlproact(MouseEvent event) throws IOException {
       
       sellbl=htmlpro;
       String deso="Create professional web project to deliver modern, responsive, and efficient user experiences using HTML, CSS, and JavaScript.";   
       String nom=sellbl.getText();
       webpage(nom,deso);
       hint.setVisible(true);
       launch.setVisible(true);
       
       
      
   }
   
   
   

   @FXML
   void jsproact(MouseEvent event) throws IOException {
      
       
       sellbl=jspro;
       String deso="Interactive and scalable project built with JavaScript for dynamic web solutions.";
       String nom=sellbl.getText();
       webpage(nom,deso);
       hint.setVisible(true);
       launch.setVisible(true); 
       
       
      
   }
   
   
   
   /////////////////////////////////////////
   @FXML
   void htmlapkact1111(MouseEvent event) throws IOException {
       
       
       sellbl=htmlapk1111;
       String deso="Android APK project for smooth and efficient PDF viewing and management.";
       String nom=sellbl.getText();
       webpage(nom,deso);
       hint.setVisible(true);
       launch.setVisible(true);
       
       
  
   }
   
   
   
   /////////////////////////////////////////
   @FXML
   void mapkact(MouseEvent event) throws IOException {
      
       sellbl=mapk;
       String deso="Android APK project for seamless music playback and management.";
       String nom=sellbl.getText();
       webpage(nom,deso);
       hint.setVisible(true);
       launch.setVisible(true);
       
   
   }
   
   

   @FXML
   void htmlapkact(MouseEvent event) throws IOException {
      
       
       sellbl=htmlapk;
       String deso="Android APK project for viewing and interacting with HTML content offline.";
       String nom=sellbl.getText();
       webpage(nom,deso);
       hint.setVisible(true);
       launch.setVisible(true);
       
       
   
   }
   
   
   
   @FXML
   void cvact(MouseEvent event) throws IOException {
      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("CVChoose.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Choose CV Type");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.show();
      Stage jk = (Stage)this.desktop.getScene().getWindow();
      jk.setIconified(true);
   }
   
   
   
   
   @FXML
   void htmlapkact1(MouseEvent event) throws IOException {
      
       
       sellbl=htmlapk1;
       String deso="Android APK project for viewing and interacting with HTML content offline, like apps, web games, quiz app and more.";
       String nom=sellbl.getText();
       webpage(nom,deso);
       hint.setVisible(true);
       launch.setVisible(true);
       
      
   }
   
   @FXML
   void htmlproact11(MouseEvent event) throws IOException {
       String userpathh = System.getProperty("user.home");
                      Desktop desky = Desktop.getDesktop();
                      desky.open(new File(userpathh + "/AppData/Roaming/resources/data/ZombieRunner.jar"));

      Stage jk = (Stage)this.desktop.getScene().getWindow();
      jk.setIconified(true);
   }
   
   


   @FXML
   void jsapkact(MouseEvent event) throws IOException {
      
       
       sellbl=jsapk;
       String deso="Android APK project for running JavaScript-powered apps smoothly on mobile.";
       String nom=sellbl.getText();
       webpage(nom,deso);
       hint.setVisible(true);
       launch.setVisible(true);
       
      
   }
   
   
   

   @FXML
   void desktopact(MouseEvent event) throws IOException {
      
       sellbl=desktop;
       String deso="Desktop app project using HTML for fast and flexible user interfaces.";
       String nom=sellbl.getText();
       webpage(nom,deso);
       hint.setVisible(true);
       launch.setVisible(true);
       
       
      
   }
   
   
   

   @FXML
   void webact(MouseEvent event) throws IOException {
      
       sellbl=web;
       String deso="Desktop app project for launching and viewing a website link directly from your PC.";
       String nom=sellbl.getText();
       webpage(nom,deso);
       hint.setVisible(true);
       launch.setVisible(true);
       
       
      
   }

   @FXML
   void setact(Event event) throws IOException {
      String toool = this.set.getSelectionModel().getSelectedItem().toString();
      if (toool.equals("Settings")) {
         

      }
     else if (toool.equals("Help")) {
         String userpathh = System.getProperty("user.home");
                      Desktop desky = Desktop.getDesktop();
          try {
              desky.open(new File(userpathh + "/AppData/Roaming/resources/data/Eagle_Help.exe"));
          } catch (IOException ex) {
              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
          }
          set.getSelectionModel().select(0);

      }
     else if (toool.equals("About")) {
         
          String userpathh = System.getProperty("user.home");
                      Desktop desky = Desktop.getDesktop();
          try {
              desky.open(new File(userpathh + "/AppData/Roaming/resources/data/About.exe"));
          } catch (IOException ex) {
              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
          }
          set.getSelectionModel().select(0);

      }
     /*
      else if (toool.equals("Update")) { //Sourceforge link
         

           Desktop desk = Desktop.getDesktop();
         try {
            desk.browse(new URI("https://sourceforge.net/p/kseagle/"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
         set.getSelectionModel().select(0);
      }
      */
      else if (toool.equals("Buy Key")) {
         
           
       Alert alert=new Alert (Alert.AlertType.CONFIRMATION);
       alert.setTitle("Buy");
       alert.setHeaderText("Buy the key!...");
       alert.setResizable(false);
       alert.setContentText("Call me via Whatsapp on +201555266002\nSend money on +01154073811.\nOr via Instapay on +201555266002.");
       DialogPane dialogPane = alert.getDialogPane();
       dialogPane.getStylesheets().add(
     getClass().getResource("cupertino-light.css").toExternalForm());
       //WebView ghhhh=new WebView();
       //ghhhh.setPrefSize(400, 200);
       //ghhhh.getEngine().loadContent("<big style=\"color:red;\"><b>Hi, user!\nPlease make sure that you had transfered 50 EGP to this number: <mark>+201154073811</mark>\nThen copy your number beside your name in browser's name textfield and your PC MAC number.\n You can get your ID Number via our tool in settings (Get My ID).\n\n"
       //+ "For forigners: You can transfer 10 dollars to Kadysoft via Paypal\nhttps://www.paypal.me/Kadysoft</b>");
       
       //ghhhh.getEngine().loadContent("");
       
       //alert.getDialogPane().setContent(ghhhh);
       alert.showAndWait();
       
       Desktop desk = Desktop.getDesktop();
         try {
            //desk.browse(new URI("https://kadysoft.mystrikingly.com"));
            desk.browse(new URI("https://wa.me/+201555266002/"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
         set.getSelectionModel().select(0);

      }
      else if (toool.equals("Uninstall")) {
         

          
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Uninstall");
      alert.setHeaderText("Uninstalling Eagle!.");
      alert.setContentText("Are you sure, you wanna uninstall Eagle?");
      DialogPane dialogPane = alert.getDialogPane();
      dialogPane.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<javafx.scene.control.ButtonType> option = alert.showAndWait();
      if (option.get() == null) {
      } else if (option.get() == javafx.scene.control.ButtonType.OK) {
       Desktop desky = Desktop.getDesktop();
          try {
              desky.open(new File("C:\\Program Files (x86)\\Kadysoft\\Eagle IDE\\Uninstall.exe"));
          } catch (IOException ex) {
              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
          }
          set.getSelectionModel().select(0);
      }
      else if (option.get() == javafx.scene.control.ButtonType.CANCEL) {
      
      }
      else {}
          
          
          
          
          
          
          
          
                     
      }
      else if (toool.equals("Get My ID")) {
         /*
          
           File batfile5 = new File(System.getProperty("user.home")+"\\KadyID.bat");

      try {
         batfile5.createNewFile();
      } catch (IOException var1237) {
         ;
      }

      try {
         PrintWriter pwwu = new PrintWriter(new FileWriter(batfile5));
         pwwu.println("wmic bios get serialnumber\ncmd /k");
         pwwu.close();
      } catch (IOException var1236) {
         ;
      }
      
      
 
          String userpath = System.getProperty("user.home");
               userpath = userpath + "\\KadyID.bat";
             Desktop  sgd = Desktop.getDesktop();

               try {
                  sgd.open(new File(userpath));
                  return;
               } catch (IOException var11) {
                  ;
               }
          */
            String command="wmic bios get serialnumber";
              StringBuffer output=new StringBuffer();
              try {
//                  Process SerNumProcess=Runtime.getRuntime().exec(command);
//                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
//                   String line="";
//                   while ((line=sNumReader.readLine())!=null) {
//                       output.append(line+"\n");
//                   }
//                   String MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
//                   
                   

                     ////////////////Machine ID////////////////
    
         //////////////////////////////////////////////////
          
          String batchcode="@echo off\n" +
"for /f \"tokens=3\" %%a in ('reg query \"HKLM\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\" /v CurrentBuild') do (\n" +
"    if %%a geq 22000 (\n" +
"        echo Windows 11\n" +
"    ) else (\n" +
"        echo Windows 10\n" +
"    )\n" +
")\n" +
"";
          String pathofbat=System.getProperty("user.home")+"\\kadinio.bat";
          File fafa=new File (pathofbat);
          fafa.deleteOnExit();
          PrintWriter paq=new PrintWriter (new FileWriter (fafa));
          paq.println(batchcode);
          paq.close();
          
            try {
            ProcessBuilder processBuilder = new ProcessBuilder(pathofbat);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
            //System.out.println(line);
            windowsversion=line;
            }
            int exitCode = process.waitFor();
            //System.out.println("Batch file executed with exit code: " + exitCode);
            } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            }
 
            if (windowsversion.equals("Windows 10")) {
                
                //Windows10
                
              String command1="wmic bios get serialnumber";
              StringBuffer output1=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command1);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output1.append(linee+"\n");
                   }
                   MachineID=output1.toString().substring(output1.indexOf("\n"),output1.length()).trim();
                   
                
                
            }
            
            else if (windowsversion.equals("Windows 11")) {
                
                //Windows11
                
              String command2="powershell Get-CimInstance -ClassName Win32_BIOS | Select-Object SerialNumber";
              StringBuffer output2=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command2);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output2.append(linee+"\n");
                   }
                   MachineID=output2.toString().substring(output2.indexOf("\n"),output2.length()).trim().replace("SerialNumber","").replace("------------","").replace("\n","");
                
                
            }
            
            else {
                
                //Windows7 or less like windows 10
                
              String command3="wmic bios get serialnumber";
              StringBuffer output3=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command3);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output3.append(linee+"\n");
                   }
                   MachineID=output3.toString().substring(output3.indexOf("\n"),output3.length()).trim();
                
                
            }
                 
                   
                   
//                   //System.out.println(MachineID);
//                   Alert alert=new Alert (Alert.AlertType.INFORMATION);
//       alert.setTitle("Get My ID");
//       alert.setHeaderText("ID!...");
//       alert.setResizable(false);
//       alert.setContentText(MachineID);
//       alert.showAndWait();
//       
//       
       
       Stage dialog = new Stage();
        dialog.initOwner(null);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initStyle(StageStyle.UNDECORATED);

        Label title = new Label("🔒 Machine ID:");
        title.getStyleClass().add("dialog-label");

        Label serialLabel = new Label(MachineID);
        serialLabel.getStyleClass().add("dialog-value");

        Button okBtn = new Button("OK");
        okBtn.getStyleClass().add("dialog-button");
        okBtn.setOnAction(e -> dialog.close());

        VBox layout = new VBox(15, title, serialLabel, okBtn);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));
        layout.getStyleClass().add("dialog-box");

        Scene scene = new Scene(layout, 350, 200);
        scene.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
        dialog.setScene(scene);
        dialog.show();
       
       
       
       
       
              
              } catch (IOException ex) {
                  Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
              }
              set.getSelectionModel().select(0);
                  
      }
       else if (toool.equals("Register")) {
           
           
        Stage dialog = new Stage();
        dialog.initOwner(null);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initStyle(StageStyle.UNDECORATED);

        Label title = new Label("🔒 Register:");
        title.getStyleClass().add("dialog-label");

        JFXPasswordField tf=new JFXPasswordField ();
        tf.setFont(Font.font(13));
        tf.setLabelFloat(true);
        tf.setPromptText("Write Serial Key ...");
        tf.getStyleClass().add("dialog-textfield");
          
          JFXButton btn=new JFXButton("Register");
          btn.setEffect(new DropShadow());
          btn.setFont(Font.font(12));
          btn.setStyle("-fx-background-color:green;");
          btn.getStyleClass().add("dialog-button");
          
             
          btn.setOnAction((ActionEvent t) -> {
              /*
              try {
                  String command="wmic bios get serialnumber";
                  StringBuffer output=new StringBuffer();
                  try {
                      Process SerNumProcess=Runtime.getRuntime().exec(command);
                      BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                      String line="";
                      while ((line=sNumReader.readLine())!=null) {
                          output.append(line+"\n");
                      }
                      String MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                      StringBuilder sb=new StringBuilder(MachineID);
                      String reverse=sb.reverse().toString();
                      //System.out.println(MachineID);
                      Alert alert=new Alert (Alert.AlertType.INFORMATION);
                      alert.setTitle("Register");
                      alert.setHeaderText("Attention!...");
                      alert.setResizable(false);
                      alert.setContentText(MachineID+"A"+reverse+"I"+MachineID+"A"+reverse+"R"+MachineID);
                      alert.showAndWait();
                      
                  } catch (IOException ex) {
                      Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  
                 
                  
              } 
              */
               //////////////////////////////////////////////////
                  String ser=tf.getText();
                  File f=new File (System.getProperty("user.home")+"\\kady.kady");
              try {
                  f.createNewFile();
              } catch (IOException ex) {
                  Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
              }
                  
                  PrintWriter pw;
              try {
                  pw = new PrintWriter (new FileWriter (f));
                  pw.println(ser);
                  pw.close();
              } catch (IOException ex) {
                  Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
              }
             
                      Alert alert=new Alert (Alert.AlertType.INFORMATION);
                      alert.setTitle("Eagle");
                      alert.setHeaderText("Register!...");
                      alert.setResizable(false);
                      alert.setContentText("Please Restart Eagle to test the registeration.");
                      
                      DialogPane dialogPane = alert.getDialogPane();
                      dialogPane.getStylesheets().add(
                    getClass().getResource("cupertino-light.css").toExternalForm());
                     
                      alert.showAndWait();
                      dialog.close();
                  
                  //////////////////////////////////////////////////
             
          });
          
      

        VBox layout = new VBox(15, title, tf, btn);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));
        layout.getStyleClass().add("dialog-box");

        Scene scene = new Scene(layout, 350, 200);
        scene.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
        dialog.setScene(scene);
        dialog.show();
           
        
        
          set.getSelectionModel().select(0);
      }
      else {
          
      }
      
      
      
      
   }
   

   
   @FXML
   void web1act(MouseEvent event) throws URISyntaxException, IOException {
            Stage sttg = new Stage();
            JFXTextField tx = new JFXTextField("https://");
            tx.setMinSize(300.0D, 40.0D);
            tx.setEditable(true);
            tx.setFont(Font.font("dialog", 15.0D));
            tx.setPromptText("Don't forget 'https://'.");
            tx.setLabelFloat(true);
            tx.setStyle("-fx-background-color:white;-fx-background-radius:3em;");
            tx.setTooltip(new Tooltip("Please Write 'https://' before the URL or don't delete it."));
            JFXButton sxa = new JFXButton("Get HTML&Save");
            sxa.setButtonType(ButtonType.RAISED);
            sxa.setEffect(new DropShadow(1.0D, Color.BLACK));
            sxa.setFont(Font.font("dialog", FontWeight.BOLD, 15.0D));
            sxa.setStyle("-fx-background-color:green;-fx-text-fill:white;");
            sxa.setMinSize(80.0D, 40.0D);
            sxa.setOnAction((rr) -> {
               FileChooser fc = new FileChooser();
               fc.getExtensionFilters().add(new ExtensionFilter("Text File", new String[]{"txt"}));
               File fxl1 = fc.showSaveDialog((Window)null);
               String axs = fxl1.getAbsolutePath().toString();
               File path = new File(axs + ".txt");
               String url = tx.getText();

               try {
                  this.u = new URL(url);
               } catch (MalformedURLException var13) {
                  ;
               }

               try {
                  this.urlc = this.u.openConnection();
               } catch (IOException var12) {
                  ;
               }

               try {
                  BufferedReader buf = new BufferedReader(new InputStreamReader(this.urlc.getInputStream()));
                  PrintWriter pw = new PrintWriter(new FileWriter(path));
                  String line = buf.readLine();

                  while(line != null) {
                     line = buf.readLine();
                     pw.print(line);
                  }

                  buf.close();
                  pw.close();
                  sttg.close();
               } catch (IOException var14) {
                  ;
               }

            });
            VBox bnm = new VBox();
            bnm.setSpacing(20.0D);
            bnm.setAlignment(Pos.CENTER);
            bnm.getChildren().addAll(new Node[]{tx, sxa});
            Scene rhl = new Scene(bnm, 400.0D, 100.0D);
            sttg.setScene(rhl);
            sttg.setTitle("Get HTML");
            sttg.setResizable(false);
            sttg.centerOnScreen();
            // sttg.setAlwaysOnTop(true);
            sttg.show();
   }
  
   @FXML
   void web11act(MouseEvent event) throws URISyntaxException, IOException {
       
        String userpath = System.getProperty("user.home");
               userpath = userpath + "/AppData/Roaming/resources/data/WebGUI.jar";
             Desktop  sgd = Desktop.getDesktop();

               try {
                  sgd.open(new File(userpath));
                  return;
               } catch (IOException var11) {
                  ;
               }
   }
   @FXML
   void web111act(MouseEvent event) throws URISyntaxException, IOException {
       
       String  userpath = System.getProperty("user.home");
               userpath = userpath + "/AppData/Roaming/resources/data/SimbaWEB.jar";
              Desktop sgd = Desktop.getDesktop();

               try {
                  sgd.open(new File(userpath));
                  return;
               } catch (IOException var10) {
                  ;
               }
   }
   @FXML
   void web1111act(MouseEvent event) throws URISyntaxException, IOException {
       
       Stage  sttg = new Stage();
               String   userpath = System.getProperty("user.home");
                 String html = userpath + "/AppData/Roaming/resources/data/user/wysiwyg.html";
                 URI uri = Paths.get(html).toAbsolutePath().toUri();
                WebView  root = new WebView();
                  root.getEngine().load(uri.toString());
                  sttg.setTitle("Eagle WYSIWUG");
                  sttg.setScene(new Scene(root, 1024.0D, 670.0D));
                  sttg.centerOnScreen();
                  sttg.setResizable(false);
                  sttg.show();
   }
   @FXML
   void web11111act(MouseEvent event) throws URISyntaxException, IOException {
       
        String userpathh = System.getProperty("user.home");
                      Desktop desky = Desktop.getDesktop();
                      desky.open(new File(userpathh + "/AppData/Roaming/resources/data/JarBuilder.jar"));

   }
   @FXML
   void web111111act(MouseEvent event) throws URISyntaxException, IOException {
       

       Stage sttg = new Stage();
                  String   userpath = System.getProperty("user.home");
                  String   html = userpath + "/AppData/Roaming/resources/data/qrcode/data/index.html";
                  URI   uri = Paths.get(html).toAbsolutePath().toUri();
                    WebView root = new WebView();
                     root.getEngine().load(uri.toString());
                     sttg.setTitle("QR Code Creator");
                     sttg.setScene(new Scene(root, 1024.0D, 670.0D));
                     sttg.centerOnScreen();
                     sttg.setResizable(false);
                     sttg.show();
   }
    @FXML
   void web1111111act(MouseEvent event) throws URISyntaxException, IOException {
      Desktop  desk = Desktop.getDesktop();
                     desk.open(new File("C:\\Program Files (x86)\\Kadysoft\\Eagle IDE\\docs\\htmltuts\\main.html"));

   }
    @FXML
   void web11111111act(MouseEvent event) throws URISyntaxException, IOException {
       

       Desktop  desk = Desktop.getDesktop();
                     desk.open(new File("C:\\Program Files (x86)\\Kadysoft\\Eagle IDE\\docs\\csstuts\\main.html"));
   }
    @FXML
   void web111111111act(MouseEvent event) throws URISyntaxException, IOException {
       Desktop desk = Desktop.getDesktop();
                     desk.open(new File("C:\\Program Files (x86)\\Kadysoft\\Eagle IDE\\docs\\jstuts\\main.html"));

   }
    @FXML
   void web1111111111act(MouseEvent event) throws URISyntaxException, IOException {
      Stage  sttg = new Stage();
                  String   userpath = System.getProperty("user.home");
                  String   html = userpath + "/AppData/Roaming/resources/data/docs/Docs.htm";
                  URI   uri = Paths.get(html).toAbsolutePath().toUri();
                   WebView  root = new WebView();
                     root.getEngine().load(uri.toString());
                     sttg.setTitle("8: JS Android Tutorials");
                     sttg.setScene(new Scene(root, 1024.0D, 670.0D));
                     sttg.centerOnScreen();
                     sttg.setResizable(false);
                     sttg.show();

   }
    @FXML
   void web11111111111act(MouseEvent event) throws URISyntaxException, IOException {
         Stage stg = new Stage();
                      Parent rootj = (Parent)FXMLLoader.load(this.getClass().getResource("JAR2EXE.fxml"));
                      Scene sce = new Scene(rootj);
                      stg.setTitle("JAR2EXE");
                      stg.centerOnScreen();
                      //stg.initStyle(StageStyle.TRANSPARENT);
                      stg.setResizable(false);
                      stg.setScene(sce);
                      stg.show();

   }
   @FXML
   void web111111111111act(MouseEvent event) throws URISyntaxException, IOException {
       
        String userpathh = System.getProperty("user.home");
                      Desktop desky = Desktop.getDesktop();
                      desky.open(new File(userpathh + "/AppData/Roaming/resources/data/ImageResizer.jar"));


   }
   @FXML
   void web111111111112act(MouseEvent event) throws URISyntaxException, IOException {
       
        String userpathh = System.getProperty("user.home");
                      Desktop desky = Desktop.getDesktop();
                      desky.open(new File(userpathh + "/AppData/Roaming/resources/data/Piano.jar"));


   }
   
   
   @FXML
   void minact(MouseEvent event) {
         
      Stage jk = (Stage)this.desktop.getScene().getWindow();
      jk.setIconified(true);
    
   }
   @FXML
   void enterdock(MouseEvent event) {
       
     dock.setOpacity(0.6);
    
   }
   @FXML
   void exitdock(MouseEvent event) {
       
    dock.setOpacity(0.3);
       
   }

   public void initialize(URL location, ResourceBundle resources) {
       
       
       //////////////////////////////////////////////////////////////////////////
       
//       PulseTransition pt1=new PulseTransition (htmlpro);
//       pt1.setAutoReverse(true);
//       pt1.setCycleCount(1000000000);
//       pt1.play();
//       
//       PulseTransition pt2=new PulseTransition (desktop);
//       pt2.setAutoReverse(true);
//       pt2.setCycleCount(1000000000);
//       pt2.play();
//       
//       PulseTransition pt3=new PulseTransition (jsapk);
//       pt3.setAutoReverse(true);
//       pt3.setCycleCount(1000000000);
//       pt3.play();
//       
//       PulseTransition pt4=new PulseTransition (htmlapk1111);
//       pt4.setAutoReverse(true);
//       pt4.setCycleCount(1000000000);
//       pt4.play();
//       
//       PulseTransition pt5=new PulseTransition (jspro);
//       pt5.setAutoReverse(true);
//       pt5.setCycleCount(1000000000);
//       pt5.play();
//       
//       PulseTransition pt6=new PulseTransition (htmlapk);
//       pt6.setAutoReverse(true);
//       pt6.setCycleCount(1000000000);
//       pt6.play();
//       
//       PulseTransition pt7=new PulseTransition (htmlapk1);
//       pt7.setAutoReverse(true);
//       pt7.setCycleCount(1000000000);
//       pt7.play();
//       
//       PulseTransition pt8=new PulseTransition (mapk);
//       pt8.setAutoReverse(true);
//       pt8.setCycleCount(1000000000);
//       pt8.play();
//       
//       PulseTransition pt9=new PulseTransition (web);
//       pt9.setAutoReverse(true);
//       pt9.setCycleCount(1000000000);
//       pt9.play();
       
//       PulseTransition pt10=new PulseTransition (htmlpro);
//       pt10.setAutoReverse(true);
//       pt10.setCycleCount(1000000000);
//       pt10.play();
       
       
       //////////////////////////////////////////////////////////////////////////
       
       
       
       ShakeTransition ft=new ShakeTransition(kadysofticon);
       ft.setAutoReverse(true);
       ft.setCycleCount(1000000);
    //   ft.play();
       
       /////////////////////////////////////////////////////////////////////////
        //set.getItems().addAll(new Object[]{"Settings","Help","About","Buy Key","Uninstall","Get My ID","Register"});
        set.getItems().addAll(new Object[]{"Buy Key","Uninstall","Get My ID","Register"});
        set.getSelectionModel().select(0);
                  
      
        
         
        
        
       ///////////////////////////////////////////////
        String command="wmic bios get serialnumber";
        StringBuffer output=new StringBuffer();
        File fg=new File (System.getProperty("user.home")+"\\kady.kady");
        
        
        if (fg.exists()) {
            try {
                
                
//                Process SerNumProcess=Runtime.getRuntime().exec(command);
//                BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
//                String lineo="";
//                while ((lineo=sNumReader.readLine())!=null) {
//                          output.append(lineo+"\n");
//                      }
//                String MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                
                
         ////////////////Machine ID////////////////
    
         //////////////////////////////////////////////////
          
          String batchcode="@echo off\n" +
"for /f \"tokens=3\" %%a in ('reg query \"HKLM\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\" /v CurrentBuild') do (\n" +
"    if %%a geq 22000 (\n" +
"        echo Windows 11\n" +
"    ) else (\n" +
"        echo Windows 10\n" +
"    )\n" +
")\n" +
"";
          String pathofbat=System.getProperty("user.home")+"\\kadinio.bat";
          File fafa=new File (pathofbat);
          fafa.deleteOnExit();
          PrintWriter paq=new PrintWriter (new FileWriter (fafa));
          paq.println(batchcode);
          paq.close();
          
            try {
            ProcessBuilder processBuilder = new ProcessBuilder(pathofbat);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
            //System.out.println(line);
            windowsversion=line;
            }
            int exitCode = process.waitFor();
            //System.out.println("Batch file executed with exit code: " + exitCode);
            } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            }
 
            if (windowsversion.equals("Windows 10")) {
                
                //Windows10
                
              String command1="wmic bios get serialnumber";
              StringBuffer output1=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command1);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output1.append(linee+"\n");
                   }
                   MachineID=output1.toString().substring(output1.indexOf("\n"),output1.length()).trim();
                   
                
                
            }
            
            else if (windowsversion.equals("Windows 11")) {
                
                //Windows11
                
              String command2="powershell Get-CimInstance -ClassName Win32_BIOS | Select-Object SerialNumber";
              StringBuffer output2=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command2);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output2.append(linee+"\n");
                   }
                   MachineID=output2.toString().substring(output2.indexOf("\n"),output2.length()).trim().replace("SerialNumber","").replace("------------","").replace("\n","");
                
                
            }
            
            else {
                
                //Windows7 or less like windows 10
                
              String command3="wmic bios get serialnumber";
              StringBuffer output3=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command3);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output3.append(linee+"\n");
                   }
                   MachineID=output3.toString().substring(output3.indexOf("\n"),output3.length()).trim();
                
                
            }
            
                
                StringBuilder sb=new StringBuilder(MachineID);
                String reverse=sb.reverse().toString();
                String NewText=MachineID+"KADY"+reverse+"AIAR"+reverse;
                
                BufferedReader buf=new BufferedReader (new FileReader (fg));
                String line=buf.readLine();
                if (line.equals(NewText)) {
                 jspro.setDisable(false);
                 htmlapk1.setDisable(false);
                 mapk.setDisable(false);
                 htmlapk.setDisable(false);
                 web.setDisable(false);
                 cv.setDisable(false);
                 web11111111111.setDisable(false);
                 web111111111111.setDisable(false);
                 
                 set.getItems().remove("Register");
                 set.getItems().remove("Get My ID");
                 set.getItems().remove("Buy Key");
                 
                }
                else {
                    
                }
                while (line!=null) {
                    line=buf.readLine();  
                    
                       
                   
                }
                
                
                buf.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            
        }
    
       //////////////////////////////////////////////////////////////////////////
       
      this.htmlpro.setTooltip(new Tooltip("Create HTML Code Project Perfectly."));
      this.jspro.setTooltip(new Tooltip("Create JavaScript Code Project Perfectly."));
      this.htmlapk.setTooltip(new Tooltip("Create HTMLAPK Project Perfectly."));
      this.htmlapk1.setTooltip(new Tooltip("Create Eagle Projects and Games."));
      htmlapk1111.setTooltip(new Tooltip("Create APK PDF Application for any E-Book."));
      this.htmlproo11.setTooltip(new Tooltip("Try me now and enjoy playing 'Plants VS Zombies'."));
      this.jsapk.setTooltip(new Tooltip("Create JSAPK Project Perfectly."));
      this.desktop.setTooltip(new Tooltip("Create HTML Desktop Project Perfectly."));
      this.web.setTooltip(new Tooltip("Create HTML Web Project Perfectly."));
      web1.setTooltip(new Tooltip("Get Page Code."));
      web11.setTooltip(new Tooltip("Eagle, Old HTML Editor."));
      web111.setTooltip(new Tooltip("SimbaWeb IDE."));
      web1111.setTooltip(new Tooltip("WYSIWYG Editor from CKEditor in Eagle Framework."));
      web11111.setTooltip(new Tooltip("Jar Builder."));
      web111111.setTooltip(new Tooltip("QR Code Generator."));
      web1111111.setTooltip(new Tooltip("HTML Tutorials."));
      web11111111.setTooltip(new Tooltip("CSS Tutorials."));
      web111111111.setTooltip(new Tooltip("JavaScript Tutorials."));
      web1111111111.setTooltip(new Tooltip("Android JavaScript Tutorials."));
      web11111111111.setTooltip(new Tooltip("Java ARchive To Executable File (JAR2EXE)."));
      web111111111111.setTooltip(new Tooltip("Resize the size of any image you want."));
      web111111111112.setTooltip(new Tooltip("Eagle Piano For Fun (Press Keyboard Keys for sound.)"));
      set.setTooltip(new Tooltip("Settings."));
      mapk.setTooltip(new Tooltip("Create Music Application with your favorite songs."));
      cv.setTooltip(new Tooltip("Create your CV and Portfolio."));
 
 
     
     imgy.setImage(new Image(this.getClass().getResourceAsStream("3.png")));
     min.setTooltip(new Tooltip("Minimize Me."));
      
     buycoffee=new WebView ();
     buycoffee.getEngine().loadContent("<script data-name=\"BMC-Widget\" data-cfasync=\"false\" src=\"https://cdnjs.buymeacoffee.com/1.0.0/widget.prod.min.js\" data-id=\"Kadysoft\" data-description=\"Support me on Buy me a coffee!\" data-message=\"\" data-color=\"#ff813f\" data-position=\"Center\" data-x_margin=\"18\" data-y_margin=\"18\"></script>");
     
   }
}