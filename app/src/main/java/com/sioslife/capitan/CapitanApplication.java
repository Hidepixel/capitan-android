package com.sioslife.capitan;

import android.app.Application;

import client.ApiService;

/**
 * Created by dinom on 18/03/2016.
 */
public class CapitanApplication extends Application {

    private ApiService api;
    @Override
    public void onCreate() {
        super.onCreate();
        api = new ApiService();
    }

    public ApiService getApi() {
        return api;
    }
}
