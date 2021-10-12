package com.examplmakecodeeasy.instgramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("dkE5prhoEp1WshyD0jaBPDOI0ZfzebF7R1OGUiut")
                // if defined
                .clientKey("naFYH9HfAmxggv356uO3GJ2u6nESkSq8z8xMXoLN")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
