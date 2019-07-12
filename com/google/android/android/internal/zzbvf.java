package com.google.android.android.internal;

import android.os.RemoteException;

public final class zzbvf
  extends com.google.android.gms.internal.zzbvd<Boolean>
{
  public zzbvf(int paramInt, String paramString, Boolean paramBoolean)
  {
    super(0, paramString, paramBoolean);
  }
  
  private final Boolean apply(zzbvl paramZzbvl)
  {
    try
    {
      String str = getKey();
      Object localObject = zzil();
      localObject = (Boolean)localObject;
      boolean bool = paramZzbvl.getBooleanFlagValue(str, ((Boolean)localObject).booleanValue(), getSource());
      return Boolean.valueOf(bool);
    }
    catch (RemoteException paramZzbvl)
    {
      for (;;) {}
    }
    return (Boolean)zzil();
  }
}
