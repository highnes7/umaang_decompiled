package com.google.android.android.analytics;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import com.google.android.android.internal.zzaoy;

@TargetApi(24)
public final class AnalyticsJobService
  extends JobService
  implements zzaoy
{
  public com.google.android.gms.internal.zzaov<com.google.android.gms.analytics.AnalyticsJobService> zzdjl;
  
  public AnalyticsJobService() {}
  
  private final com.google.android.android.internal.zzaov zztt()
  {
    if (zzdjl == null) {
      zzdjl = new com.google.android.android.internal.zzaov((Context)this);
    }
    return zzdjl;
  }
  
  public final boolean callServiceStopSelfResult(int paramInt)
  {
    return stopSelfResult(paramInt);
  }
  
  public final void makeView(JobParameters paramJobParameters, boolean paramBoolean)
  {
    jobFinished(paramJobParameters, false);
  }
  
  public final void onCreate()
  {
    super.onCreate();
    zztt().onCreate();
  }
  
  public final void onDestroy()
  {
    zztt().onDestroy();
    super.onDestroy();
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return zztt().onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public final boolean onStartJob(JobParameters paramJobParameters)
  {
    return zztt().onStartJob(paramJobParameters);
  }
  
  public final boolean onStopJob(JobParameters paramJobParameters)
  {
    return false;
  }
}
