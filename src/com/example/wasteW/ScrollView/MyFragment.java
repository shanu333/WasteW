package com.example.wasteW.ScrollView;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.wasteW.R;


public class MyFragment extends Fragment
{
    public static final String TAG = "MYFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.my_frag, container, false);
    }
}