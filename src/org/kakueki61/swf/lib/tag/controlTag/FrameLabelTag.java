package org.kakueki61.swf.lib.tag.controlTag;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.kakueki61.swf.lib.io.LoadSwfInputStream;
import org.kakueki61.swf.lib.model.RecordHeader;
import org.kakueki61.swf.lib.model.StructString;
import org.kakueki61.swf.lib.tag.Tag;


public class FrameLabelTag extends Tag {
    private static final String TAG = FrameLabelTag.class.getSimpleName();
    
    private StructString structString;
    
    public FrameLabelTag(RecordHeader rh) {
        this.recordHeader = new RecordHeader();
        this.recordHeader.setTagCode(43);
        this.recordHeader.setTagLength(rh.getTagLength());
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
    
    public String getString() {
        try {
            return new String(structString.getStringArray(), "Shift_JIS");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void readData(LoadSwfInputStream loadSwfIs) throws IOException {
        structString = loadSwfIs.getString();
    }
    
    @Override
    public String toString() {
        return "[FrameLabel]\n" + this.recordHeader + "\n" + structString;
    }
}
