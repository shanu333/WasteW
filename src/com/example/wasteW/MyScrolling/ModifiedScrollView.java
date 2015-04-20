package com.example.wasteW.MyScrolling;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.example.wasteW.R;

public class ModifiedScrollView extends ActionBarActivity
{
    @InjectView(R.id.toolbar)
    Toolbar _toolbar;
    @InjectView(R.id.container)
    LinearLayout _container;

    MyListView _listView;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modified_scroll_view);
        ButterKnife.inject(this);
        _toolbar.setTitle("haha");
        setSupportActionBar(_toolbar);

        _listView = new MyListView(this, _toolbar);
        _listView.setAdapter(getAdapter());
        _container.addView(_listView);

    }

    private ListAdapter getAdapter()
    {
        String[] values = new String[]{"1", "2", "3", "4"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);
        return adapter;
    }

    @OnClick(R.id.reduce)
    public void reduceHeight()
    {
        ViewGroup.LayoutParams params = _toolbar.getLayoutParams();
        params.height -= 20;
        _toolbar.setLayoutParams(params);
        _toolbar.invalidate();
    }
}