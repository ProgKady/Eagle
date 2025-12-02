package eagle;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ManifestPermissionEditor extends Application {

    private ListView<String> permissionListView;
    private ComboBox<String> permissionComboBox;
    private File manifestFile;
    private Document xmlDoc;

    private static final List<String> COMMON_PERMISSIONS = Arrays.asList(
            "android.permission.INTERNET",
            "android.permission.ACCESS_FINE_LOCATION",
            "android.permission.ACCESS_COARSE_LOCATION",
            "android.permission.CAMERA",
            "android.permission.RECORD_AUDIO",
            "android.permission.READ_CONTACTS",
            "android.permission.WRITE_EXTERNAL_STORAGE",
            "android.permission.READ_EXTERNAL_STORAGE"
    );
    
    
    

    @Override
    public void start(Stage primaryStage) {
        
        
        primaryStage.setTitle("AndroidManifest Permission Editor");

        permissionListView = new ListView<>();
        permissionComboBox = new ComboBox<>();
        permissionComboBox.getItems().addAll(COMMON_PERMISSIONS);
        permissionComboBox.setEditable(true);

        Button loadButton = new Button("Load Manifest");
        Button addButton = new Button("Add Permission");
        Button removeButton = new Button("Remove Selected");

        HBox controlBox = new HBox(10, permissionComboBox, addButton, removeButton);
        VBox root = new VBox(10, loadButton, permissionListView, controlBox);
        root.setPadding(new Insets(10));

        loadButton.setOnAction(e -> loadManifest(primaryStage));
        addButton.setOnAction(e -> addPermission());
        removeButton.setOnAction(e -> removeSelectedPermission());

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
    }

    private void loadManifest(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open AndroidManifest.xml");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("XML Files", "*.xml")
        );

        manifestFile = fileChooser.showOpenDialog(stage);
        if (manifestFile == null) return;

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setNamespaceAware(true); // for android:name attribute
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            xmlDoc = dBuilder.parse(manifestFile);
            xmlDoc.getDocumentElement().normalize();
            updatePermissionList();
        } catch (Exception ex) {
            showAlert("Error", "Failed to load manifest: " + ex.getMessage());
        }
    }

    private void updatePermissionList() {
        permissionListView.getItems().clear();
        NodeList nodes = xmlDoc.getElementsByTagName("uses-permission");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);
            String permission = element.getAttribute("android:name");
            if (!permission.isEmpty()) {
                permissionListView.getItems().add(permission);
            }
        }
    }

    private void addPermission() {
        if (xmlDoc == null || manifestFile == null) return;

        String permission = permissionComboBox.getEditor().getText();
        if (permission == null || permission.trim().isEmpty()) return;

        if (permissionListView.getItems().contains(permission)) {
            showAlert("Info", "Permission already exists.");
            return;
        }

        Element newPerm = xmlDoc.createElement("uses-permission");
        newPerm.setAttribute("android:name", permission);

        Node manifestNode = xmlDoc.getDocumentElement();
        Node applicationNode = getFirstChildByName(manifestNode, "application");

        if (applicationNode != null) {
            manifestNode.insertBefore(newPerm, applicationNode);
        } else {
            manifestNode.appendChild(newPerm);
        }

        saveManifest();
        updatePermissionList();
    }

    private void removeSelectedPermission() {
        if (xmlDoc == null || manifestFile == null) return;

        String selectedPermission = permissionListView.getSelectionModel().getSelectedItem();
        if (selectedPermission == null) return;

        NodeList nodes = xmlDoc.getElementsByTagName("uses-permission");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);
            if (selectedPermission.equals(element.getAttribute("android:name"))) {
                xmlDoc.getDocumentElement().removeChild(element);
                break;
            }
        }

        saveManifest();
        updatePermissionList();
    }

    private Node getFirstChildByName(Node parent, String name) {
        NodeList children = parent.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (name.equals(child.getNodeName())) {
                return child;
            }
        }
        return null;
    }

    private void saveManifest() {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(xmlDoc);
            StreamResult result = new StreamResult(manifestFile);
            transformer.transform(source, result);
        } catch (Exception e) {
            showAlert("Error", "Failed to save manifest: " + e.getMessage());
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    
    
    

    public static void main(String[] args) {
        launch(args);
    }
}
