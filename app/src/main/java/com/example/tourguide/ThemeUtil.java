package com.example.tourguide;

import android.app.Activity;
import android.content.Intent;

public class ThemeUtil {
    private static int sTheme;

    //  set the theme of the activity and restart it by creating a new activity of the same type?
    public static void changeToTheme(Activity activity, int theme){
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onActivityCreateSetTheme(Activity activity){
        activity.setTheme(R.style.ResturantCategory);
    }
}
