package com.example.tourguide;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LandmarkAdapter extends ArrayAdapter<Landmark> {

    // public constructor for the LandmarkAdapter
    public LandmarkAdapter(Context context, ArrayList<Landmark> landmarks){
        super(context, 0, landmarks);
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        // get each item based on the position in the object initialized at the public constructor
        Landmark landmark = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // set textview and imageview
        TextView listItemTextView = convertView.findViewById(R.id.list_item_business_name);
        listItemTextView.setText(landmark.getLandmarkName());

        ImageView listItemImageView = convertView.findViewById(R.id.list_item_business_image);
        listItemImageView.setImageResource(landmark.getThumbnailID());
        listItemImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        // change theme based on section

        return convertView;
    }
}
