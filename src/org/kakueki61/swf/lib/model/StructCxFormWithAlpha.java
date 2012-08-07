package org.kakueki61.swf.lib.model;

public class StructCxFormWithAlpha {
    private boolean hasAddTerms;
    private boolean hasMultTerms;
    private int nBits;
    private int redMultTerm;
    private int greenMultTerm;
    private int blueMultTerm;
    private int alphaMultTerm;
    private int redAddTerm;
    private int greenAddTerm;
    private int blueAddTerm;
    private int alphaAddTerm;
    private int bitLength;
    
    public StructCxFormWithAlpha() {
        hasAddTerms = false;
        hasMultTerms = false;
    }
    
    @Override
    public String toString() {
        return "Mult: " + redMultTerm + ", " + greenMultTerm + ", " + blueMultTerm + ", " + alphaMultTerm  + "\n"
                + "Add" + redAddTerm + ", " + greenAddTerm + ", " + blueAddTerm + ", " + alphaAddTerm;
    }
    
    public boolean hasAddTerms() {
        return hasAddTerms;
    }
    public void setHasAddTerms(boolean hasAddTerms) {
        this.hasAddTerms = hasAddTerms;
    }
    public boolean hasMultTerms() {
        return hasMultTerms;
    }
    public void setHasMultTerms(boolean hasMultTerms) {
        this.hasMultTerms = hasMultTerms;
    }
    public int getnBits() {
        return nBits;
    }
    public void setnBits(int nBits) {
        this.nBits = nBits;
    }
    public int getRedMultTerm() {
        return redMultTerm;
    }
    public void setRedMultTerm(int redMultTerm) {
        this.redMultTerm = redMultTerm;
    }
    public int getGreenMultTerm() {
        return greenMultTerm;
    }
    public void setGreenMultTerm(int greenMultTerm) {
        this.greenMultTerm = greenMultTerm;
    }
    public int getBlueMultTerm() {
        return blueMultTerm;
    }
    public void setBlueMultTerm(int blueMultTerm) {
        this.blueMultTerm = blueMultTerm;
    }
    public int getAlphaMultTerm() {
        return alphaMultTerm;
    }
    public void setAlphaMultTerm(int alphaMultTerm) {
        this.alphaMultTerm = alphaMultTerm;
    }
    public int getRedAddTerm() {
        return redAddTerm;
    }
    public void setRedAddTerm(int redAddTerm) {
        this.redAddTerm = redAddTerm;
    }
    public int getGreenAddTerm() {
        return greenAddTerm;
    }
    public void setGreenAddTerm(int greenAddTerm) {
        this.greenAddTerm = greenAddTerm;
    }
    public int getBlueAddTerm() {
        return blueAddTerm;
    }
    public void setBlueAddTerm(int blueAddTerm) {
        this.blueAddTerm = blueAddTerm;
    }
    public int getAlphaAddTerm() {
        return alphaAddTerm;
    }
    public void setAlphaAddTerm(int alphaAddTerm) {
        this.alphaAddTerm = alphaAddTerm;
    }

    public int getBitLength() {
        return bitLength;
    }

    public void setBitLength(int bitLength) {
        this.bitLength = bitLength;
    }
}
