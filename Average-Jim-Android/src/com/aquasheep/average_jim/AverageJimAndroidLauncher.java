package com.aquasheep.average_jim;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AverageJimAndroidLauncher extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_jim_android_launcher);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_average_jim_android_launcher, menu);
        return true;
    }
}
