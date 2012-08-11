package org.kakueki61.swf.lib.model.shape;

public class StructShapeWithStyle {
    
    private StructFillStyleArray fillStyles;
    private StructLineStyleArray lineStlyles;
    private int fillBits;
    private int lineBits;
    private StructShapeRecord[] shapeRecordes;
    
    public StructShapeWithStyle() {
        this.fillBits = 0;
        this.lineBits = 0;
    }
    
    /**
     * Overrides Object#toString() method.
     * Returns string value formatted (...) style.
     */
    @Override
    public String toString() {
        return "";
    }

    public StructFillStyleArray getFillStyles() {
        return fillStyles;
    }

    public void setFillStyles(StructFillStyleArray fillStyles) {
        this.fillStyles = fillStyles;
    }

    public StructLineStyleArray getLineStlyles() {
        return lineStlyles;
    }

    public void setLineStlyles(StructLineStyleArray lineStlyles) {
        this.lineStlyles = lineStlyles;
    }

    public int getFillBits() {
        return fillBits;
    }

    public void setFillBits(int fillBits) {
        this.fillBits = fillBits;
    }

    public int getLineBits() {
        return lineBits;
    }

    public void setLineBits(int lineBits) {
        this.lineBits = lineBits;
    }

    public StructShapeRecord[] getShapeRecordes() {
        return shapeRecordes;
    }

    public void setShapeRecordes(StructShapeRecord[] shapeRecordes) {
        this.shapeRecordes = shapeRecordes;
    }
}
