package com.example.wasteW.property;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import com.example.wasteW.R;

/**
 * Created by Luffy on 4/3/2015.
 */
public class PropertyAnimation extends Activity
{
    Button _rotate, _translate, _scale, _alpha, _set;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.property);
        _scale = (Button)findViewById(R.id.scaleT);
        _set = (Button)findViewById(R.id.setT);
        _rotate = (Button)findViewById(R.id.roatateT);
        _alpha = (Button)findViewById(R.id.alphaT);
        _translate = (Button)findViewById(R.id.translateT);
        initAnim();
    }


    private void initAnim()
    {
        final ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(_alpha, View.ALPHA, 0);
        alphaAnimation.setRepeatCount(1);
        alphaAnimation.setRepeatMode(ValueAnimator.REVERSE);

        final ObjectAnimator transAnimation = ObjectAnimator.ofFloat(_translate, View.TRANSLATION_X, 800);
        transAnimation.setRepeatCount(1);
        transAnimation.setRepeatMode(ValueAnimator.REVERSE);

        final ObjectAnimator rotateAnimation = ObjectAnimator.ofFloat(_rotate, View.ROTATION, 360);
        rotateAnimation.setRepeatCount(1);
        rotateAnimation.setRepeatMode(ValueAnimator.REVERSE);

        PropertyValuesHolder pvhx = PropertyValuesHolder.ofFloat(View.SCALE_X, 2);
        PropertyValuesHolder pvhy = PropertyValuesHolder.ofFloat(View.SCALE_Y, 2);
        final ObjectAnimator scaleAnimator = ObjectAnimator.ofPropertyValuesHolder(_scale, pvhx, pvhy);
        scaleAnimator.setRepeatCount(1);
        scaleAnimator.setRepeatMode(ValueAnimator.REVERSE);

        final AnimatorSet as = new AnimatorSet();
        as.play(transAnimation).after(alphaAnimation).before(rotateAnimation);
        as.play(rotateAnimation).before(scaleAnimator);

        _translate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                transAnimation.start();
            }
        });

        _rotate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                rotateAnimation.start();
            }
        });
        _scale.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                scaleAnimator.start();
            }
        });
        _alpha.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                alphaAnimation.start();
            }
        });
        _set.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                as.start();
            }
        });
    }
}