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
public class CreateQuiz2ApkController_1 implements Initializable {
   @FXML
   private ResourceBundle resources;
   @FXML
   private URL location;

   
   @FXML
    private JFXTextField apkname;

    @FXML
    private Label pathlabel;

    @FXML
    private ImageView imgview;

    @FXML
    private JFXTextField packagename;

    @FXML
    private JFXButton create;

    @FXML
    private JFXButton browse1;

    @FXML
    private JFXTextField htmlfile;

    @FXML
    private JFXTextField zipfile;

    @FXML
    private JFXButton browse2;

    @FXML
    private JFXTextArea quizdata;

    @FXML
    private JFXTextField question;

    @FXML
    private JFXTextField a1;

    @FXML
    private JFXTextField a2;

    @FXML
    private JFXTextField a3;

    @FXML
    private JFXTextField answer;

    @FXML
    private JFXButton addq;

    @FXML
    private JFXTextField wanumber;

    @FXML
    private JFXTextField a4;

    @FXML
    private JFXTextField myname;

    @FXML
    private JFXTextField quizname;

    @FXML
    private JFXTextField wanumber1;

    @FXML
    private JFXTextField wanumber11;

    @FXML
    private ImageView imgview1;

    @FXML
    private Label pathlabel1;

    

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
"                        \"question\": \""+que+"\",\n" +
"                        \"options\": [\n" +
"                            \""+a11+"\",\n" +
"                            \""+a22+"\",\n" +
"                            \""+a33+"\",\n" +
"                            \""+a44+"\"\n" +
"                        ],\n" +
"                        \"answer\": \""+ans+"\"\n" +
"                    },\n");
          
      }
      else {
             
          quizdata.appendText("{\n" +
"                        \"question\": \""+que+"\",\n" +
"                        \"options\": [\n" +
"                            \""+a11+"\",\n" +
"                            \""+a22+"\",\n" +
"                            \""+a33+"\",\n" +
"                            \""+a44+"\"\n" +
"                        ],\n" +
"                        \"answer\": \""+ans+"\"\n" +
"                    },\n");
          
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
   void imgview1act(MouseEvent event) {
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new ExtensionFilter("Image Files", new String[]{"*.png"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      this.imgview1.setImage(new Image((new File(dirpathe)).toURI().toString()));
      this.pathlabel1.setText(dirpathe);
      this.browse1.setDisable(false);
   }
   

   @FXML
   void createact(ActionEvent event) throws IOException, InterruptedException {
      String apknam = this.apkname.getText();
      String apkpkg = this.packagename.getText();
      String apkico = this.pathlabel.getText();
      
      String docico = this.pathlabel1.getText();
      //String apksource = this.htmlfile.getText();
      String apkresource = System.getProperty("user.home") + "\\AppData\\Roaming\\resources\\data\\quizmee.zip";
      /////////////////////////
      String wanum,qudat,quiznam,mynam,numberwa,numberq;
      wanum=wanumber.getText();
      qudat=quizdata.getText();
      quiznam=quizname.getText();
      mynam=myname.getText();
      
      numberwa=wanumber1.getText();
      numberq=wanumber11.getText();
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
      
      
      
      File icobat11 = new File(projectfolder + "\\ico11.bat");

      try {
         htmlbat11.createNewFile();
      } catch (IOException var1243) {
         ;
      }
      
      try {
         PrintWriter lcvvt = new PrintWriter(new FileWriter(icobat11));
         lcvvt.println("cd " + projectfolder + "\\Cordova\\assets\\www\\assets\\images");
         lcvvt.println("copy /Y " + docico + " " + projectfolder + "\\Cordova\\assets\\www\\assets\\images\\subject_icon.png");
         lcvvt.close();
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
      
       ProcessBuilder pb9p = new ProcessBuilder(new String[]{projectfolder + "\\ico11.bat"});
      pb9p.redirectError();

      try {
         Process b9p = pb9p.start();
         InputStream inputStream = b9p.getInputStream();
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

         System.out.println("Exited with " + b9p.waitFor());
      } catch (IOException var1271) {
         ;
      } catch (InterruptedException var1272) {
         ;
      }

      
      
      
      
      
      
      
  
      PrintWriter pwz;
      pwz=new PrintWriter (new FileWriter (projectfolder + "\\Cordova\\assets\\www\\index.html")); 
      
      pwz.write("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <title></title>\n" +
"    <link rel=\"stylesheet\" href=\"style.css\">\n" +
"    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +
"    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +
"    <link href=\"https://fonts.googleapis.com/css2?family=Rubik:wght@300;400;500&display=swap\" rel=\"stylesheet\">\n" +
"</head>\n" +
"<body>\n" +
"    <article>\n" +
"	\n" +
"        <section class=\"row-top\">\n" +
"            <div class=\"curr-subject\">\n" +
"                <div class=\"button-icon-container\">\n" +
"                    <img src=\"\" alt=\"Subject Icon\">\n" +
"                </div>\n" +
"                <h2></h2>\n" +
"            </div>\n" +
"            <div class=\"light-dark-toggle\">\n" +
"                <div class=\"sun-container\">\n" +
"                    <img src=\"./assets/images/icon-sun-dark.svg\" alt=\"Sun Icon\">\n" +
"                </div>\n" +
"                <label class=\"light-dark-switch\">\n" +
"                    <input type=\"checkbox\">\n" +
"                    <span class=\"slider round\"></span>\n" +
"                </label>\n" +
"                <div class=\"moon-container\">\n" +
"                    <img src=\"./assets/images/icon-moon-dark.svg\" alt=\"Moon Icon\">\n" +
"                </div>\n" +
"            </div>\n" +
"        </section>\n" +
"\n" +
"\n" +
"\n" +
"        <section class=\"start-menu visible\">\n" +
"            <div class=\"left-content\">\n" +
"                <h1>Welcome to the <span>"+quiznam+" Quiz!</span></h1>\n" +
"            \n" +
"            </div>\n" +
"			\n" +
"			\n" +
"            <div class=\"choices\">\n" +
"                <button class=\"quiz-type\" id=\""+quiznam+"\">\n" +
"                    <div class=\"button-icon-container\">\n" +
"                        <img src=\"./assets/images/subject_icon.png\" width=\"50\" height=\"50\" alt=\""+quiznam+" Icon\">\n" +
"                    </div>\n" +
"                    Start "+quiznam+" Quiz \n" +
"                </button>\n" +
"  \n" +
"            </div>\n" +
"			\n" +
"			\n" +
"            <div class=\"completion-message\" style=\"display: none; text-align: center; color: var(--text-color); margin-top: 2rem;\">\n" +
"                <p>You have already completed the quiz. Results have been saved.</p>\n" +
"                <button id=\"request-restart\" style=\"width: 100%; max-width: 20rem; background-color: var(--purple); color: white; padding: 0.75rem; border-radius: 0.75rem; margin-top: 1rem;\">Restart Quiz</button>\n" +
"                <div class=\"restart-prompt\" style=\"display: none; margin-top: 1rem;\">\n" +
"                    <input type=\"password\" id=\"restart-password\" style=\"width: 100%; max-width: 20rem; padding: 0.5rem; margin-bottom: 0.5rem; border-radius: 0.5rem; border: 1px solid var(--option-color);\" placeholder=\"Enter teacher password\">\n" +
"                    <button id=\"submit-restart\" style=\"width: 100%; max-width: 20rem; background-color: var(--purple); color: white; padding: 0.75rem; border-radius: 0.75rem;\">Submit</button>\n" +
"                    <p class=\"restart-error\" style=\"display: none; color: var(--invalid-color); margin: 0.5rem 0 0; font-style: normal;\">Incorrect password. Please try again.</p>\n" +
"                </div>\n" +
"            </div>\n" +
"        </section>\n" +
"\n" +
"        <section class=\"question-screen\">\n" +
"            <div class=\"left-content\">\n" +
"                <div class=\"flex justify-between\">\n" +
"                    <p class=\"question-count\">Question <span class=\"question-number\">1</span> of <span class=\"question-total\">"+numberq+"</span></p>\n" +
"                    <p class=\"timer\" style=\"color: var(--invalid-color); font-weight: 500;\">Time Left: <span id=\"time-left\">"+wanum+"</span>s</p>\n" +
"                </div>\n" +
"                <h1 class=\"question\"></h1>\n" +
"                <div class=\"progress-bar whole\">\n" +
"                    <div class=\"progress-bar done\"></div>\n" +
"                </div>\n" +
"            </div>\n" +
"            <div class=\"choices\">\n" +
"                <button class=\"option\" data-option=\"A\">\n" +
"                    <div class=\"option-box\">A</div>\n" +
"                    <span class=\"option-text\"></span>\n" +
"                </button>\n" +
"                <button class=\"option\" data-option=\"B\">\n" +
"                    <div class=\"option-box\">B</div>\n" +
"                    <span class=\"option-text\"></span>\n" +
"                </button>\n" +
"                <button class=\"option\" data-option=\"C\">\n" +
"                    <div class=\"option-box\">C</div>\n" +
"                    <span class=\"option-text\"></span>\n" +
"                </button>\n" +
"                <button class=\"option\" data-option=\"D\">\n" +
"                    <div class=\"option-box\">D</div>\n" +
"                    <span class=\"option-text\"></span>\n" +
"                </button>\n" +
"                <button class=\"submit-answer\">Submit Answer</button>\n" +
"                <div class=\"select-prompt\">\n" +
"                    <img src=\"./assets/images/icon-incorrect.svg\" alt=\"Error Icon\">\n" +
"                    <p>Please select an answer</p>\n" +
"                </div>\n" +
"                <div class=\"error-message\" style=\"display: none; color: var(--invalid-color); margin-top: 1rem;\">\n" +
"                    Failed to load quiz data. Please try again.\n" +
"                </div>\n" +
"            </div>\n" +
"        </section>\n" +
"\n" +
"        <section class=\"quiz-complete\">\n" +
"            <div class=\"left-content\">\n" +
"                <h1>Quiz completed <span>You scored...</span></h1>\n" +
"            </div>\n" +
"            <div class=\"choices\">\n" +
"                <div class=\"score-container\">\n" +
"                    <div class=\"curr-subject\">\n" +
"                        <div class=\"button-icon-container\">\n" +
"                            <img src=\"\" alt=\"Subject Icon\">\n" +
"                        </div>\n" +
"                        <h2></h2>\n" +
"                    </div>\n" +
"                    <p class=\"final-score\">0</p>\n" +
"                    <p class=\"score-out-of\">out of <span class=\"complete-question-total\">"+numberq+"</span></p>\n" +
"                    <div class=\"whatsapp-share\" style=\"margin-top: 1rem;\">\n" +
"                        <label for=\"teacher-whatsapp\" style=\"color: var(--text-color);\">WhatsApp Number</label>\n" +
"                        <input value=\""+numberwa+"\" type=\"text\" id=\"teacher-whatsapp\" style=\"width: 100%; padding: 0.5rem; margin: 0.5rem 0; border-radius: 0.5rem; border: 1px solid var(--option-color);\" placeholder=\"+201555266002\">\n" +
"                        <button id=\"send-whatsapp\" style=\"width: 100%; background-color: #25D366; color: white; padding: 0.75rem; border-radius: 0.75rem;\">Send Results via WhatsApp</button>\n" +
"                    </div>\n" +
"                </div>\n" +
"                <button class=\"restart\">Restart</button>\n" +
"            </div>\n" +
"        </section>\n" +
"    </article>\n" +
"    <script src=\"app.js\"></script>\n" +
"</body>\n" +
"</html>");
             
      pwz.close(); 
      
      //////////////////////////////////////////////////////////////////////
    
       //////////////////////////////////////////////////////////////////////
  
      PrintWriter pwzi;
      pwzi=new PrintWriter (new FileWriter (projectfolder + "\\Cordova\\assets\\www\\app.js")); 
      pwzi.write("document.addEventListener(\"DOMContentLoaded\", () => {\n" +
"    // Embedded quiz data\n" +
"    const quizData = {\n" +
"        \"quizzes\": [\n" +
"            {\n" +
"                \"title\": \""+quiznam+"\",\n" +
"                \"icon\": \"./assets/images/subject_icon.png\",\n" +
"                \"questions\": [\n" +
"				\n" +
"				\n" +
"				\n" +
"				\n" +
"               "+qudat+"\n" +
"					\n" +
"				\n" +
"				\n" +
"				\n" +
"                    \n" +
"                ]\n" +
"            }	\n" +
"        ]\n" +
"    };\n" +
"\n" +
"\n" +
"\n" +
"    // State variables\n" +
"    let quizType, quizChosen, qCount = -1, totalQuestions, score = 0, increment, timerInterval;\n" +
"    const TEACHER_PASSWORD = \""+mynam+"\"; // Change this to your desired password\n" +
"\n" +
"\n" +
"    // Check if quiz is completed\n" +
"    const startMenu = document.querySelector(\".start-menu\");\n" +
"    const completionMessage = document.querySelector(\".completion-message\");\n" +
"    const requestRestartButton = document.querySelector(\"#request-restart\");\n" +
"    const restartPrompt = document.querySelector(\".restart-prompt\");\n" +
"    const submitRestartButton = document.querySelector(\"#submit-restart\");\n" +
"    const restartPasswordInput = document.querySelector(\"#restart-password\");\n" +
"    const restartError = document.querySelector(\".restart-error\");\n" +
"\n" +
"    function toggleCompletionState(isCompleted) {\n" +
"        if (isCompleted) {\n" +
"            startMenu.querySelector(\".left-content\").style.display = \"none\";\n" +
"            startMenu.querySelector(\".choices\").style.display = \"none\";\n" +
"            completionMessage.style.display = \"block\";\n" +
"            startMenu.classList.add(\"visible\");\n" +
"        } else {\n" +
"            startMenu.querySelector(\".left-content\").style.display = \"flex\";\n" +
"            startMenu.querySelector(\".choices\").style.display = \"flex\";\n" +
"            completionMessage.style.display = \"none\";\n" +
"            startMenu.classList.add(\"visible\");\n" +
"        }\n" +
"    }\n" +
"\n" +
"    if (localStorage.getItem(\"quizCompleted\") === \"true\") {\n" +
"        toggleCompletionState(true);\n" +
"    } else {\n" +
"        toggleCompletionState(false);\n" +
"    }\n" +
"\n" +
"    // Handle restart request\n" +
"    requestRestartButton.addEventListener(\"click\", () => {\n" +
"        restartPrompt.style.display = \"block\";\n" +
"        restartPasswordInput.value = \"\";\n" +
"        restartError.style.display = \"none\";\n" +
"    });\n" +
"\n" +
"    // Handle restart submission\n" +
"    submitRestartButton.addEventListener(\"click\", () => {\n" +
"        const enteredPassword = restartPasswordInput.value.trim();\n" +
"        if (enteredPassword === TEACHER_PASSWORD) {\n" +
"            localStorage.removeItem(\"quizCompleted\");\n" +
"            toggleCompletionState(false);\n" +
"            restartPrompt.style.display = \"none\";\n" +
"            restartError.style.display = \"none\";\n" +
"        } else {\n" +
"            restartError.style.display = \"block\";\n" +
"        }\n" +
"    });\n" +
"\n" +
"    // Light/Dark mode toggle\n" +
"    const toggleSwitch = document.querySelector('.light-dark-switch input[type=\"checkbox\"]');\n" +
"    toggleSwitch.addEventListener('change', (event) => {\n" +
"        document.documentElement.setAttribute('data-theme', event.target.checked ? 'dark' : 'light');\n" +
"    });\n" +
"\n" +
"    // Quiz selection\n" +
"    document.querySelectorAll(\".quiz-type\").forEach(button => {\n" +
"        button.addEventListener(\"click\", () => {\n" +
"            if (localStorage.getItem(\"quizCompleted\") === \"true\") {\n" +
"                toggleCompletionState(true);\n" +
"                return;\n" +
"            }\n" +
"            quizType = button.id;\n" +
"            questionScreen(quizType);\n" +
"        });\n" +
"    });\n" +
"\n" +
"    // Option selection\n" +
"    document.querySelectorAll(\".option\").forEach(button => {\n" +
"        button.addEventListener(\"click\", () => {\n" +
"            document.querySelectorAll(\".option\").forEach(opt => {\n" +
"                opt.classList.remove(\"selected\");\n" +
"                opt.querySelector(\".option-box\").classList.remove(\"selected-box\");\n" +
"            });\n" +
"            button.classList.add(\"selected\");\n" +
"            button.querySelector(\".option-box\").classList.add(\"selected-box\");\n" +
"        });\n" +
"    });\n" +
"\n" +
"    // Submit answer\n" +
"    const submitButton = document.querySelector(\".submit-answer\");\n" +
"    submitButton.addEventListener(\"click\", () => {\n" +
"        if (!quizChosen) {\n" +
"            showError(\"Quiz data not loaded. Please try again.\");\n" +
"            return;\n" +
"        }\n" +
"        if (submitButton.textContent === \"Next Question\") {\n" +
"            clearInterval(timerInterval);\n" +
"            makeQuestions();\n" +
"            return;\n" +
"        }\n" +
"        if (submitButton.textContent === \"See Results\") {\n" +
"            clearInterval(timerInterval);\n" +
"            showQuizComplete();\n" +
"            return;\n" +
"        }\n" +
"\n" +
"        const selectedBox = document.querySelector(\".selected\");\n" +
"        if (!selectedBox) {\n" +
"            document.querySelector(\".select-prompt\").style.visibility = \"visible\";\n" +
"            return;\n" +
"        }\n" +
"\n" +
"        clearInterval(timerInterval);\n" +
"        const answerText = selectedBox.querySelector(\".option-text\").textContent;\n" +
"        selectedBox.classList.remove(\"selected\");\n" +
"        selectedBox.querySelector(\".option-box\").classList.remove(\"selected-box\");\n" +
"\n" +
"        if (validate(answerText)) {\n" +
"            score++;\n" +
"            selectedBox.classList.add(\"correct\");\n" +
"            selectedBox.querySelector(\".option-box\").classList.add(\"correct-box\");\n" +
"            selectedBox.innerHTML += `<img class=\"correct-icon\" src=\"./assets/images/icon-correct.svg\" alt=\"Correct\">`;\n" +
"        } else {\n" +
"            selectedBox.classList.add(\"invalid\");\n" +
"            selectedBox.querySelector(\".option-box\").classList.add(\"invalid-box\");\n" +
"            selectedBox.innerHTML += `<img class=\"invalid-icon\" src=\"./assets/images/icon-incorrect.svg\" alt=\"Incorrect\">`;\n" +
"        }\n" +
"\n" +
"        revealAnswers();\n" +
"        document.querySelector(\".select-prompt\").style.visibility = \"hidden\";\n" +
"        submitButton.textContent = qCount >= totalQuestions - 1 ? \"See Results\" : \"Next Question\";\n" +
"    });\n" +
"\n" +
"    // Timer function\n" +
"    function startTimer() {\n" +
"        let timeLeft = "+wanum+";\n" +
"        const timeDisplay = document.querySelector(\"#time-left\");\n" +
"        timeDisplay.textContent = timeLeft;\n" +
"        timerInterval = setInterval(() => {\n" +
"            timeLeft--;\n" +
"            timeDisplay.textContent = timeLeft;\n" +
"            if (timeLeft <= 0) {\n" +
"                clearInterval(timerInterval);\n" +
"                const selectedBox = document.querySelector(\".selected\");\n" +
"                if (selectedBox) {\n" +
"                    const answerText = selectedBox.querySelector(\".option-text\").textContent;\n" +
"                    selectedBox.classList.remove(\"selected\");\n" +
"                    selectedBox.querySelector(\".option-box\").classList.remove(\"selected-box\");\n" +
"                    if (validate(answerText)) {\n" +
"                        score++;\n" +
"                        selectedBox.classList.add(\"correct\");\n" +
"                        selectedBox.querySelector(\".option-box\").classList.add(\"correct-box\");\n" +
"                        selectedBox.innerHTML += `<img class=\"correct-icon\" src=\"./assets/images/icon-correct.svg\" alt=\"Correct\">`;\n" +
"                    } else {\n" +
"                        selectedBox.classList.add(\"invalid\");\n" +
"                        selectedBox.querySelector(\".option-box\").classList.add(\"invalid-box\");\n" +
"                        selectedBox.innerHTML += `<img class=\"invalid-icon\" src=\"./assets/images/icon-incorrect.svg\" alt=\"Incorrect\">`;\n" +
"                    }\n" +
"                    revealAnswers();\n" +
"                }\n" +
"                submitButton.textContent = qCount >= totalQuestions - 1 ? \"See Results\" : \"Next Question\";\n" +
"            }\n" +
"        }, 1000);\n" +
"    }\n" +
"\n" +
"    // Send WhatsApp results\n" +
"    document.querySelector(\"#send-whatsapp\").addEventListener(\"click\", () => {\n" +
"        const whatsappNumber = document.querySelector(\"#teacher-whatsapp\").value.trim();\n" +
"        if (!whatsappNumber || !/^\\+\\d{10,15}$/.test(whatsappNumber)) {\n" +
"            alert(\"Please enter a valid WhatsApp number with country code (e.g., +1234567890).\");\n" +
"            return;\n" +
"        }\n" +
"        const message = `Quiz Results\\nSubject: ${quizType}\\nScore: ${score} out of ${totalQuestions} (${((score / totalQuestions) * 100).toFixed(2)}%)`;\n" +
"        const encodedMessage = encodeURIComponent(message);\n" +
"        const whatsappUrl = `https://api.whatsapp.com/send?phone=${whatsappNumber}&text=${encodedMessage}`;\n" +
"        window.open(whatsappUrl, \"_blank\");\n" +
"    });\n" +
"\n" +
"    // Restart quiz (blocked if completed)\n" +
"    document.querySelector(\".restart\").addEventListener(\"click\", () => {\n" +
"        if (localStorage.getItem(\"quizCompleted\") === \"true\") {\n" +
"            document.querySelector(\".quiz-complete\").classList.remove(\"visible\");\n" +
"            toggleCompletionState(true);\n" +
"        } else {\n" +
"            document.querySelector(\".quiz-complete\").classList.remove(\"visible\");\n" +
"            toggleCompletionState(false);\n" +
"            document.querySelectorAll(\".curr-subject\").forEach(bar => {\n" +
"                bar.style.visibility = \"hidden\";\n" +
"            });\n" +
"            qCount = -1;\n" +
"            score = 0;\n" +
"            document.querySelector(\".progress-bar.done\").style.width = \"0%\";\n" +
"            document.querySelector(\".error-message\").style.display = \"none\";\n" +
"        }\n" +
"    });\n" +
"\n" +
"    function questionScreen(type) {\n" +
"        startMenu.classList.remove(\"visible\");\n" +
"        document.querySelector(\".question-screen\").classList.add(\"visible\");\n" +
"        document.querySelector(\".error-message\").style.display = \"none\";\n" +
"        setSubjectBars(type);\n" +
"        getQuiz(type);\n" +
"    }\n" +
"\n" +
"    function setSubjectBars(type) {\n" +
"        const iconMap = {\n" +
"            \""+quiznam+"\": \"./assets/images/subject_icon.png\",\n" +
"        };\n" +
"        document.querySelectorAll(\".curr-subject\").forEach(bar => {\n" +
"            bar.querySelector(\"h2\").textContent = type;\n" +
"            bar.querySelector(\"img\").src = iconMap[type];\n" +
"            bar.style.visibility = \"visible\";\n" +
"        });\n" +
"    }\n" +
"\n" +
"    function getQuiz(type) {\n" +
"        try {\n" +
"            quizChosen = quizData.quizzes.find(quiz => quiz.title === type);\n" +
"            if (!quizChosen) {\n" +
"                throw new Error(`Quiz \"${type}\" not found in data`);\n" +
"            }\n" +
"            totalQuestions = quizChosen.questions.length;\n" +
"            document.querySelector(\".question-total\").textContent = totalQuestions;\n" +
"            document.querySelector(\".complete-question-total\").textContent = totalQuestions;\n" +
"            increment = (1 / totalQuestions) * 100;\n" +
"            makeQuestions();\n" +
"        } catch (error) {\n" +
"            console.error(\"Error loading quiz data:\", error.message);\n" +
"            showError(`Failed to load quiz data: ${error.message}. Please try again.`);\n" +
"        }\n" +
"    }\n" +
"\n" +
"    function makeQuestions() {\n" +
"        qCount++;\n" +
"        if (qCount >= totalQuestions) {\n" +
"            localStorage.setItem(\"quizCompleted\", \"true\");\n" +
"            showQuizComplete();\n" +
"            return;\n" +
"        }\n" +
"\n" +
"        // Reset UI\n" +
"        document.querySelector(\".question-number\").textContent = qCount + 1;\n" +
"        document.querySelector(\".progress-bar.done\").style.width = `${increment * (qCount + 1)}%`;\n" +
"        submitButton.textContent = \"Submit Answer\";\n" +
"        document.querySelector(\".select-prompt\").style.visibility = \"hidden\";\n" +
"        document.querySelector(\".error-message\").style.display = \"none\";\n" +
"\n" +
"        // Clear previous question state\n" +
"        document.querySelectorAll(\".option\").forEach(option => {\n" +
"            option.classList.remove(\"selected\", \"invalid\", \"correct\");\n" +
"            option.querySelector(\".option-box\").classList.remove(\"selected-box\", \"invalid-box\", \"correct-box\");\n" +
"            const img = option.querySelector(\"img\");\n" +
"            if (img) img.remove();\n" +
"        });\n" +
"\n" +
"        // Set question and options\n" +
"        document.querySelector(\".question\").textContent = quizChosen.questions[qCount].question;\n" +
"        document.querySelectorAll(\".option\").forEach((option, i) => {\n" +
"            option.querySelector(\".option-text\").textContent = quizChosen.questions[qCount].options[i];\n" +
"        });\n" +
"\n" +
"        // Start timer\n" +
"        startTimer();\n" +
"    }\n" +
"\n" +
"    function revealAnswers() {\n" +
"        document.querySelectorAll(\".option\").forEach(option => {\n" +
"            const text = option.querySelector(\".option-text\").textContent;\n" +
"            if (validate(text) && !option.classList.contains(\"correct\")) {\n" +
"                option.classList.add(\"correct\");\n" +
"                option.querySelector(\".option-box\").classList.add(\"correct-box\");\n" +
"                option.innerHTML += `<img class=\"correct-icon\" src=\"./assets/images/icon-correct.svg\" alt=\"Correct\">`;\n" +
"            }\n" +
"        });\n" +
"    }\n" +
"\n" +
"    function validate(selected) {\n" +
"        return quizChosen.questions[qCount].answer === selected;\n" +
"    }\n" +
"\n" +
"    function showQuizComplete() {\n" +
"        document.querySelector(\".question-screen\").classList.remove(\"visible\");\n" +
"        document.querySelector(\".quiz-complete\").classList.add(\"visible\");\n" +
"        document.querySelector(\".final-score\").textContent = score;\n" +
"        localStorage.setItem(\"quizCompleted\", \"true\");\n" +
"    }\n" +
"\n" +
"    function showError(message) {\n" +
"        const errorMessage = document.querySelector(\".error-message\");\n" +
"        errorMessage.textContent = message;\n" +
"        errorMessage.style.display = \"block\";\n" +
"        document.querySelector(\".question-screen\").classList.add(\"visible\");\n" +
"        startMenu.classList.remove(\"visible\");\n" +
"    }\n" +
"});");
             
      pwzi.close(); 
      
      
      
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
