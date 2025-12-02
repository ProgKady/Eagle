
package com.kady.resources;

import java.net.URISyntaxException;




/**
*@author Ahmed
*/
public class zzzzzzzzz extends javafx.application.Application {
    public void start(javafx.stage.Stage kady) throws URISyntaxException {
        final String html = "Index.html";
        final java.net.URI uri = getClass().getResource( html).toURI();
        final javafx.scene.web.WebView root = new javafx.scene.web.WebView();
        root.getEngine().load(uri.toString());
        kady.setTitle("zzzzzzzzz");
        kady.centerOnScreen();
        kady.setResizable(false);
        kady.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("icon.png")));
        kady.setScene(new javafx.scene.Scene(root, 800, 600));
        kady.show();
    }
    public static void main(String[] args) { launch(args); }
}
