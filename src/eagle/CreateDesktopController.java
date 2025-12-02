package eagle;

import com.gluonhq.charm.glisten.animation.PulseTransition;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class CreateDesktopController implements Initializable {
   @FXML
   private ResourceBundle resources;
   @FXML
   private URL location;
   @FXML
   private Label pathlabel;
   @FXML
   private ImageView imgview;
   @FXML
   private JFXButton create;
   @FXML
   private JFXTextField proname;
   @FXML
   private JFXTextField prodes;
   
   @FXML
   private JFXTextField prodes1;
   
   @FXML
   private JFXButton browse;
   
   @FXML
   private JFXButton browse1;
   
   static String IconPath;
   static String ProjName;
   static String ProgDer,ProgDerr;
   static File f1;
   static File f2;
   static File f3;

   @FXML
   void imgviewact(MouseEvent event) {
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new ExtensionFilter("Image Files", new String[]{"*.png"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      this.imgview.setImage(new Image((new File(dirpathe)).toURI().toString()));
      this.pathlabel.setText(dirpathe);
      browse.setDisable(false);
   }
   
   
   
   private void copyFile(File source, File dest) throws IOException {
    try (InputStream in = new FileInputStream(source);
         OutputStream out = new FileOutputStream(dest)) {
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
    }
}

private void extractZip(String zipPath, String targetDir) throws IOException {
    try (java.util.zip.ZipInputStream zis = new java.util.zip.ZipInputStream(new FileInputStream(zipPath))) {
        java.util.zip.ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            File newFile = new File(targetDir, entry.getName());
            if (entry.isDirectory()) {
                newFile.mkdirs();
            } else {
                new File(newFile.getParent()).mkdirs();
                try (FileOutputStream fos = new FileOutputStream(newFile)) {
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                }
            }
        }
    }
}

private void deleteRecursively(File file) {
    if (file.isDirectory()) {
        for (File sub : file.listFiles()) {
            deleteRecursively(sub);
        }
    }
    file.delete();
}

   
   

   @FXML
   void createact(ActionEvent event) throws IOException, InterruptedException {
       
      
       Alert alert=new Alert (Alert.AlertType.CONFIRMATION);
       alert.setTitle("Eagle Dialog");
       alert.setHeaderText("Important!...");
       alert.setResizable(false);
       WebView ghhhh=new WebView();
       ghhhh.setPrefSize(600, 250);
       ghhhh.getEngine().loadContent("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <title>Modern Design</title>\n" +
"    <!-- Import Google Font (Roboto) -->\n" +
"    <link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap\" rel=\"stylesheet\">\n" +
"    <style>\n" +
"        /* Modern background color with a gradient */\n" +
"        body {\n" +
"            font-family: 'Roboto', sans-serif;\n" +
"            background: linear-gradient(135deg, #6a1b9a, #ab47bc); /* Purple gradient */\n" +
"            color: #ffffff; /* White text */\n" +
"            margin: 0;\n" +
"            padding: 0;\n" +
"            display: flex;\n" +
"            justify-content: center;\n" +
"            align-items: center;\n" +
"            height: 100vh; /* Full screen height */\n" +
"        }\n" +
"\n" +
"        /* Main container styling */\n" +
"        .content {\n" +
"            text-align: center;\n" +
"            background-color: rgba(0, 0, 0, 0.6); /* Semi-transparent black background */\n" +
"            padding: 40px;\n" +
"            border-radius: 12px;\n" +
"            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1); /* Soft shadow */\n" +
"            width: 80%;\n" +
"            max-width: 600px;\n" +
"        }\n" +
"\n" +
"        /* Styling for the heading */\n" +
"        h2 {\n" +
"            color: #d08770; /* Light gold color */\n" +
"            font-size: 2rem;\n" +
"            font-weight: 700;\n" +
"        }\n" +
"\n" +
"        /* Styling for the paragraph */\n" +
"        p {\n" +
"            color: #ffffff;\n" +
"            font-size: 1.1rem;\n" +
"        }\n" +
"\n" +
"        /* Styling for the \"Wanna continue?\" text */\n" +
"        h3 {\n" +
"            color: #a3be8c; /* Light green color */\n" +
"            font-size: 1.5rem;\n" +
"            font-weight: 700;\n" +
"        }\n" +
"\n" +
"        /* Button styling */\n" +
"        .button {\n" +
"            background-color: #a3be8c; /* Light green */\n" +
"            color: #ffffff;\n" +
"            padding: 10px 20px;\n" +
"            font-size: 1rem;\n" +
"            border: none;\n" +
"            border-radius: 5px;\n" +
"            cursor: pointer;\n" +
"            transition: background-color 0.3s ease;\n" +
"        }\n" +
"\n" +
"        .button:hover {\n" +
"            background-color: #8ba27a; /* Darker green on hover */\n" +
"        }\n" +
"    </style>\n" +
"</head>\n" +
"<body>\n" +
"    <div class=\"content\">\n" +
"        <h2>Hi, user!</h2>\n" +
"        <p>Please make sure Java is installed and path is set correctly.</p>\n" +
"        <!-- You can add a button to enhance the user experience -->\n" +
"    </div>\n" +
"</body>\n" +
"</html>");
       alert.getDialogPane().setContent(ghhhh);
       DialogPane dialogPane = alert.getDialogPane();
      dialogPane.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
       Optional<ButtonType> result=alert.showAndWait();
       
       
       
       if (result.get()==ButtonType.OK) {
          
            
IconPath = this.pathlabel.getText();
ProjName = this.proname.getText().replace(" ","_").replace(".","_");
ProgDer = this.prodes.getText();
ProgDerr = this.prodes1.getText();

File glk = new File(IconPath);
String newimgpath = glk.getName();

File desktop = new File(System.getProperty("user.home"), "Desktop");
File projectFolder = new File(desktop, ProjName);
File kadyFolder = new File(projectFolder, "KADY");

projectFolder.mkdir();
kadyFolder.mkdir();

File javaFile = new File(projectFolder, ProjName + ".java");
File iconTarget = new File(projectFolder, "icon.png");
File htmlTarget = new File(kadyFolder, "Index.html");
File zipTarget = new File(kadyFolder, "Src.zip");

copyFile(new File(IconPath), iconTarget);
copyFile(new File(ProgDer), htmlTarget);
copyFile(new File(ProgDerr), zipTarget);

// Extract ZIP contents to KADY folder
extractZip(zipTarget.getAbsolutePath(), kadyFolder.getAbsolutePath());




//
//try (
//    OutputStreamWriter writer = new OutputStreamWriter(
//        new FileOutputStream(javaFile), StandardCharsets.UTF_8);
//    PrintWriter pwr = new PrintWriter(writer)
//) {
//
//    pwr.println(
//"import javafx.application.Application;\n" +
//"import javafx.scene.Scene;\n" +
//"import javafx.scene.web.WebView;\n" +
//"import javafx.stage.Stage;\n" +
//"import javafx.scene.image.Image;\n" +
//"import java.net.URL;\n" +
//"\n" +
//"public class " + ProjName + " extends Application {\n" +
//"    @Override\n" +
//"    public void start(Stage kady) {\n" +
//"        WebView root = new WebView();\n" +
//"        try {\n" +
//"            URL url = getClass().getResource(\"/KADY/index.html\");\n" +
//"            if (url != null) {\n" +
//"                root.getEngine().load(url.toExternalForm());\n" +
//"            } else {\n" +
//"            }\n" +
//"        } catch (Exception e) {\n" +
//"            e.printStackTrace();\n" +
//"        }\n" +
//"\n" +
//"        kady.setTitle(\"" + ProjName + "\");\n" +
//"        kady.setScene(new Scene(root, 1000, 700));\n" +
//"        try {\n" +
//"            kady.getIcons().add(new Image(getClass().getResourceAsStream(\"/icon.png\")));\n" +
//"        } catch (Exception ex) {\n" +
//"        }\n" +
//"        kady.show();\n" +
//"    }\n" +
//"\n" +
//"    public static void main(String[] args) {\n" +
//"        launch(args);\n" +
//"    }\n" +
//"}"
//    );
//
//} catch (IOException e) {
//    e.printStackTrace();
//}
//







// Create the JavaFX source file
try (PrintWriter pwr = new PrintWriter(new FileWriter(javaFile))) {
    pwr.println("/**");
            pwr.println("* Author: Ahmed Elkady - Kadysoft Founder");
            pwr.println("*/");
            pwr.println("import javafx.application.Application;");
            pwr.println("import javafx.scene.Scene;");
            pwr.println("import javafx.scene.web.WebView;");
            pwr.println("import javafx.stage.Stage;");
            pwr.println("import javafx.scene.image.Image;");
            pwr.println("public class " + ProjName + " extends Application {");
            pwr.println("    @Override");
            pwr.println("    public void start(Stage kady) {");
            pwr.println("        WebView root = new WebView();");
            pwr.println("        String url = getClass().getResource(\"/KADY/Index.html\").toExternalForm();");
            pwr.println("        root.getEngine().load(url);");
            pwr.println("        kady.setTitle(\"" + ProjName + "\");");
            pwr.println("        kady.setScene(new Scene(root, 1000, 700));");
            pwr.println("        kady.getIcons().add(new Image(getClass().getResourceAsStream(\"/icon.png\")));");
            pwr.println("        kady.show();");
            pwr.println("    }");
            pwr.println("    public static void main(String[] args) { launch(args); }");
            pwr.println("}");
}




// Compile Java file
Process compile = Runtime.getRuntime().exec("cmd /c javac \"" + javaFile.getAbsolutePath() + "\"");
compile.waitFor();

// Create manifest
File manifestFile = new File(projectFolder, "Manifest.txt");
try (PrintWriter manifest = new PrintWriter(new FileWriter(manifestFile))) {
    manifest.println("Manifest-Version: 1.0");
    manifest.println("Main-Class: " + ProjName);
}

// Create the JAR file
String jarFileName = ProjName + ".jar";
String jarCmd = String.format(
    "cmd /c jar cfm \"%s\" Manifest.txt %s.class KADY icon.png",
    jarFileName, ProjName
);
Process jarProcess = Runtime.getRuntime().exec(jarCmd, null, projectFolder);
jarProcess.waitFor();

// Open folder
//Desktop.getDesktop().open(projectFolder);

            Notifications noti = Notifications.create();
            noti.title("Great!");
            noti.text("APP Created Successfully.");
            noti.position(Pos.CENTER);
            noti.hideAfter(Duration.seconds(5));
            noti.showInformation();

// Wait a bit to make sure folder opens before deletion (optional)
Thread.sleep(3000);

//// Delete all files except the final JAR
//for (File file : projectFolder.listFiles()) {
//    if (!file.getName().equals(jarFileName)) {
//        deleteRecursively(file);
//    }
//}


      
      
      
      
      
      
      
      
     // f2.delete();
     // File bnm=new File (System.getProperty("user.home")+"\\Desktop\\"+ProjName+"\\KADY\\Src.zip");
     // bnm.delete();
           
       }
       else {
           
       }
       
      File bnm=new File (System.getProperty("user.home")+"\\Desktop\\"+ProjName+"\\KADY\\Src.zip");
      bnm.delete();
   }

   @FXML
   void browseact(ActionEvent event) {
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new ExtensionFilter("Html Files", new String[]{"*.html"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
       ///////////////////////////////////////////
        
       try {
           PrintWriter pw = new PrintWriter(new FileWriter(dirpathe,true));
           pw.append("\n");
           //pw.append("<script data-name=\"BMC-Widget\" data-cfasync=\"false\" src=\"https://cdnjs.buymeacoffee.com/1.0.0/widget.prod.min.js\" data-id=\"Kadysoft\" data-description=\"Support me on Buy me a coffee!\" data-message=\"\" data-color=\"#ff813f\" data-position=\"Right\" data-x_margin=\"18\" data-y_margin=\"18\"></script>");
           pw.close();
       } catch (IOException ex) {
           Logger.getLogger(CreateCordovaApkController.class.getName()).log(Level.SEVERE, null, ex);
       }
            
      ///////////////////////////////////////////
      this.prodes.setText(dirpathe);
      browse1.setDisable(false);
   }
   @FXML
   void browseact1(ActionEvent event) {
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new ExtensionFilter("Zip Files", new String[]{"*.zip"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      this.prodes1.setText(dirpathe);
      create.setDisable(false);
   }

   public void initialize(URL location, ResourceBundle resources) {
      this.imgview.setImage(new Image(this.getClass().getResourceAsStream("image.png")));
      PulseTransition pulsee=new PulseTransition(imgview);
      pulsee.setAutoReverse(true);
      pulsee.setCycleCount(10);
      pulsee.play();
   }
}
