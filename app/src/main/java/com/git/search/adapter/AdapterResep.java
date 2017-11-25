package com.git.search.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.git.search.R;
import com.git.search.app.AppController;
import com.git.search.data.DataResep;

import java.util.List;

/**
 * Created by zafar on 04/08/2017.
 */

public class AdapterResep extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<DataResep> items;
    ImageLoader imageLoader;

    public AdapterResep(Activity activity, List<DataResep> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int location) {
        return items.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_resep, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        NetworkImageView thumbNail = (NetworkImageView) convertView.findViewById(R.id.gambar_berita);
        TextView nama = (TextView) convertView.findViewById(R.id.nama_resep);
        TextView id = (TextView) convertView.findViewById(R.id.id_resep);

        DataResep resep = items.get(position);

        thumbNail.setImageUrl(resep.getGambar(), imageLoader);
        nama.setText(resep.getNama_resep());
        id.setText(resep.getId_resep());

        return convertView;
    }
}
