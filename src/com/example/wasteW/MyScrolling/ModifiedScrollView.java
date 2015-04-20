package com.example.wasteW.MyScrolling;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.example.wasteW.R;

public class ModifiedScrollView extends ActionBarActivity
{
    @InjectView(R.id.toolbar)
    Toolbar _toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modified_scroll_view);
        ButterKnife.inject(this);
        _toolbar.setTitle("haha");
        setSupportActionBar(_toolbar);
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