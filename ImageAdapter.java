package com.example.sqlitekino;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private  String [] mobileValues;

    public ImageAdapter(Context context, String[] mobile){
        this.context = context;
        this.mobileValues = mobile;
    }

    @Override
    public int getCount() {
        return mobileValues.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;
        if (convertView == null) {
            gridView = new View(context);

            gridView = inflater.inflate(R.layout.mobile, null);

            ImageView imageView = (ImageView) gridView.findViewById(R.id.imageView);

            String mobile = mobileValues[position];

            if (mobile.equals("deadpool")) {
                imageView.setImageResource(R.drawable.deadpool);
            } else if (mobile.equals("friday")) {
                imageView.setImageResource(R.drawable.friday);
            } else if (mobile.equals("starwars")) {
                imageView.setImageResource(R.drawable.starwars);
            } else if (mobile.equals("superbad")) {
                imageView.setImageResource(R.drawable.superbad);
            }


        } else {
            gridView = (View) convertView;
        }
        return gridView;
    }
}
