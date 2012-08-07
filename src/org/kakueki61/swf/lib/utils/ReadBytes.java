package org.kakueki61.swf.lib.utils;

import java.io.IOException;
import java.io.InputStream;

public class ReadBytes {
    private static final String TAG = ReadBytes.class.getSimpleName();
    
    /**
     * Reads UI8 value(no need ?)
     * @param i
     * @return
     * @throws IOException
     */
    public static int readUI8(InputStream is) throws IOException {
        ReadBits.completeReadBits();
        
        return is.read();
    }
    
    /**
     * Reads 8 bit singned integer value. 
     * @param is
     * @return
     * @throws IOException
     */
    public static int readSI8(InputStream is) throws IOException {
        int v = readUI8(is);
        if((v & 0x80) != 0) {       //0x80 -> 1000 0000 でマスクして最上位ビットを確認する
            v |= 0xffffff00;
        }
        return v;
    }
    
    public static byte[] readUI8Array(InputStream is, int nBytes) throws IOException {
        ReadBits.completeReadBits();
        
        byte[] array = new byte[nBytes];
        int readSize = is.read(array);
        if(readSize < nBytes) {
            throw new IOException("Failed to read " + nBytes + " bytes data. Only " + readSize + " bytes was read.");
        }
        return array;
    }
    /**
     * UI16値を読み込む
     * @param i
     * @return
     * @throws IOException
     */
    public static int readUI16(InputStream is) throws IOException {
        ReadBits.completeReadBits();
        
        int v = is.read();   //1バイト目を読み込んで格納
        int w = is.read() << 8;
        int x = v | w;
        return x;
    }
    
    public static int readUI32(InputStream is) throws IOException{
        ReadBits.completeReadBits();
        
        int v = is.read();
        v |= is.read() << 8;
        v |= is.read() << 16;
        v |= is.read() << 24;
        return v;
    }    
    
    public static void readBytes(InputStream is, int nBytes) throws IOException {
        ReadBits.completeReadBits();
        
        int v = 0;
        for(int n = 0; n < nBytes; n++) {
            v = is.read();
            //System.out.print(v + "/");
        }
        //System.out.println();
    }
}
