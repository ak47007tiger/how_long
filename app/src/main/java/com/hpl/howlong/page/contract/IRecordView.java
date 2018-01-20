package com.hpl.howlong.page.contract;

import com.hpl.howlong.javabean.HowLongRecord;

/**
 * Created by Hpl on 2018/1/20.
 */

public interface IRecordView {
  void setHowLongRecord(HowLongRecord howLongRecord);
  HowLongRecord collectDataFromUI();
}
