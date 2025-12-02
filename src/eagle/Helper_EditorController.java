
package eagle;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class Helper_EditorController implements Initializable {

  
    @FXML
    private WebView code;

    @FXML
    private WebView view;

   
    
    
    
    @FXML
    void codekeyaction(KeyEvent event) {

       WebEngine eng = code.getEngine();
            Object result = eng.executeScript("editor.getValue()");
            if (result != null) {
                String htmlCode = result.toString();
                if (htmlCode.contains("<")&&htmlCode.contains("</")&&htmlCode.contains(">")) {
                view.getEngine().loadContent(htmlCode);
                }
                else {view.getEngine().loadContent("");}
            }
        
    }

    
    
    @FXML
    void codemouseaction(MouseEvent event) {
        
            WebEngine eng = code.getEngine();
            Object result = eng.executeScript("editor.getValue()");
            if (result != null) {
                String htmlCode = result.toString();
                if (htmlCode.contains("<")&&htmlCode.contains("</")&&htmlCode.contains(">")) {
                view.getEngine().loadContent(htmlCode);
                }
                else {view.getEngine().loadContent("");}
            }
        
        
    }

    
    
  
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        //Load here editor
        code.setContextMenuEnabled(false);  
        
        try {
            String userpathh = System.getProperty("user.home");
            File filor = new File (userpathh + "/AppData/Roaming/resources/data/ace/index.html");
            URL urly = filor.toURI().toURL();
            String finalUrl = urly.toString() + "?t=" + System.currentTimeMillis();
            code.getEngine().setJavaScriptEnabled(true);   
            code.getEngine().reload();
            code.getEngine().load(finalUrl);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Helper_EditorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        ContextMenu sds=new ContextMenu();
        WebEngine engine = code.getEngine();
        
        MenuItem hta = new MenuItem("HTML Editor");
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
        
        MenuItem csa = new MenuItem("CSS Editor");
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
        
        MenuItem jsa = new MenuItem("JavaScript Editor");
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
        
        
       sds.getItems().addAll(hta,csa,jsa);
       
        
        // Show custom menu on right-click
        code.setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                sds.show(code, event.getScreenX(), event.getScreenY());
            } else {
                sds.hide();
            }
        });
       
       
        
        
    }    
    
}
