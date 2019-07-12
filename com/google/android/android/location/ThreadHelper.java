package com.google.android.android.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.internal.zzeb;
import com.google.android.android.internal.zzed;

public final class ThreadHelper
  extends zzeb
  implements IOnBufferingUpdateListenerCallback_0_8
{
  public ThreadHelper(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.location.ILocationCallback");
  }
  
  public final void onLocationAvailability(LocationAvailability paramLocationAvailability)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramLocationAvailability);
    set(2, localParcel);
  }
  
  public final void onLocationResult(LocationResult paramLocationResult)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramLocationResult);
    set(1, localParcel);
  }
}
