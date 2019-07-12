package com.google.android.android.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.android.auth.dashclock.accounttransfer.DeviceMetaData;
import com.google.android.android.auth.dashclock.accounttransfer.MapPack;
import com.google.android.android.auth.dashclock.accounttransfer.Profile;
import com.google.android.android.common.package_9.Status;

public abstract interface zzart
  extends IInterface
{
  public abstract void addProfile(Status paramStatus, Profile paramProfile)
    throws RemoteException;
  
  public abstract void generateKey(byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract void onException(DeviceMetaData paramDeviceMetaData)
    throws RemoteException;
  
  public abstract void onFailure(Status paramStatus)
    throws RemoteException;
  
  public abstract void write(Status paramStatus)
    throws RemoteException;
  
  public abstract void write(Status paramStatus, MapPack paramMapPack)
    throws RemoteException;
  
  public abstract void zzzy()
    throws RemoteException;
}
