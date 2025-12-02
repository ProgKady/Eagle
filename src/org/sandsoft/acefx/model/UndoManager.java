
package org.sandsoft.acefx.model;

import netscape.javascript.JSException;
import netscape.javascript.JSObject;

/**
 *
 * @author Sudipto Chandra
 */
public class UndoManager {

    private final JSObject mUndoManager;

    /**
     * Manipulate undo manager commands
     *
     * @param undoManager JavaScript object of undo manager.
     */
    public UndoManager(JSObject undoManager) throws JSException {
        mUndoManager = undoManager;
    }

    /**
     * Provides a means for implementing your own undo manager. <br/>
     * options has one property, args: an Array, with two elements: <br/>
     * args[0] is an array of deltas. <br/>
     * args[1] is the document to associate with.
     *
     * @param options Required. Contains additional properties.
     */
    private void execute(Object options) throws JSException {
        mUndoManager.call("execute", options);
    }

    /**
     * Returns true if there are redo operations left to perform.
     *
     * @return true if there are redo operations left to perform.
     */
    public boolean hasRedo() throws JSException {
        return (boolean) mUndoManager.call("hasRedo");
    }

    /**
     * Returns true if there are undo operations left to perform.
     *
     * @return true if there are undo operations left to perform.
     */
    public boolean hasUndo() throws JSException {
        return (boolean) mUndoManager.call("hasUndo");
    }

    public boolean isClean() throws JSException {
        return (boolean) mUndoManager.call("isClean");
    }

    public void markClean() throws JSException {
        mUndoManager.call("markClean");
    }

    /**
     * Perform a redo operation on the document, re-implementing the last
     * change.
     *
     * @param dontSelect Required. If true, doesn't select the range of where
     * the change occurred.
     */
    public void redo(Boolean dontSelect) throws JSException {
        mUndoManager.call("redo", dontSelect);
    }

    /**
     * Destroys the stack of undo and redo redo operations.
     */
    public void reset() throws JSException {
        mUndoManager.call("reset");
    }

    /**
     * Perform an undo operation on the document, reverting the last change.
     *
     * @param dontSelect Required. If true, doesn't select the range of where
     * the change occurred.
     */
    public void undo(Boolean dontSelect) throws JSException {
        mUndoManager.call("undo", dontSelect);
    }

    public int getLength() {
        return (int) mUndoManager.call("length");
    }
}
