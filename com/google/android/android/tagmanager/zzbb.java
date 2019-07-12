package com.google.android.android.tagmanager;

import android.content.Context;

public final class zzbb
  implements zzby
{
  public static final Object zzjon = new Object();
  public static zzbb zzjrb;
  public zzek zzjpp;
  public zzbz zzjrc;
  
  public zzbb(Context paramContext)
  {
    this(zzca.zzdw(paramContext), new zzfm());
  }
  
  public zzbb(zzbz paramZzbz, zzek paramZzek)
  {
    zzjrc = paramZzbz;
    zzjpp = paramZzek;
  }
  
  public static zzby zzdq(Context paramContext)
  {
    Object localObject = zzjon;
    try
    {
      if (zzjrb == null) {
        zzjrb = new zzbb(paramContext);
      }
      paramContext = zzjrb;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public final boolean zzlo(String paramString)
  {
    if (!zzjpp.zzys())
    {
      zzdj.zzjss.zzcr("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
      return false;
    }
    zzjrc.zzlt(paramString);
    return true;
  }
}
