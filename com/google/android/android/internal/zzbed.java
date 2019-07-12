package com.google.android.android.internal;

import android.content.Context;

public final class zzbed
{
  public static zzbed zzfzt = new zzbed();
  public zzbec zzfzs = null;
  
  public zzbed() {}
  
  private final zzbec zzcq(Context paramContext)
  {
    try
    {
      if (zzfzs == null)
      {
        if (paramContext.getApplicationContext() != null) {
          paramContext = paramContext.getApplicationContext();
        }
        zzfzs = new zzbec(paramContext);
      }
      paramContext = zzfzs;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static zzbec zzcr(Context paramContext)
  {
    return zzfzt.zzcq(paramContext);
  }
}
