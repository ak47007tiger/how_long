package com.hpl.howlong.orm;

import com.hpl.howlong.javabean.DurationRecord;
import com.hpl.howlong.toolkit.TimeUtil;
import com.orm.SugarRecord;

/**
 * Created by Hpl on 2018/1/18 0018.
 */

public class DurationRecordOrm extends SugarRecord{
  public String name;
  public long createTime;
  public String detail;
  public long expectDuration;
  public long takeDuration;

  public DurationRecordOrm() {
  }

  public void from(DurationRecord record){
    name = record.name;
    createTime = TimeUtil.localCalendarToUtc(record.createTime);
    detail = record.detail;
    expectDuration = record.expectDuration;
    takeDuration = record.takeDuration;
  }
}
