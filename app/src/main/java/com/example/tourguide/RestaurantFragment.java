package com.example.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantFragment extends Fragment {

    public RestaurantFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        final ArrayList<Landmark> restaurantLandmarks = new ArrayList<>();
        restaurantLandmarks.add(new Landmark("Woks and Koi", "+2349093476816", "Silverbird Entertainment Centre (2nd floor)\n" +
                "Plot 1161, Memorial Drive,\n" +
                "Central Business District, Abuja.", "8am to 10pm", "Restaurant", R.drawable.chinese_woks_koi_2,
                // using anonymous array
                new int[] {R.drawable.chinese_woks_koi_1, R.drawable.chinese_woks_koi_2, R.drawable.chinese_woks_koi_3}));


        restaurantLandmarks.add(new Landmark("Jevinik Resturant", "+2347015863699", "494 Bangui Street, Off Ademola Adetokunbo, Wuse 2, Abuja, Nigeria.",
                "9am to 9pm", "Restaurant", R.drawable.african_jevinik_resturant_2,
                new int[] {R.drawable.african_jevinik_resturant_1, R.drawable.african_jevinik_resturant_2, R.drawable.african_jevinik_resturant_3}));

        restaurantLandmarks.add(new Landmark("Shawarma King", "+23457132603", "56 Gana Street, Maitama, Abuja", "Monday - Friday: 10am - 10pm\n" +
                "Sunday: 11am - 9pm", "Restaurant",R.drawable.shawarma_king_2,
                new int[] {R.drawable.shawarma_king_1, R.drawable.shawarma_king_2, R.drawable.shawarma_king_3}));

        ListView listView = rootView.findViewById(R.id.root_view);

        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(getContext(), restaurantLandmarks);
        listView.setAdapter(landmarkAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Landmark item = restaurantLandmarks.get(i);
                Intent detailsActivity = new Intent(getContext(), DetailsActivity.class);
                detailsActivity.putExtra("Label", item.getLandmarkName());
                detailsActivity.putExtra("Phone number", item.getPhoneNumber());
                detailsActivity.putExtra("Address", item.getLocation());
                detailsActivity.putExtra("Hours", item.getBusinessHours());
                detailsActivity.putExtra("Images", item.getImageResourceID());
                startActivity(detailsActivity);
            }
        });

        return rootView;
    }
}
