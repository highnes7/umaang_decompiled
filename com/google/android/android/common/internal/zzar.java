package com.google.android.android.common.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.android.internal.zzeb;

public final class zzar
  extends zzeb
  implements zzap
{
  public zzar(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.common.internal.ICancelToken");
  }
  
  public final void cancel()
    throws RemoteException
  {
    set(2, zzax());
  }
}
