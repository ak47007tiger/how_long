package com.hpl.howlong.page.recordlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hpl.howlong.R;
import com.hpl.howlong.javabean.HowLongRecord;
import com.hpl.howlong.page.contract.IRecordList;
import com.hpl.howlong.page.detail.DetailFragment;
import com.hpl.howlong.toolkit.page.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hpl on 2018/1/18.
 */

public class RecordListFragment extends BaseFragment implements IRecordList {

  List<HowLongRecord> records;

  @BindView(R.id.recordListRv)
  RecyclerView recordListRv;

  private ListAdapter listAdapter;

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    listAdapter = new ListAdapter();
    recordListRv.setAdapter(listAdapter);
    recordListRv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager
        .VERTICAL, false));
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
    if (null != listAdapter)
      listAdapter.notifyDataSetChanged();
  }

  private class ListItemHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.nameAndCreateTimeTv)
    TextView nameAndCreateTimeTv;
    @BindView(R.id.expectDurationTv)
    TextView expectDurationTv;
    @BindView(R.id.takeDurationTv)
    TextView takeDurationTv;
    @BindView(R.id.progressTv)
    TextView progressTv;
    @BindView(R.id.detailTv)
    TextView detailTv;
    @BindView(R.id.editBtn)
    Button editBtn;
    @BindView(R.id.deleteBtn)
    Button deleteBtn;

    ListItemHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(itemView);
    }

  }

  View.OnClickListener onDeleteListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      HowLongRecord record = (HowLongRecord) v.getTag();
    }
  };

  private View.OnClickListener onEditListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      HowLongRecord record = (HowLongRecord) v.getTag();
    }
  };

  private View.OnClickListener onItemClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      int position = recordListRv.getLayoutManager().getPosition(v);
      HowLongRecord record = (HowLongRecord) v.getTag();
      DetailFragment detailFragment = new DetailFragment();
      getActivity().getFragmentManager().beginTransaction().add(detailFragment, "DetailFragment")
          .commit();
    }
  };

  private class ListAdapter extends RecyclerView.Adapter<ListItemHolder> {

    @Override
    public ListItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View itemView = LayoutInflater.from(getActivity()).inflate(R.layout.record_list_item,
          parent, false);
      itemView.setOnClickListener(onItemClickListener);
      ListItemHolder holder = new ListItemHolder(itemView);
      holder.editBtn.setOnClickListener(onEditListener);
      holder.deleteBtn.setOnClickListener(onDeleteListener);
      return holder;
    }

    @Override
    public void onBindViewHolder(ListItemHolder holder, int position) {
      HowLongRecord record = records.get(position);
      holder.itemView.setTag(record);
      holder.editBtn.setTag(record);
      holder.deleteBtn.setTag(record);
    }

    @Override
    public int getItemCount() {
      if (records == null)
        return 0;
      return records.size();
    }
  }

}
