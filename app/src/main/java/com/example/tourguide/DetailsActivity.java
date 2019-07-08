package com.example.tourguide;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import github.chenupt.springindicator.SpringIndicator;

public class DetailsActivity extends AppCompatActivity {
    private int PHONE_CALL_PERMISSION;
    private int[] imageResourceID;
    private String phoneNumber;
    private ViewPager mImagePager;
    private PagerAdapter mPagerAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);


        Intent parentActivity = getIntent();
        String label = parentActivity.getStringExtra("Label");
        setTitle(label);

        phoneNumber = parentActivity.getStringExtra("Phone number");
        String address = parentActivity.getStringExtra("Address");
        String hours = parentActivity.getStringExtra("Hours");
        imageResourceID = parentActivity.getIntArrayExtra("Images");

        // image view pager
        mImagePager = findViewById(R.id.image_viewpager);
        mPagerAdapter = new ImageSlideAdapter(getSupportFragmentManager());
        mImagePager.setAdapter(mPagerAdapter);

        SpringIndicator springIndicator = findViewById(R.id.spring_indicator);
        springIndicator.setViewPager(mImagePager);


        // updating the views
        TextView businessNameTextView = findViewById(R.id.name_textview);
        TextView phoneNumberTextView = findViewById(R.id.phone_number_textview);
        TextView businessHoursTextView = findViewById(R.id.business_hours_textview);
        TextView addressTextView = findViewById(R.id.address_textview);

        businessNameTextView.setText(label); // remove in place of changing the label?
        phoneNumberTextView.setText(phoneNumber);
        businessHoursTextView.setText(hours);
        addressTextView.setText(address);

        // making the phonenumber textview launch the phone app and place a call
        phoneNumberTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent phoneCallIntent = new Intent(Intent.ACTION_DIAL);
                phoneCallIntent.setData(Uri.parse("tel:" + phoneNumber));

                if (ContextCompat.checkSelfPermission(DetailsActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(DetailsActivity.this, new String[]{Manifest.permission.CALL_PHONE},
                            PHONE_CALL_PERMISSION);
                } else {
                    startActivity(phoneCallIntent);
                }
            }
        });


        // set onclicklistener for address textview to launch maps
        final Uri mapsIntentUri = Uri.parse("geo:0.0?q=" + label + " " + address.replaceAll("\n", ""));
        addressTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapsIntent = new Intent(Intent.ACTION_VIEW, mapsIntentUri);
                startActivity(mapsIntent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PHONE_CALL_PERMISSION){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                final Intent phoneCallIntent = new Intent(Intent.ACTION_DIAL);
                phoneCallIntent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(phoneCallIntent);
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private class ImageSlideAdapter extends FragmentStatePagerAdapter {
        public ImageSlideAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return imageResourceID.length;
        }

        @Override
        public Fragment getItem(int i) {
            return ImageSlider.createInstance(imageResourceID[i]);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            String[] numericTitles = new String[] {"1", "2", "3"};
            return numericTitles[position];
        }
    }
}
