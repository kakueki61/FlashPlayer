package org.kakueki61.swf.lib.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.kakueki61.swf.lib.model.RecordHeader;
import org.kakueki61.swf.lib.model.StructFrameRate;
import org.kakueki61.swf.lib.model.StructRect;


public class AnalyzeStruct {
    private static final String TAG = AnalyzeStruct.class.getSimpleName();
    
    private static final int UPPER_FOR_SHORT_TAG_HEADER = 10;
    private static final int LOWER_FOR_SHORT_TAG_HEADER = 6;

    
    public static StructRect getRect(FileInputStream fis) throws IOException {
        ReadBits.completeReadBits();
        
        StructRect rect = new StructRect();
        
        int nBits = ReadBits.readUB(fis, 5);
        rect.setnBits(nBits);
        
        int xMin = ReadBits.readSB(fis, nBits);
        rect.setxMin(xMin);
        
        int xMax = ReadBits.readSB(fis, nBits);
        rect.setxMax(xMax);
        
        int yMin = ReadBits.readSB(fis, nBits);
        rect.setyMin(yMin);
        
        int yMax = ReadBits.readSB(fis, nBits);
        rect.setyMax(yMax);
        
        return rect;
    }
    
    public static StructFrameRate getFrameRate(InputStream i) throws IOException {
        ReadBits.completeReadBits();
        
        StructFrameRate frameRate = new StructFrameRate();
        
        int fractional = i.read();
        frameRate.setFractionalPotion(fractional);
        
        int integer = i.read();
        frameRate.setIntegerPotion(integer);
        
        return frameRate;
    }
    
    public static RecordHeader getRecordHeader(InputStream is) throws IOException {
        
        RecordHeader recordHeader = new RecordHeader();
        
        int v = ReadBytes.readUI16(is);
        
        recordHeader.setTagCode(v >> LOWER_FOR_SHORT_TAG_HEADER);
        
        int mask = 0x0000ffff >> UPPER_FOR_SHORT_TAG_HEADER;
        int tagLength = v & mask;
        //short or long ?
        if(tagLength != 0x3f) { //short
            recordHeader.setTagLength(tagLength);
        }else {                 //long
            recordHeader.setTagLength(ReadBytes.readUI32(is));
        }
        return recordHeader;
    }
}
