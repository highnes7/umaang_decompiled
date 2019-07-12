package com.google.android.android.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zzeb
  implements IInterface
{
  public final IBinder zzajx;
  public final String zzajy;
  
  public zzeb(IBinder paramIBinder, String paramString)
  {
    zzajx = paramIBinder;
    zzajy = paramString;
  }
  
  public final void add(int paramInt, Parcel paramParcel)
    throws RemoteException
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      zzajx.transact(paramInt, paramParcel, localParcel, 0);
      localParcel.readException();
      paramParcel.recycle();
      localParcel.recycle();
      return;
    }
    catch (Throwable localThrowable)
    {
      paramParcel.recycle();
      localParcel.recycle();
      throw localThrowable;
    }
  }
  
  public IBinder asBinder()
  {
    return zzajx;
  }
  
  public final Parcel get(int paramInt, Parcel paramParcel)
    throws RemoteException
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      zzajx.transact(paramInt, paramParcel, localParcel, 0);
      localParcel.readException();
      paramParcel.recycle();
      return localParcel;
    }
    catch (Throwable localThrowable) {}catch (RuntimeException localRuntimeException)
    {
      localThrowable.recycle();
      throw localRuntimeException;
    }
    paramParcel.recycle();
    throw localThrowable;
  }
  
  public final void set(int paramInt, Parcel paramParcel)
    throws RemoteException
  {
    try
    {
      zzajx.transact(paramInt, paramParcel, null, 1);
      paramParcel.recycle();
      return;
    }
    catch (Throwable localThrowable)
    {
      paramParcel.recycle();
      throw localThrowable;
    }
  }
  
  public final Parcel zzax()
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(zzajy);
    return localParcel;
  }
}
