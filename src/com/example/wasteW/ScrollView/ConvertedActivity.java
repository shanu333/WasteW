package com.example.wasteW.ScrollView;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import android.widget.TextView;
import com.example.wasteW.R;
import com.example.wasteW.collapse_on_scroll.CollapseOnScrollViewPager;


public class ConvertedActivity extends ActionBarActivity
{
    Toolbar _toolbar;
    CollapseOnScrollViewPager _myObservableScrollView;
    ViewPager _pager;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convert_act_l2);
        _toolbar = (Toolbar) findViewById(R.id.tool_bar);
        _toolbar.setTitle("ABCDEFGHIJKL");
        //_toolbar.setTitleTextColor(Color.parseColor("#00000000"));
        setSupportActionBar(_toolbar);
        initView();

        _myObservableScrollView = (CollapseOnScrollViewPager)findViewById(R.id.scroll_view);
        _myObservableScrollView._toolbar = _toolbar;
        _myObservableScrollView._toolbarBottom = findViewById(R.id.bottom);
        //_myObservableScrollView.setCallbacks(this);

    }

    private void initView()
    {
        _pager = (ViewPager)findViewById(R.id.pages);
        PagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new MyFragment();
                    case 1:
                        return new MyFragment();

                }
                return null;
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return getString(R.string.quick_return_item);
                    case 1:
                        return getString(R.string.sticky_item);
                }
                return null;
            }
        };
        _pager.setAdapter(adapter);
        /*_pager.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {

                return false;
            }
        });*/
    }


    /*@Override
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

    }*/



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
