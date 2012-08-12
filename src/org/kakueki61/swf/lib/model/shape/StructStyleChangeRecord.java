package org.kakueki61.swf.lib.model.shape;

/**
 * It can be used to do the following:
 * <ol>
 * <li>Select a fill or line style for drawing.
 * <li>Move the current drawing position (without drawing).
 * <li>Replace the current fill and line style arrays with a new set of styles.
 * </ol>
 * 
 * @author <a href="mailto:t.kodama61@gmail.com">kakueki61</a> (t.kodama61@gmail.com)
 *
 */
public class StructStyleChangeRecord extends StructShapeRecord {
    
    /** UB[1]: New style flag. */
    private boolean stateNewStyles;
    /** UB[1]: Line style change flag. */
    private boolean stateLineStyle;
    /** UB[1]: Fill style 1 change flag. */
    private boolean stateFillStyle1;
    /** UB[1]: Fill style 0 change flag. */
    private boolean stateFillStyle0;
    /** UB[1]: Move to flag. */
    private boolean stateMoveTo;
    
    /** UB[5]: Move bit count if stateMoveTo is true */
    private int moveBits;
    /** SB[moveBits]: Delta X value if stateMoveTo is true. */
    private int moveDeltaX;
    /** SB[moveBits]: Delta Y value if stateMoveTo is true. */
    private int moveDeltaY;
    
    /** UB[FillBits]: Fill 0 Style if stateFillStyle0 is true. */
    private int fillStyle0;
    /** UB[FillBits]: Fill 1 Style if stateFillStyle1 is true. */
    private int fillStyle1;
    /** Array of new fill styles if stateNewStyles is true. */
    private StructFillStyleArray fillStyles;
    
    /** UB[LineBits]: Line Style if stateLineStyle is true. */
    private int lineStyle;
    /** Array of new line styles if stateNewStyles is true. */
    private StructLineStyleArray lineStyles;
    
    /** UB[4]: Number of fill index bits for new styles. */
    private int numFillBits;
    
    /** UB[4]: Number of line index bits for new styles. */
    private int numLineBits;
    
    public boolean isStateNewStyles() {
        return stateNewStyles;
    }

    public void setStateNewStyles(boolean stateNewStyles) {
        this.stateNewStyles = stateNewStyles;
    }

    public boolean isStateLineStyle() {
        return stateLineStyle;
    }

    public void setStateLineStyle(boolean stateLineStyle) {
        this.stateLineStyle = stateLineStyle;
    }

    public boolean isStateFillStyle1() {
        return stateFillStyle1;
    }

    public void setStateFillStyle1(boolean stateFillStyle1) {
        this.stateFillStyle1 = stateFillStyle1;
    }

    public boolean isStateFillStyle0() {
        return stateFillStyle0;
    }

    public void setStateFillStyle0(boolean stateFillStyle0) {
        this.stateFillStyle0 = stateFillStyle0;
    }

    public boolean isStateMoveTo() {
        return stateMoveTo;
    }

    public void setStateMoveTo(boolean stateMoveTo) {
        this.stateMoveTo = stateMoveTo;
    }

    public int getMoveBits() {
        return moveBits;
    }

    public void setMoveBits(int moveBits) {
        this.moveBits = moveBits;
    }

    public int getMoveDeltaX() {
        return moveDeltaX;
    }

    public void setMoveDeltaX(int moveDeltaX) {
        this.moveDeltaX = moveDeltaX;
    }

    public int getMoveDeltaY() {
        return moveDeltaY;
    }

    public void setMoveDeltaY(int moveDeltaY) {
        this.moveDeltaY = moveDeltaY;
    }

    public int getFillStyle0() {
        return fillStyle0;
    }

    public void setFillStyle0(int fillStyle0) {
        this.fillStyle0 = fillStyle0;
    }

    public int getFillStyle1() {
        return fillStyle1;
    }

    public void setFillStyle1(int fillStyle1) {
        this.fillStyle1 = fillStyle1;
    }

    public int getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(int lineStyle) {
        this.lineStyle = lineStyle;
    }

    public int getNumFillBits() {
        return numFillBits;
    }

    public void setNumFillBits(int numFillBits) {
        this.numFillBits = numFillBits;
    }

    public int getNumLineBits() {
        return numLineBits;
    }

    public void setNumLineBits(int numLineBits) {
        this.numLineBits = numLineBits;
    }

    public StructFillStyleArray getFillStyles() {
        return fillStyles;
    }

    public void setFillStyles(StructFillStyleArray fillStyles) {
        this.fillStyles = fillStyles;
    }

    public StructLineStyleArray getLineStyles() {
        return lineStyles;
    }

    public void setLineStyles(StructLineStyleArray lineStyles) {
        this.lineStyles = lineStyles;
    }
}
