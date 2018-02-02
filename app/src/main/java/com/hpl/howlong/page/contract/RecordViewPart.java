package com.hpl.howlong.page.contract;

import android.widget.EditText;

import com.hpl.howlong.R;
import com.hpl.howlong.javabean.DurationRecord;

import butterknife.BindView;

/**
 * Created by Hpl on 2018/1/20.
 */

public class RecordViewPart extends BaseViewPart implements IRecordView{
  private DurationRecord durationRecord;

  @BindView(R.id.nameEt)
  EditText nameEt;
  @BindView(R.id.detailEt)
  EditText detailEt;

  @BindView(R.id.dayEt)
  EditText dayEt;
  @BindView(R.id.hourEt)
  EditText hourEt;
  @BindView(R.id.minuteEt)
  EditText minuteEt;

  public void setDurationRecord(DurationRecord durationRecord) {
    this.durationRecord = durationRecord;
    nameEt.setText(durationRecord.name);
    detailEt.setText(durationRecord.detail);

    int days = (int) (durationRecord.expectDuration/(3600 * 24));
    int hours = (int) (durationRecord.expectDuration/3600);
    int minutes = (int) (durationRecord.expectDuration%3600/60);
    dayEt.setText(String.valueOf(days));
    hourEt.setText(String.valueOf(hours));
    minuteEt.setText(String.valueOf(minutes));
  }

  public DurationRecord collectDataFromUI(){
    durationRecord.name = nameEt.getText().toString();
    durationRecord.detail = detailEt.getText().toString();
    int days = Integer.getInteger(dayEt.getText().toString());
    int hours = Integer.getInteger(hourEt.getText().toString());
    int minutes = Integer.getInteger(minuteEt.getText().toString());
    durationRecord.expectDuration = days * (3600 * 24) + hours * 36000 + minutes * 60;
    return durationRecord;
  }
}
