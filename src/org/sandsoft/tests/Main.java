
package org.sandsoft.tests;

import eagle.CreateJsProjectController;
import org.sandsoft.acefx.AceEditor;
import org.sandsoft.acefx.Modes;
import org.sandsoft.acefx.Themes;
import org.sandsoft.acefx.AceEvents;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Sudipto Chandra
 */
public class Main extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        final AceEditor ace = AceEditor.createNew();
        
//        root.setTop(button1);
//        root.setBottom(button2);

        Scene scene = new Scene(ace, 1270, 920);
        primaryStage.setTitle("JavaScript Editor");
        primaryStage.setScene(scene);
        primaryStage.show();

        ace.addEventHandler(AceEvents.onLoadEvent, new EventHandler<Event>() {
            @Override
            public void handle(Event t) {
                ace.getEditor().setFontSize(16);
                ace.setTheme(Themes.Chrome);
                ace.setMode(Modes.JavaScript);
               
//AceEditor.labelset();


//                ace.setText(Tester.ThemeListGenerator());
                ace.setText(Tester.ModeListGenerator());
//                ace.setText(Tester.MapObject(ace.getThemeData()));  

            }
            
        });  

    }
}
