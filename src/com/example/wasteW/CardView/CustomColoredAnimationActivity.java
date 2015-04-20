package com.example.wasteW.CardView;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.example.wasteW.R;
import com.example.wasteW.view.CustomColoredView;

/**
 * Created by Luffy on 4/3/2015.
 */
public class CustomColoredAnimationActivity extends Activity
{
    LinearLayout _container;
    Button _add;
    Button _del;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_colored_animation);
        _container = (LinearLayout)findViewById(R.id.container);
        _add = (Button)findViewById(R.id.add_new);
        _del = (Button)findViewById(R.id.del_new);
        _add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                addNewView();
            }
        });
        _del.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                delNewView();
            }
        });
        LayoutTransition layoutTransition = _container.getLayoutTransition();
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING);
    }

    private void delNewView()
    {
        _container.removeViewAt(_container.getChildCount() - 1);
    }

    private void addNewView()
    {
        CustomColoredView newView = new CustomColoredView(this);
        _container.addView(newView);
    }

}