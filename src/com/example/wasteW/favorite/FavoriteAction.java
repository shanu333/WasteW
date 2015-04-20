package com.example.wasteW.favorite;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.example.wasteW.R;

/**
 * Created by Luffy on 4/3/2015.
 */
public class FavoriteAction extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fav_two);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.favorites_saved);
        scale(imageView);
        item.setIcon(imageView.getDrawable());
        return super.onOptionsItemSelected(item);
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