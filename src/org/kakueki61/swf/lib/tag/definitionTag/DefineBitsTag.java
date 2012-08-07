package org.kakueki61.swf.lib.tag.definitionTag;


import java.io.IOException;

import org.kakueki61.swf.lib.io.LoadSwfInputStream;
import org.kakueki61.swf.lib.model.RecordHeader;
import org.kakueki61.swf.lib.tag.Tag;


public class DefineBitsTag extends Tag {
    /*
     * Defines fields
     */
    private int characterId;
    private byte[] jpegData;
    
    public DefineBitsTag() {
        this.recordHeader.setTagCode(6);
    }
    
    /**
     * constructer </br>
     * Before version 8 of the SWF file format, 
     * SWF files could contain an erroneous header of 0xFF, 0xD9, 0xFF, 0xD8 before the JPEG SOI marker.
     * @param recordHeader
     */
    public DefineBitsTag(RecordHeader recordHeader) {
        this.recordHeader = new RecordHeader();
        this.recordHeader.setTagCode(recordHeader.getTagCode());
        this.recordHeader.setTagLength(recordHeader.getTagLength());
    }
    
    @Override
    public void readData(LoadSwfInputStream loadSwfIs) throws IOException {
        characterId = loadSwfIs.readUI16();
        jpegData = loadSwfIs.readUI8Array(recordHeader.getTagLength() - 2);
    }
    
    @Override
    public String toString() {
        return "[DefineBits]\n" + "characterId: " + characterId + "\njpegData: " + jpegData.length + "bytes";
    }    
}
