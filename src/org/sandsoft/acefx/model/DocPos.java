
package org.sandsoft.acefx.model;

import netscape.javascript.JSObject;


public class DocPos {

    private int mRow;
    private int mColumn;

    public DocPos() {
        mRow = 0;
        mColumn = 0;
    }

    public DocPos(int row, int column) {
        this.mRow = row;
        this.mColumn = column;
    }

    public DocPos(JSObject arg) {
        this.mRow = (int) arg.getMember("row");
        this.mColumn = (int) arg.getMember("column");
    }

    public int getRow() {
        return mRow;
    }

    public int getColumn() {
        return mColumn;
    }

    public void setRow(int row) {
        this.mRow = row;
    }

    public void setColumn(int col) {
        this.mColumn = col;
    }

    @Override
    public String toString() {
        return String.format("{row: %d, column: %d}", mRow, mColumn);
    }
}
