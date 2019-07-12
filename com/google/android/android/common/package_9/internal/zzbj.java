package com.google.android.android.common.package_9.internal;

import java.lang.ref.WeakReference;

public final class zzbj
  extends zzbz
{
  public WeakReference<com.google.android.gms.common.api.internal.zzbd> zzfmz;
  
  public zzbj(zzbd paramZzbd)
  {
    zzfmz = new WeakReference(paramZzbd);
  }
  
  public final void zzage()
  {
    zzbd localZzbd = (zzbd)zzfmz.get();
    if (localZzbd == null) {
      return;
    }
    zzbd.access$1500(localZzbd);
  }
}
