package com.google.android.android.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.dynamic.IObjectWrapper;

public final class zzdcr
  extends zzeb
  implements zzdcq
{
  public zzdcr(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator");
  }
  
  public final zzdco getChat(IObjectWrapper paramIObjectWrapper, zzdcz paramZzdcz)
    throws RemoteException
  {
    Object localObject = zzax();
    zzed.get((Parcel)localObject, paramIObjectWrapper);
    zzed.append((Parcel)localObject, paramZzdcz);
    paramZzdcz = get(1, (Parcel)localObject);
    paramIObjectWrapper = paramZzdcz.readStrongBinder();
    if (paramIObjectWrapper == null)
    {
      paramIObjectWrapper = null;
    }
    else
    {
      localObject = paramIObjectWrapper.queryLocalInterface("com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
      if ((localObject instanceof zzdco)) {
        paramIObjectWrapper = (zzdco)localObject;
      } else {
        paramIObjectWrapper = new zzdcp(paramIObjectWrapper);
      }
    }
    paramZzdcz.recycle();
    return paramIObjectWrapper;
  }
}
