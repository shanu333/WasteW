package com.example.wasteW.window.transition;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.example.wasteW.CardView.CustomColoredAnimationActivity;
import com.example.wasteW.R;

/**
 * Created by Luffy on 4/3/2015.
 */
public class WindowTransitionActivity extends Activity
{
    Button _deafultTransition;
    Button _translateTransition;
    Button _scaleTransition;
    ImageView _bitmapTranistion;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.window_transition);
        _deafultTransition = (Button)findViewById(R.id.default_transition);
        _translateTransition= (Button) findViewById(R.id.translate_transition);
        _scaleTransition = (Button) findViewById(R.id.scale_transition);
        _deafultTransition.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                defaultTransition();
            }
        });
        _translateTransition.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateTranisition();
            }
        });
        _scaleTransition.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                scaleTransition(v);
            }
        });
        _bitmapTranistion = (ImageView)findViewById(R.id.bitmap_transition);
        _bitmapTranistion.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bitmapTransition();
            }
        });
    }

    private void bitmapTransition()
    {
        BitmapDrawable drawable = (BitmapDrawable)_bitmapTranistion.getDrawable();
        Bitmap bm = drawable.getBitmap();
        Intent intent = new Intent(this, CustomColoredAnimationActivity.class);
        Bundle scaleBundle = ActivityOptions.makeThumbnailScaleUpAnimation(_bitmapTranistion, bm, 0, 0).toBundle();
        startActivity(intent, scaleBundle);
    }

    private void scaleTransition(View v)
    {
        Intent intent = new Intent(this, CustomColoredAnimationActivity.class);
        Bundle scaleBundle = ActivityOptions.makeScaleUpAnimation(v, 0, 0,v.getWidth(), v.getHeight()).toBundle();
        startActivity(intent, scaleBundle);
    }

    private void translateTranisition()
    {
        Intent intent = new Intent(this, CustomColoredAnimationActivity.class);
        Bundle translateBundle = ActivityOptions.makeCustomAnimation(this, R.anim.slide_in_left, R.anim.slide_out_left).toBundle();
        startActivity(intent, translateBundle);
    }

    private void defaultTransition()
    {
        Intent intent = new Intent(this, CustomColoredAnimationActivity.class);
        startActivity(intent);
    }
}