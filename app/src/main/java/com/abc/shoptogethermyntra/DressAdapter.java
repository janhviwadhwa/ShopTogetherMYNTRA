package com.abc.shoptogethermyntra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DressAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Dress> dresses;

    public DressAdapter(Context context, ArrayList<Dress> dresses) {
        this.context = context;
        this.dresses = dresses;
    }

    @Override
    public int getCount() {
        return dresses.size();
    }

    @Override
    public Object getItem(int position) {
        return dresses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.dress_item, parent, false);
        }

        Dress currentDress = (Dress) getItem(position);

        TextView heartCountView = convertView.findViewById(R.id.heart_count);
        TextView starCountView = convertView.findViewById(R.id.star_count);

        heartCountView.setText(String.valueOf(currentDress.getHeartCount()));
        starCountView.setText(String.valueOf(currentDress.getStarCount()));

        return convertView;
    }
}
