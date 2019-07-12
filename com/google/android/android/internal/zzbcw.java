package com.google.android.android.internal;

import android.os.RemoteException;
import com.google.android.android.common.package_9.internal.c;
import com.google.android.gms.common.api.internal.zzn;

public final class zzbcw
  extends zzbcq
{
  public final zzn<com.google.android.gms.common.api.Status> zzfwi;
  
  public zzbcw(c paramC)
  {
    zzfwi = paramC;
  }
  
  public final void zzcg(int paramInt)
    throws RemoteException
  {
    zzfwi.setResult(new com.google.android.android.common.package_9.Status(1, paramInt, null, null));
  }
}
