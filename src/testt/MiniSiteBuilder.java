package testt;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Simple Mini "Mobirise-like" builder MVP
 * - Palette with draggable blocks
 * - Canvas (VBox) accepts drops and keeps BlockItem nodes
 * - Preview -> generate simple HTML string and show in WebView
 * - Export -> save index.html
 */
public class MiniSiteBuilder extends Application {

    // model for block instances
    static class Block {
        String id;          // unique type id e.g. "hero", "text"
        String title;       // label
        String html;        // html fragment template
        String content;     // current content (editable)
        Block(String id, String title, String html) {
            this.id = id; this.title = title; this.html = html;
            this.content = ""; // default editable content
        }

        String renderHtml() {
            // simple placeholder replacement
            return html.replace("{{content}}", escapeHtml(content.isEmpty() ? title : content));
        }

        private String escapeHtml(String s) {
            // minimal escape
            return s.replace("&","&amp;").replace("<","&lt;").replace(">","&gt;");
        }
    }

    private final VBox canvas = new VBox(10);
    private final List<Block> canvasBlocks = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Mini Site Builder (JavaFX MVP)");

        // -- Palette (left)
        VBox palette = new VBox(10);
        palette.setPadding(new Insets(10));
        palette.setStyle("-fx-background-color:#f4f6f8;");
        palette.setPrefWidth(220);
        palette.getChildren().add(new Label("Blocks"));

        // define some blocks (in real app load from resources/templates/*.html)
        Block heroBlock = new Block("hero","Hero Section",
                "<section style='padding:60px;background:#4C9AFF;color:white;text-align:center'>" +
                "<h1>{{content}}</h1><p>Hero subtitle</p></section>");
        Block textBlock = new Block("text","Text Section",
                "<section style='padding:30px'><div class='container'><p>{{content}}</p></div></section>");
        Block imageBlock = new Block("image","Image Section",
                "<section style='padding:30px;text-align:center'><img src='assets/sample.jpg' alt='' style='max-width:90%'/><p>{{content}}</p></section>");
        Block twoCol = new Block("two","Two Columns",
                "<section style='padding:30px'><div style='display:flex;gap:16px'><div style='flex:1;padding:8px;background:#fff'>{{content}}</div><div style='flex:1;padding:8px;background:#fafafa'>Right column</div></div></section>");
        List<Block> paletteBlocks = Arrays.asList(heroBlock, textBlock, imageBlock, twoCol);


        // create draggable items in palette
        for (Block b : paletteBlocks) {
            Label item = new Label(b.title);
            item.setPadding(new Insets(8));
            item.setStyle("-fx-background-color:white; -fx-border-color:#ddd; -fx-border-radius:6; -fx-background-radius:6;");
            item.setUserData(b);
            // start drag
            item.setOnDragDetected(ev -> {
                Dragboard db = item.startDragAndDrop(TransferMode.COPY);
                ClipboardContent cc = new ClipboardContent();
                cc.putString(b.id);
                db.setContent(cc);
                ev.consume();
            });
            palette.getChildren().add(item);
        }

        // -- Canvas (center)
        canvas.setPadding(new Insets(10));
        canvas.setStyle("-fx-background-color: white; -fx-border-color:#ddd;");
        canvas.setPrefWidth(520);

        Label canvasLabel = new Label("Canvas (drop blocks here)");
        canvasLabel.setStyle("-fx-font-weight:bold");
        canvas.getChildren().add(canvasLabel);

        // accept drops
        canvas.setOnDragOver(ev -> {
            if (ev.getGestureSource() != canvas && ev.getDragboard().hasString()) {
                ev.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            ev.consume();
        });

        canvas.setOnDragDropped(ev -> {
            Dragboard db = ev.getDragboard();
            boolean success = false;
            if (db.hasString()) {
                String blockId = db.getString();
                // find block by id from palette
                paletteBlocks.stream().filter(bb -> bb.id.equals(blockId)).findFirst().ifPresent(bb -> {
                    addBlockToCanvas(bb);
                });
                success = true;
            }
            ev.setDropCompleted(success);
            ev.consume();
        });

        // allow re-order by drag within canvas (simple approach)
        canvas.setOnDragDetected(ev -> {
            // not implemented re-order here (for MVP). Later: use setOnDragDropped for nodes.
        });

        // right panel: inspector + preview + export
        VBox right = new VBox(10);
        right.setPadding(new Insets(10));
        right.setPrefWidth(360);

        Button previewBtn = new Button("Preview");
        Button exportBtn = new Button("Export HTML");
        right.getChildren().addAll(previewBtn, exportBtn);

        // preview window (WebView)
        WebView webView = new WebView();
        webView.setPrefSize(320, 480);

        right.getChildren().add(webView);

        // Preview action
        previewBtn.setOnAction(e -> {
            String html = generateFullHtml();
            webView.getEngine().loadContent(html);
        });

        // Export action
        exportBtn.setOnAction(e -> {
            FileChooser chooser = new FileChooser();
            chooser.setInitialFileName("index.html");
            File file = chooser.showSaveDialog(primaryStage);
            if (file != null) {
                try (Writer w = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
                    w.write(generateFullHtml());
                    showAlert("Exported", "Saved to: " + file.getAbsolutePath());
                } catch (IOException ex) {
                    ex.printStackTrace();
                    showAlert("Error", "Failed to save: " + ex.getMessage());
                }
            }
        });

        // layout
        HBox root = new HBox(palette, canvas, right);
        Scene scene = new Scene(root, 1200, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addBlockToCanvas(Block template) {
        // create a new block instance (copy)
        Block instance = new Block(template.id, template.title, template.html);
        instance.content = template.title + " (edit...)";

        // visual representation on canvas
        HBox card = new HBox();
        card.setPadding(new Insets(10));
        card.setSpacing(10);
        card.setAlignment(Pos.CENTER_LEFT);
        card.setStyle("-fx-border-color:#e0e0e0; -fx-background-color:#fafafa; -fx-border-radius:6; -fx-background-radius:6;");
        Label title = new Label(instance.title);
        title.setStyle("-fx-font-weight:bold");
        TextField edit = new TextField(instance.content);
        edit.setPrefWidth(300);
        edit.textProperty().addListener((obs, o, n) -> instance.content = n);

        Button remove = new Button("Remove");
        remove.setOnAction(ev -> {
            canvas.getChildren().remove(card);
            canvasBlocks.remove(instance);
        });

        card.getChildren().addAll(title, edit, remove);
        canvas.getChildren().add(card);
        canvasBlocks.add(instance);
    }

    private String generateFullHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!doctype html>\n<html lang='en'>\n<head>\n<meta charset='utf-8'/>\n<meta name='viewport' content='width=device-width,initial-scale=1' />\n<title>Exported Site</title>\n<link rel='stylesheet' href='styles.css'>\n</head>\n<body style='font-family:Arial,Helvetica,sans-serif'>\n");
        for (Block b : canvasBlocks) {
            sb.append(b.renderHtml()).append("\n");
        }
        sb.append("\n</body>\n</html>");
        return sb.toString();
    }

    private void showAlert(String title, String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK);
        a.setHeaderText(null);
        a.setTitle(title);
        a.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
