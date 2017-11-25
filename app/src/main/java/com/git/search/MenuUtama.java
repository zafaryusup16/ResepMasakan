package com.git.search;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by zafar on 04/08/2017.
 */

public class MenuUtama extends AppCompatActivity {
    public Button btnResep, btnProfil, btnTentang, btnKeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        // WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnKeluar = (Button) findViewById(R.id.btnKeluar);
        btnResep = (Button) findViewById(R.id.btnResep);
        btnTentang = (Button) findViewById(R.id.btnTentang);
        btnProfil = (Button) findViewById(R.id.btnProfil);
    }

    public void profilOnClick(View view)
    {
        Intent i = new Intent(MenuUtama.this, Profil.class);
        startActivity(i);
        finish();
    }
    public void tentangOnClick(View view)
    {
        Intent i = new Intent(MenuUtama.this, Tentang.class);
        startActivity(i);
        finish();
    }
    public void resepOnClick(View v)
    {
        Intent i = new Intent(MenuUtama.this, MainActivity.class);
        startActivity(i);
        finish();
    }
    public void keluarOnClick(View v)
    {
        exit();
    }
    public void onBackPressed()
    {
        exit();
    }

    private void exit()
    {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm");

        builder.setMessage(" Apa Anda Yakin Ingin Keluar ?").setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.cancel();
            }
        }).show();
    }
}
