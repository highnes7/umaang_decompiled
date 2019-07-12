package com.google.android.android.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.dynamic.IObjectWrapper;
import com.google.android.android.dynamic.IObjectWrapper.zza;
import com.google.android.android.internal.zzeb;
import com.google.android.android.internal.zzed;

public final class Utils
  extends zzeb
  implements OkHttpClient
{
  public Utils(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
  }
  
  public final IObjectWrapper getAbsoluteUrl(IObjectWrapper paramIObjectWrapper1, String paramString, int paramInt, IObjectWrapper paramIObjectWrapper2)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramIObjectWrapper1);
    localParcel.writeString(paramString);
    localParcel.writeInt(paramInt);
    zzed.get(localParcel, paramIObjectWrapper2);
    paramIObjectWrapper1 = get(2, localParcel);
    paramString = IObjectWrapper.zza.zzao(paramIObjectWrapper1.readStrongBinder());
    paramIObjectWrapper1.recycle();
    return paramString;
  }
}
