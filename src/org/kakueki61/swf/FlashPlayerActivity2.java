package org.kakueki61.swf;

import org.kakueki61.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class FlashPlayerActivity2 extends Activity {
    /** Called when the activity is first created. */
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        
        Intent intent = getIntent();
        Bitmap bitmap = intent.getParcelableExtra("test");
        
        ((ImageView)findViewById(R.id.image)).setImageBitmap(bitmap);
    }
}