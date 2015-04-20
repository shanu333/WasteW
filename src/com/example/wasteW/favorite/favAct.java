package com.example.wasteW.favorite;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.example.wasteW.R;

/**
 * Created by Luffy on 4/3/2015.
 */
public class favAct extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fav);
        ImageView _favImg = (ImageView)findViewById(R.id.fav_item);
        _favImg.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ((ImageView)v).setImageResource(R.drawable.favorites_saved);
                scale(v);
            }
        });
    }

    protected void scale(View _scale)
    {
        PropertyValuesHolder pvhx = PropertyValuesHolder.ofFloat(View.SCALE_X, 2f);
        PropertyValuesHolder pvhy = PropertyValuesHolder.ofFloat(View.SCALE_Y, 2f);
        final ObjectAnimator scaleAnimator = ObjectAnimator.ofPropertyValuesHolder(_scale, pvhx, pvhy);
        scaleAnimator.setRepeatCount(1);
        scaleAnimator.setDuration(500);
        scaleAnimator.setRepeatMode(ValueAnimator.REVERSE);
        scaleAnimator.start();
    }
}