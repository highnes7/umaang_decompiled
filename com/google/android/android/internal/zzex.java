package com.google.android.android.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzex
  extends zzeb
  implements zzev
{
  public zzex(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
  }
  
  public final boolean getErrorMessage(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, true);
    localParcel = get(2, localParcel);
    paramBoolean = zzed.readString(localParcel);
    localParcel.recycle();
    return paramBoolean;
  }
  
  public final String getId()
    throws RemoteException
  {
    Parcel localParcel = get(1, zzax());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }
}
