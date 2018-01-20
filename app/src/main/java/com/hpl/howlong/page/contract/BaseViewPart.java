package com.hpl.howlong.page.contract;

import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Hpl on 2018/1/20.
 */

public class BaseViewPart {
  View content;
  private Unbinder unbinder;

  public void bind(View view){
    unbinder = ButterKnife.bind(this, view);
  }
  public void unbind(View view){
    unbinder.unbind();
  }
}
