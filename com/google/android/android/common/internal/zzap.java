package com.google.android.android.common.internal;

import android.os.IInterface;
import android.os.RemoteException;

public abstract interface zzap
  extends IInterface
{
  public abstract void cancel()
    throws RemoteException;
}
