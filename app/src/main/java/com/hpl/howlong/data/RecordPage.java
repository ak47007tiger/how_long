package com.hpl.howlong.data;

import com.hpl.howlong.javabean.HowLongRecord;
import com.hpl.howlong.orm.HowLongRecordOrm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Hpl on 2018/1/18.
 */

public class RecordPage {
  public int page = -1;
  public int count = -1;
  public List<HowLongRecord> searchList = new ArrayList<>();

  /**
   *
   * @param createTime pass a local time then it will be convert to utc
   * @param relation >, >=, ==, <, <=, !=
   * @return
   */
  public List<HowLongRecord> search(Date createTime, String relation){
    return searchList;
  }

  public List<HowLongRecord> search(String name, String detail){
    return searchList;
  }

  public List<HowLongRecord> search(long duration, String relation){
    return searchList;
  }
}
