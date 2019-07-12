package com.google.android.android.auth.dashclock.signin.internal;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.auth.dashclock.signin.GoogleSignInAccount;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.internal.zzec;
import com.google.android.android.internal.zzed;

public abstract class d
  extends zzec
  implements c
{
  public d()
  {
    attachInterface(this, "com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (connect(paramInt1, paramParcel1, paramParcel2, paramInt2)) {
      return true;
    }
    switch (paramInt1)
    {
    default: 
      return false;
    case 103: 
      remove((Status)zzed.get(paramParcel1, Status.CREATOR));
      break;
    case 102: 
      close((Status)zzed.get(paramParcel1, Status.CREATOR));
      break;
    case 101: 
      add((GoogleSignInAccount)zzed.get(paramParcel1, GoogleSignInAccount.CREATOR), (Status)zzed.get(paramParcel1, Status.CREATOR));
    }
    paramParcel2.writeNoException();
    return true;
  }
}
