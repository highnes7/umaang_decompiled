package com.google.android.android.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.android.location.LocationSettingsResult;

public abstract interface zzbzm
  extends IInterface
{
  public abstract void publishUpdate(LocationSettingsResult paramLocationSettingsResult)
    throws RemoteException;
}
