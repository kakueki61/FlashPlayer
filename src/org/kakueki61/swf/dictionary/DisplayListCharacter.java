package org.kakueki61.swf.dictionary;

import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.Matrix;

abstract class DisplayListCharacter extends BasicCharacter {
    private static final String TAG = DisplayListCharacter.class.getSimpleName();
    
    Matrix matrix;
    ColorMatrix colorMatrix;
    int clipDepth;
    String name;
    
    protected boolean isSwfInstance = false;
    
    MainSprite mainSprite;
    DisplayListCharacter parent;
    
    /**
     * Overrides this method.
     */
    public void updateDisplayList() {
        
    }
    
    public void dispose() {
        mainSprite = null;
        parent = null;
        matrix = null;
        colorMatrix = null;
        name = null;
        isSwfInstance = false;
    }
    
    abstract public void draw(Canvas canvas, ColorMatrix colorMatrix);
}
