package com.google.android.android.internal;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.PersistableBundle;
import com.google.android.android.common.internal.zzbp;
import com.google.android.gms.internal.zzcfk;

public final class zzcfh<T extends Context,  extends zzcfk>
{
  public final T zzdtx;
  
  public zzcfh(Context paramContext)
  {
    zzbp.append(paramContext);
    zzdtx = paramContext;
  }
  
  public static boolean load(Context paramContext, boolean paramBoolean)
  {
    zzbp.append(paramContext);
    if (Build.VERSION.SDK_INT >= 24) {}
    for (String str = "com.google.android.gms.measurement.AppMeasurementJobService";; str = "com.google.android.gms.measurement.AppMeasurementService") {
      return zzcfw.enable(paramContext, str);
    }
  }
  
  private final void putInteger(Integer paramInteger, JobParameters paramJobParameters)
  {
    zzccw localZzccw = zzccw.zzdn(zzdtx);
    zzcbw localZzcbw = localZzccw.zzaul();
    localZzccw.zzauk().e(new zzcfi(this, localZzccw, paramInteger, localZzcbw, paramJobParameters));
  }
  
  private final zzcbw zzaul()
  {
    return zzccw.zzdn(zzdtx).zzaul();
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzaul().zzayd().append("onBind called with null intent");
      return null;
    }
    paramIntent = paramIntent.getAction();
    if ("com.google.android.gms.measurement.START".equals(paramIntent)) {
      return new zzcdb(zzccw.zzdn(zzdtx));
    }
    zzaul().zzayf().append("onBind received unknown action", paramIntent);
    return null;
  }
  
  public final void onCreate()
  {
    zzcbw localZzcbw = zzccw.zzdn(zzdtx).zzaul();
    zzcax.zzawk();
    localZzcbw.zzayj().append("Local AppMeasurementService is starting up");
  }
  
  public final void onDestroy()
  {
    zzcbw localZzcbw = zzccw.zzdn(zzdtx).zzaul();
    zzcax.zzawk();
    localZzcbw.zzayj().append("Local AppMeasurementService is shutting down");
  }
  
  public final void onRebind(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzaul().zzayd().append("onRebind called with null intent");
      return;
    }
    paramIntent = paramIntent.getAction();
    zzaul().zzayj().append("onRebind called. action", paramIntent);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    zzcbw localZzcbw = zzccw.zzdn(zzdtx).zzaul();
    if (paramIntent == null)
    {
      localZzcbw.zzayf().append("AppMeasurementService started with null intent");
      return 2;
    }
    paramIntent = paramIntent.getAction();
    zzcax.zzawk();
    localZzcbw.zzayj().append("Local AppMeasurementService called. startId, action", Integer.valueOf(paramInt2), paramIntent);
    if ("com.google.android.gms.measurement.UPLOAD".equals(paramIntent)) {
      putInteger(Integer.valueOf(paramInt2), null);
    }
    return 2;
  }
  
  public final boolean onStartJob(JobParameters paramJobParameters)
  {
    zzcbw localZzcbw = zzccw.zzdn(zzdtx).zzaul();
    String str = paramJobParameters.getExtras().getString("action");
    zzcax.zzawk();
    localZzcbw.zzayj().append("Local AppMeasurementJobService called. action", str);
    if ("com.google.android.gms.measurement.UPLOAD".equals(str)) {
      putInteger(null, paramJobParameters);
    }
    return true;
  }
  
  public final boolean onUnbind(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzaul().zzayd().append("onUnbind called with null intent");
      return true;
    }
    paramIntent = paramIntent.getAction();
    zzaul().zzayj().append("onUnbind called for intent. action", paramIntent);
    return true;
  }
}
