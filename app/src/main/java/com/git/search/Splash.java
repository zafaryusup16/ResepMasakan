package com.git.search;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by zafar on 04/08/2017.
 */

public class Splash extends AppCompatActivity {
    private static int splashInterval = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(Splash.this,MenuUtama.class);
                startActivity(intent);
                finish();
            }
        }, splashInterval);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, splashInterval);
    }
}
