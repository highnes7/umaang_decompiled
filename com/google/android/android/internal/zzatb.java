package com.google.android.android.internal;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.auth.dashclock.proxy.ProxyResponse;

public abstract class zzatb
  extends zzec
  implements zzata
{
  public zzatb()
  {
    attachInterface(this, "com.google.android.gms.auth.api.internal.IAuthCallbacks");
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (connect(paramInt1, paramParcel1, paramParcel2, paramInt2)) {
      return true;
    }
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        return false;
      }
      zzel(paramParcel1.readString());
    }
    else
    {
      setDisplayMode((ProxyResponse)zzed.get(paramParcel1, ProxyResponse.CREATOR));
    }
    paramParcel2.writeNoException();
    return true;
  }
}
