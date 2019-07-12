package com.google.android.android.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzew
  extends zzec
  implements zzev
{
  public static zzev execute(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    if ((localIInterface instanceof zzev)) {
      return (zzev)localIInterface;
    }
    return new zzex(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    throw new NoSuchMethodError();
  }
}
