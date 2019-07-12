package com.google.android.android.internal;

import android.os.Binder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.android.auth.dashclock.signin.GoogleSignInAccount;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.package_9.Status;

public abstract class zzcpz
  extends zzec
  implements zzcpy
{
  public zzcpz()
  {
    attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (connect(paramInt1, paramParcel1, paramParcel2, paramInt2)) {
      return true;
    }
    Parcelable.Creator localCreator;
    if (paramInt1 != 3)
    {
      if ((paramInt1 != 4) && (paramInt1 != 6))
      {
        if (paramInt1 != 7)
        {
          if (paramInt1 != 8) {
            return false;
          }
          enqueue((zzcqf)zzed.get(paramParcel1, zzcqf.CREATOR));
          break label107;
        }
        zzed.get(paramParcel1, Status.CREATOR);
        localCreator = GoogleSignInAccount.CREATOR;
      }
      else
      {
        localCreator = Status.CREATOR;
      }
    }
    else
    {
      zzed.get(paramParcel1, ConnectionResult.CREATOR);
      localCreator = zzcpv.CREATOR;
    }
    zzed.get(paramParcel1, localCreator);
    label107:
    paramParcel2.writeNoException();
    return true;
  }
}
