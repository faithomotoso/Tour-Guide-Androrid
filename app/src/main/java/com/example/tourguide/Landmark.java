package com.example.tourguide;

public class Landmark {
    private int[] mImageResourceID = new int[3]; // 3 images per Landmark
    private int mThumbnailID;
    private String mName;
    private String mPhoneNumber;
    private String mLocation;
    private String mBusinessHours;
    private String mSection;


    /*
    * @param name - name of the Landmark
    * @param phoneNumber - phoneNumber to connect to the business
    * @param location - location of the business or landmark
    * @imageResourceID - integer array containing IDs of 3 image resources per landmark or business
    * */

    public Landmark(String name, String phoneNumber, String location, String businessHours, String section, int thumbnailID,int[] imageResourceID){
        this.mName = name;
        this.mPhoneNumber = phoneNumber;
        this.mLocation = location;
        this.mBusinessHours = businessHours;
        this.mImageResourceID = imageResourceID;
        this.mSection = section; // for changing the theme - might be wrong to be here
        this.mThumbnailID = thumbnailID;
    }


    public String getSection(){
        return mSection;
    }

    public int getThumbnailID(){
        return mThumbnailID;
    }

    public String getLandmarkName(){
        return mName;
    }

    public int[] getImageResourceID(){
        return mImageResourceID;
    }

    public String getPhoneNumber(){
        return mPhoneNumber;
    }

    public String getLocation(){
        return mLocation;
    }

    public String getBusinessHours(){
        return mBusinessHours;
    }
}
