package org.kakueki61.swf.lib.tag;

import java.io.IOException;

import org.kakueki61.swf.lib.io.LoadSwfInputStream;
import org.kakueki61.swf.lib.model.RecordHeader;
import org.kakueki61.swf.lib.model.StructRect;
import org.kakueki61.swf.lib.model.shape.StructShapeWithStyle;


public class DefineShapeTag extends Tag {
    /*
     * Defines fields
     */
    private int shapeId;
    private StructRect shapeBounds;
    private StructShapeWithStyle[] shapes;
    
    /**
     * Default constructor.
     * Makes a new RecordHeader object whose fields(tagCode and tagLength) are 1.
     */
    public DefineShapeTag() {
        this.recordHeader.setTagCode(2);
    }
    
    /**
     * Constructor.
     * Makes a new RecordHeader object whose fields(togCode and tagLength) are
     * copied from the RecordHeader object of an argument
     * @param recordHeader
     */
    public DefineShapeTag(RecordHeader recordHeader) {
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
        shapeId = loadSwfIs.readUI16();
    }
    
    @Override
    public String toString() {
        return "[DefineShape]\n" + "shapeId: " + shapeId;
    }
}
