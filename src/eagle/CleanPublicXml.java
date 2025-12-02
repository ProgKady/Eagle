package eagle;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.*;

public class CleanPublicXml {

    public static void main(String[] args) {
        try {
            String basePath = "C:\\Users\\Ahmed.ElKady\\Desktop\\ppp\\res\\values";
            File valuesFolder = new File(basePath);

            // ❗ Check if folder exists and is directory
            if (!valuesFolder.exists() || !valuesFolder.isDirectory()) {
                System.err.println("❌ Error: Folder does not exist or is not a directory:\n" + basePath);
                return;
            }

            File publicXml = new File(valuesFolder, "public.xml");
            if (!publicXml.exists()) {
                System.err.println("❌ Error: public.xml not found in:\n" + basePath);
                return;
            }

            // 🔎 Read defined array names
            Set<String> definedArrayNames = new HashSet<>();
            File[] valueFiles = valuesFolder.listFiles((dir, name) ->
                name.endsWith(".xml") && !name.equalsIgnoreCase("public.xml")
            );

            if (valueFiles == null) {
                System.err.println("❌ Error: valueFiles is null. Cannot read files from directory.");
                return;
            }

            for (File file : valueFiles) {
                System.out.println("✅ Reading: " + file.getName());
                Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
                NodeList nodes = doc.getDocumentElement().getChildNodes();
                for (int i = 0; i < nodes.getLength(); i++) {
                    Node node = nodes.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        String tag = node.getNodeName();
                        if (tag.equals("array") || tag.equals("string-array") || tag.equals("integer-array")) {
                            Element element = (Element) node;
                            if (element.hasAttribute("name")) {
                                definedArrayNames.add(element.getAttribute("name"));
                            }
                        }
                    }
                }
            }

            // 🔎 Parse public.xml
            Document publicDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(publicXml);
            NodeList publicItems = publicDoc.getDocumentElement().getElementsByTagName("public");

            List<Node> toRemove = new ArrayList<>();
            for (int i = 0; i < publicItems.getLength(); i++) {
                Element item = (Element) publicItems.item(i);
                String type = item.getAttribute("type");
                String name = item.getAttribute("name");
                if ((type.equals("array") || type.equals("string-array") || type.equals("integer-array"))
                        && !definedArrayNames.contains(name)) {
                    toRemove.add(item);
                }
            }

            for (Node node : toRemove) {
                node.getParentNode().removeChild(node);
            }

            // 💾 Save changes
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(publicDoc), new StreamResult(publicXml));

            System.out.println("✅ Removed " + toRemove.size() + " unused array entries from public.xml");

        } catch (Exception e) {
            System.err.println("❌ Exception caught: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
