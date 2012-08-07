package org.kakueki61.swf.lib.model;

import java.io.UnsupportedEncodingException;

public class StructString {
    private static final String TAG = StructString.class.getSimpleName();
    
    private byte[] stringByteArray;
    
    private int bitLength;
    
    public byte[] getStringArray() {
        return stringByteArray;
    }
    
    public void setStringArray(byte[] stringByteArray) {
        this.stringByteArray = stringByteArray;
    }
    
    public int getBitLength() {
        return bitLength;
    }
    
    public void setBitLength(int bitLength) {
        this.bitLength = bitLength;
    }
    
    /**
     * Overrides Object#toString() method.
     * Returns string value formatted (red, green, blue) style
     */
    @Override
    public String toString() {
        try {
            return "String: " + new String(stringByteArray, "Shift_JIS");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "UnsupportedEncoding !!";
        }
    }
}
