package org.kakueki61.swf.lib.tag.definitionTag;


import java.io.IOException;

import org.kakueki61.swf.lib.io.LoadSwfInputStream;
import org.kakueki61.swf.lib.model.RecordHeader;
import org.kakueki61.swf.lib.tag.Tag;


public class JPEGTablesTag extends Tag {
    /*
     * Defines fields
     */
    private byte[] jpegData;
    
    public JPEGTablesTag() {
        this.recordHeader.setTagCode(8);
    }
    
    public JPEGTablesTag(RecordHeader recordHeader) {
        this.recordHeader = new RecordHeader();
        this.recordHeader.setTagCode(recordHeader.getTagCode());
        this.recordHeader.setTagLength(recordHeader.getTagLength());
    }
    
    @Override
    public void readData(LoadSwfInputStream loadSwfIs) throws IOException {
        jpegData = loadSwfIs.readUI8Array(recordHeader.getTagLength());
    }
    
    @Override
    public String toString() {
        return "[JPEGTables]\n" + "jpegData: " + jpegData.length + "bytes";
    }
}
