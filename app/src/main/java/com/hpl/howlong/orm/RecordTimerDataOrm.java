package com.hpl.howlong.orm;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Hpl on 2018/1/29.
 */

public class RecordTimerDataOrm extends SugarRecord {
  public boolean processing;
  public long startIncreaseTime;
}
