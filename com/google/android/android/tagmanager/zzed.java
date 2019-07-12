package com.google.android.android.tagmanager;

import com.google.android.android.common.util.Log;

public final class zzed
  implements zzfx
{
  public zzed(zzec paramZzec) {}
  
  public final void goTo(zzbx paramZzbx)
  {
    zzec.goTo(zzjtd, paramZzbx.zzbdr());
    long l = paramZzbx.zzbdr();
    paramZzbx = new StringBuilder(57);
    paramZzbx.append("Permanent failure dispatching hitId: ");
    paramZzbx.append(l);
    paramZzbx = paramZzbx.toString();
    zzdj.zzjss.append(paramZzbx);
  }
  
  public final void remind(zzbx paramZzbx)
  {
    long l = paramZzbx.zzbds();
    if (l == 0L)
    {
      zzec.setDate(zzjtd, paramZzbx.zzbdr(), zzec.openDatabase(zzjtd).currentTimeMillis());
      return;
    }
    if (l + 14400000L < zzec.openDatabase(zzjtd).currentTimeMillis())
    {
      zzec.goTo(zzjtd, paramZzbx.zzbdr());
      l = paramZzbx.zzbdr();
      paramZzbx = new StringBuilder(47);
      paramZzbx.append("Giving up on failed hitId: ");
      paramZzbx.append(l);
      paramZzbx = paramZzbx.toString();
      zzdj.zzjss.append(paramZzbx);
    }
  }
  
  public final void removeParameter(zzbx paramZzbx)
  {
    zzec.goTo(zzjtd, paramZzbx.zzbdr());
  }
}
