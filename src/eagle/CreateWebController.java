package eagle;

import com.gluonhq.charm.glisten.animation.PulseTransition;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class CreateWebController implements Initializable {
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
   static String IconPath;
   static String ProjName;
   static String ProgDer;
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
      create.setDisable(false);
   }

   
//   
//private void deleteRecursively(File file) {
//    if (file.isDirectory()) {
//        for (File sub : file.listFiles()) {
//            deleteRecursively(sub);
//        }
//    }
//    file.delete();
//}
   
   
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
      
      
String outputPath = System.getProperty("user.home") + "\\Desktop\\" + ProjName;
File outDir = new File(outputPath);
outDir.mkdirs();



        // Save icon
        File iconFile = new File(outputPath + "\\icon.png");
        if (iconFile.exists()) iconFile.delete();
        copyFile(new File(IconPath), iconFile);

        // Write Java file
        File javaFile = new File(outDir, ProjName + ".java");
        try (PrintWriter pw = new PrintWriter(javaFile)) {
       
            pw.println("import javafx.application.Application;");
            pw.println("import javafx.scene.Scene;");
            pw.println("import javafx.scene.image.Image;");
            pw.println("import javafx.scene.layout.StackPane;");
            pw.println("import javafx.scene.web.WebView;");
            pw.println("import javafx.stage.Stage;");
            pw.println("public class " + ProjName + " extends Application {");
            pw.println("  public void start(Stage stage) {");
            pw.println("    WebView web = new WebView();");
            pw.println("    web.getEngine().setJavaScriptEnabled(true);");
            pw.println("    web.getEngine().load(\"" + ProgDer + "\");");
            pw.println("    StackPane root = new StackPane(web);");
            pw.println("    Scene scene = new Scene(root, 1000, 700);");
            pw.println("    stage.setTitle(\"" + ProjName + "\");");
            pw.println("    stage.setScene(scene);");
            pw.println("    stage.getIcons().add(new Image(getClass().getResourceAsStream(\"icon.png\")));");
            pw.println("    stage.show();");
            pw.println("  }");
            pw.println("  public static void main(String[] args) { launch(args); }");
            pw.println("}");
        }

        // Confirm the Java file exists
        if (!javaFile.exists()) throw new RuntimeException("Java file not created!");

        // Write manifest
        File manifest = new File(outDir, "Manifest.txt");
        try (PrintWriter mf = new PrintWriter(manifest)) {
            mf.println("Manifest-Version: 1.0");
            mf.println("Main-Class: " + ProjName);
        }

        // ✅ Compile using absolute path
        ProcessBuilder compile = new ProcessBuilder("javac", javaFile.getAbsolutePath());
        compile.directory(outDir);
        compile.redirectErrorStream(true);
        Process proc1 = compile.start();
        logProcessOutput(proc1);
        if (proc1.waitFor() != 0) throw new RuntimeException("Compilation failed!");

        // Confirm class file
        File classFile = new File(outDir, ProjName + ".class");
        if (!classFile.exists()) throw new RuntimeException("Class file not generated!");

        // ✅ Create JAR using absolute paths
        ProcessBuilder jar = new ProcessBuilder("jar", "cfm", ProjName + ".jar", "Manifest.txt",
                ProjName + ".class", "icon.png");
        jar.directory(outDir);
        jar.redirectErrorStream(true);
        Process proc2 = jar.start();
        logProcessOutput(proc2);
        if (proc2.waitFor() != 0) throw new RuntimeException("JAR creation failed!");

        // Confirm JAR
        File jarFile = new File(outDir, ProjName + ".jar");
        if (!jarFile.exists()) throw new RuntimeException("JAR not created!");

        // Done
        //Desktop.getDesktop().open(jarFile);
        //Desktop.getDesktop().open(outDir);
        javaFile.delete();
        System.out.println("JAR created: " + jarFile.getAbsolutePath());

            Notifications noti = Notifications.create();
            noti.title("Great!");
            noti.text("APP Created Successfully.");
            noti.position(Pos.CENTER);
            noti.hideAfter(Duration.seconds(5));
            noti.showInformation();

