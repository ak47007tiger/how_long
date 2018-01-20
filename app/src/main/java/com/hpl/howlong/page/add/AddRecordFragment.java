package com.hpl.howlong.page.add;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.hpl.howlong.R;
import com.hpl.howlong.javabean.HowLongRecord;
import com.hpl.howlong.page.contract.IRecordView;
import com.hpl.howlong.toolkit.page.BaseFragment;

import butterknife.BindView;

/**
 * Created by Hpl on 2018/1/18.
 */

public class AddRecordFragment extends BaseFragment implements IRecordView{

  private HowLongRecord howLongRecord;

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

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    setHowLongRecord(howLongRecord);
  }

  @Override
  protected int getLayoutId() {
    return R.layout.add_fragment;
  }

  public void setHowLongRecord(HowLongRecord howLongRecord) {
    this.howLongRecord = howLongRecord;
    if (isAdded()) return;

    nameEt.setText(howLongRecord.name);
    detailEt.setText(howLongRecord.detail);

    int days = (int) (howLongRecord.expectDuration/(3600 * 24));
    int hours = (int) (howLongRecord.expectDuration/3600);
    int minutes = (int) (howLongRecord.expectDuration%3600/60);
    dayEt.setText(String.valueOf(days));
    hourEt.setText(String.valueOf(hours));
    minuteEt.setText(String.valueOf(minutes));
  }

  public HowLongRecord collectDataFromUI(){
    howLongRecord.name = nameEt.getText().toString();
    howLongRecord.detail = detailEt.getText().toString();
    int days = Integer.getInteger(dayEt.getText().toString());
    int hours = Integer.getInteger(hourEt.getText().toString());
    int minutes = Integer.getInteger(minuteEt.getText().toString());
    howLongRecord.expectDuration = days * (3600 * 24) + hours * 36000 + minutes * 60;
    return howLongRecord;
  }

}
