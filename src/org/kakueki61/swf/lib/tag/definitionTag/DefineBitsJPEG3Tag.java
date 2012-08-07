package org.kakueki61.swf.lib.tag.definitionTag;


import java.io.IOException;

import org.kakueki61.swf.lib.io.LoadSwfInputStream;
import org.kakueki61.swf.lib.model.RecordHeader;
import org.kakueki61.swf.lib.tag.Tag;


public class DefineBitsJPEG3Tag extends Tag {
    /*
     * Defines fields
     */
    private int characterId;
    private int alphaDataOffset;
    private byte[] imageData;
    private byte[] bitmapAlphaData;
        
    public DefineBitsJPEG3Tag() {
        this.recordHeader.setTagCode(35);
    }
    
    public DefineBitsJPEG3Tag(RecordHeader recordHeader) {
        this.recordHeader = new RecordHeader();
        this.recordHeader.setTagCode(recordHeader.getTagCode());
        this.recordHeader.setTagLength(recordHeader.getTagLength());
    }
    
    public byte[] getImageData() {
        return imageData;
    }
    
    public byte[] getAlphaData() {
        return bitmapAlphaData;
    }
    
    @Override
    public void readData(LoadSwfInputStream loadSwfIs) throws IOException {
        characterId = loadSwfIs.readUI16();
        alphaDataOffset = loadSwfIs.readUI32();
        imageData = loadSwfIs.readUI8Array(alphaDataOffset);
        bitmapAlphaData = loadSwfIs.readUI8Array(recordHeader.getTagLength() - 2 - 4 - alphaDataOffset);
    }
    
    @Override
    public String toString() {
        return "[DefineBitsJPEG3]\n" + "characterId: " + characterId + "\nimageData: " 
                + imageData.length + "bytes" + ", bitmapAlphaData: " + bitmapAlphaData.length + "bytes";
    }    
}
