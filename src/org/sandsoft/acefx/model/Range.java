
package org.sandsoft.acefx.model;

import netscape.javascript.JSObject;

/**
 *
 * @author Sudipto Chandra
 */
public class Range {

    private DocPos mEnd;
    private DocPos mStart;
    
    public Range()
    {
        mEnd = new DocPos();
        mStart = new DocPos();
    }
    
    public Range(int startRow, int startColumn, int endRow, int endColumn) {
        this.mStart = new DocPos(startRow, startColumn);
        this.mEnd = new DocPos(endRow, endColumn);
    }

    public Range(JSObject arg) {
        this.mStart = new DocPos((JSObject) arg.getMember("start"));
        this.mEnd = new DocPos((JSObject) arg.getMember("end"));
    }

    public DocPos getStart() {
        return mStart;
    }

    public DocPos getEnd() {
        return mEnd;
    }

    public void setStart(DocPos start) {
        this.mStart = start;
    }

    public void setEnd(DocPos end) {
        this.mEnd = end;
    }

    @Override
    public String toString() {
        return String.format("{start:%s, end:%s}", mStart, mEnd);
    }

}
