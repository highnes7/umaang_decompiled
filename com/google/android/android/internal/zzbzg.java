package com.google.android.android.internal;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbzg
  extends zzec
  implements zzbzf
{
  public zzbzg()
  {
    attachInterface(this, "com.google.android.gms.location.internal.IFusedLocationProviderCallback");
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (connect(paramInt1, paramParcel1, paramParcel2, paramInt2)) {
      return true;
    }
    if (paramInt1 == 1)
    {
      publishUpdate((zzbyz)zzed.get(paramParcel1, zzbyz.CREATOR));
      return true;
    }
    return false;
  }
}
