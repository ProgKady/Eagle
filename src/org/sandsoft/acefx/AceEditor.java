
package org.sandsoft.acefx;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import eagle.CreateJsProjectController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.sandsoft.acefx.model.Command;
import org.sandsoft.acefx.model.Editor;
import org.sandsoft.acefx.model.UndoManager;
import org.sandsoft.acefx.model.EditSession;
import org.sandsoft.acefx.model.ThemeData;
import org.sandsoft.acefx.util.Commons;
import org.apache.commons.io.FileUtils;
import org.sandsoft.acefx.model.ModeData;



public final class AceEditor extends BorderPane {

    //where ace.js file is saved
    private static final String ACE_PATH = "ace/ace.js";

    //ace controller
    private JSObject mAce;
    //current editor
    private Editor mEditor;
    //file path to save code
    private File mFilePath;

    //web view where editor is loaded
    @FXML
    private WebView webView;
    //web engine to process java script
    private WebEngine mWebEngine;

    @FXML
    private ComboBox themeListBox;
    @FXML
    private ComboBox modeListBox;
    @FXML
    private Button undoButton;
    @FXML
    private Button redoButton;
    @FXML
    private JFXTextArea area;
    
    @FXML
    private JFXButton reed;
    
    
    /**
     * Constructor
     */
    public AceEditor() {
        
    }
    
    

    /**
     * Creates a new instance of the ace editor.
     *
     * @return
     * @throws java.io.IOException
     */
    public static AceEditor createNew() throws IOException {
        //init loader           
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AceEditor.class.getResource(
                AceEditor.class.getSimpleName() + ".fxml"));

        //attach node
        Node node = (Node) loader.load();
        BorderPane.setAlignment(node, Pos.CENTER);
        AceEditor ace = (AceEditor) loader.getController();
        ace.setCenter(node);
        ace.setMinSize(0, 0);
        ace.setPrefSize(1270, 920);
        ace.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        //post load work  
        ace.initialize();

