package com.google.android.android.internal;

import com.google.android.android.common.package_9.internal.c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzn;

public final class zzbyy
  extends zzbzg
{
  public final zzn<Status> zzfwi;
  
  public zzbyy(c paramC)
  {
    zzfwi = paramC;
  }
  
  public final void publishUpdate(zzbyz paramZzbyz)
  {
    zzfwi.setResult(paramZzbyz.getStatus());
  }
}
