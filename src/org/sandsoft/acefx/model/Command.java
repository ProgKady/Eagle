
package org.sandsoft.acefx.model;

import org.sandsoft.acefx.util.Commons;
import netscape.javascript.JSObject;


public class Command {

    private String mName;
    private String mBindKeyWin;
    private String mBindKeyMac;

    public void Command() {
    }

    public Command(JSObject dat) {
        mName = (String) dat.getMember("name");
        Object key = dat.getMember("bindKey");
        if (key != null && key instanceof JSObject) {
            mBindKeyWin = (String) ((JSObject) key).getMember("win");
            mBindKeyMac = (String) ((JSObject) key).getMember("mac");
        }
    }

    @Override
    public String toString() {
        return String.format(
                "{name:'%s', bindKey:{win:'%s', mac:'%s'}}",
                mName, mBindKeyWin, mBindKeyMac);
    }

    /**
     * Gets the Name property.
     *
     * @return value of the Name property.
     */
    public String getName() {
        return mName;
    }

    /**
     * Sets the Name property.
     *
     * @param val value of Name property.
     */
    public void setName(String val) {
        mName = val;
    }

    /**
     * Gets the BindKeyWin property.
     *
     * @return value of the BindKeyWin property.
     */
    public String getBindKeyWin() {
        return mBindKeyWin;
    }

    /**
     * Sets the BindKeyWin property.
     *
     * @param val value of BindKeyWin property.
     */
    public void setBindKeyWin(String val) {
        mBindKeyWin = val;
    }

    /**
     * Gets the BindKeyMac property.
     *
     * @return value of the BindKeyMac property.
     */
    public String getBindKeyMac() {
        return mBindKeyMac;
    }

    /**
     * Sets the BindKeyMac property.
     *
     * @param val value of BindKeyMac property.
     */
    public void setBindKeyMac(String val) {
        mBindKeyMac = val;
    }


}
