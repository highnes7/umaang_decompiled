package com.google.android.android.auth.dashclock.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.android.auth.dashclock.signin.GoogleSignInOptions;

public abstract interface Log
  extends IInterface
{
  public abstract void i(c paramC, GoogleSignInOptions paramGoogleSignInOptions)
    throws RemoteException;
  
  public abstract void ignore(c paramC, GoogleSignInOptions paramGoogleSignInOptions)
    throws RemoteException;
  
  public abstract void setLevel(c paramC, GoogleSignInOptions paramGoogleSignInOptions)
    throws RemoteException;
}
