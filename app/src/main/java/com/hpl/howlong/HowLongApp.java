package com.hpl.howlong;

import android.app.Application;
import android.content.Intent;
import android.os.Handler;

import com.hpl.howlong.service.KeepAliveService;

/**
 * Created by Hpl on 2018/1/18 0018.
 */

public class HowLongApp extends Application{

    private static HowLongApp instance;

    public static HowLongApp get(){
        return instance;
    }

    public boolean showedSpl = false;

    public final Handler handler = new Handler();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        startService(new Intent(getApplicationContext(), KeepAliveService.class));
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }
}
