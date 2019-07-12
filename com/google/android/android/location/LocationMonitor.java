package com.google.android.android.location;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.internal.zzeb;
import com.google.android.android.internal.zzed;

public final class LocationMonitor
  extends zzeb
  implements LocationBackend
{
  public LocationMonitor(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.location.ILocationListener");
  }
  
  public final void onLocationChanged(Location paramLocation)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramLocation);
    set(1, localParcel);
  }
}
