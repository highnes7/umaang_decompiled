package com.google.android.android.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.dynamic.IObjectWrapper;

public final class zzbvn
  extends zzeb
  implements zzbvl
{
  public zzbvn(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.flags.IFlagProvider");
  }
  
  public final boolean getBooleanFlagValue(String paramString, boolean paramBoolean, int paramInt)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    localParcel.writeString(paramString);
    zzed.append(localParcel, paramBoolean);
    localParcel.writeInt(paramInt);
    paramString = get(2, localParcel);
    paramBoolean = zzed.readString(paramString);
    paramString.recycle();
    return paramBoolean;
  }
  
  public final int getIntFlagValue(String paramString, int paramInt1, int paramInt2)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    localParcel.writeString(paramString);
    localParcel.writeInt(paramInt1);
    localParcel.writeInt(paramInt2);
    paramString = get(3, localParcel);
    paramInt1 = paramString.readInt();
    paramString.recycle();
    return paramInt1;
  }
  
  public final long getLongFlagValue(String paramString, long paramLong, int paramInt)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    localParcel.writeString(paramString);
    localParcel.writeLong(paramLong);
    localParcel.writeInt(paramInt);
    paramString = get(4, localParcel);
    paramLong = paramString.readLong();
    paramString.recycle();
    return paramLong;
  }
  
  public final String getStringFlagValue(String paramString1, String paramString2, int paramInt)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeInt(paramInt);
    paramString1 = get(5, localParcel);
    paramString2 = paramString1.readString();
    paramString1.recycle();
    return paramString2;
  }
  
  public final void init(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramIObjectWrapper);
    add(1, localParcel);
  }
}
