package org.kakueki61.swf.lib.model;

public class StructRGB {
    
    private int red;
    private int green;
    private int blue;
    
    public StructRGB() {
        red = green = blue = 0;
    }
    
    /**
     * Overrides Object#toString() method.
     * Returns string value formatted (red, green, blue) style
     */
    @Override
    public String toString() {
        return "RGB: " + red + ", " + green + ", " + blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
}
