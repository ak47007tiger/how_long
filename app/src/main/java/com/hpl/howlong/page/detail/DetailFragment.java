package com.hpl.howlong.page.detail;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hpl.howlong.R;
import com.hpl.howlong.javabean.HowLongRecord;
import com.hpl.howlong.toolkit.page.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Hpl on 2018/1/23.
 */

public class DetailFragment extends BaseFragment {

  HowLongRecord howLongRecord;

  @BindView(R.id.expectDurationTv)
  TextView expectDurationTv;
  @BindView(R.id.durationTv)
  TextView durationTv;
  @BindView(R.id.nameAndCreateTimeTv)
  TextView nameAndCreateTimeTv;
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
  public void onResume() {
    super.onResume();
    updateUI(howLongRecord);
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

  public void setHowLongRecord(HowLongRecord howLongRecord) {
    this.howLongRecord = howLongRecord;
    if (isVisible()) {
      updateUI(howLongRecord);
    }
  }

  void updateUI(HowLongRecord howLongRecord) {
    if (howLongRecord != null) {

    }
  }
}
