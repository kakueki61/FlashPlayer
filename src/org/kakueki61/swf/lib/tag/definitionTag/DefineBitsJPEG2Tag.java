package org.kakueki61.swf.lib.tag.definitionTag;


import java.io.IOException;

import org.kakueki61.swf.lib.io.LoadSwfInputStream;
import org.kakueki61.swf.lib.model.RecordHeader;
import org.kakueki61.swf.lib.tag.Tag;


public class DefineBitsJPEG2Tag extends Tag {
    /*
     * Defines fields
     */
    private int characterId;
    private byte[] imageData;
    
    public DefineBitsJPEG2Tag() {
        this.recordHeader.setTagCode(21);
    }
    
    public DefineBitsJPEG2Tag(RecordHeader recordHeader) {
        this.recordHeader = new RecordHeader();
        this.recordHeader.setTagCode(recordHeader.getTagCode());
        this.recordHeader.setTagLength(recordHeader.getTagLength());
    }
    
    public byte[] getImageData() {
        return imageData;
    }
    
    @Override
    public void readData(LoadSwfInputStream loadSwfIs) throws IOException {
        characterId = loadSwfIs.readUI16();
        imageData = loadSwfIs.readUI8Array(recordHeader.getTagLength() - 2);
    }
    
    @Override
    public String toString() {
        return "[DefineBitsJPEG2]\n" + "characterId: " + characterId + "\nimageData: " + imageData.length + "bytes";
    }
}
