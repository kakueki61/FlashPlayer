package org.kakueki61.swf.lib.tag;

import org.kakueki61.swf.lib.io.LoadSwfInputStream;
import org.kakueki61.swf.lib.model.RecordHeader;


public class ShowFrameTag extends Tag {
    private static final String TAG = ShowFrameTag.class.getSimpleName();
    
    /**
     * Default constructor.
     * Makes a new RecordHeader object whose fields(tagCode and tagLength) are 1.
     */
    public ShowFrameTag() {
        this.recordHeader.setTagCode(1);
    }
    
    /**
     * Constructor.
     * Makes a new RecordHeader object whose fields(togCode and tagLength) are
     * copied from the RecordHeader object of an argument
     * @param recordHeader
     */
    public ShowFrameTag(RecordHeader recordHeader) {
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
        //TODO
    }
    
    @Override
    public String toString() {
        return "[ShowFrame]\n" + this.recordHeader;
    }
}
