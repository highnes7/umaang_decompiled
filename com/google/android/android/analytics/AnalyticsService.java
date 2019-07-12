package com.google.android.android.analytics;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.android.internal.zzaoy;

public final class AnalyticsService
  extends Service
  implements zzaoy
{
  public com.google.android.gms.internal.zzaov<com.google.android.gms.analytics.AnalyticsService> zzdjl;
  
  public AnalyticsService() {}
  
  private final com.google.android.android.internal.zzaov zztt()
  {
    if (zzdjl == null) {
      zzdjl = new com.google.android.android.internal.zzaov(this);
    }
    return zzdjl;
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
    zztt();
    return null;
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
}
