package org.kakueki61.swf.lib.tag.controlTag;

import org.kakueki61.swf.lib.io.LoadSwfInputStream;
import org.kakueki61.swf.lib.model.RecordHeader;
import org.kakueki61.swf.lib.tag.Tag;


public class EndTag extends Tag {
    private static final String TAG = EndTag.class.getSimpleName();
    
    /**
     * Default constructor.
     * Makes a new RecordHeader object whose fields(tagCode and tagLength) are 0.
     */
    public EndTag() {
        this.recordHeader.setTagCode(0);
    }
    
    /**
     * Constructor.
     * Makes a new RecordHeader object whose fields(togCode and tagLength) are
     * copied from the RecordHeader object of an argument
     * @param recordHeader
     */
    public EndTag(RecordHeader recordHeader) {
        this.recordHeader = new RecordHeader();
        this.recordHeader.setTagCode(recordHeader.getTagCode());
        this.recordHeader.setTagLength(recordHeader.getTagLength());
    }
    
    /**
     * Returns TagCode.
     * @return TagCode integer
     */
    public int getTagCode() {
        return this.recordHeader.getTagCode();
    }
    
    /**
     * Returns TagLength
     * @return TagLength integer
     */
    public int getTagLength() {
        return this.recordHeader.getTagLength();
    }
    
    /**
     * @see org.kakueki61.swf.lib.tag.Tag.java
     */
    @Override
    public void readData(LoadSwfInputStream loadSwfIs) {
        //nothing to process
    }
    
    @Override
    public String toString() {
        return "[End]\n" + this.recordHeader;
    }
}
