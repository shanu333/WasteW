package com.example.wasteW.MyScrolling;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * Created by Luffy on 4/20/2015.
 */
public class MyListView extends ListView implements AbsListView.OnScrollListener
{
    Toolbar _toolbar;
    boolean _scrollDown;
    float _toolbarH;
    
    public MyListView(Context context, Toolbar toolbar)
    {
        super(context);
        _toolbar = toolbar;
        setOnScrollListener(this);
        measureToolbar();
    }

    private void measureToolbar()
    {
        _toolbarH = _toolbar.getHeight();
    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState)
    {
        view.setOnTouchListener(new OnTouchListener()
        {
            private float mInitialX;
            private float mInitialY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mInitialX = event.getX();
                        mInitialY = event.getY();
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        final float x = event.getX();
                        final float y = event.getY();
                        final float yDiff = y - mInitialY;
                        if (yDiff > 0.0) {
                            //Log.d("mymy", "SCROLL DOWN");
                            ViewGroup.LayoutParams toolbarPar = _toolbar.getLayoutParams();
                            if(toolbarPar.height > 0)
                            {
                                float toScroll = Math.min(toolbarPar.height, yDiff);
                                toScroll /= 10;
                                toolbarPar.height -= toScroll;
                                _toolbar.setLayoutParams(toolbarPar);
                                float remainScroll = yDiff - toScroll;
                                scrollListBy((int)remainScroll);
                            }
                            break;

                        } else if (yDiff < 0.0) {
                            //Log.d("mymy", "SCROLL up");

                            break;

                        }
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
    {

    }
}
