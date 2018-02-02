package com.hpl.howlong.toolkit;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Hpl on 2017/3/9 0009.
 */

public class TimeUtil {
  public static String getDateTimeStr24h(Calendar calendar){
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH) + 1;
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    int hour = calendar.get(Calendar.HOUR);
    int amPm = calendar.get(Calendar.AM_PM);
    if (Calendar.PM == amPm){
      hour += 12;
    }
    int minute = calendar.get(Calendar.MINUTE);
    String dateStr = String.format("%d/%d/%d", year, month, day);
    String timeStr = (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute);
    return dateStr + " " + timeStr;
  }

  public static String getDateTimeStr12h(Calendar calendar){
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH) + 1;
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    int hour = calendar.get(Calendar.HOUR);
    int amPm = calendar.get(Calendar.AM_PM);
    if (amPm == Calendar.PM && hour == 0){
      hour += 12;
    }
    String amPmDisplayName = calendar.getDisplayName(Calendar.AM_PM, Calendar.SHORT, Locale.getDefault());;
    /*if (amPm == Calendar.PM){
      amPmDisplayName = calendar.getDisplayName(Calendar.AM_PM, Calendar.SHORT, Locale.getDefault());
    }else {
      amPmDisplayName = calendar.getDisplayName(Calendar.AM_PM, Calendar.SHORT, Locale.getDefault());
    }*/
    int minute = calendar.get(Calendar.MINUTE);
    String dateStr = String.format("%d/%d/%d", year, month, day);
    String timeStr = (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute);
    return dateStr + " " + timeStr + " " + amPmDisplayName;
  }

  public static String getTimeStr24h(Calendar calendar){
    int hour = calendar.get(Calendar.HOUR);
    int amPm = calendar.get(Calendar.AM_PM);
    if (Calendar.PM == amPm){
      hour += 12;
    }
    int minute = calendar.get(Calendar.MINUTE);
    String timeStr = (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute);
    return timeStr;
  }

  public static long getUtcTime(){
    return System.currentTimeMillis() - TimeZone.getDefault().getRawOffset();
  }

  public static long getLocalTime(long utcTime){
    return utcTime + TimeZone.getDefault().getRawOffset();
  }

  public static Calendar utcToLocalCalendar(long utc){
    Calendar instance = Calendar.getInstance();
    instance.setTimeInMillis(getLocalTime(utc));
    return instance;
  }

  public static long localCalendarToUtc(Calendar calendar){
    return calendar.getTimeInMillis() - TimeZone.getDefault().getRawOffset();
  }

}
