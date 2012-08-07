package org.kakueki61.swf.lib.tag;

import org.kakueki61.swf.lib.io.LoadSwfInputStream;
import org.kakueki61.swf.lib.model.RecordHeader;


public class PlaceObjectTag extends Tag {
    private static final String TAG = PlaceObjectTag.class.getSimpleName();
    
    public PlaceObjectTag() {
        this.recordHeader.setTagCode(4);
    }
    
    public PlaceObjectTag(RecordHeader recordHeader) {
        this.recordHeader = new RecordHeader();
        this.recordHeader.setTagCode(recordHeader.getTagCode());
        this.recordHeader.setTagLength(recordHeader.getTagLength());
    }
    
    @Override
    public void readData(LoadSwfInputStream loadSwfIs) {
        
    }
    
    @Override
    public String toString() {
        return "[PlaceObject]\n" + this.recordHeader;
    }
}
