package eagle;

//////////////////////////////////////////////////
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//////////////////////////////////////////////////
import com.gluonhq.charm.glisten.animation.PulseTransition;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextArea;
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
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class CreateQuiz1ApkController implements Initializable {
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
   private JFXTextField quizname;
   
   @FXML
   private JFXTextField myname;
   

    @FXML
    private JFXTextArea quizdata;
    
    

    @FXML
    private JFXTextField question;
    
     @FXML
    private JFXTextField a1;
     
     @FXML
    private JFXTextField a4;
     
     @FXML
    private JFXTextField wanumber;

    @FXML
    private JFXTextField a2;

    @FXML
    private JFXTextField a3;


    @FXML
    private JFXTextField answer;
    
    

    @FXML
    private JFXButton addq;

    @FXML
    void addqact(ActionEvent event) {

        int i=1;
        String que,a11,a22,a33,a44,ans;
        que=question.getText();
        a11=a1.getText();
        a22=a2.getText();
        a33=a3.getText();
        a44=a4.getText();
        ans=answer.getText();
        
        
         if (quizdata.getText().isEmpty()==true) {
          quizdata.appendText("{\n" +
"        question: \""+que+"\",\n" +
"        a: \""+a11+"\",\n" +
"        b: \""+a22+"\",\n" +
"        c: \""+a33+"\",\n" +
"        d: \""+a44+"\",\n" +
"        correct: \""+ans+"\",\n" +
"    }\n");
      }
      else {
          quizdata.appendText(",{\n" +
"        question: \""+que+"\",\n" +
"        a: \""+a11+"\",\n" +
"        b: \""+a22+"\",\n" +
"        c: \""+a33+"\",\n" +
"        d: \""+a44+"\",\n" +
"        correct: \""+ans+"\",\n" +
"    }\n");
      }
        
         
      question.setText("");
      a1.setText("");
      a2.setText("");
      a3.setText("");
      answer.setText("");
      a4.setText("");
        
    }
   
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
    private static final int ANIMATION_SECONDS = 1;

    private Random random = new Random();

    private Digit[] digits = new Digit[60];
    private int currentIndex = 0;

    private GraphicsContext g;
    private double time = 0;

    private List<Particle> particles = new ArrayList<>();
    private int maxParticles = 0;

    private Parent createContent() {

        Pane root = new Pane();
        root.setPrefSize(800, 600);

        Canvas canvas = new Canvas(800, 600);
        g = canvas.getGraphicsContext2D();
        g.setFill(Color.BLUE);

        root.getChildren().add(canvas);

        populateDigits();
        populateParticles();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };
        timer.start();

        return root;
    }

    private void onUpdate() {
        g.clearRect(0, 0, 800, 600);

        if (time == 0 || time > ANIMATION_SECONDS) {
            currentIndex++;
            if (currentIndex == 60)
                currentIndex = 1;

            particles.parallelStream().forEach(p -> {
                if (p.index < digits[currentIndex].positions.size()) {
                    Point2D point = digits[currentIndex].positions.get(p.index);

                    // offset to center of screen
                    p.nextX = point.getX() + 350;
                    p.nextY = point.getY() + 150;
                } else {
                    if (random.nextBoolean()) {
                        // move horizontally
                        p.nextX = random.nextBoolean() ? 805 : -5;
                        p.nextY = random.nextInt(600);
                    } else {
                        // move vertically
                        p.nextX = random.nextInt(800);
                        p.nextY = random.nextBoolean() ? 605 : -5;
                    }
                }

                p.dx = p.nextX - p.x;
                p.dy = p.nextY - p.y;
                p.dx /= ANIMATION_SECONDS * 60 * random.nextDouble();
                p.dy /= ANIMATION_SECONDS * 60 * random.nextDouble();
            });



            time = 0;
        }

        for (Particle p : particles) {
            p.update();
            p.render(g);
        }

        time += 0.016;
    }

    private void populateDigits() {
        for (int i = 0; i < digits.length; i++) {
            digits[i] = new Digit();

            Text text = new Text(i + "");
            text.setFont(Font.font(144));
            text.setFill(Color.BLACK);

            Image snapshot = text.snapshot(null, null);

            for (int y = 0; y < snapshot.getHeight(); y++) {
                for (int x = 0; x < snapshot.getWidth(); x++) {
                    if (snapshot.getPixelReader().getColor(x, y).equals(Color.BLACK)) {
                        digits[i].positions.add(new Point2D(x, y));
                    }
                }
            }

            if (digits[i].positions.size() > maxParticles) {
                maxParticles = digits[i].positions.size();
            }
        }
    }

    private void populateParticles() {
        for (int i = 0; i < maxParticles; i++) {
            particles.add(new Particle(i));
        }

       
    }

    private static class Digit {
        private List<Point2D> positions = new ArrayList<>();
    }

    private static class Particle {
        private double x, y;
        private double nextX, nextY;
        private double dx, dy;
        private int index;

        public Particle(int index) {
            this.index = index;
        }

        void update() {
            if (Math.abs(nextX - x) > Math.abs(dx)) {
                x += dx;
            } else {
                x = nextX;
            }

            if (Math.abs(nextY - y) > Math.abs(dy)) {
                y += dy;
            } else {
                y = nextY;
            }
        }

        void render(GraphicsContext g) {
            Point2D center = new Point2D(350, 200);
            double alpha = 1 - new Point2D(x, y).distance(center) / 500;

            g.setGlobalAlpha(alpha);
            g.fillOval(x, y, 2, 2);
        }
    }

   
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
   void createact(ActionEvent event) throws IOException, InterruptedException {
      String apknam = this.apkname.getText();
      String apkpkg = this.packagename.getText();
      String apkico = this.pathlabel.getText();
      //String apksource = this.htmlfile.getText();
      String apkresource = System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\quiz.zip";
      /////////////////////////
      String wanum,qudat,quiznam,mynam;
      wanum=wanumber.getText();
      qudat=quizdata.getText();
      quiznam=quizname.getText();
      mynam=myname.getText();
      /////////////////////////
      
      
      
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
         Process var10 = Runtime.getRuntime().exec("cmd /c copy " + System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Cordovak.kady " + projectfolder + "\\Cordovak.apk");
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
         pw.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\apktool.bat d -f " + projectfolder + "\\Cordovak.apk -o " + projectfolder + "\\Cordova");
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
         pwq.println(System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\Build_Apk\\apktool.bat if " + projectfolder + "\\Cordovak.apk");
         pwq.close();
      } catch (IOException var1248) {
         ;
      }

      File htmlbat2 = new File(projectfolder + "\\kady3.bat");

      try {
         htmlbat2.createNewFile();
      } catch (IOException var1247) {
         ;
      }

      try {
         PrintWriter lcv = new PrintWriter(new FileWriter(htmlbat2));
         lcv.println("cd " + projectfolder + "\\Cordova\\assets\\www");
         //lcv.println("copy " + apksource + " " + projectfolder + "\\Cordova\\assets\\www\\index.html");
         lcv.close();
      } catch (IOException var1246) {
         ;
      }

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
//////////////............................................................../////////////////////////
      try {
         PrintWriter lcvv = new PrintWriter(new FileWriter(htmlbat11));
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-hdpi-v4");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-hdpi-v4\\icon.png");
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
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-ldpi-v4");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-ldpi-v4\\icon.png");
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
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-mdpi-v4");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-mdpi-v4\\icon.png");
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
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xxhdpi-v4");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xxhdpi-v4\\icon.png");
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
         lcvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xxxhdpi-v4");
         lcvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xxxhdpi-v4\\icon.png");
         lcvv.close();
      } catch (IOException var1242) {
         ;
      }
