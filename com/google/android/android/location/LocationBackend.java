package com.google.android.android.location;

import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;

public abstract interface LocationBackend
  extends IInterface
{
  public abstract void onLocationChanged(Location paramLocation)
    throws RemoteException;
}
