package com.google.android.android.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.internal.zzec;
import com.google.android.android.internal.zzed;

public abstract class zzaw
  extends zzec
  implements zzav
{
  public zzaw()
  {
    attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
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
      browse(paramParcel1.readInt(), (Bundle)zzed.get(paramParcel1, Bundle.CREATOR));
    }
    else
    {
      onSearchFinished(paramParcel1.readInt(), paramParcel1.readStrongBinder(), (Bundle)zzed.get(paramParcel1, Bundle.CREATOR));
    }
    paramParcel2.writeNoException();
    return true;
  }
}
