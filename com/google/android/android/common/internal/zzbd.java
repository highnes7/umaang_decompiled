package com.google.android.android.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.dynamic.IObjectWrapper;
import com.google.android.android.dynamic.IObjectWrapper.zza;
import com.google.android.android.internal.zzeb;
import com.google.android.android.internal.zzed;

public final class zzbd
  extends zzeb
  implements zzbc
{
  public zzbd(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
  }
  
  public final IObjectWrapper getChat(IObjectWrapper paramIObjectWrapper, zzbu paramZzbu)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramIObjectWrapper);
    zzed.append(localParcel, paramZzbu);
    paramIObjectWrapper = get(2, localParcel);
    paramZzbu = IObjectWrapper.zza.zzao(paramIObjectWrapper.readStrongBinder());
    paramIObjectWrapper.recycle();
    return paramZzbu;
  }
}
