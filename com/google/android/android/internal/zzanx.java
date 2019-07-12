package com.google.android.android.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.Log;

public abstract class zzanx
{
  public static volatile Handler zzdqs;
  public final Runnable currentTask;
  public final zzamu zzdod;
  public volatile long zzdqt;
  
  public zzanx(zzamu paramZzamu)
  {
    zzbp.append(paramZzamu);
    zzdod = paramZzamu;
    currentTask = new zzany(this);
  }
  
  private final Handler getHandler()
  {
    if (zzdqs != null) {
      return zzdqs;
    }
    try
    {
      if (zzdqs == null) {
        zzdqs = new Handler(zzdod.getContext().getMainLooper());
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
  
  public abstract void retrieveToken();
  
  public final void update(long paramLong)
  {
    if (!zzdp()) {
      return;
    }
    if (paramLong < 0L)
    {
      cancel();
      return;
    }
    long l = paramLong - Math.abs(zzdod.zzvx().currentTimeMillis() - zzdqt);
    paramLong = l;
    if (l < 0L) {
      paramLong = 0L;
    }
    getHandler().removeCallbacks(currentTask);
    if (!getHandler().postDelayed(currentTask, paramLong)) {
      zzdod.zzvy().toString("Failed to adjust delayed post. time", Long.valueOf(paramLong));
    }
  }
  
  public final void updateTimer(long paramLong)
  {
    cancel();
    if (paramLong >= 0L)
    {
      zzdqt = zzdod.zzvx().currentTimeMillis();
      if (!getHandler().postDelayed(currentTask, paramLong)) {
        zzdod.zzvy().toString("Failed to schedule delayed post. time", Long.valueOf(paramLong));
      }
    }
  }
  
  public final boolean zzdp()
  {
    return zzdqt != 0L;
  }
  
  public final long zzyg()
  {
    if (zzdqt == 0L) {
      return 0L;
    }
    return Math.abs(zzdod.zzvx().currentTimeMillis() - zzdqt);
  }
}
