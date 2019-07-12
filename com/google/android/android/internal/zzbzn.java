package com.google.android.android.internal;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.location.LocationSettingsResult;

public abstract class zzbzn
  extends zzec
  implements zzbzm
{
  public zzbzn()
  {
    attachInterface(this, "com.google.android.gms.location.internal.ISettingsCallbacks");
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (connect(paramInt1, paramParcel1, paramParcel2, paramInt2)) {
      return true;
    }
    if (paramInt1 == 1)
    {
      publishUpdate((LocationSettingsResult)zzed.get(paramParcel1, LocationSettingsResult.CREATOR));
      return true;
    }
    return false;
  }
}
