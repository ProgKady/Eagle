
package org.sandsoft.acefx.model;

import java.util.Arrays;
import javafx.stage.FileChooser;

/**
 *
 * @author dipu
 */
public class ModeData {

    private String mName;
    private String mAlias;
    private String mRegex;

    public ModeData(String name, String alias, String regex) {
        mName = name;
        mAlias = alias;
        mRegex = regex;
    }

    public String getName() {
        return mName;
    }

    public String getAlias() {
        return mAlias;
    }

    public String getSupportedExtensions() {
        return mRegex;
    }

    public boolean supportsFile(String fileName) {
        fileName = fileName.substring(fileName.lastIndexOf(".") + 1);
        fileName = fileName.toLowerCase();
        return fileName.matches(mRegex);
    }

    public FileChooser.ExtensionFilter getExtensionFilter() {
        String[] data = mRegex.split("\\|");
        for (int i = 0; i < data.length; ++i) {
            data[i] = "*." + data[i];
        }
        return new FileChooser.ExtensionFilter(mName, Arrays.asList(data));
    }

    @Override
    public String toString() {
        return String.format("%s", mName);
    }
}
