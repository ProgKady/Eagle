package eagle;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CaretNode;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;
import org.reactfx.Subscription;

public class JsEditor {
   static CodeArea codeArea;
   static Pattern PATTERN;
   static ExecutorService executor;

   public final void js_Editor() {
      Stage stage = new Stage();
      
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
        "function", "Function", "app", "App", "asset", "bws", "cp", "dlg", "es6", "esp", 
        "ga", "gl", "gles", "lang", "nxt", "sql", "sw", "tabs", "term", "twn", 
        "for", "switch", "if", "else", "var", "util", "v8", "ws", "platform", "Platform", 
        "Navigator", "navigator", "window", "document", "cordova", "Box2d", "Flot", "Gfx", "JQuery", "Numeral", 
        "Pixi", "Pixi_old", "Tween", "package", "Package", "OnStart", "OnStop", "OnPause", "OnResume", "OnDestroy", 
        "elseif", "do", "while", "html", "body", "title", "head", "a", "abbr", "acronym", 
        "address", "applet", "area", "article", "style", "script", "meta", "aside", "audio", "b", 
        "base", "basefont", "bdi", "bdo", "big", "br", "blockquote", "button", "canvas", "DOCTYPE", 
        "caption", "center", "cite", "code", "col", "colgroup", "datalist", "dd", "del", "details", 
        "dfn", "dialog", "dir", "div", "dl", "dt", "em", "embed", "figcaption", "figure", 
        "font", "footer", "form", "frame", "frameset", "header", "hr", "i", "h1", "h2", 
        "h3", "h4", "h5", "h6", "iframe", "img", "input", "ins", "kbd", "keygen", 
        "label", "legeng", "li", "link", "marquee", "map", "mark", "menu", "menuitem", "meter", 
        "nav", "noframes", "noscript", "object", "ol", "optgroup", "option", "output", "p", "param", 
        "pre", "progress", "q", "rp", "tt", "ruby", "svg", "samp", "section", "select", 
        "small", "source", "span", "strike", "strong", "sub", "summary", "sup", "table", "tbody", 
        "td", "textarea", "tfoot", "th", "thead", "time", "tr", "track", "tt", "u", 
        "ul", "video", "wbr", "transform", "border", "background", "animation", "transition", "text", "console", 
        "math", "date", "Boolean", "cookie", "alert", "\"use strict\";" };
      
    String KEYWORD_PATTERN = "\\b(" + String.join("|", (CharSequence[])KEYWORDS) + ")\\b";
    String PAREN_PATTERN = "\\(|\\)";
    String BRACE_PATTERN = "\\{|\\}";
    String BRACKET_PATTERN = "\\[|\\]";
    String SEMICOLON_PATTERN = "\\;";
    String STRING_PATTERN = "\"([^\"\\\\]|\\\\.)*\"";
    String COMMENT_PATTERN = "//[^\n]*|/\\*(.|\\R)*?\\*/";
    PATTERN = Pattern.compile("(?<KEYWORD>" + KEYWORD_PATTERN + ")" + "|(?<PAREN>" + PAREN_PATTERN + ")" + "|(?<BRACE>" + BRACE_PATTERN + ")" + "|(?<BRACKET>" + BRACKET_PATTERN + ")" + "|(?<SEMICOLON>" + SEMICOLON_PATTERN + ")" + "|(?<STRING>" + STRING_PATTERN + ")" + "|(?<COMMENT>" + COMMENT_PATTERN + ")");
    
