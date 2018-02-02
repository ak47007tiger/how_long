package com.hpl.howlong.page.add;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.hpl.howlong.R;
import com.hpl.howlong.data.Config;
import com.hpl.howlong.javabean.DurationRecord;
import com.hpl.howlong.page.contract.IRecordView;
import com.hpl.howlong.thirdpart.message.RxBus;
import com.hpl.howlong.toolkit.ViewValue;
import com.hpl.howlong.toolkit.page.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Hpl on 2018/1/18.
 */

public class AddRecordFragment extends BaseFragment implements IRecordView {

    private DurationRecord durationRecord;

    @BindView(R.id.nameEt)
    EditText nameEt;
    @BindView(R.id.detailEt)
    EditText detailEt;

    @BindView(R.id.dayEt)
    EditText dayEt;
    @BindView(R.id.hourEt)
    EditText hourEt;
    @BindView(R.id.minuteEt)
    EditText minuteEt;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setDurationRecord(durationRecord);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.add_fragment;
    }

    public void setDurationRecord(DurationRecord durationRecord) {
        this.durationRecord = durationRecord;
        if (isAdded() || durationRecord == null) return;

        nameEt.setText(durationRecord.name);
        detailEt.setText(durationRecord.detail);

        int days = (int) (durationRecord.expectDuration / (3600 * 24));
        int hours = (int) (durationRecord.expectDuration / 3600);
        int minutes = (int) (durationRecord.expectDuration % 3600 / 60);
        dayEt.setText(String.valueOf(days));
        hourEt.setText(String.valueOf(hours));
        minuteEt.setText(String.valueOf(minutes));
    }

    public DurationRecord collectDataFromUI() {
        if (durationRecord == null)
            durationRecord = new DurationRecord();

        durationRecord.name = ViewValue.getStr(nameEt, Config.default_for_empty);
        durationRecord.detail = ViewValue.getStr(detailEt, Config.default_for_empty);

        int days = getInt(dayEt, 0);
        int hours = getInt(hourEt, 0);
        int minutes = getInt(minuteEt, 0);
        durationRecord.expectDuration = days * (3600 * 24) + hours * 36000 + minutes * 60;
        return durationRecord;
    }

    @OnClick({R.id.closeBtn, R.id.addBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.closeBtn:
                RxBus.post(RxBus.tag_test,"");
                RxBus.post(RxBus.TAG_REMOVE_FRAGMENT,this);
                break;
            case R.id.addBtn:
                RxBus.post(RxBus.TAG_CREATED_NEW_RECORD,collectDataFromUI());
                RxBus.post(RxBus.TAG_REMOVE_FRAGMENT,this);
                break;
        }
    }

}
