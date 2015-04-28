package com.example.wasteW.ScrollView;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.example.wasteW.R;


public class ConvertedActivity extends ActionBarActivity implements MyObservableScrollView.Callbacks
{
    Toolbar _toolbar;
    MyObservableScrollView _myObservableScrollView;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convert_act_l2);
        _toolbar = (Toolbar) findViewById(R.id.tool_bar);
        _toolbar.setTitle("ABCDEFGHIJKL");
        _toolbar.setTitleTextColor(Color.parseColor("#00000000"));
        setSupportActionBar(_toolbar);

        _myObservableScrollView = (MyObservableScrollView)findViewById(R.id.scroll_view);
        _myObservableScrollView.setCallbacks(this);

    }


    @Override
    public void onScrollChanged(int scrollY, int oldScrollY)
    {
        float den = (_myObservableScrollView.computeVerticalScrollRange() - _myObservableScrollView.getHeight());
        float alpha = (float)scrollY/den;
        int intAlpha = (int) (alpha * 225);
        String hexAlpha = convertToHex(intAlpha);
        String color = "#" + hexAlpha + "000000";
        try
        {
            int col = Color.parseColor(color);
            _toolbar.setTitleTextColor(col);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void onDownMotionEvent()
    {

    }

    @Override
    public void onUpOrCancelMotionEvent()
    {

    }

    public String convertToHex(int a)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(a));
        if (sb.length() < 2) {
            sb.insert(0, '0'); // pad with leading zero if needed
        }
        String hex = sb.toString();
        return hex;
    }
}
