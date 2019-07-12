package com.google.android.android.internal;

import com.google.android.android.common.package_9.internal.c;
import com.google.android.gms.common.api.internal.zzn;

public final class zzasn
  extends zzasf
{
  public zzn<com.google.android.gms.common.api.Status> zzebk;
  
  public zzasn(c paramC)
  {
    zzebk = paramC;
  }
  
  public final void saveAndExit(com.google.android.android.common.package_9.Status paramStatus)
  {
    zzebk.setResult(paramStatus);
  }
}
