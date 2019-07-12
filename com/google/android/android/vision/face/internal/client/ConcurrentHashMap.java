package com.google.android.android.vision.face.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.dynamic.IObjectWrapper;
import com.google.android.android.internal.zzdck;
import com.google.android.android.internal.zzeb;
import com.google.android.android.internal.zzed;

public final class ConcurrentHashMap
  extends zzeb
  implements XYSeries
{
  public ConcurrentHashMap(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
  }
  
  public final FaceParcel[] get(IObjectWrapper paramIObjectWrapper, zzdck paramZzdck)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramIObjectWrapper);
    zzed.append(localParcel, paramZzdck);
    paramIObjectWrapper = get(1, localParcel);
    paramZzdck = (FaceParcel[])paramIObjectWrapper.createTypedArray(FaceParcel.CREATOR);
    paramIObjectWrapper.recycle();
    return paramZzdck;
  }
  
  public final void zzbin()
    throws RemoteException
  {
    add(3, zzax());
  }
  
  public final boolean zzeu(int paramInt)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    localParcel.writeInt(paramInt);
    localParcel = get(2, localParcel);
    boolean bool = zzed.readString(localParcel);
    localParcel.recycle();
    return bool;
  }
}
