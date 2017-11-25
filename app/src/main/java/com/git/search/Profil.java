package com.git.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

/**
 * Created by zafar on 04/08/2017.
 */

public class Profil extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
    }
    public void onBackPressed()
    {
        Intent i = new Intent(Profil.this, MenuUtama.class);
        startActivity(i);
        this.finish();
    }
}
