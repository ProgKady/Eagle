package eagle;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProEditorFX extends Application {
    @Override
    public void start(Stage primaryStage) {
        ProfessionalCodeEditor editor = new ProfessionalCodeEditor();
        editor.getCodeArea().replaceText(
            "public class Main {\n" +
            "    public static void main(String[] args) {\n" +
            "        System.out.println(\"Hello, IntelliJ style!\");\n" +
            "    }\n" +
            "}\n"
        );
        Scene scene = new Scene(editor, 850, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ProEditorFX");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
