package com.google.android.android.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.dynamic.IObjectWrapper;
import com.google.android.android.dynamic.IObjectWrapper.zza;
import com.google.android.android.internal.zzeb;
import com.google.android.android.internal.zzed;

public final class ItemAdapter
  extends zzeb
  implements Array
{
  public ItemAdapter(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
  }
  
  public final IObjectWrapper getAbsoluteUrl(IObjectWrapper paramIObjectWrapper, String paramString, int paramInt)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramIObjectWrapper);
    localParcel.writeString(paramString);
    localParcel.writeInt(paramInt);
    paramIObjectWrapper = get(2, localParcel);
    paramString = IObjectWrapper.zza.zzao(paramIObjectWrapper.readStrongBinder());
    paramIObjectWrapper.recycle();
    return paramString;
  }
  
  public final int insert(IObjectWrapper paramIObjectWrapper, String paramString, boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramIObjectWrapper);
    localParcel.writeString(paramString);
    zzed.append(localParcel, paramBoolean);
    paramIObjectWrapper = get(3, localParcel);
    int i = paramIObjectWrapper.readInt();
    paramIObjectWrapper.recycle();
    return i;
  }
}
