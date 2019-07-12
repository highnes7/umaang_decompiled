package com.google.android.android.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzarw
  extends zzeb
  implements zzarv
{
  public zzarw(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferService");
  }
  
  public final void addElement(zzart paramZzart, zzarr paramZzarr)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramZzart);
    zzed.append(localParcel, paramZzarr);
    add(7, localParcel);
  }
  
  public final void addElement(zzart paramZzart, zzasd paramZzasd)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramZzart);
    zzed.append(localParcel, paramZzasd);
    add(8, localParcel);
  }
  
  public final void printStackTrace(zzart paramZzart, zzarx paramZzarx)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramZzart);
    zzed.append(localParcel, paramZzarx);
    add(9, localParcel);
  }
  
  public final void printStackTrace(zzart paramZzart, zzarz paramZzarz)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramZzart);
    zzed.append(localParcel, paramZzarz);
    add(6, localParcel);
  }
  
  public final void printStackTrace(zzart paramZzart, zzasb paramZzasb)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramZzart);
    zzed.append(localParcel, paramZzasb);
    add(5, localParcel);
  }
}
