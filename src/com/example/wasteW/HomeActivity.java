package com.example.wasteW;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.example.wasteW.CardFlip.CardFlip;
import com.example.wasteW.CardView.CustomColoredAnimationActivity;
import com.example.wasteW.GoogleLogIn.GoogleLogInActivity;
import com.example.wasteW.MyScrolling.ModifiedScrollView;
import com.example.wasteW.ScrollView.MainActivity;
import com.example.wasteW.Seesaw.SeeSawActivity;
import com.example.wasteW.db.DBHandler;
import com.example.wasteW.fadingactionbar.TestActionBarActivity;
import com.example.wasteW.fadingactionbar.TestThreeActivity;
import com.example.wasteW.fadingactionbar.TestTwoActivity;
import com.example.wasteW.favorite.FavoriteAction;
import com.example.wasteW.favorite.favAct;
import com.example.wasteW.property.PropertyAnimation;
import com.example.wasteW.window.transition.WindowTransitionActivity;

/**
 * Created by Luffy on 4/3/2015.
 */
public class HomeActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        openCardActivity();
        //DBHandler handle = new DBHandler(this);
    }

    public void openCardActivity()
    {
        Intent intent = new Intent(HomeActivity.this, GoogleLogInActivity.class);
        startActivity(intent);
    }
}