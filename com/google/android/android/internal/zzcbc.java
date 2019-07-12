package com.google.android.android.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.Log;

public abstract class zzcbc
{
  public static volatile Handler zzdqs;
  public final Runnable currentTask;
  public volatile long zzdqt;
  public final zzccw zziki;
  public boolean zzine;
  
  public zzcbc(zzccw paramZzccw)
  {
    zzbp.append(paramZzccw);
    zziki = paramZzccw;
    zzine = true;
    currentTask = new zzcbd(this);
  }
  
  private final Handler getHandler()
  {
    if (zzdqs != null) {
      return zzdqs;
    }
    try
    {
      if (zzdqs == null) {
        zzdqs = new Handler(zziki.getContext().getMainLooper());
      }
      Handler localHandler = zzdqs;
      return localHandler;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void cancel()
  {
    zzdqt = 0L;
    getHandler().removeCallbacks(currentTask);
  }
  
  public final void setAlarm(long paramLong)
  {
    cancel();
    if (paramLong >= 0L)
    {
      zzdqt = zziki.zzvx().currentTimeMillis();
      if (!getHandler().postDelayed(currentTask, paramLong)) {
        zziki.zzaul().zzayd().append("Failed to schedule delayed post. time", Long.valueOf(paramLong));
      }
    }
  }
  
  public abstract void startSession();
  
  public final boolean zzdp()
  {
    return zzdqt != 0L;
  }
}
