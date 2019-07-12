package com.google.android.android.location;

import android.os.IInterface;
import android.os.RemoteException;

public abstract interface IOnBufferingUpdateListenerCallback_0_8
  extends IInterface
{
  public abstract void onLocationAvailability(LocationAvailability paramLocationAvailability)
    throws RemoteException;
  
  public abstract void onLocationResult(LocationResult paramLocationResult)
    throws RemoteException;
}
