package com.hpl.howlong.orm;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Hpl on 2018/1/18 0018.
 */

public class HowLongRecordOrm extends SugarRecord{
  public long createTime;
  public String name;
  public String detail;
  public long takeDuration;
  public long expectDuration;
}
