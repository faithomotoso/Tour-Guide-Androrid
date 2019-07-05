package com.example.tourguide;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity {
    private int PHONE_CALL_PERMISSION;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        Intent parentActivity = getIntent();
        String label = parentActivity.getStringExtra("Label");
        setTitle(label);

        final String phoneNumber = parentActivity.getStringExtra("Phone number");
        String address = parentActivity.getStringExtra("Address");
        String hours = parentActivity.getStringExtra("Hours");


        // updating the views
        TextView businessNameTextView = findViewById(R.id.name_textview);
        TextView phoneNumberTextView = findViewById(R.id.phone_number_textview);
        TextView businessHoursTextView = findViewById(R.id.business_hours_textview);
        TextView addressTextView = findViewById(R.id.address_textview);

        businessNameTextView.setText(label); // remove in place of changing the label?
        phoneNumberTextView.setText(phoneNumber);
        businessHoursTextView.setText(hours);
        addressTextView.setText(address);

        // making the textview containing the phonenumber launch the phone app and place a call
        phoneNumberTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phoneCallIntent = new Intent(Intent.ACTION_CALL);
                phoneCallIntent.setData(Uri.parse("tel:" + phoneNumber));

                // check if permission is granted
                if (ActivityCompat.checkSelfPermission(DetailsActivity.this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(DetailsActivity.this, new String[]{Manifest.permission.CALL_PHONE},
                            PHONE_CALL_PERMISSION);
                } else {
                    startActivity(phoneCallIntent);
                }
            }
        });

    }
}
