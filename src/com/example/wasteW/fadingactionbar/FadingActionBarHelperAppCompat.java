/*
 * Copyright (C) 2013 Manuel Peinado
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.wasteW.fadingactionbar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

public final class FadingActionBarHelperAppCompat extends FadingActionBarHelperBases
{

    private ActionBar mActionBar;
    private Toolbar _toolbar;

    @Override
    public void initActionBar(Activity activity) {
        mActionBar = getActionBar(activity);
        super.initActionBar(activity);
    }

    private ActionBar getActionBar(Activity activity) {
        if (activity instanceof ActionBarActivity) {
            return ((ActionBarActivity) activity).getSupportActionBar();
        }
        ActionBar actionBar = getActionBarWithReflection(activity, "getSupportActionBar");
        if (actionBar == null) {
            throw new RuntimeException("Activity should derive from ActionBarActivity "
                + "or implement a method called getSupportActionBar");
        }
        return actionBar;
    }

    @Override
    protected int getActionBarHeight() {
        return mActionBar.getHeight();
    }

    @Override
    protected boolean isActionBarNull() {
        return mActionBar == null;
    }

    @Override
    protected void setActionBarBackgroundDrawable(Drawable drawable) {
        mActionBar.setBackgroundDrawable(drawable);
    }

    @Override
    protected void setAlphaForToolbarTitle(int newAlpha)
    {
        if(_toolbar == null)
        {
            return;
        }
        Log.d("mymy", "came here");
        _toolbar.setTitleTextColor(getColor(newAlpha));
    }

    public int getColor(int alpha)
    {
        String str = "#";
        str = str + convertHex(alpha);
        str += "000000";
        Log.d("mymy", str);
        return Color.parseColor(str);
    }

    private String convertHex(int alpha)
    {
        alpha = 255 * alpha;
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(alpha));
        if (sb.length() < 2) {
            sb.insert(0, '0'); // pad with leading zero if needed
        }
        String hex = sb.toString();
        return hex;
    }
}
