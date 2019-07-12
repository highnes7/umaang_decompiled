package com.google.android.android.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zzec
  extends Binder
  implements IInterface
{
  public zzec() {}
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public final boolean connect(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 > 16777215) {
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    paramParcel1.enforceInterface(getInterfaceDescriptor());
    return false;
  }
}
