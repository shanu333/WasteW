package com.example.wasteW.fadingactionbar;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.wasteW.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class TestActionBarActivity extends ActionBarActivity
{
    Toolbar _toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        _toolbar = (Toolbar)inflater.inflate(R.layout.new_layout,null);
        _toolbar.setTitle("haha");
        setSupportActionBar(_toolbar);
        FadingActionBarHelperAppCompat helper = new FadingActionBarHelperAppCompat()
                .actionBarBackground(R.drawable.transparent)
                .headerLayout(R.layout.header)
                .contentLayout(R.layout.activity_listview);
        setContentView(helper.createView(this));
        helper.initActionBar(this);
        Log.d("mymy", helper.isActionBarNull() + "");
        //setContentView(R.layout.seesaw);
        addContentView(_toolbar, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getResources().getDimensionPixelSize(R.dimen.abc_action_bar_default_height_material)));
        ListView listView = (ListView) findViewById(android.R.id.list);
        ArrayList<String> items = loadItems(R.raw.nyc_sites);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
    }

    /**
     * @return A list of Strings read from the specified resource
     */
    private ArrayList<String> loadItems(int rawResourceId) {
        try {
            ArrayList<String> countries = new ArrayList<String>();
            InputStream inputStream = getResources().openRawResource(rawResourceId);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                countries.add(line);
            }
            reader.close();
            return countries;
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }
}