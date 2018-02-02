package com.hpl.howlong;

import android.content.Intent;
import android.os.Handler;
import android.support.multidex.MultiDexApplication;

import com.hpl.howlong.data.AppData;
import com.hpl.howlong.service.KeepAliveService;
import com.orm.SugarContext;

/**
 * Created by Hpl on 2018/1/18 0018.
 */

public class HowLongApp extends MultiDexApplication {

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

        SugarContext.init(getApplicationContext());
        AppData.data.setup();

        startService(new Intent(getApplicationContext(), KeepAliveService.class));
    }

    @Override
    public void onTerminate() {
        AppData.data.destroy();
        SugarContext.terminate();
        super.onTerminate();
        instance = null;
    }
}
