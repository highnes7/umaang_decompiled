package com.google.android.android.internal;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.auth.dashclock.credentials.Credential;
import com.google.android.android.common.package_9.Status;

public abstract class zzast
  extends zzec
  implements zzass
{
  public zzast()
  {
    attachInterface(this, "com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (connect(paramInt1, paramParcel1, paramParcel2, paramInt2)) {
      return true;
    }
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          return false;
        }
        lstat((Status)zzed.get(paramParcel1, Status.CREATOR), paramParcel1.readString());
      }
      else
      {
        saveAndExit((Status)zzed.get(paramParcel1, Status.CREATOR));
      }
    }
    else {
      saveOutput((Status)zzed.get(paramParcel1, Status.CREATOR), (Credential)zzed.get(paramParcel1, Credential.CREATOR));
    }
    paramParcel2.writeNoException();
    return true;
  }
}
