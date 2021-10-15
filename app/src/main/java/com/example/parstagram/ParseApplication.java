package com.example.parstagram;


import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("HstZu8o7tTltoDoCkDYagK28QzBYg0ySFUCNjBZ4")
                .clientKey("1KF0zljd0vfGetrMxyu9ODilC63zG1YNT7JAaHVS")
                .server("https://parseapi.back4app.com/")
                .build()
        );

    }
}
