package com.example.tourguide;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import github.chenupt.springindicator.SpringIndicator;

public class ImageSlider extends Fragment {
    private int mResourceID;

    public ImageSlider(){
    }

    // set image resource as a fragment argument upon fragment instantiation
    public static ImageSlider createInstance(int resourceID){
        ImageSlider imageSlider = new ImageSlider();
        Bundle args = new Bundle();
        args.putString("imageID", String.valueOf(resourceID));
        imageSlider.setArguments(args);
        return imageSlider;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mResourceID = Integer.parseInt(getArguments().getString("imageID"));
        Log.v("Im Res ID", String.valueOf(mResourceID));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.imageview_fragment, container, false);

        ImageView imageView = rootView.findViewById(R.id.image_viewfragment);

        imageView.setImageResource(mResourceID);


        return rootView;
    }
}
