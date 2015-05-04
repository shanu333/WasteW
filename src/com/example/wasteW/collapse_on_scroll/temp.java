package com.example.wasteW.collapse_on_scroll;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.example.wasteW.R;


public class temp  extends Activity
{
    @InjectView(R.id.view)
    View view;
    @InjectView(R.id.up)
    Button up;
    @InjectView(R.id.down)
    Button down;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_layout);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.up)
    public void onUp()
    {
        view.animate().translationY(0);
    }

    @OnClick(R.id.down)
    public void onDown()
    {
        view.animate().translationY(view.getHeight());
    }
}