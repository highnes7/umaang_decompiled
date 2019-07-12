package com.google.android.android.internal;

import android.app.PendingIntent;
import android.os.IInterface;
import android.os.RemoteException;

public abstract interface zzbzi
  extends IInterface
{
  public abstract void a(int paramInt, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void setSpeedAdjustmentAlgorithm(int paramInt, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void speak(int paramInt, String[] paramArrayOfString)
    throws RemoteException;
}
