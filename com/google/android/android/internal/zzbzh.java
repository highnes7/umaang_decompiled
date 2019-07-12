package com.google.android.android.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbzh
  extends zzeb
  implements zzbzf
{
  public zzbzh(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.location.internal.IFusedLocationProviderCallback");
  }
  
  public final void publishUpdate(zzbyz paramZzbyz)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramZzbyz);
    set(1, localParcel);
  }
}
