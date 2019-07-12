package com.google.android.android.common.package_9.internal;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.internal.zzec;
import com.google.android.android.internal.zzed;

public abstract class zzcc
  extends zzec
  implements zzcb
{
  public zzcc()
  {
    attachInterface(this, "com.google.android.gms.common.api.internal.IStatusCallback");
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (connect(paramInt1, paramParcel1, paramParcel2, paramInt2)) {
      return true;
    }
    if (paramInt1 == 1)
    {
      vibrate((Status)zzed.get(paramParcel1, Status.CREATOR));
      return true;
    }
    return false;
  }
}
