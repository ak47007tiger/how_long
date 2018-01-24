package com.hpl.howlong.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by Hpl on 2018/1/23.
 */

public class KeepAliveService extends IntentService{

  public KeepAliveService(){
    this(KeepAliveService.class.getSimpleName());
  }

  /**
   * Creates an IntentService.  Invoked by your subclass's constructor.
   *
   * @param name Used to name the worker thread, important only for debugging.
   */
  public KeepAliveService(String name) {
    super(name);
  }

  @Override
  protected void onHandleIntent(@Nullable Intent intent) {

  }

}
