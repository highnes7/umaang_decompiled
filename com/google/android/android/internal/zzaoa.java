package com.google.android.android.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.Log;

public final class zzaoa
  extends zzams
{
  public boolean zzdqv;
  public boolean zzdqw;
  public final AlarmManager zzdqx = (AlarmManager)getContext().getSystemService("alarm");
  public Integer zzdqy;
  
  public zzaoa(zzamu paramZzamu)
  {
    super(paramZzamu);
  }
  
  private final int getJobId()
  {
    if (zzdqy == null)
    {
      String str = String.valueOf(getContext().getPackageName());
      if (str.length() != 0) {
        str = "analytics".concat(str);
      } else {
        str = new String("analytics");
      }
      zzdqy = Integer.valueOf(str.hashCode());
    }
    return zzdqy.intValue();
  }
  
  private final PendingIntent zzyk()
  {
    Intent localIntent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
    localIntent.setComponent(new ComponentName(getContext(), "com.google.android.gms.analytics.AnalyticsReceiver"));
    return PendingIntent.getBroadcast(getContext(), 0, localIntent, 0);
  }
  
  public final void cancel()
  {
    zzdqw = false;
    zzdqx.cancel(zzyk());
    if (Build.VERSION.SDK_INT >= 24)
    {
      JobScheduler localJobScheduler = (JobScheduler)getContext().getSystemService("jobscheduler");
      d("Cancelling job. JobID", Integer.valueOf(getJobId()));
      localJobScheduler.cancel(getJobId());
    }
  }
  
  public final void schedule()
  {
    zzwk();
    zzbp.append(zzdqv, "Receiver not registered");
    long l1 = zzanv.zzxy();
    if (l1 > 0L)
    {
      cancel();
      long l2 = zzvx().elapsedRealtime();
      zzdqw = true;
      if (Build.VERSION.SDK_INT >= 24)
      {
        zzdm("Scheduling upload with JobScheduler");
        Object localObject = new ComponentName(getContext(), "com.google.android.gms.analytics.AnalyticsJobService");
        JobScheduler localJobScheduler = (JobScheduler)getContext().getSystemService("jobscheduler");
        localObject = new JobInfo.Builder(getJobId(), (ComponentName)localObject);
        ((JobInfo.Builder)localObject).setMinimumLatency(l1);
        ((JobInfo.Builder)localObject).setOverrideDeadline(l1 << 1);
        PersistableBundle localPersistableBundle = new PersistableBundle();
        localPersistableBundle.putString("action", "com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        ((JobInfo.Builder)localObject).setExtras(localPersistableBundle);
        localObject = ((JobInfo.Builder)localObject).build();
        d("Scheduling job. JobID", Integer.valueOf(getJobId()));
        localJobScheduler.schedule((JobInfo)localObject);
        return;
      }
      zzdm("Scheduling upload with AlarmManager");
      zzdqx.setInexactRepeating(2, l2 + l1, l1, zzyk());
    }
  }
  
  public final boolean zzdp()
  {
    return zzdqw;
  }
  
  public final void zzuk()
  {
    try
    {
      cancel();
      long l = zzanv.zzxy();
      if (l > 0L)
      {
        Object localObject = getContext().getPackageManager();
        localObject = ((PackageManager)localObject).getReceiverInfo(new ComponentName(getContext(), "com.google.android.gms.analytics.AnalyticsReceiver"), 2);
        if ((localObject != null) && (enabled))
        {
          zzdm("Receiver registered for local dispatch.");
          zzdqv = true;
          return;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
  }
  
  public final boolean zzyj()
  {
    return zzdqv;
  }
}
