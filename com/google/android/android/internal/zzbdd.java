package com.google.android.android.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbdd
  extends zzeb
  implements zzbdc
{
  public zzbdd(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.common.internal.service.ICommonService");
  }
  
  public final void replaceComment(zzbda paramZzbda)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramZzbda);
    set(1, localParcel);
  }
}