//
//// Delete all files except the final JAR
//for (File file : outDir.listFiles()) {
//    if (!file.getName().equals(jarFile)) {
//        deleteRecursively(file);
//    }
//}
      
      
//      File glk = new File(IconPath);
//      String newimgpath = glk.getName();
//      File fg = new File(System.getProperty("user.home") + "\\Desktop\\" + ProjName);
//      fg.mkdir();
//      f1 = new File(System.getProperty("user.home") + "\\Desktop\\" + ProjName + "\\" + ProjName + ".java");
//
//      try {
//         f1.createNewFile();
//      } catch (IOException var12) {
//         
//      }
//
//      try {
//         Process var5 = Runtime.getRuntime().exec("cmd /c copy " + IconPath + " " + System.getProperty("user.home") + "\\Desktop\\" + ProjName + "\\icon.png");
//      } catch (IOException var11) {
//         
//      }
//
//      PrintWriter pwr = new PrintWriter(new FileWriter(f1));
//      pwr.println();
//      pwr.println("/**\n\n*@author Ahmed Elkady - Kadysoft Founder\n\n*/\n\nimport javafx.application.Application;\nimport javafx.scene.Scene;\nimport javafx.scene.image.Image;\nimport javafx.scene.layout.StackPane;\nimport javafx.scene.web.WebView;\nimport javafx.stage.Stage;\n/**\n *\n * @author KADY\n */\npublic class " + ProjName + " extends Application {\n    \n    @Override\n    public void start(Stage stage) {\n        WebView web=new WebView ();\n        web.setMaxSize(800, 600);\n        web.getEngine().load(\"" + ProgDer + "\");\n        StackPane root = new StackPane();\n        root.getChildren().add(web);\n        Scene scene = new Scene(root, 800, 600);\n        stage.setTitle(\"" + ProjName + "\");\n        stage.setScene(scene);\n        stage.centerOnScreen();\n        stage.setResizable(false);\n        stage.getIcons().add(new Image (getClass ().getResourceAsStream(\"icon.png\")));\n        stage.show();\n    }\n    public static void main(String[] args) {\n        launch(args);\n    }}\n");
//      pwr.close();
//      Process p = Runtime.getRuntime().exec("cmd /c javac "+f1);
//      PrintWriter lcv = new PrintWriter(new FileWriter(System.getProperty("user.home") + "\\Desktop\\" + ProjName + "\\Manifest.txt"));
//      lcv.println("Manifest-Version: 1.0\nImplementation-Title: " + ProjName + "\nImplementation-Version: 1.0\nPermissions: sandbox\nCodebase: *\nJavaFX-Version: 8.0\nClass-Path: \nCreated-By: JavaFX Packager\nImplementation-Vendor: KADY\nMain-Class: " + ProjName + "\n");
//      lcv.close();
//      String userpath = System.getProperty("user.home");
//      Desktop desk = Desktop.getDesktop();
//      desk.open(new File(userpath + "/AppData/Roaming/resources/data/JarBuilder.jar"));
//      Stage stge = (Stage)this.pathlabel.getScene().getWindow();
//      stge.close();
      
      
      
           
       }
       
       else {
           
       }
       
     
   }
   
   
   private static void logProcessOutput(Process process) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    private static void copyFile(File src, File dest) throws IOException {
        try (InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dest)) {
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        }
    }
   
   

   public void initialize(URL location, ResourceBundle resources) {
       Circle cir=new Circle(100,100,100);
       
      this.imgview.setImage(new Image(this.getClass().getResourceAsStream("image.png")));
      imgview.setSmooth(true);
      PulseTransition pulsee=new PulseTransition(imgview);
      pulsee.setAutoReverse(true);
      pulsee.setCycleCount(10);
      pulsee.play();
      //imgview.setClip(cir);
   }
}