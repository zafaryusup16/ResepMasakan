package com.git.search;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.git.search.app.AppController;
import com.git.search.util.Server;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by zafar on 04/08/2017.
 */

public class Detail extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    NetworkImageView thumb_image;
    TextView id_resep, nama_resep, bahan, cara;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    SwipeRefreshLayout swipe;

    private static final String TAG = Detail.class.getSimpleName();

    public static final String TAG_ID         = "id_resep";
    public static final String TAG_NAMA       = "nama_resep";
    public static final String TAG_BAHAN      = "bahan";
    public static final String TAG_CARA       = "cara_membuat";
    public static final String TAG_GAMBAR   = "gambar";

    private static final String url_detail 	= Server.URL + "detail.php";
    String tag_json_obj = "json_obj_req";

    String sug;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        sug = i.getStringExtra("sug");

        id_resep 		= (TextView) findViewById(R.id.txt_id_resep);
        nama_resep 	   	= (TextView) findViewById(R.id.txt_nama_resep);
        bahan 	    	= (TextView) findViewById(R.id.txt_bahan);
        cara     		= (TextView) findViewById(R.id.txt_cara);
        thumb_image     = (NetworkImageView) findViewById(R.id.gambar_resep);

        swipe       = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);

        swipe.setOnRefreshListener(this);

        swipe.post(new Runnable() {
                       @Override
                       public void run() {
                           if (!sug.isEmpty()) {
                               callDetail(sug);
                           }
                       }
                   }
        );
    }

    @Override
    public void onRefresh() {
        callDetail(sug);
    }

    private void callDetail(final String nama){
        swipe.setRefreshing(true);

        StringRequest strReq = new StringRequest(Request.Method.POST, url_detail, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Response " + response.toString());
                swipe.setRefreshing(false);

                try {
                    JSONObject obj = new JSONObject(response);

                    String Id            = obj.getString(TAG_ID);
                    String Nama          = obj.getString(TAG_NAMA);
                    String Cara          = obj.getString(TAG_CARA);
                    String Bahan         = obj.getString(TAG_BAHAN);
                    String Gambar        = obj.getString(TAG_GAMBAR);

                    id_resep.setText(Id);
                    nama_resep.setText(Nama);
                    bahan.setText(Html.fromHtml(Cara));
                    cara.setText(Html.fromHtml(Bahan));
                    if (obj.getString(TAG_GAMBAR)!=""){
                        thumb_image.setImageUrl(Gambar, imageLoader);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Detail Error: " + error.getMessage());
                Toast.makeText(Detail.this,
                        error.getMessage(), Toast.LENGTH_LONG).show();
                swipe.setRefreshing(false);
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to post url
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", nama);

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
    }

    public void onBackPressed()
    {
        this.finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
