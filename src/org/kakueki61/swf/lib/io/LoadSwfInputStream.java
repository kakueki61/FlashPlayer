package org.kakueki61.swf.lib.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.kakueki61.swf.lib.model.RecordHeader;
import org.kakueki61.swf.lib.model.StructClipActions;
import org.kakueki61.swf.lib.model.StructCxFormWithAlpha;
import org.kakueki61.swf.lib.model.StructFrameRate;
import org.kakueki61.swf.lib.model.StructMatrix;
import org.kakueki61.swf.lib.model.StructRGB;
import org.kakueki61.swf.lib.model.StructRect;
import org.kakueki61.swf.lib.model.StructString;
import org.kakueki61.swf.lib.tag.Tag;
import org.kakueki61.swf.lib.tag.TagDispatcher;
import org.kakueki61.swf.lib.utils.ReadBits;
import org.kakueki61.swf.lib.utils.ReadBytes;


public class LoadSwfInputStream extends InputStream {
    private static final String TAG = LoadSwfInputStream.class.getSimpleName();
    
    private static final int UPPER_FOR_SHORT_TAG_HEADER = 10;
    private static final int LOWER_FOR_SHORT_TAG_HEADER = 6;
    
    private InputStream is;
    
    public LoadSwfInputStream(InputStream is) {
        this.is = is;
    }
    
    @Override
    public int read() throws IOException {
        return is.read();
    }
    
    public int readUI8() throws IOException {
        return ReadBytes.readUI8(is);
    }
    public int readSI8() throws IOException {
        return ReadBytes.readSI8(is);
    }
    public int readUI16() throws IOException {
        return ReadBytes.readUI16(is);
    }
    public int readUI32() throws IOException {
        return ReadBytes.readUI32(is);
    }
    
    public int readUB(int nBits) throws IOException {
        return ReadBits.readUB(is, nBits);
    }
    public int readSB(int nBits) throws IOException {
        return ReadBits.readSB(is, nBits);
    }    
    public double readFB(int nBits) throws IOException {
        return ReadBits.readFB(is, nBits);
    }
    
    public void alignByte() {
        ReadBits.completeReadBits();
    }
    
    
    /**
     * skip to read n bytes data
     * @param n the number of bytes you want to skip
     * @throws IOException 
     */
    public void skip(int n) throws IOException {
        ReadBytes.readBytes(is, n);
    }
    
    /**
     * Reads nBytes of bytes from InputStream and stores them into an array which is returned.
     * @param nBytes        the number of bytes 
     * @return
     * @throws IOException
     */
    public byte[] readUI8Array(int nBytes) throws IOException {
        alignByte();
        
        byte[] array = new byte[nBytes];
        int readSize = is.read(array);
        if(readSize < nBytes) {
            throw new IOException("Failed to read " + nBytes + " bytes data. Only " + readSize + " bytes was read.");
        }
        return array;
    }
    
    @Override
    public void close() throws IOException {
        is.close();
    }
    
    public StructRect getRect() throws IOException {
        alignByte();
        
        StructRect rect = new StructRect();
        
        int nBits = readUB(5);
        rect.setnBits(nBits);
        
        int xMin = readSB(nBits);
        rect.setxMin(xMin);
        
        int xMax = readSB(nBits);
        rect.setxMax(xMax);
        
        int yMin = readSB(nBits);
        rect.setyMin(yMin);
        
        int yMax = readSB(nBits);
        rect.setyMax(yMax);
        
        return rect;
    }
    
    public StructFrameRate getFrameRate() throws IOException {
        alignByte();
        
        StructFrameRate frameRate = new StructFrameRate();
        
        int fractional = read();
        frameRate.setFractionalPotion(fractional);
        
        int integer = read();
        frameRate.setIntegerPotion(integer);
        
        return frameRate;
    }
    
    public Tag getTagObj() throws IOException {
        
        RecordHeader recordHeader = new RecordHeader();
        
        int v = readUI16();
        
        recordHeader.setTagCode(v >> LOWER_FOR_SHORT_TAG_HEADER);
        
        int mask = 0x0000ffff >> UPPER_FOR_SHORT_TAG_HEADER;
        int tagLength = v & mask;
        //short or long ?
        if(tagLength != 0x3f) { //short
            recordHeader.setTagLength(tagLength);
        }else {                 //long
            recordHeader.setTagLength(ReadBytes.readUI32(is));
        }
        Tag tagObj = TagDispatcher.getTagObject(recordHeader);
        return tagObj;
    }
    
