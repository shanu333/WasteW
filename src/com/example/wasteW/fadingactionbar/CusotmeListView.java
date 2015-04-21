package com.example.wasteW.fadingactionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ListView;

/**
 * Created by Luffy on 4/21/2015.
 */
public class CusotmeListView extends ListView
{
    private int mMaxYOverscrollDistance;
    private static final int MAX_Y_OVERSCROLL_DISTANCE = 200;
    private Context mContext;

    public CusotmeListView(Context context)
    {
        super(context);
        mContext = context;
        initBounceListView();
    }

    public CusotmeListView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        mContext = context;
        initBounceListView();
    }

    public CusotmeListView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initBounceListView();
    }

    private void initBounceListView()
    {
        //get the density of the screen and do some maths with it on the max overscroll distance
        //variable so that you get similar behaviors no matter what the screen size

        final DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        final float density = metrics.density;

        mMaxYOverscrollDistance = (int) (density * MAX_Y_OVERSCROLL_DISTANCE);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent)
    {
        //This is where the magic happens, we have replaced the incoming maxOverScrollY with our own custom variable mMaxYOverscrollDistance;
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mMaxYOverscrollDistance, isTouchEvent);
    }


}
