package org.kakueki61.swf.dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.kakueki61.swf.lib.tag.Tag;
import org.kakueki61.swf.lib.tag.controlTag.FrameLabelTag;
import org.kakueki61.swf.lib.tag.definitionTag.DefineSpriteTag;

import android.graphics.Canvas;
import android.graphics.ColorMatrix;

public class BasicSprite extends DisplayListCharacter {
    private static final String TAG = BasicSprite.class.getSimpleName();
    
    private Tag[][] frames;
    private int currentFrame;
    private DisplayListCharacter[] displayList;
    private HashMap<String, Integer> frameLabelMap;
    private boolean isPlaying;
    private boolean visible;
    
    public BasicSprite() {
        frames = new Tag[2][0];
        currentFrame = 0;
        frameLabelMap = new HashMap<String, Integer>();
        isPlaying = true;
        visible = true;
    }
    
    @Override
    public DisplayListCharacter getInstance() {
        BasicSprite instance = new BasicSprite();
        instance.frameLabelMap = frameLabelMap;
        instance.frames = frames;
        instance.displayList = new DisplayListCharacter[128];
        return instance;
    }
    
    public BasicSprite(DefineSpriteTag spriteTag) {
        Tag[] tagTimeLine = spriteTag.getTags();
        frames = new Tag[spriteTag.getFrameCount() + 1][];
        //1フレーム分のリスト
        List<Tag> frameTags = new ArrayList<Tag>();
        int frameNo = 1;
        for(int i = 0; i < tagTimeLine.length; i++) {
            if(tagTimeLine[i].getTagCode() == 1) {          //ShowFrame
                frames[frameNo] = frameTags.toArray(new Tag[0]);
                frameNo++;
                frameTags.clear();
            }else if(tagTimeLine[i].getTagCode() == 0) {    //End
                break;
            }else if(tagTimeLine[i].getTagCode() == 43) {
                frameLabelMap.put(((FrameLabelTag)tagTimeLine[i]).getString(), frameNo);
            }else {
                frameTags.add(tagTimeLine[i]);
            }
        }
    }
    
    private void removeAll() {
        for(int i = 0; i < displayList.length; i++) {
            if(displayList[i] != null) {
                displayList[i].dispose();
                displayList[i] = null;
            }
        }
    }
    
    @Override
    public void updateDisplayList() {
        if(isPlaying) {
            update(false);
        }
        
        for(int i = 0; i < displayList.length; i++) {
            if(displayList[i] != null) {
                displayList[i].updateDisplayList();
            }
        }
    }

    private void update(boolean b) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void draw(Canvas canvas, ColorMatrix colorMatrix) {
        // TODO Auto-generated method stub
        
    }
}
