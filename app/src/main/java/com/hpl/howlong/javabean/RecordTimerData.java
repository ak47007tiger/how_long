package com.hpl.howlong.javabean;

import java.util.Calendar;

/**
 * Created by Hpl on 2018/1/29.
 */

public class RecordTimerData {
  public HowLongRecord howLongRecord;

  public boolean processing;
  public Calendar startIncreaseTime;

  public void increaseTime(){
    startIncreaseTime.setTimeInMillis(startIncreaseTime.getTimeInMillis() + 1000);
  }

}
