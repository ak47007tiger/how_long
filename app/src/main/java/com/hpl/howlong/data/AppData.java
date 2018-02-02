package com.hpl.howlong.data;

import android.util.Log;

import com.hpl.howlong.javabean.DurationRecord;
import com.hpl.howlong.orm.DurationRecordOrm;
import com.hpl.howlong.thirdpart.message.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.hwangjr.rxbus.thread.EventThread;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hpl on 2018/1/18.
 */

public class AppData {

  public static AppData data = new AppData();

  public List<DurationRecord> recordList = new ArrayList<>();

  public List<DurationRecord> searchList = new ArrayList<>();

  public Map<String,DurationRecord> idToRecord = new HashMap<>();

  public RecordPage recordPage;

  public DurationRecord toEdit;

  public void setup(){
    RxBus.register(this);
    recordList.addAll(DurationRecord.from(SugarRecord.listAll(DurationRecordOrm.class)));
  }

  public void destroy(){
    RxBus.unregister(this);
  }

  @Subscribe(tags = {@Tag(RxBus.tag_test)}, thread = EventThread.MAIN_THREAD)
  public void onTest(Object event){
    Log.d(getClass().getSimpleName(), "app data");
    Log.d(getClass().getSimpleName(), event.toString());
  }

  public void loadList(){

  }

  public void save(){

  }

  public void add(DurationRecord record){

  }

  public void remove(DurationRecord record){

  }

  public void update(DurationRecord record){

  }

  public List<DurationRecord> search(Date start, Date end){
    return searchList;
  }

  public List<DurationRecord> search(long duration, String relation){
    return searchList;
  }

  @Subscribe(tags = {@Tag(RxBus.TAG_CREATED_NEW_RECORD)}, thread = EventThread.MAIN_THREAD)
  public void onCreatedRecord(Object event){
    DurationRecord record = (DurationRecord) event;
    recordList.add(0, record);
    DurationRecordOrm recordOrm = new DurationRecordOrm();
    recordOrm.from(record);
    recordOrm.save();
    RxBus.post(RxBus.TAG_UPDATE_RECORD_LIST, "");
  }
}

