package com.hpl.howlong.page;

import android.os.Bundle;

import com.hpl.howlong.R;
import com.hpl.howlong.page.recordlist.RecordListFragment;
import com.hpl.howlong.toolkit.page.BaseActivity;

public class HomeActivity extends BaseActivity {

  private RecordListFragment recordListFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.home_activity);

    recordListFragment = new RecordListFragment();

    getFragmentManager()
        .beginTransaction()
        .add(R.id.fragmentContainerFl, recordListFragment,"RecordListFragment")
        .commit();
  }

}
