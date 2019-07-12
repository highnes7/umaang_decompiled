package com.google.android.android.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbzj
  extends zzec
  implements zzbzi
{
  public zzbzj()
  {
    attachInterface(this, "com.google.android.gms.location.internal.IGeofencerCallbacks");
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (connect(paramInt1, paramParcel1, paramParcel2, paramInt2)) {
      return true;
    }
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          return false;
        }
        setSpeedAdjustmentAlgorithm(paramParcel1.readInt(), (PendingIntent)zzed.get(paramParcel1, PendingIntent.CREATOR));
        return true;
      }
      speak(paramParcel1.readInt(), paramParcel1.createStringArray());
      return true;
    }
    a(paramParcel1.readInt(), paramParcel1.createStringArray());
    return true;
  }
}
