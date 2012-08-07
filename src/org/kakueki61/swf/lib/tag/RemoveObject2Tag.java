package org.kakueki61.swf.lib.tag;

import java.io.IOException;

import org.kakueki61.swf.lib.io.LoadSwfInputStream;
import org.kakueki61.swf.lib.model.RecordHeader;


public class RemoveObject2Tag extends Tag {
    /*
     * Defines fields
     */
    private int depth;
    
    /**
     * Default constructor.
     * Makes a new RecordHeader object whose fields(tagCode and tagLength) are 1.
     */
    public RemoveObject2Tag() {
        this.recordHeader.setTagCode(28);
    }
    
    /**
     * Constructor.
     * Makes a new RecordHeader object whose fields(togCode and tagLength) are
     * copied from the RecordHeader object of an argument
     * @param recordHeader
     */
    public RemoveObject2Tag(RecordHeader recordHeader) {
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
    public void readData(LoadSwfInputStream loadSwfIs) throws IOException {
        depth = loadSwfIs.readUI16();
    }
    
    @Override
    public String toString() {
        return "[RemoveObject2]\n" + "depth: " + depth;
    }
}
