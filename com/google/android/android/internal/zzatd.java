package com.google.android.android.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.auth.dashclock.proxy.ProxyRequest;

public final class zzatd
  extends zzeb
  implements zzatc
{
  public zzatd(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.api.internal.IAuthService");
  }
  
  public final void printStackTrace(zzata paramZzata, ProxyRequest paramProxyRequest)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramZzata);
    zzed.append(localParcel, paramProxyRequest);
    add(1, localParcel);
  }
}
