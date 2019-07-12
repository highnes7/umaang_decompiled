package com.google.android.android.internal;

import android.os.RemoteException;

public final class zzbvi
  extends com.google.android.gms.internal.zzbvd<String>
{
  public zzbvi(int paramInt, String paramString1, String paramString2)
  {
    super(0, paramString1, paramString2);
  }
  
  private final String f(zzbvl paramZzbvl)
  {
    try
    {
      String str = getKey();
      Object localObject = zzil();
      localObject = (String)localObject;
      paramZzbvl = paramZzbvl.getStringFlagValue(str, (String)localObject, getSource());
      return paramZzbvl;
    }
    catch (RemoteException paramZzbvl)
    {
      for (;;) {}
    }
    return (String)zzil();
  }
}
