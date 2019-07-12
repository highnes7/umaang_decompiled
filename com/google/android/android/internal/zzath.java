package com.google.android.android.internal;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.common.package_9.Status;

public abstract class zzath
  extends zzec
  implements zzatg
{
  public zzath()
  {
    attachInterface(this, "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverResultCallback");
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (connect(paramInt1, paramParcel1, paramParcel2, paramInt2)) {
      return true;
    }
    if (paramInt1 == 1)
    {
      createGroup((Status)zzed.get(paramParcel1, Status.CREATOR));
      return true;
    }
    return false;
  }
}
