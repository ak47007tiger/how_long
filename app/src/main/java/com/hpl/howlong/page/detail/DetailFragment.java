package com.hpl.howlong.page.detail;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hpl.howlong.R;
import com.hpl.howlong.javabean.DurationRecord;
import com.hpl.howlong.thirdpart.message.RxBus;
import com.hpl.howlong.toolkit.page.BaseFragment;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.hwangjr.rxbus.thread.EventThread;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Hpl on 2018/1/23.
 */

public class DetailFragment extends BaseFragment {

  DurationRecord durationRecord;

  @BindView(R.id.nameAndCreateTimeTv)
  TextView nameAndCreateTimeTv;
  @BindView(R.id.expectDurationTv)
  TextView expectDurationTv;
  @BindView(R.id.durationTv)
  TextView durationTv;
  @BindView(R.id.startBtn)
  Button startBtn;
  @BindView(R.id.endBtn)
  Button endBtn;
  @BindView(R.id.contentTv)
  TextView contentTv;

  @Override
  protected int getLayoutId() {
    return R.layout.detail_fragment;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    RxBus.register(this);
  }

  @Subscribe(tags = {@Tag(RxBus.TAG_RECORD_TIMER_DATA_UPDATE)}, thread = EventThread.MAIN_THREAD)
  public void onRecordTimerDataUpdate(Object event){
    if (!isVisible())
      return;
    updateUI(durationRecord);
  }

  @Override
  public void onResume() {
    super.onResume();
    updateUI(durationRecord);
  }

  @Override
  public void onDestroy() {
    RxBus.unregister(this);
    super.onDestroy();
  }

  @OnClick({R.id.startBtn, R.id.endBtn})
  public void onViewClicked(View view) {
    switch (view.getId()) {
      case R.id.startBtn:
        break;
      case R.id.endBtn:
        break;
    }
  }

  public void setDurationRecord(DurationRecord durationRecord) {
    this.durationRecord = durationRecord;
    if (isVisible()) {
      updateUI(durationRecord);
    }
  }

  void updateUI(DurationRecord durationRecord) {
    if (durationRecord != null) {

    }
  }

}
