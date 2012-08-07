package org.kakueki61.swf;

import org.kakueki61.swf.lib.model.SwfData;
import org.kakueki61.swf.lib.tag.definitionTag.DefineBitsJPEG2Tag;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class SwfView extends SurfaceView implements Callback, Runnable {
    private static final String TAG = SwfView.class.getSimpleName();
    private int playState;
    
    public static final int STATE_END = 0;
    public static final int STATE_PLAYING = 1;
    
    Thread thread;
    
    SwfData swfData = null;
    
    public SwfView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }
    
    @Override
    public void run() {
        Canvas canvas;
        
        playState = STATE_PLAYING;
        while(playState != STATE_END) {
            //TODO ï`âÊèàóù
            canvas = getHolder().lockCanvas();
            if(canvas != null) {
              //TODO canvasÇ…ï`âÊÇ∑ÇÈèàóù
                if(swfData != null) {
                    DefineBitsJPEG2Tag jpeg2 = swfData.getJpeg2();
                    
                    canvas.drawBitmap((new AnalyzeJpeg(jpeg2)).bitmap, 0, 0, null);
                }
                
                
                
                getHolder().unlockCanvasAndPost(canvas);
            }
            //TODO sleepèàóù
            
        }
    }
    
    public void setSwfData(SwfData swfData) {
        if(swfData != null) {
            this.swfData = swfData; 
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        playState = STATE_END;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
