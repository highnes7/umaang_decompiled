package com.google.android.android.auth.dashclock.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.auth.dashclock.signin.GoogleSignInOptions;
import com.google.android.android.internal.zzeb;
import com.google.android.android.internal.zzed;

public final class Logger
  extends zzeb
  implements Log
{
  public Logger(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
  }
  
  public final void i(c paramC, GoogleSignInOptions paramGoogleSignInOptions)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramC);
    zzed.append(localParcel, paramGoogleSignInOptions);
    add(102, localParcel);
  }
  
  public final void ignore(c paramC, GoogleSignInOptions paramGoogleSignInOptions)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramC);
    zzed.append(localParcel, paramGoogleSignInOptions);
    add(101, localParcel);
  }
  
  public final void setLevel(c paramC, GoogleSignInOptions paramGoogleSignInOptions)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramC);
    zzed.append(localParcel, paramGoogleSignInOptions);
    add(103, localParcel);
  }
}
