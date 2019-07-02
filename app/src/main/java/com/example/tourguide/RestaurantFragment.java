package com.example.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantFragment extends Fragment {

    public RestaurantFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        int [] images = {R.drawable.woks_koi_1, R.drawable.woks_koi_2, R.drawable.woks_koi_3};

        final ArrayList<Landmark> restaurantLandmarks = new ArrayList<>();
        restaurantLandmarks.add(new Landmark("Woks and Koi", "+2349093476816", "Silverbird Entertainment Centre (2nd floor)\n" +
                "Plot 1161, Memorial Drive,\n" +
                "Central Business District, Abuja.", "8am to 10pm", "Restaurant", R.drawable.woks_koi_2,
                images));

        ListView listView = rootView.findViewById(R.id.root_view);

        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(getContext(), restaurantLandmarks);
        listView.setAdapter(landmarkAdapter);

        return rootView;
    }
}
