package com.aquasheep.average_jim_android;

import android.os.Bundle;
import android.view.Menu;

import com.aquasheep.average_jim.AverageJimGame;
import com.badlogic.gdx.backends.android.AndroidApplication;

public class AverageJimAndroidLauncher extends AndroidApplication {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        initialize(new AverageJimGame(), false);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_average_jim_android_launcher, menu);
        return true;
    }
    
}
