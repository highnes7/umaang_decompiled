package com.google.android.android.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.dynamic.IObjectWrapper;

public final class zzdcp
  extends zzeb
  implements zzdco
{
  public zzdcp(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
  }
  
  public final zzdcs[] readFromParcel(IObjectWrapper paramIObjectWrapper, zzdck paramZzdck, zzdcu paramZzdcu)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramIObjectWrapper);
    zzed.append(localParcel, paramZzdck);
    zzed.append(localParcel, paramZzdcu);
    paramIObjectWrapper = get(3, localParcel);
    paramZzdck = (zzdcs[])paramIObjectWrapper.createTypedArray(zzdcs.CREATOR);
    paramIObjectWrapper.recycle();
    return paramZzdck;
  }
  
  public final void zzbiq()
    throws RemoteException
  {
    add(2, zzax());
  }
}
