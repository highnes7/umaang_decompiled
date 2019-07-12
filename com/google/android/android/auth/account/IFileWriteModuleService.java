package com.google.android.android.auth.account;

import android.accounts.Account;
import android.os.IInterface;
import android.os.RemoteException;

public abstract interface IFileWriteModuleService
  extends IInterface
{
  public abstract void clear(IPlayMedia_0_8 paramIPlayMedia_0_8, Account paramAccount)
    throws RemoteException;
  
  public abstract void handleResult(IPlayMedia_0_8 paramIPlayMedia_0_8, String paramString)
    throws RemoteException;
  
  public abstract void zzap(boolean paramBoolean)
    throws RemoteException;
}
