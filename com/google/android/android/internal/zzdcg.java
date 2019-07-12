package com.google.android.android.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.dynamic.IObjectWrapper;
import com.google.android.android.vision.barcode.Barcode;

public final class zzdcg
  extends zzeb
  implements zzdcf
{
  public zzdcg(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
  }
  
  public final Barcode[] getSuggestions(IObjectWrapper paramIObjectWrapper, zzdck paramZzdck)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramIObjectWrapper);
    zzed.append(localParcel, paramZzdck);
    paramIObjectWrapper = get(1, localParcel);
    paramZzdck = (Barcode[])paramIObjectWrapper.createTypedArray(Barcode.CREATOR);
    paramIObjectWrapper.recycle();
    return paramZzdck;
  }
  
  public final Barcode[] readFromParcel(IObjectWrapper paramIObjectWrapper, zzdck paramZzdck)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramIObjectWrapper);
    zzed.append(localParcel, paramZzdck);
    paramIObjectWrapper = get(2, localParcel);
    paramZzdck = (Barcode[])paramIObjectWrapper.createTypedArray(Barcode.CREATOR);
    paramIObjectWrapper.recycle();
    return paramZzdck;
  }
  
  public final void zzbin()
    throws RemoteException
  {
    add(3, zzax());
  }
}
