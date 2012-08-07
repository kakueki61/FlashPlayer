package org.kakueki61.swf.lib.model;

public class StructRect {
    private static final String TAG = StructRect.class.getSimpleName();
    
    private int nBits;
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;
    
    public StructRect() {
        nBits = 0;
        xMin = 0;
        xMax = 0;
        yMin = 0;
        yMax = 0;
    }
    
    /**
     * Overrides Object#toString() method.
     * Returns string value formatted (xMin, xMax, yMin, yMax) style.
     */
    @Override
    public String toString() {
        return "nBits: " + nBits + "\n" + "Rect: " + xMin + ", " + xMax + ", " + yMin + ", " + yMax;
    }

    public int getnBits() {
        return nBits;
    }

    public void setnBits(int nBits) {
        this.nBits = nBits;
    }

    public int getxMin() {
        return xMin;
    }

    public void setxMin(int xMin) {
        this.xMin = xMin;
    }

    public int getxMax() {
        return xMax;
    }

    public void setxMax(int xMax) {
        this.xMax = xMax;
    }

    public int getyMin() {
        return yMin;
    }

    public void setyMin(int yMin) {
        this.yMin = yMin;
    }

    public int getyMax() {
        return yMax;
    }

    public void setyMax(int yMax) {
        this.yMax = yMax;
    }
}
