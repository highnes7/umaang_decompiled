package com.google.android.android.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import com.google.android.android.common.util.Log;

public final class zzcfr
  extends zzcdu
{
  public final AlarmManager zzdqx = (AlarmManager)getContext().getSystemService("alarm");
  public Integer zzdqy;
  public final zzcbc zziwx;
  
  public zzcfr(zzccw paramZzccw)
  {
    super(paramZzccw);
    zziwx = new zzcfs(this, paramZzccw);
  }
  
  private final int getJobId()
  {
    if (zzdqy == null)
    {
      String str = String.valueOf(getContext().getPackageName());
      if (str.length() != 0) {
        str = "measurement".concat(str);
      } else {
        str = new String("measurement");
      }
      zzdqy = Integer.valueOf(str.hashCode());
    }
    return zzdqy.intValue();
  }
  
  private final void zzazv()
  {
    JobScheduler localJobScheduler = (JobScheduler)getContext().getSystemService("jobscheduler");
    zzaul().zzayj().append("Cancelling job. JobID", Integer.valueOf(getJobId()));
    localJobScheduler.cancel(getJobId());
  }
  
  private final void zzazw()
  {
    Intent localIntent = new Intent();
    Context localContext = getContext();
    zzcax.zzawk();
    localIntent = localIntent.setClassName(localContext, "com.google.android.gms.measurement.AppMeasurementReceiver");
    localIntent.setAction("com.google.android.gms.measurement.UPLOAD");
    getContext().sendBroadcast(localIntent);
  }
  
  private final PendingIntent zzyk()
  {
    Intent localIntent = new Intent();
    Context localContext = getContext();
    zzcax.zzawk();
    localIntent = localIntent.setClassName(localContext, "com.google.android.gms.measurement.AppMeasurementReceiver");
    localIntent.setAction("com.google.android.gms.measurement.UPLOAD");
    return PendingIntent.getBroadcast(getContext(), 0, localIntent, 0);
  }
  
  public final void cancel()
  {
    zzwk();
    zzdqx.cancel(zzyk());
    zziwx.cancel();
    if (Build.VERSION.SDK_INT >= 24) {
      zzazv();
    }
  }
  
  public final void setAlarm(long paramLong)
  {
    zzwk();
    zzcax.zzawk();
    if (!zzccn.listen(getContext(), false)) {
      zzaul().zzayi().append("Receiver not registered/enabled");
    }
    zzcax.zzawk();
    if (!zzcfh.load(getContext(), false)) {
      zzaul().zzayi().append("Service not registered/enabled");
    }
    cancel();
    long l = zzvx().elapsedRealtime();
    if ((paramLong < zzcax.zzaxb()) && (!zziwx.zzdp()))
    {
      zzaul().zzayj().append("Scheduling upload with DelayedRunnable");
      zziwx.setAlarm(paramLong);
    }
    zzcax.zzawk();
    if (Build.VERSION.SDK_INT >= 24)
    {
      zzaul().zzayj().append("Scheduling upload with JobScheduler");
      Object localObject = new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementJobService");
      JobScheduler localJobScheduler = (JobScheduler)getContext().getSystemService("jobscheduler");
      localObject = new JobInfo.Builder(getJobId(), (ComponentName)localObject);
      ((JobInfo.Builder)localObject).setMinimumLatency(paramLong);
      ((JobInfo.Builder)localObject).setOverrideDeadline(paramLong << 1);
      PersistableBundle localPersistableBundle = new PersistableBundle();
      localPersistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
      ((JobInfo.Builder)localObject).setExtras(localPersistableBundle);
      localObject = ((JobInfo.Builder)localObject).build();
      zzaul().zzayj().append("Scheduling job. JobID", Integer.valueOf(getJobId()));
      localJobScheduler.schedule((JobInfo)localObject);
      return;
    }
    zzaul().zzayj().append("Scheduling upload with AlarmManager");
    zzdqx.setInexactRepeating(2, l + paramLong, Math.max(zzcax.zzaxc(), paramLong), zzyk());
  }
  
  public final void zzatu()
  {
    zzccw.zzatu();
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void zzatv()
  {
    zzcax.zzawk();
  }
  
  public final void zzuk()
  {
    zzdqx.cancel(zzyk());
    if (Build.VERSION.SDK_INT >= 24) {
      zzazv();
    }
  }
}
