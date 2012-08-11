package org.kakueki61.swf.lib.model.shape;

public class StructLineStyleArray {
    /** UI8: Count of line styles */
    private int lineStyleCount;
    
    /** UI16: Extended count of line styles. Only if lineStyleCount = 0xFF */
    private int lineStyleCountExtended;
    
    /** Array of line styles. */
    private StructLineStyle[] lineStyles;
    
    /**
     * Overrides Object#toString() method.
     * Returns string value formatted (lineStyleCount, lineStyleCountExtended, content of lineStyles) style.
     */
    @Override
    public String toString() {
        String lineStylesString = "";
        for(int i = 0; i < lineStyles.length; i++) {
            lineStylesString += lineStyles[i].toString() + "\n";
        }
        return "LineStyleCount: " + lineStyleCount + ", ExtendedCount: " + lineStyleCountExtended 
                + "\n" + lineStylesString;
    }

    public int getLineStyleCount() {
        return lineStyleCount;
    }

    public void setLineStyleCount(int lineStyleCount) {
        this.lineStyleCount = lineStyleCount;
    }

    public int getStyleCountExtended() {
        return lineStyleCountExtended;
    }

    public void setStyleCountExtended(int styleCountExtended) {
        this.lineStyleCountExtended = styleCountExtended;
    }

    public StructLineStyle[] getLineStyles() {
        return lineStyles;
    }

    public void setLineStyles(StructLineStyle[] lineStyles) {
        this.lineStyles = lineStyles;
    }
}
