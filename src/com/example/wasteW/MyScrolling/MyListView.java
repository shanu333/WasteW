package com.example.wasteW.MyScrolling;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * Created by Luffy on 4/20/2015.
 */
public class MyListView extends ListView implements AbsListView.OnScrollListener
{
    Toolbar _toolbar;
    public MyListView(Context context, Toolbar toolbar)
    {
        super(context);
        _toolbar = toolbar;
        setOnScrollListener(this);
    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState)
    {
        
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
    {

    }
}