        return ace;
    }

    /**
     * Initializes view and controls after FXML is loaded.
     */
    public void initialize() {
        //setup view   
        webView.setContextMenuEnabled(true);
        mWebEngine = webView.getEngine();
        
        loadAceEditor();
        loadModeList();
        loadThemeList();

        // process page loading
        mWebEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> ov, Worker.State t, Worker.State t1) {
                if (mWebEngine.getLoadWorker().getState() == Worker.State.SUCCEEDED) {
                    //extract javascript objects
                    mAce = (JSObject) mWebEngine.executeScript("ace");
                    JSObject editor = (JSObject) mAce.call("edit", "editor");
                    mEditor = new Editor(editor);

                    setEventCatchers(editor);
                    setTheme(Themes.Solarized_Dark);
                    setMode(Modes.JavaScript);
                   // fireEvent(new Event(AceEvents.onLoadEvent));
//getEditor().setValue("/*\n* Author: Kadysoft by Ahmed Elkady\n*/\n\n//Called when application is started.\n\nfunction OnStart() {\n\n//Create a layout with objects vertically centered.\n\nlay = app.CreateLayout( \"linear\", \"VCenter,FillXY\" );\n\n//Create a text label and add it to layout.\n\ntxt = app.CreateText( \"Hello Eagle\" );\ntxt.SetTextSize( 32 );\nlay.AddChild( txt );\n\n//Add layout to app.\n\napp.AddLayout( lay );\n\n}", 1);
    
                    fireEvent(new Event(AceEvents.onLoadEvent));
                }
            }
        });
    }

    /**
     * Loads the ACE editor in the web engine.
     */
   private void loadAceEditor() {
    // Get ace.js and language_tools.js path from resources
    String acePath = getClass().getResource("ace/ace.js").toExternalForm();
    String langToolsPath = getClass().getResource("ace/ext-language_tools.js").toExternalForm();

    // Build the HTML content as a single string
    String html =
            "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "  <meta charset=\"UTF-8\">\n" +
            "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n" +
            "  <title>ACE Editor with Autocomplete</title>\n" +
            "  <style type=\"text/css\" media=\"screen\">\n" +
            "    body {\n" +
            "        overflow: hidden;\n" +
            "    }\n" +
            "    #editor {\n" +
            "        margin: 0;\n" +
            "        position: absolute;\n" +
            "        top: 0;\n" +
            "        bottom: 0;\n" +
            "        left: 0;\n" +
            "        right: 0;\n" +
            "    }\n" +
            "  </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "<pre id=\"editor\">// Type your JavaScript here</pre>\n" +
            "<script src=\"" + acePath + "\" type=\"text/javascript\" charset=\"utf-8\"></script>\n" +
            "<script src=\"" + langToolsPath + "\" type=\"text/javascript\" charset=\"utf-8\"></script>\n" +
            "<script>\n" +
            "    var editor = ace.edit(\"editor\");\n" +
            "    editor.setTheme(\"ace/theme/solarized_dark\");\n" +
            "    editor.getSession().setMode(\"ace/mode/javascript\");\n" +
            "\n" +
            "    ace.require(\"ace/ext/language_tools\");\n" +
            "    editor.setOptions({\n" +
            "        enableBasicAutocompletion: true,\n" +
            "        enableLiveAutocompletion: true,\n" +
            "        enableSnippets: true,\n" +
            "        fontSize: \"14px\"\n" +
            "    });\n" +
            "\n" +
            "    var customCompleter = {\n" +
            "        getCompletions: function(editor, session, pos, prefix, callback) {\n" +
            "            if (prefix.length === 0) { callback(null, []); return; }\n" +
            "            callback(null, [\n" +
            "                {name: \"console.log\", value: \"console.log()\", score: 1000, meta: \"custom\"},\n" +
            "                {name: \"function\", value: \"function ${1:name}() {\\n\\t$0\\n}\", score: 900, meta: \"snippet\"}\n" +
            "            ]);\n" +
            "        }\n" +
            "    };\n" +
            "    editor.completers = [customCompleter, ace.require(\"ace/ext/language_tools\").textCompleter];\n" +
            "</script>\n" +
            "</body>\n" +
            "</html>";

    // Load the HTML into the WebEngine
    mWebEngine.loadContent(html);
}


    /**
     * Creates event listener. <br/>
     * This uses the 'upcall' feature from java-script to java.
     *
     * @param editor
     */
    private void setEventCatchers(JSObject editor) {
        //set interface object
        editor.setMember("mAceEvent", new AceEvents(this));

        //on editor events
        editor.eval("this.on('blur', function() { editor.mAceEvent.onBlur(); });");
        editor.eval("this.on('change', function(e) { editor.mAceEvent.onChange(e); });");
        editor.eval("this.on('changeSelectionStyle', function(e) { editor.mAceEvent.onChangeSelectionStyle(e); });");
        editor.eval("this.on('changeSession', function(e) { editor.mAceEvent.onChangeSession(e); });");
        editor.eval("this.on('copy', function(e) { editor.mAceEvent.onCopy(e); });");
        editor.eval("this.on('focus', function() { editor.mAceEvent.onFocus(); });");
        editor.eval("this.on('paste', function(e) { editor.mAceEvent.onPaste(e); });");

        //on edit session events
        editor.eval("this.getSession().on('changeAnnotation', function() { editor.mAceEvent.onChangAnnotation(); });");
        editor.eval("this.getSession().on('changeBackMarker', function() { editor.mAceEvent.onChangeBackMarker(); });");
        editor.eval("this.getSession().on('changeBreakpoint', function() { editor.mAceEvent.onChangeBreakpoint(); });");
        editor.eval("this.getSession().on('changeFold', function() { editor.mAceEvent.onChangeFold(); });");
        editor.eval("this.getSession().on('changeFrontMarker', function() { editor.mAceEvent.onChangeFrontMarker(); });");
        editor.eval("this.getSession().on('changeMode', function() { editor.mAceEvent.onChangeMode(); });");
        editor.eval("this.getSession().on('changeOverwrite', function() { editor.mAceEvent.onChangeOverwrite(); });");
        editor.eval("this.getSession().on('changeScrollLeft', function(e) { editor.mAceEvent.onChangeScrollLeft(e); });");
        editor.eval("this.getSession().on('changeScrollTop', function(e) { editor.mAceEvent.onChangeScrollTop(e); });");
        editor.eval("this.getSession().on('changeTabSize', function() { editor.mAceEvent.onChangeTabSize(); });");
        editor.eval("this.getSession().on('changeWrapLimit', function() { editor.mAceEvent.onChangeWrapLimit(); });");
        editor.eval("this.getSession().on('changeWrapMode', function() { editor.mAceEvent.onChangeWrapMode(); });");
        editor.eval("this.getSession().on('tokenizerUpdate', function(e) { editor.mAceEvent.onTokenizerUpadate(e); });");

        addEventHandler(AceEvents.onChangeEvent, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                undoButton.setDisable(!getUndoManager().hasUndo());
                redoButton.setDisable(!getUndoManager().hasRedo());
            }
        });
    }

    /**
     * Executes a script on the current web engine.
     *
     * @param script Script to execute.
     * @return
     */
    public Object executeScript(String script) throws JSException {
        return mWebEngine.executeScript(script);
    }

    /**
     * Gets the wrapper class for editor that is associated with this control.
     * It contains various methods to interact with the editor.
     *
     * @return the editor attached to this control.
     */
    public Editor getEditor() {
        return mEditor;
    }

    /**
     * Gets the wrapper class for edit session that is associated with the
     * editor. It contains various methods to interact with the document under
     * edit.
     *
     * @return the edit session for the editor.
     */
    public EditSession getSession() {
        return mEditor.getSession();
    }

    /**
     * Gets the wrapper class for undo manger that is associated with the
     * editor. It contains methods for undo or redo operations.
     *
     * @return the undo manager for the edit session.
     */
    public UndoManager getUndoManager() {
        return getSession().getUndoManager();
    }

    /**
     * Gets the current content from the editor. If the editor is not ready an
     * empty text is returned.
     *
     * @return Current content in the editor.
     */
    public String getText() {
        return mEditor.getValue();

    }

    /**
     * Sets the given content to the editor.
     *
     * @param text the content to display.
     */
    public void setText(String text) {
        getEditor().setValue("/*\n* Author: Kadysoft by Ahmed Elkady\n*/\n\n//Called when application is started.\n\nfunction OnStart() {\n\n//Create a layout with objects vertically centered.\n\nlay = app.CreateLayout( \"linear\", \"VCenter,FillXY\" );\n\n//Create a text label and add it to layout.\n\ntxt = app.CreateText( \"Hello Eagle\" );\ntxt.SetTextSize( 32 );\nlay.AddChild( txt );\n\n//Add layout to app.\n\napp.AddLayout( lay );\n\n}", 1);
  }

    /**
     * Reloads the whole editor in WebView.
     */
    public void doReload() {
        loadAceEditor();
    }

    /**
     * Performs an undo operation. Reverts the changes.
     */
    public void doUndo() {
        getEditor().undo();
        undoButton.setDisable(!getUndoManager().hasUndo());
        redoButton.setDisable(!getUndoManager().hasRedo());
    }

    /**
     * Performs an redo operation. Re-implements the changes.
     */
    public void doRedo() {
        getEditor().redo();
        undoButton.setDisable(!getUndoManager().hasUndo());
        redoButton.setDisable(!getUndoManager().hasRedo());
    }

    /**
     * Paste text from clipboard after the cursor.
     */
    public void doPaste() {
        getEditor().insert(Clipboard.getSystemClipboard().getString());
    }

    /**
     * Copies the selected text to clipboard.
     *
     * @return True if performed successfully.
     */
    public boolean doCopy() {
        String copy = mEditor.getCopyText();
        if (copy != null && !copy.isEmpty()) {
            ClipboardContent content = new ClipboardContent();
            content.putString(copy);
            Clipboard.getSystemClipboard().setContent(content);
            return true;
        }
        return false;
    }

    /**
     * Removes the selected text and copy it to clipboard.
     */
    public void doCut() {
        if (doCopy()) {
            getEditor().insert("");
        }
    }

    /**
     * Shows the find dialog.
     */
    public void showFind() {
        getEditor().execCommand("find");
    }

    /**
     * Shows the replace dialog.
     */
    public void showReplace() {
        getEditor().execCommand("replace");
        
    }

    /**
     * Shows the options pane.
     */
    public void showOptions() {
        getEditor().execCommand("showSettingsMenu");
    }

    /**
     * Loads a content from a file.
     *
     * @param file File path to load.
     * @throws java.io.FileNotFoundException thrown if file could not be found.
     * @throws java.io.IOException thrown if file could no be read.
     */
    public void openFile(File file) throws FileNotFoundException, IOException {
        mFilePath = file;
     //   setText(FileUtils.readFileToString(file));
        setMode(Modes.getModeFromFile(file.getName()));
        //getUndoManager().reset(); 
        undoButton.setDisable(true);
        redoButton.setDisable(true);
    }

    /**
     * Saves the previously opened file.
     *
     * @throws java.io.IOException thrown if file could no be read.
     */
    public void saveFile() throws IOException, NullPointerException {
   //     FileUtils.writeStringToFile(mFilePath, getText());
    }

    /**
     * Change or set new save location and saves the file.
     *
     * @param file new location to save.
     * @throws java.io.IOException thrown if file could no be read.
     */
    public void saveAs(File file) throws IOException, NullPointerException {
        mFilePath = file;
        saveFile();
        setMode(Modes.getModeFromFile(file.getName()));
    }

    /**
     * Select the syntax highlighting mode for ace-editor. Some pre-defined
     * supported mode can be found in <code>Modes</code> class.
     *
     * @see Modes
     * @param mode Mode like "ace/mode/java".
     */
    public void setMode(ModeData mode) {
        modeListBox.getSelectionModel().select(mode);
    }

    /**
     * Currently enabled language mode.
     *
     * @see EditSession.getMode()
     * @return the current mode.
     */
    public ModeData getMode() {
        return Modes.getModeByAlias(getSession().getMode());
    }

    /**
     * Sets a theme to the editor. Some pre-defined can be found in
     * <code>Themes</code> class.
     *
     * @see Themes
     * @param theme Theme to set (must contain valid alias).
     */
    public void setTheme(ThemeData theme) {
        themeListBox.getSelectionModel().select(theme);
    }

    /**
     * Gets the current theme.
     *
     * @return
     */
    public ThemeData getTheme() {
        return Themes.getThemeByAlias(getEditor().getTheme());
    }

    /**
     * Gets a list of all available command and keyboard shortcuts
     *
     * @deprecated for internal usage only.
     * @return list of available commands
     */
    @Deprecated
    public ArrayList<Command> getCommandList() {
        JSObject names = (JSObject) mEditor.getModel().eval("this.commands.byName");
        ArrayList<Command> arr = new ArrayList<>();
        for (String str : Commons.getAllProperties(names)) {
            arr.add(new Command((JSObject) names.getMember(str)));
        }
        return arr;
    }

    //loads the list of themes in the themeListBox combobox in toolbar
    private void loadThemeList() {
        themeListBox.setItems(FXCollections.observableArrayList(Themes.SUPPORTED_THEMES));
        themeListBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null && oldValue != newValue) {
                    Object data = themeListBox.getSelectionModel().getSelectedItem();
                    getEditor().setTheme(((ThemeData) data).getAlias());
                }
            }
        });
    }

    //loads the list of modes in the modeListBox combobox in toolbar
    private void loadModeList() {
        modeListBox.setItems(FXCollections.observableArrayList(Modes.SUPPORTED_MODES));
        modeListBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null && oldValue != newValue) {
                    Object data = modeListBox.getSelectionModel().getSelectedItem();
                    getEditor().getSession().setMode(((ModeData) data).getAlias());
                }
            }
        });
    }

    //load file extension filters
    private void attachFilters(FileChooser fileChooser) {
        FileChooser.ExtensionFilter def
                = new FileChooser.ExtensionFilter("All Files", "*.*");
        fileChooser.getExtensionFilters().add(def);
        fileChooser.setSelectedExtensionFilter(def);
        for (ModeData md : Modes.SUPPORTED_MODES) {
            fileChooser.getExtensionFilters().add(md.getExtensionFilter());
        }
    }
    @FXML
    private void sample() {
     Stage   sttg = new Stage();
                   String  userpath = System.getProperty("user.home");
                  String   html = userpath + "/AppData/Roaming/resources/data/docs/Docs.htm";
                  URI   uri = Paths.get(html).toAbsolutePath().toUri();
                   WebView  root = new WebView();
                     root.getEngine().load(uri.toString());
                     sttg.setTitle("Samples");
                     sttg.setScene(new Scene(root, 1024.0D, 670.0D));
                     sttg.centerOnScreen();
                     sttg.setResizable(false);
                     sttg.show();
    }

    //toolbar buttons on action
    
    
    @FXML