//////////////////////////////////////////////////////////////////////////////////////////////////////////
 /*
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
      */
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      File htmlbat111 = new File(projectfolder + "\\kady10.bat");

      try {
         htmlbat111.createNewFile();
      } catch (IOException var1241) {
         ;
      }

      try {
         PrintWriter lcvvv = new PrintWriter(new FileWriter(htmlbat111));
         lcvvv.println("cd " + projectfolder + "\\Cordova\\res\\mipmap-xhdpi-v4");
         lcvvv.println("copy /Y " + apkico + " " + projectfolder + "\\Cordova\\res\\mipmap-xhdpi-v4\\icon.png");
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
"    <string name=\"common_google_play_services_unknown_issue\">%1$s is having trouble with Google Play services. Please try again.</string>\n" +
"    <string name=\"s1\">Save image</string>\n" +
"    <string name=\"s2\">Allow Ad to store image in Picture gallery?</string>\n" +
"    <string name=\"s3\">Accept</string>\n" +
"    <string name=\"s4\">Decline</string>\n" +
"    <string name=\"s5\">Create calendar event</string>\n" +
"    <string name=\"s6\">Allow Ad to create a calendar event?</string>\n" +
"    <string name=\"s7\">Test Ad</string>\n" +
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
         pwwwwn00.println("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?><manifest xmlns:android=\"http://schemas.android.com/apk/res/android\" android:hardwareAccelerated=\"true\" package=\"com.eagle."+apkpkg+"\" platformBuildVersionCode=\"26\" platformBuildVersionName=\"8.0.0\">\n" +
"    <supports-screens android:anyDensity=\"true\" android:largeScreens=\"true\" android:normalScreens=\"true\" android:resizeable=\"true\" android:smallScreens=\"true\" android:xlargeScreens=\"true\"/>\n" +
"    <uses-permission android:name=\"android.permission.INTERNET\"/>\n" +
"    <uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\"/>\n" +
"    <application android:hardwareAccelerated=\"true\" android:icon=\"@mipmap/icon\" android:label=\"@string/app_name\" android:supportsRtl=\"true\">\n" +
"        <activity android:configChanges=\"keyboard|keyboardHidden|locale|orientation|screenSize\" android:label=\"@string/activity_name\" android:launchMode=\"singleTop\" android:name=\"com.juthawong.android.html5videoplayer.MainActivity\" android:screenOrientation=\"portrait\" android:theme=\"@android:style/Theme.DeviceDefault.NoActionBar\" android:windowSoftInputMode=\"adjustResize\">\n" +
"            <intent-filter android:label=\"@string/launcher_name\">\n" +
"                <action android:name=\"android.intent.action.MAIN\"/>\n" +
"                <category android:name=\"android.intent.category.LAUNCHER\"/>\n" +
"            </intent-filter>\n" +
"        </activity>\n" +
"        <activity android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|screenSize|smallestScreenSize|uiMode\" android:exported=\"false\" android:name=\"com.google.android.gms.ads.AdActivity\" android:theme=\"@android:style/Theme.Translucent\"/>\n" +
"        <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\"/>\n" +
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
"- jpeg\n" +
"- mp4\n" +
"- png\n" +
"isFrameworkApk: false\n" +
"packageInfo:\n" +
"  forcedPackageId: '127'\n" +
"  renameManifestPackage: null\n" +
"sdkInfo:\n" +
"  minSdkVersion: '16'\n" +
"  targetSdkVersion: '25'\n" +
"sharedLibrary: false\n" +
"sparseResources: false\n" +
"unknownFiles:\n" +
"  build-data.properties: '8'\n" +
"  protobuf.meta: '8'\n" +
"  error_prone/Annotations.gwt.xml: '8'\n" +
"  jsr305_annotations/Jsr305_annotations.gwt.xml: '8'\n" +
"  third_party/java_src/error_prone/project/annotations/Annotations.gwt.xml: '8'\n" +
"  third_party/java_src/error_prone/project/annotations/Google_internal.gwt.xml: '8'\n" +
"usesFramework:\n" +
"  ids:\n" +
"  - 1\n" +
"  tag: null\n" +
"version: 2.3.4\n" +
"versionInfo:\n" +
"  versionCode: '10601'\n" +
"  versionName: 1.6.1");
         pwwwwnx.close();
      } catch (IOException var1228) {
         ;
      }
      ///////////////////////////////////////.X.M.L./////////////////////////////////////////
      
      File batfile666k = new File(projectfolder + "\\config.xml");

      try {
         batfile666k.createNewFile();
      } catch (IOException var1229) {
         ;
      }

      try {
         PrintWriter pwwwwnx = new PrintWriter(new FileWriter(batfile666k));
         pwwwwnx.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
"<widget id=\"com.eagle."+apkpkg+"\" version=\"1.6.1\" xmlns=\"http://www.w3.org/ns/widgets\" xmlns:cdv=\"http://cordova.apache.org/ns/1.0\">\n" +
"    <feature name=\"Whitelist\">\n" +
"        <param name=\"android-package\" value=\"org.apache.cordova.whitelist.WhitelistPlugin\" />\n" +
"        <param name=\"onload\" value=\"true\" />\n" +
"    </feature>\n" +
"    <feature name=\"AdMob\">\n" +
"        <param name=\"android-package\" value=\"com.rjfun.cordova.admob.AdMobPlugin\" />\n" +
"        <param name=\"onload\" value=\"true\" />\n" +
"    </feature>\n" +
"    <name>"+apknam+"</name>\n" +
"    <description>"+apknam+"\n" +
"</description>\n" +
"    <author email=\"kadysoftltd@gmail.com\" href=\"https://kadysoftltd.github.io/kadysoft/\"> Kadysoft\n" +
"</author>\n" +
"    <content src=\"index.html\" />\n" +
"    <access origin=\"*\" />\n" +
"    <allow-intent href=\"http://*/*\" />\n" +
"    <allow-intent href=\"https://*/*\" />\n" +
"    <allow-intent href=\"tel:*\" />\n" +
"    <allow-intent href=\"sms:*\" />\n" +
"    <allow-intent href=\"mailto:*\" />\n" +
"    <allow-intent href=\"geo:*\" />\n" +
"    <allow-intent href=\"market:*\" />\n" +
"    <preference name=\"loglevel\" value=\"DEBUG\" />\n" +
"    <preference name=\"orientation\" value=\"portrait\" />\n" +
"    <preference name=\"Fullscreen\" value=\"true\" />\n" +
"</widget>");
         pwwwwnx.close();
      } catch (IOException var1228) {
         ;
      }
     
      
      /////////////////////////////////////////////////////////////////////////////////////

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
      
      File batfile655k = new File(projectfolder + "\\kady12k.bat");

      try {
         batfile655k.createNewFile();
      } catch (IOException var1225) {
         ;
      }

      try {
         PrintWriter pwwwwmmm = new PrintWriter(new FileWriter(batfile655k));
         pwwwwmmm.println("copy /Y " + projectfolder + "\\config.xml " + projectfolder + "\\Cordova\\res\\xml\\config.xml");
         pwwwwmmm.close();
      } catch (IOException var1224) {
         ;
      }
      
     
      ///////////////////////////////////////////////////////////////////////////////////////////////

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

      ProcessBuilder pb3 = new ProcessBuilder(new String[]{projectfolder + "\\kady3.bat"});
      pb3.redirectError();

      try {
         Process b3 = pb3.start();
         InputStream inputStream = b3.getInputStream();
         Throwable var1326 = null;

         try {
            boolean var30 = true;

            int in;
            while((in = inputStream.read()) != -1) {
               System.out.print((char)in);
            }
         } catch (Throwable var1289) {
            var1326 = var1289;
            throw var1289;
         } finally {
            if (inputStream != null) {
               if (var1326 != null) {
                  try {
                     inputStream.close();
                  } catch (Throwable var1221) {
                     var1326.addSuppressed(var1221);
                  }
               } else {
                  inputStream.close();
               }
            }

         }

         System.out.println("Exited with " + b3.waitFor());
      } catch (IOException var1291) {
         ;
      } catch (InterruptedException var1292) {
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
  
      
    OutputStream instreamm=new FileOutputStream(projectfolder + "\\Cordova\\assets\\www\\script.js");
    PrintWriter pwz = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
      
      
     
      pwz.write("const quizData = [\n" +
"    \n" +
"	"+qudat+"\n" +
"	\n" +
"	\n" +
"];\n" +
"\n" +
"const quiz = document.getElementById('quiz');\n" +
"const answerEls = document.querySelectorAll('.answer');\n" +
"const questionEl = document.getElementById('question');\n" +
"const a_text = document.getElementById('a_text');\n" +
"const b_text = document.getElementById('b_text');\n" +
"const c_text = document.getElementById('c_text');\n" +
"const d_text = document.getElementById('d_text');\n" +
"const submitBtn = document.getElementById('submit');\n" +
"\n" +
"let currentQuiz = 0;\n" +
"let score = 0;\n" +
"\n" +
"function isArabic(text) {\n" +
"    const arabicRegex = /[\\u0600-\\u06FF]/;\n" +
"    return arabicRegex.test(text);\n" +
"}\n" +
"\n" +
"function loadQuiz() {\n" +
"    deselectAnswers();\n" +
"    const currentQuizData = quizData[currentQuiz];\n" +
"    questionEl.innerText = currentQuizData.question;\n" +
"    a_text.innerText = currentQuizData.a;\n" +
"    b_text.innerText = currentQuizData.b;\n" +
"    c_text.innerText = currentQuizData.c;\n" +
"    d_text.innerText = currentQuizData.d;\n" +
"    quiz.style.direction = isArabic(currentQuizData.question) ? 'rtl' : 'ltr';\n" +
"    quiz.classList.remove('fade-in');\n" +
"    void quiz.offsetWidth;\n" +
"    quiz.classList.add('fade-in');\n" +
"}\n" +
"\n" +
"function deselectAnswers() {\n" +
"    answerEls.forEach(answerEl => answerEl.checked = false);\n" +
"}\n" +
"\n" +
"function getSelected() {\n" +
"    let answer;\n" +
"    answerEls.forEach(answerEl => {\n" +
"        if (answerEl.checked) {\n" +
"            answer = answerEl.id;\n" +
"        }\n" +
"    });\n" +
"    return answer;\n" +
"}\n" +
"\n" +
"loadQuiz();\n" +
"\n" +
"submitBtn.addEventListener('click', () => {\n" +
"    const answer = getSelected();\n" +
"    if (answer) {\n" +
"        if (answer === quizData[currentQuiz].correct) {\n" +
"            score++;\n" +
"        }\n" +
"        currentQuiz++;\n" +
"        if (currentQuiz < quizData.length) {\n" +
"            loadQuiz();\n" +
"        } else {\n" +
"            submitBtn.style.display = 'none';\n" +
"            const isArabicResult = isArabic(quizData[0].question);\n" +
"            quiz.innerHTML = `\n" +
"                <center><h2>${isArabicResult ? \n" +
"                    `لقد أجبت على ${score} من ${quizData.length} أسئلة بشكل صحيح` : \n" +
"                    `You answered ${score}/${quizData.length} questions correctly`}</h2></center>\n" +
"                <br><br>\n" +
"                <center>\n" +
"                    <button class=\"btn-whatsapp\">\n" +
"                        <a href=\"https://wa.me/?text=${score}/${quizData.length}\" style=\"color: white; text-decoration: none;\">\n" +
"                            <b>${isArabicResult ? 'إرسال النتائج عبر واتساب' : 'Send Results via WhatsApp'}</b>\n" +
"                        </a>\n" +
"                    </button>\n" +
"                </center>\n" +
"            `;\n" +
"            quiz.style.direction = isArabicResult ? 'rtl' : 'ltr';\n" +
"            quiz.classList.add('fade-in');\n" +
"        }\n" +
"    }\n" +
"});"
      );
             
      pwz.close(); 
      
      //////////////////////////////////////////////////////////////////////
    
      
      //////////////////////////////////////////////////////////////////////
    
    
      
      
      
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

       ProcessBuilder pb2rtk = new ProcessBuilder(new String[]{projectfolder + "\\kady12k.bat"});
      pb2rtk.redirectError();

      try {
         Process b2rt = pb2rtk.start();
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

/*
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

     */ 
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
//          Notifications noti = Notifications.create();
//            noti.title("Great!");
//            noti.text("APP Created Successfully.");
//            noti.position(Pos.CENTER);
//            noti.hideAfter(Duration.seconds(5));
//            noti.showInformation();
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

   @FXML
   void browse1act(ActionEvent event) {
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new ExtensionFilter("Html Files", new String[]{"*.html"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      this.htmlfile.setText(dirpathe);
      this.browse2.setDisable(false);
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
      this.imgview.setImage(new Image(this.getClass().getResourceAsStream("image.png")));
      PulseTransition pulsee=new PulseTransition(imgview);
      pulsee.setAutoReverse(true);
      pulsee.setCycleCount(10);
      pulsee.play();
   }
}
