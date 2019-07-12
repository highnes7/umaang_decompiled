package com.google.android.android.common.package_9.internal;

import java.util.concurrent.locks.Lock;

public abstract class zzbm
{
  public final zzbk zzfnh;
  
  public zzbm(zzbk paramZzbk)
  {
    zzfnh = paramZzbk;
  }
  
  public final void setResolution(zzbl paramZzbl)
  {
    zzfke.lock();
    try
    {
      zzbk localZzbk1 = zzfnd;
      zzbk localZzbk2 = zzfnh;
      if (localZzbk1 != localZzbk2)
      {
        zzfke.unlock();
        return;
      }
      zzagz();
      zzfke.unlock();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzfke.unlock();
      throw localThrowable;
    }
  }
  
  public abstract void zzagz();
}
