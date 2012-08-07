package org.kakueki61.swf.lib.tag.controlTag;

import java.io.IOException;

import org.kakueki61.swf.lib.io.LoadSwfInputStream;
import org.kakueki61.swf.lib.model.RecordHeader;
import org.kakueki61.swf.lib.model.StructRGB;
import org.kakueki61.swf.lib.tag.Tag;


public class SetBackgroundColorTag extends Tag {
    private static final String TAG = SetBackgroundColorTag.class.getSimpleName();
    
    private StructRGB rgb;
    
    /**
     * Default constructor.
     * Makes a new RecordHeader object whose fields(tagCode and tagLength) are 0.
     */
    public SetBackgroundColorTag() {
        this.recordHeader.setTagCode(9);
    }
    
    /**
     * Constructor.
     * Makes a new RecordHeader object whose fields(togCode and tagLength) are
     * copied from the RecordHeader object of an argument
     * @param recordHeader
     */
    public SetBackgroundColorTag(RecordHeader recordHeader) {
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
     * @throws IOException 
     * @see org.kakueki61.swf.lib.tag.Tag.java
     */
    @Override
    public void readData(LoadSwfInputStream loadSwfIs) throws IOException {
        rgb = loadSwfIs.getRGB();
    }
    
    @Override
    public String toString() {
        return "[SetBackgroundColor]\n" + this.recordHeader + "\n" + rgb;
    }
}
