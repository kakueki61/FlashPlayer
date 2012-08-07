package org.kakueki61.swf.lib.model;

public class StructFrameRate {
    private static final String TAG = StructFrameRate.class.getSimpleName();
    
    private int fractionalPotion;
    private int integerPotion;
    
    public StructFrameRate() {
        this.fractionalPotion = 0;
        this.integerPotion = 0;
    }

    public int getFractionalPotion() {
        return fractionalPotion;
    }

    public void setFractionalPotion(int fractionalPotion) {
        this.fractionalPotion = fractionalPotion;
    }

    public int getIntegerPotion() {
        return integerPotion;
    }

    public void setIntegerPotion(int integerPotion) {
        this.integerPotion = integerPotion;
    }
}
