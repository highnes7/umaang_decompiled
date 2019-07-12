package com.google.android.android.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.android.dynamic.Integer;
import com.google.android.android.dynamite.DynamiteModule;
import com.google.android.android.dynamite.DynamiteModule.zzc;
import com.google.android.android.dynamite.DynamiteModule.zzd;

public final class zzbvk
{
  public boolean zzaqf = false;
  public zzbvl zzhay = null;
  
  public zzbvk() {}
  
  public final void initialize(Context paramContext)
  {
    try
    {
      if (zzaqf) {
        return;
      }
      localObject = DynamiteModule.zzgpt;
    }
    catch (Throwable paramContext)
    {
      Object localObject;
      label61:
      throw paramContext;
    }
    try
    {
      localObject = zzbvm.asInterface(DynamiteModule.get(paramContext, (DynamiteModule.zzd)localObject, "com.google.android.gms.flags").zzgv("com.google.android.gms.flags.impl.FlagProviderImpl"));
      zzhay = ((zzbvl)localObject);
      localObject = zzhay;
      ((zzbvl)localObject).init(new Integer(paramContext));
      zzaqf = true;
    }
    catch (DynamiteModule.zzc paramContext)
    {
      break label61;
    }
    catch (RemoteException paramContext)
    {
      break label61;
    }
  }
  
  public final Object reduce(zzbvd paramZzbvd)
  {
    try
    {
      if (!zzaqf)
      {
        paramZzbvd = paramZzbvd.zzil();
        return paramZzbvd;
      }
      return paramZzbvd.reduce(zzhay);
    }
    catch (Throwable paramZzbvd)
    {
      throw paramZzbvd;
    }
  }
}
