package org.kakueki61.swf.lib.tag.definitionTag;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.kakueki61.swf.lib.io.LoadSwfInputStream;
import org.kakueki61.swf.lib.model.RecordHeader;
import org.kakueki61.swf.lib.tag.Tag;


public class DefineSpriteTag extends Tag {
    private int spriteId;
    private int frameCount;
    private Tag[] tags;
    
    private int count;
    private String tagString;
    
    public DefineSpriteTag() {
        this.recordHeader.setTagCode(39);
    }

    public DefineSpriteTag(RecordHeader recordHeader) {
        this.recordHeader = new RecordHeader();
        this.recordHeader.setTagCode(recordHeader.getTagCode());
        this.recordHeader.setTagLength(recordHeader.getTagLength());
    }
    
    public int getSpriteId() {
        return spriteId;
    }
    public int getFrameCount() {
        return frameCount;
    }
    public Tag[] getTags() {
        return tags;
    }
    
    @Override
    public void readData(LoadSwfInputStream loadSwfIs) throws IOException {
        spriteId = loadSwfIs.readUI16();
        frameCount = loadSwfIs.readUI16();
        
        count = 1;
        List<Tag> tagList = new ArrayList<Tag>();
        Tag tag = loadSwfIs.getTagObj();
        while(tag.getTagCode() != 0) {
            count++;
            
            tag.readData(loadSwfIs);
            tagList.add(tag);
            
            tag = loadSwfIs.getTagObj();
        }
        tagList.add(tag);
        
        tags = tagList.toArray(new Tag[0]);
        
        tagString = "";
        for(int i = 0; i < tags.length; i++) {
            tagString += "    " + tags[i] + "\n";
        }
    }
    
    @Override
    public String toString() {
        return "[DefineSprite]\n" + "spriteId: " + spriteId + ", frameCount: " + frameCount + "\n"
                + "    Tag[" + count + "]\n"
                + tagString;
    }   
}
