package com.hpl.howlong.page;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.hpl.howlong.R;
import com.hpl.howlong.data.AppData;
import com.hpl.howlong.javabean.DurationRecord;
import com.hpl.howlong.page.add.AddRecordFragment;
import com.hpl.howlong.page.detail.DetailFragment;
import com.hpl.howlong.page.recordlist.RecordListFragment;
import com.hpl.howlong.thirdpart.message.RxBus;
import com.hpl.howlong.toolkit.page.BaseActivity;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.hwangjr.rxbus.thread.EventThread;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private RecordListFragment recordListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        setSupportActionBar(toolbar);

        recordListFragment = new RecordListFragment();
        recordListFragment.setHowLongList(AppData.data.recordList);
        addSupportFragment(R.id.fragmentContainerFl, recordListFragment);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_activity, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.record_list_context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.addItem) {
            toCreateRecord();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.addButton)
    public void onViewClicked() {
        toCreateRecord();
    }

    public void toCreateRecord() {
        addSupportFragment(R.id.containerFl, new AddRecordFragment());
    }

    void endCreateRecord() {
        removeSupportFragment(AddRecordFragment.class.getSimpleName());
    }

    void deleteRecord(DurationRecord record){

    }

    void toUpdateRecord(){

    }

    void closeUpdateRecord(){

    }

    void toRetrieveRecord(){
        addSupportFragment(R.id.containerFl, new DetailFragment());
    }

    void endRetrieveRecord(){
        removeSupportFragment(DetailFragment.class.getSimpleName());
    }

    @Subscribe(tags = {@Tag(RxBus.TAG_REMOVE_FRAGMENT)}, thread = EventThread.MAIN_THREAD)
    public void onAddSupportFragment(Object event){
        removeSupportFragment((Fragment) event);
    }

    @Subscribe(tags = {@Tag(RxBus.TAG_HIDE_FRAGMENT)}, thread = EventThread.MAIN_THREAD)
    public void onHideSupportFragment(Object event){
        hideSupportFragment((Fragment) event);
    }

    @Subscribe(tags = {@Tag(RxBus.TAG_SHOW_FRAGMENT)}, thread = EventThread.MAIN_THREAD)
    public void onShowSupportFragment(Object event){
        hideSupportFragment((Fragment) event);
    }

}
