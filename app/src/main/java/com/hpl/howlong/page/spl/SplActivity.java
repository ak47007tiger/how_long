package com.hpl.howlong.page.spl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hpl.howlong.HowLongApp;
import com.hpl.howlong.R;
import com.hpl.howlong.page.HomeActivity;
import com.hpl.howlong.toolkit.page.BaseActivity;

/**
 * Created by Hpl on 2018/1/31 0031.
 */

public class SplActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (HowLongApp.get().showedSpl){
            toHome();
            return;
        }

        setContentView(R.layout.spl_fragment);

        HowLongApp.get().handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toHome();
            }
        }, 1000);
    }

    void toHome(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

}
