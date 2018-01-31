package com.hpl.howlong.page;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.hpl.howlong.R;
import com.hpl.howlong.page.add.AddRecordFragment;
import com.hpl.howlong.page.recordlist.RecordListFragment;
import com.hpl.howlong.toolkit.page.BaseActivity;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {

  private RecordListFragment recordListFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.home_activity);

    recordListFragment = new RecordListFragment();

    getFragmentManager()
        .beginTransaction()
        .add(R.id.fragmentContainerFl, recordListFragment,RecordListFragment.class.getSimpleName())
        .commit();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.hone_activity, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == R.id.addItem){
      getFragmentManager()
              .beginTransaction()
              .add(R.id.fragmentContainerFl, new AddRecordFragment(), AddRecordFragment.class.getSimpleName())
              .commit();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
