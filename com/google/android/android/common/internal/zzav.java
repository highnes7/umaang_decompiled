package com.google.android.android.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

public abstract interface zzav
  extends IInterface
{
  public abstract void browse(int paramInt, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void onSearchFinished(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    throws RemoteException;
}
