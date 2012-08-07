package org.kakueki61.swf.lib.model;

public class RecordHeader {
    private static final String TAG = RecordHeader.class.getSimpleName();
    
    private int tagCode;
    private int tagLength;
    
    public RecordHeader() {
        this.tagCode = 0;
        this.tagLength = 0;
    }

    public int getTagCode() {
        return tagCode;
    }

    public void setTagCode(int tagCode) {
        this.tagCode = tagCode;
    }

    public int getTagLength() {
        return tagLength;
    }

    public void setTagLength(int tagLength) {
        this.tagLength = tagLength;
    }
    
    /** @Override */
    public String toString() {
        return "TagCodeAndLength: tagCode=" + tagCode + ", tagLength=" + tagLength;
    }
}
