package com.hpl.howlong.data;

import com.hpl.howlong.javabean.HowLongRecord;
import com.hpl.howlong.service.KeepAliveService;

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

  public List<HowLongRecord> recordList = new ArrayList<>();

  public List<HowLongRecord> searchList = new ArrayList<>();

  public Map<String,HowLongRecord> idToRecord = new HashMap<>();

  public RecordPage recordPage;

  public HowLongRecord toEdit;

  public void loadList(){

  }

  public void save(){

  }

  public void add(HowLongRecord record){

  }

  public void remove(HowLongRecord record){

  }

  public void update(HowLongRecord record){

  }

  public List<HowLongRecord> search(Date start, Date end){
    return searchList;
  }

  public List<HowLongRecord> search(long duration, String relation){
    return searchList;
  }

}

