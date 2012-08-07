package org.kakueki61.swf.lib.model;

public class StructClipActions {
    private static final String TAG = StructClipActions.class.getSimpleName();
    
    private int byteLength;
    
    public StructClipActions() {
        this.byteLength = 0;
    }
    
    @Override
    public String toString() {
        return String.valueOf(byteLength);
    }

    public int getByteLength() {
        return byteLength;
    }

    public void setByteLength(int byteLength) {
        this.byteLength = byteLength;
    }
}
