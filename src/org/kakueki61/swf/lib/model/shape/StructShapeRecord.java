package org.kakueki61.swf.lib.model.shape;

public class StructShapeRecord {
    /** 
     * Record flag.</br>
     * 0: Non-edge Records(EndShapeRecord, StyleChangeRecord)</br>
     * 1: Edge Records(StraightEdgeRecord, CurvedEdgeRecord)</br>
     */
    protected int typeFlag;
    
    public int getTypeFlag() {
        return typeFlag;
    }
    
    public void setTypeFlag(int typeFlag) {
        this.typeFlag = typeFlag;
    }
    
    /**
     * Overrides Object#toString() method.
     * Returns string value formatted (...) style.
     */
    @Override
    public String toString() {
        return "";
    }
}
