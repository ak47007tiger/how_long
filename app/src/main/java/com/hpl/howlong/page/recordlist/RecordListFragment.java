package com.hpl.howlong.page.recordlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hpl.howlong.R;
import com.hpl.howlong.javabean.HowLongRecord;
import com.hpl.howlong.page.contract.IRecordList;
import com.hpl.howlong.toolkit.page.BaseFragment;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Hpl on 2018/1/18.
 */

public class RecordListFragment extends BaseFragment implements IRecordList{

  List<HowLongRecord> records;

  @BindView(R.id.recordListRv)
  RecyclerView recordListRv;

  private ListAdapter listAdapter;

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    listAdapter = new ListAdapter();
    recordListRv.setAdapter(listAdapter);
    recordListRv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
  }

  @Override
  protected int getLayoutId() {
    return R.layout.record_list_fragment;
  }

  @Override
  public void setHowLongList(List<HowLongRecord> records) {
    this.records = records;
    updateList();
  }

  @Override
  public void updateList() {
    if(null != listAdapter)
      listAdapter.notifyDataSetChanged();
  }

  private class ListItemHolder extends RecyclerView.ViewHolder{

    TextView nameTv;
    TextView summaryTv;
    TextView createTimeTv;
    TextView expectDurationTv;
    TextView takeDurationTv;
    TextView progressTv;

    public ListItemHolder(View itemView) {
      super(itemView);
    }
  }

  private class ListAdapter extends RecyclerView.Adapter<ListItemHolder>{

    @Override
    public ListItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      return new ListItemHolder(LayoutInflater.from(getActivity()).inflate(R.layout.record_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ListItemHolder holder, int position) {
      HowLongRecord record = records.get(position);

    }

    @Override
    public int getItemCount() {
      if(records==null)
        return 0;
      return records.size();
    }
  }
}
