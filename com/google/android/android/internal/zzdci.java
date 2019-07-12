package com.google.android.android.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.dynamic.IObjectWrapper;

public final class zzdci
  extends zzeb
  implements zzdch
{
  public zzdci(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
  }
  
  public final zzdcf getChat(IObjectWrapper paramIObjectWrapper, zzdcc paramZzdcc)
    throws RemoteException
  {
    Object localObject = zzax();
    zzed.get((Parcel)localObject, paramIObjectWrapper);
    zzed.append((Parcel)localObject, paramZzdcc);
    paramZzdcc = get(1, (Parcel)localObject);
    paramIObjectWrapper = paramZzdcc.readStrongBinder();
    if (paramIObjectWrapper == null)
    {
      paramIObjectWrapper = null;
    }
    else
    {
      localObject = paramIObjectWrapper.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
      if ((localObject instanceof zzdcf)) {
        paramIObjectWrapper = (zzdcf)localObject;
      } else {
        paramIObjectWrapper = new zzdcg(paramIObjectWrapper);
      }
    }
    paramZzdcc.recycle();
    return paramIObjectWrapper;
  }
}
