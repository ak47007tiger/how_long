package com.hpl.howlong.toolkit.page;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle.components.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Hpl on 2018/1/18.
 */

public abstract class BaseFragment extends RxFragment{

  private Unbinder unbinder;

  protected int getLayoutId(){
    return -1;
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle
      savedInstanceState) {
    int layoutId = getLayoutId();
    if(layoutId == -1) return super.onCreateView(inflater, container, savedInstanceState);

    return inflater.inflate(layoutId, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    unbinder = ButterKnife.bind(this, view);
  }

  @Override
  public void onDestroyView() {
    unbinder.unbind();
    super.onDestroyView();
  }
}
