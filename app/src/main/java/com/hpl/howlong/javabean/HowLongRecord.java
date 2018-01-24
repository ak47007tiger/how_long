package com.hpl.howlong.javabean;

import java.util.Date;

/**
 * Created by Hpl on 2018/1/18 0018.
 */

public class HowLongRecord {
    public String name;
    public Date createTime;
    public String detail;
    public long expectDuration;
    public long takeDuration;

    public boolean processing;
    public long startIncreaseTime;
}
