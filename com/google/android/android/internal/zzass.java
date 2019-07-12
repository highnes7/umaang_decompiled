package com.google.android.android.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.android.auth.dashclock.credentials.Credential;
import com.google.android.android.common.package_9.Status;

public abstract interface zzass
  extends IInterface
{
  public abstract void lstat(Status paramStatus, String paramString)
    throws RemoteException;
  
  public abstract void saveAndExit(Status paramStatus)
    throws RemoteException;
  
  public abstract void saveOutput(Status paramStatus, Credential paramCredential)
    throws RemoteException;
}
