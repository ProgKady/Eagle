package eagle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
//import com.jfoenix.controls.JFXButton.ButtonType;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTreeView;
import static eagle.HTMLEditor.app_theme;
import static eagle.HTMLEditor.executor;
import static eagle.HTMLEditor.fullo;
import static eagle.HTMLEditor.htmltab;
import static eagle.HTMLEditor.mmmo;
import static eagle.HTMLEditor.root;
import static eagle.HTMLEditor.tabpane;

import java.awt.Desktop;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.Tooltip;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.IndexRange;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebEngine;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.WindowEvent;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.controlsfx.control.Notifications;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Entities;
import org.reactfx.Subscription;


public class HTMLEditor_Old extends Application {
    
    
    private JFXTreeView<Path> projectTree;
    private Path projectRoot;
    public static String mmmo,fullo;
    
    
    ///////////////////////
    MenuBar barr;
    Menu fil,edt,htmltag,csstag,jstag,run,toools,help;
    MenuItem tol1,tol2,tol3,tol4,tol5,tol6,tol7,tol8,tol9,tol10,tol11,tol12,tol13;
    public static Tab htmltab;
    ///////////////////////
   CodeArea codeArea;
   static Pattern PATTERN;
   static Alert ad;
   static ExecutorService executor;
   static BorderPane root;
   WebView codee;
   MenuItem it1;
   MenuItem it2;
   MenuItem it3;
   MenuItem it4;
   MenuItem it5;
   MenuItem it21;
   MenuItem it22;
   MenuItem itht;
   MenuItem itct;
   MenuItem itjt;
   MenuItem it6;
   MenuItem it7;
   MenuItem it8;
   MenuItem it9;
   MenuItem it10;
   MenuItem it11;
   MenuItem it12;
   MenuItem it13;
   MenuItem it14;
   MenuItem it1477;
   CheckMenuItem it14774;
   JFXTextField tagsearch;
   Menu m1;
   Menu m2;
   Menu m3;
   Menu m4;
   Menu m5;
   Menu m6;
   Menu m7;
   MenuItem openf;
   MenuItem newhtml;
   MenuItem h1;
   MenuItem h2;
   MenuItem h3;
   MenuItem h4;
   MenuItem h5;
   MenuItem h6;
   MenuItem h7;
   MenuItem h8;
   MenuItem h9;
   MenuItem h10;
   MenuItem h11;
   MenuItem h12;
   MenuItem h13;
   MenuItem h14;
   MenuItem h15;
   MenuItem h16;
   MenuItem h17;
   MenuItem h18;
   MenuItem h19;
   MenuItem h20;
   MenuItem h21;
   MenuItem h22;
   MenuItem h23;
   MenuItem h24;
   MenuItem h25;
   MenuItem h26;
   MenuItem h27;
   MenuItem h28;
   MenuItem h29;
   MenuItem h30;
   MenuItem h31;
   MenuItem h32;
   MenuItem h33;
   MenuItem h34;
   MenuItem h35;
   MenuItem h36;
   MenuItem h37;
   MenuItem h38;
   MenuItem h39;
   MenuItem h40;
   MenuItem h41;
   MenuItem h42;
   MenuItem h43;
   MenuItem h44;
   MenuItem h45;
   MenuItem h46;
   MenuItem h47;
   MenuItem h48;
   MenuItem h49;
   MenuItem h50;
   MenuItem h51;
   MenuItem h52;
   MenuItem h53;
   MenuItem h54;
   MenuItem h55;
   MenuItem h56;
   MenuItem h57;
   MenuItem h58;
   MenuItem h59;
   MenuItem h60;
   MenuItem h61;
   MenuItem h62;
   MenuItem h63;
   MenuItem h64;
   MenuItem h65;
   MenuItem h66;
   MenuItem h67;
   MenuItem h68;
   MenuItem h69;
   MenuItem h70;
   MenuItem h71;
   MenuItem h72;
   MenuItem h73;
   MenuItem h74;
   MenuItem h75;
   MenuItem h76;
   MenuItem h77;
   MenuItem h78;
   MenuItem h79;
   MenuItem h80;
   MenuItem h81;
   MenuItem h82;
   MenuItem h83;
   MenuItem h84;
   MenuItem h85;
   MenuItem h86;
   MenuItem h87;
   MenuItem h88;
   MenuItem h89;
   MenuItem h90;
   MenuItem h91;
   MenuItem h92;
   MenuItem h93;
   MenuItem h94;
   MenuItem h95;
   MenuItem h96;
   MenuItem h97;
   MenuItem h98;
   MenuItem h99;
   MenuItem h100;
   MenuItem h101;
   MenuItem h102;
   MenuItem h103;
   MenuItem h104;
   MenuItem h105;
   MenuItem h106;
   MenuItem h107;
   MenuItem h108;
   MenuItem h109;
   MenuItem h110;
   MenuItem h111;
   MenuItem h112;
   MenuItem h113;
   MenuItem h114;
   MenuItem h115;
   MenuItem h116;
   MenuItem cs1;
   MenuItem c2;
   MenuItem c3;
   MenuItem c4;
   MenuItem c5;
   MenuItem c6;
   MenuItem c7;
   MenuItem c8;
   MenuItem c9;
   MenuItem c10;
   MenuItem c11;
   MenuItem c12;
   MenuItem c13;
   MenuItem c14;
   MenuItem c15;
   MenuItem c16;
   MenuItem c17;
   MenuItem c18;
   MenuItem c19;
   MenuItem c20;
   MenuItem c21;
   MenuItem c22;
   MenuItem c23;
   MenuItem c24;
   MenuItem c25;
   MenuItem c26;
   MenuItem c27;
   MenuItem c28;
   MenuItem c29;
   MenuItem c30;
   MenuItem c31;
   MenuItem c32;
   MenuItem c33;
   MenuItem c34;
   MenuItem c35;
   MenuItem c36;
   MenuItem c37;
   MenuItem c38;
   MenuItem c39;
   MenuItem c40;
   MenuItem c41;
   MenuItem c42;
   MenuItem c43;
   MenuItem c44;
   MenuItem c45;
   MenuItem c46;
   MenuItem c47;
   MenuItem c48;
   MenuItem c49;
   MenuItem c50;
   MenuItem c51;
   MenuItem c52;
   MenuItem c53;
   MenuItem c54;
   MenuItem c55;
   MenuItem c56;
   MenuItem c57;
   static JFXTabPane tabpane;
   MenuItem c58;
   MenuItem c59;
   MenuItem c60;
   MenuItem c61;
   MenuItem c62;
   MenuItem c63;
   MenuItem c64;
   MenuItem c65;
   MenuItem c66;
   MenuItem c67;
   MenuItem c68;
   MenuItem c69;
   MenuItem c70;
   MenuItem c71;
   MenuItem c72;
   MenuItem c73;
   MenuItem c74;
   MenuItem c75;
   MenuItem c76;
   MenuItem c77;
   MenuItem c78;
   MenuItem c79;
   MenuItem c80;
   MenuItem c81;
   MenuItem c82;
   MenuItem c83;
   MenuItem c84;
   MenuItem c85;
   MenuItem c86;
   MenuItem c87;
   MenuItem c88;
   MenuItem c89;
   MenuItem c90;
   MenuItem c91;
   MenuItem c92;
   MenuItem c93;
   MenuItem c94;
   MenuItem c95;
   MenuItem c96;
   MenuItem c97;
   MenuItem c98;
   MenuItem c99;
   MenuItem c100;
   MenuItem c101;
   MenuItem c102;
   MenuItem c103;
   MenuItem c104;
   MenuItem c105;
   MenuItem c106;
   MenuItem c107;
   MenuItem c108;
   MenuItem c109;
   MenuItem c110;
   MenuItem c111;
   MenuItem c112;
   MenuItem c113;
   MenuItem c114;
   MenuItem c115;
   MenuItem c116;
   MenuItem c117;
   MenuItem c118;
   MenuItem iconi;
   Separator sep1;
   Menu js;
   Menu ele;
   Menu var;
   Menu out;
   Menu commm;
   Menu eve;
   Menu strings;
   Menu numbers;
   Menu maths;
   Menu dates;
   Menu dateformats;
   Menu datemethods;
   Menu cons;
   Menu sett;
   Menu gett;
   Menu utc;
   Menu cook;
   Menu tim;
   Menu one;
   Menu two;
   Menu three;
   Menu four;
   static MenuItem j1;
   static MenuItem j2;
   static MenuItem j3;
   static MenuItem j4;
   static MenuItem j5;
   static MenuItem j6;
   static MenuItem j7;
   static MenuItem j8;
   static MenuItem j9;
   static MenuItem j10;
   static MenuItem j11;
   static MenuItem j12;
   static MenuItem j13;
   static MenuItem j14;
   static MenuItem j15;
   static MenuItem j16;
   static MenuItem j17;
   static MenuItem j18;
   static MenuItem j19;
   static MenuItem j20;
   static MenuItem j21;
   static MenuItem j22;
   static MenuItem j23;
   static MenuItem j24;
   static MenuItem j25;
   static MenuItem j26;
   static MenuItem j27;
   static MenuItem j28;
   static MenuItem j29;
   static MenuItem j30;
   static MenuItem j31;
   static MenuItem j32;
   static MenuItem j33;
   static MenuItem j34;
   static MenuItem j35;
   static MenuItem j36;
   static MenuItem j37;
   static MenuItem j38;
   static MenuItem j39;
   static MenuItem j40;
   static MenuItem j41;
   static MenuItem j42;
   static MenuItem j43;
   static MenuItem j44;
   static MenuItem j45;
   static MenuItem j46;
   static MenuItem j47;
   static MenuItem j48;
   static MenuItem j49;
   static MenuItem j50;
   static MenuItem j51;
   static MenuItem j52;
   static MenuItem j53;
   static MenuItem j54;
   static MenuItem j55;
   static MenuItem j56;
   static MenuItem j57;
   static MenuItem j58;
   static MenuItem j59;
   static MenuItem j60;
   static MenuItem j61;
   static MenuItem j62;
   static MenuItem j63;
   static MenuItem j64;
   static MenuItem j65;
   static MenuItem j66;
   static MenuItem j67;
   static MenuItem j68;
   static MenuItem j69;
   static MenuItem j70;
   static MenuItem j71;
   static MenuItem j72;
   static MenuItem j73;
   static MenuItem j74;
   static MenuItem j75;
   static MenuItem j76;
   static MenuItem j77;
   static MenuItem j78;
   static MenuItem j79;
   static MenuItem j80;
   static MenuItem j81;
   static MenuItem j82;
   static MenuItem j83;
   static MenuItem j84;
   static MenuItem j85;
   static MenuItem j86;
   static MenuItem j87;
   static MenuItem j88;
   static MenuItem j89;
   static MenuItem j90;
   static MenuItem j91;
   static MenuItem j92;
   static MenuItem j93;
   static MenuItem j94;
   static MenuItem j95;
   static MenuItem j96;
   static MenuItem j97;
   static MenuItem j98;
   static MenuItem j99;
   static MenuItem j100;
   static MenuItem j101;
   static MenuItem j102;
   static MenuItem j103;
   static MenuItem j104;
   static MenuItem j105;
   static MenuItem j106;
   static MenuItem j107;
   static MenuItem j108;
   static MenuItem j109;
   static MenuItem j110;
   static MenuItem j111;
   static MenuItem j112;
   static MenuItem j113;
   static MenuItem j114;
   static MenuItem j115;
   static MenuItem j116;
   static MenuItem j117;
   static MenuItem j118;
   static MenuItem j119;
   static MenuItem aiartool;
   static MenuItem j120;
   static MenuItem j121;
   static MenuItem j122;
   static MenuItem j123;
   static MenuItem j124;
   static MenuItem j125;
   static MenuItem j126;
   static MenuItem j127;
   static MenuItem j128;
   static MenuItem j129;
   static MenuItem j130;
   static MenuItem j131;
   static MenuItem j132;
   static MenuItem j133;
   static MenuItem j134;
   static MenuItem j135;
   static MenuItem j136;
   static MenuItem j137;
   static MenuItem j138;
   static MenuItem j139;
   static MenuItem j140;
   static MenuItem j141;
   static MenuItem j142;
   static MenuItem j143;
   static MenuItem j144;
   static MenuItem j145;
   static MenuItem j146;
   static MenuItem j147;
   static MenuItem j148;
   static MenuItem j149;
   static MenuItem j150;
   static MenuItem j151;
   static MenuItem j152;
   static MenuItem j153;
   static MenuItem j154;
   static MenuItem j155;
   static MenuItem j156;
   static MenuItem j157;
   static MenuItem j158;
   static MenuItem j159;
   static MenuItem j160;
   static MenuItem j161;
   static MenuItem j162;
   static MenuItem j163;
   static MenuItem j164;
   static MenuItem j165;
   static MenuItem j166;
   static MenuItem j167;
   static MenuItem j168;
   static MenuItem j169;
   static MenuItem j170;
   Menu men1;
   Menu men2;
   Menu men3;
   Menu men4;
   Menu men5;
   Menu men6;
   Menu men7;
   Menu tagg;
   CheckMenuItem c1;
   CheckMenuItem check2;
   URL u;
   URLConnection urlc;
   static String path;
   MenuItem gethtml;
   MenuItem htmlfile;
   MenuItem cssfile;
   MenuItem jsfile;
   Menu createfile;
   
   JFXTextArea myarea;
   
   
   
   MenuItem newfullproject;
   
   
public static double font_sizee;
public static String codearea_color,font_size,codearea_syntax,app_theme,font_family,font_weight,font_style;


   
   private double currentFontSize = font_sizee;
   private String currentTheme = app_theme;
   public static ScrollPane scpane,scpane1,scpane2,htmlscroll;
   
   private Path copiedFile = null;
   
   Path selectedFilePath; // To store the path of the selected item
   
   public static String selfileee;
   
   private ExecutorService executort = Executors.newFixedThreadPool(2);
   
   
List<IndexRange> matchRanges = new ArrayList<>();
int currentMatchIndex = -1;



//////////////////PHP/////////////////



//////////////////////////////////////

   
   public void start(Stage HTMLStage) {
       
       
       
       ///////////////////////////////////////////////
      htmlfile = new MenuItem("HTML File");
      htmlfile.setStyle("-fx-font-size:13;");
      htmlfile.setOnAction((sdd) -> {
          
         Label lop=new Label("Where do you want to save the new file?");
         lop.setFont(Font.font("monospaced",FontWeight.BOLD,16));
         //lop.setEffect(new DropShadow());
         
         JFXTextField fnam=new JFXTextField ("");
         //fnam.setEffect(new DropShadow());
         fnam.setPromptText("File Name? ...");
         fnam.setLabelFloat(true);
         fnam.setStyle("-fx-text-size:15;-fx-font-weight:bold;");
          
         ToggleGroup tg=new ToggleGroup(); 
          
         JFXRadioButton opp=new JFXRadioButton ("Project Directory");
         //opp.setEffect(new DropShadow());
         opp.setToggleGroup(tg);
         
         JFXRadioButton oppp=new JFXRadioButton ("Another Directory");
         //oppp.setEffect(new DropShadow());
         oppp.setToggleGroup(tg);
         
         VBox poo=new VBox();
         poo.setAlignment(Pos.CENTER);
         poo.setSpacing(20);
         poo.getChildren().addAll(lop,fnam,opp,oppp);
         
          
         Alert alert=new Alert (AlertType.CONFIRMATION);
         alert.setTitle("Eagle Dialog");
         alert.setHeaderText("New File ...");
         alert.getDialogPane().setContent(poo);
         alert.setResizable(false);
         Optional<ButtonType> result=alert.showAndWait();
            if (result.get()==ButtonType.OK) {
          
                if (opp.isSelected()==true) {
                    String fnamy=fnam.getText();
                    String poss=htmltab.getText().replace("Index.html","");
                    File fc=new File (poss+fnamy+".html");
                    try {
                        fc.createNewFile();
                    } catch (IOException ex) {
                        Logger.getLogger(HTMLEditor_Old.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    Tab tyu=new Tab (poss+fnamy+".html");
                    CodeArea coi=new CodeArea("<html>");
                    tyu.setContent(coi);
                    tabpane.getTabs().add(tyu);
                    
                }
                else if (oppp.isSelected()==true) {
                    
                }
                
           
            }
               else {
           
               }
      
         
      });

      cssfile = new MenuItem("CSS File");
      cssfile.setStyle("-fx-font-size:13;");
      cssfile.setOnAction((sdd) -> {
         
      });
      jsfile = new MenuItem("JS File");
      jsfile.setStyle("-fx-font-size:13;");
      jsfile.setOnAction((sdd) -> {
         
      });
       
       
       
      createfile=new Menu ("Create New File");
      //createfile.setAccelerator(KeyCombination.keyCombination("Ctrl+F"));
      //createfile.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("file.png"))));
      createfile.setMnemonicParsing(true);
      createfile.setStyle("-fx-text-size:17;-fx-font-weight:bold;");
      createfile.getItems().addAll(htmlfile,cssfile,jsfile);
       ///////////////////////////////////////////////
      it14774= new CheckMenuItem("Edit in Viewer");
      it14774.setStyle("-fx-font-size:13;");
      it14774.setOnAction((sdd) -> {
          
          if (it14774.isSelected()==true) {
          
         String terte=codeArea.getText().replace("<HTML LANG=\"EN-US\"","<HTML LANG=\"EN-US\" CONTENTEDITABLE").replace("<HTML ","<HTML CONTENTEDITABLE ");
         codeArea.replaceText(terte); 
              
          }
          
          else {
              
         String terte=codeArea.getText().replace("<HTML LANG=\"EN-US\" CONTENTEDITABLE","<HTML LANG=\"EN-US\"").replace("<HTML CONTENTEDITABLE ","<HTML ");
         codeArea.replaceText(terte);    
              
          }
         
      });
     
      
      myarea=new JFXTextArea();
       
      this.h1 = new MenuItem("comment");
      this.h1.setStyle("-fx-font-size:13;");
      WebView erty1=new WebView ();
          erty1.setPrefSize(200,100);
          erty1.getEngine().loadContent("<center><!-- --></center>");
       //   h1.setGraphic(erty1);
      this.h1.setOnAction((sdd) -> {
          
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<!-- -->");
      });
      this.h115 = new MenuItem("&nbsp  ' '");
      this.h115.setStyle("-fx-font-size:13;");
      WebView erty115=new WebView ();
          erty115.setPrefSize(200,100);
          erty115.getEngine().loadContent("<center>&nbsp</center>");
       //   h115.setGraphic(erty115);
      this.h115.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "&nbsp");
      });
      this.h116 = new MenuItem("&rarr  -->");
      this.h116.setStyle("-fx-font-size:13;");
      WebView erty116=new WebView ();
          erty116.setPrefSize(200,100);
          erty116.getEngine().loadContent("<center>&rarr</center>");
       //   h116.setGraphic(erty116);
      this.h116.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "&rarr");
      });
      this.h2 = new MenuItem("DOCTYPE");
      this.h2.setStyle("-fx-font-size:13;");
      WebView erty2=new WebView ();
          erty2.setPrefSize(200,100);
          erty2.getEngine().loadContent("<center><!DOCTYPE html></center>");
       //   h2.setGraphic(erty2);
      this.h2.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<!DOCTYPE html>");
      });
      this.h3 = new MenuItem("a");
      this.h3.setStyle("-fx-font-size:13;");
      WebView erty3=new WebView ();
          erty3.setPrefSize(200,100);
          erty3.getEngine().loadContent("<center><a href=\"#\" title=\" \" target=\"_blank\">Eagle</a></center>");
       //   h3.setGraphic(erty3);
      this.h3.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<a href=\" \" title=\"Eagle\" target=\"_blank\"> </a>");
      });
      this.h4 = new MenuItem("abbr");
      this.h4.setStyle("-fx-font-size:13;");
      WebView erty4=new WebView ();
          erty4.setPrefSize(200,100);
          erty4.getEngine().loadContent("<center><abbr title=\"Eagle\">Eagle</abbr></center>");
        //  h4.setGraphic(erty4);
      this.h4.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<abbr title=\" \"> </abbr>");
      });
      this.h5 = new MenuItem("acronym");
      this.h5.setStyle("-fx-font-size:13;");
      WebView erty5=new WebView ();
          erty5.setPrefSize(200,100);
          erty5.getEngine().loadContent("<center><acronym title=\"Eagle\">Eage</acronym></center>");
      //    h5.setGraphic(erty5);
      this.h5.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<acronym title=\" \"> </acronym>");
      });
      this.h6 = new MenuItem("address");
      this.h6.setStyle("-fx-font-size:13;");
      WebView erty6=new WebView ();
          erty6.setPrefSize(200,100);
          erty6.getEngine().loadContent("<center><address>Eagle</address></center>");
       //   h6.setGraphic(erty6);
      this.h6.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<address> </address>");
      });
      this.h7 = new MenuItem("area");
      this.h7.setStyle("-fx-font-size:13;");
      WebView erty7=new WebView ();
          erty7.setPrefSize(200,100);
          erty7.getEngine().loadContent("<center><area shape=\"circle\" coords=\"20\"></center>");
       //   h7.setGraphic(erty7);
      this.h7.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<area shape=\" \" coords=\" \">");
      });
      this.h8 = new MenuItem("article");
      this.h8.setStyle("-fx-font-size:13;");
      WebView erty8=new WebView ();
          erty8.setPrefSize(200,100);
          erty8.getEngine().loadContent("<center><article>Eagle</article></center>");
       //   h8.setGraphic(erty8);
      this.h8.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<article> </article>");
      });
      this.h9 = new MenuItem("aside");
      this.h9.setStyle("-fx-font-size:13;");
      WebView erty9=new WebView ();
          erty9.setPrefSize(200,100);
          erty9.getEngine().loadContent("<center><aside>Eagle</aside></center>");
       //   h9.setGraphic(erty9);
      this.h9.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<aside> </aside>");
      });
      this.h10 = new MenuItem("audio");
      this.h10.setStyle("-fx-font-size:13;");
      WebView erty10=new WebView ();
          erty10.setPrefSize(200,100);
          erty10.getEngine().loadContent("<center><audio controls=\"controls\"><source src=\"#\"></audio></center>");
       //   h10.setGraphic(erty10);
      this.h10.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<audio controls=\"controls\" loop=\"loop\" autoplay=\"autoplay\"><source src=\" \"></audio>");
      });
      this.h11 = new MenuItem("b");
      this.h11.setStyle("-fx-font-size:13;");
      this.h11.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<b> </b>");
      });
      this.h12 = new MenuItem("base");
      this.h12.setStyle("-fx-font-size:13;");
      this.h12.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<base href=\" \" target=\"_blank\">");
      });
      this.h13 = new MenuItem("basefont");
      this.h13.setStyle("-fx-font-size:13;");
      this.h13.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<basefont color=\" \" size=\" \">");
      });
      this.h14 = new MenuItem("bdi");
      this.h14.setStyle("-fx-font-size:13;");
      this.h14.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<bdi> </bdi>");
      });
      this.h15 = new MenuItem("bdo");
      this.h15.setStyle("-fx-font-size:13;");
      this.h15.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<bdo dir=\"\"> </bdo>");
      });
      this.h16 = new MenuItem("big");
      this.h16.setStyle("-fx-font-size:13;");
      this.h16.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<big> </big>");
      });
      this.h17 = new MenuItem("blockquote");
      this.h17.setStyle("-fx-font-size:13;");
      this.h17.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<blockquote cite=\"URL\"> </blockquote>");
      });
      this.h18 = new MenuItem("br");
      this.h18.setStyle("-fx-font-size:13;");
      this.h18.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<br>");
      });
      this.h19 = new MenuItem("button");
      this.h19.setStyle("-fx-font-size:13;");
      this.h19.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<button type=\"button, reset, submit\"\nvalue=\"\" name=\"\" form=\"ID\" formaction=\"URL\"\nformentype=\"multipart/form-data , text/plain\"\nformmethod=\"get , post\" formnovalidate=\"\"> </button>");
      });
      this.h20 = new MenuItem("canvas");
      this.h20.setStyle("-fx-font-size:13;");
      this.h20.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<canvas width=\"\" height=\"\"> </canvas>");
      });
      this.h21 = new MenuItem("caption");
      this.h21.setStyle("-fx-font-size:13;");
      this.h21.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<caption> </caption>");
      });
      this.h22 = new MenuItem("center");
      this.h22.setStyle("-fx-font-size:13;");
      this.h22.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<center> </center>");
      });
      this.h23 = new MenuItem("cite");
      this.h23.setStyle("-fx-font-size:13;");
      this.h23.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<cite> </cite>");
      });
      this.h24 = new MenuItem("code");
      this.h24.setStyle("-fx-font-size:13;");
      this.h24.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<code> </code>");
      });
      this.h25 = new MenuItem("col");
      this.h25.setStyle("-fx-font-size:13;");
      this.h25.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<col span=\"NUMBER\" style=\" \">");
      });
      this.h26 = new MenuItem("colgroup");
      this.h26.setStyle("-fx-font-size:13;");
      this.h26.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<colgroup> </colgroup>");
      });
      this.h27 = new MenuItem("datalist");
      this.h27.setStyle("-fx-font-size:13;");
      this.h27.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<datalist id=\"\">\n<option value=\"\">\n<option value=\"\">\n</datalist>");
      });
      this.h28 = new MenuItem("dd");
      this.h28.setStyle("-fx-font-size:13;");
      this.h28.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<dd> </dd>");
      });
      this.h29 = new MenuItem("del");
      this.h29.setStyle("-fx-font-size:13;");
      this.h29.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<del cite=\"URL\" datetime=\"YYYY-MM-DDThh:mm:ssTZD\"> </del>");
      });
      this.h30 = new MenuItem("details");
      this.h30.setStyle("-fx-font-size:13;");
      this.h30.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<details open=\"open\">\n<summary> </summary>\n</details>");
      });
      this.h31 = new MenuItem("dfn");
      this.h31.setStyle("-fx-font-size:13;");
      this.h31.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<dfn> </dfn>");
      });
      this.h32 = new MenuItem("dialog");
      this.h32.setStyle("-fx-font-size:13;");
      this.h32.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<dialog> </dialog>");
      });
      this.h33 = new MenuItem("dir");
      this.h33.setStyle("-fx-font-size:13;");
      this.h33.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<dir> </dir>");
      });
      this.h34 = new MenuItem("div");
      this.h34.setStyle("-fx-font-size:13;");
      this.h34.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<div> </div>");
      });
      this.h35 = new MenuItem("dl");
      this.h35.setStyle("-fx-font-size:13;");
      this.h35.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<dl> </dl>");
      });
      this.h36 = new MenuItem("dt");
      this.h36.setStyle("-fx-font-size:13;");
      this.h36.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<dt> </dt>");
      });
      this.h37 = new MenuItem("em");
      this.h37.setStyle("-fx-font-size:13;");
      this.h37.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<em> </em>");
      });
      this.h38 = new MenuItem("embed");
      this.h38.setStyle("-fx-font-size:13;");
      this.h38.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<embed src=\"\" width=\"\" height=\"\" type=\"\">");
      });
      this.h39 = new MenuItem("fieldset");
      this.h39.setStyle("-fx-font-size:13;");
      this.h39.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<fieldset disabled=\"disabled\"\nname=\"\"\nform=\"ID\"> </fieldset>");
      });
      this.h40 = new MenuItem("figcaption");
      this.h40.setStyle("-fx-font-size:13;");
      this.h40.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<figcaption> </figcaption>");
      });
      this.h41 = new MenuItem("figure");
      this.h41.setStyle("-fx-font-size:13;");
      this.h41.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<figure> </figure>");
      });
      this.h42 = new MenuItem("font");
      this.h42.setStyle("-fx-font-size:13;");
      this.h42.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<font size=\"\" color=\"\" face=\"\"> </font>");
      });
      this.h43 = new MenuItem("footer");
      this.h43.setStyle("-fx-font-size:13;");
      this.h43.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<footer> </footer>");
      });
      this.h44 = new MenuItem("form");
      this.h44.setStyle("-fx-font-size:13;");
      this.h44.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<form action=\"URL\" method=\"get , post\"\naccept-charset=\"\" autocomplete=\"on , off\"\nenctype=\"text/plain\" name=\"\"\nid=\"\"\nclass=\"\"\ntarget=\"_blank , _parent , _self , _top\" > </form>");
      });
      this.h45 = new MenuItem("frame");
      this.h45.setStyle("-fx-font-size:13;");
      this.h45.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<frame src=\"\">");
      });
      this.h46 = new MenuItem("frameset");
      this.h46.setStyle("-fx-font-size:13;");
      this.h46.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<frameset cols=\" %, %, %\"> </frameset>");
      });
      this.h47 = new MenuItem("h1->h6");
      this.h47.setStyle("-fx-font-size:13;");
      this.h47.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<h1> You can change the number, 1 to 6 </h1>");
      });
      this.h48 = new MenuItem("header");
      this.h48.setStyle("-fx-font-size:13;");
      this.h48.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<header> </header>");
      });
      this.h49 = new MenuItem("hr");
      this.h49.setStyle("-fx-font-size:13;");
      this.h49.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<hr>");
      });
      this.h50 = new MenuItem("i");
      this.h50.setStyle("-fx-font-size:13;");
      this.h50.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<i> </i>");
      });
      this.h51 = new MenuItem("iframe");
      this.h51.setStyle("-fx-font-size:13;");
      this.h51.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<iframe src=\"URL\" width=\"\" height=\"\" seamless=\"seemless\"\nsandbox=\"allow-forms , allow-same-orgin , allow-scripts , allow-top-navigation\" name=\"\"> </iframe>");
      });
      this.h52 = new MenuItem("img");
      this.h52.setStyle("-fx-font-size:13;");
      this.h52.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<img src=\"URL\" alt=\"\" height=\"\" width=\"\" ismap=\"ismap\" crossorgin=\"anonymous , use-credentials\">");
      });
      this.h53 = new MenuItem("input");
      this.h53.setStyle("-fx-font-size:13;");
      this.h53.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<input type=\"button , checkbox , color , date , datetime , datetime-local , email , file , hidden , image , month , number , password , radio , range , reset , search , submit , tel , text , time , url , week\" \n name=\"\" autocapitalize=\"sentences, words, characters, off\" value=\"\" accept=\"audio/* , video/* , image/*\" alt=\"\"\nautocomplete=\"on , off\"\nwidth=\"\" height=\"\" max=\"NUMBER\" maxlength=\"NUMBER\"\nmin=\"NUMBER\" multiple=\"multiple\" pattern=\"regexp\" name=\"\" placeholder=\"\"\nreadonly=\"readonly\" required=\"required\" size=\"NUMBER\" src=\"URL\" step=\"NUMBER\" spellcheck=\"default, true, false\" wrap=\"hard, soft\">");
      });
      this.h54 = new MenuItem("ins");
      this.h54.setStyle("-fx-font-size:13;");
      this.h54.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<ins cite=\"URL\" datetime=\"\"> </ins>");
      });
      this.h55 = new MenuItem("kbd");
      this.h55.setStyle("-fx-font-size:13;");
      this.h55.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<kbd> </kbd>");
      });
      this.h56 = new MenuItem("keygen");
      this.h56.setStyle("-fx-font-size:13;");
      this.h56.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<keygen name=\"\" autofocus=\"autofocus\" challenge=\"challenge\" disabled=\"disabled\" keytype=\"rsa , dsa , ec\">");
      });
      this.h57 = new MenuItem("label");
      this.h57.setStyle("-fx-font-size:13;");
      this.h57.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<label for=\"ID\"> </label>");
      });
      this.h58 = new MenuItem("legend for 'fieldset' element");
      this.h58.setStyle("-fx-font-size:13;");
      this.h58.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<legend> </legend>");
      });
      this.h59 = new MenuItem("li");
      this.h59.setStyle("-fx-font-size:13;");
      this.h59.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<li> </li>");
      });
      this.h60 = new MenuItem("link");
      this.h60.setStyle("-fx-font-size:13;");
      this.h60.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<link rel=\"\" type=\"\" href=\"URL\">");
      });
      this.h61 = new MenuItem("marquee");
      this.h61.setStyle("-fx-font-size:13;");
      this.h61.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<marquee bgcolor=\"red\" width=\"500\" height=\"100\"\nalign=\"top or middle or bottom\" hspace=\"30\" vspace=\"30\"\nbehavior=\"scroll or slide or alternate\" direction=\"left or right\"\nloop=\"infinite or -1 or any number\" scrollamount=\"10\"\nscrolldelay=\"500\"></marquee>");
      });
      this.h62 = new MenuItem("map");
      this.h62.setStyle("-fx-font-size:13;");
      this.h62.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<map name=\"\"> </map>");
      });
      this.h63 = new MenuItem("mark");
      this.h63.setStyle("-fx-font-size:13;");
      this.h63.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<mark> </mark>");
      });
      this.h64 = new MenuItem("menu");
      this.h64.setStyle("-fx-font-size:13;");
      this.h64.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<menu type=\"context , toolbar , list\" id=\"\" label=\"\"> </menu>");
      });
      this.h65 = new MenuItem("menuitem");
      this.h65.setStyle("-fx-font-size:13;");
      this.h65.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<menuitem label=\"\"onclick=\"\"> </menuitem>");
      });
      this.h66 = new MenuItem("meta");
      this.h66.setStyle("-fx-font-size:13;");
      this.h66.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<meta charset=\"\" name=\"application-name , author , description , generator , keywords, viewport\" content=\"\">");
      });
      this.h67 = new MenuItem("meter");
      this.h67.setStyle("-fx-font-size:13;");
      this.h67.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<meter value=\"\" min=\"\" max=\"\" low=\"\" high=\"\" optimum=\"\"> </meter>");
      });
      this.h68 = new MenuItem("nav");
      this.h68.setStyle("-fx-font-size:13;");
      this.h68.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<nav> </nav>");
      });
      this.h69 = new MenuItem("noframe");
      this.h69.setStyle("-fx-font-size:13;");
      this.h69.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<noframe> </noframe>");
      });
      this.h70 = new MenuItem("noscript");
      this.h70.setStyle("-fx-font-size:13;");
      this.h70.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<noscript> </noscript>");
      });
      this.h71 = new MenuItem("object");
      this.h71.setStyle("-fx-font-size:13;");
      this.h71.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<object width=\"\" height=\"\" data=\"\"> </object>");
      });
      this.h72 = new MenuItem("ol");
      this.h72.setStyle("-fx-font-size:13;");
      this.h72.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<ol reversed=\"reversed\" number=\"\" type=\"1 , A , a , l , i\"> </ol>");
      });
      this.h73 = new MenuItem("optgroup");
      this.h73.setStyle("-fx-font-size:13;");
      this.h73.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<optgroup label=\"\">");
      });
      this.h74 = new MenuItem("option");
      this.h74.setStyle("-fx-font-size:13;");
      this.h74.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<option value=\"\" selected=\"selected\" label=\"\" disabled=\"disabled\"> </option>");
      });
      this.h75 = new MenuItem("output");
      this.h75.setStyle("-fx-font-size:13;");
      this.h75.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<output name=\"\" for=\"ID\"> </output>");
      });
      this.h76 = new MenuItem("p");
      this.h76.setStyle("-fx-font-size:13;");
      this.h76.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<p contenteditable=\"true, false\"> </p>");
      });
      this.h77 = new MenuItem("param");
      this.h77.setStyle("-fx-font-size:13;");
      this.h77.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<param name=\"\" value=\"\">");
      });
      this.h78 = new MenuItem("pre");
      this.h78.setStyle("-fx-font-size:13;");
      this.h78.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<pre> </pre>");
      });
      this.h79 = new MenuItem("progress");
      this.h79.setStyle("-fx-font-size:13;");
      this.h79.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<progress value=\"\" max=\"100\"> </progress>");
      });
      this.h80 = new MenuItem("q");
      this.h80.setStyle("-fx-font-size:13;");
      this.h80.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<q cite=\"URL\"> </q>");
      });
      this.h81 = new MenuItem("rp");
      this.h81.setStyle("-fx-font-size:13;");
      this.h81.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<rp> </rp>");
      });
      this.h82 = new MenuItem("rt");
      this.h82.setStyle("-fx-font-size:13;");
      this.h82.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<rt> </rt>");
      });
      this.h83 = new MenuItem("ruby");
      this.h83.setStyle("-fx-font-size:13;");
      this.h83.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<ruby> </ruby>");
      });
      this.h84 = new MenuItem("svg");
      this.h84.setStyle("-fx-font-size:13;");
      this.h84.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<svg width=\"\" height=\"\"><circle cx=\"50\" cy=\"50\" r=\"40\" stroke=\"green\" stroke-width=\"4\" fill=\"yellow;\"/><rect width=\"\" height=\"\"\nstyle=\"fill:rgb(0,0,255); stroke-width:10; stroke:rgb(0,0,0);\"/><rect x=\"50\" y=\"20\" rx=\"20\" ry=\"20\" width=\"150\" height=\"150\"\nstyle=\"fill:red; stroke:black; stroke-width:5; opacity:0.5;\"/><polygon points=\"100,10 40,198 190,78 10,78 160,198\"\nstyle=\"fill:lime; stroke:purple; stroke-width:5; fill-rule:evenodd;\"/></svg>");
      });
      this.h85 = new MenuItem("samp");
      this.h85.setStyle("-fx-font-size:13;");
      this.h85.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<samp> </samp>");
      });
      this.h86 = new MenuItem("script");
      this.h86.setStyle("-fx-font-size:13;");
      this.h86.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<script src=\"\" defar=\"defer\"> </script>");
      });
      this.h87 = new MenuItem("section");
      this.h87.setStyle("-fx-font-size:13;");
      this.h87.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<section> </section>");
      });
      this.h88 = new MenuItem("select");
      this.h88.setStyle("-fx-font-size:13;");
      this.h88.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<select multiple=\"multiple\" disabled=\"disabled\"> </select>");
      });
      this.h89 = new MenuItem("small");
      this.h89.setStyle("-fx-font-size:13;");
      this.h89.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<small> </small>");
      });
      this.h90 = new MenuItem("source");
      this.h90.setStyle("-fx-font-size:13;");
      this.h90.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<source src=\"\">");
      });
      this.h91 = new MenuItem("span");
      this.h91.setStyle("-fx-font-size:13;");
      this.h91.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<span> </span>");
      });
      this.h92 = new MenuItem("strike");
      this.h92.setStyle("-fx-font-size:13;");
      this.h92.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<strike> </strike>");
      });
      this.h93 = new MenuItem("strong");
      this.h93.setStyle("-fx-font-size:13;");
      this.h93.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<strong> </strong>");
      });
      this.h94 = new MenuItem("style");
      this.h94.setStyle("-fx-font-size:13;");
      this.h94.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<style> </style>");
      });
      this.h95 = new MenuItem("sub");
      this.h95.setStyle("-fx-font-size:13;");
      this.h95.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<sub> </sub>");
      });
      this.h96 = new MenuItem("summary");
      this.h96.setStyle("-fx-font-size:13;");
      this.h96.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<summary> </summary>");
      });
      this.h97 = new MenuItem("sup");
      this.h97.setStyle("-fx-font-size:13;");
      this.h97.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<sup> </sup>");
      });
      this.h98 = new MenuItem("table");
      this.h98.setStyle("-fx-font-size:13;");
      this.h98.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<table border=\"\" width=\"\" height=\"\"> </table>");
      });
      this.h99 = new MenuItem("tbody");
      this.h99.setStyle("-fx-font-size:13;");
      this.h99.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<tbody> </tbody>");
      });
      this.h100 = new MenuItem("td");
      this.h100.setStyle("-fx-font-size:13;");
      this.h100.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<td> </td>");
      });
      this.h101 = new MenuItem("textrea");
      this.h101.setStyle("-fx-font-size:13;");
      this.h101.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<textarea rows=\" \" cols=\" \" placeholder=\" \"> </textarea>");
      });
      this.h102 = new MenuItem("tfoot");
      this.h102.setStyle("-fx-font-size:13;");
      this.h102.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<tfoot> </tfoot>");
      });
      this.h103 = new MenuItem("th");
      this.h103.setStyle("-fx-font-size:13;");
      this.h103.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<th> </th>");
      });
      this.h104 = new MenuItem("thead");
      this.h104.setStyle("-fx-font-size:13;");
      this.h104.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<thead> </thead>");
      });
      this.h105 = new MenuItem("time");
      this.h105.setStyle("-fx-font-size:13;");
      this.h105.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<time> </time>");
      });
      this.h106 = new MenuItem("title");
      this.h106.setStyle("-fx-font-size:13;");
      this.h106.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<title> </title>");
      });
      this.h107 = new MenuItem("tr");
      this.h107.setStyle("-fx-font-size:13;");
      this.h107.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<tr> </tr>");
      });
      this.h108 = new MenuItem("track");
      this.h108.setStyle("-fx-font-size:13;");
      this.h108.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<track src=\"URL\" kind=\"captions , chapters , descriptions , metadate , subtitles\" srclang=\"\" label=\"\">");
      });
      this.h109 = new MenuItem("tt");
      this.h109.setStyle("-fx-font-size:13;");
      this.h109.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<tt> </tt>");
      });
      this.h110 = new MenuItem("u");
      this.h110.setStyle("-fx-font-size:13;");
      this.h110.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<u> </u>");
      });
      this.h111 = new MenuItem("ul");
      this.h111.setStyle("-fx-font-size:13;");
      this.h111.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<ul> </ul>");
      });
      this.h112 = new MenuItem("var");
      this.h112.setStyle("-fx-font-size:13;");
      this.h112.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<var> </var>");
      });
      this.h113 = new MenuItem("video");
      this.h113.setStyle("-fx-font-size:13;");
      this.h113.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<video autoplay=\"autoplay\" loop=\"loop\" muted=\"muted\" poster=\"URL\" preload=\"auto , metadate , none\"  width=\"\" height=\"\"controls=\"controls\" src=\"URL\">\n </video>");
      });
      this.h114 = new MenuItem("wbr");
      this.h114.setStyle("-fx-font-size:13;");
      this.h114.setOnAction((sdd) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.replaceText(pos, pos, "<wbr>");
      });
      this.cs1 = new MenuItem("Link");
      this.cs1.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "<link rel=\"stylesheet\" type=\"text/css\" href=\"file_name.css\">\n");
      });
      this.c2 = new MenuItem("Comment");
      this.c2.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "/*\nWrite your comment here\n*/\n");
      });
      this.c3 = new MenuItem("CSS For Element");
      this.c3.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "<!--Replace this with HTML_Element name, like:p--> {\nReplace this with css code\n}\n");
      });
      this.c4 = new MenuItem("CSS For ID OF Element");
      this.c4.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "<!--Replace this with # then id of element, like:#button1--> {\nReplace this with css code\n}\n");
      });
      this.c5 = new MenuItem("CSS For Class Name");
      this.c5.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "<!--Replace this with '.' then class name, like:.center--> {\nReplace this with css code\n}\n");
      });
      this.c6 = new MenuItem("CSS For Element In Class");
      this.c6.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "<!--Replace this with element name and '.' then class name , like:p.center--> {\nReplace this with css code\n}\n");
      });
      this.c7 = new MenuItem("CSS For Group Of Elements");
      this.c7.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "<!--Replace this with HTML_Element names then Comma ',', like:h1,h2,p--> {\nReplace this with css code\n}\n");
      });
      this.c61 = new MenuItem("Background-Attachment");
      this.c61.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "background-attachment:scroll,local,initial,inherit,fixed;\n");
      });
      this.c62 = new MenuItem("Background-Clip");
      this.c62.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "background-clip:initial,border-box,content-box,padding-box,inherit;\n");
      });
      this.c63 = new MenuItem("Background-Color");
      this.c63.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "background-color:aqua;\n");
      });
      this.c64 = new MenuItem("Background-Image");
      this.c64.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "background-image:url(\"Flower.jpg\");\n");
      });
      this.c65 = new MenuItem("Background-Origin");
      this.c65.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "background-origin:padding-box,initial,inherit,content-box,border-box;\n");
      });
      this.c66 = new MenuItem("Background-Position");
      this.c66.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "background-position:top,right,left,calc,bottom,center;\n");
      });
      this.c67 = new MenuItem("Background-Position-X");
      this.c67.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "background-position-x:;\n");
      });
      this.c68 = new MenuItem("Background-Position-Y");
      this.c68.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "background-position-y:;\n");
      });
      this.c69 = new MenuItem("Background-Repeat");
      this.c69.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "background-repeat:no-repeat,repeat-y,repeat-x,round,space,repeat;\n");
      });
      this.c70 = new MenuItem("Background-Size");
      this.c70.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "background-size:cover,contain,auto;\n");
      });
      this.c9 = new MenuItem("Font");
      this.c9.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "font-family:impact;\n                            font-size:xx-small,xx-large,x-small,smaller,small,medium,larger,large,x-large;\n                            font-size-adjust:200;\n                            font-stretch:ultra-expanded,ultra-condensed,semi-expanded,semi-condensed,extra-expanded,extra-condensed,condensed,expanded;\n                            font-style:oblique,normal,italic;\n                            font-weight:normal,lighter,bolder,bold,Any Number;\n");
      });
      this.c71 = new MenuItem("Color");
      this.c71.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "color:blueviolet;\n");
      });
      this.c72 = new MenuItem("Text-Align");
      this.c72.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-align:match-parent,start,right,left,end,center;\n");
      });
      this.c73 = new MenuItem("Text-Align-Last");
      this.c73.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-align-last:match-parent,start,right,left,end,center;\n");
      });
      this.c74 = new MenuItem("Text-Combine-Horizontal");
      this.c74.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-combine-horizontal:latin,digits,ascii-digits,alphanumeric,alpha,all;\n");
      });
      this.c75 = new MenuItem("Text-Decoration");
      this.c75.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-decoration:aqua;\n");
      });
      this.c76 = new MenuItem("Text-Decoration-Color");
      this.c76.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-decoration-color:aqua;\n");
      });
      this.c77 = new MenuItem("Text-Decoration-Line");
      this.c77.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-decoration-line:line-through,overline,underline;\n");
      });
      this.c78 = new MenuItem("Text-Decoration-Skip");
      this.c78.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-decoration-skip:spaces,objects,ink;\n");
      });
      this.c79 = new MenuItem("Text-Decoration-Style");
      this.c79.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-decoration-style:wavy,solid,double,dotted,dashed;\n");
      });
      this.c80 = new MenuItem("Text-Emphasis");
      this.c80.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-emphasis:aquamarine;\n");
      });
      this.c81 = new MenuItem("Text-Emphasis-Color");
      this.c81.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-emphasis-color:aquamarine;\n");
      });
      this.c82 = new MenuItem("Text-Emphasis-Position");
      this.c82.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-emphasis-position:right,left,below,above;\n");
      });
      this.c83 = new MenuItem("Text-Emphasis-Style");
      this.c83.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-emphasis-style:triangle,sesame,open,filled,double-circle,dot,circle;\n");
      });
      this.c84 = new MenuItem("Text-Height");
      this.c84.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-height:text-size,max-size,font-size,auto;\n");
      });
      this.c85 = new MenuItem("Text-Indent");
      this.c85.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-indent:hanging,each-line,calc;\n");
      });
      this.c86 = new MenuItem("Text-Justify");
      this.c86.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-justify:kashida,inter-word,inter-ideograph,inter-cluster,distribute,auto;\n");
      });
      this.c87 = new MenuItem("Text-Orientation");
      this.c87.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-orientation:vertical-right,upright,rotate-right,rotate-normal,rotate-left,auto;\n");
      });
      this.c88 = new MenuItem("Text-Overflow");
      this.c88.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-overflow:url,ellipsis-word,ellipsis,clip;\n");
      });
      this.c89 = new MenuItem("Text-Shadow");
      this.c89.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-shadow:3px 3px 5px green;\n");
      });
      this.c90 = new MenuItem("Text-Spacing");
      this.c90.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-spacing:space-start,space-end,trim-adjacent,space-adjacent,punctuation,ideograph-alpha,allow-end;\n");
      });
      this.c91 = new MenuItem("Text-Transform");
      this.c91.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-transform:uppercase,lowercase,fullwidth,fullsize-kana,capitalize;\n");
      });
      this.c92 = new MenuItem("Text-Underline-Position");
      this.c92.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-underline-position:below,auto,alphabetic;\n");
      });
      this.c93 = new MenuItem("Text-Wrap");
      this.c93.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-wrap:normal,avoid;\n");
      });
      this.c11 = new MenuItem("Margins");
      this.c11.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "//Please Select one only from (\"em,px,%\")\nmargin: em or % or px;\n                            margin-bottom:em or % or px;\n                            margin-left:em or % or px;\n                            margin-right:em or % or px;\n                            margin-top:em or % or px;\n");
      });
      this.c94 = new MenuItem("Border Color");
      this.c94.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "border:gray;\n");
      });
      this.c95 = new MenuItem("Border-Bottom");
      this.c95.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "border-bottom:red;\n");
      });
      this.c96 = new MenuItem("Border-Top");
      this.c96.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "border-top:;\n");
      });
      this.c97 = new MenuItem("Border-Right");
      this.c97.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "border-right:;\n");
      });
      this.c98 = new MenuItem("Border-Left");
      this.c98.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "border-left: ;\n");
      });
      this.c99 = new MenuItem("Border-Bottom-Color");
      this.c99.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "border-bottom-color: ;\n");
      });
      this.c100 = new MenuItem("Border-Top-Color");
      this.c100.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "border-top-color: ;\n");
      });
      this.c101 = new MenuItem("Border-Left-Color");
      this.c101.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "border-left-color: ;\n");
      });
      this.c102 = new MenuItem("Border-Right-Color");
      this.c102.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "border-right-color: ;\n");
      });
      this.c103 = new MenuItem("Border-Bottom-Left-Radius");
      this.c103.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "border-bottom-left-radius: px;\n");
      });
      this.c104 = new MenuItem("Border-Bottom-Left-Radius");
      this.c104.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "border-bottom-right-radius: px;\n");
      });
      this.c105 = new MenuItem("Border-Top-Left-Radius");
      this.c105.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "border-top-left-radius: px;\n");
      });
      this.c106 = new MenuItem("Border-Top-Right-Radius");
      this.c106.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "border-top-right-radius: px;\n");
      });
      this.c107 = new MenuItem("Border-Width");
      this.c107.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "border-width:thin,thick,medium ;\n");
      });
      this.c108 = new MenuItem("Border-Collapse");
      this.c108.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "border-collapse:separate,collapse ;\n");
      });
      this.c109 = new MenuItem("Border-Color");
      this.c109.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "border-color:gold ;\n");
      });
      this.c110 = new MenuItem("Border-Image");
      this.c110.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "border-image: ;\n");
      });
      this.c13 = new MenuItem("Paddings");
      this.c13.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "padding: em;\n                            padding-bottom: em;\n                            padding-left: em;\n                            padding-right: em;\n                            padding-top: em;\n");
      });
      this.c14 = new MenuItem("Alignment");
      this.c14.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "alignment-adjust:text-before-edge,text-after-edge,middle,mathematical,ideographic,hanging,central,before-edge,baseline,alphabetic,after-edge;\n                alignment-baseline:use-script,text-before-edge,text-after-edge,middle,mathematical,ideographic,hanging,central,before-edge,baseline,alphabetic,after-edge;\n                \n");
      });
      this.c15 = new MenuItem("Animation");
      this.c15.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "animation:linear,infinite,ease-out,ease-in-out,ease-in,ease,cubic-bezier,alternate;\n               animation-delay: s;\n               animation-direction:alternate,normal;\n               animation-duration: s;\n               animation-fill-mode:forwards,both,backwards;\n               animation-iteration-count:infinite ;//or //Number\n               animation-name: ;\n               animation-play-state:running,paused;\n");
      });
      this.c16 = new MenuItem("Appearance");
      this.c16.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "appearance:window,radio-button,menubar,menu-item,menu,hyperlink,dialog,desktop,combo-box,checkbox,button;\n                \n");
      });
      this.c17 = new MenuItem("Box");
      this.c17.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "box-shadow: aqua;  \n             box-sizing: border-box;  \n");
      });
      this.c18 = new MenuItem("Elevation");
      this.c18.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, " elevation:5deg;\n");
      });
      this.c19 = new MenuItem("Columns");
      this.c19.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "column-count: ;\n            column-fill:auto,balance;\n            column-gap: normal;\n            column-rule: black;\n            column-rule-color: aqua;\n            column-rule-style:solid,ridge,hidden,groove,double,dotted,dashed;\n            column-rule-width:thin,thick,medium;\n            column-span: all;\n            column-width:min-content,max-content,fit-content,fill-available;\n            columns: em;\n");
      });
      this.c20 = new MenuItem("Chrome And Safari");
      this.c20.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "-webkit-\n\n//write this tag then go to\ntransformation menu to select one.\nExample: -webkit-transform:rotate(100deg);\n");
      });
      this.c116 = new MenuItem("Internet Explorer");
      this.c116.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "-ms-\n\n//write this tag then go to\ntransformation menu to select one.\nExample: -ms-transform:rotate(100deg);\n");
      });
      this.c117 = new MenuItem("Mozilla FireFox");
      this.c117.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "-moz-\n\n//write this tag then go to\ntransformation menu to select one.\nExample: -moz-transform:rotate(100deg);\n");
      });
      this.c118 = new MenuItem("Opera");
      this.c118.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "-o-\n//write this tag then go to\ntransformation menu to select one.\nExample: -o-transform:rotate(100deg);\n");
      });
      this.tagg = new Menu("Browsers tags For Animations");
      this.tagg.getItems().addAll(new MenuItem[]{this.c20, this.c116, this.c117, this.c118});
      this.c21 = new MenuItem("Transform2D-Matrix");
      this.c21.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:matrix(<number>, <number>, <number>, <number>, <number>, <number>);\n");
      });
      this.c22 = new MenuItem("Transform2D-Translate");
      this.c22.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:translate(px,px);\n");
      });
      this.c23 = new MenuItem("Transform2D-TranslateX");
      this.c23.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:translateX(px);\n");
      });
      this.c24 = new MenuItem("Transform2D-TranslateY");
      this.c24.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:translateY(px);\n");
      });
      this.c25 = new MenuItem("Transform2D-Scale");
      this.c25.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:scale(<number>,<number>);\n");
      });
      this.c26 = new MenuItem("Transform2D-ScaleX");
      this.c26.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:scaleX(<number>);\n");
      });
      this.c27 = new MenuItem("Transform2D-ScaleY");
      this.c27.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:scaleY(<number>);\n");
      });
      this.c28 = new MenuItem("Transform2D-Rotate");
      this.c28.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:rotate(deg);\n");
      });
      this.c29 = new MenuItem("Transform2D-SkewX");
      this.c29.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:skewX(deg);\n");
      });
      this.c30 = new MenuItem("Transform2D-SkewY");
      this.c30.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:skewY(deg);\n");
      });
      this.c31 = new MenuItem("Transform3D-Matrix");
      this.c31.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:matrix3d(<number>,<number>,<number>,<number>,<number>,<number>,<number>,<number>,<number>,<number>,<number>,<number>,<number>,<number>,<number>,<number>);\n");
      });
      this.c32 = new MenuItem("Transform3D-Translate");
      this.c32.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:translate3d(px,px,px);\n");
      });
      this.c33 = new MenuItem("Transform3D-TranslateX");
      this.c33.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:translateX(px);\n");
      });
      this.c34 = new MenuItem("Transform3D-TranslateY");
      this.c34.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:translateY(px);\n");
      });
      this.c41 = new MenuItem("Transform3D-TranslateZ");
      this.c41.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:translateZ(px);\n");
      });
      this.c35 = new MenuItem("Transform3D-Scale");
      this.c35.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:scale3d(<number>,<number>,<number>);\n");
      });
      this.c36 = new MenuItem("Transform3D-ScaleX");
      this.c36.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:scaleX(<number>);\n");
      });
      this.c37 = new MenuItem("Transform3D-ScaleY");
      this.c37.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:scaleY(<number>);\n");
      });
      this.c42 = new MenuItem("Transform3D-ScaleZ");
      this.c42.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:scaleZ(<number>);\n");
      });
      this.c38 = new MenuItem("Transform3D-Rotate");
      this.c38.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:rotate3d(<number>,<number>,<number>,deg);\n");
      });
      this.c43 = new MenuItem("Transform3D-RotateX");
      this.c43.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:rotateX(deg);\n");
      });
      this.c44 = new MenuItem("Transform3D-RotateY");
      this.c44.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:rotateY(deg);\n");
      });
      this.c45 = new MenuItem("Transform3D-RotateZ");
      this.c45.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:rotateZ(deg);\n");
      });
      this.c39 = new MenuItem("Transform3D-SkewX");
      this.c39.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:skewX(deg);\n");
      });
      this.c40 = new MenuItem("Transform3D-SkewY");
      this.c40.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:skewY(deg);\n");
      });
      this.c46 = new MenuItem("Transform3D-Skew");
      this.c46.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transform:skew(deg,deg);\n");
      });
      this.c47 = new MenuItem("Transform3D-Perspective");
      this.c47.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "perspective(px);\n");
      });
      this.c48 = new MenuItem("Text-Direction");
      this.c48.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "direction:rtl or ltr;\n");
      });
      this.c111 = new MenuItem("Transition");
      this.c111.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transition:<‘transition-property’> || <‘transition-duration’> || <‘transition-timing-function’> || <‘transition-delay’> [, [<‘transition-property’> || <‘transition-duration’> || <‘transition-timing-function’> || <‘transition-delay’>]];\n");
      });
      this.c112 = new MenuItem("Transition-Delay");
      this.c112.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transition-delay:time in seconds s;\n");
      });
      this.c113 = new MenuItem("Transition-Duration");
      this.c113.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transition-duration:s;\n");
      });
      this.c114 = new MenuItem("Transition-Property");
      this.c114.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transition-property:none | all | [ <IDENT> ];\n");
      });
      this.c115 = new MenuItem("Transition-Timing-Function");
      this.c115.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "transition-timing-function:ease | linear | ease-in | ease-out | ease-in-out | cubic-bezier(<number>, <number>, <number>, <number>), step-start | step-end | steps(<number>[, start | end ];\n");
      });
      this.c49 = new MenuItem("Text-Combine-Horizontal");
      this.c49.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-combine-horizontal:Select one only:none | all | [ [digits <integer> | ascii-digits <integer> ] || [ alpha <integer> | latin <integer> ] || alphanumeric <integer> ];\n");
      });
      this.c50 = new MenuItem("Caption-Side");
      this.c50.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "caption-side:before or after;\n");
      });
      this.c51 = new MenuItem("Column-Width");
      this.c51.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "column-width:‘min-content’ | ‘max-content’ | ‘fill-available’ | ‘fit-content’;\n");
      });
      this.c52 = new MenuItem("Text-Combine-Mode");
      this.c52.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-combine-mode:auto | compress | [ no-compress || use-glyphs;\n");
      });
      this.c53 = new MenuItem("Text-Orientation");
      this.c53.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "text-orientation:upright-right | upright | sideways-right | sideways-left | sideways | use-glyph-orientation;\n");
      });
      this.c54 = new MenuItem("Unicode-Bidi");
      this.c54.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "unicode-bidi:normal | embed | [ isolate || bidi-override ] | plaintext;\n");
      });
      this.c55 = new MenuItem("Writing-Mode");
      this.c55.setOnAction((h) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "writing-mode:horizontal-tb | vertical-rl | vertical-lr;\n");
      });
      j1 = new MenuItem("Create Function!");
      j1.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "function Function_Name ( ) {\n\n//Write Your Code Here!\n\n}\n");
      });
      j2 = new MenuItem("GetElement ByID");
      j2.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "document.getElementById(\"\").value=\"\";\n");
      });
      j3 = new MenuItem("GetElements ByClassName");
      j3.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "document.getElementsByClassName(\"\").innerHTML=\"\";\n");
      });
      j4 = new MenuItem("GetElements ByTagName");
      j4.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "document.getElementsByTagName(\"\").innerHTML=\"\";\n");
      });
      j5 = new MenuItem("Query Selector");
      j5.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "document.querySelectorAll(\"\");\n");
      });
      j6 = new MenuItem("Integer Variable");
      j6.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var Var_Name= ;\n");
      });
      j7 = new MenuItem("String Variable");
      j7.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var Var_Name=\" \";\n");
      });
      j8 = new MenuItem("Alert");
      j8.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "window.alert();\n");
      });
      j9 = new MenuItem("Write");
      j9.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "document.write();\n");
      });
      j10 = new MenuItem("Console");
      j10.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "console.log();\n");
      });
      j11 = new MenuItem("Single Line Comment");
      j11.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "// Write your comment!\n");
      });
      j12 = new MenuItem("Multi-Line Comment");
      j12.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "/*\nWrite your comment here\n*/\n");
      });
      j13 = new MenuItem("OnChange Event (Function)");
      j13.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "onchange=\"\"\n");
      });
      j14 = new MenuItem("OnClick Event (Function)");
      j14.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "onclick=\"\"\n");
      });
      j15 = new MenuItem("OnMouseOver Event (Function)");
      j15.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "onmouseover=\"\"\n");
      });
      j16 = new MenuItem("OnMouseOut Event (Function)");
      j16.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "onmouseout=\"\"\n");
      });
      j17 = new MenuItem("OnKeyDown Event (Function)");
      j17.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "onkeydown=\"\"\n");
      });
      j18 = new MenuItem("OnLoad Event (Function)");
      j18.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "onload=\"\"\n");
      });
      j19 = new MenuItem("OnChange Event (Code)");
      j19.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "onchange=''\n");
      });
      j20 = new MenuItem("OnClick Event (Code)");
      j20.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "onclick=''\n");
      });
      j21 = new MenuItem("OnMouseOver Event (Code)");
      j21.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "onmouseover=''\n");
      });
      j22 = new MenuItem("OnMouseOut Event (Code)");
      j22.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "onmouseout=''\n");
      });
      j23 = new MenuItem("OnKeyDown Event (Code)");
      j23.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "onkeydown=''\n");
      });
      j24 = new MenuItem("OnLoad Event (Code)");
      j24.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "onload=''\n");
      });
      j25 = new MenuItem("String Length");
      j25.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var String_name_1=String_Name_2.length;\n");
      });
      j26 = new MenuItem("Find a String In a String (FIRST)");
      j26.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var String_name_1=String_Name_2.indexOf(\"word\");\n");
      });
      j27 = new MenuItem("Find a String In a String (LAST)");
      j27.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var String_name_1=String_Name_2.lastIndexOf(\"word\");\n");
      });
      j28 = new MenuItem("Search For a String In a String");
      j28.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var String_name_1=String_Name_2.search(\"word\");\n");
      });
      j29 = new MenuItem("Slice Method");
      j29.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var String_name_1=String_Name_2.slice(start,end);\n");
      });
      j30 = new MenuItem("SubString Method");
      j30.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var String_name_1=String_Name_2.substring(start,end);\n");
      });
      j31 = new MenuItem("SubStr Method");
      j31.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var String_name_1=String_Name_2.substr(start,length);\n");
      });
      j32 = new MenuItem("Replace text");
      j32.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var String_name_1=String_Name_2.replace(\"\",\"\");\n");
      });
      j33 = new MenuItem("To UpperCase Method");
      j33.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var String_name_1=String_Name_2.toUpperCase();\n");
      });
      j34 = new MenuItem("To LowerCase Method");
      j34.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var String_name_1=String_Name_2.toLowerCase();\n");
      });
      j35 = new MenuItem("Concat Method");
      j35.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var String_name_1=String_Name_2.concat(\"\",\"\");\n");
      });
      j36 = new MenuItem("CharAt Method");
      j36.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "String_Name.charAt(number);\n");
      });
      j37 = new MenuItem("CharCodeAt Method");
      j37.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "String_Name.charCodeAt(number);\n");
      });
      j38 = new MenuItem("Convert an Integer To a String");
      j38.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Integer_Name.toString();\n");
      });
      j39 = new MenuItem("ToExponential Method");
      j39.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Integer_Name.toExponential(Number of integers after the point.);\n");
      });
      j40 = new MenuItem("ToFixed Method");
      j40.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Integer_Name.toFixed(Number of integers after the point.);\n");
      });
      j41 = new MenuItem("ToPrecision Method");
      j41.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Integer_Name.toPrecision(Length or Number of integers after the point-1.);\n");
      });
      j42 = new MenuItem("ValueOf Method");
      j42.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Integer_Name.valueOf();\n");
      });
      j43 = new MenuItem("Number Method");
      j43.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Integer_Name.Number(Integer_Name);\n");
      });
      j44 = new MenuItem("ParseInt Method");
      j44.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "parseInt(\"\");\n");
      });
      j45 = new MenuItem("ParseFloat Method");
      j45.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "parseFloat(\"\");\n");
      });
      j46 = new MenuItem("MAX_VALUE Method");
      j46.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Integer_Name.MAX_VALUE;\n");
      });
      j47 = new MenuItem("MIN_VALUE Method");
      j47.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Integer_Name.MIN_VALUE;\n");
      });
      j48 = new MenuItem("NEGATIVE_INFINITY Method");
      j48.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Integer_Name.NEGATIVE_INFINITY;\n");
      });
      j49 = new MenuItem("NaN Method");
      j49.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Integer_Name.NaN;\n");
      });
      j50 = new MenuItem("POSITIVE_INFINITY Method");
      j50.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Integer_Name.POSITIVE_INFINITY;\n");
      });
      j51 = new MenuItem("Split Method");
      j51.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "String_Name.split(\"\");\n");
      });
      j52 = new MenuItem("Min");
      j52.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.min();\n");
      });
      j53 = new MenuItem("Max");
      j53.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.max();\n");
      });
      j54 = new MenuItem("Random");
      j54.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.random();\n");
      });
      j55 = new MenuItem("Round");
      j55.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.round();\n");
      });
      j56 = new MenuItem("Ceil");
      j56.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.ceil();\n");
      });
      j57 = new MenuItem("Floor");
      j57.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.floor();\n");
      });
      j58 = new MenuItem("ABS");
      j58.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.abs();\n");
      });
      j59 = new MenuItem("aSin");
      j59.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.asin();\n");
      });
      j60 = new MenuItem("aCos");
      j60.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.acos();\n");
      });
      j61 = new MenuItem("aTan");
      j61.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.atan();\n");
      });
      j62 = new MenuItem("aTan2");
      j62.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.atan2(,);\n");
      });
      j63 = new MenuItem("Sin");
      j63.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.sin();\n");
      });
      j64 = new MenuItem("Cos");
      j64.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.cos();\n");
      });
      j65 = new MenuItem("Tan");
      j65.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.tan();\n");
      });
      j66 = new MenuItem("EXP");
      j66.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.exp();\n");
      });
      j67 = new MenuItem("Log");
      j67.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.log();\n");
      });
      j68 = new MenuItem("Sqrt");
      j68.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.sqrt();\n");
      });
      j69 = new MenuItem("Power");
      j69.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.pow(,);\n");
      });
      j70 = new MenuItem("Euler's Number");
      j70.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.E\n");
      });
      j71 = new MenuItem("PI");
      j71.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.PI\n");
      });
      j72 = new MenuItem("Square root of 2");
      j72.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.SQRT2\n");
      });
      j73 = new MenuItem("Square root of 1/2");
      j73.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.SQRT1_2\n");
      });
      j74 = new MenuItem("Natural Logarithm of 2");
      j74.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.LN2\n");
      });
      j75 = new MenuItem("Natural Logarithm of 10");
      j75.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.LN10\n");
      });
      j76 = new MenuItem("Base 2 Logarithm of E");
      j76.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.LOG2E\n");
      });
      j77 = new MenuItem("Base 10 Logarithm of E");
      j77.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Math.LOG10E\n");
      });
      j78 = new MenuItem("Display Date");
      j78.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\n");
      });
      j79 = new MenuItem("getDate");
      j79.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.getDate();\n");
      });
      j80 = new MenuItem("getDay");
      j80.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.getDay();\n");
      });
      j81 = new MenuItem("getFullYear");
      j81.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.getFullYear();\n");
      });
      j82 = new MenuItem("getHours");
      j82.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.getHours();\n");
      });
      j83 = new MenuItem("getMilliseconds");
      j83.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.getMilliseconds();\n");
      });
      j84 = new MenuItem("getMinutes");
      j84.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.getMinutes();\n");
      });
      j85 = new MenuItem("getMonth");
      j85.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.getMonth();\n");
      });
      j86 = new MenuItem("getSeconds");
      j86.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.getSeconds();\n");
      });
      j87 = new MenuItem("getTime");
      j87.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.getTime();\n");
      });
      j88 = new MenuItem("setDate");
      j88.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.setDate();\n");
      });
      j89 = new MenuItem("setFullYear");
      j89.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.setFullYear();\n");
      });
      j90 = new MenuItem("setHours");
      j90.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.setHours();\n");
      });
      j91 = new MenuItem("setMilliseconds");
      j91.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.setMilliseconds();\n");
      });
      j92 = new MenuItem("setMinutes");
      j92.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.setMinutes();\n");
      });
      j93 = new MenuItem("setMonth");
      j93.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.setMonth();\n");
      });
      j94 = new MenuItem("setSeconds");
      j94.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.setSeconds();\n");
      });
      j95 = new MenuItem("setTime");
      j95.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.setTime();\n");
      });
      j96 = new MenuItem("getUTCDate");
      j96.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.getUTCDate();\n");
      });
      j97 = new MenuItem("getUTCDay");
      j97.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.getUTCDay();\n");
      });
      j98 = new MenuItem("getUTCFullYear");
      j98.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.getUTCFullYear();\n");
      });
      j99 = new MenuItem("getUTCHours");
      j99.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.getUTCHours();\n");
      });
      j100 = new MenuItem("getUTCMilliseconds");
      j100.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.getUTCMilliseconds();\n");
      });
      j101 = new MenuItem("getUTCMinutes");
      j101.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.getUTCMinutes();\n");
      });
      j102 = new MenuItem("getUTCMonth");
      j102.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.getUTCMonth();\n");
      });
      j103 = new MenuItem("getUTCSeconds");
      j103.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=new Date();\ndateofme.getUTCSeconds();\n");
      });
      j104 = new MenuItem("Date Parse");
      j104.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var dateofme=Date.parse();\n");
      });
      j105 = new MenuItem("Boolean");
      j105.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Boolean();\n");
      });
      j106 = new MenuItem("Create an Array");
      j106.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var array1=[];\n");
      });
      j107 = new MenuItem("Convert Arrays to Strings");
      j107.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Array_Name.toString();\n");
      });
      j108 = new MenuItem("Join Method");
      j108.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Array_Name.join();\n");
      });
      j109 = new MenuItem("POP Method (Remove Element)");
      j109.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Array_Name.pop();\n");
      });
      j110 = new MenuItem("PUSH Method (Add Element)");
      j110.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Array_Name.push();\n");
      });
      j111 = new MenuItem("Shift Method");
      j111.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Array_Name.shift();\n");
      });
      j112 = new MenuItem("UnShift Method");
      j112.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Array_Name.unshift();\n");
      });
      j113 = new MenuItem("Change an Element");
      j113.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Array_Name[number]=value;\n");
      });
      j114 = new MenuItem("Append an Element");
      j114.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Array_Name[Array_Name.length]=value;\n");
      });
      j115 = new MenuItem("Delete an Element");
      j115.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "delete Array_Name[number];\n");
      });
      j116 = new MenuItem("Splice Method (Add Elements with specified Places");
      j116.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Array_Name.splice();\n");
      });
      j117 = new MenuItem("Splice Method (Remove an Element with specified place");
      j117.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Array_Name.splice();\n");
      });
      j118 = new MenuItem("Concat Method");
      j118.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Array_Name.concat(Another_Array_Name);\n");
      });
      j119 = new MenuItem("Slice Method");
      j119.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Array_Name.slice(number);\n");
      });
      j120 = new MenuItem("Sort Method");
      j120.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Array_Name.sort();\n");
      });
      j121 = new MenuItem("Reverse Method");
      j121.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "Array_Name.reverse();\n");
      });
      j122 = new MenuItem("If");
      j122.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "if (condition) {\nWrite what will happen if true\n}\n");
      });
      j123 = new MenuItem("If...ELSE");
      j123.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "if (//condition) {\nWrite what will happen if true\n}\nelse {\nWrite what will happen if false\n}\n");
      });
      j124 = new MenuItem("IF...ELSEIF...ELSE");
      j124.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "if (condition) {\nWrite what will happen if true\n}\nelse if (condition) {\nWrite what will happen if true\n}\n//Write any number of 'Else If' that you want\nelse {\nWrite what will happen if false\n}\n");
      });
      j125 = new MenuItem("?:");
      j125.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "(Condition)? if true : if false\n");
      });
      j126 = new MenuItem("Switch");
      j126.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "switch (Expression) {\ncase n:\n//Your Code\nbreak;\ncase n:\n//Your Code\nbreak;\n//Write any number of 'case' you want\ndefault:\nCode Of Default Block\n}\n");
      });
      j127 = new MenuItem("For");
      j127.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "for (initialization ; condition ; decrement or increment ;) {\n//Code\n}\n");
      });
      j128 = new MenuItem("For/in");
      j128.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "for (variable in Property) {\n//Code\n}\n");
      });
      j129 = new MenuItem("While");
      j129.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "while (Condition) {\n//Code\n}\n");
      });
      j130 = new MenuItem("Do...While");
      j130.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "do {\n//Code\n}\nwhile (Condition);\n");
      });
      j131 = new MenuItem("Try...Catch");
      j131.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "try {\n//Block of code to try\n}\ncatch (Error) {\n//Block of code to handle errors\n}\nfinally {\n//Block of code to be executed regardless of the try/catch result\n}\n");
      });
      j132 = new MenuItem("Throw Exception");
      j132.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "throw variable;\n");
      });
      j133 = new MenuItem("Strict Mode");
      j133.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "\"use strict\";\n");
      });
      j134 = new MenuItem("JSON Array");
      j134.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "\"\": [{\"\":\"\"}]\n");
      });
      j135 = new MenuItem("Form Validation (Write it with HTML Input)");
      j135.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "required\n");
      });
      j136 = new MenuItem("Create Cookie");
      j136.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "document.cookie=\"username=Ahmed Elkady;expires=Sun, 05 Jan 2020 12:00:00 UTC;path=c:/users/\";\n");
      });
      j137 = new MenuItem("Modify Cookie");
      j137.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "document.cookie=\"Modify Info\";\n");
      });
      j138 = new MenuItem("Delete Cookie");
      j138.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "document.cookie=\"Change Date (Expired Date)\";\n");
      });
      j139 = new MenuItem("Read Cookie");
      j139.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "var name=cname+\"=\";\nvar ca=document.cookie.split(';');\nfor (var i=0;i<ca.length;i++) {\nvar c=ca[i];\nwhile (c.charAt(0)=='') {\nc =c.substring (1);\n}\nif (c.indexOf(name)==0) {\nreturn\nc.substring(name.length,c.length);\n}\n}\nreturn\"\";\n\n");
      });
      j140 = new MenuItem("Alert Box");
      j140.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "window.alert();\n");
      });
      j141 = new MenuItem("Confirm Box");
      j141.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "window.confirm();\n");
      });
      j142 = new MenuItem("Prompt Box");
      j142.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "window.prompt();\n");
      });
      j143 = new MenuItem("Navigator Cookie Enabled");
      j143.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "navigator.cookieEnabled;\n");
      });
      j144 = new MenuItem("Browser Name");
      j144.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "navigator.appName;\nnavigator.appCodeName;\n");
      });
      j145 = new MenuItem("Browser Engine");
      j145.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "navigator.product;\n");
      });
      j146 = new MenuItem("Browser Version 1");
      j146.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "navigator.appVersion;\n");
      });
      j147 = new MenuItem("Browser Version 2");
      j147.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "navigator.userAgent;\n");
      });
      j148 = new MenuItem("Browser Platform");
      j148.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "navigator.platform;\n");
      });
      j149 = new MenuItem("Browser Language");
      j149.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "navigator.language;\n");
      });
      j150 = new MenuItem("Java Enabled Or No");
      j150.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "navigator.javaEnabled();\n");
      });
      j151 = new MenuItem("History Back");
      j151.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "window.history.back();\n");
      });
      j152 = new MenuItem("History Forward");
      j152.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "window.history.forward();\n");
      });
      j153 = new MenuItem("Window Location Href");
      j153.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "window.location.href;\n");
      });
      j154 = new MenuItem("Window Location HostName");
      j154.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "window.location.hostname;\n");
      });
      j155 = new MenuItem("Window Location PathName");
      j155.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "window.location.pathname;\n");
      });
      j156 = new MenuItem("Window Location Protocol");
      j156.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "window.location.protocol;\n");
      });
      j157 = new MenuItem("Window Location Assign");
      j157.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "window.location.assign(\"New URL To Load\");\n");
      });
      j158 = new MenuItem("Get Screen Width");
      j158.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "screen.width;\n");
      });
      j159 = new MenuItem("Get Screen Height");
      j159.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "screen.height;\n");
      });
      j160 = new MenuItem("Get Screen Available Width");
      j160.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "screen.availWidth;\n");
      });
      j161 = new MenuItem("Get Screen Available Height");
      j161.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "screen.availHeight;\n");
      });
      j162 = new MenuItem("Get Screen Color Depth");
      j162.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "screen.colorDepth;\n");
      });
      j163 = new MenuItem("Get Screen Pixel Depth");
      j163.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "screen.pixelDepth\n");
      });
      j164 = new MenuItem("Browser Window Width");
      j164.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "window.innerWidth;\ndocument.body.clientWidth;\n");
      });
      j165 = new MenuItem("Browser Window Height");
      j165.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "window.innerHeight;\ndocument.body.clientHeight;\n");
      });
      j166 = new MenuItem("Open a New Window Method");
      j166.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "window.open();\n");
      });
      j167 = new MenuItem("Close The Current Window");
      j167.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "window.close();\n");
      });
      j168 = new MenuItem("Move The Current Window");
      j168.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "window.moveTo();\n");
      });
      j169 = new MenuItem("Resize The Current Window");
      j169.setOnAction((hk) -> {
         int pos = this.codeArea.getCaretPosition();
         this.codeArea.insertText(pos, "window.resizeTo();\n");
      });
      
      
      
      
      
       
      this.gethtml = new MenuItem("Get HTML…");
this.gethtml.setOnAction((hk) -> {

    Stage stage = new Stage();

    // Modern Input Field
    JFXTextField urlField = new JFXTextField("https://");
    urlField.setMinWidth(350);
    urlField.setMinHeight(50);
    urlField.setLabelFloat(true);
    urlField.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 15));
    urlField.setTooltip(new Tooltip("⚡ أدخل رابط يبدأ بـ 'https://'"));
    urlField.setStyle(
        "-fx-background-color: #FFFFFF;" +
        "-fx-background-radius: 12;" +
        "-fx-border-radius: 12;" +
        "-fx-border-color: #4C9AFF;" +
        "-fx-border-width: 1.5;" +
        "-fx-padding: 0 12 0 12;"
    );

    // Modern Button
    JFXButton downloadButton = new JFXButton("⬇ Download & Save HTML");
    downloadButton.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
    downloadButton.setPrefSize(250, 50);
    downloadButton.setButtonType(JFXButton.ButtonType.RAISED);
    downloadButton.setStyle(
        "-fx-background-color: linear-gradient(to right, #4C9AFF, #6A5ACD);" +
        "-fx-text-fill: white;" +
        "-fx-background-radius: 25;" +
        "-fx-cursor: hand;"
    );
    downloadButton.setEffect(new DropShadow(12, Color.rgb(0, 0, 0, 0.25)));

    // Download Action
    downloadButton.setOnAction(e -> {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Text File", "*.txt"));
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            String urlText = urlField.getText();
            try {
                u = new URL(urlText);
                urlc = u.openConnection();

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
                     PrintWriter writer = new PrintWriter(new FileWriter(file))) {

                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.println(line);
                    }

                }
                stage.close();
            } catch (IOException ex) {
                new Alert(Alert.AlertType.ERROR, "❌ Failed to download HTML!").showAndWait();
                ex.printStackTrace();
            }
        }
    });

    // Layout
    VBox root = new VBox(25, urlField, downloadButton);
    root.setPadding(new Insets(30));
    root.setAlignment(Pos.CENTER);
    root.setStyle(
        "-fx-background-color: linear-gradient(to bottom, #F9FAFB, #EAEFF5);" +
        "-fx-background-radius: 18;"
    );
    root.setEffect(new DropShadow(20, Color.rgb(0, 0, 0, 0.10)));

    Scene scene = new Scene(root, 520, 240);
    scene.getStylesheets().add(getClass().getResource(app_theme).toExternalForm());

    stage.setScene(scene);
    stage.setTitle("🌐 Download HTML");
    stage.setResizable(false);
    stage.centerOnScreen();
    stage.setAlwaysOnTop(true);
    stage.show();
});
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      this.ele = new Menu("Get Elements");
      this.ele.getItems().addAll(new MenuItem[]{j2, j3, j4, j5});
      this.one = new Menu("Structure Statements");
      this.one.getItems().addAll(new MenuItem[]{j122, j123, j124, j125, j126, j127, j128, j129, j130});
      this.two = new Menu("Exceptions");
      this.two.getItems().addAll(new MenuItem[]{j131, j132});
      this.three = new Menu("Important Services1");
      this.three.getItems().addAll(new MenuItem[]{j140, j141, j142, j143, j144, j145, j146, j147, j148, j149, j150, j151, j152, j153, j154});
      this.four = new Menu("Important Services2");
      this.four.getItems().addAll(new MenuItem[]{j155, j156, j157, j158, j159, j160, j161, j162, j163, j164, j165, j166, j167, j168, j169});
      this.var = new Menu("Variables");
      this.var.getItems().addAll(new MenuItem[]{j6, j7});
      this.cook = new Menu("Cookies");
      this.cook.getItems().addAll(new MenuItem[]{j136, j137, j138, j139});
      this.tim = new Menu("Timing Events");
      this.tim.getItems().addAll(new MenuItem[0]);
      this.gett = new Menu("Getter");
      this.gett.getItems().addAll(new MenuItem[]{j79, j80, j81, j82, j83, j84, j85, j86, j87});
      this.sett = new Menu("Setter");
      this.sett.getItems().addAll(new MenuItem[]{j88, j89, j90, j91, j92, j93, j94, j95, j104});
      this.utc = new Menu("UTC Formats");
      this.utc.getItems().addAll(new MenuItem[]{j96, j97, j98, j99, j100, j101, j102, j103});
      this.out = new Menu("Output");
      this.out.getItems().addAll(new MenuItem[]{j8, j9, j10});
      this.commm = new Menu("Comments");
      this.commm.getItems().addAll(new MenuItem[]{j11, j12});
      this.eve = new Menu("Events");
      this.eve.getItems().addAll(new MenuItem[]{j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24});
      this.strings = new Menu("String Methods");
      this.strings.getItems().addAll(new MenuItem[]{j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, j37, j51});
      this.numbers = new Menu("Number Methods");
      this.numbers.getItems().addAll(new MenuItem[]{j38, j39, j40, j41, j42, j43, j44, j45, j46, j47, j48, j49, j50});
      this.cons = new Menu("Constants");
      this.cons.getItems().addAll(new MenuItem[]{j70, j71, j72, j73, j74, j75, j76, j77});
      this.maths = new Menu("Math");
      this.maths.getItems().addAll(new MenuItem[]{j52, j53, j54, j55, j56, j57, j58, j59, j60, j61, j62, j63, j64, j65, j66, j67, j68, j69, this.cons});
      this.dates = new Menu("Dates");
      this.dates.getItems().addAll(new MenuItem[]{j78});
      this.dateformats = new Menu("Arrays");
      this.dateformats.getItems().addAll(new MenuItem[]{j106, j107, j108, j109, j110, j111, j112, j113, j114, j115, j116, j117, j118, j119, j120, j121});
      this.datemethods = new Menu("Date Methods");
      this.datemethods.getItems().addAll(new MenuItem[]{this.sett, this.gett, this.utc});
      this.js = new Menu("Java Script");
      this.js.getItems().addAll(new MenuItem[]{j1, this.ele, this.var, this.out, this.commm, this.strings, this.numbers, this.eve, this.maths, this.dates, this.datemethods, j105, this.dateformats, this.one, this.two, j133, j134, j135, this.cook, this.three, this.four});
      this.men1 = new Menu("Writing-Modes");
      this.men1.getItems().addAll(new MenuItem[]{this.c48, this.c49, this.c50, this.c51, this.c52, this.c53, this.c54, this.c55});
      this.men2 = new Menu("Transformations-3D");
      this.men2.getItems().addAll(new MenuItem[]{this.c47, this.c31, this.c32, this.c33, this.c34, this.c41, this.c35, this.c36, this.c37, this.c42, this.c38, this.c43, this.c44, this.c45, this.c39, this.c40, this.c46});
      this.men3 = new Menu("Transformations-2D");
      this.men3.getItems().addAll(new MenuItem[]{this.c21, this.c22, this.c23, this.c24, this.c25, this.c26, this.c27, this.c28, this.c29, this.c30});
      this.men4 = new Menu("Background");
      this.men4.getItems().addAll(new MenuItem[]{this.c61, this.c62, this.c63, this.c64, this.c65, this.c66, this.c67, this.c68, this.c69, this.c70});
      this.men5 = new Menu("Text");
      this.men5.getItems().addAll(new MenuItem[]{this.c71, this.c72, this.c73, this.c74, this.c75, this.c76, this.c77, this.c78, this.c79, this.c80, this.c81, this.c82, this.c83, this.c84, this.c85, this.c86, this.c87, this.c88, this.c89, this.c90, this.c91, this.c92, this.c93});
      this.men6 = new Menu("Borders");
      this.men6.getItems().addAll(new MenuItem[]{this.c94, this.c95, this.c96, this.c97, this.c98, this.c99, this.c100, this.c101, this.c102, this.c103, this.c104, this.c105, this.c106, this.c107, this.c108, this.c109, this.c110});
      this.men7 = new Menu("Transitions");
      this.men7.getItems().addAll(new MenuItem[]{this.c111, this.c112, this.c113, this.c114, this.c115});
      this.m6 = new Menu("CSS");
      this.m6.getItems().addAll(new MenuItem[]{this.cs1, this.c2, this.c3, this.c4, this.c5, this.c6, this.c7, this.c9, this.c11, this.c13, this.c14, this.c15, this.c16, this.c17, this.c18, this.c19, this.tagg, this.men6, this.men7, this.men5, this.men4, this.men3, this.men2, this.men1});
      this.it2 = new MenuItem("Save");
      this.it2.setStyle("-fx-font-size:13;");
      this.it2.setOnAction((sd) -> {
         String FullPathh = htmltab.getText();
         String codeee = this.codeArea.getText();

         try {
            PrintWriter pw = new PrintWriter(new FileWriter(FullPathh));
            pw.println();
            pw.print(codeee+"\n");
//            pw.print("<style>\n" +
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
//"        </div>"
//                    + "<script data-name=\"BMC-Widget\" data-cfasync=\"false\" src=\"https://cdnjs.buymeacoffee.com/1.0.0/widget.prod.min.js\" data-id=\"Kadysoft\" data-description=\"Support me on Buy me a coffee!\" data-message=\"\" data-color=\"#ff813f\" data-position=\"Right\" data-x_margin=\"18\" data-y_margin=\"18\"></script>\n" +
//"  </footer>\n" +
//"</body>");
            pw.close();
         } catch (IOException var5) {
            Logger.getLogger(HTMLEditor_Old.class.getName()).log(Level.SEVERE, (String)null, var5);
         }

      });
      
      
     
      this.it3 = new MenuItem("Run In Browser");
      this.it3.setStyle("-fx-font-size:13;");
      this.it3.setOnAction((sd) -> {
          
          
            
                 
                  
                  
        if (tabpane.isVisible()==true) {
           
         
         String vovo=codeArea.getText();
         if (vovo.contains("</html>")) {
             //Open
             
             String FullPath = htmltab.getText();
         Desktop des = Desktop.getDesktop();

         try {
            des.open(new File(FullPath));
         } catch (IOException var4) {
            Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var4);
         }
         }
         
         else {
             
             //Noti
      Notifications noti = Notifications.create();
      noti.title("Fatal Error!");
      noti.text("Selected file isn't html file or empty or doesn't have <html> tag to preview in browser.");
      noti.position(Pos.CENTER);
      noti.showError();
         }
        
       
         
         
         
           
       }
       
       else {
           
           String vovo=codeArea.getText();
         if (vovo.contains("</html>")) {
             
                   
         TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
         String FullPathh = selectedItem.getValue().toString();
        
         
         Desktop des = Desktop.getDesktop();

         try {
            des.open(new File(FullPathh));
         } catch (IOException var4) {
            Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var4);
         }
             
         } 
         
         else {
             
      Notifications noti = Notifications.create();
      noti.title("Fatal Error!");
      noti.text("Selected file isn't html file or empty or doesn't have <html> tag to preview in browser.");
      noti.position(Pos.CENTER);
      noti.showError();
             
         }
            
      
         
         
           
       }        
                  
         
         
         

      });
      
      
      
      
      
      this.it4 = new MenuItem("Exit");
      this.it4.setStyle("-fx-font-size:13;");
      this.it4.setOnAction((sd) -> {
         Alert alertio = new Alert(Alert.AlertType.CONFIRMATION);
alertio.setTitle("Close!");
alertio.setHeaderText("Exit Eagle Editor");
alertio.setContentText("Are you sure you wanna exit?");
ButtonType buttonTypeOne = new ButtonType("Yes");
ButtonType buttonTypetwo = new ButtonType("No");
alertio.getButtonTypes().setAll(buttonTypeOne, buttonTypetwo);
DialogPane dialogPaneii = alertio.getDialogPane();
dialogPaneii.getStylesheets().add(getClass().getResource(app_theme).toExternalForm());
Optional<ButtonType> results = alertio.showAndWait();


if (results.isPresent() && results.get() == buttonTypeOne) {
    
   //System.exit(0);
   Stage stage = (Stage) barr.getScene().getWindow();
   stage.close(); // ✅ Closes just this window
    
}
  

else if (results.isPresent() && results.get() == buttonTypetwo) {
    
    sd.consume();
        
}


else {

    
    
}

      });
      this.it8 = new MenuItem("Cut");
      this.it8.setStyle("-fx-font-size:13;");
      this.it8.setOnAction((sd) -> {
         this.codeArea.cut();
      });
      this.it9 = new MenuItem("Copy");
      this.it9.setStyle("-fx-font-size:13;");
      this.it9.setOnAction((sd) -> {
         this.codeArea.copy();
      });
      this.it10 = new MenuItem("Paste");
      this.it10.setStyle("-fx-font-size:13;");
      this.it10.setOnAction((sd) -> {
         this.codeArea.paste();
      });
      this.it11 = new MenuItem("Undo");
      this.it11.setStyle("-fx-font-size:13;");
      this.it11.setOnAction((sd) -> {
         this.codeArea.undo();
      });
      this.it12 = new MenuItem("Redo");
      this.it12.setStyle("-fx-font-size:13;");
      this.it12.setOnAction((sd) -> {
         this.codeArea.redo();
      });
      this.it13 = new MenuItem("Select All");
      this.it13.setStyle("-fx-font-size:13;");
      this.it13.setOnAction((sd) -> {
         this.codeArea.selectAll();
      });
      this.it14 = new MenuItem("Clear");
      this.it14.setStyle("-fx-font-size:13;");
      this.it14.setOnAction((sd) -> {
         this.codeArea.clear();
      });
      
    


it1477 = new MenuItem("Find and Replace");
it1477.setStyle("-fx-font-size: 13;");
it1477.setOnAction((sd) -> {
    Stage dialog = new Stage();

    JFXTextField findField = new JFXTextField();
    findField.setPromptText("Find What?");
    //findField.setStyle("-fx-font-size:15; -fx-text-fill: white;");
    findField.setLabelFloat(true);

    JFXTextField replaceField = new JFXTextField();
    replaceField.setPromptText("Replace With...");
    //replaceField.setStyle("-fx-font-size:15; -fx-text-fill: white;");
    replaceField.setLabelFloat(true);

    JFXCheckBox matchCase = new JFXCheckBox("Match Case");
    matchCase.setStyle("-fx-text-fill: black;");

    JFXCheckBox wholeWord = new JFXCheckBox("Whole Word");
    wholeWord.setStyle("-fx-text-fill: black;");

    Label matchCountLabel = new Label("Matches: 0");
    matchCountLabel.setStyle("-fx-text-fill: green;");

    JFXButton findBtn = new JFXButton("Find All");
    //findBtn.setStyle("-fx-background-color: #1E90FF; -fx-text-fill: white; -fx-font-size: 15;");

    JFXButton nextBtn = new JFXButton("Next");
    //nextBtn.setStyle("-fx-background-color: #DAA520; -fx-text-fill: black; -fx-font-size: 15;");

    JFXButton prevBtn = new JFXButton("Previous");
    //prevBtn.setStyle("-fx-background-color: #FF8C00; -fx-text-fill: black; -fx-font-size: 15;");

    JFXButton replaceBtn = new JFXButton("Replace All");
    //replaceBtn.setStyle("-fx-background-color: #32CD32; -fx-text-fill: white; -fx-font-size: 15;");

    // Function to find all matches
    Runnable findMatches = () -> {
        matchRanges.clear();
        currentMatchIndex = -1;

        String content = codeArea.getText();
        String target = findField.getText();
        if (target.isEmpty()) return;

        String pattern = Pattern.quote(target);
        if (wholeWord.isSelected()) pattern = "\\b" + pattern + "\\b";

        Pattern regex = matchCase.isSelected() ?
            Pattern.compile(pattern) :
            Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);

        Matcher matcher = regex.matcher(content);
        while (matcher.find()) {
            matchRanges.add(new IndexRange(matcher.start(), matcher.end()));
        }

        matchCountLabel.setText("Matches: " + matchRanges.size());

        if (!matchRanges.isEmpty()) {
            currentMatchIndex = 0;
            IndexRange first = matchRanges.get(0);
            codeArea.selectRange(first.getStart(), first.getEnd());
        }
    };

    // Replace all matches
    replaceBtn.setOnAction((e) -> {
        String find = findField.getText();
        String replace = replaceField.getText();
        if (find.isEmpty()) return;

        String content = codeArea.getText();
        String pattern = Pattern.quote(find);
        if (wholeWord.isSelected()) pattern = "\\b" + pattern + "\\b";

        Pattern compiledPattern = matchCase.isSelected() ?
            Pattern.compile(pattern) :
            Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);

        Matcher matcher = compiledPattern.matcher(content);
        boolean found = matcher.find();
        if (found) {
            String result = matcher.replaceAll(replace);
            codeArea.replaceText(result);
            showAlert(AlertType.INFORMATION, "Replaced", "All occurrences were replaced.");
            findMatches.run();
        } else {
            showAlert(AlertType.WARNING, "Not Found", "The word was not found.");
        }
    });

    findBtn.setOnAction((e) -> findMatches.run());

    nextBtn.setOnAction((e) -> {
        if (matchRanges.isEmpty()) return;
        currentMatchIndex = (currentMatchIndex + 1) % matchRanges.size();
        IndexRange range = matchRanges.get(currentMatchIndex);
        codeArea.selectRange(range.getStart(), range.getEnd());
        codeArea.requestFocus();
        codeArea.requestFollowCaret();
    });

    prevBtn.setOnAction((e) -> {
        if (matchRanges.isEmpty()) return;
        currentMatchIndex = (currentMatchIndex - 1 + matchRanges.size()) % matchRanges.size();
        IndexRange range = matchRanges.get(currentMatchIndex);
        codeArea.selectRange(range.getStart(), range.getEnd());
        codeArea.requestFocus();
        codeArea.requestFollowCaret();
    });

    VBox layout = new VBox(10,
        findField, replaceField,
        new HBox(10, matchCase, wholeWord),
        new HBox(10, findBtn, replaceBtn),
        new HBox(10, prevBtn, nextBtn),
        matchCountLabel
    );

    layout.setPadding(new Insets(15));
    layout.setAlignment(Pos.CENTER);
    //layout.setStyle("-fx-background-color: #2b2b2b;");

    Scene scene = new Scene(layout, 420, 330);
    dialog.setTitle("Find and Replace");
    dialog.setScene(scene);
    scene.getStylesheets().add(getClass().getResource(app_theme).toExternalForm());
    dialog.setResizable(false);
    dialog.centerOnScreen();
    dialog.show();
});


      
      
      
      openf = new MenuItem("Open HTML File...");
      openf.setStyle("-fx-font-size:13;");
      openf.setOnAction((sd) -> {
          
      if (!codeArea.getText().isEmpty()) {       
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Open HTML File");
      alert.setHeaderText("Are you sure want to open new project?\n\nYou will lose everything!!!.");
      alert.setContentText("We will discard all changes.");
      DialogPane dialogPaneu = alert.getDialogPane();
                     dialogPaneu.getStylesheets().add(
                   getClass().getResource(app_theme).toExternalForm());
      Optional<ButtonType> option = alert.showAndWait();
      if (option.get() == null) {  
      } else if (option.get() == ButtonType.OK) {
      ///////////////////////////////////////////////   
      ///////////////////////////////////////////////   
      codeArea.clear();
      codee.getEngine().loadContent("");
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[]{"*.html"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      htmltab.setText(dirpathe);
           try {
               BufferedReader buff=new BufferedReader (new FileReader (dirpathe));
               String line =buff.readLine();
               while (line!=null) {
                 line=buff.readLine();
                codeArea.appendText(line);
                codeArea.appendText("\n"); 
               }
               buff.close();
           } catch (FileNotFoundException ex) {
              } catch (IOException ex) {
               }    
     
           
      }
      else if (option.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled.");
      noti.position(Pos.CENTER);
      noti.showInformation();
      }
      else {}   
      }    
      else {
      codeArea.clear();
      codee.getEngine().loadContent("");
      FileChooser fcho = new FileChooser();
      //fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[]{"*.ks"}));
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[]{"*.html"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      htmltab.setText(dirpathe);
      
    /////////////////////(:)//////////////////////
    try {
    myarea.clear();
    InputStream inputinstream=new FileInputStream(dirpathe);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    String lo;
    myarea.appendText("");
    while ((lo=bi.readLine())!=null) {
    myarea.appendText("\n"+lo
       .replace("ﬦ","A")
       .replace("ﬧ","B")
       .replace("ﬨ","C")
       .replace("﬩","D")
       .replace("שׁ","E")    
       .replace("שׂ","F")        
       .replace("שּׁ","G")         
       .replace("שּׂ","H")         
       .replace("אַ","I")         
       .replace("אָ","J")         
       .replace("אּ","K")         
       .replace("בּ","L")         
       .replace("גּ","M")         
       .replace("דּ","N")         
       .replace("הּ","O")         
       .replace("וּ","P")         
       .replace("זּ","Q")         
       .replace("טּ","R")         
       .replace("יּ","S")         
       .replace("ךּ","T")         
       .replace("כּ","U")         
       .replace("לּ","V")
       .replace("מּ","W")         
       .replace("נּ","X")         
       .replace("סּ","Y")         
       .replace("ףּ","Z")         
       .replace("פּ","0")         
       .replace("צּ","1")         
       .replace("קּ","2")         
       .replace("רּ","3")         
       .replace("שּ","4")         
       .replace("תּ","5")         
       .replace("וֹ","6")         
       .replace("בֿ","7")         
       .replace("כֿ","8")
       .replace("פֿ","9")
       .replace("&NBSP;","")               
    ); 
    }
    bi.close();
    }catch (Exception g) {}
    String codefff=myarea.getText();
    codeArea.appendText(codefff);
    codeArea.setDisable(false);
    codee.setDisable(false);
   
    
      }
 
      });
      
      this.newhtml = new MenuItem("New HTML Empty code");
      this.newhtml.setStyle("-fx-font-size:13;");
      this.newhtml.setOnAction((sd) -> {
          
          
      if (!codeArea.getText().isEmpty()) {       
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("New Empty Code");
      alert.setHeaderText("Are you sure want to add new empty code?\n\nYou will lose everything!!!.");
      alert.setContentText("We will discard all changes.");
      DialogPane dialogPaneu = alert.getDialogPane();
                     dialogPaneu.getStylesheets().add(
                   getClass().getResource(app_theme).toExternalForm());
      Optional<ButtonType> option = alert.showAndWait();
      if (option.get() == null) {  
      } else if (option.get() == ButtonType.OK) {
      ///////////////////////////////////////////////   
      codeArea.clear();
      codee.getEngine().loadContent("");
      codeArea.appendText("<!DOCTYPE html>\n"
                 + "<html lang=\"en-US\">\n"
                 + "<head>\n"
                 + "<title>Kadysoft</title>\n"
                 + "<meta charset=\"UTF-8\">\n"
                 + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                 + "<link href=\"icon.png\" rel=\"icon\">\n"
                 + "<!--Write Links for CSS and JS Files Here!-->\n\n"
                 + "<style type=\"text/css\">\n\n"
                 + "<!--Write Your CSS Code Here!-->\n\n"
                 + "</style>\n\n"
                 + "<script type=\"text/javascript\">\n\n"
                 + "<!--Write Your JS Code Here!-->\n\n"
                 + "</script>\n"
                 + "</head>\n\n"
                 + "<body>\n\n"
                 + "<!--Write Your Code Here-->\n\n"
                 + "</body>\n"
                 + "</html>");
      codeArea.setDisable(false);
      codee.setDisable(false);
      ///////////////////////////////////////////////
      }
      else if (option.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled.");
      noti.position(Pos.CENTER);
      noti.showInformation();
      }
      else {}   
      }    
      else {
      codeArea.clear();
      codee.getEngine().loadContent("");
      codeArea.appendText("<!DOCTYPE html>\n"
                 + "<html lang=\"en-US\">\n"
                 + "<head>\n"
                 + "<title>Kadysoft</title>\n"
                 + "<meta charset=\"UTF-8\">\n"
                 + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                 + "<link href=\"icon.png\" rel=\"icon\">\n"
                 + "<!--Write Links for CSS and JS Files Here!-->\n\n"
                 + "<style type=\"text/css\">\n\n"
                 + "<!--Write Your CSS Code Here!-->\n\n"
                 + "</style>\n\n"
                 + "<script type=\"text/javascript\">\n\n"
                 + "<!--Write Your JS Code Here!-->\n\n"
                 + "</script>\n"
                 + "</head>\n\n"
                 + "<body>\n\n"
                 + "<!--Write Your Code Here-->\n\n"
                 + "</body>\n"
                 + "</html>");
      codeArea.setDisable(false);
      codee.setDisable(false);
      }           
      });
      
      this.m1 = new Menu("HTML5");
      this.m1.setStyle("-fx-font-size:14;");
      this.m1.getItems().addAll(new MenuItem[]{this.h1, this.h2, this.h3, this.h4, this.h5, this.h6, this.h7, this.h8, this.h9, this.h10, this.h11, this.h12, this.h13, this.h14, this.h15, this.h16, this.h17, this.h18, this.h19, this.h20, this.h21, this.h22, this.h23, this.h24, this.h25, this.h26, this.h27, this.h28, this.h29, this.h30, this.h31, this.h32, this.h33, this.h34, this.h35, this.h36, this.h37, this.h38, this.h39, this.h40, this.h115, this.h116, this.h41, this.h42, this.h43, this.h44, this.h45, this.h46, this.h47, this.h48, this.h49, this.h50, this.h51, this.h52, this.h53, this.h54, this.h55, this.h56, this.h57, this.h58, this.h59, this.h60, this.h61, this.h62, this.h63, this.h64, this.h65, this.h66, this.h67, this.h68, this.h69, this.h70, this.h71, this.h72, this.h73, this.h74, this.h75, this.h76, this.h77, this.h78, this.h79, this.h80, this.h81, this.h82, this.h83, this.h84, this.h85, this.h86, this.h87, this.h88, this.h89, this.h90, this.h91, this.h92, this.h93, this.h94, this.h95, this.h96, this.h97, this.h98, this.h99, this.h100, this.h101, this.h102, this.h103, this.h104, this.h105, this.h106, this.h107, this.h108, this.h109, this.h110, this.h111, this.h112, this.h113, this.h114});
      this.m3 = new Menu("Edit");
      this.m3.setStyle("-fx-font-size:14;");
      this.m3.getItems().addAll(new MenuItem[]{this.it8, this.it9, this.it10, this.it11, this.it12, this.it13, this.it14});
      ContextMenu conmenu = new ContextMenu();
      conmenu.getItems().addAll(new MenuItem[]{newhtml,this.gethtml, this.it3, this.it4});
      conmenu.show(HTMLStage);
      ///////////////////////////////////////////////////////////
      tol1 = new MenuItem("Edit Me");
      tol1.setOnAction((hk) -> {
         Stage gx = new Stage();
         
         javafx.scene.web.HTMLEditor editkt=new javafx.scene.web.HTMLEditor ();
         editkt.setHtmlText("Kadysoft - Edit Me.");
         //editkt.setEffect(new DropShadow());
         
         JFXTextArea cody=new JFXTextArea ();
         cody.setStyle("-fx-background-color:white;-fx-font-size:14;-fx-font-weight:bold;-fx-font-family:Monospaced;");
         //cody.setEffect(new DropShadow());
         
         Label lp=new Label ();
         lp.setStyle("-fx-background-color:white;-fx-font-size:16;-fx-font-weight:bold;-fx-font-family:Monospaced;");
         //lp.setEffect(new DropShadow());
         
         JFXButton viewwe=new JFXButton ("Get & Copy");
         //viewwe.setButtonType(ButtonType.RAISED);
         viewwe.setFont(Font.font("Monospaced",FontWeight.BOLD,15));
         viewwe.setStyle("-fx-background-color:green;");
         //viewwe.setEffect(new DropShadow());
         viewwe.setOnAction((hllk) -> {
             
             String htmlcod=editkt.getHtmlText();
             String formattedHtml = beautifyHtml(htmlcod);
             cody.setText (formattedHtml);
             cody.selectAll();
             cody.copy();
             lp.setText("I've copied it, paste it now in Eagle editor and enjoy.");
             
            
 
             
         });
         
         VBox bnm = new VBox();
         bnm.setPadding(new Insets (10,10,10,10));
         bnm.setSpacing(10.0D);
         bnm.setAlignment(Pos.CENTER);
         bnm.getChildren().addAll(editkt,cody,lp,viewwe);
         Scene rhl = new Scene(bnm, 800.0D, 600.0D);
         rhl.getStylesheets().add(getClass().getResource(app_theme).toExternalForm());
         gx.setScene(rhl);
         gx.setTitle("Edit Me");
         gx.setResizable(false);
         gx.centerOnScreen();
         gx.setAlwaysOnTop(true);
         gx.show();
      });
      
      tol2 = new MenuItem("Color Codes");
      tol2.setStyle("-fx-font-size:13;");
      tol2.setOnAction((sd) -> {
        Desktop desk = Desktop.getDesktop();
                   String  userpath = System.getProperty("user.home");
          try {
              desk.open(new File(userpath+"/AppData/Roaming/resources/data/colorcodes.jar"));
          } catch (IOException ex) {
              Logger.getLogger(HTMLEditor_Old.class.getName()).log(Level.SEVERE, null, ex);
          }
      });
      
      tol4 = new MenuItem("HTML Bold Generator");
      tol4.setStyle("-fx-font-size:13;");
      tol4.setOnAction((sd) -> {
         Desktop desk = Desktop.getDesktop();
                   String  userpath = System.getProperty("user.home");
          try {
              desk.open(new File(userpath+"/AppData/Roaming/resources/data/bold.jar"));
          } catch (IOException ex) {
              Logger.getLogger(HTMLEditor_Old.class.getName()).log(Level.SEVERE, null, ex);
          }
      });
      tol5 = new MenuItem("HTML Link Generator");
      tol5.setStyle("-fx-font-size:13;");
      tol5.setOnAction((sd) -> {
         Desktop desk = Desktop.getDesktop();
                   String  userpath = System.getProperty("user.home");
          try {
              desk.open(new File(userpath+"/AppData/Roaming/resources/data/link.jar"));
          } catch (IOException ex) {
              Logger.getLogger(HTMLEditor_Old.class.getName()).log(Level.SEVERE, null, ex);
          }
      });
      tol6 = new MenuItem("HTML Image Generator");
      tol6.setStyle("-fx-font-size:13;");
      tol6.setOnAction((sd) -> {
         Desktop desk = Desktop.getDesktop();
                   String  userpath = System.getProperty("user.home");
          try {
              desk.open(new File(userpath+"/AppData/Roaming/resources/data/image.jar"));
          } catch (IOException ex) {
              Logger.getLogger(HTMLEditor_Old.class.getName()).log(Level.SEVERE, null, ex);
          }
      });
      tol7 = new MenuItem("HTML Text Color Generator");
      tol7.setStyle("-fx-font-size:13;");
      tol7.setOnAction((sd) -> {
         Desktop desk = Desktop.getDesktop();
                   String  userpath = System.getProperty("user.home");
          try {
              desk.open(new File(userpath+"/AppData/Roaming/resources/data/tcolor.jar"));
          } catch (IOException ex) {
              Logger.getLogger(HTMLEditor_Old.class.getName()).log(Level.SEVERE, null, ex);
          }
      });
      tol8 = new MenuItem("HTML Text Generator");
      tol8.setStyle("-fx-font-size:13;");
      tol8.setOnAction((sd) -> {
         Desktop desk = Desktop.getDesktop();
                   String  userpath = System.getProperty("user.home");
          try {
              desk.open(new File(userpath+"/AppData/Roaming/resources/data/text.jar"));
          } catch (IOException ex) {
              Logger.getLogger(HTMLEditor_Old.class.getName()).log(Level.SEVERE, null, ex);
          }
      });
      tol9 = new MenuItem("HTML Form Generator");
      tol9.setStyle("-fx-font-size:13;");
      tol9.setOnAction((sd) -> {
         Desktop desk = Desktop.getDesktop();
                   String  userpath = System.getProperty("user.home");
          try {
              desk.open(new File(userpath+"/AppData/Roaming/resources/data/form.jar"));
          } catch (IOException ex) {
              Logger.getLogger(HTMLEditor_Old.class.getName()).log(Level.SEVERE, null, ex);
          }
      });
      tol10 = new MenuItem("HTML IFrame Generator");
      tol10.setStyle("-fx-font-size:13;");
      tol10.setOnAction((sd) -> {
         Desktop desk = Desktop.getDesktop();
                   String  userpath = System.getProperty("user.home");
          try {
              desk.open(new File(userpath+"/AppData/Roaming/resources/data/iframe.jar"));
          } catch (IOException ex) {
              Logger.getLogger(HTMLEditor_Old.class.getName()).log(Level.SEVERE, null, ex);
          }
      });
      
      aiartool = new MenuItem("Aiar Editor");
      aiartool.setStyle("-fx-font-size:13;");
      aiartool.setOnAction((sd) -> {
          Desktop desk = Desktop.getDesktop();
                   String  userpath = System.getProperty("user.home");
          try {
              desk.open(new File(userpath+"/AppData/Roaming/resources/data/Aiar/Aiar.jar"));
          } catch (IOException ex) {
              Logger.getLogger(HTMLEditor_Old.class.getName()).log(Level.SEVERE, null, ex);
          }
      });
      
      
      
      tol11 = new MenuItem("Open Music ...");
      tol11.setStyle("-fx-font-size:13;");
      tol11.setOnAction((sd) -> {
          
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new ExtensionFilter("Music Files", new String[]{"*.mp3"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      codeArea.clear();
      codee.getEngine().loadContent("");
      codeArea.appendText("<!DOCTYPE html>\n"
                 + "<html lang=\"en-US\">\n"
                 + "<head>\n"
                 + "<title>Kadysoft</title>\n"
                 + "<meta charset=\"UTF-8\">\n"
                 + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                 + "<link href=\"icon.png\" rel=\"icon\">\n"
                 + "<!--Write Links for CSS and JS Files Here!-->\n\n"
                 + "<style type=\"text/css\">\n\n"
                 + "<!--Write Your CSS Code Here!-->\n\n"
                 + "</style>\n\n"
                 + "<script type=\"text/javascript\">\n\n"
                 + "<!--Write Your JS Code Here!-->\n\n"
                 + "</script>\n"
                 + "</head>\n\n"
                 + "<body>\n\n"
                 + "<audio controls=\"controls\" src=\""+"file://"+dirpathe+"\" loop=\"loop\" autoplay=\"autoplay\"></audio>\n\n"
                 + "</body>\n"
                 + "</html>");
      
      });
      tol12 = new MenuItem("Open Video ...");
      tol12.setStyle("-fx-font-size:13;");
      tol12.setOnAction((sd) -> {
         
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new ExtensionFilter("Video Files", new String[]{"*.mp4"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      codeArea.clear();
      codee.getEngine().loadContent("");
      codeArea.appendText("<!DOCTYPE html>\n"
                 + "<html lang=\"en-US\">\n"
                 + "<head>\n"
                 + "<title>Kadysoft</title>\n"
                 + "<meta charset=\"UTF-8\">\n"
                 + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                 + "<link href=\"icon.png\" rel=\"icon\">\n"
                 + "<!--Write Links for CSS and JS Files Here!-->\n\n"
                 + "<style type=\"text/css\">\n\n"
                 + "<!--Write Your CSS Code Here!-->\n\n"
                 + "</style>\n\n"
                 + "<script type=\"text/javascript\">\n\n"
                 + "<!--Write Your JS Code Here!-->\n\n"
                 + "</script>\n"
                 + "</head>\n\n"
                 + "<body>\n\n"
                 + "<video autoplay=\"autoplay\" loop=\"loop\" width=\"400\" height=\"300\" controls=\"controls\" src=\""+"file://"+dirpathe+"\">\n" +
"</video>\n\n"
                 + "</body>\n"
                 + "</html>");
          
      });
      tol13 = new MenuItem("Open Image ...");
      tol13.setStyle("-fx-font-size:13;");
      tol13.setOnAction((sd) -> {
         
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new ExtensionFilter("Image Files", new String[]{"*.png","*.jpg","*.jpeg","*.gif"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      codeArea.clear();
      codee.getEngine().loadContent("");
      codeArea.appendText("<!DOCTYPE html>\n"
                 + "<html lang=\"en-US\">\n"
                 + "<head>\n"
                 + "<title>Kadysoft</title>\n"
                 + "<meta charset=\"UTF-8\">\n"
                 + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                 + "<link href=\"icon.png\" rel=\"icon\">\n"
                 + "<!--Write Links for CSS and JS Files Here!-->\n\n"
                 + "<style type=\"text/css\">\n\n"
                 + "<!--Write Your CSS Code Here!-->\n\n"
                 + "</style>\n\n"
                 + "<script type=\"text/javascript\">\n\n"
                 + "<!--Write Your JS Code Here!-->\n\n"
                 + "</script>\n"
                 + "</head>\n\n"
                 + "<body>\n\n"
                 + "<img src=\""+"file://"+dirpathe+"\" alt=\"KADY\" height=\"300\" width=\"300\">\n\n"
                 + "</body>\n"
                 + "</html>");
          
      });
      
      
       //TWO//
      
      
       //Double Click
       
//      projectTree = new TreeView<>();
//      projectTree.setOnMouseClicked(event -> {
//            if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
//                TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
//                if (selectedItem != null && Files.isRegularFile(selectedItem.getValue())) {
//                    loadFileToEditor(selectedItem.getValue());
//                    
//                }
//            }
//        });
      

//Single Click

projectTree = new JFXTreeView<>();

//// Show only file/folder name instead of full path
//projectTree.setCellFactory(tv -> new TreeCell<Path>() {
//    @Override
//    protected void updateItem(Path item, boolean empty) {
//        super.updateItem(item, empty);
//        if (empty || item == null) {
//            setText(null);
//        } else {
//            setText(item.getFileName().toString());
//        }
//    }
//});


//
//projectTree.setCellFactory(tv -> new TreeCell<Path>() {
//    @Override
//    protected void updateItem(Path item, boolean empty) {
//        super.updateItem(item, empty);
//        if (empty || item == null) {
//            setText(null);
//        } else {
//            setText(item.getFileName().toString()); // show only name
//        }
//    }
//});



// Load file content on single-click (selection)
//
//projectTree.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//    @Override
//    public void handle(MouseEvent event) {
//        if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
//            TreeItem<Path> clickedItem = getTreeItemAtMousePosition(event);
//            if (clickedItem != null && Files.isRegularFile(clickedItem.getValue())) {
//                loadFileToEditor(clickedItem.getValue());
//            }
//        }
//    }
//});







        
      // Context Menu creation
ContextMenu contextMenu = new ContextMenu();
MenuItem refresh = new MenuItem("Refresh Projects");
SeparatorMenuItem sp0=new SeparatorMenuItem();
MenuItem openItem = new MenuItem("Read File In Editor");
SeparatorMenuItem sp1=new SeparatorMenuItem();
MenuItem addFileItem = new MenuItem("Add New File");
SeparatorMenuItem sp2=new SeparatorMenuItem();
MenuItem openItemm = new MenuItem("Open Project Folder");
SeparatorMenuItem sp3=new SeparatorMenuItem();
MenuItem previewImageItem = new MenuItem("Preview Image");
MenuItem previewmediaItem = new MenuItem("Preview Audio/Video");
SeparatorMenuItem sp4=new SeparatorMenuItem();
MenuItem deleteItem = new MenuItem("Delete File");
MenuItem renameItem = new MenuItem("Rename File");
SeparatorMenuItem sp5=new SeparatorMenuItem();
MenuItem cop=new MenuItem ("Copy File");
contextMenu.getItems().addAll(openItem,sp2, openItemm,sp3,previewImageItem,previewmediaItem,sp4, deleteItem, renameItem,sp5,cop);


// Global or class-level variable to store the copied file path

// COPY ACTION (from project tree or clipboard)
cop.setOnAction(e -> {
    TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();

    // Copy from project tree (when a file is selected)
    if (selectedItem != null && Files.isRegularFile(selectedItem.getValue())) {
        copiedFile = selectedItem.getValue();
        System.out.println("Copied from tree: " + copiedFile);
    }
    // Copy from system clipboard (if there's a file in the clipboard)
    else if (Clipboard.getSystemClipboard().hasFiles()) {
        List<File> clipboardFiles = Clipboard.getSystemClipboard().getFiles();
        copiedFile = clipboardFiles.get(0).toPath();  // Use first file
        System.out.println("Copied from clipboard: " + copiedFile);
    } else {
        showErrorDialog("Please select a file from the project or copy a file to the clipboard.");
    }
});


// Context Menu for folders
ContextMenu folderContextMenu = new ContextMenu();
MenuItem expandItem = new MenuItem("Expand Folder");
MenuItem collapseItem = new MenuItem("Collapse Folder");
SeparatorMenuItem sp6=new SeparatorMenuItem();
MenuItem deleteFolderItem = new MenuItem("Delete Folder");
MenuItem pas=new MenuItem ("Paste File");
folderContextMenu.getItems().addAll(refresh,sp0,expandItem, collapseItem,sp6, deleteFolderItem,pas,sp1, addFileItem);


// PASTE ACTION (handle pasting from both clipboard and project tree)
pas.setOnAction(e -> {
    TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
    
    if (selectedItem != null && Files.isDirectory(selectedItem.getValue())) {
        if (copiedFile != null) {
            try {
                // If copied file is from clipboard, copy it
                if (Clipboard.getSystemClipboard().hasFiles()) {
                    List<File> clipboardFiles = Clipboard.getSystemClipboard().getFiles();
                    Path clipboardFile = clipboardFiles.get(0).toPath();  // Use first file

                    Path destination = selectedItem.getValue().resolve(clipboardFile.getFileName());

                    // Handle name conflict by appending _copy1, _copy2, etc.
                    int counter = 1;
                    while (Files.exists(destination)) {
                        String fileName = clipboardFile.getFileName().toString();
                        String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
                        String extension = fileName.substring(fileName.lastIndexOf('.') + 1);
                        String newName = baseName + "_copy" + (counter++) + "." + extension;
                        destination = selectedItem.getValue().resolve(newName);
                    }

                    // Copy file from clipboard to selected directory
                    Files.copy(clipboardFile, destination);
                    System.out.println("Pasted clipboard file to: " + destination);
                } else {
                    // If copied from the project tree, paste like before
                    Path destination = selectedItem.getValue().resolve(copiedFile.getFileName());

                    // Handle name conflict by appending _copy1, _copy2, etc.
                    int counter = 1;
                    while (Files.exists(destination)) {
                        String fileName = copiedFile.getFileName().toString();
                        String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
                        String extension = fileName.substring(fileName.lastIndexOf('.') + 1);
                        String newName = baseName + "_copy" + (counter++) + "." + extension;
                        destination = selectedItem.getValue().resolve(newName);
                    }

                    // Copy file from project tree to selected directory
                    Files.copy(copiedFile, destination);
                    System.out.println("Pasted tree file to: " + destination);
                }

                refreshProjectTree(); // Refresh the tree after pasting
            } catch (IOException ex) {
                ex.printStackTrace();
                showErrorDialog("Failed to paste file: " + ex.getMessage());
            }
        } else {
            showErrorDialog("No file copied to paste.");
        }
    } else {
        showErrorDialog("Please select a folder to paste the file.");
    }
});





refresh.setOnAction(e -> {
   
    
          try {
              
            //  TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
              refreshProjectTree();
            //  projectTree.getSelectionModel().select(selectedItem);
              
              
          } catch (IOException ex) {
              Logger.getLogger(HTMLEditor_Old.class.getName()).log(Level.SEVERE, null, ex);
          }
    
});




// Define actions
openItem.setOnAction(e -> {
    TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
    if (selectedItem != null && Files.isRegularFile(selectedItem.getValue())) {
        
        Path clickedPathf = selectedItem.getValue();
        selectedFilePath = clickedPathf;
        selfileee=selectedFilePath.toString();
        
        loadFileToEditor(clickedPathf);
        
        //loadFileToEditor(selectedItem.getValue());
    }
});



addFileItem.setOnAction(e -> {
    TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
    if (selectedItem != null && Files.isDirectory(selectedItem.getValue())) {
        TextInputDialog inputDialog = new TextInputDialog("NewIndex.html");
        inputDialog.setTitle("Create New File");
        inputDialog.setHeaderText("Enter file name with extension:");
        inputDialog.setContentText("File name:");
DialogPane dialogPane = inputDialog.getDialogPane();
dialogPane.getStylesheets().add(getClass().getResource(app_theme).toExternalForm());
dialogPane.getStyleClass().add("nord-dialog");
        Optional<String> result = inputDialog.showAndWait();
        result.ifPresent(fileName -> {
            try {
                Path newFile = selectedItem.getValue().resolve(fileName);
                if (!Files.exists(newFile)) {
                    Files.createFile(newFile);
                    refreshProjectTree(); // Refresh after creating file
                } else {
                    showErrorDialog("File already exists: " + fileName);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                showErrorDialog("Failed to create file: " + ex.getMessage());
            }
        });
    }
});




// Define actions
openItemm.setOnAction(e -> {
    
    TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
    String fo1=selectedItem.getValue().getFileName().toString();  //File Name
    String fo2="\\";  //Break
    String fo3=selectedItem.getValue().toString(); //Full Path
    String repl=fo2+fo1;
    
    String finalfo=fo3.replace(repl,"");
    
    Desktop desk;
    desk=Desktop.getDesktop();
          try {
              desk.open(new File (finalfo));
          } catch (IOException ex) {
              Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, null, ex);
          }
    
});

previewmediaItem.setOnAction(e -> {
    TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
    if (selectedItem != null && Files.isRegularFile(selectedItem.getValue())) {
        showMediaPreview(selectedItem.getValue());//Show image
    }
});

previewImageItem.setOnAction(e -> {
    TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
    if (selectedItem != null && Files.isRegularFile(selectedItem.getValue())) {
        showImagePreview(selectedItem.getValue());//Show image
    }
});





deleteItem.setOnAction(e -> {
    TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
    if (selectedItem != null) {
        boolean confirmed = showConfirmationDialog("Are you sure you want to delete this file?");
        if (confirmed) {
            try {
                Files.deleteIfExists(selectedItem.getValue());
                selectedItem.getParent().getChildren().remove(selectedItem);
                codeArea.clear();
                selfileee=null;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
});



renameItem.setOnAction(e -> {
    TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
    if (selectedItem != null) {
        TextInputDialog dialog = new TextInputDialog(selectedItem.getValue().getFileName().toString());
        dialog.setTitle("Rename File");
        dialog.setHeaderText("Rename the file:");
        dialog.setContentText("New name:");
        // Apply Nord Dark Theme
DialogPane dialogPane = dialog.getDialogPane();
dialogPane.getStylesheets().add(getClass().getResource(app_theme).toExternalForm());
dialogPane.getStyleClass().add("nord-dialog");

        dialog.showAndWait().ifPresent(newName -> {
            try {
                Path source = selectedItem.getValue();
                Path target = source.resolveSibling(newName);
                Files.move(source, target);
                selectedItem.setValue(target);
                Path clickedPathff = selectedItem.getValue();
                selectedFilePath = clickedPathff;
                selfileee=selectedFilePath.toString();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
});
      
      
expandItem.setOnAction(e -> {
    TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
    if (selectedItem != null) {
        selectedItem.setExpanded(true);
    }
});

collapseItem.setOnAction(e -> {
    TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
    if (selectedItem != null) {
        selectedItem.setExpanded(false);
    }
});


deleteFolderItem.setOnAction(e -> {
    TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
    if (selectedItem != null) {
        boolean confirmed = showConfirmationDialog("Are you sure you want to delete this folder?");
        if (confirmed) {
            try {
                // 1. Delete the folder and its contents
                deleteDirectoryRecursively(selectedItem.getValue());

                // 2. Remove from tree
                TreeItem<Path> parent = selectedItem.getParent();
                if (parent != null) {
                    parent.getChildren().remove(selectedItem);
                    codeArea.clear();
                    selfileee=null;
                } else {
                    // It's the root; clear the root or set a new one
                    projectTree.setRoot(null); // Or show an empty placeholder
                    codeArea.clear();
                    selfileee=null;
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
});


//
//deleteFolderItem.setOnAction(e -> {
//    TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
//    if (selectedItem != null) {
//        boolean confirmed = showConfirmationDialog("Are you sure you want to delete this folder?");
//        if (confirmed) {
//            // delete folder and its contents
//            try {
//                deleteDirectoryRecursively(selectedItem.getValue());
//                selectedItem.getParent().getChildren().remove(selectedItem);
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
//});








projectTree.setOnMouseClicked(event -> {
    TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
    if (selectedItem == null) return;

    Path clickedPath = selectedItem.getValue();
    if (clickedPath == null || !Files.exists(clickedPath)) return;

    if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
        if (Files.isRegularFile(clickedPath) && Files.isReadable(clickedPath)) {
            String extension = getFileExtension(clickedPath).toLowerCase();

            // Open images in image preview UI, do not save path
            if (extension.matches("png|jpg|jpeg|gif|ico")) {
                try {
                    showImagePreview(clickedPath);
                } catch (Exception ex) {
                    showErrorDialog("Failed to load image: " + ex.getMessage());
                }
                return; // ❌ Don't continue to editor
            }

            // Open media in media preview UI, do not save path
            if (extension.matches("mp3|mp4|wav")) {
                try {
                    showMediaPreview(clickedPath); // Your custom method
                } catch (Exception ex) {
                    showErrorDialog("Failed to load media: " + ex.getMessage());
                }
                return; // ❌ Don't continue to editor
            }
            
            
            
            if (extension.matches("pdf")) {
                try {
                    //Show PDF File
                    showPDFPreview(clickedPath);
                } catch (Exception ex) {
                    showErrorDialog("Failed to load PDF File: " + ex.getMessage());
                }
                return; // ❌ Don't continue to editor
            }
            
            
            if (extension.matches("xls|xlsx|docx|doc|ppt")) {
                try {
                    //preview outside
                   
Alert alertr = new Alert(Alert.AlertType.CONFIRMATION);
alertr.setTitle("Recipes Time");
alertr.setHeaderText("Recipe Time Viewer");
alertr.setContentText("Choose one option to view recipes time: ");
ButtonType buttonTypeOner = new ButtonType("Open Outside");
ButtonType buttonTypeCancelr = new ButtonType("Open Inside");
alertr.getButtonTypes().setAll(buttonTypeOner, buttonTypeCancelr);
DialogPane dialogPaneir = alertr.getDialogPane();
dialogPaneir.getStylesheets().add(getClass().getResource("primer-dark.css").toExternalForm());
Optional<ButtonType> resultsr = alertr.showAndWait();
if (resultsr.isPresent() && resultsr.get() == buttonTypeOner) {
    
    //Outside
    
    Desktop desko=Desktop.getDesktop();
    desko.open(clickedPath.toFile());
    
}

else {
    
    //Inside
    
    selectedFilePath = clickedPath;
    selfileee=selectedFilePath.toString();
    loadFileToEditor(clickedPath);
    
    
}
                    
                    
                } catch (Exception ex) {
                    showErrorDialog("Failed to load file: " + ex.getMessage());
                }
                return; // ❌ Don't continue to editor
            }
            
            

            // For other files: load to editor and save selected path ✅
            selectedFilePath = clickedPath;
            selfileee=selectedFilePath.toString();
            loadFileToEditor(clickedPath);
        }
    }

    // Right-click context menus
    else if (event.getButton() == MouseButton.SECONDARY) {
        File file = clickedPath.toFile();
        String name = file.getName().toLowerCase();

        boolean isImage = name.matches(".*\\.(png|jpg|jpeg|gif|bmp|ico)");
        boolean isMedia = name.matches(".*\\.(mp3|mp4|wav)");
        boolean isFile = name.contains(".");

        if (!isFile) {
            folderContextMenu.show(projectTree, event.getScreenX(), event.getScreenY());
        } else if (isImage) {
            previewImageItem.setDisable(false);
            contextMenu.show(projectTree, event.getScreenX(), event.getScreenY());
        } else if (isMedia) {
            previewmediaItem.setDisable(false);
            contextMenu.show(projectTree, event.getScreenX(), event.getScreenY());
        } else {
            previewImageItem.setDisable(true);
            previewmediaItem.setDisable(true);
            contextMenu.show(projectTree, event.getScreenX(), event.getScreenY());
        }
    }
});
















   
//// Set mouse click behavior
//projectTree.setOnMouseClicked(event -> {
//    TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
//
//    if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
//        if (selectedItem != null && Files.isRegularFile(selectedItem.getValue())) {
//            loadFileToEditor(selectedItem.getValue());
//        }
//    } else if (event.getButton() == MouseButton.SECONDARY) {
//        if (selectedItem != null) {
//            projectTree.getSelectionModel().select(selectedItem);
//            contextMenu.show(projectTree, event.getScreenX(), event.getScreenY());
//        }
//    }
//});

// Optional: Hide context menu if clicking elsewhere
projectTree.addEventHandler(ContextMenuEvent.CONTEXT_MENU_REQUESTED, event -> {
    if (projectTree.getSelectionModel().getSelectedItem() == null) {
        contextMenu.hide();
        folderContextMenu.hide();
    }
});
      
      newfullproject = new MenuItem("New Full Project");
      newfullproject.setStyle("-fx-font-size:13;");
      
      newfullproject.setOnAction((sd) -> {
          
          
      if (!codeArea.getText().isEmpty()) {
	  
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Open HTML File");
      alert.setHeaderText("Are you sure want to open new project?\n\nYou will lose everything!!!.");
      alert.setContentText("We will discard all changes.");
      DialogPane dialogPaneu = alert.getDialogPane();
      dialogPaneu.getStylesheets().add(
      getClass().getResource(app_theme).toExternalForm());
      Optional<ButtonType> option = alert.showAndWait();
      if (option.get() == null) {} 
	  else if (option.get() == ButtonType.OK) {
       
      codeArea.clear();
      codee.getEngine().loadContent("");
      
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select Location to Create Project");
        Path selectedDir = Optional.ofNullable(chooser.showDialog(null))
                .map(File::toPath)
                .orElse(null);
        if (selectedDir != null) {
            TextInputDialog dialog = new TextInputDialog("NewHtmlProject");
            dialog.setTitle("Project Name");
            dialog.setHeaderText("Enter project name:");
            DialogPane dialogPaneuu = dialog.getDialogPane();
            dialogPaneuu.getStylesheets().add(
            getClass().getResource(app_theme).toExternalForm());
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(name -> {
                try {
                    projectRoot = selectedDir.resolve(name);
                    Files.createDirectories(projectRoot);
                    
                    Files.write(projectRoot.resolve("index.html"),
    ("<!DOCTYPE html>\n" +
"<html lang=\"ar\" dir=\"rtl\">\n" +
"<head>\n" +
"  <meta charset=\"UTF-8\">\n" +
"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"  <title>أنا المسلم - برنامج ديني متقدم</title>\n" +
"  <link rel=\"stylesheet\" href=\"style.css\">\n" +
"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css\">\n" +
"</head>\n" +
"<body>\n" +
"  <div class=\"main-container\">\n" +
"    <header>\n" +
"      <h1>🎵 أنا المسلم</h1>\n" +
"      <button id=\"themeToggle\" class=\"btn\">تبديل الوضع (فاتح/داكن)</button>\n" +
"    </header>\n" +
"\n" +
"    <div class=\"tab-navigation\">\n" +
"      <button class=\"tab-btn active\" onclick=\"openTab('player')\">مشغل الصوت</button>\n" +
"      <button class=\"tab-btn\" onclick=\"openTab('quiz')\">الاختبار</button>\n" +
"      <button class=\"tab-btn\" onclick=\"openTab('tafsir')\">التفسير</button>\n" +
"      <button class=\"tab-btn\" onclick=\"openTab('prayer')\">أوقات الصلاة</button>\n" +
"      <button class=\"tab-btn\" onclick=\"openTab('hadith')\">الحديث</button>\n" +
"      <button class=\"tab-btn\" onclick=\"openTab('dhikr')\">الذكر</button>\n" +
"      <button class=\"tab-btn\" onclick=\"openTab('quran')\">القرآن</button>\n" +
"      <button class=\"tab-btn\" onclick=\"openTab('dua')\">الدعاء</button>\n" +
"      <button class=\"tab-btn\" onclick=\"openTab('calendar')\">التقويم</button>\n" +
"    </div>\n" +
"\n" +
"    <section id=\"player\" class=\"tab-content active\">\n" +
"      <h2>مشغل الصوت</h2>\n" +
"      <div class=\"cover-img-wrapper\">\n" +
"        <img src=\"1.jpg\" alt=\"صورة الغلاف\" class=\"cover-img\">\n" +
"      </div>\n" +
"      <div class=\"audio-controls\">\n" +
"        <audio id=\"audioPlayer\" controls>\n" +
"          <source src=\"1.mp3\" type=\"audio/mpeg\">\n" +
"        </audio>\n" +
"        <div class=\"volume-control\">\n" +
"          <label for=\"volume\">الصوت:</label>\n" +
"          <input type=\"range\" id=\"volume\" min=\"0\" max=\"1\" step=\"0.1\" value=\"1\">\n" +
"        </div>\n" +
"      </div>\n" +
"      <div class=\"controls\">\n" +
"        <button onclick=\"backward()\" class=\"btn\"><i class=\"fas fa-backward\"></i> 10 ثوانٍ للخلف</button>\n" +
"        <button onclick=\"togglePlay()\" class=\"btn\"><i class=\"fas fa-play-pause\"></i></button>\n" +
"        <button onclick=\"forward()\" class=\"btn\"><i class=\"fas fa-forward\"></i> 10 ثوانٍ للأمام</button>\n" +
"      </div>\n" +
"    </section>\n" +
"\n" +
"    <section id=\"quiz\" class=\"tab-content\">\n" +
"      <h2>❓ اختبار معلومات إسلامية</h2>\n" +
"      <div id=\"quiz\"></div>\n" +
"      <button onclick=\"submitQuiz()\">تصحيح</button>\n" +
"      <p id=\"score\"></p>\n" +
"    </section>\n" +
"\n" +
"    <section id=\"tafsir\" class=\"tab-content\">\n" +
"      <h2>📖 تفسير سورة الفاتحة</h2>\n" +
"      <p>\n" +
"        سورة الفاتحة هي أول سورة في القرآن الكريم، وتسمى أم الكتاب والسبع المثاني. تحتوي على سبع آيات تتضمن الثناء على الله، وطلب الهداية، والدعاء بالثبات على الصراط المستقيم، والابتعاد عن طريق المغضوب عليهم والضالين.\n" +
"        <br><br>\n" +
"        <strong>الحمد لله رب العالمين:</strong> الثناء الكامل لله رب كل شيء.<br>\n" +
"        <strong>الرحمن الرحيم:</strong> صفات الرحمة الواسعة التي تشمل الدنيا والآخرة.<br>\n" +
"        <strong>مالك يوم الدين:</strong> إقرار بأن الله وحده هو الحاكم يوم القيامة.<br>\n" +
"        <strong>إياك نعبد وإياك نستعين:</strong> توحيد العبادة والاستعانة بالله فقط.<br>\n" +
"        <strong>اهدنا الصراط المستقيم:</strong> دعاء بأن يهدينا الله إلى الطريق الصحيح.<br>\n" +
"        <strong>صراط الذين أنعمت عليهم:</strong> هو طريق الأنبياء والصالحين.<br>\n" +
"        <strong>غير المغضوب عليهم ولا الضالين:</strong> طلب الحماية من طرق الذين غضب الله عليهم والذين ضلوا.\n" +
"      </p>\n" +
"    </section>\n" +
"\n" +
"    <section id=\"prayer\" class=\"tab-content\">\n" +
"      <h2>🕌 أوقات الصلاة</h2>\n" +
"      <button id=\"getPrayerTimesBtn\" class=\"btn\">احصل على أوقات الصلاة</button>\n" +
"      <div id=\"prayerTimes\"></div>\n" +
"    </section>\n" +
"\n" +
"    <section id=\"hadith\" class=\"tab-content\">\n" +
"      <h2>📜 حديث يومي</h2>\n" +
"      <button onclick=\"showRandomHadith()\" class=\"btn\">عرض حديث عشوائي</button>\n" +
"      <p id=\"hadithText\"></p>\n" +
"    </section>\n" +
"\n" +
"    <section id=\"dhikr\" class=\"tab-content\">\n" +
"      <h2>🔢 عداد الذكر</h2>\n" +
"      <p id=\"dhikrCount\">0</p>\n" +
"      <button onclick=\"incrementDhikr()\" class=\"btn\">ذكر الله</button>\n" +
"      <button onclick=\"resetDhikr()\" class=\"btn\">إعادة تعيين</button>\n" +
"    </section>\n" +
"\n" +
"    <section id=\"quran\" class=\"tab-content\">\n" +
"      <h2>📖 آية قرآنية عشوائية</h2>\n" +
"      <button id=\"getAyahBtn\" class=\"btn\">عرض آية عشوائية</button>\n" +
"      <p id=\"ayahText\"></p>\n" +
"      <p id=\"ayahTranslation\"></p>\n" +
"    </section>\n" +
"\n" +
"    <section id=\"dua\" class=\"tab-content\">\n" +
"      <h2>🤲 دعاء يومي</h2>\n" +
"      <button onclick=\"showRandomDua()\" class=\"btn\">عرض دعاء عشوائي</button>\n" +
"      <p id=\"duaText\"></p>\n" +
"    </section>\n" +
"\n" +
"    <section id=\"calendar\" class=\"tab-content\">\n" +
"      <h2>📅 التقويم الهجري</h2>\n" +
"      <button id=\"getHijriDateBtn\" class=\"btn\">احصل على التاريخ الهجري</button>\n" +
"      <p id=\"hijriDate\"></p>\n" +
"    </section>\n" +
"  </div>\n" +
"\n" +
"  <script src=\"script.js\"></script>\n" +
"</body>\n" +
"</html>").getBytes(StandardCharsets.UTF_8)
);

                    
                    
                    Files.write(projectRoot.resolve("style.css"),
    ("/* Global Styles */\n" +
"body {\n" +
"  margin: 0;\n" +
"  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n" +
"  background: linear-gradient(135deg, #d9e7ff, #ffe3e3);\n" +
"  color: #2c3e50;\n" +
"  display: flex;\n" +
"  justify-content: center;\n" +
"  align-items: center;\n" +
"  min-height: 100vh;\n" +
"  padding: 20px;\n" +
"  transition: background 0.5s ease, color 0.5s ease;\n" +
"}\n" +
"\n" +
"body.dark-mode {\n" +
"  background: linear-gradient(135deg, #2c3e50, #34495e);\n" +
"  color: #ecf0f1;\n" +
"}\n" +
"\n" +
".main-container {\n" +
"  max-width: 900px;\n" +
"  width: 100%;\n" +
"  display: flex;\n" +
"  flex-direction: column;\n" +
"  align-items: center;\n" +
"}\n" +
"\n" +
"header {\n" +
"  text-align: center;\n" +
"  margin-bottom: 40px;\n" +
"}\n" +
"\n" +
"header h1 {\n" +
"  font-size: 3rem;\n" +
"  color: #e74c3c;\n" +
"  text-shadow: 3px 3px 6px rgba(0, 0, 0, 0.2);\n" +
"  animation: fadeIn 1.5s ease-in-out;\n" +
"}\n" +
"\n" +
"#themeToggle {\n" +
"  background: linear-gradient(45deg, #e74c3c, #f39c12);\n" +
"  margin-top: 10px;\n" +
"}\n" +
"\n" +
".tab-navigation {\n" +
"  display: flex;\n" +
"  flex-wrap: wrap;\n" +
"  justify-content: center;\n" +
"  margin-bottom: 30px;\n" +
"}\n" +
"\n" +
".tab-btn {\n" +
"  background: linear-gradient(45deg, #bdc3c7, #95a5a6);\n" +
"  color: #2c3e50;\n" +
"  border: none;\n" +
"  padding: 10px 20px;\n" +
"  margin: 5px;\n" +
"  border-radius: 10px;\n" +
"  cursor: pointer;\n" +
"  transition: background 0.3s ease;\n" +
"}\n" +
"\n" +
".tab-btn.active {\n" +
"  background: linear-gradient(45deg, #e74c3c, #c0392b);\n" +
"  color: #fff;\n" +
"}\n" +
"\n" +
"body.dark-mode .tab-btn {\n" +
"  background: linear-gradient(45deg, #34495e, #2c3e50);\n" +
"  color: #ecf0f1;\n" +
"}\n" +
"\n" +
"body.dark-mode .tab-btn.active {\n" +
"  background: linear-gradient(45deg, #e74c3c, #c0392b);\n" +
"}\n" +
"\n" +
".tab-content {\n" +
"  display: none;\n" +
"  background: rgba(255, 255, 255, 0.95);\n" +
"  backdrop-filter: blur(8px);\n" +
"  border-radius: 20px;\n" +
"  padding: 30px;\n" +
"  box-shadow: 0 12px 40px rgba(0, 0, 0, 0.15);\n" +
"  width: 100%;\n" +
"  max-width: 700px;\n" +
"  transition: transform 0.4s ease, box-shadow 0.4s ease;\n" +
"  text-align: center;\n" +
"}\n" +
"\n" +
".tab-content.active {\n" +
"  display: block;\n" +
"}\n" +
"\n" +
"body.dark-mode .tab-content {\n" +
"  background: rgba(44, 62, 80, 0.95);\n" +
"  color: #ecf0f1;\n" +
"}\n" +
"\n" +
".tab-content:hover {\n" +
"  transform: translateY(-10px);\n" +
"  box-shadow: 0 15px 45px rgba(0, 0, 0, 0.2);\n" +
"}\n" +
"\n" +
"h2 {\n" +
"  color: #e74c3c;\n" +
"  margin-bottom: 20px;\n" +
"  font-size: 2rem;\n" +
"}\n" +
"\n" +
".cover-img {\n" +
"  width: 250px;\n" +
"  height: 250px;\n" +
"  border-radius: 50%;\n" +
"  border: 5px solid #ecf0f1;\n" +
"  transition: transform 0.4s ease;\n" +
"}\n" +
"\n" +
".cover-img:hover {\n" +
"  transform: rotate(360deg);\n" +
"}\n" +
"\n" +
".audio-controls audio {\n" +
"  width: 100%;\n" +
"  accent-color: #e74c3c;\n" +
"}\n" +
"\n" +
".volume-control {\n" +
"  margin-top: 15px;\n" +
"  display: flex;\n" +
"  align-items: center;\n" +
"  justify-content: center;\n" +
"  gap: 10px;\n" +
"}\n" +
"\n" +
".volume-control input {\n" +
"  width: 150px;\n" +
"  accent-color: #e74c3c;\n" +
"}\n" +
"\n" +
".controls {\n" +
"  display: flex;\n" +
"  justify-content: center;\n" +
"  gap: 15px;\n" +
"  margin-top: 20px;\n" +
"}\n" +
"\n" +
".btn {\n" +
"  background: linear-gradient(45deg, #e74c3c, #c0392b);\n" +
"  color: #fff;\n" +
"  border: none;\n" +
"  padding: 12px 25px;\n" +
"  border-radius: 12px;\n" +
"  cursor: pointer;\n" +
"  font-size: 1.1rem;\n" +
"  transition: transform 0.3s ease, background 0.4s ease;\n" +
"  box-shadow: 0 5px 18px rgba(231, 76, 60, 0.4);\n" +
"  margin: 10px;\n" +
"}\n" +
"\n" +
".btn:hover {\n" +
"  transform: scale(1.05);\n" +
"  background: linear-gradient(45deg, #c0392b, #e74c3c);\n" +
"}\n" +
"\n" +
".quiz-question {\n" +
"  margin-bottom: 25px;\n" +
"  text-align: right;\n" +
"}\n" +
"\n" +
".option-label {\n" +
"  display: block;\n" +
"  margin: 10px 0;\n" +
"  padding: 10px;\n" +
"  border-radius: 10px;\n" +
"  background: #f9f9f9;\n" +
"  transition: background 0.3s ease;\n" +
"}\n" +
"\n" +
"body.dark-mode .option-label {\n" +
"  background: #34495e;\n" +
"}\n" +
"\n" +
".option-label:hover {\n" +
"  background: #ecf0f1;\n" +
"}\n" +
"\n" +
"body.dark-mode .option-label:hover {\n" +
"  background: #2c3e50;\n" +
"}\n" +
"\n" +
"#score {\n" +
"  font-size: 1.3rem;\n" +
"  color: #27ae60;\n" +
"  animation: pulse 1s infinite;\n" +
"}\n" +
"\n" +
"@keyframes pulse {\n" +
"  0% { transform: scale(1); }\n" +
"  50% { transform: scale(1.05); }\n" +
"  100% { transform: scale(1); }\n" +
"}\n" +
"\n" +
"#prayerTimes, #hadithText, #dhikrCount, #ayahText, #ayahTranslation, #duaText, #hijriDate {\n" +
"  margin-top: 20px;\n" +
"  font-size: 1.2rem;\n" +
"  line-height: 1.6;\n" +
"  color: #34495e;\n" +
"}\n" +
"\n" +
"body.dark-mode #prayerTimes, body.dark-mode #hadithText, body.dark-mode #dhikrCount, body.dark-mode #ayahText, body.dark-mode #ayahTranslation, body.dark-mode #duaText, body.dark-mode #hijriDate {\n" +
"  color: #bdc3c7;\n" +
"}\n" +
"\n" +
"#dhikrCount {\n" +
"  font-size: 4rem;\n" +
"  color: #2980b9;\n" +
"}\n" +
"\n" +
"@media (max-width: 600px) {\n" +
"  .tab-navigation {\n" +
"    flex-direction: column;\n" +
"  }\n" +
"  .tab-btn {\n" +
"    width: 100%;\n" +
"    margin: 5px 0;\n" +
"  }\n" +
"  .tab-content {\n" +
"    padding: 20px;\n" +
"  }\n" +
"  h1 {\n" +
"    font-size: 2.5rem;\n" +
"  }\n" +
"  h2 {\n" +
"    font-size: 1.8rem;\n" +
"  }\n" +
"  .cover-img {\n" +
"    width: 200px;\n" +
"    height: 200px;\n" +
"  }\n" +
"}"
    ).getBytes(StandardCharsets.UTF_8)
);

                    
                    Files.write(projectRoot.resolve("script.js"),
    ("// Theme Toggle\n" +
"document.getElementById('themeToggle').addEventListener('click', () => {\n" +
"  document.body.classList.toggle('dark-mode');\n" +
"});\n" +
"\n" +
"// Tab Switching\n" +
"function openTab(tabId) {\n" +
"  const tabs = document.querySelectorAll('.tab-content');\n" +
"  const btns = document.querySelectorAll('.tab-btn');\n" +
"  tabs.forEach(tab => tab.classList.remove('active'));\n" +
"  btns.forEach(btn => btn.classList.remove('active'));\n" +
"  document.getElementById(tabId).classList.add('active');\n" +
"  document.querySelector(`[onclick=\"openTab('${tabId}')\"]`).classList.add('active');\n" +
"}\n" +
"\n" +
"// Media Controls\n" +
"const audio = document.getElementById('audioPlayer');\n" +
"const volumeSlider = document.getElementById('volume');\n" +
"volumeSlider.addEventListener('input', () => {\n" +
"  audio.volume = volumeSlider.value;\n" +
"});\n" +
"\n" +
"function forward() {\n" +
"  audio.currentTime = Math.min(audio.currentTime + 10, audio.duration);\n" +
"  animateButton('forward');\n" +
"}\n" +
"\n" +
"function backward() {\n" +
"  audio.currentTime = Math.max(audio.currentTime - 10, 0);\n" +
"  animateButton('backward');\n" +
"}\n" +
"\n" +
"function togglePlay() {\n" +
"  const playButton = document.querySelector('button[onclick=\"togglePlay()\"]');\n" +
"  if (audio.paused) {\n" +
"    audio.play();\n" +
"    playButton.innerHTML = '<i class=\"fas fa-pause\"></i>';\n" +
"  } else {\n" +
"    audio.pause();\n" +
"    playButton.innerHTML = '<i class=\"fas fa-play\"></i>';\n" +
"  }\n" +
"  animateButton('togglePlay');\n" +
"}\n" +
"\n" +
"function animateButton(action) {\n" +
"  const button = document.querySelector(`button[onclick=\"${action}()\"]`);\n" +
"  button.style.transform = 'scale(1.1)';\n" +
"  setTimeout(() => {\n" +
"    button.style.transform = 'scale(1)';\n" +
"  }, 200);\n" +
"}\n" +
"\n" +
"// Quiz Data and Functions\n" +
"const questions = [\n" +
"  {\n" +
"    question: \"ما هي أول سورة نزلت في القرآن؟\",\n" +
"    options: [\"سورة البقرة\", \"سورة العلق\", \"سورة الفاتحة\", \"سورة النور\"],\n" +
"    answer: \"سورة العلق\"\n" +
"  },\n" +
"  {\n" +
"    question: \"من هو أول من أسلم من الصبيان؟\",\n" +
"    options: [\"عمر بن الخطاب\", \"علي بن أبي طالب\", \"عثمان بن عفان\", \"عبدالله بن عباس\"],\n" +
"    answer: \"علي بن أبي طالب\"\n" +
"  },\n" +
"  {\n" +
"    question: \"ما هي القبلة الأولى للمسلمين؟\",\n" +
"    options: [\"المسجد الحرام\", \"المسجد الأقصى\", \"المسجد النبوي\", \"الكعبة\"],\n" +
"    answer: \"المسجد الأقصى\"\n" +
"  },\n" +
"  {\n" +
"    question: \"من هو النبي الذي ابتلعه الحوت؟\",\n" +
"    options: [\"موسى\", \"يونس\", \"نوح\", \"إبراهيم\"],\n" +
"    answer: \"يونس\"\n" +
"  },\n" +
"  {\n" +
"    question: \"كم عدد أركان الإسلام؟\",\n" +
"    options: [\"3\", \"4\", \"5\", \"6\"],\n" +
"    answer: \"5\"\n" +
"  },\n" +
"  {\n" +
"    question: \"ما هي معركة بدر؟\",\n" +
"    options: [\"أول معركة للمسلمين\", \"آخر معركة\", \"معاهدة\", \"هجرة\"],\n" +
"    answer: \"أول معركة للمسلمين\"\n" +
"  },\n" +
"  {\n" +
"    question: \"من هو خاتم الأنبياء؟\",\n" +
"    options: [\"موسى\", \"عيسى\", \"محمد\", \"إبراهيم\"],\n" +
"    answer: \"محمد\"\n" +
"  },\n" +
"  {\n" +
"    question: \"كم عدد أركان الإيمان؟\",\n" +
"    options: [\"5\", \"6\", \"7\", \"4\"],\n" +
"    answer: \"6\"\n" +
"  },\n" +
"  {\n" +
"    question: \"ما هي السورة التي تسمى عروس القرآن؟\",\n" +
"    options: [\"سورة الرحمن\", \"سورة يس\", \"سورة الفاتحة\", \"سورة الإخلاص\"],\n" +
"    answer: \"سورة الرحمن\"\n" +
"  },\n" +
"  {\n" +
"    question: \"من هو النبي الذي بنى السفينة؟\",\n" +
"    options: [\"موسى\", \"يونس\", \"نوح\", \"إبراهيم\"],\n" +
"    answer: \"نوح\"\n" +
"  }\n" +
"];\n" +
"\n" +
"function loadQuiz() {\n" +
"  const quizDiv = document.getElementById('quiz');\n" +
"  quizDiv.innerHTML = '';\n" +
"  questions.forEach((q, i) => {\n" +
"    const questionBlock = document.createElement('div');\n" +
"    questionBlock.classList.add('quiz-question');\n" +
"    questionBlock.innerHTML = `<p><strong>${i + 1}. ${q.question}</strong></p>`;\n" +
"    q.options.forEach(opt => {\n" +
"      const id = `q${i}-${opt}`;\n" +
"      questionBlock.innerHTML += `\n" +
"        <label class=\"option-label\">\n" +
"          <input type=\"radio\" name=\"q${i}\" value=\"${opt}\" id=\"${id}\"> ${opt}\n" +
"        </label>`;\n" +
"    });\n" +
"    quizDiv.appendChild(questionBlock);\n" +
"  });\n" +
"}\n" +
"\n" +
"function submitQuiz() {\n" +
"  let score = 0;\n" +
"  const scoreElement = document.getElementById('score');\n" +
"  questions.forEach((q, i) => {\n" +
"    const selected = document.querySelector(`input[name=\"q${i}\"]:checked`);\n" +
"    if (selected && selected.value === q.answer) {\n" +
"      score++;\n" +
"    }\n" +
"  });\n" +
"  document.getElementById('score').textContent = `✔️ نتيجتك: ${score} من ${questions.length}`;\n" +
"}\n" +
"\n" +
"// Prayer Times\n" +
"function getPrayerTimes() {\n" +
"  const prayerTimesDiv = document.getElementById('prayerTimes');\n" +
"  if (navigator.geolocation) {\n" +
"    navigator.geolocation.getCurrentPosition(\n" +
"      position => {\n" +
"        const lat = position.coords.latitude;\n" +
"        const lon = position.coords.longitude;\n" +
"        fetch(`http://api.aladhan.com/v1/timingsByCity?city=Cairo&country=Egypt&method=2`)\n" +
"          .then(response => response.json())\n" +
"          .then(data => {\n" +
"            const timings = data.data.timings;\n" +
"            prayerTimesDiv.innerHTML = `\n" +
"              <p>الفجر: ${timings.Fajr}</p>\n" +
"              <p>الشروق: ${timings.Sunrise}</p>\n" +
"              <p>الظهر: ${timings.Dhuhr}</p>\n" +
"              <p>العصر: ${timings.Asr}</p>\n" +
"              <p>المغرب: ${timings.Maghrib}</p>\n" +
"              <p>العشاء: ${timings.Isha}</p>\n" +
"            `;\n" +
"          })\n" +
"          .catch(error => {\n" +
"            console.error('Error fetching prayer times:', error);\n" +
"            prayerTimesDiv.innerHTML = '<p>فشل في جلب أوقات الصلاة، حاول مرة أخرى.</p>';\n" +
"          });\n" +
"      },\n" +
"      () => {\n" +
"        prayerTimesDiv.innerHTML = '<p>الرجاء تفعيل الموقع الجغرافي أو استخدام مدينة افتراضية.</p>';\n" +
"        fetchPrayerTimesByDefaultCity();\n" +
"      }\n" +
"    );\n" +
"  } else {\n" +
"    prayerTimesDiv.innerHTML = '<p>Geolocation غير مدعوم، جاري استخدام مدينة افتراضية.</p>';\n" +
"    fetchPrayerTimesByDefaultCity();\n" +
"  }\n" +
"}\n" +
"\n" +
"function fetchPrayerTimesByDefaultCity() {\n" +
"  fetch('http://api.aladhan.com/v1/timingsByCity?city=Cairo&country=Egypt&method=2')\n" +
"    .then(response => response.json())\n" +
"    .then(data => {\n" +
"      const timings = data.data.timings;\n" +
"      document.getElementById('prayerTimes').innerHTML = `\n" +
"        <p>الفجر: ${timings.Fajr}</p>\n" +
"        <p>الشروق: ${timings.Sunrise}</p>\n" +
"        <p>الظهر: ${timings.Dhuhr}</p>\n" +
"        <p>العصر: ${timings.Asr}</p>\n" +
"        <p>المغرب: ${timings.Maghrib}</p>\n" +
"        <p>العشاء: ${timings.Isha}</p>\n" +
"      `;\n" +
"    })\n" +
"    .catch(error => {\n" +
"      console.error('Error fetching default prayer times:', error);\n" +
"      document.getElementById('prayerTimes').innerHTML = '<p>فشل في جلب الأوقات، تحقق من الاتصال.</p>';\n" +
"    });\n" +
"}\n" +
"\n" +
"document.getElementById('getPrayerTimesBtn').addEventListener('click', getPrayerTimes);\n" +
"\n" +
"// Hadith\n" +
"const hadiths = [\n" +
"  \"قال رسول الله ﷺ: الْمُسْلِمُ مَنْ سَلِمَ الْمُسْلِمُونَ مِنْ لِسَانِهِ وَيَدِهِ.\",\n" +
"  \"قال رسول الله ﷺ: مَنْ صَلَّى عَلَيَّ صَلَاةً وَاحِدَةً صَلَّى اللَّهُ عَلَيْهِ عَشْرَ صَلَوَاتٍ.\",\n" +
"  \"قال رسول الله ﷺ: خَيْرُكُمْ مَنْ تَعَلَّمَ الْقُرْآنَ وَعَلَّمَهُ.\",\n" +
"  \"قال رسول الله ﷺ: الدُّعَاءُ هُوَ الْعِبَادَةُ.\",\n" +
"  \"قال رسول الله ﷺ: إِنَّ اللَّهَ يُحِبُّ إِذَا عَمِلَ أَحَدُكُمْ عَمَلًا أَنْ يُتْقِنَهُ.\",\n" +
"  \"قال رسول الله ﷺ: مَنْ سَلَكَ طَرِيقًا يَطْلُبُ فِيهِ عِلْمًا سَلَكَ اللَّهُ بِهِ طَرِيقًا مِنْ طُرُقِ الْجَنَّةِ.\",\n" +
"  \"قال رسول الله ﷺ: إِنَّمَا الْأَعْمَالُ بِالنِّيَّاتِ.\"\n" +
"];\n" +
"\n" +
"function showRandomHadith() {\n" +
"  const randomIndex = Math.floor(Math.random() * hadiths.length);\n" +
"  document.getElementById('hadithText').textContent = hadiths[randomIndex];\n" +
"}\n" +
"\n" +
"// Dhikr Counter\n" +
"let dhikrCount = 0;\n" +
"function incrementDhikr() {\n" +
"  dhikrCount++;\n" +
"  document.getElementById('dhikrCount').textContent = dhikrCount;\n" +
"  animateDhikr();\n" +
"}\n" +
"\n" +
"function resetDhikr() {\n" +
"  dhikrCount = 0;\n" +
"  document.getElementById('dhikrCount').textContent = dhikrCount;\n" +
"}\n" +
"\n" +
"function animateDhikr() {\n" +
"  const countElement = document.getElementById('dhikrCount');\n" +
"  countElement.style.transform = 'scale(1.2)';\n" +
"  setTimeout(() => {\n" +
"    countElement.style.transform = 'scale(1)';\n" +
"  }, 200);\n" +
"}\n" +
"\n" +
"// Random Quran Ayah\n" +
"function getRandomAyah() {\n" +
"  fetch('https://api.alquran.cloud/v1/ayah/random/ar.alafasy')\n" +
"    .then(response => response.json())\n" +
"    .then(data => {\n" +
"      document.getElementById('ayahText').textContent = data.data.text;\n" +
"      document.getElementById('ayahTranslation').textContent = `سورة ${data.data.surah.name} - آية ${data.data.numberInSurah}`;\n" +
"    })\n" +
"    .catch(error => {\n" +
"      console.error('Error fetching ayah:', error);\n" +
"      document.getElementById('ayahText').textContent = 'فشل في جلب الآية، حاول مرة أخرى.';\n" +
"      document.getElementById('ayahTranslation').textContent = '';\n" +
"    });\n" +
"}\n" +
"\n" +
"document.getElementById('getAyahBtn').addEventListener('click', getRandomAyah);\n" +
"\n" +
"// Random Dua\n" +
"const duas = [\n" +
"  \"اللهم أنت ربي لا إله إلا أنت، خلقتني وأنا عبدك، وأنا على عهدك ووعدك ما استطعت، أعوذ بك من شر ما صنعت، أبوء لك بنعمتك علي، وأبوء بذنبي فاغفر لي فإنه لا يغفر الذنوب إلا أنت.\",\n" +
"  \"اللهم إني أسألك الهدى والتقى والعفاف والغنى.\",\n" +
"  \"ربنا آتنا في الدنيا حسنة وفي الآخرة حسنة وقنا عذاب النار.\",\n" +
"  \"اللهم اغفر لي ذنبي كله، دقه وجله، وأوله وآخره، وعلا نيته وسرّه.\",\n" +
"  \"اللهم إني أعوذ بك من فتنة النار وعذاب النار، وفتنة القبر، وعذاب القبر، وشر فتنة الغنى، وشر فتنة الفقر، اللهم إني أعوذ بك من شر فتنة المسيح الدجال.\"\n" +
"];\n" +
"\n" +
"function showRandomDua() {\n" +
"  const randomIndex = Math.floor(Math.random() * duas.length);\n" +
"  document.getElementById('duaText').textContent = duas[randomIndex];\n" +
"}\n" +
"\n" +
"// Hijri Date\n" +
"function getHijriDate() {\n" +
"  const today = new Date().toISOString().slice(0, 10);\n" +
"  fetch(`http://api.aladhan.com/v1/gToH?date=${today}`)\n" +
"    .then(response => response.json())\n" +
"    .then(data => {\n" +
"      const hijri = data.data.hijri;\n" +
"      document.getElementById('hijriDate').textContent = `التاريخ الهجري: ${hijri.day} ${hijri.month.ar} ${hijri.year} هـ`;\n" +
"    })\n" +
"    .catch(error => {\n" +
"      console.error('Error fetching Hijri date:', error);\n" +
"      document.getElementById('hijriDate').textContent = 'فشل في جلب التاريخ الهجري، حاول مرة أخرى.';\n" +
"    });\n" +
"}\n" +
"\n" +
"document.getElementById('getHijriDateBtn').addEventListener('click', getHijriDate);\n" +
"\n" +
"// Load the quiz on page load\n" +
"window.onload = () => {\n" +
"  loadQuiz();\n" +
"  showRandomHadith(); // Show initial hadith\n" +
"  openTab('player'); // Open default tab\n" +
"  getPrayerTimes(); // Auto-fetch prayer times\n" +
"  getRandomAyah(); // Auto-fetch initial ayah\n" +
"  getHijriDate(); // Auto-fetch Hijri date\n" +
"};"
    ).getBytes(StandardCharsets.UTF_8)
);

                    
                  //  refreshProjectTree();
                    
                //    try {
//    refreshProjectTree();
//} catch (IOException e) {
//    e.printStackTrace();
//}

        SplitPane splitPane = new SplitPane();
        codeArea.setWrapText(true);
        scpane=new ScrollPane();
        scpane.setFitToHeight(true);
        scpane.setFitToWidth(true);
        scpane.getStylesheets().add(this.getClass().getResource(codearea_syntax).toExternalForm());
        scpane.getStylesheets().add(this.getClass().getResource(app_theme).toExternalForm());
        scpane.setContent(new VirtualizedScrollPane(this.codeArea));
        scpane1=new ScrollPane();
        scpane1.setFitToHeight(true);
        scpane1.setFitToWidth(true);
        scpane1.setContent(projectTree);
        scpane2=new ScrollPane();
        scpane2.setFitToHeight(true);
        //scpane2.setFitToWidth(true);
        scpane2.setContent(codee);
        splitPane.getItems().addAll(scpane1, scpane,scpane2);
        splitPane.setDividerPositions(0.2, 0.8);
        root.setCenter(splitPane);
        tabpane.setVisible(false);
        
        
        codeArea.setDisable(false);
        codee.setDisable(false);
        
        newhtml.setDisable(true);
        openf.setDisable(true);
        
        String userpathh = System.getProperty("user.home");
        String pao=projectRoot.toFile().toString();
        
        Path sourcePath1 = Paths.get(userpathh + "/AppData/Roaming/resources/data/1.jpg");     // Source file path
        Path targetPath1 = Paths.get(pao+"\\"+"1.jpg");     // Destination path
        
        Path sourcePath2 = Paths.get(userpathh + "/AppData/Roaming/resources/data/1.mp3");     // Source file path
        Path targetPath2 = Paths.get(pao+"\\"+"1.mp3");     // Destination path
        
       // Path sourcePath3 = Paths.get(userpathh + "/AppData/Roaming/resources/data/1.pdf");     // Source file path
       // Path targetPath3 = Paths.get(pao+"\\"+"1.pdf");     // Destination path

        try {
            Files.copy(sourcePath1, targetPath1, StandardCopyOption.REPLACE_EXISTING);
            Files.copy(sourcePath2, targetPath2, StandardCopyOption.REPLACE_EXISTING);
          //  Files.copy(sourcePath3, targetPath3, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
                      try {
    refreshProjectTree();
} catch (IOException e) {
    e.printStackTrace();
}

        
                    
                } catch (IOException ex) {
                    showAlert("Error", "Failed to create project: " + ex.getMessage());
                }
            });
        }
          
      //Load here 
      
	  
           
      }
	  
      else if (option.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled.");
      noti.position(Pos.CENTER);
      noti.showInformation();
      }
      else {}  
      
      
      
      
      }


	  
      else {
	  
      codeArea.clear();
	codee.getEngine().loadContent("");
      
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select Location to Create Project");
        Path selectedDir = Optional.ofNullable(chooser.showDialog(null))
                .map(File::toPath)
                .orElse(null);
        if (selectedDir != null) {
            TextInputDialog dialog = new TextInputDialog("NewHtmlProject");
            dialog.setTitle("Project Name");
            dialog.setHeaderText("Enter project name:");
            DialogPane dialogPaneu = dialog.getDialogPane();
            dialogPaneu.getStylesheets().add(
            getClass().getResource(app_theme).toExternalForm());
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(name -> {
                try {
                    projectRoot = selectedDir.resolve(name);
                    Files.createDirectories(projectRoot);
                    
                    Files.write(projectRoot.resolve("index.html"),
    ("<!DOCTYPE html>\n" +
"<html lang=\"ar\" dir=\"rtl\">\n" +
"<head>\n" +
"  <meta charset=\"UTF-8\">\n" +
"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"  <title>أنا المسلم - برنامج ديني متقدم</title>\n" +
"  <link rel=\"stylesheet\" href=\"style.css\">\n" +
"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css\">\n" +
"</head>\n" +
"<body>\n" +
"  <div class=\"main-container\">\n" +
"    <header>\n" +
"      <h1>🎵 أنا المسلم</h1>\n" +
"      <button id=\"themeToggle\" class=\"btn\">تبديل الوضع (فاتح/داكن)</button>\n" +
"    </header>\n" +
"\n" +
"    <div class=\"tab-navigation\">\n" +
"      <button class=\"tab-btn active\" onclick=\"openTab('player')\">مشغل الصوت</button>\n" +
"      <button class=\"tab-btn\" onclick=\"openTab('quiz')\">الاختبار</button>\n" +
"      <button class=\"tab-btn\" onclick=\"openTab('tafsir')\">التفسير</button>\n" +
"      <button class=\"tab-btn\" onclick=\"openTab('prayer')\">أوقات الصلاة</button>\n" +
"      <button class=\"tab-btn\" onclick=\"openTab('hadith')\">الحديث</button>\n" +
"      <button class=\"tab-btn\" onclick=\"openTab('dhikr')\">الذكر</button>\n" +
"      <button class=\"tab-btn\" onclick=\"openTab('quran')\">القرآن</button>\n" +
"      <button class=\"tab-btn\" onclick=\"openTab('dua')\">الدعاء</button>\n" +
"      <button class=\"tab-btn\" onclick=\"openTab('calendar')\">التقويم</button>\n" +
"    </div>\n" +
"\n" +
"    <section id=\"player\" class=\"tab-content active\">\n" +
"      <h2>مشغل الصوت</h2>\n" +
"      <div class=\"cover-img-wrapper\">\n" +
"        <img src=\"1.jpg\" alt=\"صورة الغلاف\" class=\"cover-img\">\n" +
"      </div>\n" +
"      <div class=\"audio-controls\">\n" +
"        <audio id=\"audioPlayer\" controls>\n" +
"          <source src=\"1.mp3\" type=\"audio/mpeg\">\n" +
"        </audio>\n" +
"        <div class=\"volume-control\">\n" +
"          <label for=\"volume\">الصوت:</label>\n" +
"          <input type=\"range\" id=\"volume\" min=\"0\" max=\"1\" step=\"0.1\" value=\"1\">\n" +
"        </div>\n" +
"      </div>\n" +
"      <div class=\"controls\">\n" +
"        <button onclick=\"backward()\" class=\"btn\"><i class=\"fas fa-backward\"></i> 10 ثوانٍ للخلف</button>\n" +
"        <button onclick=\"togglePlay()\" class=\"btn\"><i class=\"fas fa-play-pause\"></i></button>\n" +
"        <button onclick=\"forward()\" class=\"btn\"><i class=\"fas fa-forward\"></i> 10 ثوانٍ للأمام</button>\n" +
"      </div>\n" +
"    </section>\n" +
"\n" +
"    <section id=\"quiz\" class=\"tab-content\">\n" +
"      <h2>❓ اختبار معلومات إسلامية</h2>\n" +
"      <div id=\"quiz\"></div>\n" +
"      <button onclick=\"submitQuiz()\">تصحيح</button>\n" +
"      <p id=\"score\"></p>\n" +
"    </section>\n" +
"\n" +
"    <section id=\"tafsir\" class=\"tab-content\">\n" +
"      <h2>📖 تفسير سورة الفاتحة</h2>\n" +
"      <p>\n" +
"        سورة الفاتحة هي أول سورة في القرآن الكريم، وتسمى أم الكتاب والسبع المثاني. تحتوي على سبع آيات تتضمن الثناء على الله، وطلب الهداية، والدعاء بالثبات على الصراط المستقيم، والابتعاد عن طريق المغضوب عليهم والضالين.\n" +
"        <br><br>\n" +
"        <strong>الحمد لله رب العالمين:</strong> الثناء الكامل لله رب كل شيء.<br>\n" +
"        <strong>الرحمن الرحيم:</strong> صفات الرحمة الواسعة التي تشمل الدنيا والآخرة.<br>\n" +
"        <strong>مالك يوم الدين:</strong> إقرار بأن الله وحده هو الحاكم يوم القيامة.<br>\n" +
"        <strong>إياك نعبد وإياك نستعين:</strong> توحيد العبادة والاستعانة بالله فقط.<br>\n" +
"        <strong>اهدنا الصراط المستقيم:</strong> دعاء بأن يهدينا الله إلى الطريق الصحيح.<br>\n" +
"        <strong>صراط الذين أنعمت عليهم:</strong> هو طريق الأنبياء والصالحين.<br>\n" +
"        <strong>غير المغضوب عليهم ولا الضالين:</strong> طلب الحماية من طرق الذين غضب الله عليهم والذين ضلوا.\n" +
"      </p>\n" +
"    </section>\n" +
"\n" +
"    <section id=\"prayer\" class=\"tab-content\">\n" +
"      <h2>🕌 أوقات الصلاة</h2>\n" +
"      <button id=\"getPrayerTimesBtn\" class=\"btn\">احصل على أوقات الصلاة</button>\n" +
"      <div id=\"prayerTimes\"></div>\n" +
"    </section>\n" +
"\n" +
"    <section id=\"hadith\" class=\"tab-content\">\n" +
"      <h2>📜 حديث يومي</h2>\n" +
"      <button onclick=\"showRandomHadith()\" class=\"btn\">عرض حديث عشوائي</button>\n" +
"      <p id=\"hadithText\"></p>\n" +
"    </section>\n" +
"\n" +
"    <section id=\"dhikr\" class=\"tab-content\">\n" +
"      <h2>🔢 عداد الذكر</h2>\n" +
"      <p id=\"dhikrCount\">0</p>\n" +
"      <button onclick=\"incrementDhikr()\" class=\"btn\">ذكر الله</button>\n" +
"      <button onclick=\"resetDhikr()\" class=\"btn\">إعادة تعيين</button>\n" +
"    </section>\n" +
"\n" +
"    <section id=\"quran\" class=\"tab-content\">\n" +
"      <h2>📖 آية قرآنية عشوائية</h2>\n" +
"      <button id=\"getAyahBtn\" class=\"btn\">عرض آية عشوائية</button>\n" +
"      <p id=\"ayahText\"></p>\n" +
"      <p id=\"ayahTranslation\"></p>\n" +
"    </section>\n" +
"\n" +
"    <section id=\"dua\" class=\"tab-content\">\n" +
"      <h2>🤲 دعاء يومي</h2>\n" +
"      <button onclick=\"showRandomDua()\" class=\"btn\">عرض دعاء عشوائي</button>\n" +
"      <p id=\"duaText\"></p>\n" +
"    </section>\n" +
"\n" +
"    <section id=\"calendar\" class=\"tab-content\">\n" +
"      <h2>📅 التقويم الهجري</h2>\n" +
"      <button id=\"getHijriDateBtn\" class=\"btn\">احصل على التاريخ الهجري</button>\n" +
"      <p id=\"hijriDate\"></p>\n" +
"    </section>\n" +
"  </div>\n" +
"\n" +
"  <script src=\"script.js\"></script>\n" +
"</body>\n" +
"</html>").getBytes(StandardCharsets.UTF_8)
);

                    
                    
                    Files.write(projectRoot.resolve("style.css"),
    ("/* Global Styles */\n" +
"body {\n" +
"  margin: 0;\n" +
"  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n" +
"  background: linear-gradient(135deg, #d9e7ff, #ffe3e3);\n" +
"  color: #2c3e50;\n" +
"  display: flex;\n" +
"  justify-content: center;\n" +
"  align-items: center;\n" +
"  min-height: 100vh;\n" +
"  padding: 20px;\n" +
"  transition: background 0.5s ease, color 0.5s ease;\n" +
"}\n" +
"\n" +
"body.dark-mode {\n" +
"  background: linear-gradient(135deg, #2c3e50, #34495e);\n" +
"  color: #ecf0f1;\n" +
"}\n" +
"\n" +
".main-container {\n" +
"  max-width: 900px;\n" +
"  width: 100%;\n" +
"  display: flex;\n" +
"  flex-direction: column;\n" +
"  align-items: center;\n" +
"}\n" +
"\n" +
"header {\n" +
"  text-align: center;\n" +
"  margin-bottom: 40px;\n" +
"}\n" +
"\n" +
"header h1 {\n" +
"  font-size: 3rem;\n" +
"  color: #e74c3c;\n" +
"  text-shadow: 3px 3px 6px rgba(0, 0, 0, 0.2);\n" +
"  animation: fadeIn 1.5s ease-in-out;\n" +
"}\n" +
"\n" +
"#themeToggle {\n" +
"  background: linear-gradient(45deg, #e74c3c, #f39c12);\n" +
"  margin-top: 10px;\n" +
"}\n" +
"\n" +
".tab-navigation {\n" +
"  display: flex;\n" +
"  flex-wrap: wrap;\n" +
"  justify-content: center;\n" +
"  margin-bottom: 30px;\n" +
"}\n" +
"\n" +
".tab-btn {\n" +
"  background: linear-gradient(45deg, #bdc3c7, #95a5a6);\n" +
"  color: #2c3e50;\n" +
"  border: none;\n" +
"  padding: 10px 20px;\n" +
"  margin: 5px;\n" +
"  border-radius: 10px;\n" +
"  cursor: pointer;\n" +
"  transition: background 0.3s ease;\n" +
"}\n" +
"\n" +
".tab-btn.active {\n" +
"  background: linear-gradient(45deg, #e74c3c, #c0392b);\n" +
"  color: #fff;\n" +
"}\n" +
"\n" +
"body.dark-mode .tab-btn {\n" +
"  background: linear-gradient(45deg, #34495e, #2c3e50);\n" +
"  color: #ecf0f1;\n" +
"}\n" +
"\n" +
"body.dark-mode .tab-btn.active {\n" +
"  background: linear-gradient(45deg, #e74c3c, #c0392b);\n" +
"}\n" +
"\n" +
".tab-content {\n" +
"  display: none;\n" +
"  background: rgba(255, 255, 255, 0.95);\n" +
"  backdrop-filter: blur(8px);\n" +
"  border-radius: 20px;\n" +
"  padding: 30px;\n" +
"  box-shadow: 0 12px 40px rgba(0, 0, 0, 0.15);\n" +
"  width: 100%;\n" +
"  max-width: 700px;\n" +
"  transition: transform 0.4s ease, box-shadow 0.4s ease;\n" +
"  text-align: center;\n" +
"}\n" +
"\n" +
".tab-content.active {\n" +
"  display: block;\n" +
"}\n" +
"\n" +
"body.dark-mode .tab-content {\n" +
"  background: rgba(44, 62, 80, 0.95);\n" +
"  color: #ecf0f1;\n" +
"}\n" +
"\n" +
".tab-content:hover {\n" +
"  transform: translateY(-10px);\n" +
"  box-shadow: 0 15px 45px rgba(0, 0, 0, 0.2);\n" +
"}\n" +
"\n" +
"h2 {\n" +
"  color: #e74c3c;\n" +
"  margin-bottom: 20px;\n" +
"  font-size: 2rem;\n" +
"}\n" +
"\n" +
".cover-img {\n" +
"  width: 250px;\n" +
"  height: 250px;\n" +
"  border-radius: 50%;\n" +
"  border: 5px solid #ecf0f1;\n" +
"  transition: transform 0.4s ease;\n" +
"}\n" +
"\n" +
".cover-img:hover {\n" +
"  transform: rotate(360deg);\n" +
"}\n" +
"\n" +
".audio-controls audio {\n" +
"  width: 100%;\n" +
"  accent-color: #e74c3c;\n" +
"}\n" +
"\n" +
".volume-control {\n" +
"  margin-top: 15px;\n" +
"  display: flex;\n" +
"  align-items: center;\n" +
"  justify-content: center;\n" +
"  gap: 10px;\n" +
"}\n" +
"\n" +
".volume-control input {\n" +
"  width: 150px;\n" +
"  accent-color: #e74c3c;\n" +
"}\n" +
"\n" +
".controls {\n" +
"  display: flex;\n" +
"  justify-content: center;\n" +
"  gap: 15px;\n" +
"  margin-top: 20px;\n" +
"}\n" +
"\n" +
".btn {\n" +
"  background: linear-gradient(45deg, #e74c3c, #c0392b);\n" +
"  color: #fff;\n" +
"  border: none;\n" +
"  padding: 12px 25px;\n" +
"  border-radius: 12px;\n" +
"  cursor: pointer;\n" +
"  font-size: 1.1rem;\n" +
"  transition: transform 0.3s ease, background 0.4s ease;\n" +
"  box-shadow: 0 5px 18px rgba(231, 76, 60, 0.4);\n" +
"  margin: 10px;\n" +
"}\n" +
"\n" +
".btn:hover {\n" +
"  transform: scale(1.05);\n" +
"  background: linear-gradient(45deg, #c0392b, #e74c3c);\n" +
"}\n" +
"\n" +
".quiz-question {\n" +
"  margin-bottom: 25px;\n" +
"  text-align: right;\n" +
"}\n" +
"\n" +
".option-label {\n" +
"  display: block;\n" +
"  margin: 10px 0;\n" +
"  padding: 10px;\n" +
"  border-radius: 10px;\n" +
"  background: #f9f9f9;\n" +
"  transition: background 0.3s ease;\n" +
"}\n" +
"\n" +
"body.dark-mode .option-label {\n" +
"  background: #34495e;\n" +
"}\n" +
"\n" +
".option-label:hover {\n" +
"  background: #ecf0f1;\n" +
"}\n" +
"\n" +
"body.dark-mode .option-label:hover {\n" +
"  background: #2c3e50;\n" +
"}\n" +
"\n" +
"#score {\n" +
"  font-size: 1.3rem;\n" +
"  color: #27ae60;\n" +
"  animation: pulse 1s infinite;\n" +
"}\n" +
"\n" +
"@keyframes pulse {\n" +
"  0% { transform: scale(1); }\n" +
"  50% { transform: scale(1.05); }\n" +
"  100% { transform: scale(1); }\n" +
"}\n" +
"\n" +
"#prayerTimes, #hadithText, #dhikrCount, #ayahText, #ayahTranslation, #duaText, #hijriDate {\n" +
"  margin-top: 20px;\n" +
"  font-size: 1.2rem;\n" +
"  line-height: 1.6;\n" +
"  color: #34495e;\n" +
"}\n" +
"\n" +
"body.dark-mode #prayerTimes, body.dark-mode #hadithText, body.dark-mode #dhikrCount, body.dark-mode #ayahText, body.dark-mode #ayahTranslation, body.dark-mode #duaText, body.dark-mode #hijriDate {\n" +
"  color: #bdc3c7;\n" +
"}\n" +
"\n" +
"#dhikrCount {\n" +
"  font-size: 4rem;\n" +
"  color: #2980b9;\n" +
"}\n" +
"\n" +
"@media (max-width: 600px) {\n" +
"  .tab-navigation {\n" +
"    flex-direction: column;\n" +
"  }\n" +
"  .tab-btn {\n" +
"    width: 100%;\n" +
"    margin: 5px 0;\n" +
"  }\n" +
"  .tab-content {\n" +
"    padding: 20px;\n" +
"  }\n" +
"  h1 {\n" +
"    font-size: 2.5rem;\n" +
"  }\n" +
"  h2 {\n" +
"    font-size: 1.8rem;\n" +
"  }\n" +
"  .cover-img {\n" +
"    width: 200px;\n" +
"    height: 200px;\n" +
"  }\n" +
"}"
    ).getBytes(StandardCharsets.UTF_8)
);

                    
                    Files.write(projectRoot.resolve("script.js"),
    ("// Theme Toggle\n" +
"document.getElementById('themeToggle').addEventListener('click', () => {\n" +
"  document.body.classList.toggle('dark-mode');\n" +
"});\n" +
"\n" +
"// Tab Switching\n" +
"function openTab(tabId) {\n" +
"  const tabs = document.querySelectorAll('.tab-content');\n" +
"  const btns = document.querySelectorAll('.tab-btn');\n" +
"  tabs.forEach(tab => tab.classList.remove('active'));\n" +
"  btns.forEach(btn => btn.classList.remove('active'));\n" +
"  document.getElementById(tabId).classList.add('active');\n" +
"  document.querySelector(`[onclick=\"openTab('${tabId}')\"]`).classList.add('active');\n" +
"}\n" +
"\n" +
"// Media Controls\n" +
"const audio = document.getElementById('audioPlayer');\n" +
"const volumeSlider = document.getElementById('volume');\n" +
"volumeSlider.addEventListener('input', () => {\n" +
"  audio.volume = volumeSlider.value;\n" +
"});\n" +
"\n" +
"function forward() {\n" +
"  audio.currentTime = Math.min(audio.currentTime + 10, audio.duration);\n" +
"  animateButton('forward');\n" +
"}\n" +
"\n" +
"function backward() {\n" +
"  audio.currentTime = Math.max(audio.currentTime - 10, 0);\n" +
"  animateButton('backward');\n" +
"}\n" +
"\n" +
"function togglePlay() {\n" +
"  const playButton = document.querySelector('button[onclick=\"togglePlay()\"]');\n" +
"  if (audio.paused) {\n" +
"    audio.play();\n" +
"    playButton.innerHTML = '<i class=\"fas fa-pause\"></i>';\n" +
"  } else {\n" +
"    audio.pause();\n" +
"    playButton.innerHTML = '<i class=\"fas fa-play\"></i>';\n" +
"  }\n" +
"  animateButton('togglePlay');\n" +
"}\n" +
"\n" +
"function animateButton(action) {\n" +
"  const button = document.querySelector(`button[onclick=\"${action}()\"]`);\n" +
"  button.style.transform = 'scale(1.1)';\n" +
"  setTimeout(() => {\n" +
"    button.style.transform = 'scale(1)';\n" +
"  }, 200);\n" +
"}\n" +
"\n" +
"// Quiz Data and Functions\n" +
"const questions = [\n" +
"  {\n" +
"    question: \"ما هي أول سورة نزلت في القرآن؟\",\n" +
"    options: [\"سورة البقرة\", \"سورة العلق\", \"سورة الفاتحة\", \"سورة النور\"],\n" +
"    answer: \"سورة العلق\"\n" +
"  },\n" +
"  {\n" +
"    question: \"من هو أول من أسلم من الصبيان؟\",\n" +
"    options: [\"عمر بن الخطاب\", \"علي بن أبي طالب\", \"عثمان بن عفان\", \"عبدالله بن عباس\"],\n" +
"    answer: \"علي بن أبي طالب\"\n" +
"  },\n" +
"  {\n" +
"    question: \"ما هي القبلة الأولى للمسلمين؟\",\n" +
"    options: [\"المسجد الحرام\", \"المسجد الأقصى\", \"المسجد النبوي\", \"الكعبة\"],\n" +
"    answer: \"المسجد الأقصى\"\n" +
"  },\n" +
"  {\n" +
"    question: \"من هو النبي الذي ابتلعه الحوت؟\",\n" +
"    options: [\"موسى\", \"يونس\", \"نوح\", \"إبراهيم\"],\n" +
"    answer: \"يونس\"\n" +
"  },\n" +
"  {\n" +
"    question: \"كم عدد أركان الإسلام؟\",\n" +
"    options: [\"3\", \"4\", \"5\", \"6\"],\n" +
"    answer: \"5\"\n" +
"  },\n" +
"  {\n" +
"    question: \"ما هي معركة بدر؟\",\n" +
"    options: [\"أول معركة للمسلمين\", \"آخر معركة\", \"معاهدة\", \"هجرة\"],\n" +
"    answer: \"أول معركة للمسلمين\"\n" +
"  },\n" +
"  {\n" +
"    question: \"من هو خاتم الأنبياء؟\",\n" +
"    options: [\"موسى\", \"عيسى\", \"محمد\", \"إبراهيم\"],\n" +
"    answer: \"محمد\"\n" +
"  },\n" +
"  {\n" +
"    question: \"كم عدد أركان الإيمان؟\",\n" +
"    options: [\"5\", \"6\", \"7\", \"4\"],\n" +
"    answer: \"6\"\n" +
"  },\n" +
"  {\n" +
"    question: \"ما هي السورة التي تسمى عروس القرآن؟\",\n" +
"    options: [\"سورة الرحمن\", \"سورة يس\", \"سورة الفاتحة\", \"سورة الإخلاص\"],\n" +
"    answer: \"سورة الرحمن\"\n" +
"  },\n" +
"  {\n" +
"    question: \"من هو النبي الذي بنى السفينة؟\",\n" +
"    options: [\"موسى\", \"يونس\", \"نوح\", \"إبراهيم\"],\n" +
"    answer: \"نوح\"\n" +
"  }\n" +
"];\n" +
"\n" +
"function loadQuiz() {\n" +
"  const quizDiv = document.getElementById('quiz');\n" +
"  quizDiv.innerHTML = '';\n" +
"  questions.forEach((q, i) => {\n" +
"    const questionBlock = document.createElement('div');\n" +
"    questionBlock.classList.add('quiz-question');\n" +
"    questionBlock.innerHTML = `<p><strong>${i + 1}. ${q.question}</strong></p>`;\n" +
"    q.options.forEach(opt => {\n" +
"      const id = `q${i}-${opt}`;\n" +
"      questionBlock.innerHTML += `\n" +
"        <label class=\"option-label\">\n" +
"          <input type=\"radio\" name=\"q${i}\" value=\"${opt}\" id=\"${id}\"> ${opt}\n" +
"        </label>`;\n" +
"    });\n" +
"    quizDiv.appendChild(questionBlock);\n" +
"  });\n" +
"}\n" +
"\n" +
"function submitQuiz() {\n" +
"  let score = 0;\n" +
"  const scoreElement = document.getElementById('score');\n" +
"  questions.forEach((q, i) => {\n" +
"    const selected = document.querySelector(`input[name=\"q${i}\"]:checked`);\n" +
"    if (selected && selected.value === q.answer) {\n" +
"      score++;\n" +
"    }\n" +
"  });\n" +
"  document.getElementById('score').textContent = `✔️ نتيجتك: ${score} من ${questions.length}`;\n" +
"}\n" +
"\n" +
"// Prayer Times\n" +
"function getPrayerTimes() {\n" +
"  const prayerTimesDiv = document.getElementById('prayerTimes');\n" +
"  if (navigator.geolocation) {\n" +
"    navigator.geolocation.getCurrentPosition(\n" +
"      position => {\n" +
"        const lat = position.coords.latitude;\n" +
"        const lon = position.coords.longitude;\n" +
"        fetch(`http://api.aladhan.com/v1/timingsByCity?city=Cairo&country=Egypt&method=2`)\n" +
"          .then(response => response.json())\n" +
"          .then(data => {\n" +
"            const timings = data.data.timings;\n" +
"            prayerTimesDiv.innerHTML = `\n" +
"              <p>الفجر: ${timings.Fajr}</p>\n" +
"              <p>الشروق: ${timings.Sunrise}</p>\n" +
"              <p>الظهر: ${timings.Dhuhr}</p>\n" +
"              <p>العصر: ${timings.Asr}</p>\n" +
"              <p>المغرب: ${timings.Maghrib}</p>\n" +
"              <p>العشاء: ${timings.Isha}</p>\n" +
"            `;\n" +
"          })\n" +
"          .catch(error => {\n" +
"            console.error('Error fetching prayer times:', error);\n" +
"            prayerTimesDiv.innerHTML = '<p>فشل في جلب أوقات الصلاة، حاول مرة أخرى.</p>';\n" +
"          });\n" +
"      },\n" +
"      () => {\n" +
"        prayerTimesDiv.innerHTML = '<p>الرجاء تفعيل الموقع الجغرافي أو استخدام مدينة افتراضية.</p>';\n" +
"        fetchPrayerTimesByDefaultCity();\n" +
"      }\n" +
"    );\n" +
"  } else {\n" +
"    prayerTimesDiv.innerHTML = '<p>Geolocation غير مدعوم، جاري استخدام مدينة افتراضية.</p>';\n" +
"    fetchPrayerTimesByDefaultCity();\n" +
"  }\n" +
"}\n" +
"\n" +
"function fetchPrayerTimesByDefaultCity() {\n" +
"  fetch('http://api.aladhan.com/v1/timingsByCity?city=Cairo&country=Egypt&method=2')\n" +
"    .then(response => response.json())\n" +
"    .then(data => {\n" +
"      const timings = data.data.timings;\n" +
"      document.getElementById('prayerTimes').innerHTML = `\n" +
"        <p>الفجر: ${timings.Fajr}</p>\n" +
"        <p>الشروق: ${timings.Sunrise}</p>\n" +
"        <p>الظهر: ${timings.Dhuhr}</p>\n" +
"        <p>العصر: ${timings.Asr}</p>\n" +
"        <p>المغرب: ${timings.Maghrib}</p>\n" +
"        <p>العشاء: ${timings.Isha}</p>\n" +
"      `;\n" +
"    })\n" +
"    .catch(error => {\n" +
"      console.error('Error fetching default prayer times:', error);\n" +
"      document.getElementById('prayerTimes').innerHTML = '<p>فشل في جلب الأوقات، تحقق من الاتصال.</p>';\n" +
"    });\n" +
"}\n" +
"\n" +
"document.getElementById('getPrayerTimesBtn').addEventListener('click', getPrayerTimes);\n" +
"\n" +
"// Hadith\n" +
"const hadiths = [\n" +
"  \"قال رسول الله ﷺ: الْمُسْلِمُ مَنْ سَلِمَ الْمُسْلِمُونَ مِنْ لِسَانِهِ وَيَدِهِ.\",\n" +
"  \"قال رسول الله ﷺ: مَنْ صَلَّى عَلَيَّ صَلَاةً وَاحِدَةً صَلَّى اللَّهُ عَلَيْهِ عَشْرَ صَلَوَاتٍ.\",\n" +
"  \"قال رسول الله ﷺ: خَيْرُكُمْ مَنْ تَعَلَّمَ الْقُرْآنَ وَعَلَّمَهُ.\",\n" +
"  \"قال رسول الله ﷺ: الدُّعَاءُ هُوَ الْعِبَادَةُ.\",\n" +
"  \"قال رسول الله ﷺ: إِنَّ اللَّهَ يُحِبُّ إِذَا عَمِلَ أَحَدُكُمْ عَمَلًا أَنْ يُتْقِنَهُ.\",\n" +
"  \"قال رسول الله ﷺ: مَنْ سَلَكَ طَرِيقًا يَطْلُبُ فِيهِ عِلْمًا سَلَكَ اللَّهُ بِهِ طَرِيقًا مِنْ طُرُقِ الْجَنَّةِ.\",\n" +
"  \"قال رسول الله ﷺ: إِنَّمَا الْأَعْمَالُ بِالنِّيَّاتِ.\"\n" +
"];\n" +
"\n" +
"function showRandomHadith() {\n" +
"  const randomIndex = Math.floor(Math.random() * hadiths.length);\n" +
"  document.getElementById('hadithText').textContent = hadiths[randomIndex];\n" +
"}\n" +
"\n" +
"// Dhikr Counter\n" +
"let dhikrCount = 0;\n" +
"function incrementDhikr() {\n" +
"  dhikrCount++;\n" +
"  document.getElementById('dhikrCount').textContent = dhikrCount;\n" +
"  animateDhikr();\n" +
"}\n" +
"\n" +
"function resetDhikr() {\n" +
"  dhikrCount = 0;\n" +
"  document.getElementById('dhikrCount').textContent = dhikrCount;\n" +
"}\n" +
"\n" +
"function animateDhikr() {\n" +
"  const countElement = document.getElementById('dhikrCount');\n" +
"  countElement.style.transform = 'scale(1.2)';\n" +
"  setTimeout(() => {\n" +
"    countElement.style.transform = 'scale(1)';\n" +
"  }, 200);\n" +
"}\n" +
"\n" +
"// Random Quran Ayah\n" +
"function getRandomAyah() {\n" +
"  fetch('https://api.alquran.cloud/v1/ayah/random/ar.alafasy')\n" +
"    .then(response => response.json())\n" +
"    .then(data => {\n" +
"      document.getElementById('ayahText').textContent = data.data.text;\n" +
"      document.getElementById('ayahTranslation').textContent = `سورة ${data.data.surah.name} - آية ${data.data.numberInSurah}`;\n" +
"    })\n" +
"    .catch(error => {\n" +
"      console.error('Error fetching ayah:', error);\n" +
"      document.getElementById('ayahText').textContent = 'فشل في جلب الآية، حاول مرة أخرى.';\n" +
"      document.getElementById('ayahTranslation').textContent = '';\n" +
"    });\n" +
"}\n" +
"\n" +
"document.getElementById('getAyahBtn').addEventListener('click', getRandomAyah);\n" +
"\n" +
"// Random Dua\n" +
"const duas = [\n" +
"  \"اللهم أنت ربي لا إله إلا أنت، خلقتني وأنا عبدك، وأنا على عهدك ووعدك ما استطعت، أعوذ بك من شر ما صنعت، أبوء لك بنعمتك علي، وأبوء بذنبي فاغفر لي فإنه لا يغفر الذنوب إلا أنت.\",\n" +
"  \"اللهم إني أسألك الهدى والتقى والعفاف والغنى.\",\n" +
"  \"ربنا آتنا في الدنيا حسنة وفي الآخرة حسنة وقنا عذاب النار.\",\n" +
"  \"اللهم اغفر لي ذنبي كله، دقه وجله، وأوله وآخره، وعلا نيته وسرّه.\",\n" +
"  \"اللهم إني أعوذ بك من فتنة النار وعذاب النار، وفتنة القبر، وعذاب القبر، وشر فتنة الغنى، وشر فتنة الفقر، اللهم إني أعوذ بك من شر فتنة المسيح الدجال.\"\n" +
"];\n" +
"\n" +
"function showRandomDua() {\n" +
"  const randomIndex = Math.floor(Math.random() * duas.length);\n" +
"  document.getElementById('duaText').textContent = duas[randomIndex];\n" +
"}\n" +
"\n" +
"// Hijri Date\n" +
"function getHijriDate() {\n" +
"  const today = new Date().toISOString().slice(0, 10);\n" +
"  fetch(`http://api.aladhan.com/v1/gToH?date=${today}`)\n" +
"    .then(response => response.json())\n" +
"    .then(data => {\n" +
"      const hijri = data.data.hijri;\n" +
"      document.getElementById('hijriDate').textContent = `التاريخ الهجري: ${hijri.day} ${hijri.month.ar} ${hijri.year} هـ`;\n" +
"    })\n" +
"    .catch(error => {\n" +
"      console.error('Error fetching Hijri date:', error);\n" +
"      document.getElementById('hijriDate').textContent = 'فشل في جلب التاريخ الهجري، حاول مرة أخرى.';\n" +
"    });\n" +
"}\n" +
"\n" +
"document.getElementById('getHijriDateBtn').addEventListener('click', getHijriDate);\n" +
"\n" +
"// Load the quiz on page load\n" +
"window.onload = () => {\n" +
"  loadQuiz();\n" +
"  showRandomHadith(); // Show initial hadith\n" +
"  openTab('player'); // Open default tab\n" +
"  getPrayerTimes(); // Auto-fetch prayer times\n" +
"  getRandomAyah(); // Auto-fetch initial ayah\n" +
"  getHijriDate(); // Auto-fetch Hijri date\n" +
"};"
    ).getBytes(StandardCharsets.UTF_8)
);

                    
                  //  refreshProjectTree();
                    
      
        SplitPane splitPane = new SplitPane();
        codeArea.setWrapText(true);
        scpane=new ScrollPane();
        scpane.setFitToHeight(true);
        scpane.setFitToWidth(true);
        scpane.getStylesheets().add(this.getClass().getResource(codearea_syntax).toExternalForm());
        scpane.getStylesheets().add(this.getClass().getResource(app_theme).toExternalForm());
        scpane.setContent(new VirtualizedScrollPane(this.codeArea));
        scpane1=new ScrollPane();
        scpane1.setFitToHeight(true);
        scpane1.setFitToWidth(true);
        scpane1.setContent(projectTree);
        scpane2=new ScrollPane();
        scpane2.setFitToHeight(true);
        //scpane2.setFitToWidth(true);
        scpane2.setContent(codee);
        splitPane.getItems().addAll(scpane1, scpane,scpane2);
        splitPane.setDividerPositions(0.2, 0.8);
        root.setCenter(splitPane);
        tabpane.setVisible(false);
        
        
        codeArea.setDisable(false);
        codee.setDisable(false);
        newhtml.setDisable(true);
        
        String userpathh = System.getProperty("user.home");
        String pao=projectRoot.toFile().toString();
        
        Path sourcePath1 = Paths.get(userpathh + "/AppData/Roaming/resources/data/1.jpg");     // Source file path
        Path targetPath1 = Paths.get(pao+"\\"+"1.jpg");     // Destination path
        
        Path sourcePath2 = Paths.get(userpathh + "/AppData/Roaming/resources/data/1.mp3");     // Source file path
        Path targetPath2 = Paths.get(pao+"\\"+"1.mp3");     // Destination path
        
      //  Path sourcePath3 = Paths.get(userpathh + "/AppData/Roaming/resources/data/1.pdf");     // Source file path
      //  Path targetPath3 = Paths.get(pao+"\\"+"1.pdf");     // Destination path

        try {
            Files.copy(sourcePath1, targetPath1, StandardCopyOption.REPLACE_EXISTING);
            Files.copy(sourcePath2, targetPath2, StandardCopyOption.REPLACE_EXISTING);
        //    Files.copy(sourcePath3, targetPath3, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
                      try {
    refreshProjectTree();
} catch (IOException e) {
    e.printStackTrace();
}

                    
                } catch (IOException ex) {
                    showAlert("Error", "Failed to create project: " + ex.getMessage());
                }
            });
        }
          
      //Load here 
      newhtml.setDisable(true);
     openf.setDisable(true);
    }
      
      codeArea.setDisable(true);
      
      
          
      });
     
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
//      newfullproject.setOnAction((sd) -> {
//          
//          
//      if (!codeArea.getText().isEmpty()) {
//	  
//      Alert alert = new Alert(AlertType.CONFIRMATION);
//      alert.setTitle("Open HTML File");
//      alert.setHeaderText("Are you sure want to open new project?\n\nYou will lose everything!!!.");
//      alert.setContentText("We will discard all changes.");
//      DialogPane dialogPaneu = alert.getDialogPane();
//      dialogPaneu.getStylesheets().add(
//      getClass().getResource(app_theme).toExternalForm());
//      Optional<ButtonType> option = alert.showAndWait();
//      if (option.get() == null) {} 
//	  else if (option.get() == ButtonType.OK) {
//       
//      codeArea.clear();
//      codee.getEngine().loadContent("");
//      
//        DirectoryChooser chooser = new DirectoryChooser();
//        chooser.setTitle("Select Location to Create Project");
//        Path selectedDir = Optional.ofNullable(chooser.showDialog(null))
//                .map(File::toPath)
//                .orElse(null);
//        if (selectedDir != null) {
//            TextInputDialog dialog = new TextInputDialog("NewHtmlProject");
//            dialog.setTitle("Project Name");
//            dialog.setHeaderText("Enter project name:");
//            DialogPane dialogPaneuu = dialog.getDialogPane();
//            dialogPaneuu.getStylesheets().add(
//            getClass().getResource(app_theme).toExternalForm());
//            Optional<String> result = dialog.showAndWait();
//            result.ifPresent(name -> {
//                try {
//                    projectRoot = selectedDir.resolve(name);
//                    Files.createDirectories(projectRoot);
//                    
//                    Files.write(projectRoot.resolve("index.html"),
//    ("<!DOCTYPE html>\n" +
//    "<html lang=\"en\">\n" +
//    "<head>\n" +
//    "    <meta charset=\"UTF-8\">\n" +
//    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
//    "    <title>My Welcome Project</title>\n" +
//    "    <link rel=\"stylesheet\" href=\"style.css\">\n" +
//    "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n" +
//    "    <style>\n" +
//    "        #footer {\n" +
//    "            background: #fff;\n" +
//    "            box-shadow: 0px -5px 12px 5px rgba(0, 0, 0, 0.1);\n" +
//    "            padding: 30px 10px;\n" +
//    "            color: #333;\n" +
//    "            font-size: 16px;\n" +
//    "            margin-top: auto;\n" +
//    "        }\n" +
//    "        #footer .credits {\n" +
//    "            font-size: 15px;\n" +
//    "            color: #888;\n" +
//    "        }\n" +
//    "        #footer .footer-links a {\n" +
//    "            color: #666;\n" +
//    "            padding-left: 15px;\n" +
//    "        }\n" +
//    "        #footer .footer-links a:first-child {\n" +
//    "            padding-left: 0;\n" +
//    "        }\n" +
//    "        #footer .footer-links a:hover {\n" +
//    "            color: #1dc8cd;\n" +
//    "        }\n" +
//    "    </style>\n" +
//    "</head>\n" +
//    "<body>\n" +
//    "\n" +
//    "    <div class=\"card m-5 p-4 text-center\">\n" +
//    "        <h1 id=\"welcomeText\">Welcome To Eagle!</h1>\n" +
//    "        <p>We're happy to have you here.</p>\n" +
//    "        <button class=\"btn btn-primary\" onclick=\"changeText()\">Say Hello</button>\n" +
//    "    </div>\n" +
//    "\n" +
//    "    <footer id=\"footer\" class=\"mt-auto\">\n" +
//    "        <div class=\"container text-center\">\n" +
//    "            <div class=\"copyright\">\n" +
//    "                <b>&copy; Copyright \n" +
//    "                    <a href=\"https://www.facebook.com/kadysoft\" target=\"_blank\">\n" +
//    "                        <strong style=\"color:deeppink;\">Kadysoft</strong>\n" +
//    "                    </a>. All Rights Reserved.\n" +
//    "                </b>\n" +
//    "            </div>\n" +
//    "            <br>\n" +
//    "            <div class=\"credits\">\n" +
//    "                <b style=\"color:purple;\">Designed by \n" +
//    "                    <strong style=\"color:deeppink;\">Eagle.</strong>\n" +
//    "                </b>\n" +
//    "            </div>\n" +
//    "        </div>\n" +
//    "    </footer>\n" +
//    "\n" +
//    "    <script src=\"script.js\" defer></script>\n" +
//    "    <script \n" +
//    "        data-name=\"BMC-Widget\" \n" +
//    "        data-cfasync=\"false\" \n" +
//    "        src=\"https://cdnjs.buymeacoffee.com/1.0.0/widget.prod.min.js\" \n" +
//    "        data-id=\"Kadysoft\" \n" +
//    "        data-description=\"Support me on Buy me a coffee!\" \n" +
//    "        data-message=\"\" \n" +
//    "        data-color=\"#ff813f\" \n" +
//    "        data-position=\"Right\" \n" +
//    "        data-x_margin=\"18\" \n" +
//    "        data-y_margin=\"18\">\n" +
//    "    </script>\n" +
//    "</body>\n" +
//    "</html>\n").getBytes(StandardCharsets.UTF_8)
//);
//
//                    
//                    
//                    Files.write(projectRoot.resolve("style.css"),
//    ("body {\n" +
//    "    background: linear-gradient(135deg, #74ebd5 0%, #acb6e5 100%);\n" +
//    "    height: 100vh;\n" +
//    "    margin: 0;\n" +
//    "    display: flex;\n" +
//    "    flex-direction: column;\n" +
//    "    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n" +
//    "}\n\n" +
//    ".card {\n" +
//    "    background: white;\n" +
//    "    padding: 30px 40px;\n" +
//    "    border-radius: 15px;\n" +
//    "    box-shadow: 0 10px 20px rgba(0,0,0,0.2);\n" +
//    "    text-align: center;\n" +
//    "    margin: 50px auto;\n" +
//    "    animation: fadeIn 1s ease;\n" +
//    "}\n\n" +
//    "h1 {\n" +
//    "    margin-bottom: 10px;\n" +
//    "    color: #333;\n" +
//    "}\n\n" +
//    "p {\n" +
//    "    color: #666;\n" +
//    "    margin-bottom: 20px;\n" +
//    "}\n\n" +
//    "button {\n" +
//    "    background-color: #74ebd5;\n" +
//    "    border: none;\n" +
//    "    padding: 10px 20px;\n" +
//    "    border-radius: 8px;\n" +
//    "    font-size: 16px;\n" +
//    "    color: #333;\n" +
//    "    cursor: pointer;\n" +
//    "    transition: background-color 0.3s;\n" +
//    "}\n\n" +
//    "button:hover {\n" +
//    "    background-color: #4fc3f7;\n" +
//    "}\n\n" +
//    "@keyframes fadeIn {\n" +
//    "    from { opacity: 0; transform: translateY(-20px); }\n" +
//    "    to { opacity: 1; transform: translateY(0); }\n" +
//    "}\n"
//    ).getBytes(StandardCharsets.UTF_8)
//);
//
//                    
//                    Files.write(projectRoot.resolve("script.js"),
//    ("function changeText() {\n" +
//    "    document.getElementById(\"welcomeText\").innerText = \"Hello, Friend From Eagle!\";\n" +
//    "}\n"
//    ).getBytes(StandardCharsets.UTF_8)
//);
//
//                    
//                  //  refreshProjectTree();
//                    
//                    try {
//    refreshProjectTree();
//} catch (IOException e) {
//    e.printStackTrace();
//}
//
//        SplitPane splitPane = new SplitPane();
//        codeArea.setWrapText(true);
//        scpane=new ScrollPane();
//        scpane.setFitToHeight(true);
//        scpane.setFitToWidth(true);
//        scpane.getStylesheets().add(this.getClass().getResource(codearea_syntax).toExternalForm());
//        scpane.getStylesheets().add(this.getClass().getResource(app_theme).toExternalForm());
//        scpane.setContent(new VirtualizedScrollPane(this.codeArea));
//        scpane1=new ScrollPane();
//        scpane1.setFitToHeight(true);
//        scpane1.setFitToWidth(true);
//        scpane1.setContent(projectTree);
//        scpane2=new ScrollPane();
//        scpane2.setFitToHeight(true);
//        //scpane2.setFitToWidth(true);
//        scpane2.setContent(codee);
//        splitPane.getItems().addAll(scpane1, scpane,scpane2);
//        splitPane.setDividerPositions(0.2, 0.8);
//        root.setCenter(splitPane);
//        tabpane.setVisible(false);
//        
//        
//        codeArea.setDisable(false);
//        codee.setDisable(false);
//        
//        newhtml.setDisable(true);
//        openf.setDisable(true);
//                    
//                } catch (IOException ex) {
//                    showAlert("Error", "Failed to create project: " + ex.getMessage());
//                }
//            });
//        }
//          
//      //Load here 
//      
//	  
//           
//      }
//	  
//      else if (option.get() == ButtonType.CANCEL) {
//      Notifications noti = Notifications.create();
//      noti.title("Cancel!");
//      noti.text("Operation Cancelled.");
//      noti.position(Pos.CENTER);
//      noti.showInformation();
//      }
//      else {}  
//      
//      
//      
//      
//      }
//
//
//	  
//      else {
//	  
//      codeArea.clear();
//	codee.getEngine().loadContent("");
//      
//        DirectoryChooser chooser = new DirectoryChooser();
//        chooser.setTitle("Select Location to Create Project");
//        Path selectedDir = Optional.ofNullable(chooser.showDialog(null))
//                .map(File::toPath)
//                .orElse(null);
//        if (selectedDir != null) {
//            TextInputDialog dialog = new TextInputDialog("NewHtmlProject");
//            dialog.setTitle("Project Name");
//            dialog.setHeaderText("Enter project name:");
//            DialogPane dialogPaneu = dialog.getDialogPane();
//            dialogPaneu.getStylesheets().add(
//            getClass().getResource(app_theme).toExternalForm());
//            Optional<String> result = dialog.showAndWait();
//            result.ifPresent(name -> {
//                try {
//                    projectRoot = selectedDir.resolve(name);
//                    Files.createDirectories(projectRoot);
//                    
//                    Files.write(projectRoot.resolve("index.html"),
//    ("<!DOCTYPE html>\n" +
//    "<html lang=\"en\">\n" +
//    "<head>\n" +
//    "    <meta charset=\"UTF-8\">\n" +
//    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
//    "    <title>My Welcome Project</title>\n" +
//    "    <link rel=\"stylesheet\" href=\"style.css\">\n" +
//    "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n" +
//    "    <style>\n" +
//    "        #footer {\n" +
//    "            background: #fff;\n" +
//    "            box-shadow: 0px -5px 12px 5px rgba(0, 0, 0, 0.1);\n" +
//    "            padding: 30px 10px;\n" +
//    "            color: #333;\n" +
//    "            font-size: 16px;\n" +
//    "            margin-top: auto;\n" +
//    "        }\n" +
//    "        #footer .credits {\n" +
//    "            font-size: 15px;\n" +
//    "            color: #888;\n" +
//    "        }\n" +
//    "        #footer .footer-links a {\n" +
//    "            color: #666;\n" +
//    "            padding-left: 15px;\n" +
//    "        }\n" +
//    "        #footer .footer-links a:first-child {\n" +
//    "            padding-left: 0;\n" +
//    "        }\n" +
//    "        #footer .footer-links a:hover {\n" +
//    "            color: #1dc8cd;\n" +
//    "        }\n" +
//    "    </style>\n" +
//    "</head>\n" +
//    "<body>\n" +
//    "\n" +
//    "    <div class=\"card m-5 p-4 text-center\">\n" +
//    "        <h1 id=\"welcomeText\">Welcome To Eagle!</h1>\n" +
//    "        <p>We're happy to have you here.</p>\n" +
//    "        <button class=\"btn btn-primary\" onclick=\"changeText()\">Say Hello</button>\n" +
//    "    </div>\n" +
//    "\n" +
//    "    <footer id=\"footer\" class=\"mt-auto\">\n" +
//    "        <div class=\"container text-center\">\n" +
//    "            <div class=\"copyright\">\n" +
//    "                <b>&copy; Copyright \n" +
//    "                    <a href=\"https://www.facebook.com/kadysoft\" target=\"_blank\">\n" +
//    "                        <strong style=\"color:deeppink;\">Kadysoft</strong>\n" +
//    "                    </a>. All Rights Reserved.\n" +
//    "                </b>\n" +
//    "            </div>\n" +
//    "            <br>\n" +
//    "            <div class=\"credits\">\n" +
//    "                <b style=\"color:purple;\">Designed by \n" +
//    "                    <strong style=\"color:deeppink;\">Eagle.</strong>\n" +
//    "                </b>\n" +
//    "            </div>\n" +
//    "        </div>\n" +
//    "    </footer>\n" +
//    "\n" +
//    "    <script src=\"script.js\" defer></script>\n" +
//    "    <script \n" +
//    "        data-name=\"BMC-Widget\" \n" +
//    "        data-cfasync=\"false\" \n" +
//    "        src=\"https://cdnjs.buymeacoffee.com/1.0.0/widget.prod.min.js\" \n" +
//    "        data-id=\"Kadysoft\" \n" +
//    "        data-description=\"Support me on Buy me a coffee!\" \n" +
//    "        data-message=\"\" \n" +
//    "        data-color=\"#ff813f\" \n" +
//    "        data-position=\"Right\" \n" +
//    "        data-x_margin=\"18\" \n" +
//    "        data-y_margin=\"18\">\n" +
//    "    </script>\n" +
//    "</body>\n" +
//    "</html>\n").getBytes(StandardCharsets.UTF_8)
//);
//
//                    
//                    
//                    Files.write(projectRoot.resolve("style.css"),
//    ("body {\n" +
//    "    background: linear-gradient(135deg, #74ebd5 0%, #acb6e5 100%);\n" +
//    "    height: 100vh;\n" +
//    "    margin: 0;\n" +
//    "    display: flex;\n" +
//    "    flex-direction: column;\n" +
//    "    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n" +
//    "}\n\n" +
//    ".card {\n" +
//    "    background: white;\n" +
//    "    padding: 30px 40px;\n" +
//    "    border-radius: 15px;\n" +
//    "    box-shadow: 0 10px 20px rgba(0,0,0,0.2);\n" +
//    "    text-align: center;\n" +
//    "    margin: 50px auto;\n" +
//    "    animation: fadeIn 1s ease;\n" +
//    "}\n\n" +
//    "h1 {\n" +
//    "    margin-bottom: 10px;\n" +
//    "    color: #333;\n" +
//    "}\n\n" +
//    "p {\n" +
//    "    color: #666;\n" +
//    "    margin-bottom: 20px;\n" +
//    "}\n\n" +
//    "button {\n" +
//    "    background-color: #74ebd5;\n" +
//    "    border: none;\n" +
//    "    padding: 10px 20px;\n" +
//    "    border-radius: 8px;\n" +
//    "    font-size: 16px;\n" +
//    "    color: #333;\n" +
//    "    cursor: pointer;\n" +
//    "    transition: background-color 0.3s;\n" +
//    "}\n\n" +
//    "button:hover {\n" +
//    "    background-color: #4fc3f7;\n" +
//    "}\n\n" +
//    "@keyframes fadeIn {\n" +
//    "    from { opacity: 0; transform: translateY(-20px); }\n" +
//    "    to { opacity: 1; transform: translateY(0); }\n" +
//    "}\n"
//    ).getBytes(StandardCharsets.UTF_8)
//);
//
//                    
//                    Files.write(projectRoot.resolve("script.js"),
//    ("function changeText() {\n" +
//    "    document.getElementById(\"welcomeText\").innerText = \"Hello, Friend From Eagle!\";\n" +
//    "}\n"
//    ).getBytes(StandardCharsets.UTF_8)
//);
//
//                    
//                  //  refreshProjectTree();
//                    
//                    try {
//    refreshProjectTree();
//} catch (IOException e) {
//    e.printStackTrace();
//}
//
//        SplitPane splitPane = new SplitPane();
//        codeArea.setWrapText(true);
//        scpane=new ScrollPane();
//        scpane.setFitToHeight(true);
//        scpane.setFitToWidth(true);
//        scpane.getStylesheets().add(this.getClass().getResource(codearea_syntax).toExternalForm());
//        scpane.getStylesheets().add(this.getClass().getResource(app_theme).toExternalForm());
//        scpane.setContent(new VirtualizedScrollPane(this.codeArea));
//        scpane1=new ScrollPane();
//        scpane1.setFitToHeight(true);
//        scpane1.setFitToWidth(true);
//        scpane1.setContent(projectTree);
//        scpane2=new ScrollPane();
//        scpane2.setFitToHeight(true);
//        //scpane2.setFitToWidth(true);
//        scpane2.setContent(codee);
//        splitPane.getItems().addAll(scpane1, scpane,scpane2);
//        splitPane.setDividerPositions(0.2, 0.8);
//        root.setCenter(splitPane);
//        tabpane.setVisible(false);
//        
//        
//        codeArea.setDisable(false);
//        codee.setDisable(false);
//        newhtml.setDisable(true);
//                    
//                } catch (IOException ex) {
//                    showAlert("Error", "Failed to create project: " + ex.getMessage());
//                }
//            });
//        }
//          
//      //Load here 
//      newhtml.setDisable(true);
//     openf.setDisable(true);
//    }
//          
//      });
//      
      
      
      
      MenuItem openfullproject = new MenuItem("Open Full Existing Project");
      openfullproject.setStyle("-fx-font-size:13;");
      openfullproject.setOnAction((sd) -> {
          
          
          if (!codeArea.getText().isEmpty()) {
	  
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Open HTML File");
      alert.setHeaderText("Are you sure want to open new project?\n\nYou will lose everything!!!.");
      alert.setContentText("We will discard all changes.");
      DialogPane dialogPaneu = alert.getDialogPane();
      dialogPaneu.getStylesheets().add(
      getClass().getResource(app_theme).toExternalForm());
      Optional<ButtonType> option = alert.showAndWait();
      if (option.get() == null) {} 
	  else if (option.get() == ButtonType.OK) {
       
      codeArea.clear();
	codee.getEngine().loadContent("");
          DirectoryChooser chooser = new DirectoryChooser();
chooser.setTitle("Select Existing Project Folder");
Path selectedDir = Optional.ofNullable(chooser.showDialog(null))
        .map(File::toPath)
        .orElse(null);

        if (selectedDir != null) {
            projectRoot = selectedDir;
            
            try {
    refreshProjectTree();
} catch (IOException e) {
    e.printStackTrace();
}
            
            
            
            
   
         //   refreshProjectTree();
            
        SplitPane splitPane = new SplitPane();
        codeArea.setWrapText(true);
        scpane=new ScrollPane();
        scpane.setFitToHeight(true);
        scpane.setFitToWidth(true);
        scpane.getStylesheets().add(this.getClass().getResource(codearea_syntax).toExternalForm());
        scpane.getStylesheets().add(this.getClass().getResource(app_theme).toExternalForm());
        scpane.setContent(new VirtualizedScrollPane(this.codeArea));
        scpane1=new ScrollPane();
        scpane1.setFitToHeight(true);
        scpane1.setFitToWidth(true);
        scpane1.setContent(projectTree);
        scpane2=new ScrollPane();
        scpane2.setFitToHeight(true);
        scpane2.setContent(codee);
        splitPane.getItems().addAll(scpane1, scpane,scpane2);
        splitPane.setDividerPositions(0.2, 0.8);
        root.setCenter(splitPane);
        tabpane.setVisible(false);
        
        codeArea.setDisable(false);
        codee.setDisable(false);
        
        newhtml.setDisable(true);
        openf.setDisable(true);
        
        }
           
      }
	  
      else if (option.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled.");
      noti.position(Pos.CENTER);
      noti.showInformation();
      }
      else {}   
      
     
      
      }


	  
      else {
	  
      codeArea.clear();
	codee.getEngine().loadContent("");
          DirectoryChooser chooser = new DirectoryChooser();
chooser.setTitle("Select Existing Project Folder");
Path selectedDir = Optional.ofNullable(chooser.showDialog(null))
        .map(File::toPath)
        .orElse(null);

        if (selectedDir != null) {
            projectRoot = selectedDir;
            
            try {
    refreshProjectTree();
} catch (IOException e) {
    e.printStackTrace();
}
            
            
            
            
   
         //   refreshProjectTree();
            
        SplitPane splitPane = new SplitPane();
        codeArea.setWrapText(true);
        scpane=new ScrollPane();
        scpane.setFitToHeight(true);
        scpane.setFitToWidth(true);
        scpane.getStylesheets().add(this.getClass().getResource(codearea_syntax).toExternalForm());
        scpane.getStylesheets().add(this.getClass().getResource(app_theme).toExternalForm());
        scpane.setContent(new VirtualizedScrollPane(this.codeArea));
        scpane1=new ScrollPane();
        scpane1.setFitToHeight(true);
        scpane1.setFitToWidth(true);
        scpane1.setContent(projectTree);
        scpane2=new ScrollPane();
        scpane2.setFitToHeight(true);
        scpane2.setContent(codee);
        splitPane.getItems().addAll(scpane1, scpane,scpane2);
        splitPane.setDividerPositions(0.2, 0.8);
        root.setCenter(splitPane);
        tabpane.setVisible(false);
        
        codeArea.setDisable(false);
        codee.setDisable(false);
        
        newhtml.setDisable(true);
        openf.setDisable(true);
        
        }
        
      
     
    }
          
         
    //setupRefreshTimer();
    
    codeArea.setDisable(true);
          
         
      });
      
      
      
      
      
      
      
      
      ////////////////////////////////////////////////////////////////////////////////////
      
      MenuItem fontSizeItem = new MenuItem("Font Size");
      fontSizeItem.setAccelerator(KeyCombination.keyCombination("Ctrl+F"));
      fontSizeItem.setOnAction(e -> showFontDialog(codeArea));

      MenuItem themeItem = new MenuItem("App Theme");
      themeItem.setAccelerator(KeyCombination.keyCombination("Ctrl+M"));
      themeItem.setOnAction(e -> showThemeDialog());
      
      MenuItem themeeItem = new MenuItem("Code Editor Theme");
      themeeItem.setAccelerator(KeyCombination.keyCombination("Ctrl+T"));
      themeeItem.setOnAction(e ->showCodeAreaThemeDialog(scpane));
      
      MenuItem mnmn = new MenuItem("Apply");
      mnmn.setVisible(false);
      mnmn.setOnAction(e ->mnmnmnmn());
      
      
      
        MenuItem colorMenuItem = new MenuItem("App Color");
        JFXColorPicker colorPickerr = new JFXColorPicker();
        colorPickerr.setValue(Color.web("#2E3440")); // Match nord-dark initial
        // When user picks a color, update the background
        colorPickerr.setOnAction(e -> {
        Color selectedColor = colorPickerr.getValue();
        String hex = toHexString(selectedColor);
        String css = ".root { -fx-background-color: " + hex + "; }";
        try {
        File cssFile = new File(System.getProperty("user.home")+"\\"+"dynamic-theme.css");
        Files.write(cssFile.toPath(), css.getBytes());
        
        mnmn.fire();

    } catch (IOException ex) {
        ex.printStackTrace();
    }
           
        });
        colorMenuItem.setGraphic(colorPickerr);
     
      
      
      
      
      
      MenuItem changeTextColor = new MenuItem("Change Background Color...");
      changeTextColor.setAccelerator(KeyCombination.keyCombination("Ctrl+B"));
      
     // Create JFXColorPicker popup
        changeTextColor.setOnAction(e -> {
            Dialog<Void> dialog = new Dialog<>();
            dialog.setTitle("Pick Text Color");
            styleDialogDark(dialog.getDialogPane());

            JFXColorPicker colorPicker = new JFXColorPicker(Color.BLACK);
            HBox hbox = new HBox(colorPicker);
            hbox.setAlignment(Pos.CENTER);
            hbox.setSpacing(10);
            dialog.getDialogPane().setContent(hbox);

            ButtonType applyButton = new ButtonType("Apply", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(applyButton, ButtonType.CANCEL);

            dialog.setResultConverter(button -> {
                if (button == applyButton) {
                    Color selected = colorPicker.getValue();
                    String rgb = String.format("rgb(%d, %d, %d)",
                            (int) (selected.getRed() * 255),
                            (int) (selected.getGreen() * 255),
                            (int) (selected.getBlue() * 255));
                    //codeArea.setStyle("-fx-background-color:" + rgb + ";-fx-font-size:"+currentFontSize+";-fx-font-weight:bold;-fx-font-family:Monospaced;");
                    codeArea.setStyle("-fx-background-color:" + rgb + ";-fx-font-size:"+currentFontSize+";-fx-font-style:"+font_style+";-fx-font-weight:"+font_weight+";-fx-font-family:"+font_family+";");
                    updateSetting("CodeArea_Color",rgb);
                    updateSetting("Font_Size",font_size);
                    codearea_color=rgb;
                    //codeArea.setStyle("-fx-text-fill: " + rgb + "; -fx-font-size: 16px;");
                }
                return null;
            });

            dialog.showAndWait();
        });
      
      ////////////////////////////////////////////////////////////////////////////////////
      
      
      MenuItem helper1 = new MenuItem("Standalone");
      helper1.setOnAction(e -> {
       
          try {
          
      Stage stg = new Stage();
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("Helper_Editor.fxml"));
      Scene sce = new Scene(root);
      stg.setTitle("Helper Editor");
      stg.centerOnScreen();
      stg.setResizable(true);
      stg.setScene(sce);
      stg.show();
    
          }catch (Exception m)  {}
          
      });
      
      MenuItem helper2 = new MenuItem("Plugin");
      helper2.setOnAction(e -> {
       
        Stage popup = new Stage();
        popup.setTitle("Helper Editor");
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        
        
        
//        // Handle click or key event
//        webView.setOnMousePressed(evc -> {
//        Object result = engine.executeScript("editor.getValue()");
//        String htmlCode = result.toString();
//        int caretPosition = codeArea.getCaretPosition();
//        codeArea.insertText(caretPosition, htmlCode );
//        });
//        webView.setOnKeyPressed(emn -> {
//        Object result = engine.executeScript("editor.getValue()");
//        String htmlCode = result.toString();
//        int caretPosition = codeArea.getCaretPosition();
//        codeArea.insertText(caretPosition, htmlCode );    
//        });
        
        
        
        webView.setPrefSize(1000, 400);
        try {
        String userpathh = System.getProperty("user.home");
        File filor = new File (userpathh + "/AppData/Roaming/resources/data/ace/index.html");
        URL urly = filor.toURI().toURL();
        String finalUrl = urly.toString() + "?t=" + System.currentTimeMillis();
        engine.setJavaScriptEnabled(true);   
        engine.reload();
        engine.load(finalUrl);
        } catch (Exception dfdf){}
        Button closeBtn = new Button("Close");
        closeBtn.setOnAction(eyd -> popup.close());
        
        Button hta = new Button("HTML");
        hta.setOnAction(eys -> {
        try {
        String userpathh = System.getProperty("user.home");
        File filor = new File (userpathh + "/AppData/Roaming/resources/data/ace/index.html");
        PrintWriter pwwq=new PrintWriter (new FileWriter (filor));
        pwwq.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"<meta charset=\"UTF-8\" />\n" +
"<title></title>\n" +
"<style>\n" +
"html, body {\n" +
"margin: 0;\n" +
"height: 100%;\n" +
"overflow: hidden;\n" +
"}\n" +
"#editor {\n" +
"height: 100vh;\n" +
"width: 100vw;\n" +
"}\n" +
"</style>\n" +
"</head>\n" +
"<body>\n" +
"<div id=\"editor\"></div>\n" +
"<!-- Load Ace core and autocomplete tools -->\n" +
"<script src=\"ace/ace.js\"></script>\n" +
"<script src=\"ace/ext-language_tools.js\"></script>\n" +
"<!-- Load modes -->\n" +
"<script src=\"ace/mode-html.js\"></script>\n" +
"<script src=\"ace/mode-css.js\"></script>\n" +
"<script src=\"ace/mode-javascript.js\"></script>\n" +
"<!-- Load themes -->\n" +
"<script src=\"ace/theme-monokai.js\"></script>\n" +
"<script src=\"ace/theme-chrome.js\"></script>\n" +
"<script>\n" +
"const editor = ace.edit(\"editor\");\n" +
"editor.setTheme(\"ace/theme/chrome\"); // or \"ace/theme/chrome\"\n" +
"editor.session.setMode(\"ace/mode/html\");\n" +
"editor.setOptions({\n" +
"fontSize: \"14px\",\n" +
"enableBasicAutocompletion: true,\n" +
"enableLiveAutocompletion: true,\n" +
"enableSnippets: true,\n" +
"showPrintMargin: false,\n" +
"tabSize: 2\n" +
"});\n" +
"// Optional: Detect mode based on user typing\n" +
"// Or you can add buttons to switch between HTML/CSS/JS\n" +
"</script>\n" +
"</body>\n" +
"</html>");
        pwwq.close();
        URL urly = filor.toURI().toURL();
        String finalUrl = urly.toString() + "?t=" + System.currentTimeMillis();
        engine.setJavaScriptEnabled(true);   
        engine.reload();
        engine.load(finalUrl);
        } catch (Exception dfdf){}  
        });
        
        Button csa = new Button("CSS");
        csa.setOnAction(eyk -> {
        try {
        String userpathh = System.getProperty("user.home");
        File filor = new File (userpathh + "/AppData/Roaming/resources/data/ace/index.html");
        PrintWriter pwwq=new PrintWriter (new FileWriter (filor));
        pwwq.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"<meta charset=\"UTF-8\" />\n" +
"<title></title>\n" +
"<style>\n" +
"html, body {\n" +
"margin: 0;\n" +
"height: 100%;\n" +
"overflow: hidden;\n" +
"}\n" +
"#editor {\n" +
"height: 100vh;\n" +
"width: 100vw;\n" +
"}\n" +
"</style>\n" +
"</head>\n" +
"<body>\n" +
"<div id=\"editor\"></div>\n" +
"<!-- Load Ace core and autocomplete tools -->\n" +
"<script src=\"ace/ace.js\"></script>\n" +
"<script src=\"ace/ext-language_tools.js\"></script>\n" +
"<!-- Load modes -->\n" +
"<script src=\"ace/mode-html.js\"></script>\n" +
"<script src=\"ace/mode-css.js\"></script>\n" +
"<script src=\"ace/mode-javascript.js\"></script>\n" +
"<!-- Load themes -->\n" +
"<script src=\"ace/theme-monokai.js\"></script>\n" +
"<script src=\"ace/theme-chrome.js\"></script>\n" +
"<script>\n" +
"const editor = ace.edit(\"editor\");\n" +
"editor.setTheme(\"ace/theme/chrome\"); // or \"ace/theme/chrome\"\n" +
"editor.session.setMode(\"ace/mode/css\");\n" +
"editor.setOptions({\n" +
"fontSize: \"14px\",\n" +
"enableBasicAutocompletion: true,\n" +
"enableLiveAutocompletion: true,\n" +
"enableSnippets: true,\n" +
"showPrintMargin: false,\n" +
"tabSize: 2\n" +
"});\n" +
"// Optional: Detect mode based on user typing\n" +
"// Or you can add buttons to switch between HTML/CSS/JS\n" +
"</script>\n" +
"</body>\n" +
"</html>");
        pwwq.close();
        URL urly = filor.toURI().toURL();
        String finalUrl = urly.toString() + "?t=" + System.currentTimeMillis();
        engine.setJavaScriptEnabled(true);   
        engine.reload();
        engine.load(finalUrl);
        } catch (Exception dfdf){}
        });
        
        Button jsa = new Button("JavaScript");
        jsa.setOnAction(eyl -> {
        try {
        String userpathh = System.getProperty("user.home");
        File filor = new File (userpathh + "/AppData/Roaming/resources/data/ace/index.html");
        PrintWriter pwwq=new PrintWriter (new FileWriter (filor));
        pwwq.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"<meta charset=\"UTF-8\" />\n" +
"<title></title>\n" +
"<style>\n" +
"html, body {\n" +
"margin: 0;\n" +
"height: 100%;\n" +
"overflow: hidden;\n" +
"}\n" +
"#editor {\n" +
"height: 100vh;\n" +
"width: 100vw;\n" +
"}\n" +
"</style>\n" +
"</head>\n" +
"<body>\n" +
"<div id=\"editor\"></div>\n" +
"<!-- Load Ace core and autocomplete tools -->\n" +
"<script src=\"ace/ace.js\"></script>\n" +
"<script src=\"ace/ext-language_tools.js\"></script>\n" +
"<!-- Load modes -->\n" +
"<script src=\"ace/mode-html.js\"></script>\n" +
"<script src=\"ace/mode-css.js\"></script>\n" +
"<script src=\"ace/mode-javascript.js\"></script>\n" +
"<!-- Load themes -->\n" +
"<script src=\"ace/theme-monokai.js\"></script>\n" +
"<script src=\"ace/theme-chrome.js\"></script>\n" +
"<script>\n" +
"const editor = ace.edit(\"editor\");\n" +
"editor.setTheme(\"ace/theme/chrome\"); // or \"ace/theme/chrome\"\n" +
"editor.session.setMode(\"ace/mode/javascript\");\n" +
"editor.setOptions({\n" +
"fontSize: \"14px\",\n" +
"enableBasicAutocompletion: true,\n" +
"enableLiveAutocompletion: true,\n" +
"enableSnippets: true,\n" +
"showPrintMargin: false,\n" +
"tabSize: 2\n" +
"});\n" +
"// Optional: Detect mode based on user typing\n" +
"// Or you can add buttons to switch between HTML/CSS/JS\n" +
"</script>\n" +
"</body>\n" +
"</html>");
        pwwq.close();
        URL urly = filor.toURI().toURL();
        String finalUrl = urly.toString() + "?t=" + System.currentTimeMillis();
        engine.setJavaScriptEnabled(true);   
        engine.reload();
        engine.load(finalUrl);
        } catch (Exception dfdf){}
        });
        Button insertButton = new Button("Insert To CodeArea");
        insertButton.setOnAction(eir -> {
            
            
Alert alertio = new Alert(Alert.AlertType.CONFIRMATION);
alertio.setTitle("Insert");
alertio.setHeaderText("Insert To CodeArea");
alertio.setContentText("What do you wanna do?");
ButtonType buttonTypeOne = new ButtonType("Insert");
ButtonType buttonTypetwo = new ButtonType("Replace");
alertio.getButtonTypes().setAll(buttonTypeOne, buttonTypetwo);
DialogPane dialogPaneii = alertio.getDialogPane();
dialogPaneii.getStylesheets().add(getClass().getResource(app_theme).toExternalForm());
Optional<ButtonType> results = alertio.showAndWait();
if (results.isPresent() && results.get() == buttonTypeOne) {
    
  //Insert
  Object result = engine.executeScript("editor.getValue()");
        String htmlCode = result.toString();
        int caretPosition = codeArea.getCaretPosition();
        codeArea.insertText(caretPosition, htmlCode );    
    simulateMouseClickOnNode(codeArea);

}
  

else if (results.isPresent() && results.get() == buttonTypetwo) {
    
  //Replace
  Object result = engine.executeScript("editor.getValue()");
        String htmlCode = result.toString();
        int caretPosition = codeArea.getCaretPosition();
        //codeArea.insertText(caretPosition, htmlCode );
        codeArea.clear();
        codeArea.replaceText(0,0, htmlCode);
        simulateMouseClickOnNode(codeArea);

}

else {}    
            
            
        
        });
        HBox controls = new HBox(10, closeBtn,hta,csa,jsa,insertButton );
        controls.setPadding(new Insets(10));
        controls.setStyle("-fx-alignment: center;");
        VBox layout = new VBox(webView, controls);
        layout.setPadding(new Insets(0));
        Scene popupScene = new Scene(layout, 1000, 450);
        popupScene.getStylesheets().add(getClass().getResource(app_theme).toExternalForm());
        popup.setScene(popupScene);
        popup.setAlwaysOnTop(true);
        popup.setResizable(false);
        Stage mainStage = (Stage) barr.getScene().getWindow();
        // Position it at bottom of mainStage
        Runnable updatePopupPosition = () -> {
        double mainX = mainStage.getX();
        double mainY = mainStage.getY();
        double mainW = mainStage.getWidth();
        double mainH = mainStage.getHeight();
        double popupX = mainX + (mainW - popup.getWidth()) / 2;
        double popupY = mainY + mainH - popup.getHeight() - 10; // 10 px above bottom
        popup.setX(popupX);
        popup.setY(popupY);
        };
        ChangeListener<Number> positionListener = (obs, oldVal, newVal) -> updatePopupPosition.run();
        mainStage.xProperty().addListener(positionListener);
        mainStage.yProperty().addListener(positionListener);
        mainStage.widthProperty().addListener(positionListener);
        mainStage.heightProperty().addListener(positionListener);
        popup.show();
        Platform.runLater(updatePopupPosition);
        
//        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
//        double x = (screenBounds.getWidth() - 1000) / 2;
//        double y = screenBounds.getHeight() - 450 - 40; // 40px offset from bottom
//        popup.setX(x);
//        popup.setY(y);
//        popup.show();
          
      });
      
      Menu helpermenu = new Menu("Helper Editor");
      helpermenu.getItems().addAll(helper2,helper1);
      
      
      
      fil=new Menu ("File");
      fil.setAccelerator(KeyCombination.keyCombination("Ctrl+F"));
      fil.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("file.png"))));
      fil.setMnemonicParsing(true);
      fil.setStyle("-fx-text-size:17;-fx-font-weight:bold;");
      fil.getItems().addAll(newfullproject,openfullproject,openf,newhtml,it4);
      
      edt=new Menu ("Edit");
      edt.setAccelerator(KeyCombination.keyCombination("Ctrl+E"));
      edt.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("edit.png"))));
      edt.setMnemonicParsing(true);
      edt.setStyle("-fx-text-size:17;-fx-font-weight:bold;");
      edt.getItems().addAll(this.it8, this.it9, this.it10, this.it11, this.it12, this.it13, this.it14,it1477,new SeparatorMenuItem(),fontSizeItem,new SeparatorMenuItem(),themeItem,new SeparatorMenuItem(),themeeItem,new SeparatorMenuItem(),changeTextColor);
      
      htmltag=new Menu ("HTML Tags");
      htmltag.setAccelerator(KeyCombination.keyCombination("Ctrl+H"));
      htmltag.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("html.png"))));
      htmltag.setMnemonicParsing(true);
      htmltag.setStyle("-fx-text-size:17;-fx-font-weight:bold;");
      htmltag.getItems().addAll(this.h1, this.h2, this.h3, this.h4, this.h5, this.h6, this.h7, this.h8, this.h9, this.h10, this.h11, this.h12, this.h13, this.h14, this.h15, this.h16, this.h17, this.h18, this.h19, this.h20, this.h21, this.h22, this.h23, this.h24, this.h25, this.h26, this.h27, this.h28, this.h29, this.h30, this.h31, this.h32, this.h33, this.h34, this.h35, this.h36, this.h37, this.h38, this.h39, this.h40, this.h115, this.h116, this.h41, this.h42, this.h43, this.h44, this.h45, this.h46, this.h47, this.h48, this.h49, this.h50, this.h51, this.h52, this.h53, this.h54, this.h55, this.h56, this.h57, this.h58, this.h59, this.h60, this.h61, this.h62, this.h63, this.h64, this.h65, this.h66, this.h67, this.h68, this.h69, this.h70, this.h71, this.h72, this.h73, this.h74, this.h75, this.h76, this.h77, this.h78, this.h79, this.h80, this.h81, this.h82, this.h83, this.h84, this.h85, this.h86, this.h87, this.h88, this.h89, this.h90, this.h91, this.h92, this.h93, this.h94, this.h95, this.h96, this.h97, this.h98, this.h99, this.h100, this.h101, this.h102, this.h103, this.h104, this.h105, this.h106, this.h107, this.h108, this.h109, this.h110, this.h111, this.h112, this.h113, this.h114);
      
      csstag=new Menu ("CSS");
      csstag.setAccelerator(KeyCombination.keyCombination("Ctrl+M"));
      csstag.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("css.png"))));
      csstag.setMnemonicParsing(true);
      csstag.setStyle("-fx-text-size:17;-fx-font-weight:bold;");
      csstag.getItems().addAll(this.cs1, this.c2, this.c3, this.c4, this.c5, this.c6, this.c7, this.c9, this.c11, this.c13, this.c14, this.c15, this.c16, this.c17, this.c18, this.c19, this.tagg, this.men6, this.men7, this.men5, this.men4, this.men3, this.men2, this.men1);
      
      jstag=new Menu ("JavaScript");
      jstag.setAccelerator(KeyCombination.keyCombination("Ctrl+J"));
      jstag.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("js.png"))));
      jstag.setMnemonicParsing(true);
      jstag.setStyle("-fx-text-size:17;-fx-font-weight:bold;");
      jstag.getItems().addAll(j1, this.ele, this.var, this.out, this.commm, this.strings, this.numbers, this.eve, this.maths, this.dates, this.datemethods, j105, this.dateformats, this.one, this.two, j133, j134, j135, this.cook, this.three, this.four);
      
      run=new Menu ("Run");
      run.setAccelerator(KeyCombination.keyCombination("Ctrl+R"));
      run.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("runn.png"))));
      run.setMnemonicParsing(true);
      run.setStyle("-fx-text-size:17;-fx-font-weight:bold;");
      run.getItems().addAll(it3);
      
      toools=new Menu ("Tools");
      toools.setAccelerator(KeyCombination.keyCombination("Ctrl+T"));
      toools.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("tools.png"))));
      toools.setMnemonicParsing(true);
      toools.setStyle("-fx-text-size:17;-fx-font-weight:bold;");
      toools.getItems().addAll(gethtml,helpermenu,aiartool,tol1,tol2,tol11,tol12,tol13);
      
      help=new Menu ("Help");
      //help.setAccelerator(KeyCombination.keyCombination("Ctrl+F"));
      //help.setGraphic();
      help.setMnemonicParsing(true);
      help.setStyle("-fx-text-size:17;-fx-font-weight:bold;");
      //help.getItems().addAll();
      
      barr=new MenuBar();
      barr.setMinHeight(30);
      //barr.setStyle("-fx-background-color:white;");
      //barr.setEffect(new DropShadow());
      barr.getMenus().addAll(fil,edt,htmltag,csstag,jstag,run,toools);
      
      ///////////////////////////////////////////////////////////
    Pattern XML_TAG = Pattern.compile("(?<ELEMENT>(</?\\h*)(\\w+)([^<>]*)(\\h*/?>))|(?<COMMENT><!--[^<>]+-->)");
    Pattern ATTRIBUTES = Pattern.compile("(\\w+\\h*)(=)(\\h*\"[^\"]+\")");
    int GROUP_OPEN_BRACKET = 2;
    int GROUP_ELEMENT_NAME = 3;
    int GROUP_ATTRIBUTES_SECTION = 4;
    int GROUP_CLOSE_BRACKET = 5;
    int GROUP_ATTRIBUTE_NAME = 1;
    int GROUP_EQUAL_SYMBOL = 2;
    int GROUP_ATTRIBUTE_VALUE = 3;
    

  String[] KEYWORDS = {
    
      // Control Flow & Declarations
"function", "if", "else", "switch", "case", "default", "for", "while", "do", "break", "continue", "return",

// Variables
"var", "let", "const",

// Boolean Literals
"true", "false", "null", "undefined", "NaN", "Infinity",

// Error Handling
"try", "catch", "finally", "throw",

// Operators / Special
"new", "this", "typeof", "instanceof", "in", "delete", "void", "await", "async", "yield",

// Class & Module System
"class", "extends", "super", "constructor", "static", "implements", "import", "export", "default", "from", "require",

// TS Types
"interface", "type", "enum", "any", "unknown", "never", "void", "boolean", "number", "string", "symbol", "bigint",

// TS Modifiers
"readonly", "public", "private", "protected", "abstract", "declare", "override", "infer", "asserts", "as", "satisfies",

// Namespacing
"namespace", "module", "global",

// Global Browser APIs
"window", "document", "navigator", "location", "history", "screen",

// Timers
"setTimeout", "setInterval", "clearTimeout", "clearInterval",

// Console
"console", "log", "warn", "error", "debug", "info",

// DOM Access
"getElementById", "getElementsByClassName", "getElementsByTagName",
"querySelector", "querySelectorAll", "createElement", "appendChild", "removeChild",

// Events
"addEventListener", "removeEventListener", "event", "target", "preventDefault", "stopPropagation",

// Built-in Types
"Object", "Function", "Array", "String", "Number", "Boolean", "Symbol", "BigInt",

// Utility Objects
"Math", "Date", "JSON", "RegExp", "Map", "Set", "WeakMap", "WeakSet", "Promise", "Intl", "Reflect", "Proxy",

// JSON
"parse", "stringify",

"React", "JSX", "useState", "useEffect", "useContext", "useRef", "useReducer", "useMemo", "useCallback",
"Fragment", "Component", "PureComponent", "createContext", "createElement", "cloneElement", "memo", "forwardRef",
"render", "hydrate", "strictMode", "children", "props", "state", "setState", "className",

"Vue", "data", "methods", "computed", "watch", "props", "emit", "setup", "ref", "reactive",
"v-if", "v-else", "v-for", "v-bind", "v-model", "v-on", "v-show", "v-slot", "v-pre", "v-cloak",

"NgModule", "Component", "Injectable", "Directive", "Pipe", "Input", "Output", "EventEmitter", "OnInit", "OnDestroy",
"HttpClient", "FormControl", "FormGroup", "ngIf", "ngFor", "ngClass", "ngModel", "RouterModule",

"script", "style", "onMount", "beforeUpdate", "afterUpdate", "onDestroy", "$:", "$store", "$props", "$capture_state", "$inject_state",
"bind", "class", "each", "if", "else", "await", "then", "catch",

// Next.js (React)
"getStaticProps", "getServerSideProps", "getStaticPaths", "App", "Document", "Head", "Link", "useRouter",

// Nuxt.js (Vue)
"defineNuxtConfig", "useRouter", "useRoute", "definePageMeta", "useAsyncData", "useFetch", "setup",

 "$", "jQuery", "$(document).ready", "ajax", "html", "text", "val", "attr", "css", "addClass", "removeClass",
"fadeIn", "fadeOut", "slideDown", "slideUp", "on", "off", "click", "submit", "change",
   
    
    // HTML Tags
    // Document metadata
    "html", "head", "title", "base", "link", "meta", "style", "script", "noscript",
    "template", "slot",

    // Sections
    "body", "section", "nav", "article", "aside", "h1", "h2", "h3", "h4", "h5", "h6",
    "header", "footer", "main", "address",

    // Grouping content
    "p", "hr", "pre", "blockquote", "ol", "ul", "li", "dl", "dt", "dd", "div", "figure", "figcaption",

    // Text-level semantics
    "a", "abbr", "b", "bdi", "bdo", "br", "cite", "code", "data", "dfn", "em", "i", "kbd",
    "mark", "q", "rp", "rt", "ruby", "s", "samp", "small", "span", "strong", "sub", "sup",
    "time", "u", "var", "wbr",

    // Edits
    "ins", "del",

    // Embedded content
    "img", "iframe", "embed", "object", "param", "video", "audio", "source", "track",
    "canvas", "map", "area", "svg", "math", "picture",

    // Forms
    "form", "label", "input", "button", "select", "datalist", "optgroup", "option",
    "textarea", "keygen", "output", "progress", "meter", "fieldset", "legend",

    // Interactive elements
    "details", "summary", "dialog", "menu", "menuitem",

    // Tables
    "table", "caption", "colgroup", "col", "thead", "tbody", "tfoot", "tr", "td", "th",

    // Deprecated or obsolete tags
    "acronym", "applet", "basefont", "bgsound", "big", "blink", "center", "command", "content",
    "dir", "font", "frame", "frameset", "image", "isindex", "keygen", "listing", "marquee",
    "menuitem", "multicol", "nextid", "nobr", "noembed", "noframes", "plaintext", "rb",
    "shadow", "spacer", "strike", "tt", "xmp",

        
    // Box model & layout
"margin", "margin-top", "margin-right", "margin-bottom", "margin-left",
"padding", "padding-top", "padding-right", "padding-bottom", "padding-left",
"border", "border-width", "border-style", "border-color", "border-radius",
"box-sizing", "box-shadow", "overflow", "overflow-x", "overflow-y",

// Positioning & layout
"position", "top", "right", "bottom", "left", "z-index",
"display", "inline", "block", "inline-block", "flex", "grid", "inline-flex", "inline-grid", "none", "visibility",

// Flex & Grid
"justify-content", "align-items", "align-content", "align-self", "flex-direction", "flex-wrap", "flex-grow", "flex-shrink", "flex-basis", "gap",
"grid-template-columns", "grid-template-rows", "grid-column", "grid-row", "grid-area", "place-items",

// Typography
"font", "font-size", "font-weight", "font-family", "font-style", "line-height", "letter-spacing", "word-spacing", "text-align", "text-decoration",
"text-transform", "vertical-align", "white-space", "direction", "unicode-bidi",

// Colors & backgrounds
"color", "background", "background-color", "background-image", "background-size", "background-repeat", "background-position", "background-attachment",
"opacity", "filter", "mix-blend-mode",

// Transforms & transitions
"transform", "rotate", "scale", "translate", "skew", "transform-origin",
"transition", "transition-property", "transition-duration", "transition-timing-function", "transition-delay",
"animation", "animation-name", "animation-duration", "animation-delay", "animation-iteration-count", "animation-direction", "animation-fill-mode",

// Sizing
"width", "height", "min-width", "max-width", "min-height", "max-height",

// Cursors & interactivity
"cursor", "pointer-events", "user-select",

// Miscellaneous
"content", "clip", "visibility", "clear", "float",

  "svg", "g", "defs", "symbol", "use", "image", "path", "rect", "circle", "ellipse", "line", "polyline", "polygon",
"text", "tspan", "textPath", "clipPath", "mask", "pattern", "linearGradient", "radialGradient", "stop", "filter",
"feGaussianBlur", "feOffset", "feBlend", "feColorMatrix", "feComponentTransfer", "feComposite", "feFlood",
"feImage", "feMerge", "feMorphology", "feTile", "feTurbulence",

"xmlns", "xmlns:xlink", "x", "y", "width", "height", "viewBox", "preserveAspectRatio", "fill", "stroke", "stroke-width",
"d", "transform", "rotate", "scale", "translate", "cx", "cy", "r", "rx", "ry", "x1", "y1", "x2", "y2", "points",
"offset", "stop-color", "stop-opacity", "mask", "clip-path", "id",


"<?xml", "<?", "?>", "</", "/>", "[CDATA[", "]]>",
"version", "encoding", "element", "attribute", "value", "xmlns", "xsi", "xlink",

"package", "use strict", "default", "module.exports", "define",
"OnStart", "OnStop", "OnPause", "OnResume", "OnDestroy",
"require", "exports", "import", "define", "amd"



    
};



    
    
//    String[] KEYWORDS = { 
//        
//        // JavaScript
//        "function", "if", "else", "for", "while", "switch", "case", "var", "let", "const", "return", "true", "false",
//        "try", "catch", "finally", "throw", "new", "this", "typeof", "instanceof", "in", "delete", "await", "async",
//        "window", "document", "console", "alert", "navigator", "setTimeout", "setInterval", "clearTimeout", "clearInterval",
//        // DOM & BOM
//        "addEventListener", "querySelector", "getElementById", "getElementsByClassName", "getElementsByTagName",
//        // HTML
//        "html", "body", "head", "title", "meta", "link", "style", "script", "div", "span", "img", "a", "ul", "ol", "li",
//        "table", "thead", "tbody", "tfoot", "tr", "td", "th", "form", "input", "textarea", "button", "select", "option",
//        "header", "footer", "section", "article", "nav", "main", "aside", "figure", "figcaption", "canvas", "video",
//        "audio", "source", "iframe", "blockquote", "code", "pre", "br", "hr", "label", "fieldset", "legend","p","h1","h2","h3","h4","h5","h6",
//        // CSS
//        "color", "background", "border", "padding", "margin", "font", "display", "position", "absolute", "relative",
//        "fixed", "sticky", "flex", "grid", "inline", "block", "none", "visibility", "overflow", "z-index", "width",
//        "height", "min-width", "max-width", "min-height", "max-height", "box-shadow", "text-align", "justify-content",
//        "align-items", "animation", "transition", "transform", "rotate", "scale", "translate", "opacity",
//        // Misc.
//        "DOCTYPE", "use strict", "package", "import", "export", "class", "extends", "super", "implements",
//        "Date", "Math", "Boolean", "String", "Number", "Array", "Object", "Map", "Set", "RegExp", "JSON", "parse", "stringify",
//        // Frameworks
//        "jQuery", "React", "Vue", "Angular", "Svelte", "Bootstrap", "Tailwind", "Pixi", "Tween", "Box2d", "Flot",
//        "OnStart", "OnStop", "OnPause", "OnResume", "OnDestroy",
//    
//    
//         // HTML
//"HTML", "BODY", "HEAD", "TITLE", "META", "LINK", "STYLE", "SCRIPT", "DIV", "SPAN", "IMG", "A", "UL", "OL", "LI",
//"TABLE", "THEAD", "TBODY", "TFOOT", "TR", "TD", "TH", "FORM", "INPUT", "TEXTAREA", "BUTTON", "SELECT", "OPTION",
//"HEADER", "FOOTER", "SECTION", "ARTICLE", "NAV", "MAIN", "ASIDE", "FIGURE", "FIGCAPTION", "CANVAS", "VIDEO",
//"AUDIO", "SOURCE", "IFRAME", "BLOCKQUOTE", "CODE", "PRE", "BR", "HR", "LABEL", "FIELDSET", "LEGEND","P","H1","H2","H3","H4","H5","H6",
//// CSS
//"COLOR", "BACKGROUND", "BORDER", "PADDING", "MARGIN", "FONT", "DISPLAY", "POSITION", "ABSOLUTE", "RELATIVE",
//"FIXED", "STICKY", "FLEX", "GRID", "INLINE", "BLOCK", "NONE", "VISIBILITY", "OVERFLOW", "Z-INDEX", "WIDTH",
//"HEIGHT", "MIN-WIDTH", "MAX-WIDTH", "MIN-HEIGHT", "MAX-HEIGHT", "BOX-SHADOW", "TEXT-ALIGN", "JUSTIFY-CONTENT",
//"ALIGN-ITEMS", "ANIMATION", "TRANSITION", "TRANSFORM", "ROTATE", "SCALE", "TRANSLATE", "OPACITY",
//// MISC.
//"DOCTYPE", "USE STRICT", "PACKAGE", "IMPORT", "EXPORT", "CLASS", "EXTENDS", "SUPER", "IMPLEMENTS",
//"DATE", "MATH", "BOOLEAN", "STRING", "NUMBER", "ARRAY", "OBJECT", "MAP", "SET", "REGEXP", "JSON", "PARSE", "STRINGIFY",
//
//// Html
//"Html", "Body", "Head", "Title", "Meta", "Link", "Style", "Script", "Div", "Span", "Img", "A", "Ul", "Ol", "Li",
//"Table", "Thead", "Tbody", "Tfoot", "Tr", "Td", "Th", "Form", "Input", "Textarea", "Button", "Select", "Option",
//"Header", "Footer", "Section", "Article", "Nav", "Main", "Aside", "Figure", "Figcaption", "Canvas", "Video",
//"Audio", "Source", "Iframe", "Blockquote", "Code", "Pre", "Br", "Hr", "Label", "Fieldset", "Legend","P","H1","H2","H3","H4","H5","H6",
//// Css
//"Color", "Background", "Border", "Padding", "Margin", "Font", "Display", "Position", "Absolute", "Relative",
//"Fixed", "Sticky", "Flex", "Grid", "Inline", "Block", "None", "Visibility", "Overflow", "Z-Index", "Width",
//"Height", "Min-Width", "Max-Width", "Min-Height", "Max-Height", "Box-Shadow", "Text-Align", "Justify-Content",
//"Align-Items", "Animation", "Transition", "Transform", "Rotate", "Scale", "Translate", "Opacity",
//// Misc.
//"Doctype", "Use Strict", "Package", "Import", "Export", "Class", "Extends", "Super", "Implements",
//"Date", "Math", "Boolean", "String", "Number", "Array", "Object", "Map", "Set", "Regexp", "Json", "Parse", "Stringify"
//
//
//    };
//      
    String KEYWORD_PATTERN = "\\b(" + String.join("|", (CharSequence[])KEYWORDS) + ")\\b";
    String PAREN_PATTERN = "\\(|\\)";
    String BRACE_PATTERN = "\\{|\\}";
    String BRACKET_PATTERN = "\\[|\\]";
    String SEMICOLON_PATTERN = "\\;";
    String STRING_PATTERN = "\"([^\"\\\\]|\\\\.)*\"";
    String COMMENT_PATTERN = "//[^\n]*|/\\*(.|\\R)*?\\*/";
    //PATTERN = Pattern.compile("(?<KEYWORD>" + KEYWORD_PATTERN + ")" + "|(?<PAREN>" + PAREN_PATTERN + ")" + "|(?<BRACE>" + BRACE_PATTERN + ")" + "|(?<BRACKET>" + BRACKET_PATTERN + ")" + "|(?<SEMICOLON>" + SEMICOLON_PATTERN + ")" + "|(?<STRING>" + STRING_PATTERN + ")" + "|(?<COMMENT>" + COMMENT_PATTERN + ")");
    PATTERN = Pattern.compile(
    "(?<KEYWORD>\\b(" +
        "function|if|else|for|while|switch|case|var|let|const|return|true|false|" +
        "try|catch|finally|throw|new|this|typeof|instanceof|in|delete|await|async|" +
        "window|document|console|alert|navigator|setTimeout|setInterval|clearTimeout|clearInterval|" +
        "addEventListener|querySelector|getElementById|getElementsByClassName|getElementsByTagName|" +
        // TypeScript
        "interface|enum|public|private|protected|readonly|any|unknown|never|void|as|type|namespace|module|" +
        // HTML Tags (complete)
        "html|body|head|title|meta|link|style|script|noscript|base|div|span|img|a|ul|ol|li|table|thead|tbody|tfoot|tr|td|th|form|input|textarea|button|select|option|optgroup|label|fieldset|legend|header|footer|section|article|nav|main|aside|figure|figcaption|details|summary|dialog|canvas|video|audio|source|track|iframe|object|embed|blockquote|q|cite|code|pre|abbr|address|b|i|u|strong|em|small|sub|sup|mark|time|progress|meter|data|datalist|output|br|hr|wbr|p|h1|h2|h3|h4|h5|h6|" +
        // CSS Properties
        "color|background|background-color|background-image|background-position|background-size|background-repeat|background-attachment|border|border-width|border-style|border-color|border-radius|box-sizing|box-shadow|padding|margin|font|font-size|font-weight|font-family|font-style|line-height|letter-spacing|word-spacing|display|position|absolute|relative|fixed|sticky|top|right|bottom|left|z-index|overflow|overflow-x|overflow-y|width|height|min-width|max-width|min-height|max-height|visibility|justify-content|align-items|align-content|align-self|flex|flex-direction|flex-wrap|flex-grow|flex-shrink|flex-basis|grid|grid-template-columns|grid-template-rows|grid-column|grid-row|grid-area|place-items|transform|rotate|scale|translate|skew|transform-origin|transition|transition-property|transition-duration|transition-delay|transition-timing-function|animation|animation-name|animation-duration|animation-delay|animation-iteration-count|animation-direction|animation-fill-mode|opacity|filter|mix-blend-mode|cursor|pointer-events|user-select|content|clip|float|clear|direction|unicode-bidi|white-space|text-align|text-decoration|text-transform|vertical-align|" +
        // SVG Tags
        "svg|g|defs|symbol|use|image|path|rect|circle|ellipse|line|polyline|polygon|text|tspan|textPath|clipPath|mask|pattern|linearGradient|radialGradient|stop|filter|feGaussianBlur|feOffset|feBlend|feColorMatrix|feComponentTransfer|feComposite|feFlood|feImage|feMerge|feMorphology|feTile|feTurbulence|" +
        // SVG Attributes
        "xmlns|xmlns:xlink|x|y|viewBox|fill|stroke|stroke-width|d|cx|cy|r|rx|ry|x1|y1|x2|y2|points|offset|stop-color|stop-opacity|preserveAspectRatio|clip-path|id|" +
        // Markdown
        // JSON
        // XML
       "#|##|###|####|#####|######|\\*\\*|\\*|_|__|\\-|\\+|>|`|```|\\[|\\]|\\(|\\)|!|---|\\*\\*\\*|" +
"null|true|false|\\{|\\}|\\[|\\]|:|,|\\\"|" +
"<\\?xml|<\\?|\\?>|</|/>|CDATA|encoding|version|element|attribute|value|xsi|xlink|" +
"class|extends|super|constructor|static|implements|import|export|from|require|package|default|define|module\\.exports|use strict|OnStart|OnStop|OnPause|OnResume|OnDestroy"+

        // JS Objects
        "Date|Math|Boolean|String|Number|Array|Object|Map|Set|RegExp|JSON|parse|stringify|" +
        // Frameworks
        "React|Vue|Angular|Svelte|jQuery|Next|Nuxt|" +
        // Modules & others
        
    ")\\b)|" +
    "(?<PAREN>\\(|\\))|(?<BRACE>\\{|\\})|(?<BRACKET>\\[|\\])|" +
    "(?<SEMICOLON>;)|(?<STRING>\"([^\"\\\\]|\\\\.)*\")|" +
    "(?<COMMENT>//[^\\n]*|/\\*(.|\\R)*?\\*/)");

  
    
    String sampleCode = String.join("\n", "", "<!DOCTYPE html>\n<html lang=\"en-US\">\n<head>\n<title>Index</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<link href=\"icon.png\" rel=\"icon\">\n<!--Write Links for CSS and JS Files Here!-->\n\n<style type=\"text/css\">\n\n<!--Write Your CSS Code Here!-->\n\n</style>\n\n<script type=\"text/javascript\">\n\n<!--Write Your JS Code Here!-->\n\n</script>\n</head>\n\n<body>\n\n<!--Write Your Code Here-->\n\n</body>\n</html>", "");
      this.codeArea = new CodeArea();
      
      
//      codeArea.caretPositionProperty().addListener((obs, oldPos, newPos) -> {
//    Platform.runLater(() -> {
//        int pos = newPos.intValue();
//        String text = codeArea.getText();
//        if (pos > 0 && pos <= text.length()) {
//            char ch = text.charAt(pos - 1);
//
//            // Handle only if at a brace character
//            if ("{}[]()".indexOf(ch) >= 0) {
//                Optional<Integer> match = findMatchingBrace(text, pos - 1);
//                if (match.isPresent()) {
//                    int matchPos = match.get();
//
//                    // Clear previous highlights
//                    codeArea.setStyleSpans(0, computeHighlight(text, -1, -1));
//
//                    // Highlight current and matching braces
//                    codeArea.setStyleSpans(0, computeHighlight(text, pos - 1, matchPos));
//                }
//            } else {
//                codeArea.setStyleSpans(0, computeHighlight(text, -1, -1)); // Clear highlight
//            }
//        }
//    });
//});

      
   
      
      
      this.codeArea.setContextMenu(conmenu);
      this.codeArea.setWrapText(true);
      IntFunction numberFactory = LineNumberFactory.get(this.codeArea);
      IntFunction arrowFactory = new ArrowFactory(this.codeArea.currentParagraphProperty());
      IntFunction graphicFactory = (line) -> {
         HBox hbox = new HBox(new Node[]{(Node)numberFactory.apply(line), (Node)arrowFactory.apply(line)});
         hbox.setAlignment(Pos.CENTER_LEFT);
         return hbox;
      };
      this.codeArea.setParagraphGraphicFactory(graphicFactory);
      this.codeArea.moveTo(0, 0);
      executor = Executors.newSingleThreadExecutor();
      this.codeArea.setMinSize(1024.0D, 600.0D);
      
      
      
      //this.codeArea.setStyle("-fx-background-color:"+codearea_color+";-fx-font-size:"+font_size+";-fx-font-weight:bold;-fx-font-family:Monospaced;");
      this.codeArea.setStyle("-fx-background-color:" + codearea_color + ";-fx-font-size:"+font_size+";-fx-font-style:"+font_style+";-fx-font-weight:"+font_weight+";-fx-font-family:"+font_family+";");
      this.codeArea.setParagraphGraphicFactory(LineNumberFactory.get(this.codeArea));
      
      Subscription cleanupWhenDone = codeArea.multiPlainChanges().successionEnds(Duration.ofMillis(500L)).supplyTask(this::computeHighlightingAsync).awaitLatest(codeArea.multiPlainChanges()).filterMap(t -> {
          if (t.isSuccess())
            return Optional.of(t.get()); 
          t.getFailure().printStackTrace();
          return Optional.empty();
        }).subscribe(this::applyHighlighting);
    //codeArea.replaceText(0, 0, sampleCode);
      this.codee = new WebView();
      this.codee.getEngine().setJavaScriptEnabled(true);
      this.codee.getEngine().loadContent(this.codeArea.getText());
      this.codee.setMaxWidth(1000);
      
      
      
      
      
      
      
      
      
      
      
      this.codeArea.setOnKeyReleased((kkl) -> {
          
          
        // this.codee.getEngine().loadContent(this.codeArea.getText());
        
        
         if (tabpane.isVisible()==true) {
           
         String FullPathh = htmltab.getText();
         String codeee = this.codeArea.getText();
         mmmo=codeee;
         fullo=FullPathh;
         
           if (fullo.equals("Choose Old File ...")) {
             
             File sw1=new File (System.getProperty("user.home")+"\\Desktop\\Unknown_Project");
             sw1.mkdir();
             
             File sw2=new File (System.getProperty("user.home")+"\\Desktop\\Unknown_Project\\index.html");
             try {
                 sw2.createNewFile();
             } catch (IOException ex) {
                 Logger.getLogger(HTMLEditor_Old.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             htmltab.setText(sw2.getAbsolutePath().toString());
             
             String FullPathhj = htmltab.getText();
             fullo=FullPathhj;
             
             
            
             if (mmmo.isEmpty()) {
                 
                 PrintWriter pw;
                 try {
                     pw = new PrintWriter(new FileWriter(fullo));
                     pw.println();
                     pw.print(mmmo);
                     pw.close();
                 } catch (IOException ex) {
                     Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, null, ex);
                 }
            
                 codee.getEngine().loadContent("");
                 
             }
             
             else {
                 
                      try {
            PrintWriter pw = new PrintWriter(new FileWriter(fullo));
            pw.println();
            pw.print(mmmo);
            pw.close();
            
File filor = new File (fullo);
URL url = filor.toURI().toURL();
String finalUrl = url.toString() + "?t=" + System.currentTimeMillis();
codee.getEngine().load(finalUrl);
codee.getEngine().reload();

//Noti
      Notifications noti = Notifications.create();
      noti.title("Be Careful");
      noti.text("We created folder for project you will find path on tab name by default.");
      noti.position(Pos.CENTER);
      noti.showInformation();

 } catch (IOException var5) {
            Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var5);
         }
                 
             }
              
             
         }
         
         
         
         
         
         
         
           
       }
       
       else {
           
         //TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
         //String FullPathh = selectedItem.getValue().toString();
         String codeee = this.codeArea.getText();
         mmmo=codeee;
         fullo=selfileee;
           
       }
       
         
        
            
         if (mmmo.contains("</html>")) {
                   
         try {
            PrintWriter pw = new PrintWriter(new FileWriter(fullo));
            pw.println();
            pw.print(mmmo);
//            pw.print("<style>\n" +
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
//"        </div>"
//                    + "<script data-name=\"BMC-Widget\" data-cfasync=\"false\" src=\"https://cdnjs.buymeacoffee.com/1.0.0/widget.prod.min.js\" data-id=\"Kadysoft\" data-description=\"Support me on Buy me a coffee!\" data-message=\"\" data-color=\"#ff813f\" data-position=\"Right\" data-x_margin=\"18\" data-y_margin=\"18\"></script>\n" +
//"  </footer>\n" +
//"</body>");
            pw.close();
            
File filor = new File (fullo);
URL url = filor.toURI().toURL();
String finalUrl = url.toString() + "?t=" + System.currentTimeMillis();
codee.getEngine().load(finalUrl);
codee.getEngine().reload();


            
         } catch (IOException var5) {
            Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var5);
         }
         
         
         }
         
         else if (mmmo.contains("</HTML>")) {
                   
         try {
            PrintWriter pw = new PrintWriter(new FileWriter(fullo));
            pw.println();
            pw.print(mmmo);
//            pw.print("<style>\n" +
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
//"        </div>"
//                    + "<script data-name=\"BMC-Widget\" data-cfasync=\"false\" src=\"https://cdnjs.buymeacoffee.com/1.0.0/widget.prod.min.js\" data-id=\"Kadysoft\" data-description=\"Support me on Buy me a coffee!\" data-message=\"\" data-color=\"#ff813f\" data-position=\"Right\" data-x_margin=\"18\" data-y_margin=\"18\"></script>\n" +
//"  </footer>\n" +
//"</body>");
            pw.close();
            
            File filor = new File (fullo);
URL url = filor.toURI().toURL();
String finalUrl = url.toString() + "?t=" + System.currentTimeMillis();
codee.getEngine().load(finalUrl);
codee.getEngine().reload();

            
         } catch (IOException var5) {
            Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var5);
         }
          
         }
         
         
         
         
         
         
         else if (mmmo.contains("<svg")) {       
         try {
            PrintWriter pw = new PrintWriter(new FileWriter(fullo));
            pw.println();
            pw.print(mmmo);
            pw.close();
            
File filor = new File (fullo);
URL url = filor.toURI().toURL();
//String finalUrl = url.toString() + "?t=" + System.currentTimeMillis();
codee.getEngine().load(url.toString());
//codee.getEngine().reload();

         } catch (IOException var5) {
            Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var5);
         }
        
         
         
         
         }
         
         else if (mmmo.contains("<SVG")) {  
         try {
            PrintWriter pw = new PrintWriter(new FileWriter(fullo));
            pw.println();
            pw.print(mmmo);
            pw.close();
            
            
File filor = new File (fullo);
URL url = filor.toURI().toURL();
//String finalUrl = url.toString() + "?t=" + System.currentTimeMillis();
codee.getEngine().load(url.toString());
//codee.getEngine().reload();

         } catch (IOException var5) {
            Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var5);
         }
          
         }
         
         
         
         
      
         
         
         
         
         
         
         
         
         
         else {
             
             
              try {
            PrintWriter pw = new PrintWriter(new FileWriter(fullo));
            pw.println();
            pw.print(mmmo);
            pw.close();
            
File filor = new File (fullo);
URL url = filor.toURI().toURL();
String finalUrl = url.toString() + "?t=" + System.currentTimeMillis();
codee.getEngine().load(finalUrl);
codee.getEngine().reload();


            
         } catch (IOException var5) {
            Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var5);
         } 
             
             
          
//         try {
//            PrintWriter pw = new PrintWriter(new FileWriter(fullo));
//            pw.println();
//            pw.print(mmmo);
//         
//            pw.close();
//            
//            codee.getEngine().loadContent("");
//            
//         } catch (IOException var5) {
//            Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var5);
//         }
             
         }

      });
      
      
      
      
      
      //FIVE//
      
      this.codeArea.setOnMouseClicked((lo) -> {
       //  this.codee.getEngine().loadContent(this.codeArea.getText());
       
       if (tabpane.isVisible()==true) {
           
         String FullPathh = htmltab.getText();
         String codeee = this.codeArea.getText();
         mmmo=codeee;
         fullo=FullPathh;
         
         
           if (fullo.equals("Choose Old File ...")) {
             
             File sw1=new File (System.getProperty("user.home")+"\\Desktop\\Unknown_Project");
             sw1.mkdir();
             
             File sw2=new File (System.getProperty("user.home")+"\\Desktop\\Unknown_Project\\index.html");
             try {
                 sw2.createNewFile();
             } catch (IOException ex) {
                 Logger.getLogger(HTMLEditor_Old.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             htmltab.setText(sw2.getAbsolutePath().toString());
             
             String FullPathhu = htmltab.getText();
             fullo=FullPathhu;
             
                  if (mmmo.isEmpty()) {
                 
                 PrintWriter pw;
                 try {
                     pw = new PrintWriter(new FileWriter(fullo));
                     pw.println();
                     pw.print(mmmo);
                     pw.close();
                 } catch (IOException ex) {
                     Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, null, ex);
                 }
            
                 codee.getEngine().loadContent("");
                 
             }
             
             else {
                 
                      try {
            PrintWriter pw = new PrintWriter(new FileWriter(fullo));
            pw.println();
            pw.print(mmmo);
            pw.close();
            
File filor = new File (fullo);
URL url = filor.toURI().toURL();
String finalUrl = url.toString() + "?t=" + System.currentTimeMillis();
codee.getEngine().load(finalUrl);
codee.getEngine().reload();

//Noti
      Notifications noti = Notifications.create();
      noti.title("Be Careful");
      noti.text("We created folder for project you will find path on tab name by default.");
      noti.position(Pos.CENTER);
      noti.showInformation();

 } catch (IOException var5) {
            Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var5);
         }
                 
             }
             
              
              
             
         }
         
         
         
         
         
         
         
           
       }
       
       else {
           
         //TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
         //String FullPathh = selectedItem.getValue().toString();
         String codeee = this.codeArea.getText();
         mmmo=codeee;
         fullo=selfileee;
           
       }
       
         
         
         if (mmmo.contains("</html>")) {
                   
         try {
            PrintWriter pw = new PrintWriter(new FileWriter(fullo));
            pw.println();
            pw.print(mmmo);
//            pw.print("<style>\n" +
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
//"        </div>"
//                    + "<script data-name=\"BMC-Widget\" data-cfasync=\"false\" src=\"https://cdnjs.buymeacoffee.com/1.0.0/widget.prod.min.js\" data-id=\"Kadysoft\" data-description=\"Support me on Buy me a coffee!\" data-message=\"\" data-color=\"#ff813f\" data-position=\"Right\" data-x_margin=\"18\" data-y_margin=\"18\"></script>\n" +
//"  </footer>\n" +
//"</body>");
            pw.close();
            
File filor = new File (fullo);
URL url = filor.toURI().toURL();
String finalUrl = url.toString() + "?t=" + System.currentTimeMillis();
codee.getEngine().load(finalUrl);
codee.getEngine().reload();

            
         } catch (IOException var5) {
            Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var5);
         }
         
         
             
             
         }
         
         else if (mmmo.contains("</HTML>")) {
                   
         try {
            PrintWriter pw = new PrintWriter(new FileWriter(fullo));
            pw.println();
            pw.print(mmmo);
//            pw.print("<style>\n" +
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
//"        </div>"
//                    + "<script data-name=\"BMC-Widget\" data-cfasync=\"false\" src=\"https://cdnjs.buymeacoffee.com/1.0.0/widget.prod.min.js\" data-id=\"Kadysoft\" data-description=\"Support me on Buy me a coffee!\" data-message=\"\" data-color=\"#ff813f\" data-position=\"Right\" data-x_margin=\"18\" data-y_margin=\"18\"></script>\n" +
//"  </footer>\n" +
//"</body>");
            pw.close();
            
            File filor = new File (fullo);
URL url = filor.toURI().toURL();
String finalUrl = url.toString() + "?t=" + System.currentTimeMillis();
//codee.getEngine().reload();
codee.getEngine().load(finalUrl);
codee.getEngine().reload();

            
         } catch (IOException var5) {
            Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var5);
         }
         
         
             
             
         }
         
         
           else if (mmmo.contains("<svg")) {       
         try {
            PrintWriter pw = new PrintWriter(new FileWriter(fullo));
            pw.println();
            pw.print(mmmo);
            pw.close();
            
File filor = new File (fullo);
URL url = filor.toURI().toURL();
//String finalUrl = url.toString() + "?t=" + System.currentTimeMillis();
codee.getEngine().load(url.toString());
//codee.getEngine().reload();

         } catch (IOException var5) {
            Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var5);
         }
        
         
         
         
         }
         
         else if (mmmo.contains("<SVG")) {  
         try {
            PrintWriter pw = new PrintWriter(new FileWriter(fullo));
            pw.println();
            pw.print(mmmo);
            pw.close();
            
            
File filor = new File (fullo);
URL url = filor.toURI().toURL();
//String finalUrl = url.toString() + "?t=" + System.currentTimeMillis();
codee.getEngine().load(url.toString());
//codee.getEngine().reload();

         } catch (IOException var5) {
            Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var5);
         }
          
         }
         
         
         
         
         
         
         
         
         else {
             
             
            try {
            PrintWriter pw = new PrintWriter(new FileWriter(fullo));
            pw.println();
            pw.print(mmmo);
            pw.close();
            
File filor = new File (fullo);
URL url = filor.toURI().toURL();
String finalUrl = url.toString() + "?t=" + System.currentTimeMillis();
codee.getEngine().load(finalUrl);
codee.getEngine().reload();

            
         } catch (IOException var5) {
            Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var5);
         }
             
          
//         try {
//            PrintWriter pw = new PrintWriter(new FileWriter(fullo));
//            pw.println();
//            pw.print(mmmo);
//          
//            pw.close();
//            codee.getEngine().loadContent("");
//            
//          
//         } catch (IOException var5) {
//            Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var5);
//         }
             
         }
         

         });
      
      
      
      codeArea.setOnKeyPressed((kkl) -> {
        
          
          
          
      });
      
      
      HTMLStage.setOnShowing((hhv) -> {
         
         tabpane = new JFXTabPane();
         tabpane.getStylesheets().add(this.getClass().getResource(codearea_syntax).toExternalForm());
         BorderPane newroot = new BorderPane();
         newroot.getStylesheets().add(this.getClass().getResource(codearea_syntax).toExternalForm());
         newroot.setCenter(new VirtualizedScrollPane(this.codeArea));
         newroot.setRight(this.codee);
         
         
         
         htmlscroll = new ScrollPane();
         htmlscroll.getStylesheets().add(this.getClass().getResource(codearea_syntax).toExternalForm());  //Change Theme
         htmlscroll.setVbarPolicy(ScrollBarPolicy.NEVER);
         htmlscroll.setHbarPolicy(ScrollBarPolicy.NEVER);
         htmlscroll.setFitToHeight(true);
         htmlscroll.setPannable(true);
         htmlscroll.setContent(newroot);
         htmlscroll.setFitToWidth(true);
         htmltab = new Tab("Choose Old File ...");
         htmltab.setClosable(false);
         htmltab.setContent(htmlscroll);
         tabpane.getTabs().addAll(new Tab[]{htmltab});
         SplitPane split=new SplitPane(tabpane);
         split.setOrientation(Orientation.VERTICAL);
         
         root.setCenter(split);
      });
      
      
      
      root = new BorderPane();
      root.setTop(barr);
      Scene scenee = new Scene(root, 1600.0D, 750.0D);
      scenee.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
    if (event.getButton() == MouseButton.PRIMARY || event.getButton() == MouseButton.MIDDLE) {
        contextMenu.hide();
        folderContextMenu.hide();
    }
});
      scenee.getStylesheets().add(this.getClass().getResource(app_theme).toExternalForm());
      HTMLStage.setScene(scenee);
      HTMLStage.centerOnScreen();
      HTMLStage.setTitle("HTML Editor (Eagle Version)");
      HTMLStage.setResizable(true);
      
      HTMLStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
      @Override
      public void handle(WindowEvent event) {
          
Alert alertio = new Alert(Alert.AlertType.CONFIRMATION);
alertio.setTitle("Close!");
alertio.setHeaderText("Exit Eagle Editor");
alertio.setContentText("Are you sure you wanna exit?");
ButtonType buttonTypeOne = new ButtonType("Yes");
ButtonType buttonTypetwo = new ButtonType("No");
alertio.getButtonTypes().setAll(buttonTypeOne, buttonTypetwo);
DialogPane dialogPaneii = alertio.getDialogPane();
dialogPaneii.getStylesheets().add(getClass().getResource(app_theme).toExternalForm());
Optional<ButtonType> results = alertio.showAndWait();


if (results.isPresent() && results.get() == buttonTypeOne) {
    
   //System.exit(0);
   Stage stage = (Stage) barr.getScene().getWindow();
   stage.close(); // ✅ Closes just this window
    
}
  

else if (results.isPresent() && results.get() == buttonTypetwo) {
    
    event.consume();
        
}


else {

    
    
}

          
        
      }
      });
      
      
      



      
      
 
      HTMLStage.show();
      

      
      
   }
   
   

   public void stop() {
    executor.shutdown();
  }
   
   
   
   
   private void refreshProjectTree() throws IOException {
       
   //  Platform.runLater(() -> {   
    if (projectRoot != null) {
        TreeItem<Path> rootItem = createNode(projectRoot);
        projectTree.setRoot(rootItem);
        projectTree.setShowRoot(true); // Set false if you don't want root shown
        enableDragAndDrop(rootItem);   // If you have DnD
        expandTree(rootItem);          // Expand if needed
        codeArea.setDisable(true);
    }
   // });
    
}
  
  
//   private void setupRefreshTimer() {
//    Timer timer = new Timer();
//    timer.schedule(new TimerTask() {
//        @Override
//        public void run() {
//            Platform.runLater(() -> {
//                try {
//                    TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
//                    refreshProjectTree();
//                    projectTree.getSelectionModel().select(selectedItem);
//                   // System.out.println("Hello");
//                } catch (IOException ex) {
//                    Logger.getLogger(HTMLEditor_Old.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            });  
//            
//          //  Platform.runLater(() -> workmach.setText(Integer.toString(workingmachinesno)));  
//            
//        }
//    }, 1000 , 5000 );
//}

   
    
   
   
    
    private void expandTree(TreeItem<?> item) {
    if (item != null && !item.isLeaf()) {
        item.setExpanded(true);
        for (TreeItem<?> child : item.getChildren()) {
            expandTree(child);
        }
    }
}
    
    private TreeItem<Path> buildProjectsTree(Path projectsDirectory) throws IOException {
    TreeItem<Path> rootItem = new TreeItem<>(projectsDirectory);

    try (DirectoryStream<Path> stream = Files.newDirectoryStream(projectsDirectory)) {
        for (Path path : stream) {
            if (Files.isDirectory(path)) {
                TreeItem<Path> projectItem = new TreeItem<>(path);
                rootItem.getChildren().add(projectItem);

                // You can preload just 1 dummy child if you want lazy loading later
                if (hasSubDirectories(path)) {
                    projectItem.getChildren().add(new TreeItem<>(Paths.get("Loading...")));
                }
            }
        }
    }
    return rootItem;
}

private boolean hasSubDirectories(Path dir) throws IOException {
    try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
        for (Path path : stream) {
            if (Files.isDirectory(path)) {
                return true;
            }
        }
    }
    return false;
}

    // Set up drag-and-drop functionality
    private void enableDragAndDrop(TreeItem<Path> rootItem) {
        // Handle drag over (allow files to be dragged onto the tree)
        projectTree.setOnDragOver(event -> {
            if (event.getGestureSource() != projectTree && event.getDragboard().hasFiles()) {
                event.acceptTransferModes(TransferMode.COPY);
            }
            event.consume();
        });

        // Handle drop action
        projectTree.setOnDragDropped(event -> {
            javafx.scene.input.Dragboard dragboard = event.getDragboard();  // Explicit type for dragboard
            if (dragboard.hasFiles()) {
                for (java.io.File file : dragboard.getFiles()) {  // Explicit type for file
                    Path filePath = file.toPath();

                    if (Files.isRegularFile(filePath)) {
                        // Check if the drop target is a folder or the root project folder
                        TreeItem<Path> selectedItem = projectTree.getSelectionModel().getSelectedItem();
                        if (selectedItem != null) {
                            if (Files.isDirectory(selectedItem.getValue())) {
                                // Drop onto a folder (subfolder)
                                addFileToProject(filePath, selectedItem);
                            } else if (Files.isDirectory(selectedItem.getValue().getParent())) {
                                // Drop onto the root project folder
                                addFileToProject(filePath, rootItem);
                            }
                        } else {
                            // Drop onto the root project folder if no item is selected
                            addFileToProject(filePath, rootItem);
                        }
                    }
                }
                event.setDropCompleted(true);
            }
            event.consume();
        });
    }

    // Add the dropped file to the project tree view (subfolder or root)
    private void addFileToProject(Path file, TreeItem<Path> parentItem) {
        // If dropping directly on the project root, add the file directly under the root
        if (parentItem.getValue().getFileName().toString().equals("Project")) {
            TreeItem<Path> fileItem = new TreeItem<>(file);
            parentItem.getChildren().add(fileItem);
        } else {
            // If dropping on a folder, add the file as a child of that folder
            TreeItem<Path> fileItem = new TreeItem<>(file);
            parentItem.getChildren().add(fileItem);
        }

        // Optionally, load the file or preview it if needed
        loadFileToEditor(file);
    }


   // --- Helper Methods ---

private void showMediaPreview(Path mediaPath) {
    try {
        String fileName = mediaPath.getFileName().toString().toLowerCase();
        String mediaURL = mediaPath.toUri().toString();

        Media media = new Media(mediaURL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        // Buttons
        Button playButton = new Button("Play");
        Button pauseButton = new Button("Pause");
        Button stopButton = new Button("Stop");

        HBox controls = new HBox(10, playButton, pauseButton, stopButton);
        controls.setAlignment(Pos.CENTER);

        // Add buttons immediately
        root.getChildren().add(controls);

        // Video support
        if (fileName.endsWith(".mp4")) {
            MediaView mediaView = new MediaView(mediaPlayer);
            mediaView.setPreserveRatio(true);
            mediaView.setFitWidth(600);
            mediaView.setFitHeight(400);
            root.getChildren().add(0, mediaView); // add before controls
        }

        // Controls
        playButton.setOnAction(e -> {
            mediaPlayer.play();
        });

        pauseButton.setOnAction(e -> mediaPlayer.pause());
        stopButton.setOnAction(e -> mediaPlayer.stop());

        // Prepare scene
        Scene scene = new Scene(root, 650, fileName.endsWith(".mp4") ? 480 : 150);
        scene.getStylesheets().add(getClass().getResource(app_theme).toExternalForm());

        Stage stage = new Stage();
        stage.setTitle("Media Preview - " + mediaPath.getFileName());
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        // Ensure mediaPlayer is released on close
        stage.setOnCloseRequest(e -> mediaPlayer.dispose());

        // ❗ Start only when ready (especially for .mp3)
        mediaPlayer.setOnReady(() -> {
            System.out.println("Media ready: duration = " + mediaPlayer.getMedia().getDuration().toSeconds() + " seconds");
            // Optional: autoplay
            // mediaPlayer.play();
        });

        mediaPlayer.setOnError(() -> {
            System.err.println("Media error: " + mediaPlayer.getError().getMessage());
            showErrorDialog("Media Error: " + mediaPlayer.getError().getMessage());
        });

        stage.showAndWait();

    } catch (Exception ex) {
        ex.printStackTrace();
        showErrorDialog("Failed to preview media: " + ex.getMessage());
    }
}



    
   private void showPDFPreview(Path imagePath) {
    try {
        
        File file = new File(imagePath.toFile().toString());
        PDDocument document = PDDocument.load(file);
        PDFRenderer renderer = new PDFRenderer(document);
        int numPages = document.getNumberOfPages();
        ListView<Integer> listView = new ListView<>();
        listView.setOrientation(Orientation.VERTICAL);
        for (int i = 0; i < numPages; i++) listView.getItems().add(i);
        listView.setCellFactory(lv -> new ListCell<Integer>() {
            private ImageView imageView = new ImageView();

            @Override
            protected void updateItem(Integer pageIndex, boolean empty) {
                super.updateItem(pageIndex, empty);
                if (empty || pageIndex == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(imageView);
                imageView.setFitWidth(600);
                imageView.setPreserveRatio(true);
                imageView.setImage(null); // reset
                // Render page in background
                executort.submit(() -> {
                    try {
                        BufferedImage bim = renderer.renderImageWithDPI(pageIndex, 72);
                        Image fxImage = SwingFXUtils.toFXImage(bim, null);
                        Platform.runLater(() -> imageView.setImage(fxImage));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        });
        Stage stage = new Stage();
        Scene scene = new Scene(listView, 800, 600);
        scene.getStylesheets().add(getClass().getResource(app_theme).toExternalForm());
        stage.setTitle("PDF Preview - " + imagePath.getFileName());
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        stage.setOnCloseRequest(event -> {
            executor.shutdown();
            try {
                document.close();
            } catch (Exception ignored) {}
        });
        
    } catch (IOException ex) {
        ex.printStackTrace();
    }
} 
    
    

private void showImagePreview(Path imagePath) {
    try {
        Image image = new Image(Files.newInputStream(imagePath));
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(600);
        imageView.setFitHeight(400);

        StackPane root = new StackPane(imageView);
        Scene scene = new Scene(root, 650, 450);
        scene.getStylesheets().add(getClass().getResource(app_theme).toExternalForm());

        Stage stage = new Stage();
        stage.setTitle("Image Preview - " + imagePath.getFileName());
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

private boolean showConfirmationDialog(String message) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirm Deletion");
    alert.setHeaderText(message);
    DialogPane dialogPane = alert.getDialogPane();
    dialogPane.getStylesheets().add(
    getClass().getResource(app_theme).toExternalForm());
    Optional<ButtonType> result = alert.showAndWait();
    return result.isPresent() && result.get() == ButtonType.OK;
    
}

private void deleteDirectoryRecursively(Path path) throws IOException {
    if (Files.isDirectory(path)) {
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(path)) {
            for (Path entry : entries) {
                deleteDirectoryRecursively(entry);
            }
        }
    }
    Files.deleteIfExists(path);
}







    private TreeItem<Path> createNode(Path filePath) {
    TreeItem<Path> item = new TreeItem<>(filePath);
    if (Files.isDirectory(filePath)) {
        // Folder icon for directories
        item.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("folder.png"))));
        
        
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(filePath)) {
            for (Path child : stream) {
                if (Files.isDirectory(child)) {
                    item.getChildren().add(createNode(child)); // Recurse for folders
                } else {
                    item.getChildren().add(createFileNode(child)); // Add file
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
//        try {
//            Files.walk(filePath).filter(Files::isRegularFile).forEach(path -> {
//                if (Files.isDirectory(path)) {
//                    item.getChildren().add(createNode(path)); // Recurse for directories
//                } else {
//                    TreeItem<Path> fileItem = createFileNode(path);
//                    item.getChildren().add(fileItem); // Add file items with icons
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        
        
    } else {
        item.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("default_file.png"))));
    }

    return item;
}
    
    private TreeItem<Path> createFileNode(Path filePath) {
    TreeItem<Path> fileItem = new TreeItem<>(filePath);
    String extension = getFileExtension(filePath);
    System.out.println(extension);

    if ("html".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("html_1.png"))));
    } else if ("css".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("css_1.png"))));
    } else if ("js".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("js_1.png"))));
    }
    
    
    else if ("png".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("imgo.png"))));
    }
    else if ("jpg".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("imgo.png"))));
    }
    else if ("jpeg".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("imgo.png"))));
    }
    else if ("ico".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("imgo.png"))));
    }
    else if ("gif".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("imgo.png"))));
    }
    else if ("bmp".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("imgo.png"))));
    }
    
    
    
    
    
    else if ("json".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("json.png"))));
    }
    else if ("pdf".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("pdff.png"))));
    }
    else if ("ts".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("ts.png"))));
    }
    else if ("md".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("md.png"))));
    }
    else if ("svg".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("svg.png"))));
    }
    else if ("txt".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("txt.png"))));
    }
    else if ("mp3".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("mp3.png"))));
    }
    else if ("mp4".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("mp4.png"))));
    }
    else if ("wav".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("wav.png"))));
    }
    else if ("xml".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("xml.png"))));
    }
    else if ("xlsx".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("xlsx.png"))));
    }
    else if ("xls".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("xlsx.png"))));
    }
    else if ("ppt".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("ppt.png"))));
    }
    else if ("docx".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("docx.png"))));
    }
    else if ("zip".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("zip.png"))));
    }
    else if ("rar".equalsIgnoreCase(extension)) {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("zip.png"))));
    }
    
    
    
    
    else {
        fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("default_file.png"))));
    }

    return fileItem;
}
    
    private String getFileExtension(Path filePath) {
    String filename = filePath.getFileName().toString();
    int dotIndex = filename.lastIndexOf('.');
    return (dotIndex == -1) ? "" : filename.substring(dotIndex + 1);
}

    
    private void loadFileToEditor(Path filePath) {
        try {
            
            codeArea.setDisable(true); // Optional: prevents user interaction
            String content = new String(Files.readAllBytes(filePath), StandardCharsets.UTF_8);
            codeArea.replaceText(content);        
            codeArea.getUndoManager().forgetHistory();
            codeArea.setDisable(false);

        } catch (IOException e) {
            showAlert("Error", "Failed to load file: " + e.getMessage());
        }
    }

    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
        getClass().getResource(app_theme).toExternalForm());
        alert.showAndWait();
    }
  
    
  private void loadProjects() {
    try {
        String userrr=System.getProperty("user.home");
        Path projectsDir = Paths.get(userrr+"\\Eagle_Projects"); // your projects directory
        if (Files.exists(projectsDir) && Files.isDirectory(projectsDir)) {
            TreeItem<Path> root = (TreeItem<Path>) projectTree.getRoot();
            if (root == null) {
                root = new TreeItem<>(projectsDir); // جذر يحتوي على مجلد المشاريع نفسه
                projectTree.setRoot(root);
            }

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(projectsDir)) {
                for (Path entry : stream) {
                    if (Files.isDirectory(entry)) {
                        boolean alreadyExists = root.getChildren().stream()
                                .anyMatch(child -> child.getValue().equals(entry));
                        if (!alreadyExists) {
                            TreeItem<Path> projectItem = new TreeItem<>(entry);
                            root.getChildren().add(projectItem);
                        }
                    }
                }
            }

            projectTree.setShowRoot(true);

            // (اختياري) عرض اسم الفولدر بدل المسار الكامل:
            projectTree.setCellFactory(tv -> new TreeCell<Path>() {
                @Override
                protected void updateItem(Path item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.getFileName().toString()); // يعرض اسم المجلد فقط
                    }
                }
            });
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

   
private TreeItem<Path> getTreeItemAtMousePosition(MouseEvent event) {
    Node node = event.getPickResult().getIntersectedNode();

    // Traverse up to TreeCell
    while (node != null && !(node instanceof TreeCell)) {
        node = node.getParent();
    }

    if (node instanceof TreeCell) {
        TreeCell cell = (TreeCell) node;
        return cell.getTreeItem();
    }

    return null;
}



  
  /////////////////////////////////////////////////////////////////////////////////

private void showFontDialog(CodeArea codeArea) {
        Stage dialog = new Stage();
        dialog.setTitle("Choose Font");
        
        //dialog.initOwner(owner);

        ComboBox<String> fontFamilyBox = new ComboBox<>();
        fontFamilyBox.setItems(FXCollections.observableArrayList(Font.getFamilies()));
        fontFamilyBox.setEditable(false);
        fontFamilyBox.setValue("Consolas"); // default

        ComboBox<Integer> fontSizeBox = new ComboBox<>();
        fontSizeBox.setItems(FXCollections.observableArrayList(8, 10, 12, 14, 16, 18, 20, 24, 28, 32, 36, 40, 48, 64));
        fontSizeBox.setEditable(true);
        fontSizeBox.setValue(16);

        JFXCheckBox boldCheck = new JFXCheckBox("Bold");
        JFXCheckBox italicCheck = new JFXCheckBox("Italic");

        Label preview = new Label("Preview: Aa Bb Cc 123");
        preview.setStyle("-fx-border-color: gray; -fx-padding: 10;");
        updatePreview(preview, fontFamilyBox.getValue(), fontSizeBox.getValue(), boldCheck.isSelected(), italicCheck.isSelected());

        Runnable update = () -> updatePreview(preview,
                fontFamilyBox.getValue(),
                fontSizeBox.getValue(),
                boldCheck.isSelected(),
                italicCheck.isSelected());

        fontFamilyBox.setOnAction(e -> update.run());
        fontSizeBox.setOnAction(e -> update.run());
        boldCheck.setOnAction(e -> update.run());
        italicCheck.setOnAction(e -> update.run());

        JFXButton applyBtn = new JFXButton("Apply");
        
        applyBtn.setOnAction(e -> {
    try {
        String sizeStr = fontSizeBox.getEditor().getText();
        int size = Integer.parseInt(sizeStr);

        currentFontSize = (double) size;

        String style = buildFontStyle(fontFamilyBox.getValue(), size, boldCheck.isSelected(), italicCheck.isSelected());
        codeArea.setStyle(style + "-fx-background-color:" + codearea_color + ";");

        updateSetting("Font_Size", Integer.toString(size));
        updateSetting("Font_Family", fontFamilyBox.getValue());
        if (boldCheck.isSelected())
        {
            updateSetting("Font_Weight", "bold");
            font_weight="bold";
        }
        if (italicCheck.isSelected())
        {
            updateSetting("Font_Style", "italic");
            font_style="italic";
        }
                
        font_family=fontFamilyBox.getValue();
                

        dialog.close();
    } catch (NumberFormatException ex) {
        System.err.println("Invalid font size entered: " + fontSizeBox.getEditor().getText());
        // Optionally show an alert to the user
    }
});

        
//        applyBtn.setOnAction(e -> {
//            currentFontSize = (double)fontSizeBox.getValue();
//            String style = buildFontStyle(fontFamilyBox.getValue(), fontSizeBox.getValue(), boldCheck.isSelected(), italicCheck.isSelected());
//            codeArea.setStyle(style+"-fx-background-color:" + codearea_color + ";");
//            
//            updateSetting("Font_Size",Integer.toString(fontSizeBox.getValue()));
//            updateSetting("Font_Family",fontFamilyBox.getValue());
//            if (boldCheck.isSelected()) {updateSetting("Font_Weight","bold");}
//            if (italicCheck.isSelected()) {updateSetting("Font_Style","italic");}
//            
//            
//            dialog.close();
//        });

        VBox layout = new VBox(10,
                new Label("Font Family:"), fontFamilyBox,
                new Label("Font Size:"), fontSizeBox,
                boldCheck, italicCheck,
                preview, applyBtn);
        layout.setPadding(new Insets(10));
        Scene gd=new Scene (layout);
        gd.getStylesheets().add(getClass().getResource(app_theme).toExternalForm());
        dialog.setScene(gd);
        dialog.setResizable(false);
        dialog.show();
    }

    private void updatePreview(Label label, String family, int size, boolean bold, boolean italic) {
        String style = buildFontStyle(family, size, bold, italic);
        label.setStyle(style + "; -fx-border-color: gray; -fx-padding: 10;");
    }

    private String buildFontStyle(String family, int size, boolean bold, boolean italic) {
        StringBuilder style = new StringBuilder();
        style.append(String.format("-fx-font-family: '%s'; -fx-font-size: %dpx;", family, size));
        if (bold) style.append(" -fx-font-weight: bold;");
        if (italic) style.append(" -fx-font-style: italic;");
        return style.toString();
    }


  ////////////////////////////////////////////////////////////////////////////////
  
//  
//  private void showFontSizeDialog() {
//        TextInputDialog dialog = new TextInputDialog(String.valueOf((int) currentFontSize));
//        dialog.setTitle("Font Size");
//        dialog.setHeaderText("Set Font Size");
//        dialog.setContentText("Enter size (e.g. 14):");
//
//        styleDialogDark(dialog.getDialogPane());
//
//        Optional<String> result = dialog.showAndWait();
//        result.ifPresent(size -> {
//            try {
//                currentFontSize = Double.parseDouble(size);
//                //codeArea.setStyle("-fx-font-size: " + currentFontSize + "px;");
//                codeArea.setStyle("-fx-background-color:" + codearea_color + ";-fx-font-size:"+currentFontSize+";-fx-font-weight:bold;-fx-font-family:Monospaced;");
//           
//                updateSetting("Font_Size",size);
//            } catch (NumberFormatException e) {
//                showError("Invalid number format.");
//            }
//        });
//    }
  
  
  
  
  private void showThemeDialog() {
        ChoiceDialog<String> dialog = new ChoiceDialog<>(currentTheme, app_theme, "nord-light.css","nord-dark.css","cupertino-dark.css","cupertino-light.css","dracula.css","dark.css","ssss.css","primer-dark.css","primer-light.css");
        dialog.setTitle("Theme");
        dialog.setHeaderText("Select CSS Theme");
        dialog.setContentText("Choose style:");

        styleDialogDark(dialog.getDialogPane());

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(theme -> {
            currentTheme = theme;
            app_theme = theme;
            Scene scene = codeArea.getScene();
            applyTheme(scene, currentTheme);
            updateSetting("App_Theme",currentTheme);
        });
    }
  
  
  
  private void mnmnmnmn() {
    File cssFile = new File(System.getProperty("user.home") + File.separator + "dynamic-theme.css");
    currentTheme = cssFile.getAbsolutePath();
    app_theme = cssFile.getAbsolutePath();

    Scene scene = codeArea.getScene();
    if (scene != null) {
        applyThemey(scene, currentTheme);
    } else {
        System.err.println("Scene is null.");
    }

    updateSetting("App_Theme", currentTheme);
}


  private void applyThemey(Scene scene, String themeFilePath) {
    try {
        scene.getStylesheets().clear();
        File file = new File(themeFilePath);
        if (file.exists()) {
            String cssUri = file.toURI().toString();
            scene.getStylesheets().add(cssUri);
            System.out.println("Theme applied: " + cssUri);
        } else {
            System.err.println("Theme file not found: " + themeFilePath);
        }
    } catch (Exception ex) {
        System.err.println("Error applying theme: " + themeFilePath);
        ex.printStackTrace();
    }
}

  

    private void styleDialogDark(DialogPane dialogPane) {
        dialogPane.getStylesheets().add(getClass().getResource(app_theme).toExternalForm());
        dialogPane.getStyleClass().add("dark-dialog");
    }

    private void applyTheme(Scene scene, String themeFile) {
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource(themeFile).toExternalForm());
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        styleDialogDark(alert.getDialogPane());
        alert.showAndWait();
    }

//
//private void showCodeAreaThemeDialog(ScrollPane scpane) {
//    ChoiceDialog<String> dialog = new ChoiceDialog<>(codearea_syntax,
//    codearea_syntax,     "light-theme.css",
//    "dark-nord.css",
//    "monokai.css",
//    "draculaa.css",
//    "solarized-dark.css",
//    "solarized-light.css",
//    "github-dark.css",
//    "one-dark.css",
//    "gruvbox-dark.css",
//    "material-light.css");
//
//    dialog.setTitle("Code Syntax Theme");
//    dialog.setHeaderText("Change Code Editor Theme");
//    dialog.setContentText("Choose theme:");
//
//    styleDialogDark(dialog.getDialogPane());
//
//    Optional<String> result = dialog.showAndWait();
//    result.ifPresent(themeeCss -> {
//        
//        scpane.getStylesheets().clear();
//        scpane.getStylesheets().add(getClass().getResource(themeeCss).toExternalForm());
//        
//    });
//}

    

    
private void showCodeAreaThemeDialog(ScrollPane scpane) {
    ChoiceDialog<String> dialog = new ChoiceDialog<>(codearea_syntax,
            codearea_syntax, "java-keywords.css","intellij_light.css","github_light.css","chrome_light.css","solarized_light.css","xcode_light.css","eclipse_light.css","tomorrow_light.css","netbeans_light.css","vs_light.css","atom_one_light.css","ace_cloud_light.css","idle_light.css","dracula_light.css","solarized_white.css","papercolor_light.css","intellij_dark.css","github_dark.css","monokai.css","chrome.css","tomorrow_night.css","solarized_dark.css","one_dark.css","material_darker.css","nord.css","gruvbox_dark.css","night_owl.css","oceanic_next.css","cobalt2.css","ayu_mirage.css","synthwave.css");

    dialog.setTitle("Code Syntax Theme");
    dialog.setHeaderText("Change Code Editor Theme");
    dialog.setContentText("Choose theme:");

    styleDialogDark(dialog.getDialogPane());

    Optional<String> result = dialog.showAndWait();
    result.ifPresent(themeCss -> {
        scpane.getStylesheets().clear();
        scpane.getStylesheets().add(getClass().getResource(themeCss).toExternalForm());
        
        if (themeCss.contains("monokai")) {
            codeArea.setStyle("-fx-background-color: #272822; -fx-text-fill: #f8f8f2;");
            updateSetting("CodeArea_Color","#272822");
            codearea_color="#272822";
        }
        
        else {
            //codeArea.setStyle("-fx-background-color:"+codearea_color+";-fx-font-size:"+currentFontSize+";-fx-font-weight:bold;-fx-font-family:Monospaced;");
            codeArea.setStyle("-fx-background-color:" + codearea_color + ";-fx-font-size:"+currentFontSize+";-fx-font-style:"+font_style+";-fx-font-weight:"+font_weight+";-fx-font-family:"+font_family+";");
        }
        
        updateSetting("CodeArea_Syntax",themeCss);
        
    });
}

 // Helper: Convert Color to HEX string
    private String toHexString(Color color) {
        return String.format("#%02X%02X%02X",
            (int)(color.getRed() * 255),
            (int)(color.getGreen() * 255),
            (int)(color.getBlue() * 255));
    }

  
  
  private Optional<Integer> findMatchingBrace(String text, int pos) {
    char ch = text.charAt(pos);
    char open, close;
    int direction;

    switch (ch) {
        case '{': open = ch; close = '}'; direction = 1; break;
        case '(': open = ch; close = ')'; direction = 1; break;
        case '[': open = ch; close = ']'; direction = 1; break;
        case '}': open = '{'; close = ch; direction = -1; break;
        case ')': open = '('; close = ch; direction = -1; break;
        case ']': open = '['; close = ch; direction = -1; break;
        default: return Optional.empty();
    }

    int depth = 0;
    for (int i = pos; i >= 0 && i < text.length(); i += direction) {
        char c = text.charAt(i);
        if (c == open) depth++;
        if (c == close) depth--;
        if (depth == 0) return Optional.of(i);
    }

    return Optional.empty();
}

private StyleSpans<Collection<String>> computeHighlight(String text, int pos1, int pos2) {
    StyleSpansBuilder<Collection<String>> spansBuilder = new StyleSpansBuilder<>();
    int last = 0;
    for (int i = 0; i < text.length(); i++) {
        if (i == pos1 || i == pos2) {
            spansBuilder.add(Collections.emptyList(), i - last);
            spansBuilder.add(Collections.singleton("brace-highlight"), 1);
            last = i + 1;
        }
    }
    spansBuilder.add(Collections.emptyList(), text.length() - last);
    return spansBuilder.create();
}

   

public void simulateMouseClickOnNode(Node node) {
    Platform.runLater(() -> {
        try {
            // Get screen coordinates of the node
            Bounds bounds = node.localToScreen(node.getBoundsInLocal());
            double x = bounds.getMinX() + bounds.getWidth() / 2;
            double y = bounds.getMinY() + bounds.getHeight() / 2;

            // Use AWT Robot to click
            Robot robot = new Robot();
            robot.mouseMove((int) x, (int) y);
            robot.mousePress(java.awt.event.MouseEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(java.awt.event.MouseEvent.BUTTON1_DOWN_MASK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    });
}




private void updateSetting(String keyToUpdate, String newValue) {
        try {
            String userpathh = System.getProperty("user.home");
            Path filePath = Paths.get(userpathh + "/AppData/Roaming/resources/data/Settings.kady");
            List<String> lines = Files.readAllLines(filePath);
            List<String> updatedLines = new ArrayList<>();
            for (String line : lines) {
                if (line.startsWith(keyToUpdate + "=")) {
                    updatedLines.add(keyToUpdate + "=" + newValue);
                } else {
                    updatedLines.add(line);
                }
            }
            Files.write(filePath, updatedLines, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
   
  


private void showErrorDialog(String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText(null);
    alert.setContentText(message);
    DialogPane dialogPaneii = alert.getDialogPane();
    dialogPaneii.getStylesheets().add(getClass().getResource(app_theme).toExternalForm());
    alert.showAndWait();
}




// Helper method for alerts
private void showAlert(Alert.AlertType type, String title, String message) {
    Alert alert = new Alert(type);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.setResizable(false);
    DialogPane dialogPane = alert.getDialogPane();
    dialogPane.setStyle("-fx-background-color: #3c3f41; -fx-text-fill: white;");
    dialogPane.lookup(".content.label").setStyle("-fx-text-fill: white;");
    alert.showAndWait();
}

   
   
   
   
   public String beautifyHtml(String rawHtml) {
    Document doc = Jsoup.parse(rawHtml);
    doc.outputSettings()
        .indentAmount(4)
        .prettyPrint(true)
        .escapeMode(Entities.EscapeMode.base);
    return doc.outerHtml();
}
   
   
   
   
  
  private Task<StyleSpans<Collection<String>>> computeHighlightingAsync() {
    final String text = codeArea.getText();
    Task<StyleSpans<Collection<String>>> task = new Task<StyleSpans<Collection<String>>>() {
        protected StyleSpans<Collection<String>> call() throws Exception {
          return HTMLEditor_Old.computeHighlighting(text);
        }
      };
    executor.execute(task);
    return task;
  }
  
  private void applyHighlighting(StyleSpans<Collection<String>> highlighting) {
    codeArea.setStyleSpans(0, highlighting);
  }
  
  private static StyleSpans<Collection<String>> computeHighlighting(String text) {
    Matcher matcher = PATTERN.matcher(text);
    int lastKwEnd = 0;
    StyleSpansBuilder<Collection<String>> spansBuilder = new StyleSpansBuilder();
    while (matcher.find()) {
      String styleClass = (matcher.group("KEYWORD") != null) ? "keyword" : ((matcher.group("PAREN") != null) ? "paren" : ((matcher.group("BRACE") != null) ? "brace" : ((matcher.group("BRACKET") != null) ? "bracket" : ((matcher.group("SEMICOLON") != null) ? "semicolon" : ((matcher.group("STRING") != null) ? "string" : ((matcher.group("COMMENT") != null) ? "comment" : null))))));
      assert styleClass != null;
      spansBuilder.add(Collections.emptyList(), matcher.start() - lastKwEnd);
      spansBuilder.add(Collections.singleton(styleClass), matcher.end() - matcher.start());
      lastKwEnd = matcher.end();
    } 
    spansBuilder.add(Collections.emptyList(), text.length() - lastKwEnd);
    return spansBuilder.create();
  }
  
  
  
  
  
  
  
  
  
  public void cococo ()  {
          
              
      if (!codeArea.getText().isEmpty()) {
	  
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Open HTML File");
      alert.setHeaderText("Are you sure want to open new project?\n\nYou will lose everything!!!.");
      alert.setContentText("We will discard all changes.");
      DialogPane dialogPaneu = alert.getDialogPane();
      dialogPaneu.getStylesheets().add(
      getClass().getResource(app_theme).toExternalForm());
      Optional<ButtonType> option = alert.showAndWait();
      if (option.get() == null) {} 
	  else if (option.get() == ButtonType.OK) {
       
      codeArea.clear();
      codee.getEngine().loadContent("");
      
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select Location to Create Project");
        Path selectedDir = Optional.ofNullable(chooser.showDialog(null))
                .map(File::toPath)
                .orElse(null);
        if (selectedDir != null) {
            TextInputDialog dialog = new TextInputDialog("NewBlankHtmlProject");
            dialog.setTitle("Project Name");
            dialog.setHeaderText("Enter project name:");
            DialogPane dialogPaneuu = dialog.getDialogPane();
            dialogPaneuu.getStylesheets().add(
            getClass().getResource(app_theme).toExternalForm());
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(name -> {
                try {
                    projectRoot = selectedDir.resolve(name);
                    Files.createDirectories(projectRoot);
                    
                    Files.write(projectRoot.resolve("index.html"),
    ("<!DOCTYPE html>\n" +
"<html lang=\"en\" dir=\"ltr\">\n" +
"<head>\n" +
"  <meta charset=\"UTF-8\">\n" +
"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"  <title>Blank HTML Project</title>\n" +
"  <link rel=\"stylesheet\" href=\"style.css\">\n" +
"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css\">\n" +
"</head>\n" +
"<body>\n" +
"\n" +
"\n" +
"\n" +
"  <script src=\"script.js\"></script>\n" +
"</body>\n" +
"</html>").getBytes(StandardCharsets.UTF_8)
);

                    
                    
                    Files.write(projectRoot.resolve("style.css"),
    ("/* Global Styles */\n"
    ).getBytes(StandardCharsets.UTF_8)
);

                    
                    Files.write(projectRoot.resolve("script.js"),
    ("// Theme Toggle\n").getBytes(StandardCharsets.UTF_8)
);

                    
                  //  refreshProjectTree();
                    
                //    try {
//    refreshProjectTree();
//} catch (IOException e) {
//    e.printStackTrace();
//}

        SplitPane splitPane = new SplitPane();
        codeArea.setWrapText(true);
        scpane=new ScrollPane();
        scpane.setFitToHeight(true);
        scpane.setFitToWidth(true);
        scpane.getStylesheets().add(this.getClass().getResource(codearea_syntax).toExternalForm());
        scpane.getStylesheets().add(this.getClass().getResource(app_theme).toExternalForm());
        scpane.setContent(new VirtualizedScrollPane(this.codeArea));
        scpane1=new ScrollPane();
        scpane1.setFitToHeight(true);
        scpane1.setFitToWidth(true);
        scpane1.setContent(projectTree);
        scpane2=new ScrollPane();
        scpane2.setFitToHeight(true);
        //scpane2.setFitToWidth(true);
        scpane2.setContent(codee);
        splitPane.getItems().addAll(scpane1, scpane,scpane2);
        splitPane.setDividerPositions(0.2, 0.8);
        root.setCenter(splitPane);
        tabpane.setVisible(false);
        
        
        codeArea.setDisable(false);
        codee.setDisable(false);
        
        newhtml.setDisable(true);
        openf.setDisable(true);
        
        String userpathh = System.getProperty("user.home");
        String pao=projectRoot.toFile().toString();
        
        //Path sourcePath1 = Paths.get(userpathh + "/AppData/Roaming/resources/data/1.jpg");     // Source file path
        //Path targetPath1 = Paths.get(pao+"\\"+"1.jpg");     // Destination path
        
        //Path sourcePath2 = Paths.get(userpathh + "/AppData/Roaming/resources/data/1.mp3");     // Source file path
        //Path targetPath2 = Paths.get(pao+"\\"+"1.mp3");     // Destination path
        
       // Path sourcePath3 = Paths.get(userpathh + "/AppData/Roaming/resources/data/1.pdf");     // Source file path
       // Path targetPath3 = Paths.get(pao+"\\"+"1.pdf");     // Destination path

//        try {
//            Files.copy(sourcePath1, targetPath1, StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(sourcePath2, targetPath2, StandardCopyOption.REPLACE_EXISTING);
//          //  Files.copy(sourcePath3, targetPath3, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        
                      try {
    refreshProjectTree();
} catch (IOException e) {
    e.printStackTrace();
}

        
                    
                } catch (IOException ex) {
                    showAlert("Error", "Failed to create project: " + ex.getMessage());
                }
            });
        }
          
      //Load here 
      
	  
           
      }
	  
      else if (option.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled.");
      noti.position(Pos.CENTER);
      noti.showInformation();
      }
      else {}  
      
      
      
      
      }


	  
      else {
	  
      codeArea.clear();
	codee.getEngine().loadContent("");
      
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select Location to Create Project");
        Path selectedDir = Optional.ofNullable(chooser.showDialog(null))
                .map(File::toPath)
                .orElse(null);
        if (selectedDir != null) {
            TextInputDialog dialog = new TextInputDialog("NewBlankHtmlProject");
            dialog.setTitle("Project Name");
            dialog.setHeaderText("Enter project name:");
            DialogPane dialogPaneu = dialog.getDialogPane();
            dialogPaneu.getStylesheets().add(
            getClass().getResource(app_theme).toExternalForm());
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(name -> {
                try {
                    projectRoot = selectedDir.resolve(name);
                    Files.createDirectories(projectRoot);
                    
                    Files.write(projectRoot.resolve("index.html"),
    ("<!DOCTYPE html>\n" +
"<html lang=\"en\" dir=\"ltr\">\n" +
"<head>\n" +
"  <meta charset=\"UTF-8\">\n" +
"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"  <title>Blank HTML Project</title>\n" +
"  <link rel=\"stylesheet\" href=\"style.css\">\n" +
"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css\">\n" +
"</head>\n" +
"<body>\n" +
"\n" +
"\n" +
"\n" +
"  <script src=\"script.js\"></script>\n" +
"</body>\n" +
"</html>").getBytes(StandardCharsets.UTF_8)
);

                    
                    
                    Files.write(projectRoot.resolve("style.css"),
    ("/* Global Styles */\n"
    ).getBytes(StandardCharsets.UTF_8)
);

                    
                    Files.write(projectRoot.resolve("script.js"),
    ("// Theme Toggle\n"
    ).getBytes(StandardCharsets.UTF_8)
);

                    
                  //  refreshProjectTree();
                    
      
        SplitPane splitPane = new SplitPane();
        codeArea.setWrapText(true);
        scpane=new ScrollPane();
        scpane.setFitToHeight(true);
        scpane.setFitToWidth(true);
        scpane.getStylesheets().add(this.getClass().getResource(codearea_syntax).toExternalForm());
        scpane.getStylesheets().add(this.getClass().getResource(app_theme).toExternalForm());
        scpane.setContent(new VirtualizedScrollPane(this.codeArea));
        scpane1=new ScrollPane();
        scpane1.setFitToHeight(true);
        scpane1.setFitToWidth(true);
        scpane1.setContent(projectTree);
        scpane2=new ScrollPane();
        scpane2.setFitToHeight(true);
        //scpane2.setFitToWidth(true);
        scpane2.setContent(codee);
        splitPane.getItems().addAll(scpane1, scpane,scpane2);
        splitPane.setDividerPositions(0.2, 0.8);
        root.setCenter(splitPane);
        tabpane.setVisible(false);
        
        
        codeArea.setDisable(false);
        codee.setDisable(false);
        newhtml.setDisable(true);
        
        String userpathh = System.getProperty("user.home");
        String pao=projectRoot.toFile().toString();
        
        //Path sourcePath1 = Paths.get(userpathh + "/AppData/Roaming/resources/data/1.jpg");     // Source file path
        //Path targetPath1 = Paths.get(pao+"\\"+"1.jpg");     // Destination path
        
        //Path sourcePath2 = Paths.get(userpathh + "/AppData/Roaming/resources/data/1.mp3");     // Source file path
        //Path targetPath2 = Paths.get(pao+"\\"+"1.mp3");     // Destination path
        
      //  Path sourcePath3 = Paths.get(userpathh + "/AppData/Roaming/resources/data/1.pdf");     // Source file path
      //  Path targetPath3 = Paths.get(pao+"\\"+"1.pdf");     // Destination path

//        try {
//            //Files.copy(sourcePath1, targetPath1, StandardCopyOption.REPLACE_EXISTING);
//            //Files.copy(sourcePath2, targetPath2, StandardCopyOption.REPLACE_EXISTING);
//        //    Files.copy(sourcePath3, targetPath3, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        
                      try {
    refreshProjectTree();
} catch (IOException e) {
    e.printStackTrace();
}

                    
                } catch (IOException ex) {
                    showAlert("Error", "Failed to create project: " + ex.getMessage());
                }
            });
        }
          
      //Load here 
      newhtml.setDisable(true);
     openf.setDisable(true);
    }
      
      codeArea.setDisable(true);
      
      
          
      }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}