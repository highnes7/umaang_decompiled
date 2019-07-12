package com.google.android.android.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.dynamic.IObjectWrapper;
import com.google.android.android.dynamic.IObjectWrapper.zza;
import com.google.android.android.internal.zzeb;

public final class zzau
  extends zzeb
  implements zzas
{
  public zzau(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.common.internal.ICertData");
  }
  
  public final IObjectWrapper zzaez()
    throws RemoteException
  {
    Parcel localParcel = get(1, zzax());
    IObjectWrapper localIObjectWrapper = IObjectWrapper.zza.zzao(localParcel.readStrongBinder());
    localParcel.recycle();
    return localIObjectWrapper;
  }
  
  public final int zzafa()
    throws RemoteException
  {
    Parcel localParcel = get(2, zzax());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }
}
