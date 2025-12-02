package eagle;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class FixManifest {

    public static void main(String[] args) throws Exception {
        String manifestPath = "C:\\Users\\Ahmed.ElKady\\Desktop\\ppp\\AndroidManifest.xml";
        File xmlFile = new File(manifestPath);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        Document doc = dbFactory.newDocumentBuilder().parse(xmlFile);
        doc.getDocumentElement().normalize();

        // ??? hasFragileUserData
        NodeList appList = doc.getElementsByTagName("application");
        if (appList.getLength() > 0) {
            Element app = (Element) appList.item(0);
            if (app.hasAttribute("android:hasFragileUserData")) {
                app.removeAttribute("android:hasFragileUserData");
                System.out.println("? Removed 'hasFragileUserData'");
            }
        }

        // ??? foregroundServiceType
        NodeList services = doc.getElementsByTagName("service");
        for (int i = 0; i < services.getLength(); i++) {
            Element service = (Element) services.item(i);
            if (service.hasAttribute("android:foregroundServiceType")) {
                service.removeAttribute("android:foregroundServiceType");
                System.out.println("? Removed 'foregroundServiceType'");
            }
        }

        // ??? ????? ??????
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(xmlFile);
        transformer.transform(source, result);

        System.out.println("? Manifest fixed and saved.");
    }
}







//
//
//
//import org.w3c.dom.*;
//import javax.xml.parsers.*;
//import javax.xml.transform.*;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//import java.io.File;
//
//public class ManifestFixer {
//    public static void main(String[] args) throws Exception {
//        
//        
//        
//        String projectfolder = "C:\\Users\\Ahmed.ElKady\\Desktop\\instapay";
//        String manifestPath = projectfolder + "\\AndroidManifest.xml";
//
//        File xmlFile = new File(manifestPath);
//        if (!xmlFile.exists()) {
//            System.err.println("❌ File not found: " + manifestPath);
//            return;
//        }
//
//        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//        dbFactory.setNamespaceAware(true);
//        Document doc = dbFactory.newDocumentBuilder().parse(xmlFile);
//        doc.getDocumentElement().normalize();
//
//        // Get android namespace URI from root
//        String androidNS = doc.getDocumentElement().getAttribute("xmlns:android");
//        if (androidNS == null || androidNS.isEmpty()) {
//            androidNS = "http://schemas.android.com/apk/res/android"; // fallback
//        }
//
//        // Remove 'hasFragileUserData' from <application>
//        NodeList appList = doc.getElementsByTagName("application");
//        if (appList.getLength() > 0) {
//            Element app = (Element) appList.item(0);
//            if (app.hasAttributeNS(androidNS, "hasFragileUserData")) {
//                app.removeAttributeNS(androidNS, "hasFragileUserData");
//                System.out.println("✅ Removed 'hasFragileUserData'");
//            }
//        }
//
//        // Remove 'foregroundServiceType' from <service>
//        NodeList services = doc.getElementsByTagName("service");
//        for (int i = 0; i < services.getLength(); i++) {
//            Element service = (Element) services.item(i);
//            if (service.hasAttributeNS(androidNS, "foregroundServiceType")) {
//                service.removeAttributeNS(androidNS, "foregroundServiceType");
//                System.out.println("✅ Removed 'foregroundServiceType' in service #" + (i + 1));
//            }
//        }
//
//        // Save back the modified XML
//        Transformer transformer = TransformerFactory.newInstance().newTransformer();
//        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
//        DOMSource source = new DOMSource(doc);
//        StreamResult result = new StreamResult(xmlFile);
//        transformer.transform(source, result);
//
//        System.out.println("✅ AndroidManifest.xml fixed and saved successfully.");
//        
//        
//    }
//    
//    
//}
//
//
