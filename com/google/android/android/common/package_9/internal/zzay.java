package com.google.android.android.common.package_9.internal;

import com.google.android.android.internal.zzcpx;
import com.google.android.android.internal.zzcqf;
import java.lang.ref.WeakReference;

public final class zzay
  extends zzcpx
{
  public final WeakReference<com.google.android.gms.common.api.internal.zzar> zzfly;
  
  public zzay(zzar paramZzar)
  {
    zzfly = new WeakReference(paramZzar);
  }
  
  public final void enqueue(zzcqf paramZzcqf)
  {
    zzar localZzar = (zzar)zzfly.get();
    if (localZzar == null) {
      return;
    }
    zzflh.enqueue(new zzaz(this, localZzar, localZzar, paramZzcqf));
  }
}
