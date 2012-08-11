package org.kakueki61.swf.lib.model.shape;

public class StructLineStyleArray {
    /** UI8: Count of line styles */
    private int lineStyleCount;
    
    /** UI16: Extended count of line styles. Only if lineStyleCount = 0xFF */
    private int styleCountExtended;
    
    /** Array of line styles. */
    private StructLineStyle[] lineStyles;
    
    /**
     * Overrides Object#toString() method.
     * Returns string value formatted (...) style.
     */
    @Override
    public String toString() {
        return "";
    }

    public int getLineStyleCount() {
        return lineStyleCount;
    }

    public void setLineStyleCount(int lineStyleCount) {
        this.lineStyleCount = lineStyleCount;
    }

    public int getStyleCountExtended() {
        return styleCountExtended;
    }

    public void setStyleCountExtended(int styleCountExtended) {
        this.styleCountExtended = styleCountExtended;
    }

    public StructLineStyle[] getLineStyles() {
        return lineStyles;
    }

    public void setLineStyles(StructLineStyle[] lineStyles) {
        this.lineStyles = lineStyles;
    }
}
