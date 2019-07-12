package com.google.android.android.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.android.internal.zzcfh;
import com.google.android.android.internal.zzcfk;
import support.android.v4.content.WakefulBroadcastReceiver;

public final class AppMeasurementService
  extends Service
  implements zzcfk
{
  public zzcfh zzikt;
  
  public AppMeasurementService() {}
  
  private final zzcfh zzatt()
  {
    if (zzikt == null) {
      zzikt = new zzcfh(this);
    }
    return zzikt;
  }
  
  public final boolean callServiceStopSelfResult(int paramInt)
  {
    return stopSelfResult(paramInt);
  }
  
  public final void makeView(JobParameters paramJobParameters, boolean paramBoolean)
  {
    throw new UnsupportedOperationException();
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    return zzatt().onBind(paramIntent);
  }
  
  public final void onCreate()
  {
    super.onCreate();
    zzatt().onCreate();
  }
  
  public final void onDestroy()
  {
    zzatt().onDestroy();
    super.onDestroy();
  }
  
  public final void onRebind(Intent paramIntent)
  {
    zzatt().onRebind(paramIntent);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    zzatt().onStartCommand(paramIntent, paramInt1, paramInt2);
    WakefulBroadcastReceiver.completeWakefulIntent(paramIntent);
    return 2;
  }
  
  public final boolean onUnbind(Intent paramIntent)
  {
    return zzatt().onUnbind(paramIntent);
  }
}
