package com.example.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MallFragment extends Fragment {
    public MallFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.list_view, container, false);

        final ArrayList<Landmark> mallLandmarks = new ArrayList<>();
        mallLandmarks.add(new Landmark("Jabi Lake Mall", "+2348097618000", "Jabi District, Bala Sokoto Way, Jabi, Abuja, Nigeria.", "9am to 9pm",
                "Mall", R.drawable.jabi_lake_mall_icon,
                new int[] {R.drawable.jabi_lake_mall_1, R.drawable.jabi_lake_mall_2, R.drawable.jabi_lake_mall_3}));

        mallLandmarks.add(new Landmark("Ceddi Plaza", "+23411676822", "264 Tafawa Balewa Way, Central Business District, Abuja", "8am to 11pm",
                "Mall", R.drawable.ceddi_plaza_icon,
                new int[] {R.drawable.ceddi_plaza_1, R.drawable.ceddi_plaza_2}));

        ListView listView = rootView.findViewById(R.id.root_view);
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(getContext(), mallLandmarks);
        listView.setAdapter(landmarkAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Landmark item = mallLandmarks.get(i);
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
