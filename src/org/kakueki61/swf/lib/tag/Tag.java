package org.kakueki61.swf.lib.tag;

import java.io.IOException;

import org.kakueki61.swf.lib.io.LoadSwfInputStream;
import org.kakueki61.swf.lib.model.RecordHeader;


public class Tag {
    private static final String TAG = Tag.class.getSimpleName();
    
    protected RecordHeader recordHeader;
    
    /**
     * Default constructor.
     * Makes a new RecordHeader object whose fields(tagCode and tagLength) are 0.
     */
    public Tag() {
        this.recordHeader = new RecordHeader();
    }
    
    /**
     * Constructor.
     * Makes a new RecordHeader object whose fields(togCode and tagLength) are
     * copied from the RecordHeader object of an argument
     * @param recordHeader
     */
    public Tag(RecordHeader recordHeader) {
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
     * Override this method in each subclass.
     * @param loadSwf 
     * @throws IOException 
     */
    public void readData(LoadSwfInputStream loadSwf) throws IOException {
        loadSwf.skip(getTagLength());
    }
    
    @Override
    public String toString() {
        return "[unknown Tag]" + "\n" + this.recordHeader;
    }
}
