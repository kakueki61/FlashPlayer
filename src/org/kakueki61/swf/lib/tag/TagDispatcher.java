package org.kakueki61.swf.lib.tag;

import org.kakueki61.swf.lib.model.RecordHeader;
import org.kakueki61.swf.lib.tag.controlTag.EndTag;
import org.kakueki61.swf.lib.tag.controlTag.FrameLabelTag;
import org.kakueki61.swf.lib.tag.controlTag.SetBackgroundColorTag;
import org.kakueki61.swf.lib.tag.definitionTag.DefineBitsJPEG2Tag;
import org.kakueki61.swf.lib.tag.definitionTag.DefineBitsJPEG3Tag;
import org.kakueki61.swf.lib.tag.definitionTag.DefineBitsTag;
import org.kakueki61.swf.lib.tag.definitionTag.DefineSpriteTag;
import org.kakueki61.swf.lib.tag.definitionTag.JPEGTablesTag;


public class TagDispatcher {
    private static final String TAG = TagDispatcher.class.getSimpleName();
    
    public static Tag getTagObject(RecordHeader recordHeader) {
        switch(recordHeader.getTagCode()) {
            case 0:
                return new EndTag(recordHeader);
            case 1:
                return new ShowFrameTag(recordHeader);
            case 4:
                return new PlaceObjectTag(recordHeader);
            case 5:
                return new RemoveObjectTag(recordHeader);
            case 6:
                return new DefineBitsTag(recordHeader);
            case 8:
                return new JPEGTablesTag(recordHeader);
            case 9:
                return new SetBackgroundColorTag(recordHeader);
            case 21:
                return new DefineBitsJPEG2Tag(recordHeader);
            case 26:
                return new PlaceObject2Tag(recordHeader);
            case 28:
                return new RemoveObject2Tag(recordHeader);
            case 35:
                return new DefineBitsJPEG3Tag(recordHeader);
            case 39:
                return new DefineSpriteTag(recordHeader);
            case 43:
                return new FrameLabelTag(recordHeader);
            default:
                break;
        }
        return new Tag(recordHeader);
    }
}
