package eagle;

import com.gluonhq.charm.glisten.animation.PulseTransition;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.controlsfx.control.Notifications;

public class CreateAPKPDFController implements Initializable {
   @FXML
   private ResourceBundle resources;
   @FXML
   private URL location;
   @FXML
   private JFXTextField zipfile;
   @FXML
   private Label pathlabel;
   @FXML
   private JFXTextField apkname;
   @FXML
   private JFXButton browse2;
   @FXML
   private JFXTextField packagename;
   @FXML
   private JFXButton browse1;
   @FXML
   private JFXTextField htmlfile;
   @FXML
   private ImageView imgview;
   @FXML
   private JFXButton create;
   
   @FXML
   private JFXTextField htmlfile111;
   
   @FXML
   private JFXTextField outputdir,selimg;
   
   @FXML
   private ComboBox extension;
   
    @FXML
   private JFXSpinner loading;
   
   @FXML
   private RadioButton method1,method2,method3,originallogo,changelogo;
   
   @FXML
   private Label preview1,preview2;
   
   ToggleGroup toggroup;
   
   public static String apkresource,pathtologo;
   
   
   
   @FXML
   void preview1action(MouseEvent event) {
       
        String  userpath = System.getProperty("user.home");
        userpath = userpath + "/AppData/Roaming/resources/data/method1.png";
       
        File imageFile = new File(userpath);
        
        Image image = new Image(imageFile.toURI().toString()); // Replace with your image path
        ImageView imageView = new ImageView(image);

        // Adjust the size of the ImageView
        imageView.setFitWidth(563);
        imageView.setFitHeight(792);
        imageView.setPreserveRatio(true);

        // Create a Dialog for the image preview
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Image Preview");
        dialog.getDialogPane().getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());

        // Set the dialog content
        dialog.getDialogPane().setContent(imageView);

