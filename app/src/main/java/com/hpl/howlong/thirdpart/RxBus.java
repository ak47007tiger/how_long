package com.hpl.howlong.thirdpart;

import com.hwangjr.rxbus.Bus;

public final class RxBus {
    public static final String Action_Record_Timer_Data_Update = "Record_Timer_Data_Update";

    private static Bus sBus;
    
    public static synchronized Bus get() {
        if (sBus == null) {
            sBus = new Bus();
        }
        return sBus;
    }
}