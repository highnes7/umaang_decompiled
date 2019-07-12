package com.google.android.android.internal;

import com.google.android.android.common.util.Log;

public final class zzaol
{
  public final Log zzasc;
  public final String zzdmr;
  public final long zzdtc = 2000L;
  public final int zzdtd = 60;
  public double zzdte = zzdtd;
  public long zzdtf;
  public final Object zzdtg = new Object();
  
  public zzaol(int paramInt, long paramLong, String paramString, Log paramLog)
  {
    zzdmr = paramString;
    zzasc = paramLog;
  }
  
  public zzaol(String paramString, Log paramLog)
  {
    this(60, 2000L, paramString, paramLog);
  }
  
  public final boolean zzys()
  {
    Object localObject = zzdtg;
    try
    {
      long l1 = zzasc.currentTimeMillis();
      if (zzdte < zzdtd)
      {
        double d1 = l1 - zzdtf;
        long l2 = zzdtc;
        double d2 = l2;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        if (d1 > 0.0D) {
          zzdte = Math.min(zzdtd, zzdte + d1);
        }
      }
      zzdtf = l1;
      if (zzdte >= 1.0D)
      {
        zzdte -= 1.0D;
        return true;
      }
      String str = zzdmr;
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 34);
      localStringBuilder.append("Excessive ");
      localStringBuilder.append(str);
      localStringBuilder.append(" detected; call ignored.");
      zzaom.zzcr(localStringBuilder.toString());
      return false;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
