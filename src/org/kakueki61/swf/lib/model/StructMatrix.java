package org.kakueki61.swf.lib.model;

public class StructMatrix {
    
    private boolean hasScale;
    private int nScaleBits;     //UB[5]
    private double xScale;         //FB[nScaleBits]
    private double yScale;         
    private boolean hasRotate;      //UB[1]
    private int nRotateBits;    //UB[5]
    private double rotateSkew0;    //FB[nRotateBits]
    private double rotateSkew1;    //
    private int nTranslateBits; //UB[5]
    private int xTranslate;     //SB[nTranslateBits]
    private int yTranslate;     //
    private int bitLength;
    
    public StructMatrix() {
        hasScale = false;
        hasRotate = false;
        xScale = 1;
        yScale = 1;
        rotateSkew0 = 0;
        rotateSkew1 = 0;
        xTranslate = 0;
        yTranslate = 0;
    }
    
    @Override
    public String toString() {
        return "|" + xScale + ", " + rotateSkew0 + ", " + xTranslate + "|\n"
                + "|" + rotateSkew1 + ", " + yScale + ", " + yTranslate + "|";
    }

    public boolean hasScale() {
        return hasScale;
    }

    public void setHasScale(boolean hasScale) {
        this.hasScale = hasScale;
    }

    public int getnScaleBits() {
        return nScaleBits;
    }

    public void setnScaleBits(int nScaleBits) {
        this.nScaleBits = nScaleBits;
    }

    public double getxScale() {
        return xScale;
    }

    public void setxScale(double xScale) {
        this.xScale = xScale;
    }

    public double getyScale() {
        return yScale;
    }

    public void setyScale(double yScale) {
        this.yScale = yScale;
    }

    public boolean hasRotate() {
        return hasRotate;
    }

    public void setHasRotate(boolean hasRotate) {
        this.hasRotate = hasRotate;
    }

    public int getnRotateBits() {
        return nRotateBits;
    }

    public void setnRotateBits(int nRotateBits) {
        this.nRotateBits = nRotateBits;
    }

    public double getRotateSkew0() {
        return rotateSkew0;
    }

    public void setRotateSkew0(double rotateSkew0) {
        this.rotateSkew0 = rotateSkew0;
    }

    public double getRotateSkew1() {
        return rotateSkew1;
    }

    public void setRotateSkew1(double rotateSkew1) {
        this.rotateSkew1 = rotateSkew1;
    }

    public int getnTranslateBits() {
        return nTranslateBits;
    }

    public void setnTranslateBits(int nTranslateBits) {
        this.nTranslateBits = nTranslateBits;
    }

    public int getxTranslate() {
        return xTranslate;
    }

    public void setxTranslate(int xTranslate) {
        this.xTranslate = xTranslate;
    }

    public int getyTranslate() {
        return yTranslate;
    }

    public void setyTranslate(int yTranslate) {
        this.yTranslate = yTranslate;
    }
    
    public int getBitLength() {
        return bitLength;
    }
    
    public void setBitLength(int bitLength) {
        this.bitLength = bitLength;
    }
}
