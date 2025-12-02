package eagle;





import javafx.application.Application;
import javafx.beans.property.*;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FlutterUIDesigner extends Application {

    // Root model node for widget tree
    public static abstract class WidgetModel {
        private final StringProperty name = new SimpleStringProperty();
        private final ListProperty<WidgetModel> children = new SimpleListProperty<>(FXCollections.observableArrayList());
        private final ObjectProperty<WidgetModel> parent = new SimpleObjectProperty<>(null);

        public WidgetModel(String name) {
            this.name.set(name);
        }

        public StringProperty nameProperty() {
            return name;
        }

        public String getName() {
            return name.get();
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public ObservableList<WidgetModel> getChildren() {
            return children.get();
        }

        public ListProperty<WidgetModel> childrenProperty() {
            return children;
        }

        public void addChild(WidgetModel child) {
            child.parent.set(this);
            children.add(child);
        }

        public ObjectProperty<WidgetModel> parentProperty() {
            return parent;
        }

        public WidgetModel getParent() {
            return parent.get();
        }

        // Properties Map to store widget-specific properties
        protected final Map<String, Object> properties = new HashMap<>();

        public Map<String, Object> getProperties() {
            return properties;
        }

        public abstract String toFlutterCode(int indent);

        protected String indentStr(int indent) {
    return repeat("  ", indent);
}

private String repeat(String str, int times) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < times; i++) {
        sb.append(str);
    }
    return sb.toString();
}
        
    }

    // Container widget (like Flutter Container)
    public static class ContainerModel extends WidgetModel {
        public ContainerModel() {
            super("Container");
            // Default properties
            properties.put("color", "#FFFFFFFF"); // white color
            properties.put("width", 100.0);
            properties.put("height", 100.0);
            properties.put("padding", 8.0);
            properties.put("margin", 8.0);
        }

        @Override
        public String toFlutterCode(int indent) {
            String indentS = indentStr(indent);
            StringBuilder sb = new StringBuilder();
            sb.append(indentS).append("Container(\n");

            // Color property
            String color = (String) properties.getOrDefault("color", "#FFFFFFFF");
            sb.append(indentS).append("  color: Color(0x").append(color.substring(1)).append("),\n");

            // Width and height
            double width = (double) properties.getOrDefault("width", 100.0);
            double height = (double) properties.getOrDefault("height", 100.0);
            sb.append(indentS).append("  width: ").append(width).append(",\n");
            sb.append(indentS).append("  height: ").append(height).append(",\n");

            // Padding
            double padding = (double) properties.getOrDefault("padding", 8.0);
            sb.append(indentS).append("  padding: EdgeInsets.all(").append(padding).append("),\n");

            // Children - single child or Column if multiple
            if (childrenProperty().isEmpty()) {
                sb.append(indentS).append("  child: null,\n");
            } else if (childrenProperty().size() == 1) {
                sb.append(indentS).append("  child:\n");
                sb.append(childrenProperty().get(0).toFlutterCode(indent + 2)).append(",\n");
            } else {
                sb.append(indentS).append("  child: Column(\n");
                sb.append(indentS).append("    children: [\n");
                for (WidgetModel c : childrenProperty()) {
                    sb.append(c.toFlutterCode(indent + 3)).append(",\n");
                }
                sb.append(indentS).append("    ],\n");
                sb.append(indentS).append("  ),\n");
            }

            sb.append(indentS).append(")");
            return sb.toString();
        }
    }

    // Text widget
    public static class TextModel extends WidgetModel {
        public TextModel() {
            super("Text");
            properties.put("text", "Hello Flutter");
            properties.put("color", "#FF000000"); // black
            properties.put("fontSize", 16.0);
        }

        @Override
        public String toFlutterCode(int indent) {
            String indentS = indentStr(indent);
            String text = (String) properties.getOrDefault("text", "Hello Flutter");
            String color = (String) properties.getOrDefault("color", "#FF000000");
            double fontSize = (double) properties.getOrDefault("fontSize", 16.0);
            StringBuilder sb = new StringBuilder();
            sb.append(indentS).append("Text(\n");
            sb.append(indentS).append("  '").append(text.replace("'", "\\'")).append("',\n");
            sb.append(indentS).append("  style: TextStyle(\n");
            sb.append(indentS).append("    color: Color(0x").append(color.substring(1)).append("),\n");
            sb.append(indentS).append("    fontSize: ").append(fontSize).append(",\n");
            sb.append(indentS).append("  ),\n");
            sb.append(indentS).append(")");
            return sb.toString();
        }
    }

    // Button widget (FlatButton deprecated, use TextButton)
    public static class ButtonModel extends WidgetModel {
        public ButtonModel() {
            super("Button");
            properties.put("text", "Click Me");
            properties.put("color", "#FF2196F3"); // blue
        }

        @Override
        public String toFlutterCode(int indent) {
            String indentS = indentStr(indent);
            String text = (String) properties.getOrDefault("text", "Click Me");
            String color = (String) properties.getOrDefault("color", "#FF2196F3");
            StringBuilder sb = new StringBuilder();
            sb.append(indentS).append("TextButton(\n");
            sb.append(indentS).append("  onPressed: () {},\n");
            sb.append(indentS).append("  style: TextButton.styleFrom(\n");
            sb.append(indentS).append("    backgroundColor: Color(0x").append(color.substring(1)).append("),\n");
            sb.append(indentS).append("  ),\n");
            sb.append(indentS).append("  child: Text('").append(text.replace("'", "\\'")).append("'),\n");
            sb.append(indentS).append(")");
            return sb.toString();
        }
    }

    // Column widget
    public static class ColumnModel extends WidgetModel {
        public ColumnModel() {
            super("Column");
        }

        @Override
        public String toFlutterCode(int indent) {
            String indentS = indentStr(indent);
            StringBuilder sb = new StringBuilder();
            sb.append(indentS).append("Column(\n");
            sb.append(indentS).append("  children: [\n");
            for (WidgetModel c : childrenProperty()) {
                sb.append(c.toFlutterCode(indent + 2)).append(",\n");
            }
            sb.append(indentS).append("  ],\n");
            sb.append(indentS).append(")");
            return sb.toString();
        }
    }

    // Row widget
    public static class RowModel extends WidgetModel {
        public RowModel() {
            super("Row");
        }

        @Override
        public String toFlutterCode(int indent) {
            String indentS = indentStr(indent);
            StringBuilder sb = new StringBuilder();
            sb.append(indentS).append("Row(\n");
            sb.append(indentS).append("  children: [\n");
            for (WidgetModel c : childrenProperty()) {
                sb.append(c.toFlutterCode(indent + 2)).append(",\n");
            }
            sb.append(indentS).append("  ],\n");
            sb.append(indentS).append(")");
            return sb.toString();
        }
    }

    // Main UI Components
    private TreeView<WidgetModel> widgetTree;
    private VBox propertyEditor;
    private Pane canvasPane;
    private WidgetModel selectedWidget = null;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Flutter UI Designer (JavaFX) - Dark Theme");

        BorderPane root = new BorderPane();

        // Dark theme styles
        root.setStyle("-fx-background-color: #2b2b2b; -fx-text-fill: #eeeeee;");

        // Left: Widget Palette
        VBox palette = new VBox(10);
        palette.setPadding(new Insets(10));
        palette.setPrefWidth(150);
        palette.setStyle("-fx-background-color: #3c3f41;");

        Label paletteLabel = new Label("Widgets");
        paletteLabel.setStyle("-fx-text-fill: #ffffff; -fx-font-weight: bold;");
        palette.getChildren().add(paletteLabel);

        Button btnContainer = new Button("Container");
        Button btnText = new Button("Text");
        Button btnButton = new Button("Button");
        Button btnColumn = new Button("Column");
        Button btnRow = new Button("Row");

        stylePaletteButton(btnContainer);
        stylePaletteButton(btnText);
        stylePaletteButton(btnButton);
        stylePaletteButton(btnColumn);
        stylePaletteButton(btnRow);

        palette.getChildren().addAll(btnContainer, btnText, btnButton, btnColumn, btnRow);

        // Center: Canvas
        canvasPane = new Pane();
        canvasPane.setPrefSize(600, 600);
        canvasPane.setStyle("-fx-background-color: #313335; -fx-border-color: #555555; -fx-border-width: 1;");
        ScrollPane canvasScroll = new ScrollPane(canvasPane);
        canvasScroll.setFitToWidth(true);
        canvasScroll.setFitToHeight(true);

        // Right: Widget Tree + Properties
        VBox rightPane = new VBox(10);
        rightPane.setPadding(new Insets(10));
        rightPane.setPrefWidth(300);
        rightPane.setStyle("-fx-background-color: #3c3f41;");

        Label treeLabel = new Label("Widget Tree");
        treeLabel.setStyle("-fx-text-fill: #ffffff; -fx-font-weight: bold;");
        rightPane.getChildren().add(treeLabel);

        widgetTree = new TreeView<>();
        widgetTree.setStyle("-fx-background-color: #2b2b2b; -fx-text-fill: #eeeeee;");
        widgetTree.setShowRoot(false);
        rightPane.getChildren().add(widgetTree);

        Label propLabel = new Label("Properties");
        propLabel.setStyle("-fx-text-fill: #ffffff; -fx-font-weight: bold;");
        rightPane.getChildren().add(propLabel);

        propertyEditor = new VBox(8);
        ScrollPane propScroll = new ScrollPane(propertyEditor);
        propScroll.setFitToWidth(true);
        propScroll.setPrefHeight(300);
        rightPane.getChildren().add(propScroll);

        // Bottom: Export button
        Button exportBtn = new Button("Export Flutter Dart Code");
        stylePaletteButton(exportBtn);

        exportBtn.setOnAction(e -> {
            exportFlutterCode();
        });

        // Layout root
        root.setLeft(palette);
        root.setCenter(canvasScroll);
        root.setRight(rightPane);
        root.setBottom(exportBtn);
        BorderPane.setAlignment(exportBtn, Pos.CENTER);
        BorderPane.setMargin(exportBtn, new Insets(10));

        // Root widget for canvas
        WidgetModel rootWidget = new ContainerModel();
        rootWidget.setName("Root Container");

        // Initialize widget tree
        TreeItem<WidgetModel> rootTreeItem = createTreeItem(rootWidget);
        widgetTree.setRoot(rootTreeItem);
        widgetTree.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                selectWidget(newSel.getValue());
            }
        });

        // Palette buttons add widgets to selected node
        btnContainer.setOnAction(e -> addWidget(new ContainerModel()));
        btnText.setOnAction(e -> addWidget(new TextModel()));
        btnButton.setOnAction(e -> addWidget(new ButtonModel()));
        btnColumn.setOnAction(e -> addWidget(new ColumnModel()));
        btnRow.setOnAction(e -> addWidget(new RowModel()));

        // Initial selection
        selectWidget(rootWidget);

        primaryStage.setScene(new Scene(root, 1050, 700));
        primaryStage.show();
    }

    private void stylePaletteButton(Button btn) {
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setStyle("-fx-background-color: #555555; -fx-text-fill: white;");
        btn.setOnMouseEntered(e -> btn.setStyle("-fx-background-color: #777777; -fx-text-fill: white;"));
        btn.setOnMouseExited(e -> btn.setStyle("-fx-background-color: #555555; -fx-text-fill: white;"));
    }

    private TreeItem<WidgetModel> createTreeItem(WidgetModel widget) {
        TreeItem<WidgetModel> item = new TreeItem<WidgetModel>(widget) {
            @Override
            public String toString() {
                return widget.getName();
            }
        };
        for (WidgetModel c : widget.getChildren()) {
            item.getChildren().add(createTreeItem(c));
        }
        item.setExpanded(true);
        return item;
    }

    private void selectWidget(WidgetModel widget) {
        selectedWidget = widget;
        buildPropertyEditor(widget);
        drawCanvas();
    }

    private void addWidget(WidgetModel newWidget) {
        if (selectedWidget == null) return;
        selectedWidget.addChild(newWidget);

        // Refresh tree view
        TreeItem<WidgetModel> rootItem = widgetTree.getRoot();
        widgetTree.setRoot(null); // Force refresh
        widgetTree.setRoot(rootItem);

        // Expand all tree nodes
        expandAll(rootItem);

        // Select new widget
        selectWidget(newWidget);
    }

    private void expandAll(TreeItem<?> item) {
        if (item == null) return;
        item.setExpanded(true);
        for (TreeItem<?> child : item.getChildren()) {
            expandAll(child);
        }
    }

    private void buildPropertyEditor(WidgetModel widget) {
        propertyEditor.getChildren().clear();
        if (widget == null) return;

        Label widgetLabel = new Label("Editing: " + widget.getName());
        widgetLabel.setStyle("-fx-text-fill: #ffffff; -fx-font-weight: bold;");
        propertyEditor.getChildren().add(widgetLabel);

        Map<String, Object> props = widget.getProperties();

        // For each widget type, we expose certain properties
        if (widget instanceof ContainerModel) {
            addColorPicker("Color", "color", props);
            addDoubleField("Width", "width", props);
            addDoubleField("Height", "height", props);
            addDoubleField("Padding", "padding", props);
            addDoubleField("Margin", "margin", props);
        } else if (widget instanceof TextModel) {
            addTextField("Text", "text", props);
            addColorPicker("Color", "color", props);
            addDoubleField("Font Size", "fontSize", props);
        } else if (widget instanceof ButtonModel) {
            addTextField("Text", "text", props);
            addColorPicker("Color", "color", props);
        } else if (widget instanceof ColumnModel) {
            Label info = new Label("No editable properties.");
            info.setStyle("-fx-text-fill: #ccc;");
            propertyEditor.getChildren().add(info);
        } else if (widget instanceof RowModel) {
            Label info = new Label("No editable properties.");
            info.setStyle("-fx-text-fill: #ccc;");
            propertyEditor.getChildren().add(info);
        }
    }

    private void addTextField(String label, String propName, Map<String, Object> props) {
        Label lbl = new Label(label);
        lbl.setStyle("-fx-text-fill: white;");
        TextField tf = new TextField(props.get(propName).toString());
        tf.textProperty().addListener((obs, oldVal, newVal) -> {
            props.put(propName, newVal);
            drawCanvas();
        });
        propertyEditor.getChildren().addAll(lbl, tf);
    }

    private void addDoubleField(String label, String propName, Map<String, Object> props) {
        Label lbl = new Label(label);
        lbl.setStyle("-fx-text-fill: white;");
        TextField tf = new TextField(props.get(propName).toString());
        tf.textProperty().addListener((obs, oldVal, newVal) -> {
            try {
                double val = Double.parseDouble(newVal);
                props.put(propName, val);
                drawCanvas();
            } catch (NumberFormatException ignored) {
            }
        });
        propertyEditor.getChildren().addAll(lbl, tf);
    }

    private void addColorPicker(String label, String propName, Map<String, Object> props) {
        Label lbl = new Label(label);
        lbl.setStyle("-fx-text-fill: white;");

        Color initColor = Color.WHITE;
        try {
            initColor = Color.web((String) props.get(propName));
        } catch (Exception ignored) {
        }
        ColorPicker cp = new ColorPicker(initColor);
        cp.setOnAction(e -> {
            Color c = cp.getValue();
            String hex = String.format("#%02X%02X%02X%02X",
                    (int) (c.getOpacity() * 255),
                    (int) (c.getRed() * 255),
                    (int) (c.getGreen() * 255),
                    (int) (c.getBlue() * 255));
            props.put(propName, hex);
            drawCanvas();
        });
        propertyEditor.getChildren().addAll(lbl, cp);
    }

    private void drawCanvas() {
        canvasPane.getChildren().clear();
        if (selectedWidget == null) return;
        Node node = createFXNode(selectedWidget);
        if (node != null) {
            canvasPane.getChildren().add(node);
        }
    }

    private Node createFXNode(WidgetModel widget) {
        if (widget instanceof ContainerModel) {
            return createContainerFX((ContainerModel) widget);
        } else if (widget instanceof TextModel) {
            return createTextFX((TextModel) widget);
        } else if (widget instanceof ButtonModel) {
            return createButtonFX((ButtonModel) widget);
        } else if (widget instanceof ColumnModel) {
            return createColumnFX((ColumnModel) widget);
        } else if (widget instanceof RowModel) {
            return createRowFX((RowModel) widget);
        }
        return new Label("Unsupported widget: " + widget.getName());
    }

    private Region createContainerFX(ContainerModel container) {
        Pane pane = new Pane();
        String colorStr = (String) container.getProperties().getOrDefault("color", "#FFFFFFFF");
        Color color = Color.web(colorStr);
        pane.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));

        double width = (double) container.getProperties().getOrDefault("width", 100.0);
        double height = (double) container.getProperties().getOrDefault("height", 100.0);
        pane.setPrefSize(width, height);

        // Draw children inside
        double padding = (double) container.getProperties().getOrDefault("padding", 8.0);
        double offset = padding;

        for (WidgetModel child : container.getChildren()) {
            Node childNode = createFXNode(child);
            if (childNode != null) {
                if (childNode instanceof Region) {
                    ((Region) childNode).setLayoutX(offset);
                    ((Region) childNode).setLayoutY(offset);
                }
                pane.getChildren().add(childNode);
                offset += 50; // stack with offset for demo
            }
        }
        return pane;
    }

    private Label createTextFX(TextModel text) {
        Label lbl = new Label((String) text.getProperties().getOrDefault("text", ""));
        String colorStr = (String) text.getProperties().getOrDefault("color", "#FF000000");
        Color color = Color.web(colorStr);
        lbl.setTextFill(color);
        double fontSize = (double) text.getProperties().getOrDefault("fontSize", 16.0);
        lbl.setFont(new Font(fontSize));
        return lbl;
    }

    private Button createButtonFX(ButtonModel btn) {
        Button button = new Button((String) btn.getProperties().getOrDefault("text", "Click Me"));
        String colorStr = (String) btn.getProperties().getOrDefault("color", "#FF2196F3");
        Color color = Color.web(colorStr);
        button.setStyle("-fx-background-color: " + toRgbString(color));
        return button;
    }

    private VBox createColumnFX(ColumnModel col) {
        VBox box = new VBox(5);
        for (WidgetModel child : col.getChildren()) {
            Node childNode = createFXNode(child);
            if (childNode != null) box.getChildren().add(childNode);
        }
        box.setStyle("-fx-border-color: #666; -fx-border-width: 1;");
        box.setPadding(new Insets(5));
        return box;
    }

    private HBox createRowFX(RowModel row) {
        HBox box = new HBox(5);
        for (WidgetModel child : row.getChildren()) {
            Node childNode = createFXNode(child);
            if (childNode != null) box.getChildren().add(childNode);
        }
        box.setStyle("-fx-border-color: #666; -fx-border-width: 1;");
        box.setPadding(new Insets(5));
        return box;
    }

    private String toRgbString(Color c) {
        return String.format("#%02X%02X%02X",
                (int) (c.getRed() * 255),
                (int) (c.getGreen() * 255),
                (int) (c.getBlue() * 255));
    }

    private void exportFlutterCode() {
        if (widgetTree.getRoot() == null) {
            showAlert("No widgets to export");
            return;
        }
        WidgetModel root = widgetTree.getRoot().getValue();
        StringBuilder sb = new StringBuilder();
        sb.append("import 'package:flutter/material.dart';\n\n");
        sb.append("void main() => runApp(MyApp());\n\n");
        sb.append("class MyApp extends StatelessWidget {\n");
        sb.append("  @override\n");
        sb.append("  Widget build(BuildContext context) {\n");
        sb.append("    return MaterialApp(\n");
        sb.append("      home: Scaffold(\n");
        sb.append("        body: Center(\n");
        sb.append(root.toFlutterCode(4)).append(",\n");
        sb.append("        ),\n");
        sb.append("      ),\n");
        sb.append("    );\n");
        sb.append("  }\n");
        sb.append("}\n");

        try {
            FileWriter fw = new FileWriter("exported_ui.dart");
            fw.write(sb.toString());
            fw.close();
            showAlert("Flutter code exported to exported_ui.dart");
        } catch (IOException e) {
            showAlert("Failed to export code: " + e.getMessage());
        }
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
