package com.google.android.android.internal;

import android.os.IInterface;
import android.os.RemoteException;

public abstract interface zzev
  extends IInterface
{
  public abstract boolean getErrorMessage(boolean paramBoolean)
    throws RemoteException;
  
  public abstract String getId()
    throws RemoteException;
}
