package com.hpl.howlong.orm;

import com.orm.SugarRecord;

/**
 * Created by Hpl on 2018/1/29.
 */

public class RecordTimerDataOrm extends SugarRecord {
  //DurationRecordOrm recordOrm;

  public boolean processing;
  public long startIncreaseTime;

  public RecordTimerDataOrm() {
  }
}
