package com.hpl.howlong.thirdpart.message;

import android.support.v4.app.Fragment;

/**
 * Created by Hpl on 2018/2/1 0001.
 */

public class SupportFragmentEvent {

    public Fragment fragment;

    public String tag;

    public static SupportFragmentEvent produce(Fragment fragment, String tag){
        SupportFragmentEvent event = new SupportFragmentEvent();
        event.fragment = fragment;
        event.tag = tag;
        return event;
    }

    public static SupportFragmentEvent produce(Fragment fragment){
        return produce(fragment, fragment.getClass().getSimpleName());
    }

}
