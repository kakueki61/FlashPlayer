package org.kakueki61.swf.lib.tag;


import java.io.IOException;

import org.kakueki61.swf.lib.io.LoadSwfInputStream;
import org.kakueki61.swf.lib.model.RecordHeader;
import org.kakueki61.swf.lib.model.StructClipActions;
import org.kakueki61.swf.lib.model.StructCxFormWithAlpha;
import org.kakueki61.swf.lib.model.StructMatrix;
import org.kakueki61.swf.lib.model.StructString;


public class PlaceObject2Tag extends Tag {
    private static final String TAG = PlaceObject2Tag.class.getSimpleName();
    
    /*
     * Defines any fields
     */
    //TODO ほとんどのやつは1ビットしかないんだからbyte型にすべき？
    private boolean hasClipActions = false;
    private boolean hasClipDepth = false;
    private boolean hasName = false;
    private boolean hasRatio = false;
    private boolean hasColorTransform = false;
    private boolean hasMatrix = false;
    private boolean hasCharacter = false;
    private boolean isMove = false;
    private int depth;
    private int characterId;
    private StructMatrix matrix;
    private StructCxFormWithAlpha colorTransform;
    private int ratio;
    private StructString name;
    private int clipDepth;
    private StructClipActions clipActions;
    
    /**
     * default constructor
     * Sets 24 to RecordHeader.tagCode.
     */
    public PlaceObject2Tag() {
        this.recordHeader.setTagCode(26);
    }
    
    public PlaceObject2Tag(RecordHeader recordHeader) {
        this.recordHeader = new RecordHeader();
        this.recordHeader.setTagCode(recordHeader.getTagCode());
        this.recordHeader.setTagLength(recordHeader.getTagLength());
    }
    
    @Override
    public void readData(LoadSwfInputStream loadSwfIs) throws IOException {
        int count = 0;
        
        hasClipActions = loadSwfIs.readUB(1) != 0 ? true : false;
        hasClipDepth = loadSwfIs.readUB(1) != 0 ? true : false;
        hasName = loadSwfIs.readUB(1) != 0 ? true : false;
        hasRatio = loadSwfIs.readUB(1) != 0 ? true : false;
        hasColorTransform = loadSwfIs.readUB(1) != 0 ? true : false;
        hasMatrix = loadSwfIs.readUB(1) != 0 ? true : false;
        hasCharacter = loadSwfIs.readUB(1) != 0 ? true : false;
        isMove = loadSwfIs.readUB(1) != 0 ? true : false;
        count += 8;
        depth = loadSwfIs.readUI16();
        count += 16;
        if(hasCharacter) {
            characterId = loadSwfIs.readUI16();
            count += 16;
        }
        if(hasMatrix) {
            matrix = loadSwfIs.getMatrix();
            count += matrix.getBitLength();
        }
        if(hasColorTransform) {
            colorTransform = loadSwfIs.getCxFormWithAlpha();
            count += colorTransform.getBitLength();
        }
        if(hasRatio) {
            ratio = loadSwfIs.readUI16();
            count += 16;
        }
        if(hasName) {
            name = loadSwfIs.getString();
            count += name.getBitLength();
        }
        if(hasClipDepth) {
            clipDepth = loadSwfIs.readUI16();
            count += 16;
        }
        
        int left = getTagLength() * 8 - count;
        //System.out.println("left: " + left + "bit");
        if(hasClipActions) {
            clipActions = loadSwfIs.getClipActions(left / 8);    
        }
    }
    
    @Override
    public String toString() {
        return "[PlaceObject2]\n" + "depth: " + depth + ", characterId: " + characterId + ", matrix: " + matrix + ", color: " + colorTransform
                + ", ratio: " + ratio + ", name: " + name + ", clipDepth: " + clipDepth + ", clipActions: " + clipActions + "Byte";
    }
}
