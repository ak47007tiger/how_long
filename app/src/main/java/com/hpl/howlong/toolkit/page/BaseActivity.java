package com.hpl.howlong.toolkit.page;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle.components.RxActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Hpl on 2018/1/18.
 */

public abstract class BaseActivity extends RxActivity{

  private Unbinder unbinder;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public void setContentView(View view) {
    super.setContentView(view);
    unbinder = ButterKnife.bind(this);
  }

  @Override
  public void setContentView(int layoutResID) {
    super.setContentView(layoutResID);
    unbinder = ButterKnife.bind(this);
  }

  @Override
  public void setContentView(View view, ViewGroup.LayoutParams params) {
    super.setContentView(view, params);
    unbinder = ButterKnife.bind(this);
  }

  @Override
  protected void onDestroy() {
    unbinder.unbind();
    super.onDestroy();
  }
}
