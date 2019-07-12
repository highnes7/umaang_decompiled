package com.google.android.android.internal;

import android.os.RemoteException;

public final class zzbvg
  extends com.google.android.gms.internal.zzbvd<Integer>
{
  public zzbvg(int paramInt, String paramString, Integer paramInteger)
  {
    super(0, paramString, paramInteger);
  }
  
  private final Integer next(zzbvl paramZzbvl)
  {
    try
    {
      String str = getKey();
      Object localObject = zzil();
      localObject = (Integer)localObject;
      int i = paramZzbvl.getIntFlagValue(str, ((Integer)localObject).intValue(), getSource());
      return Integer.valueOf(i);
    }
    catch (RemoteException paramZzbvl)
    {
      for (;;) {}
    }
    return (Integer)zzil();
  }
}
