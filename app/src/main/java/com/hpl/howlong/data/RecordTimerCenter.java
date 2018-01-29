package com.hpl.howlong.data;

import android.os.Handler;

import com.hpl.howlong.javabean.RecordTimerData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Hpl on 2018/1/29.
 */

public class RecordTimerCenter {

  public static RecordTimerCenter instance = new RecordTimerCenter();

  Handler handler = new Handler();

  Collection<RecordTimerData> timerDataList = new ArrayList<>();

  Runnable countTime = new Runnable() {
    @Override
    public void run() {
      for (RecordTimerData data : timerDataList){
        data.increaseTime();
      }
      handler.postDelayed(this,1000);
    }
  };

  public void startCountTime(){
    handler.post(countTime);
  }

  public void stopCountTime(){
    handler.removeCallbacks(countTime);
  }

  HashSet<RecordTimerData> tempSet = new HashSet<>();

  public void start(Collection<RecordTimerData> list) {
    tempSet.addAll(list);
    timerDataList.addAll(tempSet);
    tempSet.clear();
  }

  public void stop(Collection<RecordTimerData> list) {
    timerDataList.removeAll(list);
  }

  public void start(RecordTimerData timerData) {
    if (!timerDataList.contains(timerData))
      timerDataList.add(timerData);
  }

  public void stop(RecordTimerData timerData) {
    if (timerDataList.contains(timerData))
      timerDataList.remove(timerData);
  }

}
