package com.google.android.android.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import com.google.android.android.internal.zzcfh;
import com.google.android.android.internal.zzcfk;

@TargetApi(24)
public final class AppMeasurementJobService
  extends JobService
  implements zzcfk
{
  public zzcfh zzikt;
  
  public AppMeasurementJobService() {}
  
  private final zzcfh zzatt()
  {
    if (zzikt == null) {
      zzikt = new zzcfh((Context)this);
    }
    return zzikt;
  }
  
  public final boolean callServiceStopSelfResult(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void makeView(JobParameters paramJobParameters, boolean paramBoolean)
  {
    jobFinished(paramJobParameters, false);
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
  
  public final boolean onStartJob(JobParameters paramJobParameters)
  {
    return zzatt().onStartJob(paramJobParameters);
  }
  
  public final boolean onStopJob(JobParameters paramJobParameters)
  {
    return false;
  }
  
  public final boolean onUnbind(Intent paramIntent)
  {
    return zzatt().onUnbind(paramIntent);
  }
}
