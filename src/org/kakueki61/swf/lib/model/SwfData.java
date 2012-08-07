package org.kakueki61.swf.lib.model;

import org.kakueki61.swf.lib.tag.Tag;
import org.kakueki61.swf.lib.tag.definitionTag.DefineBitsJPEG2Tag;

public class SwfData {
    private boolean isCompressed;
    private int version;
    private int fileLength;
    private StructRect frameSize;
    private StructFrameRate frameRate;
    private int frameCount;
    
    private Tag[] tags = null;
    private String fileName;
    
    public SwfData() {
        isCompressed = false;
    }
    
    @Override
    public String toString() {
        String tagString = "";
        for(int i = 0; i < tags.length; i++) {
            tagString += tags[i].toString() + "\n";
        }
        
        return "isCompressed: " + isCompressed + "\n"
                + "version: " + version + "\n"
                + "fileLength: " + fileLength + "\n"
                + "frameSize: " + frameSize + "\n"
                + "frameRate: " + frameRate.getIntegerPotion() + "." + frameRate.getFractionalPotion() + "\n"
                + "frameCount: " + frameCount + "\n"
                + tagString;
    }
    
    public DefineBitsJPEG2Tag getJpeg2() {
        for(int i = 0; i < tags.length; i++) {
            if(tags[i].getTagCode() == 21) {
                return (DefineBitsJPEG2Tag)tags[i];
            }
        }
        return null;
    }

    public boolean isCompressed() {
        return isCompressed;
    }

    public void setCompressed(boolean isCompressed) {
        this.isCompressed = isCompressed;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getFileLength() {
        return fileLength;
    }

    public void setFileLength(int fileLength) {
        this.fileLength = fileLength;
    }

    public StructRect getFrameSize() {
        return frameSize;
    }

    public void setFrameSize(StructRect frameSize) {
        this.frameSize = frameSize;
    }

    public StructFrameRate getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(StructFrameRate frameRate) {
        this.frameRate = frameRate;
    }

    public int getFrameCount() {
        return frameCount;
    }

    public void setFrameCount(int frameCount) {
        this.frameCount = frameCount;
    }

    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