    public StructRGB getRGB() throws IOException {
        alignByte();
        
        StructRGB rgb = new StructRGB();
        rgb.setRed(readUI8());
        rgb.setGreen(readUI8());
        rgb.setBlue(readUI8());
        
        return rgb;
    }

    //TODO 要検討：int[]とbyte[]の違い。int[]でいいの？
    /*
    public StructString getString(int length) throws IOException {
        ReadBits.completeReadBits();
        
        StructString structString = new StructString();

        int[] stringArray = new int[length];
        boolean isContinue = true;
        int index = 0;
        while(isContinue && index < length) {
            stringArray[index] = readUI8();
            index++;
            if(stringArray[index] == 0) {
                isContinue = false;
            }
        }
        structString.setStringArray(stringArray);
        return structString;
    }
    */
    
    public StructString getString() throws IOException {
        alignByte();
        
        //for debugging 
        int count = 0;
        
        StructString structString = new StructString();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int v;
        while((v = readUI8()) != 0) {
            baos.write(v);              //v(int:符号付き4バイト整数値)の下位1バイトが書き込まれる
            count += 8;
        }
        count += 8;
        byte[] stringByteArray = baos.toByteArray();
        structString.setStringArray(stringByteArray);
        baos.close();
        
        structString.setBitLength(count);
        
        return structString;
    }
    
    /**
     * Reads Matrix and returns StructMatrix object
     * @return  StructMatrix
     * @throws IOException
     */
    public StructMatrix getMatrix() throws IOException {
        alignByte();
        
        StructMatrix matrix = new StructMatrix();
        
        //for debugging
        int count = 0;
        
        matrix.setHasScale(readUB(1) == 1);
        count++;
        if(matrix.hasScale()) {
            int nScaleBits = readUB(5);
            matrix.setxScale(readFB(nScaleBits));
            matrix.setyScale(readFB(nScaleBits));
            count += 5 + nScaleBits * 2;
        }
        
        matrix.setHasRotate(readUB(1) == 1);
        count++;
        if(matrix.hasRotate()) {
            int nRotateBits = readUB(5);
            matrix.setRotateSkew0(readFB(nRotateBits));
            matrix.setRotateSkew1(readFB(nRotateBits));
            count += 5 + nRotateBits * 2;
        }
        
        int nTranslateBits = readUB(5);
        matrix.setxTranslate(readSB(nTranslateBits));
        matrix.setyTranslate(readSB(nTranslateBits));
        count += 5 + nTranslateBits * 2;
        
        matrix.setBitLength(count);
        
        return matrix;
    }
    
    public StructCxFormWithAlpha getCxFormWithAlpha() throws IOException {
        alignByte();
        
        StructCxFormWithAlpha cxFormWithAlpha = new StructCxFormWithAlpha();
        
        int count = 0;
        
        boolean hasAddTerms = readUB(1) == 1;
        boolean hasMultTerms = readUB(1) == 1;
        
        int nBits = readUB(4);
        
        count = 6;
        
        if(hasMultTerms) {
            cxFormWithAlpha.setRedMultTerm(readSB(nBits));
            cxFormWithAlpha.setGreenMultTerm(readSB(nBits));
            cxFormWithAlpha.setBlueMultTerm(readSB(nBits));
            cxFormWithAlpha.setAlphaMultTerm(readSB(nBits));
            count += 4 * nBits;
        }
        if(hasAddTerms) {
            cxFormWithAlpha.setRedAddTerm(readSB(nBits));
            cxFormWithAlpha.setGreenAddTerm(readSB(nBits));
            cxFormWithAlpha.setBlueAddTerm(readSB(nBits));
            cxFormWithAlpha.setAlphaAddTerm(readSB(nBits));
            count += 4 * nBits;
        }
        
        cxFormWithAlpha.setBitLength(count);
        
        return cxFormWithAlpha;
    }
    
    public StructClipActions getClipActions(int nBytes) throws IOException {
        alignByte();
        
        StructClipActions clipActions = new StructClipActions();
        clipActions.setByteLength(nBytes);
        
        skip(nBytes);
        
        return clipActions;
    }
}
