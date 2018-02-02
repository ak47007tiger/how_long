package com.hpl.howlong.page.contract;

import com.hpl.howlong.javabean.DurationRecord;

/**
 * Created by Hpl on 2018/1/20.
 */

public interface IRecordView {
  void setDurationRecord(DurationRecord durationRecord);
  DurationRecord collectDataFromUI();
}
