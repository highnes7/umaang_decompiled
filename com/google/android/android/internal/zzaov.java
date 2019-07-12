package com.google.android.android.internal;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.PersistableBundle;
import com.google.android.android.common.internal.zzbp;
import com.google.android.gms.internal.zzaoy;

public final class zzaov<T extends Context,  extends zzaoy>
{
  public static Boolean zzdty;
  public final Handler mHandler;
  public final T zzdtx;
  
  public zzaov(Context paramContext)
  {
    zzbp.append(paramContext);
    zzdtx = paramContext;
    mHandler = new Handler();
  }
  
  private final void putInteger(Integer paramInteger, JobParameters paramJobParameters)
  {
    zzamu localZzamu = zzamu.zzbg(zzdtx);
    zzaon localZzaon = localZzamu.zzvy();
    localZzamu.zzwc().addKey(new zzaow(this, paramInteger, localZzamu, localZzaon, paramJobParameters));
  }
  
  public static boolean zzbi(Context paramContext)
  {
    zzbp.append(paramContext);
    Boolean localBoolean = zzdty;
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    boolean bool = zzapd.enable(paramContext, "com.google.android.gms.analytics.AnalyticsService");
    zzdty = Boolean.valueOf(bool);
    return bool;
  }
  
  public final void onCreate()
  {
    zzamu.zzbg(zzdtx).zzvy().zzdm("Local AnalyticsService is starting up");
  }
  
  public final void onDestroy()
  {
    zzamu.zzbg(zzdtx).zzvy().zzdm("Local AnalyticsService is shutting down");
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Object localObject = zzaou.zzaqd;
    try
    {
      zzcqh localZzcqh = zzaou.zzdtw;
      if ((localZzcqh != null) && (localZzcqh.isHeld())) {
        localZzcqh.release();
      }
    }
    catch (Throwable localThrowable) {}
    try
    {
      throw localThrowable;
      localObject = zzamu.zzbg(zzdtx).zzvy();
      if (paramIntent == null)
      {
        ((zzamr)localObject).zzdp("AnalyticsService started with null intent");
        return 2;
      }
      paramIntent = paramIntent.getAction();
      ((zzamr)localObject).add("Local AnalyticsService called. startId, action", Integer.valueOf(paramInt2), paramIntent);
      if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(paramIntent))
      {
        putInteger(Integer.valueOf(paramInt2), null);
        return 2;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;) {}
    }
    return 2;
  }
  
  public final boolean onStartJob(JobParameters paramJobParameters)
  {
    zzaon localZzaon = zzamu.zzbg(zzdtx).zzvy();
    String str = paramJobParameters.getExtras().getString("action");
    localZzaon.d("Local AnalyticsJobService called. action", str);
    if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(str)) {
      putInteger(null, paramJobParameters);
    }
    return true;
  }
}
