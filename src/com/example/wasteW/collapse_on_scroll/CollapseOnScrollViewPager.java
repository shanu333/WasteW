package com.example.wasteW.collapse_on_scroll;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;
import com.example.wasteW.R;
import com.example.wasteW.ScrollView.MyFragment;

import java.util.List;


public class CollapseOnScrollViewPager extends CollapseOnScrollView
{
    ViewPager myViewPager;
    ScrollView scrollView;
    AttributeSet attrs;
    public Toolbar _toolbar;
    public View _toolbarBottom;
    int bottomHieght;

    public CollapseOnScrollViewPager(Context context)
    {
        super(context);
        initViewPager(null);
    }

    public CollapseOnScrollViewPager(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initViewPager(attrs);
    }

    public CollapseOnScrollViewPager(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        initViewPager(attrs);
    }

    @Override
    protected void onScrolling(int distance)
    {
        float den = (computeVerticalScrollRange() - getHeight());
        float alpha = (float) getScrollY() / den;
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
        bottomHieght = _toolbarBottom.getHeight();
        //Log.d("mymy", "" + distance);
        if (Math.abs(distance) != 0)
        {
            if (distance < 0)
            {
                // hide and animate bottom toolbar
                onUp(_toolbarBottom);

            } else
            {
                // show and animate bottom toolbar
                onDown(_toolbarBottom);
            }
        }
    }


    public void onUp(View view)
    {
        view.animate().translationY(0).alpha(1).setDuration(100);
    }


    public void onDown(View view)
    {
        view.animate().translationY(view.getHeight()).alpha(0).setDuration(50);
    }

    public String convertToHex(int a)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(a));
        if (sb.length() < 2)
        {
            sb.insert(0, '0'); // pad with leading zero if needed
        }
        String hex = sb.toString();
        return hex;
    }

    public void initViewPager(AttributeSet attrs)
    {
        this.attrs = attrs;
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CollapseOnScrollView);
        final int viewPagerId = typedArray.getResourceId(R.styleable.CollapseOnScrollView_scrollOnDragId, -1);
        typedArray.recycle();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
            @Override
            public void onGlobalLayout()
            {
                if (Build.VERSION.SDK_INT < 16)
                {
                    getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else
                {
                    getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

                if (viewPagerId >= 0)
                {
                    myViewPager = (ViewPager) findViewById(viewPagerId);
                    showCollapseOnDragViewByDefault(true);
                }

            }
        });
    }

    @Override
    protected ScrollView getScrollView()
    {
        scrollView = (ScrollView) findViewWithTag(MyFragment.TAG + myViewPager.getCurrentItem());
        return scrollView;
    }


}
