package com.hpl.howlong.data;

import com.hpl.howlong.javabean.DurationRecord;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Hpl on 2018/1/18.
 */

public class RecordPage {
  public int page = -1;
  public int count = -1;
  public List<DurationRecord> searchList = new ArrayList<>();

  /**
   *
   * @param createTime pass a local time then it will be convert to utc
   * @param relation >, >=, ==, <, <=, !=
   * @return
   */
  public List<DurationRecord> search(Date createTime, String relation){
    return searchList;
  }

  public List<DurationRecord> search(String name, String detail){
    return searchList;
  }

  public List<DurationRecord> search(long duration, String relation){
    return searchList;
  }
}
