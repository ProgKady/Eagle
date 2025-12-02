package eagle;

import java.awt.Desktop;
import java.io.File;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
////////////////////////////////////////

public class Main extends Application {
    /////////////////////////////////////
    //private List<Point> snow = new LinkedList<>();
    //double gravity = 0.15D;
    //public static MediaPlayer mediaPlayer;
    /////////////////////////////////////
   public void start(Stage stage) throws Exception {
       ////////////////////////////////////////////////////////////////////
//      Stage stg = new Stage();
//      
//      WritableImage image = new WritableImage(700, 500);
//      drawString(image, "Made with", 70, 60);
//      drawString(image, "Love in", 120, 150);
//      drawString(image, "Kadysoft-Eagle", 10, 250);
//      drawString(image, "by KADY.", 100, 350);
//    final PixelReader reader = image.getPixelReader();
//
//    Canvas show = new Canvas(500, 400);
//    final GraphicsContext context = show.getGraphicsContext2D();
//    new AnimationTimer(){
//      @Override
//      public void handle(long arg0){
//        context.clearRect(0, 0, 500, 400);
//
//        context.setFill(Color.WHITE);
//        context.fillRect(0, 0, 500, 400);
//
//        context.setFill(Color.BLACK);
//        Iterator<Point> it = snow.iterator();
//        while(it.hasNext()){
//          Point p = it.next();
//          p.vy += gravity * p.s;
//          p.y += p.vy;
//          if(p.y >= 400){
//            it.remove();
//          }else{
//            if(reader.getColor((int) p.x, (int) p.y).equals(Color.BLACK)){
//              p.y -= p.vy;
//              p.vy = 0;
//              p.y += 0.2;
//            }
//
//            context.fillOval(p.x, p.y, 2, 2);
//          }
//        }
//
//        for(int i = 0; i < 10; i++){
//          snow.add(new Point(Math.random() * 500, 0, Math.random() + 0.5));
//        }
//      }
//    }.start();
//
//      
//      Scene sce = new Scene(new Group(show));
//      stg.setTitle("Welcome To Eagle");
//      stg.centerOnScreen();
//      stg.setResizable(false);
//      stg.setScene(sce);
//      stg.setAlwaysOnTop(true);
//      stg.show();
//      
       
     // Thread.sleep(3000);
       
      ///////////////////////////////////////////////////////////////////// 
      Parent root;
      root = (Parent)FXMLLoader.load(this.getClass().getResource("Welcome.fxml"));
              root.setStyle("-fx-border-color: black; -fx-border-width: 1px;-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, .75), 20, 0.19, 0, 0);");
      Scene scene = new Scene(root,Color.TRANSPARENT);
      stage.setTitle("Eagle With Simba - Step2APK.");
      stage.centerOnScreen();
      //stage.initStyle(StageStyle.TRANSPARENT);
      stage.setResizable(false);
      stage.getIcons().add(new javafx.scene.image.Image (getClass ().getResourceAsStream("iconnn.png")));
      stage.setScene(scene);
      /*
    stage.setOnShowing((WindowEvent u) -> {
        
    });
*/
      stage.show();
      com.sun.glass.ui.Window.getWindows().get(0).setUndecoratedMoveRectangle(30);
   }

    
  
  
//  void noisy(PixelReader reader, GraphicsContext context){
//    context.setFill(Color.BLACK);
//    context.fillRect(0, 0, 500, 400);
//
//    context.setFill(Color.WHITE);
//    for(int i = 0; i < 500; i++){
//      for(int j = 0; j < 400; j++){
//        double r = Math.random();
//        if(reader.getColor(i, j).equals(Color.BLACK)){
//          if(r > 0.75) context.fillOval(i, j, 1, 1);
//        }else if(r > 0.95){
//          context.fillOval(i, j, 1, 1);
//        }
//      }
//    }
//  }
//
//  public void drawString(WritableImage image, String text, int x, int y){
//    BufferedImage buffer = SwingFXUtils.fromFXImage(image, null);
//    Graphics g = buffer.getGraphics();
//    g.setColor(java.awt.Color.BLACK);
//    g.setFont(new Font(" Aharoni", 1, 65));
//    g.drawString(text, x, y);
//    SwingFXUtils.toFXImage(buffer, image);
//    g.dispose();
//  }

  

//  static class Point{
//    double x; 
//    double y; 
//    double s; 
//    double vy; 
//
//    public Point(double x, double y, double s){
//      this.x = x;
//      this.y = y;
//      this.s = s;
//      this.vy = 0;
//    }
//
//    public String toString(){
//      return x + " , " + y + " , " + s + " , " + vy;
//    }
//
//  }
 
  
  public static void main(String[] args){
    launch(args);
  }

}