package com.hpl.howlong.page.add;

import android.widget.EditText;

import com.hpl.howlong.R;
import com.hpl.howlong.toolkit.page.BaseFragment;

/**
 * Created by Hpl on 2018/1/18.
 */

public class AddRecordFragment extends BaseFragment{

  EditText name;

  @Override
  protected int getLayoutId() {
    return R.layout.add_fragment;
  }
}