    String sampleCode = String.join("\n", (CharSequence[])new String[] { 
          "", "//Called when application is started.", "", "function OnStart()", "      {", "//Create a layout with objects vertically centered.", "", "lay = app.CreateLayout( \"linear\", \"VCenter,FillXY\" );", "", "//Create a text label and add it to layout.", 
          "txt = app.CreateText( \"Hello Eagle\" );", "txt.SetTextSize( 32 );", "lay.AddChild( txt );", "", "//Add layout to app.", "app.AddLayout( lay );", "", "        }", "" });
    
    
      MenuItem mi = new MenuItem("Save Me!");
      mi.setStyle("-fx-font-size:18");
      mi.setOnAction((nj) -> {
         String FullPathh = CreateJsProjectController.f1.toString();
         String codeee = codeArea.getText();

         try {
            PrintWriter pw = new PrintWriter(new FileWriter(FullPathh));
            pw.println();
            pw.print(codeee);
            pw.close();
         } catch (IOException var4) {
           // Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var4);
         }

      });
      ContextMenu conmenu = new ContextMenu();
      conmenu.getItems().addAll(new MenuItem[]{mi});
      codeArea = new CodeArea();
      
      codeArea.setContextMenu(conmenu);
      codeArea.setWrapText(true);
      IntFunction<Node> numberFactory = LineNumberFactory.get(codeArea);
    IntFunction<Node> arrowFactory = new ArrowFactory(codeArea.currentParagraphProperty());
    IntFunction graphicFactory = (line) -> {
         HBox hbox = new HBox(new Node[]{(Node)numberFactory.apply(line), (Node)arrowFactory.apply(line)});
         hbox.setAlignment(Pos.CENTER_LEFT);
         return hbox;
      };
    codeArea.setParagraphGraphicFactory(graphicFactory);
    codeArea.moveTo(0, 0);
    executor = Executors.newSingleThreadExecutor();
    codeArea.setMinSize(1024.0D, 600.0D);
    codeArea.setStyle("-fx-background-color:white;-fx-font-size:15;-fx-font-weight:bold;-fx-font-family:Monospaced;-fx-text-fill:white;");
    this.codeArea.setParagraphGraphicFactory(LineNumberFactory.get(this.codeArea));
    Subscription cleanupWhenDone = codeArea.multiPlainChanges().successionEnds(Duration.ofMillis(500L)).supplyTask(this::computeHighlightingAsync).awaitLatest(codeArea.multiPlainChanges()).filterMap(t -> {
          if (t.isSuccess())
            return Optional.of(t.get()); 
          t.getFailure().printStackTrace();
          return Optional.empty();
        }).subscribe(this::applyHighlighting);
    codeArea.replaceText(0, 0, sampleCode);
      codeArea.setOnKeyReleased((kkl) -> {
         String FullPathh = CreateJsProjectController.f1.toString();
         String codeee = codeArea.getText();

         try {
            PrintWriter pw = new PrintWriter(new FileWriter(FullPathh));
            pw.println();
            pw.print(codeee);
            pw.close();
         } catch (IOException var5) {
         //   Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var5);
         }

      });
      codeArea.setOnMouseClicked((lo) -> {
         String FullPathh = CreateJsProjectController.f1.toString();
         String codeee = codeArea.getText();

         try {
            PrintWriter pw = new PrintWriter(new FileWriter(FullPathh));
            pw.println();
            pw.print(codeee);
            pw.close();
         } catch (IOException var5) {
         //   Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var5);
         }

      });
      BorderPane root = new BorderPane();
      root.setCenter(new VirtualizedScrollPane(codeArea));
      Scene scene = new Scene(root, 1024.0D, 600.0D);
      scene.getStylesheets().add(this.getClass().getResource("java-keywords.css").toExternalForm());
      stage.setTitle("JS Editor");
      stage.setScene(scene);
      stage.showAndWait();
   }

   public void stop() {
    executor.shutdown();
  }
   
  private Task<StyleSpans<Collection<String>>> computeHighlightingAsync() {
    final String text = codeArea.getText();
    Task<StyleSpans<Collection<String>>> task = new Task<StyleSpans<Collection<String>>>() {
        protected StyleSpans<Collection<String>> call() throws Exception {
          return JsEditor.computeHighlighting(text);
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
}