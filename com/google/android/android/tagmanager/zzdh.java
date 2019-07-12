package com.google.android.android.tagmanager;

import com.google.android.android.common.util.Log;

public final class zzdh
  implements zzek
{
  public final Log zzasc;
  public final String zzdmr;
  public final long zzdtc = 900000L;
  public final int zzdtd = 5;
  public double zzdte = Math.min(1, 5);
  public long zzdtf;
  public final Object zzdtg = new Object();
  public final long zzjsr = 5000L;
  
  public zzdh(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString, Log paramLog)
  {
    zzdmr = paramString;
    zzasc = paramLog;
  }
  
  public final boolean zzys()
  {
    Object localObject = zzdtg;
    try
    {
      long l1 = zzasc.currentTimeMillis();
      if (l1 - zzdtf < zzjsr)
      {
        str = zzdmr;
        localStringBuilder = new StringBuilder(String.valueOf(str).length() + 34);
        localStringBuilder.append("Excessive ");
        localStringBuilder.append(str);
        localStringBuilder.append(" detected; call ignored.");
        str = localStringBuilder.toString();
        zzdj.zzjss.zzcr(str);
        return false;
      }
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
      str = localStringBuilder.toString();
      zzdj.zzjss.zzcr(str);
      return false;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
