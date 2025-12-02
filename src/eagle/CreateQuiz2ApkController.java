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
//timer/quiz name/questions/topic
public class CreateQuiz2ApkController implements Initializable {
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
"        q:\'"+que+"\',\n" +
"        options:"+"[\'"+a11+"\',\'"+a22+"\',\'"+a33+"\',\'"+a44+"\']"+",\n"+
"        answer:"+ans+"\n"+
"    }\n");
      }
      else {
          quizdata.appendText(",{\n" +
"        q:\'"+que+"\',\n" +
"        options:"+"[\'"+a11+"\',\'"+a22+"\',\'"+a33+"\',\'"+a44+"\']"+",\n"+
"        answer:"+ans+"\n"+
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
      String apkresource = System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\quizme.zip";
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
  
      PrintWriter pwz;
      pwz=new PrintWriter (new FileWriter (projectfolder + "\\Cordova\\assets\\www\\js\\app.js")); 
      pwz.write("const questionNumber = document.querySelector(\".question-number\");\n" +
"const parentTitle = document.querySelector(\".parent-title\");\n" +
"const subTitle = document.querySelector(\".sub-title\");\n" +
"const questionText = document.querySelector(\".question-text\");\n" +
"const optionContainer = document.querySelector(\".option-container\");\n" +
"const answersIndicatorContainer = document.querySelector(\".answers-indicator\");\n" +
"const homeBox = document.querySelector(\".home-box\");\n" +
"const quizBox = document.querySelector(\".quiz-box\");\n" +
"const resultBox = document.querySelector(\".result-box\");\n" +
"const model_container = document.getElementById(\"model_container\");\n" +
"const result_container1 = document.getElementById(\"result_container1\");\n" +
"const result_container2 = document.getElementById(\"result_container2\");\n" +
"const result_container3 = document.getElementById(\"result_container3\");\n" +
"const result_container4 = document.getElementById(\"result_container4\");\n" +
"const result_container5 = document.getElementById(\"result_container5\");\n" +
"const close = document.getElementById(\"close\");\n" +
"const thankyou1 = document.getElementById(\"thankyou1\");\n" +
"const thankyou2 = document.getElementById(\"thankyou2\");\n" +
"const thankyou3 = document.getElementById(\"thankyou3\");\n" +
"const thankyou4 = document.getElementById(\"thankyou4\");\n" +
"const thankyou5 = document.getElementById(\"thankyou5\");\n" +
"const timeCount = quizBox.querySelector(\".timer .timer_sec\");\n" +
"const timeLine = quizBox.querySelector(\".time_line\");\n" +
"\n" +
"let questionCounter = 0;\n" +
"let currentQuestion;\n" +
"let availableQuestions = [];\n" +
"let availableOptions = [];\n" +
"let correctAnswers = 0;\n" +
"let attempt = 0;\n" +
"let counter;\n" +
"let currTime = 0;\n" +
"let totalTime = 0; \n" +
"let widthValue = 0;\n" +
"let timeValue = "+wanum+";\n" +
"let date = new Date();\n" +
"let ctr = date.getTime();\n" +
"\n" +
"//push the questions into availableQuestions array\n" +
"function setAvailabeOption()\n" +
"{\n" +
"	const totalQuestions = quiz.length;\n" +
"	for(let i=0;i<totalQuestions;i++)\n" +
"	{\n" +
"		availableQuestions.push(quiz[i])\n" +
"	}\n" +
"}\n" +
"\n" +
"//set question number and question and option\n" +
"function getNewQuestion()\n" +
"{\n" +
"    //set question number\n" +
"    questionNumber.innerHTML = \"Question \"+(questionCounter+1)+\" of \"+quiz.length;\n" +
"    //set question text\n" +
"    //get random questions\n" +
"    const questionIndex = availableQuestions[Math.floor(Math.random() * availableQuestions.length)]\n" +
"    currentQuestion = questionIndex;\n" +
"    questionText.innerHTML = currentQuestion.q;\n" +
"\n" +
"    //get the position of questionIndex from the availableQuestions array    \n" +
"    const index1 = availableQuestions.indexOf(questionIndex);\n" +
"    //remove the questionIndex from the availableQuestion Array, so that the question do not repeat\n" +
"    availableQuestions.splice(index1,1);\n" +
"    //set options\n" +
"    //get the length of options\n" +
"    const optionLen = currentQuestion.options.length\n" +
"    //push options into availableOptions array\n" +
"    for(let i=0;i<optionLen;i++)\n" +
"    {\n" +
"    	availableOptions.push(i)\n" +
"    }\n" +
"\n" +
"    optionContainer.innerHTML = '';\n" +
"    let animationDelay = 0.2;\n" +
"    //create options in html\n" +
"    for(let i=0;i<optionLen;i++)\n" +
"    {\n" +
"    	//random option\n" +
"    	const optionIndex = availableOptions[Math.floor(Math.random() * availableOptions.length)]\n" +
"    	//get the position of optionIndex from availableOptions\n" +
"    	const index2 = availableOptions.indexOf(optionIndex);\n" +
"        //remove the optionIndex from availableOptions, so that it will not be repeated\n" +
"    	availableOptions.splice(index2,1);\n" +
"    	const option = document.createElement(\"div\");\n" +
"    	option.innerHTML = currentQuestion.options[optionIndex];\n" +
"    	option.id = optionIndex;\n" +
"    	option.style.animationDelay = animationDelay + 's';\n" +
"    	animationDelay = animationDelay + 0.2;\n" +
"    	option.className = \"option\";\n" +
"    	optionContainer.appendChild(option)\n" +
"    	option.setAttribute(\"onclick\",\"getResult(this)\");\n" +
"    }\n" +
"    questionCounter++;\n" +
"}\n" +
"\n" +
"//get the result of current attempt questions\n" +
"function getResult(element)\n" +
"{\n" +
"	clearInterval(counter);\n" +
"	clearInterval(counterLine); \n" +
"	const id = parseInt(element.id);\n" +
"	//get answer by comparing the id of clicked option\n" +
"	if(id === currentQuestion.answer)\n" +
"	{\n" +
"		//set the green color to the correct option\n" +
"		element.classList.add(\"correct\");\n" +
"		//add the indicator to correct mark\n" +
"		updateAnswersIndicator(\"correct\");\n" +
"		correctAnswers++;\n" +
"	}\n" +
"	else\n" +
"	{\n" +
"		//set the red color to the wrong option\n" +
"		element.classList.add(\"wrong\");\n" +
"		//add the indicator to wrong mark\n" +
"		updateAnswersIndicator(\"wrong\");\n" +
"\n" +
"		//if the answer is incorrect then show the correct option by addin green color the correct option\n" +
"		const optionLen = optionContainer.children.length;\n" +
"		for(let i=0;i<optionLen;i++)\n" +
"		{\n" +
"			if(parseInt(optionContainer.children[i].id) === currentQuestion.answer){\n" +
"				optionContainer.children[i].classList.add(\"correct\");\n" +
"			}\n" +
"		}\n" +
"	}\n" +
"	attempt++;\n" +
"	unclickableOptions();\n" +
"}\n" +
"\n" +
"//make all the options unclickable once the user select a option(RESTRICT THE USER TO CHANGE THE OPTION)\n" +
"function unclickableOptions()\n" +
"{\n" +
"	const optionLen = optionContainer.children.length;\n" +
"	for(let i=0;i<optionLen;i++)\n" +
"	{\n" +
"		optionContainer.children[i].classList.add(\"already-answered\");\n" +
"	}\n" +
"}\n" +
"\n" +
"function answersIndicator()\n" +
"{\n" +
"	answersIndicatorContainer.innerHTML = '';\n" +
"	const totalQuestions = quiz.length;\n" +
"	for(let i=0;i<totalQuestions;i++)\n" +
"	{\n" +
"		const indicator = document.createElement(\"div\");\n" +
"		answersIndicatorContainer.appendChild(indicator);\n" +
"	}\n" +
"}\n" +
"\n" +
"function updateAnswersIndicator(markType)\n" +
"{\n" +
"	answersIndicatorContainer.children[questionCounter-1].classList.add(markType);\n" +
"}\n" +
"\n" +
"function next()\n" +
"{\n" +
"	if(questionCounter == quiz.length)\n" +
"	{\n" +
"		totalTime += (timeValue - currTime);\n" +
"		showAlertBox();\n" +
"	}\n" +
"	else\n" +
"	{\n" +
"		clearInterval(counter);\n" +
"		startTimer(timeValue);\n" +
"		clearInterval(counterLine);\n" +
"		startTimerLine(0);\n" +
"		getNewQuestion();\n" +
"		totalTime += (timeValue - currTime);\n" +
"	}\n" +
"}\n" +
"\n" +
"function showAlertBox()\n" +
"{\n" +
"	clearInterval(counter);\n" +
"	clearInterval(counterLine);\n" +
"	model_container.classList.add('show');\n" +
"	close.addEventListener('click',()=>{\n" +
"		model_container.classList.remove('show');\n" +
"		quizOver();\n" +
"	})\n" +
"}\n" +
"\n" +
"function showResult1()\n" +
"{\n" +
"	result_container1.classList.add('show');\n" +
"	thankyou1.addEventListener('click',()=>{\n" +
"		result_container1.classList.remove('show');\n" +
"	})\n" +
"}\n" +
"\n" +
"function showResult2()\n" +
"{\n" +
"	result_container2.classList.add('show');\n" +
"	thankyou2.addEventListener('click',()=>{\n" +
"		result_container2.classList.remove('show');\n" +
"	})\n" +
"}\n" +
"\n" +
"function showResult3()\n" +
"{\n" +
"	result_container3.classList.add('show');\n" +
"	thankyou3.addEventListener('click',()=>{\n" +
"		result_container3.classList.remove('show');\n" +
"	})\n" +
"}\n" +
"\n" +
"function showResult4()\n" +
"{\n" +
"	result_container4.classList.add('show');\n" +
"	thankyou4.addEventListener('click',()=>{\n" +
"		result_container4.classList.remove('show');\n" +
"	})\n" +
"}\n" +
"\n" +
"function showResult5()\n" +
"{\n" +
"	result_container5.classList.add('show');\n" +
"	thankyou5.addEventListener('click',()=>{\n" +
"		result_container5.classList.remove('show');\n" +
"	})\n" +
"}\n" +
"\n" +
"function quizOver()\n" +
"{\n" +
"	//hide quiz box\n" +
"	quizBox.classList.add(\"hide\");\n" +
"	//show result box\n" +
"	resultBox.classList.remove(\"hide\");\n" +
"	quizResult();\n" +
"}\n" +
"\n" +
"//get quiz result\n" +
"function quizResult()\n" +
"{\n" +
"	resultBox.querySelector(\".total-questions\").innerHTML = quiz.length;\n" +
"    resultBox.querySelector(\".total-attempt\").innerHTML = attempt;\n" +
"    resultBox.querySelector(\".not-attempt\").innerHTML = quiz.length - attempt;\n" +
"    resultBox.querySelector(\".total-correct\").innerHTML = correctAnswers;\n" +
"    resultBox.querySelector(\".total-wrong\").innerHTML = attempt - correctAnswers;\n" +
"    resultBox.querySelector(\".total-time-taken\").innerHTML = totalTime +\" seconds out of \"+quiz.length*30+\" seconds\";\n" +
"    const percentage = Math.round(((correctAnswers/quiz.length)*100)*100)/100;\n" +
"    if(percentage>=80.00)\n" +
"    {\n" +
"        resultBox.querySelector(\".Percentage\").innerHTML = \"<b style='color:darkgreen;'>\" + percentage.toFixed(1) + \"%\" + \"     (Excellent, Keep it up)\";\n" +
"        showResult1();\n" +
"    }\n" +
"    else if(percentage>=60.00&&percentage<80.00)\n" +
"    {\n" +
"        resultBox.querySelector(\".Percentage\").innerHTML = \"<b style='color:#056108;'>\" + percentage.toFixed(1) + \"%\" + \"     (Very Good, Keep learning)\";\n" +
"        showResult2();\n" +
"    }\n" +
"    else if(percentage>=40.00&&percentage<60.00)\n" +
"    {\n" +
"        resultBox.querySelector(\".Percentage\").innerHTML = \"<b style='color:#7a6007;'>\" + percentage.toFixed(1) + \"%\" + \"     (Good, Keep Practicing)\";\n" +
"        showResult3();\n" +
"    }\n" +
"    else if(percentage>=30.00&&percentage<40.00)\n" +
"    {\n" +
"        resultBox.querySelector(\".Percentage\").innerHTML = \"<b style='color:#7a4507;'>\" + percentage.toFixed(1) + \"%\" + \"     (satisfied, But not enough)\";\n" +
"        showResult4();\n" +
"    }\n" +
"    else if(percentage<30.00)\n" +
"    {\n" +
"        resultBox.querySelector(\".Percentage\").innerHTML = \"<b style='color:darkred;'>\" + percentage.toFixed(1) + \"%\" + \"     (Poor, Need more Practice)</b>\";\n" +
"        showResult5();\n" +
"    }\n" +
"    resultBox.querySelector(\".total-score\").innerHTML = correctAnswers +\" out of \"+quiz.length+\" questions\";\n" +
"\n" +
"    let id = ctr += 1;\n" +
"    var totalTimeTaken = totalTime + \" seconds\";\n" +
"    var totalQuestion = quiz.length, quizSubTitle = subTitle.innerHTML, quizParentTitle = parentTitle.innerHTML;\n" +
"    auth.onAuthStateChanged(user => {\n" +
"        if (user) {        	\n" +
"            fs.collection(user.uid).doc('_' + id).set({         \n" +
"                id: '_' + id,\n" +
"                quizParentTitle,\n" +
"                quizSubTitle,\n" +
"                totalQuestion,\n" +
"                correctAnswers,\n" +
"                percentage,\n" +
"                totalTimeTaken\n" +
"            }).then(() => {\n" +
"            	sendUserDetailsForEmailNotification(quizSubTitle,quizParentTitle,percentage);\n" +
"                console.log('Test result added successfully !!!');\n" +
"            }).catch(err => {\n" +
"                console.log(err.message);\n" +
"            })\n" +
"        }\n" +
"        else {\n" +
"            console.log('user is not signedIn...');\n" +
"        }\n" +
"    })\n" +
"}\n" +
"\n" +
"function resetQuiz()\n" +
"{\n" +
"	questionCounter = 0;\n" +
"    correctAnswers = 0;\n" +
"    attempt = 0;\n" +
"    clearInterval(counter);\n" +
"	clearInterval(counterLine);\n" +
"}\n" +
"\n" +
"function tryAgainQuiz()\n" +
"{\n" +
"	//hide the resultBox\n" +
"	resultBox.classList.add(\"hide\");\n" +
"	//show the quizBox\n" +
"	quizBox.classList.remove(\"hide\");\n" +
"	//reset the elements to 0\n" +
"	resetQuiz();\n" +
"	//restart the quiz\n" +
"	startQuiz();\n" +
"}\n" +
"\n" +
"function goToHome()\n" +
"{\n" +
"	//reset the quiz\n" +
"	resetQuiz();\n" +
"	//hide result box\n" +
"	resultBox.classList.add(\"hide\");\n" +
"	//show home box\n" +
"	homeBox.classList.remove(\"hide\");\n" +
"	window.location.replace(\"selection.html\");\n" +
"}\n" +
"\n" +
"//### Starting Point ###\n" +
"\n" +
"function startQuiz()\n" +
"{\n" +
"	//hide home box\n" +
"	homeBox.classList.add(\"hide\");\n" +
"	//show quiz box\n" +
"	quizBox.classList.remove(\"hide\");\n" +
"    //set all questions in the availableQuestions Array\n" +
"	setAvailabeOption();\n" +
"	//call the getNewQuestion function\n" +
"	getNewQuestion();\n" +
"	//start Timer and TimeLine\n" +
"    startTimer(timeValue);\n" +
"    //start TimerLine\n" +
"    startTimerLine(0);\n" +
"	//to create indicators of answers\n" +
"	answersIndicator();\n" +
"}\n" +
"\n" +
"function startTimer(time)\n" +
"{\n" +
"	counter = setInterval(timer,1000);\n" +
"	function timer()\n" +
"	{\n" +
"		timeCount.textContent = time;\n" +
"		currTime=time;\n" +
"		time--;\n" +
"		if(time < 0)\n" +
"		{\n" +
"			clearInterval(counter);\n" +
"			timeCount.textContent = \"00\";\n" +
"			updateAnswersIndicator(\"notAttempted\");\n" +
"			next();\n" +
"		}\n" +
"	}\n" +
"}\n" +
"\n" +
"function startTimerLine(time)\n" +
"{\n" +
"    counterLine = setInterval(timer, 120);\n" +
"    function timer()\n" +
"    {\n" +
"        time += 1; \n" +
"        timeLine.style.width = time + \"px\";\n" +
"        checkNavigation();\n" +
"        if(time > 640)\n" +
"        { \n" +
"            clearInterval(counterLine); \n" +
"        }\n" +
"    }\n" +
"}\n" +
"\n" +
"function checkNavigation()\n" +
"{\n" +
"	var str=document.visibilityState;\n" +
"	if(str === \"hidden\")\n" +
"	{\n" +
"		console.log(str);\n" +
"		window.location.replace(\"navigationError.html\");\n" +
"	}\n" +
"}\n" +
"\n" +
"window.onload = function()\n" +
"{\n" +
"	homeBox.querySelector(\".total-questions\").innerHTML = quiz.length;\n" +
"}\n" +
"\n" +
"function sendUserDetailsForEmailNotification(quizSubTitle,quizParentTitle,percentage) {\n" +
"	const url = \"https://www.facebook.com/kadysoft\";\n" +
"    auth.onAuthStateChanged(user => {\n" +
"        if (user) {\n" +
"            fs.collection('users').doc(user.uid).get().then((snapshot) => {\n" +
"                const name = snapshot.data().Name;                      \n" +
"                const email = snapshot.data().Email;             \n" +
"                sendEmail(name,email,url,quizSubTitle,quizParentTitle,percentage);\n" +
"            })\n" +
"        }\n" +
"    })\n" +
"}\n" +
"\n" +
"function sendEmail(name,email,url,quizSubTitle,quizParentTitle,percentage) \n" +
"{ \n" +
"    Email.send({ \n" +
"        Host: \"smtp.gmail.com\", \n" +
"        Username: \"kadysoftltd@gmail.com\", \n" +
"        Password: \"xojeabbhcvthitth\", \n" +
"        To: email,\n" +
"        From: 'kadysoftltd@gmail.com', \n" +
"        Subject: \"Greetings From Kadysoft - Test Completion\", \n" +
"        Body: \"<html><h1><b><b style='color:maroon'>Hello \"+name+\", </b></h1><h3>You have successfully completed the quiz in Quiz Corner. Following are your attempt Details : <br><br><b style='font-size:25px;'>Quiz Title : <b style='color:maroon;'>\"+quizSubTitle+\"</b></b><br><b style='font-size:25px;'>Module Title : <b style='color:maroon;'>\"+quizParentTitle+\"</b></b><br><b style='font-size:25px;'>Percentage : <b style='color:maroon;'>\"+percentage+\" %</b></b><br><br> For Detailed Test Summary, Login to the portal using \"+url+\" and check your summary under Test Summary Tab...</h3><h2><font color='navy'>Thanks & regards,</font><br><font color='red'>- Ahmed Elkady (QUIZ CORNER)</font><br></h2><h3>for more queries,<p>reach me at:\\kadysoftltd@gmail.com</p></h3></b></html>\", \n" +
"    }) \n" +
"    .then(function(message) \n" +
"    { \n" +
"    	console.log(message);\n" +
"        console.log(name+\" \"+email+\" \"+quizSubTitle+\" \"+quizParentTitle+\" \"+percentage);\n" +
"    }); \n" +
"} ");
             
      pwz.close(); 
      
      //////////////////////////////////////////////////////////////////////
    
       //////////////////////////////////////////////////////////////////////
  
    OutputStream instreamm=new FileOutputStream(projectfolder + "\\Cordova\\assets\\www\\js\\corejava.js");
    PrintWriter pwzi = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    pwzi.write("const quiz=[\n" +
"\n" +
""+qudat+"\n" +
"]");
             
      pwzi.close(); 
      
      //////////////////////////////////////////////////////////////////////
      
       //////////////////////////////////////////////////////////////////////
  
       
       
      PrintWriter pwzo;
      pwzo=new PrintWriter (new FileWriter (projectfolder + "\\Cordova\\assets\\www\\index.html")); 
      pwzo.write("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"  <head>\n" +
"    <meta charset=\"UTF-8\" />\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
"    <title>Powered By Eagle</title>\n" +
"    <link rel=\"shortout icon\" type=\"image/x-icon\" href=\"img/kadysoft.png\">\n" +
"    <link rel=\"stylesheet\" href=\"css/java.css\" />\n" +
"    <script src=\"https://kit.fontawesome.com/64d58efce2.js\" crossorigin=\"anonymous\"></script>\n" +
"  </head>\n" +
"  <body>\n" +
"    <div class=\"container\">\n" +
"      <div class=\"form\">\n" +
"        <div class=\"contact-info\">\n" +
"          <h3 class=\"title\"><b><center><font color=\"#1b8079\">"+quiznam+"</font></center></b></h3>\n" +
"        </div>\n" +
"\n" +
"        <div class=\"contact-form\">\n" +
"          <form>\n" +
"            <center><a href=\"javacore.html\" class=\"buttonfx c-btn\">Take The Risk</a></center>\n" +
"            \n" +
"          </form>\n" +
"        </div>\n" +
"      </div>\n" +
"    </div>\n" +
"  </body>\n" +
"</html>\n" +
"" +
"");
             
      pwzo.close(); 
      
      //////////////////////////////////////////////////////////////////////
      
       //////////////////////////////////////////////////////////////////////
  
      PrintWriter pwzp;
      pwzp=new PrintWriter (new FileWriter (projectfolder + "\\Cordova\\assets\\www\\javacore.html")); 
      pwzp.write("<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"	<meta charset=\"UTF-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"	<title>Powered By Eagle</title>\n" +
"	<link rel=\"icon\" href=\"img/quiz.png\" type=\"image/x-icon\">\n" +
"	<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n" +
"	<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
"	<script src=\"https://smtpjs.com/v3/smtp.js\"></script>\n" +
"</head>\n" +
"<body>\n" +
"	<div class=\"home-box custom-box\">\n" +
"		<h3>INSTRUCTIONS</h3><br>\n" +
"		<p>This Quiz will test your Knowledge in <b class=\"sub-title\" style=\"color:#660000\">"+quiznam+"</b>.</p>\n" +
"		<p><b style=\"color:navy\">Parent Topic :    </b><b class=\"parent-title\"style=\"color:maroon\">"+mynam+"</b></p>\n" +
"		<p><b style=\"color:green\">Total Number of Questions :    </b><b><span style=\"font-weight:bold\" class=\"total-questions\"></span> questions</b></p>\n" +
"		<p><h4><b><u>Points to be Noted:</u></b></h4></p>\n" +
"		<p>1) Each Question will have <b>seconds</b> of time to answer<p>\n" +
"		<p>2) If not answered within the time, it will be marked as <b>un-answered</b><p>\n" +
"		<p>3) Please avoid <b>Navigation</b> from the page<p>\n" +
"		<p>4) Correct Answers will also be shown when you mark a Wrong Answer<p>\n" +
"		<p>5) Evaluation <b>score Percentange </b>and <b>Performance Rating</b> will be displayed at the end of the Quiz<p>\n" +

"		<center><button type=\"button\" class=\"btn\" onclick=\"startQuiz()\">Start Quiz</button></center>\n" +
"	</div>\n" +
"	<div class=\"quiz-box custom-box hide\">\n" +
"		<div class=\"timer\">\n" +
"                <div class=\"time_left_txt\"><b>Time Left</b></div>\n" +
"                <div class=\"timer_sec\">00</div>\n" +
"        </div>\n" +
"        <div class=\"question-number\">\n" +
"		</div>\n" +
"		<div class=\"time_line\"></div>\n" +
"		<div class=\"question-text\">\n" +
"\n" +
"		</div>\n" +
"		<div class=\"option-container\">\n" +
"			\n" +
"		</div>\n" +
"		<div class=\"next-question-btn\">\n" +
"		<center>	<button type=\"button\" class=\"btn\" onclick=\"next()\">Next</button></center>\n" +
"		</div>\n" +
"		<div class=\"answers-indicator\">\n" +
"			\n" +
"		</div>\n" +
"	</div>\n" +
"	<div class=\"result-box custom-box hide\">\n" +
"		<h1>Quiz Result</h1>\n" +
"		<table>\n" +
"			<tr>\n" +
"				<td><b>Total Questions</b></td>\n" +
"				<td><span class=\"total-questions\"></span></td>\n" +
"			</tr>\n" +
"			<tr>\n" +
"				<td><b>Attempted Questions</b></td>\n" +
"				<td><span class=\"total-attempt\"></span></td>\n" +
"			</tr>\n" +
"			<tr>\n" +
"				<td><b>Not Attempted</b></td>\n" +
"				<td><span class=\"not-attempt\"></span></td>\n" +
"			</tr>\n" +
"			<tr>\n" +
"				<td><b>Correct Answers</b></td>\n" +
"				<td><span class=\"total-correct\"></span></td>\n" +
"			</tr>\n" +
"			<tr>\n" +
"				<td><b>Wrong Answers</b></td>\n" +
"				<td><span class=\"total-wrong\"></span></td>\n" +
"			</tr>\n" +
"			<tr>\n" +
"				<td><b>Time Taken</b></td>\n" +
"				<td><span class=\"total-time-taken\"></span></td>\n" +
"			</tr>\n" +
"			<tr>\n" +
"				<td><b>Percentage</b></td>\n" +
"				<td><span class=\"Percentage\"></span></td>\n" +
"			</tr>\n" +
"			<tr>\n" +
"				<td><b>Total Score</b></td>\n" +
"				<td><span class=\"total-score\"></span></td>\n" +
"			</tr>\n" +
"		</table>\n" +
"		\n" +
"	</div>\n" +
"	<div class=\"model-container\" id=\"model_container\">\n" +
"		<div class=\"model\">\n" +
"		    <h1>Quiz Over</h1><br>\n" +
"		    <img src=\"img/completed.gif\" width=\"200\" height=\"200\"><br><br>\n" +
"		    <center><button class=\"btn\" id=\"close\">Result</button></center>\n" +
"	    </div>\n" +
"	</div>\n" +
"	<div class=\"result-container1\" id=\"result_container1\">\n" +
"		<div class=\"result1\">\n" +
"		    <h1>Excellent! Keep it up </h1><br>\n" +
"		    <img src=\"img/Kadysoft.png\" width=\"300\" height=\"300\"><br><br>\n" +
"		    <center><button class=\"btn\" id=\"thankyou1\">Thank You Kadysoft</button></center>\n" +
"	    </div>\n" +
"	</div>\n" +
"	<div class=\"result-container2\" id=\"result_container2\">\n" +
"		<div class=\"result2\">\n" +
"		    <h1>Very Good! Keep Learning </h1><br>\n" +
"		    <img src=\"img/Kadysoft.png\" width=\"300\" height=\"300\"><br><br>\n" +
"		    <center><button class=\"btn\" id=\"thankyou2\">Thank You Kadysoft</button></center>\n" +
"	    </div>\n" +
"	</div>\n" +
"	<div class=\"result-container3\" id=\"result_container3\">\n" +
"		<div class=\"result3\">\n" +
"		    <h1>Good! Keep Practicing </h1><br>\n" +
"		    <img src=\"img/Kadysoft.png\" width=\"300\" height=\"300\"><br><br>\n" +
"		    <center><button class=\"btn\" id=\"thankyou3\">Thank You Kadysoft</button></center>\n" +
"	    </div>\n" +
"	</div>\n" +
"	<div class=\"result-container4\" id=\"result_container4\">\n" +
"		<div class=\"result4\">\n" +
"		    <h1>Satisfied, but not Enough </h1><br>\n" +
"		    <img src=\"img/Kadysoft.png\" width=\"300\" height=\"300\"><br><br>\n" +
"		    <center><button class=\"btn\" id=\"thankyou4\">Thank You Kadysoft</button></center>\n" +
"	    </div>\n" +
"	</div>\n" +
"	<div class=\"result-container5\" id=\"result_container5\">\n" +
"		<div class=\"result5\">\n" +
"		    <h1>Poor, need more Practice</h1><br><br><br>\n" +
"		    <img src=\"img/Kadysoft.png\" width=\"250\" height=\"250\"><br><br><br>\n" +
"		    <center><button class=\"btn\" id=\"thankyou5\">Thank You Kadysoft</button></center>\n" +
"	    </div>\n" +
"	</div>\n" +
"\n" +
"<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"\n" +
"        integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\">\n" +
"    </script>\n" +
"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"\n" +
"        integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\">\n" +
"    </script>\n" +
"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"\n" +
"        integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\">\n" +
"    </script>\n" +
"<script src=\"https://www.gstatic.com/firebasejs/8.2.0/firebase-app.js\"></script>\n" +
"      <script src=\"https://www.gstatic.com/firebasejs/7.17.1/firebase-auth.js\"></script>\n" +
"<script src=\"https://www.gstatic.com/firebasejs/7.17.1/firebase-firestore.js\"></script>\n" +
"\n" +
"<script>\n" +
"  var firebaseConfig = \n" +
"  {\n" +
"  };\n" +
"  firebase.initializeApp(firebaseConfig);\n" +
"  const auth = firebase.auth();\n" +
"  const fs = firebase.firestore();\n" +
"  const db = firebase.firestore();\n" +
"</script>\n" +
"<script src=\"js/corejava.js\"></script>\n" +
"<script src=\"js/app.js\"></script>\n" +
"</body>\n" +
"</html>");
             
      pwzp.close(); 
      
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
