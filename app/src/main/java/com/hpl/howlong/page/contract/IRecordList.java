package com.hpl.howlong.page.contract;

import com.hpl.howlong.javabean.DurationRecord;

import java.util.List;

/**
 * Created by Hpl on 2018/1/20.
 */

public interface IRecordList {
  void setHowLongList(List<DurationRecord> records);
  void updateList();
}
