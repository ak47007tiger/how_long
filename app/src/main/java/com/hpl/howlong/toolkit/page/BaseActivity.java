package com.hpl.howlong.toolkit.page;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.hpl.howlong.thirdpart.message.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.hwangjr.rxbus.thread.EventThread;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Hpl on 2018/1/18.
 */

public abstract class BaseActivity extends RxAppCompatActivity{

  private Unbinder unbinder;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    RxBus.register(this);
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
    RxBus.unregister(this);
    unbinder.unbind();
    super.onDestroy();
  }

  public void addSupportFragment(int id, Fragment fragment){
    addSupportFragment(id, fragment, fragment.getClass().getSimpleName());
  }

  public void addSupportFragment(int id, Fragment fragment, String tag){
    getSupportFragmentManager()
            .beginTransaction()
            .add(id, fragment, tag)
            .commit();
  }

  public void removeSupportFragment(String tag){
    removeSupportFragment(getSupportFragmentManager().findFragmentByTag(tag));
  }

  public void removeSupportFragment(Fragment fragment){
    getSupportFragmentManager()
            .beginTransaction()
            .remove(fragment)
            .commit();
  }

  public void hideSupportFragment(Fragment fragment){
    getSupportFragmentManager()
            .beginTransaction()
            .hide(fragment)
            .commit();
  }

  public void showSupportFragment(Fragment fragment){
    getSupportFragmentManager()
            .beginTransaction()
            .show(fragment)
            .commit();
  }

}
