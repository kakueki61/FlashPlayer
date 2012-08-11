package org.kakueki61.swf.lib.model.shape;

public class StructFillStyleArray {
    
    private int fillStyleCount;
    private int fillStyleExtended;
    private StructFillStyle[] fillStyles;
    
    public StructFillStyleArray() {
        fillStyleCount = 0;
        fillStyleExtended = 0;
    }
    
    /**
     * Overrides Object#toString() method.
     * Returns string value formatted (...) style.
     */
    @Override
    public String toString() {
        return "";
    }

    public int getFillStyleCount() {
        return fillStyleCount;
    }

    public void setFillStyleCount(int fillStyleCount) {
        this.fillStyleCount = fillStyleCount;
    }

    public int getFillStyleExtended() {
        return fillStyleExtended;
    }

    public void setFillStyleExtended(int fillStyleExtended) {
        this.fillStyleExtended = fillStyleExtended;
    }

    public StructFillStyle[] getFillStyles() {
        return fillStyles;
    }

    public void setFillStyles(StructFillStyle[] fillStyles) {
        this.fillStyles = fillStyles;
    }
}