        // Add a Close button to the dialog
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        // Show the dialog
        dialog.show();
       
       
   }
   
   
   
   
   @FXML
    void method1action(ActionEvent event) {

        
        originallogo.setDisable(false);
        changelogo.setDisable(false);
        
        
    }

    @FXML
    void method2action(ActionEvent event) {

         originallogo.setDisable(true);
        changelogo.setDisable(true);
        
    }

    @FXML
    void method3action(ActionEvent event) {

         originallogo.setDisable(true);
        changelogo.setDisable(true);
        
        
    }
    
    @FXML
    void changelogoaction(ActionEvent event) {

        
        
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new ExtensionFilter("Images Files", new String[]{"*.png"}));
      fcho.setTitle("Image Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      pathtologo=dirpathe;
      
    }
   
   
   
   @FXML
   void preview2action(MouseEvent event) {
       
       String  userpath = System.getProperty("user.home");
       userpath = userpath + "/AppData/Roaming/resources/data/method2.png";
       File imageFile = new File(userpath);
        
        Image image = new Image(imageFile.toURI().toString()); // Replace with your image path
        ImageView imageView = new ImageView(image);

        // Adjust the size of the ImageView
        imageView.setFitWidth(492);
        imageView.setFitHeight(791);
        imageView.setPreserveRatio(true);

        // Create a Dialog for the image preview
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Image Preview");
        dialog.getDialogPane().getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());

        // Set the dialog content
        dialog.getDialogPane().setContent(imageView);

        // Add a Close button to the dialog
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        // Show the dialog
        dialog.show();
       
   }
   
   
   @FXML
   void splitpdf(MouseEvent event) {
       
       
       
                FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
                File selectedFile = fileChooser.showOpenDialog(null);

                // Check if a file was selected
                if (selectedFile == null) {
                    Platform.runLater(() -> selimg.setText("❌ No file selected."));
                    //return null;
                }

                String pdfPath = selectedFile.getAbsolutePath();
                String nn = selectedFile.getName().replace(".pdf", "");
                String outputDir = outputdir.getText() + nn + "\\";

 Task<Void> taskk = new Task<Void>() {
        @Override
        protected Void call() {

            try {
                // Open File Chooser
               

                // Load the PDF document
                PDDocument document = PDDocument.load(new File(pdfPath));
                PDFRenderer pdfRenderer = new PDFRenderer(document);
                int numPages = document.getNumberOfPages();

                // Create output directory if it does not exist
                File dir = new File(outputDir);
                if (!dir.exists()) dir.mkdirs();

                // Show loading indicator
                Platform.runLater(() -> {
                    loading.setVisible(true);
                    selimg.setText("Processing PDF: " + pdfPath + " / " + numPages + " Pages.");
                });

                // Process each page
                for (int page = 0; page < numPages; page++) {
                    BufferedImage image = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
                    File outputFile = new File(outputDir + (page + 1) + "." + extension.getSelectionModel().getSelectedItem().toString());
                    ImageIO.write(image, extension.getSelectionModel().getSelectedItem().toString(), outputFile);

                    // Update UI safely
                    int currentPage = page + 1;
                    Platform.runLater(() -> selimg.setText("Processing page " + currentPage + " of " + numPages));
                }

                document.close();

                // Notify user
                Platform.runLater(() -> {
                    loading.setVisible(false);
                    selimg.setText("✅ PDF split successfully.");
                    Notifications.create()
                        .title("Great!")
                        .text("✅ PDF split into images successfully to:\n" + outputDir)
                        .position(Pos.CENTER)
                        .hideAfter(Duration.seconds(3))
                        .showInformation();
                });

            } catch (IOException e) {
                e.printStackTrace();
                Platform.runLater(() -> selimg.setText("❌ Error processing PDF."));
            }

            return null;
        }
    };

    // Start task in a new thread
    new Thread(taskk).start();



       
       
       
       
       
   }
   
   
   
   @FXML
   void browseaction(ActionEvent event) {
       
    DirectoryChooser directoryChooser = new DirectoryChooser();
    File folder = directoryChooser.showDialog(null);

    if (folder == null || !folder.isDirectory()) {
        outputdir.setText("⚠️ Please select a valid folder first.");
        return;
    }
    
    else {
       outputdir.setText(folder.getAbsolutePath().toString()+"\\"); 
    }
       
   }
   

   @FXML
   void imgviewact(MouseEvent event) {
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new ExtensionFilter("Image Files", new String[]{"*.png"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      this.imgview.setImage(new Image((new File(dirpathe)).toURI().toString()));
      this.pathlabel.setText(dirpathe);
      this.browse1.setDisable(false);
   }
   
   @FXML
   void linkkact(ActionEvent event) throws IOException {
     
        String userpathh = System.getProperty("user.home");
        Desktop desky = Desktop.getDesktop();
        desky.open(new File(userpathh + "/AppData/Roaming/resources/data/PDF2PNG/pdf2png.exe"));

   }
   
   

   @FXML
   void createact(ActionEvent event) throws IOException, InterruptedException {
       
       
       
       if (method3.isSelected()==true) {
           
           //Build your model
           
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new ExtensionFilter("Zip Files", new String[]{"*.zip"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      apkresource=dirpathe;
      
      
      String apknam = this.apkname.getText();
      String apkpkg = this.packagename.getText();
      String apkico = this.pathlabel.getText();
      String apksource = this.htmlfile.getText();
      
      String pnum=htmlfile111.getText();
      int newnum=Integer.parseInt(pnum);
      int newnewnum=newnum+1;
      
      
      
      
       
final Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Creating APK, Please wait ...");
String contentText = "Congratulations\n" +
"Task maybe takes 1 minute, you will find \"" + apknam + ".apk\"on your desktop after Finishing.\n" +
"Support Eagle and Kadysoft on Facebook.\n\nMade with L❤VE by Kadysoft.";
Label statusLabel = new Label(contentText);
JFXProgressBar progressBar = new JFXProgressBar(0);
progressBar.setPrefWidth(300);
VBox content = new VBox(10, statusLabel, progressBar);
alert.getDialogPane().setContent(content);
alert.setGraphic(imgview);
alert.setResizable(false);
alert.getDialogPane().getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
Platform.runLater(alert::show);

Task<Void> task = new Task<Void>() {
    @Override
    protected Void call() throws Exception {
        
        
        Random random = new Random();

        // Progress simulator
        for (int i = 0; i < 20; i++) {
            Thread.sleep(200 + random.nextInt(300)); // simulate work
            double simulatedProgress = Math.min(0.95, progressBar.getProgress() + 0.025 + random.nextDouble() * 0.05);
            double finalProgress = simulatedProgress;
            Platform.runLater(() -> progressBar.setProgress(finalProgress));
        }

      
      
      
      
      
      File projectfolder = new File(System.getProperty("user.home") + "\\appdata\\roaming\\HtmlProject");
      projectfolder.mkdir();

      try {
         Process var10 = Runtime.getRuntime().exec("cmd /c copy " + System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Cordova.kady " + projectfolder + "\\Cordova.apk");
      } catch (IOException var1252) {
         ;
      }

      File batfile1 = new File(projectfolder + "\\kady1.bat");

      try {
         batfile1.createNewFile();
      } catch (IOException var1251) {
         ;
      }

      try {
         PrintWriter pw = new PrintWriter(new FileWriter(batfile1));
         pw.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\apktool.bat d -f " + projectfolder + "\\Cordova.apk -o " + projectfolder + "\\Cordova");
         pw.close();
      } catch (IOException var1250) {
         ;
      }

      File framwork = new File(projectfolder + "\\kady2.bat");

      try {
         framwork.createNewFile();
      } catch (IOException var1249) {
         ;
      }

      try {
         PrintWriter pwq = new PrintWriter(new FileWriter(framwork));
         pwq.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\apktool.bat if " + projectfolder + "\\Cordova.apk");
         pwq.close();
      } catch (IOException var1248) {
         ;
      }

//      File htmlbat2 = new File(projectfolder + "\\kady3.bat");
//
//      try {
//         htmlbat2.createNewFile();
//      } catch (IOException var1247) {
//         ;
//      }
//
//      try {
//         PrintWriter lcv = new PrintWriter(new FileWriter(htmlbat2));
//         lcv.println("cd " + projectfolder + "\\Cordova\\assets\\www\\images");
//         lcv.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\7z.exe x -y " + apksource);
//         lcv.close();
//      } catch (IOException var1246) {
//         ;
//      }

//      File htmlbat1 = new File(projectfolder + "\\kady4.bat");
//
//      try {
//         htmlbat1.createNewFile();
//      } catch (IOException var1245) {
//         ;
//      }
//
//      try {
//         PrintWriter lcv = new PrintWriter(new FileWriter(htmlbat1));
//         lcv.println("cd " + projectfolder + "\\Cordova\\assets\\www");
//         lcv.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\7z.exe x -y " + apkresource);
//         lcv.close();
//      } catch (IOException var1244) {
//         ;
//      }
      
      File htmlbat11 = new File(projectfolder + "\\kady9.bat");

      try {
         htmlbat11.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat11));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-hdpi");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-hdpi\\ic_launcher.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

File htmlbat1110 = new File(projectfolder + "\\kady910.bat");

      try {
         htmlbat1110.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat1110));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-ldpi");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-ldpi\\ic_launcher.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
      
      File htmlbat11100 = new File(projectfolder + "\\kady9100.bat");

      try {
         htmlbat11100.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat11100));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-mdpi");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-mdpi\\ic_launcher.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
      File htmlbat111000 = new File(projectfolder + "\\kady91000.bat");

      try {
         htmlbat111000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat111000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xxhdpi");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xxhdpi\\ic_launcher.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
      
      File htmlbat1110000 = new File(projectfolder + "\\kady910000.bat");

      try {
         htmlbat1110000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat1110000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xxxhdpi");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xxxhdpi\\ic_launcher.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
//////////////////////////////////////////////////////////////////////////////////////////////////////////
 
      File htmlbat11100000 = new File(projectfolder + "\\kady9100000.bat");

      try {
         htmlbat11100000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat11100000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-hdpi-v26");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-hdpi-v26\\ic_launcher_foreground.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
       
      File htmlbat111000000 = new File(projectfolder + "\\kady91000000.bat");

      try {
         htmlbat111000000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat111000000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-ldpi-v26");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-ldpi-v26\\ic_launcher_foreground.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
       
      File htmlbat1110000000 = new File(projectfolder + "\\kady910000000.bat");

      try {
         htmlbat1110000000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat1110000000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-mhdpi-v26");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-mhdpi-v26\\ic_launcher_foreground.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
       
      File htmlbat11100000000 = new File(projectfolder + "\\kady9100000000.bat");

      try {
         htmlbat11100000000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat11100000000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xhdpi-v26");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xhdpi-v26\\ic_launcher_foreground.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
       
      File htmlbat111000000000 = new File(projectfolder + "\\kady91000000000.bat");

      try {
         htmlbat111000000000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat111000000000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xxhdpi-v26");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xxhdpi-v26\\ic_launcher_foreground.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
       
      File htmlbat1110000000000 = new File(projectfolder + "\\kady910000000000.bat");

      try {
         htmlbat1110000000000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat1110000000000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xxxhdpi-v26");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xxxhdpi-v26\\ic_launcher_foreground.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      File htmlbat111 = new File(projectfolder + "\\kady10.bat");

      try {
         htmlbat111.createNewFile();
      } catch (IOException var1241) {
         ;
      }

      try {
         PrintWriter lcvvv = new PrintWriter(new FileWriter(htmlbat111));
         lcvvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xhdpi");
         lcvvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xhdpi\\ic_launcher.png");
         lcvvv.close();
      } catch (IOException var1240) {
         ;
      }

      File batfile3 = new File(projectfolder + "\\kady5.bat");

      try {
         batfile3.createNewFile();
      } catch (IOException var1239) {
         ;
      }

      try {
         PrintWriter pww = new PrintWriter(new FileWriter(batfile3));
         pww.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\apktool.bat b -f " + projectfolder + "\\Cordova");
         pww.close();
      } catch (IOException var1238) {
         ;
      }

      File batfile5 = new File(projectfolder + "\\kady6.bat");

      try {
         batfile5.createNewFile();
      } catch (IOException var1237) {
         ;
      }

      try {
         PrintWriter pwwu = new PrintWriter(new FileWriter(batfile5));
         pwwu.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\zipalign.exe -v 4 " + projectfolder + "\\Cordova\\dist\\Cordova.apk " + projectfolder + "\\newApk.apk");
         pwwu.close();
      } catch (IOException var1236) {
         ;
      }

      File batfile4 = new File(projectfolder + "\\kady7.bat");

      try {
         batfile4.createNewFile();
      } catch (IOException var1235) {
         ;
      }

      try {
         PrintWriter pwww = new PrintWriter(new FileWriter(batfile4));
         //pwww.println("cd " + System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data");
         pwww.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk.bat " + projectfolder + "\\newApk.apk");
         pwww.close();
      } catch (IOException var1234) {
         ;
      }

      File batfile6 = new File(projectfolder + "\\kady8.bat");

      try {
         batfile6.createNewFile();
      } catch (IOException var1233) {
         ;
      }

      try {
         PrintWriter pwwww = new PrintWriter(new FileWriter(batfile6));
         pwwww.println("copy " + projectfolder + "\\newApk_Eagle_Kadysoft.apk " + System.getProperty("user.home") + "\\desktop");
         pwwww.close();
      } catch (IOException var1232) {
         ;
      }

      File batfile66 = new File(projectfolder + "\\strings.xml");

      try {
         batfile66.createNewFile();
      } catch (IOException var1231) {
         ;
      }

      try {
         PrintWriter pwwwwn = new PrintWriter(new FileWriter(batfile66));
         pwwwwn.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
"<resources>\n" +
"    <string name=\"activity_name\">@string/launcher_name</string>\n" +
"    <string name=\"app_name\">"+apknam+"</string>\n" +
"    <string name=\"launcher_name\">@string/app_name</string>\n" +
"</resources>");
         pwwwwn.close();
      } catch (IOException var1230) {
         ;
      }
      /////////////////////////////////////////////////////////////////////
      
      File batfile6600 = new File(projectfolder + "\\AndroidManifest.xml");

      try {
         batfile6600.createNewFile();
      } catch (IOException var1231) {
         
      }

      try {
         PrintWriter pwwwwn00 = new PrintWriter(new FileWriter(batfile6600));
         pwwwwn00.println("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?><manifest xmlns:android=\"http://schemas.android.com/apk/res/android\" android:compileSdkVersion=\"28\" android:compileSdkVersionCodename=\"9\" android:hardwareAccelerated=\"true\" package=\"com.zib.apache.cordova.browser\" platformBuildVersionCode=\"10000\" platformBuildVersionName=\"1.0.0\">\n" +
"    <supports-screens android:anyDensity=\"true\" android:largeScreens=\"true\" android:normalScreens=\"true\" android:resizeable=\"true\" android:smallScreens=\"true\" android:xlargeScreens=\"true\"/>\n" +
"    <uses-permission android:name=\"android.permission.INTERNET\"/>\n" +
"    <application android:hardwareAccelerated=\"true\" android:icon=\"@mipmap/ic_launcher\" android:label=\"@string/app_name\" android:supportsRtl=\"true\">\n" +
"        <activity android:configChanges=\"keyboard|keyboardHidden|locale|orientation|screenLayout|screenSize|smallestScreenSize|uiMode\" android:label=\"@string/activity_name\" android:launchMode=\"singleTop\" android:name=\"com.zib.apache.cordova.browser.MainActivity\" android:theme=\"@android:style/Theme.DeviceDefault.NoActionBar\" android:windowSoftInputMode=\"adjustResize\">\n" +
"            <intent-filter android:label=\"@string/launcher_name\">\n" +
"                <action android:name=\"android.intent.action.MAIN\"/>\n" +
"                <category android:name=\"android.intent.category.LAUNCHER\"/>\n" +
"            </intent-filter>\n" +
"        </activity>\n" +
"        <meta-data android:name=\"com.android.vending.derived.apk.id\" android:value=\"1\"/>\n" +
"    </application>\n" +
"</manifest>");
         pwwwwn00.close();
      } catch (IOException var1230) {
         
      }
      
     //////////////////////////////////////////////////////////////////////
      File batfile666 = new File(projectfolder + "\\apktool.yml");

      try {
         batfile666.createNewFile();
      } catch (IOException var1229) {
         ;
      }

      try {
         PrintWriter pwwwwnx = new PrintWriter(new FileWriter(batfile666));
         pwwwwnx.println("!!brut.androlib.meta.MetaInfo\n" +
"apkFileName: Cordova.apk\n" +
"compressionType: false\n" +
"doNotCompress:\n" +
"- arsc\n" +
"- png\n" +
"isFrameworkApk: false\n" +
"packageInfo:\n" +
"  forcedPackageId: '127'\n" +
"  renameManifestPackage: com.eagle."+apkpkg+"\n" +
"sdkInfo:\n" +
"  minSdkVersion: '19'\n" +
"  targetSdkVersion: '28'\n" +
"sharedLibrary: false\n" +
"sparseResources: false\n" +
"unknownFiles: {}\n" +
"usesFramework:\n" +
"  ids:\n" +
"  - 1\n" +
"  tag: null\n" +
"version: 2.3.4\n" +
"versionInfo:\n" +
"  versionCode: '10000'\n" +
"  versionName: 1.0.0");
         pwwwwnx.close();
      } catch (IOException var1228) {
         ;
      }

      File batfile65 = new File(projectfolder + "\\kady11.bat");

      try {
         batfile65.createNewFile();
      } catch (IOException var1227) {
         ;
      }

      try {
         PrintWriter pwwwwm = new PrintWriter(new FileWriter(batfile65));
         pwwwwm.println("copy /Y " + projectfolder + "\\strings.xml " + projectfolder + "\\Cordova\\res\\values\\strings.xml");
         pwwwwm.close();
      } catch (IOException var1226) {
         ;
      }
      /////////////////////////////////////////////////////////////////////////////
      
      File batfile650 = new File(projectfolder + "\\kady1100.bat");

      try {
         batfile650.createNewFile();
      } catch (IOException var1227) {
         
      }

      try {
         PrintWriter pwwwwm0 = new PrintWriter(new FileWriter(batfile650));
         pwwwwm0.println("copy /Y " + projectfolder + "\\AndroidManifest.xml " + projectfolder + "\\Cordova\\AndroidManifest.xml");
         pwwwwm0.close();
      } catch (IOException var1226) {
         
      }
      
      /////////////////////////////////////////////////////////////////////////////

      File batfile655 = new File(projectfolder + "\\kady12.bat");

      try {
         batfile655.createNewFile();
      } catch (IOException var1225) {
         ;
      }

      try {
         PrintWriter pwwwwmmm = new PrintWriter(new FileWriter(batfile655));
         pwwwwmmm.println("copy /Y " + projectfolder + "\\apktool.yml " + projectfolder + "\\Cordova\\apktool.yml");
         pwwwwmmm.close();
      } catch (IOException var1224) {
         ;
      }

      ProcessBuilder pb1 = new ProcessBuilder(new String[]{projectfolder + "\\kady1.bat"});
      pb1.redirectError();

      try {
         Process b1 = pb1.start();
         InputStream inputStream = b1.getInputStream();
         Throwable var27 = null;

         try {
            boolean var28 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1297) {
            var27 = var1297;
            throw var1297;
         } finally {
            if (inputStream != null) {
               if (var27 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1223) {
                     var27.addSuppressed(var1223);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b1.waitFor());
      } catch (IOException var1299) {
         ;
      } catch (InterruptedException var1300) {
         ;
      }

      ProcessBuilder pb2 = new ProcessBuilder(new String[]{projectfolder + "\\kady2.bat"});
      pb2.redirectError();

      try {
         Process b2 = pb2.start();
         InputStream inputStream = b2.getInputStream();
         Throwable var1322 = null;

         try {
            boolean var29 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1293) {
            var1322 = var1293;
            throw var1293;
         } finally {
            if (inputStream != null) {
               if (var1322 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1222) {
                     var1322.addSuppressed(var1222);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b2.waitFor());
      } catch (IOException var1295) {
         ;
      } catch (InterruptedException var1296) {
         ;
      }
      
      
      
      
      
try {
    File zipFile = new File(apkresource); // The ZIP or APK file you want to extract
    File outputFolder = new File(projectfolder + "\\Cordova\\assets\\www"); // Target folder for extraction

    if (!outputFolder.exists()) {
        outputFolder.mkdirs();
    }

    byte[] buffer = new byte[1024];

    try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            File newFile = new File(outputFolder, entry.getName());

            // Security: prevent zip-slip attack
            String destDirPath = outputFolder.getCanonicalPath();
            String destFilePath = newFile.getCanonicalPath();
            if (!destFilePath.startsWith(destDirPath + File.separator)) {
                System.out.println("Skipping suspicious entry: " + entry.getName());
                continue;
            }

            if (entry.isDirectory()) {
                newFile.mkdirs();
            } else {
                new File(newFile.getParent()).mkdirs();

                try (FileOutputStream fos = new FileOutputStream(newFile)) {
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                }
            }
        }
    }

    System.out.println("Extraction complete.");

} catch (IOException e) {
    e.printStackTrace();
}


      
      
      
//      ProcessBuilder pb4 = new ProcessBuilder(new String[]{projectfolder + "\\kady4.bat"});
//      pb4.redirectError();
//
//      try {
//         Process b4 = pb4.start();
//         InputStream inputStream = b4.getInputStream();
//         Throwable var1331 = null;
//
//         try {
//            boolean var31 = true;
//
//            int in;
//            while((in = inputStream.read()) != -1) {
//               System.out.print((char)in);
//            }
//         } catch (Throwable var1285) {
//            var1331 = var1285;
//            throw var1285;
//         } finally {
//            if (inputStream != null) {
//               if (var1331 != null) {
//                  try {
//                     inputStream.close();
//                  } catch (Throwable var1220) {
//                     var1331.addSuppressed(var1220);
//                  }
//               } else {
//                  inputStream.close();
//               }
//            }
//
//         }
//
//         System.out.println("Exited with " + b4.waitFor());
//      } catch (IOException var1287) {
//         ;
//      } catch (InterruptedException var1288) {
//         ;
//      }

      
      //////////////////////////////////////////////////////////////////////
   //   try {
   //      Process var10 = Runtime.getRuntime().exec("cmd /c copy "+apksource+" "+projectfolder + "\\Cordova\\assets\\www\\pages\\kady.zip");
  //    } catch (IOException var1252) {
  //       ;
  //    }
  
//  
//  
//  if (method1.isSelected()==true) {
//      
//        PrintWriter pwz;
//      pwz=new PrintWriter (new FileWriter (projectfolder + "\\Cordova\\assets\\www\\index.html"));
//      
//      /*
//        pwz.write("<!doctype html>\n" +
//"<!--[if lt IE 7 ]> <html lang=\"en\" class=\"ie6\"> <![endif]-->\n" +
//"<!--[if IE 7 ]>    <html lang=\"en\" class=\"ie7\"> <![endif]-->\n" +
//"<!--[if IE 8 ]>    <html lang=\"en\" class=\"ie8\"> <![endif]-->\n" +
//"<!--[if IE 9 ]>    <html lang=\"en\" class=\"ie9\"> <![endif]-->\n" +
//"<!--[if !IE]><!--> <html lang=\"en\"> <!--<![endif]-->\n" +
//"<head>\n" +
//"<meta name=\"viewport\" content=\"width = 1050, user-scalable = no\" />\n" +
//"<script type=\"text/javascript\" src=\"extras/jquery.min.1.7.js\"></script>\n" +
//"<script type=\"text/javascript\" src=\"extras/modernizr.2.5.3.min.js\"></script>\n" +
//"</head>\n" +
//"<body>\n" +
//"\n" +
//"<div class=\"flipbook-viewport\">\n" +
//"	<div class=\"container\">\n" +
//"		<div class=\"flipbook\">\n");
//             for(int i = 1; i < newnewnum; i++) {            
//         
//         pwz.write("<div style=\"background-image:url(pages/"+i+".jpg)\"></div>");
//         
//      }
//             pwz.write("</div>\n" +
//"	</div>\n" +
//"</div>\n" +
//"\n" +
//"\n" +
//"<script type=\"text/javascript\">\n" +
//"\n" +
//"function loadApp() {\n" +
//"\n" +
//"	// Create the flipbook\n" +
//"\n" +
//"	$('.flipbook').turn({\n" +
//"			// Width\n" +
//"\n" +
//"			width:922,\n" +
//"			\n" +
//"			// Height\n" +
//"\n" +
//"			height:600,\n" +
//"\n" +
//"			// Elevation\n" +
//"\n" +
//"			elevation: 50,\n" +
//"			\n" +
//"			// Enable gradients\n" +
//"\n" +
//"			gradients: true,\n" +
//"			\n" +
//"			// Auto center this flipbook\n" +
//"\n" +
//"			autoCenter: true\n" +
//"\n" +
//"	});\n" +
//"}\n" +
//"\n" +
//"// Load the HTML4 version if there's not CSS transform\n" +
//"\n" +
//"yepnope({\n" +
//"	test : Modernizr.csstransforms,\n" +
//"	yep: ['lib/turn.js'],\n" +
//"	nope: ['lib/turn.html4.min.js'],\n" +
//"	both: ['css/basic.css'],\n" +
//"	complete: loadApp\n" +
//"});\n" +
//"\n" +
//"</script>\n" +
//"\n" +
//"</body>\n" +
//"</html>");
//      pwz.close(); 
//   */
//      
//       pwz.write("<html>\n" +
//"<head>\n" +
//"    <meta charset=\"utf-8\">\n" +
//"    <meta name=\"viewport\" content=\"viewport-fit=cover, width=device-width, height=device-height, initial-scale=1, maximum-scale=1, user-scalable=no\">\n" +
//"    <meta http-equiv=\"Content-Security-Policy\" content=\"default-src * data: gap: https://ssl.gstatic.com; style-src * 'unsafe-inline'; script-src * 'unsafe-inline' 'unsafe-eval'\">\n" +
//"    <title>Kadysoft</title>\n" +
//"		<meta name=\"description\" content=\"Eagle\" />\n" +
//"		<meta name=\"keywords\" content=\"Kali Linux\" />\n" +
//"		<meta name=\"author\" content=\"Ahmed Elkady\" /> \n" +
//"		<link rel=\"stylesheet\" type=\"text/css\" href=\"css/jquery.jscrollpane.custom.css\" />\n" +
//"		<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bookblock.css\" />\n" +
//"		<link rel=\"stylesheet\" type=\"text/css\" href=\"css/custom.css\" />\n" +
//"		<script src=\"js/modernizr.custom.79639.js\"></script>\n" +
//"		\n" +
//"    <link rel=\"stylesheet\" href=\"lib/onsenui/css/onsenui.css\">\n" +
//"    <link rel=\"stylesheet\" href=\"lib/onsenui/css/onsen-css-components.css\">\n" +
//"    <script src=\"components/loader.js\"></script>\n" +
//"    <link rel=\"stylesheet\" href=\"components/loader.css\">    \n" +
//"    <!-- <link rel=\"stylesheet\" href=\"css/style.css\"> -->\n" +
//"</head>\n" +
//"\n" +
//"<body>\n" +
//"		<div id=\"container\" class=\"container\">	\n" +
//"\n" +
//"			<div class=\"menu-panel\">\n" +
//"				<h3></h3>\n" +
//"				<ul id=\"menu-toc\" class=\"menu-toc\">\n"
//               + "<li class=\"menu-toc-current\"><a href=\"#item0\"></a><center><h4>Kadysoft Ltd.</h4></center></li>");
//        
//             for(int i = 1; i < newnewnum; i++) {            
//         
//         pwz.write("<li><a href=\"#item"+i+"\">Page "+i+"</a></li>\n");
//         
//      }
//             
//             
//        
//             pwz.write("</ul>\n" +
//"			</div>\n" +
//"\n" +
//"			<div class=\"bb-custom-wrapper\">\n" +
//"				<div id=\"bb-bookblock\" class=\"bb-bookblock\">\n"
//                     + "<div class=\"bb-item\" id=\"item0\">\n" +
//"						<div class=\"content\">\n" +
//"							<div class=\"scroller\">\n" +
//"<center><h3>Powered by </h3><img src=\"images/kadysoft.png\"></center>\n"
//                     + "<br><style>\n" +
//"#footer {\n" +
//"  background: #fff;\n" +
//"  box-shadow: 5px 5px 12px 5px rgba(0, 0, 0, 0.2);\n" +
//"  padding: 30px 10px;\n" +
//"  color: #333;\n" +
//"  font-size: 16px;\n" +
//"}\n" +
//"\n" +
//"#footer .credits {\n" +
//"  font-size: 15px;\n" +
//"  color: #888;\n" +
//"}\n" +
//"\n" +
//"#footer .footer-links a {\n" +
//"  color: #666;\n" +
//"  padding-left: 15px;\n" +
//"}\n" +
//"\n" +
//"#footer .footer-links a:first-child {\n" +
//"  padding-left: 0;\n" +
//"}\n" +
//"\n" +
//"#footer .footer-links a:hover {\n" +
//"  color: #1dc8cd;\n" +
//"}\n" +
//"\n" +
//"</style>\n" +
//"<body>\n" +
//"    <footer id=\"footer\">\n" +
//"    <div class=\"container\">\n" +
//"      <div class=\"row\">\n" +
//"        <div class=\"col-lg-6 text-lg-left text-center\">\n" +
//"          <div class=\"copyright\">\n" +
//"            <b>&copy; Copyright <a href=\"https://www.facebook.com/kadysoft\" target=\"_blank\"><strong style=\"color:deeppink;\">Kadysoft</strong></a>. All Rights Reserved.</b>\n" +
//"          </div><br>\n" +
//"          <div class=\"credits\"><b style=\"color:purple;\">Designed by <strong style=\"color:deeppink;\">Eagle.</strong></b>\n" +
//"          </div>\n" +
//"        </div>\n" +
//"        </div>\n" +
//"  </footer>\n" +
//"</body>\n" +
//"							</div>\n" +
//"						</div>\n" +
//"					</div>");
//             
//             for (int a=1; a < newnewnum; a++) {
//                 pwz.write("<div class=\"bb-item\" id=\"item"+a+"\">\n" +
//"						<div class=\"content\">\n" +
//"							<div class=\"scroller\">\n" +
//"<img src=\"images/"+a+".jpg\">\n" +
//"							</div>\n" +
//"						</div>\n" +
//"					</div>\n" +
//"					\n");
//             }
//             
//         pwz.write("				<nav>\n" +
//"					<span id=\"bb-nav-prev\">&larr;</span>\n" +
//"					<span id=\"bb-nav-next\">&rarr;</span>\n" +
//"				</nav>\n" +
//"\n" +
//"				<span id=\"tblcontents\" class=\"menu-button\">Table of Contents</span>\n" +
//"\n" +
//"			</div>\n" +
//"				\n" +
//"		</div><!-- /container -->\n" +
//"		<script src=\"js/jquery-3.4.1.min.js\"></script>\n" +
//"		<!-- <script src=\"js/jquery.mousewheel.js\"></script> -->\n" +
//"		<script src=\"js/jquery.jscrollpane.min.js\"></script>\n" +
//"		<script src=\"js/jquerypp.custom.js\"></script>\n" +
//"		<script src=\"js/jquery.bookblock.js\"></script>\n" +
//"		<script src=\"js/page.js\"></script>\n" +
//"    <script src=\"js/app.js\"></script>\n" +
//"    <script src=\"lib/onsenui/js/onsenui.min.js\"></script>\n" +
//"    <script type=\"text/javascript\">\n" +
//"    	$(document).ready(function(){\n" +
//"    		$('.jspScrollable').jScrollPane(\n" +
//"			{\n" +
//"				verticalDragMinHeight: 40,\n" +
//"				verticalDragMaxHeight: 40,\n" +
//"				horizontalDragMinWidth: 40,\n" +
//"				horizontalDragMaxWidth: 40\n" +
//"			}\n" +
//"			);\n" +
//"    	});\n" +
//"    	\n" +
//"    </script>"
//     +"</body>\n" +
//"</html>"
//       +"<script data-name=\"BMC-Widget\" data-cfasync=\"false\" src=\"https://cdnjs.buymeacoffee.com/1.0.0/widget.prod.min.js\" data-id=\"Kadysoft\" data-description=\"Support me on Buy me a coffee!\" data-message=\"\" data-color=\"#ff813f\" data-position=\"Right\" data-x_margin=\"18\" data-y_margin=\"18\"></script>");    
//             
//      pwz.close(); 
//      
//      //////////////////////////////////////////////////////////////////////
//      
//      
//      
//      
//  }
//  
//  
//  
//  
//  
//  
//  else {
//      
//      //Method 2
//      
//      
//      
//      PrintWriter pwz;
//      pwz=new PrintWriter (new FileWriter (projectfolder + "\\Cordova\\assets\\www\\index.html"));
//      
//      pwz.write("<!DOCTYPE html>\n" +
//"<html lang=\"en\">\n" +
//"<head>\n" +
//"  <meta charset=\"UTF-8\">\n" +
//"  <title>Kadysoft Book Viewer</title>\n" +
//"  <style>\n" +
//"    * {\n" +
//"      box-sizing: border-box;\n" +
//"    }\n" +
//"    body {\n" +
//"      margin: 0;\n" +
//"      font-family: 'Segoe UI', sans-serif;\n" +
//"      background: #1e1e2f;\n" +
//"      color: #f0f0f0;\n" +
//"    }\n" +
//"    .navbar {\n" +
//"      display: flex;\n" +
//"      justify-content: space-between;\n" +
//"      align-items: center;\n" +
//"      padding: 12px 20px;\n" +
//"      background-color: #282c34;\n" +
//"      color: #fff;\n" +
//"    }\n" +
//"    .navbar h1 {\n" +
//"      margin: 0;\n" +
//"      font-size: 22px;\n" +
//"      color: #90caf9;\n" +
//"    }\n" +
//"    .menu-toggle {\n" +
//"      background: none;\n" +
//"      border: none;\n" +
//"      color: white;\n" +
//"      font-size: 20px;\n" +
//"      cursor: pointer;\n" +
//"    }\n" +
//"    .controls-panel {\n" +
//"      display: none;\n" +
//"      flex-wrap: wrap;\n" +
//"      gap: 10px;\n" +
//"      justify-content: center;\n" +
//"      padding: 10px;\n" +
//"      background: #2c2f45;\n" +
//"      transition: all 0.3s ease;\n" +
//"    }\n" +
//"    .controls-panel.active {\n" +
//"      display: flex;\n" +
//"    }\n" +
//"    button, input[type=\"number\"], input[type=\"range\"] {\n" +
//"      background: #3949ab;\n" +
//"      color: white;\n" +
//"      border: none;\n" +
//"      padding: 8px 14px;\n" +
//"      border-radius: 8px;\n" +
//"      font-size: 14px;\n" +
//"      cursor: pointer;\n" +
//"      transition: 0.3s;\n" +
//"    }\n" +
//"    button:hover {\n" +
//"      background: #1e88e5;\n" +
//"    }\n" +
//"    input[type=\"range\"] {\n" +
//"      width: 100px;\n" +
//"    }\n" +
//"    input[type=\"number\"] {\n" +
//"      width: 60px;\n" +
//"      text-align: center;\n" +
//"    }\n" +
//"    .book-container {\n" +
//"      position: relative;\n" +
//"      margin: 20px auto;\n" +
//"      width: 90%;\n" +
//"      max-width: 1000px;\n" +
//"      height: 75vh;\n" +
//"      background-color: #2a2a3d;\n" +
//"      border-radius: 16px;\n" +
//"      box-shadow: 0 15px 40px rgba(0, 0, 0, 0.5);\n" +
//"      overflow: hidden;\n" +
//"    }\n" +
//"    .book {\n" +
//"      display: flex;\n" +
//"      height: 100%;\n" +
//"      transition: transform 0.6s ease;\n" +
//"    }\n" +
//"    .page {\n" +
//"      min-width: 100%;\n" +
//"      height: 100%;\n" +
//"      overflow: hidden;\n" +
//"      display: flex;\n" +
//"      align-items: center;\n" +
//"      justify-content: center;\n" +
//"    }\n" +
//"    .page img {\n" +
//"      max-width: 100%;\n" +
//"      max-height: 100%;\n" +
//"      object-fit: contain;\n" +
//"      transition: transform 0.3s ease;\n" +
//"    }\n" +
//"    .counter {\n" +
//"      font-size: 14px;\n" +
//"      color: #ccc;\n" +
//"      padding: 8px;\n" +
//"    }\n" +
//"  </style>\n" +
//"</head>\n" +
//"<body>\n" +
//"\n" +
//"<div class=\"navbar\">\n" +
//"  <h1>"+apknam+"</h1>\n" +
//"  <button class=\"menu-toggle\" onclick=\"toggleMenu()\">Menu</button>\n" +
//"</div>\n" +
//"\n" +
//"<div class=\"controls-panel\" id=\"controlsPanel\">\n" +
//"  <button onclick=\"prevPage()\">Previous</button>\n" +
//"  <button onclick=\"nextPage()\">Next</button>\n" +
//"  <span class=\"counter\" id=\"counter\">Page 1 / "+pnum+"</span>\n" +
//"  <input type=\"range\" min=\"0.5\" max=\"2\" step=\"0.1\" value=\"1\" id=\"zoomSlider\" title=\"Zoom\">\n" +
//"  <input type=\"number\" min=\"1\" max=\"20\" id=\"goToPage\" placeholder=\"Page #\" title=\"Go to page\">\n" +
//"  <button onclick=\"gotoPage()\">Go</button>\n" +
//"  <button onclick=\"toggleFull()\">Fullscreen</button>\n" +
//"</div>\n" +
//"\n" +
//"<div class=\"book-container\">\n" +
//"  <div class=\"book\" id=\"book\"></div>\n" +
//"</div>\n" +
//"\n" +
//"<script>\n" +
//"  const totalPages = "+pnum+";\n" +
//"  const book = document.getElementById(\"book\");\n" +
//"  const counter = document.getElementById(\"counter\");\n" +
//"  const zoomSlider = document.getElementById(\"zoomSlider\");\n" +
//"  const goToInput = document.getElementById(\"goToPage\");\n" +
//"  const controlsPanel = document.getElementById(\"controlsPanel\");\n" +
//"\n" +
//"  let currentPage = 0;\n" +
//"  let zoom = 1;\n" +
//"\n" +
//"  function loadPages() {\n" +
//"    for (let i = 1; i <= totalPages; i++) {\n" +
//"      const page = document.createElement(\"div\");\n" +
//"      page.className = \"page\";\n" +
//"      const img = document.createElement(\"img\");\n" +
//"      img.src = `images/${i}.jpg`;\n" +
//"      img.alt = `Page ${i}`;\n" +
//"      page.appendChild(img);\n" +
//"      book.appendChild(page);\n" +
//"    }\n" +
//"    updateView();\n" +
//"  }\n" +
//"\n" +
//"  function updateView() {\n" +
//"    book.style.transform = `translateX(-${currentPage * 100}%)`;\n" +
//"    document.querySelectorAll(\".page img\").forEach(img => {\n" +
//"      img.style.transform = `scale(${zoom})`;\n" +
//"    });\n" +
//"    counter.textContent = `Page ${currentPage + 1} / ${totalPages}`;\n" +
//"  }\n" +
//"\n" +
//"  function nextPage() {\n" +
//"    if (currentPage < totalPages - 1) {\n" +
//"      currentPage++;\n" +
//"      updateView();\n" +
//"    }\n" +
//"  }\n" +
//"\n" +
//"  function prevPage() {\n" +
//"    if (currentPage > 0) {\n" +
//"      currentPage--;\n" +
//"      updateView();\n" +
//"    }\n" +
//"  }\n" +
//"\n" +
//"  function gotoPage() {\n" +
//"    const p = parseInt(goToInput.value);\n" +
//"    if (!isNaN(p) && p >= 1 && p <= totalPages) {\n" +
//"      currentPage = p - 1;\n" +
//"      updateView();\n" +
//"    }\n" +
//"  }\n" +
//"\n" +
//"  function toggleFull() {\n" +
//"    if (!document.fullscreenElement) {\n" +
//"      document.documentElement.requestFullscreen().catch(err => alert(err));\n" +
//"    } else {\n" +
//"      document.exitFullscreen();\n" +
//"    }\n" +
//"  }\n" +
//"\n" +
//"  function toggleMenu() {\n" +
//"    controlsPanel.classList.toggle(\"active\");\n" +
//"  }\n" +
//"\n" +
//"  zoomSlider.addEventListener(\"input\", (e) => {\n" +
//"    zoom = parseFloat(e.target.value);\n" +
//"    updateView();\n" +
//"  });\n" +
//"\n" +
//"  document.addEventListener(\"keydown\", (e) => {\n" +
//"    if (e.key === \"ArrowRight\") nextPage();\n" +
//"    if (e.key === \"ArrowLeft\") prevPage();\n" +
//"  });\n" +
//"\n" +
//"  loadPages();\n" +
//"</script>\n" +
//"\n" +
//"</body>\n" +
//"</html>");    
//      pwz.close(); 
//      
//      //////////////////////////////////////////////////////////////////////
//      
//      
//      
//      
//  }
//  
//  
    
      
          
try {
    File zipFile = new File(apksource); // The ZIP or APK file you want to extract
    File outputFolder = new File(projectfolder + "\\Cordova\\assets\\www\\images"); // Target folder for extraction

    if (!outputFolder.exists()) {
        outputFolder.mkdirs();
    }

    byte[] buffer = new byte[1024];

    try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            File newFile = new File(outputFolder, entry.getName());

            // Security: prevent zip-slip attack
            String destDirPath = outputFolder.getCanonicalPath();
            String destFilePath = newFile.getCanonicalPath();
            if (!destFilePath.startsWith(destDirPath + File.separator)) {
                System.out.println("Skipping suspicious entry: " + entry.getName());
                continue;
            }

            if (entry.isDirectory()) {
                newFile.mkdirs();
            } else {
                new File(newFile.getParent()).mkdirs();

                try (FileOutputStream fos = new FileOutputStream(newFile)) {
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                }
            }
        }
    }

    System.out.println("Extraction complete.");

} catch (IOException e) {
    e.printStackTrace();
}

      
      
      
//      ProcessBuilder pb3 = new ProcessBuilder(new String[]{projectfolder + "\\kady3.bat"});
//      pb3.redirectError();
//
//      try {
//         Process b3 = pb3.start();
//         InputStream inputStream = b3.getInputStream();
//         Throwable var1326 = null;
//
//         try {
//            boolean var30 = true;
//
//            int in;
//            while((in = inputStream.read()) != -1) {
//               System.out.print((char)in);
//            }
//         } catch (Throwable var1289) {
//            var1326 = var1289;
//            throw var1289;
//         } finally {
//            if (inputStream != null) {
//               if (var1326 != null) {
//                  try {
//                     inputStream.close();
//                  } catch (Throwable var1221) {
//                     var1326.addSuppressed(var1221);
//                  }
//               } else {
//                  inputStream.close();
//               }
//            }
//
//         }
//
//         System.out.println("Exited with " + b3.waitFor());
//      } catch (IOException var1291) {
//         ;
//      } catch (InterruptedException var1292) {
//         ;
//      }



      
      ProcessBuilder pb2r = new ProcessBuilder(new String[]{projectfolder + "\\kady11.bat"});
      pb2r.redirectError();

      try {
         Process b2r = pb2r.start();
         InputStream inputStream = b2r.getInputStream();
         Throwable var1336 = null;

         try {
            boolean var32 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1281) {
            var1336 = var1281;
            throw var1281;
         } finally {
            if (inputStream != null) {
               if (var1336 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1219) {
                     var1336.addSuppressed(var1219);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b2r.waitFor());
      } catch (IOException var1283) {
         ;
      } catch (InterruptedException var1284) {
         ;
      }
      /////////////////////////////////////////////////////////////////////
      
      
      ProcessBuilder pb2r0 = new ProcessBuilder(new String[]{projectfolder + "\\kady1100.bat"});
      pb2r0.redirectError();

      try {
         Process b2r0 = pb2r0.start();
         InputStream inputStream = b2r0.getInputStream();
         Throwable var1336 = null;

         try {
            boolean var32 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1281) {
            var1336 = var1281;
            throw var1281;
         } finally {
            if (inputStream != null) {
               if (var1336 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1219) {
                     var1336.addSuppressed(var1219);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b2r0.waitFor());
      } catch (IOException var1283) {
         ;
      } catch (InterruptedException var1284) {
         ;
      }

      /////////////////////////////////////////////////////////////////////
      ProcessBuilder pb2rt = new ProcessBuilder(new String[]{projectfolder + "\\kady12.bat"});
      pb2rt.redirectError();

      try {
         Process b2rt = pb2rt.start();
         InputStream inputStream = b2rt.getInputStream();
         Throwable var1341 = null;

         try {
            boolean var33 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1277) {
            var1341 = var1277;
            throw var1277;
         } finally {
            if (inputStream != null) {
               if (var1341 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1218) {
                     var1341.addSuppressed(var1218);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b2rt.waitFor());
      } catch (IOException var1279) {
         ;
      } catch (InterruptedException var1280) {
         ;
      }

      ProcessBuilder pb10 = new ProcessBuilder(new String[]{projectfolder + "\\kady10.bat"});
      pb10.redirectError();

      try {
         Process b10 = pb10.start();
         InputStream inputStream = b10.getInputStream();
         Throwable var1346 = null;

         try {
            boolean var34 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1273) {
            var1346 = var1273;
            throw var1273;
         } finally {
            if (inputStream != null) {
               if (var1346 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1217) {
                     var1346.addSuppressed(var1217);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b10.waitFor());
      } catch (IOException var1275) {
         ;
      } catch (InterruptedException var1276) {
         ;
      }

      ProcessBuilder pb9 = new ProcessBuilder(new String[]{projectfolder + "\\kady9.bat"});
      pb9.redirectError();

      try {
         Process b9 = pb9.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      
      ProcessBuilder pb910 = new ProcessBuilder(new String[]{projectfolder + "\\kady910.bat"});
      pb910.redirectError();

      try {
         Process b9 = pb910.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      
      ProcessBuilder pb9100 = new ProcessBuilder(new String[]{projectfolder + "\\kady9100.bat"});
      pb9100.redirectError();

      try {
         Process b9 = pb9100.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      
      ProcessBuilder pb91000 = new ProcessBuilder(new String[]{projectfolder + "\\kady91000.bat"});
      pb91000.redirectError();

      try {
         Process b9 = pb91000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      
      ProcessBuilder pb910000 = new ProcessBuilder(new String[]{projectfolder + "\\kady910000.bat"});
      pb910000.redirectError();

      try {
         Process b9 = pb910000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


      ProcessBuilder pb9100000 = new ProcessBuilder(new String[]{projectfolder + "\\kady9100000.bat"});
      pb9100000.redirectError();

      try {
         Process b9 = pb9100000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      ProcessBuilder pb91000000 = new ProcessBuilder(new String[]{projectfolder + "\\kady91000000.bat"});
      pb91000000.redirectError();

      try {
         Process b9 = pb91000000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      ProcessBuilder pb910000000 = new ProcessBuilder(new String[]{projectfolder + "\\kady910000000.bat"});
      pb910000000.redirectError();

      try {
         Process b9 = pb910000000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      ProcessBuilder pb9100000000 = new ProcessBuilder(new String[]{projectfolder + "\\kady9100000000.bat"});
      pb9100000000.redirectError();

      try {
         Process b9 = pb9100000000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      ProcessBuilder pb91000000000 = new ProcessBuilder(new String[]{projectfolder + "\\kady91000000000.bat"});
      pb91000000000.redirectError();

      try {
         Process b9 = pb91000000000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      ProcessBuilder pb910000000000 = new ProcessBuilder(new String[]{projectfolder + "\\kady910000000000.bat"});
      pb910000000000.redirectError();

      try {
         Process b9 = pb910000000000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      ProcessBuilder pb5 = new ProcessBuilder(new String[]{projectfolder + "\\kady5.bat"});
      pb5.redirectError();

      try {
         Process b5 = pb5.start();
         InputStream inputStream = b5.getInputStream();
         Throwable var1356 = null;

         try {
            boolean var36 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1265) {
            var1356 = var1265;
            throw var1265;
         } finally {
            if (inputStream != null) {
               if (var1356 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1215) {
                     var1356.addSuppressed(var1215);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b5.waitFor());
      } catch (IOException var1267) {
         ;
      } catch (InterruptedException var1268) {
         ;
      }

      ProcessBuilder pb6 = new ProcessBuilder(new String[]{projectfolder + "\\kady6.bat"});
      pb6.redirectError();

      try {
         Process b6 = pb6.start();
         InputStream inputStream = b6.getInputStream();
         Throwable var1361 = null;

         try {
            boolean var37 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1261) {
            var1361 = var1261;
            throw var1261;
         } finally {
            if (inputStream != null) {
               if (var1361 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1214) {
                     var1361.addSuppressed(var1214);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b6.waitFor());
      } catch (IOException var1263) {
         ;
      } catch (InterruptedException var1264) {
         ;
      }

      ProcessBuilder pb7 = new ProcessBuilder(new String[]{projectfolder + "\\kady7.bat"});
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

      ProcessBuilder pb8 = new ProcessBuilder(new String[]{projectfolder + "\\kady8.bat"});
      pb8.redirectError();

      Process b82;
      try {
         b82 = pb8.start();
         inputStream = b82.getInputStream();
         var1366 = null;

         try {
            var38 = true;

            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1253) {
            var1366 = var1253;
            throw var1253;
         } finally {
            if (inputStream != null) {
               if (var1366 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1212) {
                     var1366.addSuppressed(var1212);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b82.waitFor());
      } catch (IOException var1255) {
         ;
      } catch (InterruptedException var1256) {
         ;
      }

      
       Thread.sleep(5000);
      
      
      try {
         b82 = Runtime.getRuntime().exec("cmd /c rmdir /s /q " + projectfolder);
      } catch (IOException var1211) {
         ;
      }

//      alert.setAlertType(AlertType.INFORMATION);
//      alert.close();
//      
//      Stage stg = (Stage)this.create.getScene().getWindow();
//      stg.close();
//      
//      
//        Notifications noti = Notifications.create();
//            noti.title("Great!");
//            noti.text("APP Created Successfully.");
//            noti.position(Pos.CENTER);
//            noti.hideAfter(Duration.seconds(5));
//            noti.showInformation();
//      
//      
//      
//      Desktop fjh=Desktop.getDesktop();
//       try {
//           fjh.open(new File (System.getProperty("user.home")+"\\Desktop"));
//       } catch (IOException ex) {
//           Logger.getLogger(CreateHtmlApkController.class.getName()).log(Level.SEVERE, null, ex);
//       }
       
       
         // Simulate delay (optional)
        Thread.sleep(1000);
        // Final progress to 100%
        Platform.runLater(() -> progressBar.setProgress(1.0));
        // Let progress bar show 100% before closing
        Thread.sleep(500);
        return null;
    }
    
    @Override
        protected void failed() {
            Platform.runLater(() -> {
                alert.close();
                Alert fail = new Alert(Alert.AlertType.ERROR, "❌ Error: " + getException().getMessage(), ButtonType.OK);
                fail.showAndWait();
            });
        }
   
    @Override
    protected void succeeded() {
        super.succeeded();
        Platform.runLater(() -> {
            alert.close(); // close the progress alert
            // Show the "done" alert
            Notifications noti = Notifications.create();
            noti.title("Great!");
            noti.text("✅ APK created successfully on your desktop!");
            noti.position(Pos.CENTER);
            noti.hideAfter(Duration.seconds(7));
            noti.showInformation();
            
        });
    }
};
// Start background thread
Thread backgroundThread = new Thread(task);
backgroundThread.setDaemon(true);
backgroundThread.start();

       
       
       
           
           
           
       }
       
       
      
       
       
       
       else {
           
           
      String apknam = this.apkname.getText();
      String apkpkg = this.packagename.getText();
      String apkico = this.pathlabel.getText();
      String apksource = this.htmlfile.getText();
      
      if (method1.isSelected()==true) {
           
          String apkresourcee =System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\kadysoft.zip";
          
          apkresource=apkresourcee;
          
          
           
       }
      
      if (method2.isSelected()==true) {
           
          String apkresourcee =System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\kadysoftt.zip";
          
          apkresource=apkresourcee;
           
       }
       
      
      
      String pnum=htmlfile111.getText();
      int newnum=Integer.parseInt(pnum);
      int newnewnum=newnum+1;
        
        
        
        
        
        
        
        
         
final Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Creating APK, Please wait ...");
String contentText = "Congratulations\n" +
"Task maybe takes 1 minute, you will find \"" + apknam + ".apk\"on your desktop after Finishing.\n" +
"Support Eagle and Kadysoft on Facebook.\n\nMade with L❤VE by Kadysoft.";
Label statusLabel = new Label(contentText);
JFXProgressBar progressBar = new JFXProgressBar(0);
progressBar.setPrefWidth(300);
VBox content = new VBox(10, statusLabel, progressBar);
alert.getDialogPane().setContent(content);
alert.setGraphic(imgview);
alert.setResizable(false);
alert.getDialogPane().getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
Platform.runLater(alert::show);

Task<Void> task = new Task<Void>() {
    @Override
    protected Void call() throws Exception {
        
        
        Random random = new Random();

        // Progress simulator
        for (int i = 0; i < 20; i++) {
            Thread.sleep(200 + random.nextInt(300)); // simulate work
            double simulatedProgress = Math.min(0.95, progressBar.getProgress() + 0.025 + random.nextDouble() * 0.05);
            double finalProgress = simulatedProgress;
            Platform.runLater(() -> progressBar.setProgress(finalProgress));
        }
        
        
        
        
        
        
        
        
        
      File projectfolder = new File(System.getProperty("user.home") + "\\appdata\\roaming\\HtmlProject");
      projectfolder.mkdir();

      try {
         Process var10 = Runtime.getRuntime().exec("cmd /c copy " + System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Cordova.kady " + projectfolder + "\\Cordova.apk");
      } catch (IOException var1252) {
         ;
      }

      File batfile1 = new File(projectfolder + "\\kady1.bat");

      try {
         batfile1.createNewFile();
      } catch (IOException var1251) {
         ;
      }

      try {
         PrintWriter pw = new PrintWriter(new FileWriter(batfile1));
         pw.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\apktool.bat d -f " + projectfolder + "\\Cordova.apk -o " + projectfolder + "\\Cordova");
         pw.close();
      } catch (IOException var1250) {
         ;
      }

      File framwork = new File(projectfolder + "\\kady2.bat");

      try {
         framwork.createNewFile();
      } catch (IOException var1249) {
         ;
      }

      try {
         PrintWriter pwq = new PrintWriter(new FileWriter(framwork));
         pwq.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\apktool.bat if " + projectfolder + "\\Cordova.apk");
         pwq.close();
      } catch (IOException var1248) {
         ;
      }

//      File htmlbat2 = new File(projectfolder + "\\kady3.bat");
//
//      try {
//         htmlbat2.createNewFile();
//      } catch (IOException var1247) {
//         ;
//      }
//
//      try {
//         PrintWriter lcv = new PrintWriter(new FileWriter(htmlbat2));
//         lcv.println("cd " + projectfolder + "\\Cordova\\assets\\www\\images");
//         lcv.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\7z.exe x -y " + apksource);
//         lcv.close();
//      } catch (IOException var1246) {
//         ;
//      }

//      File htmlbat1 = new File(projectfolder + "\\kady4.bat");
//
//      try {
//         htmlbat1.createNewFile();
//      } catch (IOException var1245) {
//         ;
//      }
//
//      try {
//         PrintWriter lcv = new PrintWriter(new FileWriter(htmlbat1));
//         lcv.println("cd " + projectfolder + "\\Cordova\\assets\\www");
//         lcv.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\7z.exe x -y " + apkresource);
//         lcv.close();
//      } catch (IOException var1244) {
//         ;
//      }
      
      File htmlbat11 = new File(projectfolder + "\\kady9.bat");

      try {
         htmlbat11.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat11));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-hdpi");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-hdpi\\ic_launcher.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

File htmlbat1110 = new File(projectfolder + "\\kady910.bat");

      try {
         htmlbat1110.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat1110));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-ldpi");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-ldpi\\ic_launcher.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
      
      File htmlbat11100 = new File(projectfolder + "\\kady9100.bat");

      try {
         htmlbat11100.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat11100));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-mdpi");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-mdpi\\ic_launcher.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
      File htmlbat111000 = new File(projectfolder + "\\kady91000.bat");

      try {
         htmlbat111000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat111000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xxhdpi");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xxhdpi\\ic_launcher.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
      
      File htmlbat1110000 = new File(projectfolder + "\\kady910000.bat");

      try {
         htmlbat1110000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat1110000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xxxhdpi");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xxxhdpi\\ic_launcher.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
//////////////////////////////////////////////////////////////////////////////////////////////////////////
 
      File htmlbat11100000 = new File(projectfolder + "\\kady9100000.bat");

      try {
         htmlbat11100000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat11100000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-hdpi-v26");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-hdpi-v26\\ic_launcher_foreground.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
       
      File htmlbat111000000 = new File(projectfolder + "\\kady91000000.bat");

      try {
         htmlbat111000000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat111000000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-ldpi-v26");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-ldpi-v26\\ic_launcher_foreground.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
       
      File htmlbat1110000000 = new File(projectfolder + "\\kady910000000.bat");

      try {
         htmlbat1110000000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat1110000000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-mhdpi-v26");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-mhdpi-v26\\ic_launcher_foreground.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
       
      File htmlbat11100000000 = new File(projectfolder + "\\kady9100000000.bat");

      try {
         htmlbat11100000000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat11100000000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xhdpi-v26");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xhdpi-v26\\ic_launcher_foreground.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
       
      File htmlbat111000000000 = new File(projectfolder + "\\kady91000000000.bat");

      try {
         htmlbat111000000000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat111000000000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xxhdpi-v26");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xxhdpi-v26\\ic_launcher_foreground.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
      
       
      File htmlbat1110000000000 = new File(projectfolder + "\\kady910000000000.bat");

      try {
         htmlbat1110000000000.createNewFile();
      } catch (IOException var1243) {
         ;
      }

      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat1110000000000));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xxxhdpi-v26");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xxxhdpi-v26\\ic_launcher_foreground.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      File htmlbat111 = new File(projectfolder + "\\kady10.bat");

      try {
         htmlbat111.createNewFile();
      } catch (IOException var1241) {
         ;
      }

      try {
         PrintWriter lcvvv = new PrintWriter(new FileWriter(htmlbat111));
         lcvvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xhdpi");
         lcvvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xhdpi\\ic_launcher.png");
         lcvvv.close();
      } catch (IOException var1240) {
         ;
      }

      File batfile3 = new File(projectfolder + "\\kady5.bat");

      try {
         batfile3.createNewFile();
      } catch (IOException var1239) {
         ;
      }

      try {
         PrintWriter pww = new PrintWriter(new FileWriter(batfile3));
         pww.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\apktool.bat b -f " + projectfolder + "\\Cordova");
         pww.close();
      } catch (IOException var1238) {
         ;
      }

      File batfile5 = new File(projectfolder + "\\kady6.bat");

      try {
         batfile5.createNewFile();
      } catch (IOException var1237) {
         ;
      }

      try {
         PrintWriter pwwu = new PrintWriter(new FileWriter(batfile5));
         pwwu.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\zipalign.exe -v 4 " + projectfolder + "\\Cordova\\dist\\Cordova.apk " + projectfolder + "\\newApk.apk");
         pwwu.close();
      } catch (IOException var1236) {
         ;
      }

      File batfile4 = new File(projectfolder + "\\kady7.bat");

      try {
         batfile4.createNewFile();
      } catch (IOException var1235) {
         ;
      }

      try {
         PrintWriter pwww = new PrintWriter(new FileWriter(batfile4));
         //pwww.println("cd " + System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data");
         pwww.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk.bat " + projectfolder + "\\newApk.apk");
         pwww.close();
      } catch (IOException var1234) {
         ;
      }

      File batfile6 = new File(projectfolder + "\\kady8.bat");

      try {
         batfile6.createNewFile();
      } catch (IOException var1233) {
         ;
      }

      try {
         PrintWriter pwwww = new PrintWriter(new FileWriter(batfile6));
         pwwww.println("copy " + projectfolder + "\\newApk_Eagle_Kadysoft.apk " + System.getProperty("user.home") + "\\desktop");
         pwwww.close();
      } catch (IOException var1232) {
         ;
      }

      File batfile66 = new File(projectfolder + "\\strings.xml");

      try {
         batfile66.createNewFile();
      } catch (IOException var1231) {
         ;
      }

      try {
         PrintWriter pwwwwn = new PrintWriter(new FileWriter(batfile66));
         pwwwwn.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
"<resources>\n" +
"    <string name=\"activity_name\">@string/launcher_name</string>\n" +
"    <string name=\"app_name\">"+apknam+"</string>\n" +
"    <string name=\"launcher_name\">@string/app_name</string>\n" +
"</resources>");
         pwwwwn.close();
      } catch (IOException var1230) {
         ;
      }
      /////////////////////////////////////////////////////////////////////
      
      File batfile6600 = new File(projectfolder + "\\AndroidManifest.xml");

      try {
         batfile6600.createNewFile();
      } catch (IOException var1231) {
         
      }

      try {
         PrintWriter pwwwwn00 = new PrintWriter(new FileWriter(batfile6600));
         pwwwwn00.println("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?><manifest xmlns:android=\"http://schemas.android.com/apk/res/android\" android:compileSdkVersion=\"28\" android:compileSdkVersionCodename=\"9\" android:hardwareAccelerated=\"true\" package=\"com.zib.apache.cordova.browser\" platformBuildVersionCode=\"10000\" platformBuildVersionName=\"1.0.0\">\n" +
"    <supports-screens android:anyDensity=\"true\" android:largeScreens=\"true\" android:normalScreens=\"true\" android:resizeable=\"true\" android:smallScreens=\"true\" android:xlargeScreens=\"true\"/>\n" +
"    <uses-permission android:name=\"android.permission.INTERNET\"/>\n" +
"    <application android:hardwareAccelerated=\"true\" android:icon=\"@mipmap/ic_launcher\" android:label=\"@string/app_name\" android:supportsRtl=\"true\">\n" +
"        <activity android:configChanges=\"keyboard|keyboardHidden|locale|orientation|screenLayout|screenSize|smallestScreenSize|uiMode\" android:label=\"@string/activity_name\" android:launchMode=\"singleTop\" android:name=\"com.zib.apache.cordova.browser.MainActivity\" android:theme=\"@android:style/Theme.DeviceDefault.NoActionBar\" android:windowSoftInputMode=\"adjustResize\">\n" +
"            <intent-filter android:label=\"@string/launcher_name\">\n" +
"                <action android:name=\"android.intent.action.MAIN\"/>\n" +
"                <category android:name=\"android.intent.category.LAUNCHER\"/>\n" +
"            </intent-filter>\n" +
"        </activity>\n" +
"        <meta-data android:name=\"com.android.vending.derived.apk.id\" android:value=\"1\"/>\n" +
"    </application>\n" +
"</manifest>");
         pwwwwn00.close();
      } catch (IOException var1230) {
         
      }
      
     //////////////////////////////////////////////////////////////////////
      File batfile666 = new File(projectfolder + "\\apktool.yml");

      try {
         batfile666.createNewFile();
      } catch (IOException var1229) {
         ;
      }

      try {
         PrintWriter pwwwwnx = new PrintWriter(new FileWriter(batfile666));
         pwwwwnx.println("!!brut.androlib.meta.MetaInfo\n" +
"apkFileName: Cordova.apk\n" +
"compressionType: false\n" +
"doNotCompress:\n" +
"- arsc\n" +
"- png\n" +
"isFrameworkApk: false\n" +
"packageInfo:\n" +
"  forcedPackageId: '127'\n" +
"  renameManifestPackage: com.eagle."+apkpkg+"\n" +
"sdkInfo:\n" +
"  minSdkVersion: '19'\n" +
"  targetSdkVersion: '28'\n" +
"sharedLibrary: false\n" +
"sparseResources: false\n" +
"unknownFiles: {}\n" +
"usesFramework:\n" +
"  ids:\n" +
"  - 1\n" +
"  tag: null\n" +
"version: 2.3.4\n" +
"versionInfo:\n" +
"  versionCode: '10000'\n" +
"  versionName: 1.0.0");
         pwwwwnx.close();
      } catch (IOException var1228) {
         ;
      }

      File batfile65 = new File(projectfolder + "\\kady11.bat");

      try {
         batfile65.createNewFile();
      } catch (IOException var1227) {
         ;
      }

      try {
         PrintWriter pwwwwm = new PrintWriter(new FileWriter(batfile65));
         pwwwwm.println("copy /Y " + projectfolder + "\\strings.xml " + projectfolder + "\\Cordova\\res\\values\\strings.xml");
         pwwwwm.close();
      } catch (IOException var1226) {
         ;
      }
      /////////////////////////////////////////////////////////////////////////////
      
      File batfile650 = new File(projectfolder + "\\kady1100.bat");

      try {
         batfile650.createNewFile();
      } catch (IOException var1227) {
         
      }

      try {
         PrintWriter pwwwwm0 = new PrintWriter(new FileWriter(batfile650));
         pwwwwm0.println("copy /Y " + projectfolder + "\\AndroidManifest.xml " + projectfolder + "\\Cordova\\AndroidManifest.xml");
         pwwwwm0.close();
      } catch (IOException var1226) {
         
      }
      
      /////////////////////////////////////////////////////////////////////////////

      File batfile655 = new File(projectfolder + "\\kady12.bat");

      try {
         batfile655.createNewFile();
      } catch (IOException var1225) {
         ;
      }

      try {
         PrintWriter pwwwwmmm = new PrintWriter(new FileWriter(batfile655));
         pwwwwmmm.println("copy /Y " + projectfolder + "\\apktool.yml " + projectfolder + "\\Cordova\\apktool.yml");
         pwwwwmmm.close();
      } catch (IOException var1224) {
         ;
      }

      ProcessBuilder pb1 = new ProcessBuilder(new String[]{projectfolder + "\\kady1.bat"});
      pb1.redirectError();

      try {
         Process b1 = pb1.start();
         InputStream inputStream = b1.getInputStream();
         Throwable var27 = null;

         try {
            boolean var28 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1297) {
            var27 = var1297;
            throw var1297;
         } finally {
            if (inputStream != null) {
               if (var27 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1223) {
                     var27.addSuppressed(var1223);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b1.waitFor());
      } catch (IOException var1299) {
         ;
      } catch (InterruptedException var1300) {
         ;
      }

      ProcessBuilder pb2 = new ProcessBuilder(new String[]{projectfolder + "\\kady2.bat"});
      pb2.redirectError();

      try {
         Process b2 = pb2.start();
         InputStream inputStream = b2.getInputStream();
         Throwable var1322 = null;

         try {
            boolean var29 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1293) {
            var1322 = var1293;
            throw var1293;
         } finally {
            if (inputStream != null) {
               if (var1322 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1222) {
                     var1322.addSuppressed(var1222);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b2.waitFor());
      } catch (IOException var1295) {
         ;
      } catch (InterruptedException var1296) {
         ;
      }
      
      
      
      
      
try {
    File zipFile = new File(apkresource); // The ZIP or APK file you want to extract
    File outputFolder = new File(projectfolder + "\\Cordova\\assets\\www"); // Target folder for extraction

    if (!outputFolder.exists()) {
        outputFolder.mkdirs();
    }

    byte[] buffer = new byte[1024];

    try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            File newFile = new File(outputFolder, entry.getName());

            // Security: prevent zip-slip attack
            String destDirPath = outputFolder.getCanonicalPath();
            String destFilePath = newFile.getCanonicalPath();
            if (!destFilePath.startsWith(destDirPath + File.separator)) {
                System.out.println("Skipping suspicious entry: " + entry.getName());
                continue;
            }

            if (entry.isDirectory()) {
                newFile.mkdirs();
            } else {
                new File(newFile.getParent()).mkdirs();

                try (FileOutputStream fos = new FileOutputStream(newFile)) {
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                }
            }
        }
    }

    System.out.println("Extraction complete.");

} catch (IOException e) {
    e.printStackTrace();
}


      
      
      
//      ProcessBuilder pb4 = new ProcessBuilder(new String[]{projectfolder + "\\kady4.bat"});
//      pb4.redirectError();
//
//      try {
//         Process b4 = pb4.start();
//         InputStream inputStream = b4.getInputStream();
//         Throwable var1331 = null;
//
//         try {
//            boolean var31 = true;
//
//            int in;
//            while((in = inputStream.read()) != -1) {
//               System.out.print((char)in);
//            }
//         } catch (Throwable var1285) {
//            var1331 = var1285;
//            throw var1285;
//         } finally {
//            if (inputStream != null) {
//               if (var1331 != null) {
//                  try {
//                     inputStream.close();
//                  } catch (Throwable var1220) {
//                     var1331.addSuppressed(var1220);
//                  }
//               } else {
//                  inputStream.close();
//               }
//            }
//
//         }
//
//         System.out.println("Exited with " + b4.waitFor());
//      } catch (IOException var1287) {
//         ;
//      } catch (InterruptedException var1288) {
//         ;
//      }

      
      //////////////////////////////////////////////////////////////////////
   //   try {
   //      Process var10 = Runtime.getRuntime().exec("cmd /c copy "+apksource+" "+projectfolder + "\\Cordova\\assets\\www\\pages\\kady.zip");
  //    } catch (IOException var1252) {
  //       ;
  //    }
  
  
  
  if (method1.isSelected()==true) {
      
      PrintWriter pwz;
      pwz=new PrintWriter (new FileWriter (projectfolder + "\\Cordova\\assets\\www\\index.html"));
      
      /*
        pwz.write("<!doctype html>\n" +
"<!--[if lt IE 7 ]> <html lang=\"en\" class=\"ie6\"> <![endif]-->\n" +
"<!--[if IE 7 ]>    <html lang=\"en\" class=\"ie7\"> <![endif]-->\n" +
"<!--[if IE 8 ]>    <html lang=\"en\" class=\"ie8\"> <![endif]-->\n" +
"<!--[if IE 9 ]>    <html lang=\"en\" class=\"ie9\"> <![endif]-->\n" +
"<!--[if !IE]><!--> <html lang=\"en\"> <!--<![endif]-->\n" +
"<head>\n" +
"<meta name=\"viewport\" content=\"width = 1050, user-scalable = no\" />\n" +
"<script type=\"text/javascript\" src=\"extras/jquery.min.1.7.js\"></script>\n" +
"<script type=\"text/javascript\" src=\"extras/modernizr.2.5.3.min.js\"></script>\n" +
"</head>\n" +
"<body>\n" +
"\n" +
"<div class=\"flipbook-viewport\">\n" +
"	<div class=\"container\">\n" +
"		<div class=\"flipbook\">\n");
             for(int i = 1; i < newnewnum; i++) {            
         
         pwz.write("<div style=\"background-image:url(pages/"+i+".jpg)\"></div>");
         
      }
             pwz.write("</div>\n" +
"	</div>\n" +
"</div>\n" +
"\n" +
"\n" +
"<script type=\"text/javascript\">\n" +
"\n" +
"function loadApp() {\n" +
"\n" +
"	// Create the flipbook\n" +
"\n" +
"	$('.flipbook').turn({\n" +
"			// Width\n" +
"\n" +
"			width:922,\n" +
"			\n" +
"			// Height\n" +
"\n" +
"			height:600,\n" +
"\n" +
"			// Elevation\n" +
"\n" +
"			elevation: 50,\n" +
"			\n" +
"			// Enable gradients\n" +
"\n" +
"			gradients: true,\n" +
"			\n" +
"			// Auto center this flipbook\n" +
"\n" +
"			autoCenter: true\n" +
"\n" +
"	});\n" +
"}\n" +
"\n" +
"// Load the HTML4 version if there's not CSS transform\n" +
"\n" +
"yepnope({\n" +
"	test : Modernizr.csstransforms,\n" +
"	yep: ['lib/turn.js'],\n" +
"	nope: ['lib/turn.html4.min.js'],\n" +
"	both: ['css/basic.css'],\n" +
"	complete: loadApp\n" +
"});\n" +
"\n" +
"</script>\n" +
"\n" +
"</body>\n" +
"</html>");
      pwz.close(); 
   */
      
       pwz.write("<html>\n" +
"<head>\n" +
"    <meta charset=\"utf-8\">\n" +
"    <meta name=\"viewport\" content=\"viewport-fit=cover, width=device-width, height=device-height, initial-scale=1, maximum-scale=1, user-scalable=no\">\n" +
"    <meta http-equiv=\"Content-Security-Policy\" content=\"default-src * data: gap: https://ssl.gstatic.com; style-src * 'unsafe-inline'; script-src * 'unsafe-inline' 'unsafe-eval'\">\n" +
"    <title>Kadysoft</title>\n" +
"		<meta name=\"description\" content=\"Eagle\" />\n" +
"		<meta name=\"keywords\" content=\"Kali Linux\" />\n" +
"		<meta name=\"author\" content=\"Ahmed Elkady\" /> \n" +
"		<link rel=\"stylesheet\" type=\"text/css\" href=\"css/jquery.jscrollpane.custom.css\" />\n" +
"		<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bookblock.css\" />\n" +
"		<link rel=\"stylesheet\" type=\"text/css\" href=\"css/custom.css\" />\n" +
"		<script src=\"js/modernizr.custom.79639.js\"></script>\n" +
"		\n" +
"    <link rel=\"stylesheet\" href=\"lib/onsenui/css/onsenui.css\">\n" +
"    <link rel=\"stylesheet\" href=\"lib/onsenui/css/onsen-css-components.css\">\n" +
"    <script src=\"components/loader.js\"></script>\n" +
"    <link rel=\"stylesheet\" href=\"components/loader.css\">    \n" +
"    <!-- <link rel=\"stylesheet\" href=\"css/style.css\"> -->\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"		<div id=\"container\" class=\"container\">	\n" +
"\n" +
"			<div class=\"menu-panel\">\n" +
"				<h3></h3>\n" +
"				<ul id=\"menu-toc\" class=\"menu-toc\">\n"
               + "<li class=\"menu-toc-current\"><a href=\"#item0\"></a><center><h4>Kadysoft Ltd.</h4></center></li>");
        
             for(int i = 1; i < newnewnum; i++) {            
         
         pwz.write("<li><a href=\"#item"+i+"\">Page "+i+"</a></li>\n");
         
      }
             
             
        
             pwz.write("</ul>\n" +
"			</div>\n" +
"\n" +
"			<div class=\"bb-custom-wrapper\">\n" +
"				<div id=\"bb-bookblock\" class=\"bb-bookblock\">\n"
                     + "<div class=\"bb-item\" id=\"item0\">\n" +
"						<div class=\"content\">\n" +
"							<div class=\"scroller\">\n" +
"<center><h3>Powered by </h3><img src=\"images/kadysoft.png\"></center>\n"
                     + "<br><style>\n" +
"#footer {\n" +
"  background: #fff;\n" +
"  box-shadow: 5px 5px 12px 5px rgba(0, 0, 0, 0.2);\n" +
"  padding: 30px 10px;\n" +
"  color: #333;\n" +
"  font-size: 16px;\n" +
"}\n" +
"\n" +
"#footer .credits {\n" +
"  font-size: 15px;\n" +
"  color: #888;\n" +
"}\n" +
"\n" +
"#footer .footer-links a {\n" +
"  color: #666;\n" +
"  padding-left: 15px;\n" +
"}\n" +
"\n" +
"#footer .footer-links a:first-child {\n" +
"  padding-left: 0;\n" +
"}\n" +
"\n" +
"#footer .footer-links a:hover {\n" +
"  color: #1dc8cd;\n" +
"}\n" +
"\n" +
"</style>\n" +
"<body>\n" +
"    <footer id=\"footer\">\n" +
"    <div class=\"container\">\n" +
"      <div class=\"row\">\n" +
"        <div class=\"col-lg-6 text-lg-left text-center\">\n" +
"          <div class=\"copyright\">\n" +
"            <b>&copy; Copyright <a href=\"https://www.facebook.com/kadysoft\" target=\"_blank\"><strong style=\"color:deeppink;\">Kadysoft</strong></a>. All Rights Reserved.</b>\n" +
"          </div><br>\n" +
"          <div class=\"credits\"><b style=\"color:purple;\">Designed by <strong style=\"color:deeppink;\">Eagle.</strong></b>\n" +
"          </div>\n" +
"        </div>\n" +
"        </div>\n" +
"  </footer>\n" +
"</body>\n" +
"							</div>\n" +
"						</div>\n" +
"					</div>");
             
             for (int a=1; a < newnewnum; a++) {
                 pwz.write("<div class=\"bb-item\" id=\"item"+a+"\">\n" +
"						<div class=\"content\">\n" +
"							<div class=\"scroller\">\n" +
"<img src=\"images/"+a+".jpg\">\n" +
"							</div>\n" +
"						</div>\n" +
"					</div>\n" +
"					\n");
             }
             
         pwz.write("				<nav>\n" +
"					<span id=\"bb-nav-prev\">&larr;</span>\n" +
"					<span id=\"bb-nav-next\">&rarr;</span>\n" +
"				</nav>\n" +
"\n" +
"				<span id=\"tblcontents\" class=\"menu-button\">Table of Contents</span>\n" +
"\n" +
"			</div>\n" +
"				\n" +
"		</div><!-- /container -->\n" +
"		<script src=\"js/jquery-3.4.1.min.js\"></script>\n" +
"		<!-- <script src=\"js/jquery.mousewheel.js\"></script> -->\n" +
"		<script src=\"js/jquery.jscrollpane.min.js\"></script>\n" +
"		<script src=\"js/jquerypp.custom.js\"></script>\n" +
"		<script src=\"js/jquery.bookblock.js\"></script>\n" +
"		<script src=\"js/page.js\"></script>\n" +
"    <script src=\"js/app.js\"></script>\n" +
"    <script src=\"lib/onsenui/js/onsenui.min.js\"></script>\n" +
"    <script type=\"text/javascript\">\n" +
"    	$(document).ready(function(){\n" +
"    		$('.jspScrollable').jScrollPane(\n" +
"			{\n" +
"				verticalDragMinHeight: 40,\n" +
"				verticalDragMaxHeight: 40,\n" +
"				horizontalDragMinWidth: 40,\n" +
"				horizontalDragMaxWidth: 40\n" +
"			}\n" +
"			);\n" +
"    	});\n" +
"    	\n" +
"    </script>"
     +"</body>\n" +
"</html>"
     + "");    
             
      pwz.close(); 
      
      //////////////////////////////////////////////////////////////////////
      
      
      if (changelogo.isSelected()==true) {
          
            // Path to the image you want to replace
        String originalImagePath = projectfolder + "\\Cordova\\assets\\www\\images\\kadysoft.png";
        // Path to the new image that will replace the old one
        String newImagePath = pathtologo;
        try {
            File originalImage = new File(originalImagePath);
            File newImage = new File(newImagePath);
            // Replace (copy and overwrite) the original image with the new one
            Files.copy(newImage.toPath(), originalImage.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image replaced successfully.");
        } catch (IOException e) {
            System.err.println("Error while replacing image: " + e.getMessage());
        }
          
      }
      
      
      else {
          
          
          
      }
      
      
    
      
      
      
      
  }
  
  
  
  
  
  
  else {
      
      //Method 2
      
      
      
      PrintWriter pwz;
      pwz=new PrintWriter (new FileWriter (projectfolder + "\\Cordova\\assets\\www\\index.html"));
      
      pwz.write("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"  <meta charset=\"UTF-8\">\n" +
"  <title>Kadysoft Book Viewer</title>\n" +
"  <style>\n" +
"    * {\n" +
"      box-sizing: border-box;\n" +
"    }\n" +
"    body {\n" +
"      margin: 0;\n" +
"      font-family: 'Segoe UI', sans-serif;\n" +
"      background: #1e1e2f;\n" +
"      color: #f0f0f0;\n" +
"    }\n" +
"    .navbar {\n" +
"      display: flex;\n" +
"      justify-content: space-between;\n" +
"      align-items: center;\n" +
"      padding: 12px 20px;\n" +
"      background-color: #282c34;\n" +
"      color: #fff;\n" +
"    }\n" +
"    .navbar h1 {\n" +
"      margin: 0;\n" +
"      font-size: 22px;\n" +
"      color: #90caf9;\n" +
"    }\n" +
"    .menu-toggle {\n" +
"      background: none;\n" +
"      border: none;\n" +
"      color: white;\n" +
"      font-size: 20px;\n" +
"      cursor: pointer;\n" +
"    }\n" +
"    .controls-panel {\n" +
"      display: none;\n" +
"      flex-wrap: wrap;\n" +
"      gap: 10px;\n" +
"      justify-content: center;\n" +
"      padding: 10px;\n" +
"      background: #2c2f45;\n" +
"      transition: all 0.3s ease;\n" +
"    }\n" +
"    .controls-panel.active {\n" +
"      display: flex;\n" +
"    }\n" +
"    button, input[type=\"number\"], input[type=\"range\"] {\n" +
"      background: #3949ab;\n" +
"      color: white;\n" +
"      border: none;\n" +
"      padding: 8px 14px;\n" +
"      border-radius: 8px;\n" +
"      font-size: 14px;\n" +
"      cursor: pointer;\n" +
"      transition: 0.3s;\n" +
"    }\n" +
"    button:hover {\n" +
"      background: #1e88e5;\n" +
"    }\n" +
"    input[type=\"range\"] {\n" +
"      width: 100px;\n" +
"    }\n" +
"    input[type=\"number\"] {\n" +
"      width: 60px;\n" +
"      text-align: center;\n" +
"    }\n" +
"    .book-container {\n" +
"      position: relative;\n" +
"      margin: 20px auto;\n" +
"      width: 90%;\n" +
"      max-width: 1000px;\n" +
"      height: 75vh;\n" +
"      background-color: #2a2a3d;\n" +
"      border-radius: 16px;\n" +
"      box-shadow: 0 15px 40px rgba(0, 0, 0, 0.5);\n" +
"      overflow: hidden;\n" +
"    }\n" +
"    .book {\n" +
"      display: flex;\n" +
"      height: 100%;\n" +
"      transition: transform 0.6s ease;\n" +
"    }\n" +
"    .page {\n" +
"      min-width: 100%;\n" +
"      height: 100%;\n" +
"      overflow: hidden;\n" +
"      display: flex;\n" +
"      align-items: center;\n" +
"      justify-content: center;\n" +
"    }\n" +
"    .page img {\n" +
"      max-width: 100%;\n" +
"      max-height: 100%;\n" +
"      object-fit: contain;\n" +
"      transition: transform 0.3s ease;\n" +
"    }\n" +
"    .counter {\n" +
"      font-size: 14px;\n" +
"      color: #ccc;\n" +
"      padding: 8px;\n" +
"    }\n" +
"  </style>\n" +
"</head>\n" +
"<body>\n" +
"\n" +
"<div class=\"navbar\">\n" +
"  <h1>"+apknam+"</h1>\n" +
"  <button class=\"menu-toggle\" onclick=\"toggleMenu()\">Menu</button>\n" +
"</div>\n" +
"\n" +
"<div class=\"controls-panel\" id=\"controlsPanel\">\n" +
"  <button onclick=\"prevPage()\">Previous</button>\n" +
"  <button onclick=\"nextPage()\">Next</button>\n" +
"  <span class=\"counter\" id=\"counter\">Page 1 / "+pnum+"</span>\n" +
"  <input type=\"range\" min=\"0.5\" max=\"2\" step=\"0.1\" value=\"1\" id=\"zoomSlider\" title=\"Zoom\">\n" +
"  <input type=\"number\" min=\"1\" max=\"20\" id=\"goToPage\" placeholder=\"Page #\" title=\"Go to page\">\n" +
"  <button onclick=\"gotoPage()\">Go</button>\n" +
"  <button onclick=\"toggleFull()\">Fullscreen</button>\n" +
"</div>\n" +
"\n" +
"<div class=\"book-container\">\n" +
"  <div class=\"book\" id=\"book\"></div>\n" +
"</div>\n" +
"\n" +
"<script>\n" +
"  const totalPages = "+pnum+";\n" +
"  const book = document.getElementById(\"book\");\n" +
"  const counter = document.getElementById(\"counter\");\n" +
"  const zoomSlider = document.getElementById(\"zoomSlider\");\n" +
"  const goToInput = document.getElementById(\"goToPage\");\n" +
"  const controlsPanel = document.getElementById(\"controlsPanel\");\n" +
"\n" +
"  let currentPage = 0;\n" +
"  let zoom = 1;\n" +
"\n" +
"  function loadPages() {\n" +
"    for (let i = 1; i <= totalPages; i++) {\n" +
"      const page = document.createElement(\"div\");\n" +
"      page.className = \"page\";\n" +
"      const img = document.createElement(\"img\");\n" +
"      img.src = `images/${i}.jpg`;\n" +
"      img.alt = `Page ${i}`;\n" +
"      page.appendChild(img);\n" +
"      book.appendChild(page);\n" +
"    }\n" +
"    updateView();\n" +
"  }\n" +
"\n" +
"  function updateView() {\n" +
"    book.style.transform = `translateX(-${currentPage * 100}%)`;\n" +
"    document.querySelectorAll(\".page img\").forEach(img => {\n" +
"      img.style.transform = `scale(${zoom})`;\n" +
"    });\n" +
"    counter.textContent = `Page ${currentPage + 1} / ${totalPages}`;\n" +
"  }\n" +
"\n" +
"  function nextPage() {\n" +
"    if (currentPage < totalPages - 1) {\n" +
"      currentPage++;\n" +
"      updateView();\n" +
"    }\n" +
"  }\n" +
"\n" +
"  function prevPage() {\n" +
"    if (currentPage > 0) {\n" +
"      currentPage--;\n" +
"      updateView();\n" +
"    }\n" +
"  }\n" +
"\n" +
"  function gotoPage() {\n" +
"    const p = parseInt(goToInput.value);\n" +
"    if (!isNaN(p) && p >= 1 && p <= totalPages) {\n" +
"      currentPage = p - 1;\n" +
"      updateView();\n" +
"    }\n" +
"  }\n" +
"\n" +
"  function toggleFull() {\n" +
"    if (!document.fullscreenElement) {\n" +
"      document.documentElement.requestFullscreen().catch(err => alert(err));\n" +
"    } else {\n" +
"      document.exitFullscreen();\n" +
"    }\n" +
"  }\n" +
"\n" +
"  function toggleMenu() {\n" +
"    controlsPanel.classList.toggle(\"active\");\n" +
"  }\n" +
"\n" +
"  zoomSlider.addEventListener(\"input\", (e) => {\n" +
"    zoom = parseFloat(e.target.value);\n" +
"    updateView();\n" +
"  });\n" +
"\n" +
"  document.addEventListener(\"keydown\", (e) => {\n" +
"    if (e.key === \"ArrowRight\") nextPage();\n" +
"    if (e.key === \"ArrowLeft\") prevPage();\n" +
"  });\n" +
"\n" +
"  loadPages();\n" +
"</script>\n" +
"\n" +
"</body>\n" +
"</html>");    
      pwz.close(); 
      
      //////////////////////////////////////////////////////////////////////
      
      
      
      
  }
  
  
    
      
          
try {
    File zipFile = new File(apksource); // The ZIP or APK file you want to extract
    File outputFolder = new File(projectfolder + "\\Cordova\\assets\\www\\images"); // Target folder for extraction

    if (!outputFolder.exists()) {
        outputFolder.mkdirs();
    }

    byte[] buffer = new byte[1024];

    try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            File newFile = new File(outputFolder, entry.getName());

            // Security: prevent zip-slip attack
            String destDirPath = outputFolder.getCanonicalPath();
            String destFilePath = newFile.getCanonicalPath();
            if (!destFilePath.startsWith(destDirPath + File.separator)) {
                System.out.println("Skipping suspicious entry: " + entry.getName());
                continue;
            }

            if (entry.isDirectory()) {
                newFile.mkdirs();
            } else {
                new File(newFile.getParent()).mkdirs();

                try (FileOutputStream fos = new FileOutputStream(newFile)) {
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                }
            }
        }
    }

    System.out.println("Extraction complete.");

} catch (IOException e) {
    e.printStackTrace();
}

      
      
      
//      ProcessBuilder pb3 = new ProcessBuilder(new String[]{projectfolder + "\\kady3.bat"});
//      pb3.redirectError();
//
//      try {
//         Process b3 = pb3.start();
//         InputStream inputStream = b3.getInputStream();
//         Throwable var1326 = null;
//
//         try {
//            boolean var30 = true;
//
//            int in;
//            while((in = inputStream.read()) != -1) {
//               System.out.print((char)in);
//            }
//         } catch (Throwable var1289) {
//            var1326 = var1289;
//            throw var1289;
//         } finally {
//            if (inputStream != null) {
//               if (var1326 != null) {
//                  try {
//                     inputStream.close();
//                  } catch (Throwable var1221) {
//                     var1326.addSuppressed(var1221);
//                  }
//               } else {
//                  inputStream.close();
//               }
//            }
//
//         }
//
//         System.out.println("Exited with " + b3.waitFor());
//      } catch (IOException var1291) {
//         ;
//      } catch (InterruptedException var1292) {
//         ;
//      }



      
      ProcessBuilder pb2r = new ProcessBuilder(new String[]{projectfolder + "\\kady11.bat"});
      pb2r.redirectError();

      try {
         Process b2r = pb2r.start();
         InputStream inputStream = b2r.getInputStream();
         Throwable var1336 = null;

         try {
            boolean var32 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1281) {
            var1336 = var1281;
            throw var1281;
         } finally {
            if (inputStream != null) {
               if (var1336 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1219) {
                     var1336.addSuppressed(var1219);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b2r.waitFor());
      } catch (IOException var1283) {
         ;
      } catch (InterruptedException var1284) {
         ;
      }
      /////////////////////////////////////////////////////////////////////
      
      
      ProcessBuilder pb2r0 = new ProcessBuilder(new String[]{projectfolder + "\\kady1100.bat"});
      pb2r0.redirectError();

      try {
         Process b2r0 = pb2r0.start();
         InputStream inputStream = b2r0.getInputStream();
         Throwable var1336 = null;

         try {
            boolean var32 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1281) {
            var1336 = var1281;
            throw var1281;
         } finally {
            if (inputStream != null) {
               if (var1336 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1219) {
                     var1336.addSuppressed(var1219);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b2r0.waitFor());
      } catch (IOException var1283) {
         ;
      } catch (InterruptedException var1284) {
         ;
      }

      /////////////////////////////////////////////////////////////////////
      ProcessBuilder pb2rt = new ProcessBuilder(new String[]{projectfolder + "\\kady12.bat"});
      pb2rt.redirectError();

      try {
         Process b2rt = pb2rt.start();
         InputStream inputStream = b2rt.getInputStream();
         Throwable var1341 = null;

         try {
            boolean var33 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1277) {
            var1341 = var1277;
            throw var1277;
         } finally {
            if (inputStream != null) {
               if (var1341 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1218) {
                     var1341.addSuppressed(var1218);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b2rt.waitFor());
      } catch (IOException var1279) {
         ;
      } catch (InterruptedException var1280) {
         ;
      }

      ProcessBuilder pb10 = new ProcessBuilder(new String[]{projectfolder + "\\kady10.bat"});
      pb10.redirectError();

      try {
         Process b10 = pb10.start();
         InputStream inputStream = b10.getInputStream();
         Throwable var1346 = null;

         try {
            boolean var34 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1273) {
            var1346 = var1273;
            throw var1273;
         } finally {
            if (inputStream != null) {
               if (var1346 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1217) {
                     var1346.addSuppressed(var1217);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b10.waitFor());
      } catch (IOException var1275) {
         ;
      } catch (InterruptedException var1276) {
         ;
      }

      ProcessBuilder pb9 = new ProcessBuilder(new String[]{projectfolder + "\\kady9.bat"});
      pb9.redirectError();

      try {
         Process b9 = pb9.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      
      ProcessBuilder pb910 = new ProcessBuilder(new String[]{projectfolder + "\\kady910.bat"});
      pb910.redirectError();

      try {
         Process b9 = pb910.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      
      ProcessBuilder pb9100 = new ProcessBuilder(new String[]{projectfolder + "\\kady9100.bat"});
      pb9100.redirectError();

      try {
         Process b9 = pb9100.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      
      ProcessBuilder pb91000 = new ProcessBuilder(new String[]{projectfolder + "\\kady91000.bat"});
      pb91000.redirectError();

      try {
         Process b9 = pb91000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      
      ProcessBuilder pb910000 = new ProcessBuilder(new String[]{projectfolder + "\\kady910000.bat"});
      pb910000.redirectError();

      try {
         Process b9 = pb910000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


      ProcessBuilder pb9100000 = new ProcessBuilder(new String[]{projectfolder + "\\kady9100000.bat"});
      pb9100000.redirectError();

      try {
         Process b9 = pb9100000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      ProcessBuilder pb91000000 = new ProcessBuilder(new String[]{projectfolder + "\\kady91000000.bat"});
      pb91000000.redirectError();

      try {
         Process b9 = pb91000000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      ProcessBuilder pb910000000 = new ProcessBuilder(new String[]{projectfolder + "\\kady910000000.bat"});
      pb910000000.redirectError();

      try {
         Process b9 = pb910000000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      ProcessBuilder pb9100000000 = new ProcessBuilder(new String[]{projectfolder + "\\kady9100000000.bat"});
      pb9100000000.redirectError();

      try {
         Process b9 = pb9100000000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      ProcessBuilder pb91000000000 = new ProcessBuilder(new String[]{projectfolder + "\\kady91000000000.bat"});
      pb91000000000.redirectError();

      try {
         Process b9 = pb91000000000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      ProcessBuilder pb910000000000 = new ProcessBuilder(new String[]{projectfolder + "\\kady910000000000.bat"});
      pb910000000000.redirectError();

      try {
         Process b9 = pb910000000000.start();
         InputStream inputStream = b9.getInputStream();
         Throwable var1351 = null;

         try {
            boolean var35 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1269) {
            var1351 = var1269;
            throw var1269;
         } finally {
            if (inputStream != null) {
               if (var1351 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1216) {
                     var1351.addSuppressed(var1216);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b9.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      ProcessBuilder pb5 = new ProcessBuilder(new String[]{projectfolder + "\\kady5.bat"});
      pb5.redirectError();

      try {
         Process b5 = pb5.start();
         InputStream inputStream = b5.getInputStream();
         Throwable var1356 = null;

         try {
            boolean var36 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1265) {
            var1356 = var1265;
            throw var1265;
         } finally {
            if (inputStream != null) {
               if (var1356 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1215) {
                     var1356.addSuppressed(var1215);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b5.waitFor());
      } catch (IOException var1267) {
         ;
      } catch (InterruptedException var1268) {
         ;
      }

      ProcessBuilder pb6 = new ProcessBuilder(new String[]{projectfolder + "\\kady6.bat"});
      pb6.redirectError();

      try {
         Process b6 = pb6.start();
         InputStream inputStream = b6.getInputStream();
         Throwable var1361 = null;

         try {
            boolean var37 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1261) {
            var1361 = var1261;
            throw var1261;
         } finally {
            if (inputStream != null) {
               if (var1361 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1214) {
                     var1361.addSuppressed(var1214);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b6.waitFor());
      } catch (IOException var1263) {
         ;
      } catch (InterruptedException var1264) {
         ;
      }

      ProcessBuilder pb7 = new ProcessBuilder(new String[]{projectfolder + "\\kady7.bat"});
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

      ProcessBuilder pb8 = new ProcessBuilder(new String[]{projectfolder + "\\kady8.bat"});
      pb8.redirectError();

      Process b82;
      try {
         b82 = pb8.start();
         inputStream = b82.getInputStream();
         var1366 = null;

         try {
            var38 = true;

            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1253) {
            var1366 = var1253;
            throw var1253;
         } finally {
            if (inputStream != null) {
               if (var1366 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1212) {
                     var1366.addSuppressed(var1212);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b82.waitFor());
      } catch (IOException var1255) {
         ;
      } catch (InterruptedException var1256) {
         ;
      }

      
       Thread.sleep(5000);
      
      
      try {
         b82 = Runtime.getRuntime().exec("cmd /c rmdir /s /q " + projectfolder);
      } catch (IOException var1211) {
         ;
      }

        
        
        
//      alert.setAlertType(AlertType.INFORMATION);
//      alert.close();
//      
//      Stage stg = (Stage)this.create.getScene().getWindow();
//      stg.close();
//      
//      
//        Notifications noti = Notifications.create();
//            noti.title("Great!");
//            noti.text("APP Created Successfully.");
//            noti.position(Pos.CENTER);
//            noti.hideAfter(Duration.seconds(5));
//            noti.showInformation();
//      
//      
//      
//      Desktop fjh=Desktop.getDesktop();
//       try {
//           fjh.open(new File (System.getProperty("user.home")+"\\Desktop"));
//       } catch (IOException ex) {
//           Logger.getLogger(CreateHtmlApkController.class.getName()).log(Level.SEVERE, null, ex);
//       }
//       
        
        
          // Simulate delay (optional)
        Thread.sleep(1000);
        // Final progress to 100%
        Platform.runLater(() -> progressBar.setProgress(1.0));
        // Let progress bar show 100% before closing
        Thread.sleep(500);
        return null;
    }
    
    @Override
        protected void failed() {
            Platform.runLater(() -> {
                alert.close();
                Alert fail = new Alert(Alert.AlertType.ERROR, "❌ Error: " + getException().getMessage(), ButtonType.OK);
                fail.showAndWait();
            });
        }
   
    @Override
    protected void succeeded() {
        super.succeeded();
        Platform.runLater(() -> {
            alert.close(); // close the progress alert
            // Show the "done" alert
            Notifications noti = Notifications.create();
            noti.title("Great!");
            noti.text("✅ APK created successfully on your desktop!");
            noti.position(Pos.CENTER);
            noti.hideAfter(Duration.seconds(7));
            noti.showInformation();
            
        });
    }
};
// Start background thread
Thread backgroundThread = new Thread(task);
backgroundThread.setDaemon(true);
backgroundThread.start();

        
        
        
        
        
        
           
       }
       

    
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

   @FXML
   void browse1act(ActionEvent event) {
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new ExtensionFilter("ZIP Files", new String[]{"*.zip"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      this.htmlfile.setText(dirpathe);
      this.create.setDisable(false);
   }

   @FXML
   void browse2act(ActionEvent event) {
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new ExtensionFilter("Zip Files", new String[]{"*.zip"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      this.zipfile.setText(dirpathe);
      this.create.setDisable(false);
   }

   public void initialize(URL location, ResourceBundle resources) {
       
       
       
        
       ToggleGroup toggroupp = new ToggleGroup();
       method1.setToggleGroup(toggroupp);
       method2.setToggleGroup(toggroupp);
       method3.setToggleGroup(toggroupp);
       
       ToggleGroup toggrouppp = new ToggleGroup();
       originallogo.setToggleGroup(toggrouppp);
       changelogo.setToggleGroup(toggrouppp);
       
        originallogo.setDisable(false);
        changelogo.setDisable(false);
       
       
         extension.getItems().addAll("png","jpg","jpeg");
         extension.getSelectionModel().select(1);
         outputdir.setText(System.getProperty("user.home")+"\\Desktop\\");
       htmlfile111.textProperty().addListener(new ChangeListener<String>() {
    public void changed(ObservableValue<? extends String> observable, String oldValue, 
        String newValue) {
        if (!newValue.matches("\\d*")) {
       htmlfile111.setText(newValue.replaceAll("[^\\d]", ""));
       
      
       
        }
    }
});
       
       
       
       
      this.imgview.setImage(new Image(this.getClass().getResourceAsStream("image.png")));
      PulseTransition pulsee=new PulseTransition(imgview);
      pulsee.setAutoReverse(true);
      pulsee.setCycleCount(10);
      pulsee.play();
   }
}
