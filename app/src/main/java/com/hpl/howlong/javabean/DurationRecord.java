package com.hpl.howlong.javabean;

import com.hpl.howlong.orm.DurationRecordOrm;
import com.hpl.howlong.toolkit.TimeUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Hpl on 2018/1/18 0018.
 */

public class DurationRecord {
    public String name;
    public Calendar createTime;
    public String detail;
    public long expectDuration;
    public long takeDuration;

    public DurationRecord() {
        createTime = Calendar.getInstance();
    }

    public DurationRecord from(DurationRecordOrm dbDate){
        name = dbDate.name;
        createTime = TimeUtil.utcToLocalCalendar(dbDate.createTime);
        detail = dbDate.detail;
        expectDuration = dbDate.expectDuration;
        takeDuration = dbDate.takeDuration;
        return this;
    }

    public static List<DurationRecord> from(List<DurationRecordOrm> dbDates){
        List<DurationRecord> records = new ArrayList<>(dbDates.size());
        for (DurationRecordOrm dbDate : dbDates){
            records.add(new DurationRecord().from(dbDate));
        }
        return records;
    }
}
