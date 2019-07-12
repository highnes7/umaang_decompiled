package com.google.android.android.tagmanager;

import com.google.android.android.common.util.Clock;
import com.google.android.android.common.util.Log;

public final class zzfm
  implements zzek
{
  public final Log zzasc = Clock.zzfyr;
  public final long zzdtc = 2000L;
  public final int zzdtd = 60;
  public double zzdte = zzdtd;
  public final Object zzdtg = new Object();
  public long zzjve;
  
  public zzfm()
  {
    this(60, 2000L);
  }
  
  public zzfm(int paramInt, long paramLong) {}
  
  public final boolean zzys()
  {
    Object localObject = zzdtg;
    try
    {
      long l1 = zzasc.currentTimeMillis();
      if (zzdte < zzdtd)
      {
        double d1 = l1 - zzjve;
        long l2 = zzdtc;
        double d2 = l2;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        if (d1 > 0.0D) {
          zzdte = Math.min(zzdtd, zzdte + d1);
        }
      }
      zzjve = l1;
      if (zzdte >= 1.0D)
      {
        zzdte -= 1.0D;
        return true;
      }
      zzdj.zzjss.zzcr("No more tokens available.");
      return false;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
