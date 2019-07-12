package com.google.android.android.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzatf
  extends zzeb
  implements zzate
{
  public zzatf(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
  }
  
  public final void updateVisibility(zzatg paramZzatg)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramZzatg);
    add(1, localParcel);
  }
}
