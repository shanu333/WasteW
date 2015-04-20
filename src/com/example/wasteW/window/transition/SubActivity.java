package com.example.wasteW.window.transition;

import android.app.Activity;
import android.os.Bundle;
import com.example.wasteW.R;

/**
 * Created by Luffy on 4/3/2015.
 */
public class SubActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);
    }

    @Override
    public void finish()
    {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
}