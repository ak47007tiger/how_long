package com.hpl.howlong.thirdpart.message;

import com.hwangjr.rxbus.Bus;

public final class RxBus {
    public static final String TAG_RECORD_TIMER_DATA_UPDATE = "record_timer_data_update";

    public static final String TAG_CREATED_NEW_RECORD = "created_new_record";
    public static final String TAG_END_CREATE_RECORD = "end_create_record";

    public static final String TAG_UPDATE_RECORD_LIST = "update_record_list";

    public static final String TAG_DELETE_RECORD = "delete_record";
    public static final String TAG_UPDATED_RECORD = "updated_record";

    public static final String TAG_ADD_FRAGMENT = "add_fragment";
    public static final String TAG_REMOVE_FRAGMENT = "remove_fragment";
    public static final String TAG_HIDE_FRAGMENT = "hide_fragment";
    public static final String TAG_SHOW_FRAGMENT = "show_fragment";

    public static final String tag_test = "test";

    private static Bus sBus;
    
    public static synchronized Bus get() {
        if (sBus == null) {
            sBus = new Bus();
        }
        return sBus;
    }

    public static void post(String tag, Object event){
        get().post(tag, event);
    }

    public static void post(Object event){
        get().post(event);
    }

    public static void register(Object o){
        get().register(o);
    }

    public static void unregister(Object o){
        get().unregister(o);
    }
}