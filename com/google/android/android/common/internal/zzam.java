package com.google.android.android.common.internal;

import android.accounts.Account;
import android.os.IInterface;
import android.os.RemoteException;

public abstract interface zzam
  extends IInterface
{
  public abstract Account getAccount()
    throws RemoteException;
}
