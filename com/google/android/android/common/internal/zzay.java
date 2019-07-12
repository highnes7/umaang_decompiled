package com.google.android.android.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzay
  implements zzax
{
  public final IBinder zzajx;
  
  public zzay(IBinder paramIBinder)
  {
    zzajx = paramIBinder;
  }
  
  public final IBinder asBinder()
  {
    return zzajx;
  }
  
  public final void rename(zzav paramZzav, CommandResult paramCommandResult)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
      localParcel1.writeStrongBinder(paramZzav.asBinder());
      localParcel1.writeInt(1);
      paramCommandResult.writeToParcel(localParcel1, 0);
      zzajx.transact(46, localParcel1, localParcel2, 0);
      localParcel2.readException();
      localParcel2.recycle();
      localParcel1.recycle();
      return;
    }
    catch (Throwable paramZzav)
    {
      localParcel2.recycle();
      localParcel1.recycle();
      throw paramZzav;
    }
  }
}
