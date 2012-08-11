package org.kakueki61.swf.lib.model.shape;

import org.kakueki61.swf.lib.model.StructMatrix;
import org.kakueki61.swf.lib.model.StructRGBA;

public class StructFillStyle {
    
    /** 0x00: solid fill */
    public static final int SOLID_FILL_SYTLE = 0x00;
    /** 0x10: linear gradient fill */
    public static final int LINEAR_GRADIENT_FILL_STYLE = 0x10;
    /** 0x12: radical gradient fill  */
    public static final int RADIAL_GRADIENT_FILL_STYLE = 0x12;
    /** 0x13: focal radial gradient fill */
    public static final int FOCAL_RADIAL_GRADIENT_FILL_STYLE = 0x13;
    /** 0x40: repeating bitmap fill */
    public static final int REPEATING_BITMAP_FILL_STYLE = 0x40;
    /** 0x41: clipped bitmap fill */
    public static final int CLIPPED_BITMAP_FILL_STYLE = 0x41;
    /** 0x42: non_smoothed repeating bitmap */
    public static final int NON_SMOOTHED_REPEATING_BITMAP_STYLE = 0x42;
    /** 0x43: non_smoothed clipped bitmap */
    public static final int NON_SMOOTHED_CIPPED_BITMAP_STYLE = 0x43;
    
    /** 
     * Type of fill style
     * <ul>
     * <li>SOLID_FILL_STYLE
     * <li>LINEAR_GRADIENT_FILL_STYLE
     * <li>RADIAL_GRADIENT_FILL_STYLE
     * <li>FOCAL_RADIAL_GRADIENT_FILL_STYLE
     * <li>REPEATING_BITMAP_FILL_STYLE
     * <li>CIPPED_BITMAP_FILL_STYLE
     * <li>NON_SMOOTHED_REPEATING_BITMAP_STYLE
     * <li>NON_SMOOTHED_CLIPPED_BITMAP_STYLE
     * </ul>
     */
    private int fillStyleType;
    /**
     * Solid fill color with opacity in opacity</br>
     * Unless fillStyleType = SOLID_FILL_STYLE, this value is null.
     */
    private StructRGBA color;
    /**
     * Matrix for gradient fill.</br>
     * Unless fillStyleType = LINEAR_GRADIENT_FILL_STYLE 
     * or RADIAL_GRADIENT_FILL_STYLE or FOCAL_RAIAL_GRADIENT_FILL_STYLE,
     * this value is null. 
     */
    private StructMatrix gradientMatrix;
    /**
     * Gradient fill.</br>
     * If fillStyleType = LINEAR_GRADIENT_FILL_STYLE or RADIAL_GRADIENT_FILL_STYLE, this value is GRADIENT.</br>
     * IF fillStyleType = FOCAL_RADIAL_GRADIENT_FILL_STYLE, this value is FOCALGRADIENT.
     */
    private StructGradient gradient;
    /** 
     * ID of bitmap character for fill.</br>
     * Unless fillStyleType = REPEATING_BITMAP_FILL_STYLE, 
     * CIPPED_BITMAP_FILL_STYLE,
     * NON_SMOOTHED_REPEATING_BITMAP_STYLE or
     * NON_SMOOTHED_CLIPPED_BITMAP_STYLE, this value is null.
     */
    private int bitmapId;
    
    /** 
     * Matrix for bitmap fill.</br>
     * Unless fillStyleType = REPEATING_BITMAP_FILL_STYLE, 
     * CIPPED_BITMAP_FILL_STYLE,
     * NON_SMOOTHED_REPEATING_BITMAP_STYLE or
     * NON_SMOOTHED_CLIPPED_BITMAP_STYLE, this value is null.
     */
    private StructMatrix bitmapMatrix;
    
    /**
     * Overrides Object#toString() method.
     * Returns string value formatted (red, green, blue) style
     */
    @Override
    public String toString() {
        String str = "FillStyleType = ";
        switch(fillStyleType) {
            case SOLID_FILL_SYTLE:
                str += "solid (" + color + ")";
                break;
            case LINEAR_GRADIENT_FILL_STYLE:
                str += "linear gradient (" + gradientMatrix + ")";
                break;
            case RADIAL_GRADIENT_FILL_STYLE:
                str += "radial gradient (" + gradientMatrix + ")";
                break;
            case FOCAL_RADIAL_GRADIENT_FILL_STYLE:
                str += "focal radial gradient (" + gradientMatrix + ")";
                break;
            case REPEATING_BITMAP_FILL_STYLE:
                str += "repeating bitmap (ID=" + bitmapId + "\n" + bitmapMatrix + ")";
                break;
            case CLIPPED_BITMAP_FILL_STYLE:
                str += "clipped bitmap (ID=" + bitmapId + "\n" + bitmapMatrix + ")";
                break;
            case NON_SMOOTHED_REPEATING_BITMAP_STYLE:
                str += "non-smoothed repeating bitmap (ID=" + bitmapId + "\n" + bitmapMatrix + ")";
                break;
            case NON_SMOOTHED_CIPPED_BITMAP_STYLE:
                str += "non-smoothed clipped bitmap (ID=" + bitmapId + "\n" + bitmapMatrix + ")";
                break;
        }
        return str;
    }
    
    public int getFillStyleType() {
        return fillStyleType;
    }
    public void setFillStyleType(int fillStyleType) {
        this.fillStyleType = fillStyleType;
    }
    public StructRGBA getColor() {
        return color;
    }
    public void setColor(StructRGBA color) {
        this.color = color;
    }
    public StructMatrix getGradientMatrix() {
        return gradientMatrix;
    }
    public void setGradientMatrix(StructMatrix gradientMatrix) {
        this.gradientMatrix = gradientMatrix;
    }
    public StructGradient getGradient() {
        return gradient;
    }
    public void setGradient(StructGradient gradient) {
        this.gradient = gradient;
    }
    public int getBitmapId() {
        return bitmapId;
    }
    public void setBitmapId(int bitmapId) {
        this.bitmapId = bitmapId;
    }
    public StructMatrix getBitmapMatrix() {
        return bitmapMatrix;
    }
    public void setBitmapMatrix(StructMatrix bitmapMatrix) {
        this.bitmapMatrix = bitmapMatrix;
    }
}