package org.kakueki61.swf.lib.model.shape;

import org.kakueki61.swf.lib.model.StructRGBA;

/**
 * A line style represents a width and color of a line.
 * 
 * @author <a href="mailto:t.kodama61@gmail.com">kakueki61</a> (t.kodama61@gmail.com)
 *
 */
public class StructLineStyle {
    /** UI16: Width of line in twips. */
    private int width;
    
    /** RGBA: Color value including alpha channel information for Shape3. */
    private StructRGBA color;
    
    /**
     * Overrides Object#toString() method.
     * Returns string value formatted (width, color) style.
     */
    @Override
    public String toString() {
        return "width: " + width + "twip, color: " + color; 
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public StructRGBA getColor() {
        return color;
    }

    public void setColor(StructRGBA color) {
        this.color = color;
    }
}
