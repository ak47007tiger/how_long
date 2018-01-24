package com.hpl.howlong.orm;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Hpl on 2018/1/18 0018.
 */

public class HowLongRecordOrm extends SugarRecord{
  public String name;
  public long createTime;
  public String detail;
  public long expectDuration;
  public long takeDuration;

  public boolean processing;
  public long startIncreaseTime;
}
