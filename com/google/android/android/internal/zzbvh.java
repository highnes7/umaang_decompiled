package com.google.android.android.internal;

import android.os.RemoteException;

public final class zzbvh
  extends com.google.android.gms.internal.zzbvd<Long>
{
  public zzbvh(int paramInt, String paramString, Long paramLong)
  {
    super(0, paramString, paramLong);
  }
  
  private final Long next(zzbvl paramZzbvl)
  {
    try
    {
      String str = getKey();
      Object localObject = zzil();
      localObject = (Long)localObject;
      long l = paramZzbvl.getLongFlagValue(str, ((Long)localObject).longValue(), getSource());
      return Long.valueOf(l);
    }
    catch (RemoteException paramZzbvl)
    {
      for (;;) {}
    }
    return (Long)zzil();
  }
}
