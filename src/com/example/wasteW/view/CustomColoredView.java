package com.example.wasteW.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Luffy on 4/3/2015.
 */
public class CustomColoredView extends View
{
    private boolean mExpanded = false;
    private LinearLayout.LayoutParams mCompressedParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 50);
    private LinearLayout.LayoutParams mExpandedParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
    public CustomColoredView(Context context)
    {
        super(context);
        int red = (int)(Math.random() * 128 + 127);
        int green = (int)(Math.random() * 128 + 127);
        int blue = (int)(Math.random() * 128 + 127);
        int color = 0xff << 24 | (red << 16) | (green << 8) | blue;
        setBackgroundColor(color);
        setLayoutParams(mCompressedParams);
        setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setLayoutParams(mExpanded ? mExpandedParams : mCompressedParams);
                mExpanded = !mExpanded;
                requestLayout();
            }
        });
    }
}
