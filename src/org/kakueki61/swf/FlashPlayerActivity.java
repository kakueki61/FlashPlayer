package org.kakueki61.swf;

import java.io.IOException;
import java.io.InputStream;

import org.kakueki61.R;
import org.kakueki61.swf.lib.io.LoadSwfInputStream;
import org.kakueki61.swf.lib.io.StoreSwfData;
import org.kakueki61.swf.lib.model.SwfData;
import org.kakueki61.swf.lib.tag.definitionTag.DefineBitsJPEG2Tag;
import org.kakueki61.swf.lib.utils.SwfIOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class FlashPlayerActivity extends Activity {
    /** Called when the activity is first created. */
    
    private SwfView swfView;
    private SwfData swfData = null;

    private boolean isLoaded = false;
    private boolean isChanged = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        swfView = new SwfView(this);
//        setContentView(swfView);
        
        setContentView(R.layout.main);
        
        

        
        findViewById(R.id.button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream is = getResources().openRawResource(R.raw.picture_fadeout);
                LoadSwfInputStream loadSwfIs = new LoadSwfInputStream(is);
                StoreSwfData storeSwfData = new StoreSwfData(loadSwfIs);
                try {
                    swfData = storeSwfData.getSwfData();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SwfIOException e) {
                    e.printStackTrace();
                }
                
                ((TextView)findViewById(R.id.text)).setText(swfData.toString());
                
                findViewById(R.id.button2).setEnabled(true);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                
                setContentView(R.layout.main2);
                
                DefineBitsJPEG2Tag jpeg2 = swfData.getJpeg2();
                ((ImageView)findViewById(R.id.image)).setImageBitmap(new AnalyzeJpeg(jpeg2).bitmap);
                
                findViewById(R.id.back).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), FlashPlayerActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
        
        if(isChanged) {
            
        }
    }
}