private void openButtonOnAction() throws InterruptedException {
    
    String valll=mEditor.getValue().toString();
    
    if (valll.isEmpty()) {
    
    
        
        area.setText("");
        
        FileChooser fcho = new FileChooser();
        fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("JavaScript Files", "*.js"));
        fcho.setTitle("Kady Choose");
        File f = fcho.showOpenDialog(null);
        
        if (f == null) return; // user cancelled
        
        String dirpathe = f.getAbsolutePath();
        
        try (BufferedReader buff = new BufferedReader(new FileReader(dirpathe))) {
            String line;
            while ((line = buff.readLine()) != null) {
                area.appendText(line);
                area.appendText("\n");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AceEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AceEditor.class.getName()).log(Level.SEVERE, null, ex);
        }

        Thread.sleep(200);

        mEditor.setValue("", 1);
        String coo = area.getText();
        mEditor.setValue(coo, 1);
        area.setText("");
        
    }
    
    else {
    
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Eagle Dialog");
    alert.setHeaderText("Important!...");
    alert.setContentText("You will lose your code, Are you sure?\nContinue?");
    alert.setResizable(false);
    DialogPane dialogPane = alert.getDialogPane();
    dialogPane.getStylesheets().add(
        getClass().getResource("cupertino-light.css").toExternalForm()
    );
    
    Optional<ButtonType> result = alert.showAndWait();
    
    if (result.isPresent() && result.get() == ButtonType.OK) {
        
        
        
        area.setText("");
        
        FileChooser fcho = new FileChooser();
        fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("JavaScript Files", "*.js"));
        fcho.setTitle("Kady Choose");
        File f = fcho.showOpenDialog(null);
        
        if (f == null) return; // user cancelled
        
        String dirpathe = f.getAbsolutePath();
        
        try (BufferedReader buff = new BufferedReader(new FileReader(dirpathe))) {
            String line;
            while ((line = buff.readLine()) != null) {
                area.appendText(line);
                area.appendText("\n");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AceEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AceEditor.class.getName()).log(Level.SEVERE, null, ex);
        }

        Thread.sleep(200);

        mEditor.setValue("", 1);
        String coo = area.getText();
        mEditor.setValue(coo, 1);
        area.setText("");
    } else {
        // User canceled
    }
    
    }
    
    
}

    
    
    
    @FXML
    void reedaction(ActionEvent event) {

       mEditor.setValue("", 1);
       String coo=area.getText();
       mEditor.setValue(coo, 1);
       area.setText("");
        
    }
    
    
  

    @FXML
    private void saveButtonOnAction() {
       /* try {
            if (mFilePath != null) {
                saveFile();
                return;
            }
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save file");
            attachFilters(fileChooser);
            File file = fileChooser.showSaveDialog(this.getScene().getWindow());
            if (file != null) {
                saveAs(file);
            }
        } catch (IOException | NullPointerException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
*/
       
       
       
      FileChooser dcho = new FileChooser();
      dcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("JavaScript Files", new String[]{"*.js"}));
      dcho.setInitialDirectory(new File(System.getProperty("user.home") + "/desktop"));
      dcho.setTitle("Kady Directory");
      File f = dcho.showSaveDialog((Window)null);
      String dirpath = f.getAbsolutePath().toString();
      
      File dirr=new File (dirpath);
        try {
            dirr.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(AceEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        String codee=mEditor.getValue();
        
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(dirr));
            pw.println();
            pw.print(codee);
            pw.close();
         } catch (IOException var4) {
           // Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, (String)null, var4);
         }
       
       //System.out.println(dirpath);
     //  mEditor.setValue("hiii", 5);
       
    }
    
    

    @FXML
    private void reloadButtonOnAction() {
        doReload();
    }

    @FXML
    private void cutButtonOnAction() {
        doCut();
    }

    @FXML
    private void copyButtonOnAction() {
        doCopy();
    }

    @FXML
    private void pasteButtonOnAction() {
        doPaste();
    }

    @FXML
    private void undoButtonOnAction() {
        doUndo();
    }

    @FXML
    private void redoButtonOnAction() {
        doRedo();
    }

    @FXML
    private void findButtonOnAction() {
        showFind();
    }

    @FXML
    private void replaceButtonOnAction() {
        showReplace();
    }

    @FXML
    private void optionsButtonOnAction() {
        showOptions();
    }

}
