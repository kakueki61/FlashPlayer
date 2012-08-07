package org.kakueki61.swf.lib.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.kakueki61.swf.lib.model.SwfData;
import org.kakueki61.swf.lib.tag.Tag;
import org.kakueki61.swf.lib.tag.definitionTag.DefineBitsJPEG2Tag;
import org.kakueki61.swf.lib.utils.SwfIOException;


public class StoreSwfData {
    private static final String TAG = StoreSwfData.class.getSimpleName();
    
    private SwfData swfData;
    private LoadSwfInputStream loadSwfIs;
    
    public StoreSwfData(LoadSwfInputStream loadSwfIs) {
        swfData = new SwfData();
        this.loadSwfIs = loadSwfIs;
    }
    
    public SwfData getSwfData() throws IOException, SwfIOException {
        swfData.setCompressed(loadSwfIs.read() == 'C');
        
        if(loadSwfIs.read() != 'W') {
            throw new SwfIOException("1st signature is not \'W\' !");
        }
        if(loadSwfIs.read() != 'S') {
            throw new SwfIOException("1st signature is not \'S\' !");
        }
        
        swfData.setVersion(loadSwfIs.read());
        swfData.setFileLength(loadSwfIs.readUI32());
        swfData.setFrameSize(loadSwfIs.getRect());
        swfData.setFrameRate(loadSwfIs.getFrameRate());
        swfData.setFrameCount(loadSwfIs.readUI16());
        
        //read Tags and stored to ArrayList of tags.
        List<Tag> tagList = new ArrayList<Tag>();
        Tag tag = loadSwfIs.getTagObj();
        while(tag.getTagCode() != 0) {
            tag.readData(loadSwfIs);
            tagList.add(tag);

            tag = loadSwfIs.getTagObj();
        }
        tagList.add(tag);
        
        swfData.setTags(tagList.toArray(new Tag[0]));
        
        loadSwfIs.close();
        
        return swfData;
    }
}
