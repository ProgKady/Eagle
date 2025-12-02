package eagle;

import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;

public class CodeEditor extends StackPane {
   final WebView webview = new WebView();
   private String editingCode;
   private final String editingTemplate = "<!doctype html><html><head>  <link rel=\"stylesheet\" href=\"http://codemirror.net/lib/codemirror.css\">  <script src=\"http://codemirror.net/lib/codemirror.js\"></script>  <script src=\"http://codemirror.net/mode/clike/clike.js\"></script></head><body><form><textarea id=\"code\" name=\"code\">\n${code}</textarea></form><script>  var editor = CodeMirror.fromTextArea(document.getElementById(\"code\"), {    lineNumbers: true,    matchBrackets: true,    mode: \"text/x-java\"  });</script></body></html>";

   private String applyEditingTemplate() {
      return "<!doctype html><html><head>  <link rel=\"stylesheet\" href=\"http://codemirror.net/lib/codemirror.css\">  <script src=\"http://codemirror.net/lib/codemirror.js\"></script>  <script src=\"http://codemirror.net/mode/clike/clike.js\"></script></head><body><form><textarea id=\"code\" name=\"code\">\n${code}</textarea></form><script>  var editor = CodeMirror.fromTextArea(document.getElementById(\"code\"), {    lineNumbers: true,    matchBrackets: true,    mode: \"text/x-java\"  });</script></body></html>".replace("${code}", this.editingCode);
   }

   public void setCode(String newCode) {
      this.editingCode = newCode;
      this.webview.getEngine().loadContent(this.applyEditingTemplate());
   }

   public String getCodeAndSnapshot() {
      this.editingCode = (String)this.webview.getEngine().executeScript("editor.getValue();");
      return this.editingCode;
   }

   public void revertEdits() {
      this.setCode(this.editingCode);
   }

   CodeEditor(String editingCode) {
      this.editingCode = editingCode;
      this.webview.setPrefSize(650.0D, 325.0D);
      this.webview.setMinSize(650.0D, 325.0D);
      this.webview.getEngine().loadContent(this.applyEditingTemplate());
      this.getChildren().add(this.webview);
   }
}
