package com.google.android.android.internal;

import android.app.job.JobParameters;

public final class zzcfi
  implements Runnable
{
  public zzcfi(zzcfh paramZzcfh, zzccw paramZzccw, Integer paramInteger, zzcbw paramZzcbw, JobParameters paramJobParameters) {}
  
  public final void run()
  {
    zzirr.zzazk();
    zzirr.queueEvent(new zzcfj(this));
    zzirr.zzazg();
  }
}
