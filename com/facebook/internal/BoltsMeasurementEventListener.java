package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.facebook.appevents.AppEventsLogger;
import java.util.Iterator;
import java.util.Set;
import support.android.v4.content.LocalBroadcastManager;

public class BoltsMeasurementEventListener
  extends BroadcastReceiver
{
  public static final String BOLTS_MEASUREMENT_EVENT_PREFIX = "bf_";
  public static final String MEASUREMENT_EVENT_ARGS_KEY = "event_args";
  public static final String MEASUREMENT_EVENT_NAME_KEY = "event_name";
  public static final String MEASUREMENT_EVENT_NOTIFICATION_NAME = "com.parse.bolts.measurement_event";
  public static BoltsMeasurementEventListener _instance;
  public Context applicationContext;
  
  public BoltsMeasurementEventListener(Context paramContext)
  {
    applicationContext = paramContext.getApplicationContext();
  }
  
  private void close()
  {
    LocalBroadcastManager.getInstance(applicationContext).unregisterReceiver(this);
  }
  
  public static BoltsMeasurementEventListener getInstance(Context paramContext)
  {
    BoltsMeasurementEventListener localBoltsMeasurementEventListener = _instance;
    if (localBoltsMeasurementEventListener != null) {
      return localBoltsMeasurementEventListener;
    }
    _instance = new BoltsMeasurementEventListener(paramContext);
    _instance.open();
    return _instance;
  }
  
  private void open()
  {
    LocalBroadcastManager.getInstance(applicationContext).registerReceiver(this, new IntentFilter("com.parse.bolts.measurement_event"));
  }
  
  public void finalize()
    throws Throwable
  {
    try
    {
      close();
      super.finalize();
      return;
    }
    catch (Throwable localThrowable)
    {
      super.finalize();
      throw localThrowable;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = AppEventsLogger.newLogger(paramContext);
    Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("bf_");
    ((StringBuilder)localObject).append(paramIntent.getStringExtra("event_name"));
    localObject = ((StringBuilder)localObject).toString();
    paramIntent = paramIntent.getBundleExtra("event_args");
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramIntent.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localBundle.putString(str.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String)paramIntent.get(str));
    }
    paramContext.logEvent((String)localObject, localBundle);
  }
}
