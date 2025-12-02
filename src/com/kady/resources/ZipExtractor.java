package com.kady.resources;
import java.io.*;
import java.util.zip.*;

public class ZipExtractor {

    public static void unzip(File zipFile, File outputFolder) throws IOException {
        if (!outputFolder.exists()) outputFolder.mkdirs();

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                File newFile = new File(outputFolder, entry.getName());

                if (entry.isDirectory()) {
                    newFile.mkdirs();
                } else {
                    // Write file
                    new File(newFile.getParent()).mkdirs();
                    try (FileOutputStream fos = new FileOutputStream(newFile)) {
                        byte[] buffer = new byte[4096];
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }

                    // Check if the extracted file is a zip (based on extension)
                    if (newFile.getName().toLowerCase().endsWith(".zip")) {
                        // Recursively extract nested zip
                        File nestedOutput = new File(newFile.getParent(), newFile.getName().replace(".zip", ""));
                        unzip(newFile, nestedOutput);
                        // Optionally delete the nested zip file after extraction
                        newFile.delete();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        File zipFile = new File("C:\\Users\\Ahmed.ElKady\\Desktop\\jspaintmaster\\jspaintmaster\\styles.zip");
        File outputFolder = new File("C:\\Users\\Ahmed.ElKady\\Desktop\\jspaintmaster\\jspaintmaster\\hihi");
        unzip(zipFile, outputFolder);
        System.out.println("Extraction completed.");
    }
}
