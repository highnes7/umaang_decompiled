package com.google.android.android.auth.dashclock.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.android.auth.dashclock.signin.GoogleSignInAccount;
import com.google.android.android.common.package_9.Status;

public abstract interface c
  extends IInterface
{
  public abstract void add(GoogleSignInAccount paramGoogleSignInAccount, Status paramStatus)
    throws RemoteException;
  
  public abstract void close(Status paramStatus)
    throws RemoteException;
  
  public abstract void remove(Status paramStatus)
    throws RemoteException;
}
