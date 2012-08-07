package org.kakueki61.swf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.InflaterOutputStream;

import org.kakueki61.swf.lib.tag.definitionTag.DefineBitsJPEG2Tag;
import org.kakueki61.swf.lib.tag.definitionTag.DefineBitsJPEG3Tag;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class AnalyzeJpeg {
    private static final String TAG = AnalyzeJpeg.class.getSimpleName();
    
    Bitmap bitmap;
    
    public AnalyzeJpeg(DefineBitsJPEG2Tag jpeg2) {
        bitmap = decodeJpeg(jpeg2.getImageData());
    }
    
    public AnalyzeJpeg(DefineBitsJPEG3Tag jpeg3) {
        bitmap = decodeJpeg(jpeg3.getImageData());
        try {
            byte[] alphaData = decodeZlib(jpeg3.getAlphaData(), bitmap.getWidth() * bitmap.getHeight());
            int[] pixels = new int[alphaData.length];
            bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            for(int i = 0; i < pixels.length; i++) {
                pixels[i] &= (alphaData[i] << 24) | 0x00ffffff;
            }
            bitmap = Bitmap.createBitmap(pixels, bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private Bitmap decodeJpeg(byte[] jpegByte) {
        ByteArrayInputStream bais = new ByteArrayInputStream(jpegByte);
        ByteArrayOutputStream baos = new ByteArrayOutputStream(jpegByte.length);
        
        boolean isStarted = false;
        
        /*
         * FFD8 -> SOI スタートマーカー
         * FFD9 -> EOI エンドマーカー
         */
        int v;
        while((v = bais.read()) != -1) {
            //マーカーを探す
            if(v == 0xff) {
                int w = bais.read();
                if(w == 0xd8) {         //SOI
                    if(!isStarted) {
                        baos.write(v);
                        baos.write(w);
                        isStarted = true;
                    }
                }else if(w == 0xd9) {
                    
                }else {
                    baos.write(v);
                    baos.write(w);
                }
            }else {
                baos.write(v);
            }
        }
        baos.write(0xff);
        baos.write(0xd9);
        jpegByte = baos.toByteArray();
        return BitmapFactory.decodeByteArray(jpegByte, 0, jpegByte.length);
    }
    
    private byte[] decodeZlib(byte[] byteZlib, int decodedSize) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(decodedSize);
        InflaterOutputStream ios = new InflaterOutputStream(baos);
        byte[] decodedData;
        ios.write(byteZlib);
        ios.flush();
        ios.close();
        decodedData = baos.toByteArray();
        baos.close();
        return decodedData;
    }
}
