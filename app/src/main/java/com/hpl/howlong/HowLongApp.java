package com.hpl.howlong;

import android.app.Application;
import android.content.Intent;

import com.hpl.howlong.service.KeepAliveService;

/**
 * Created by Hpl on 2018/1/18 0018.
 */

public class HowLongApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        startService(new Intent(getApplicationContext(), KeepAliveService.class));
    }
}
