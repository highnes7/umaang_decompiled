package com.google.android.android.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

public final class zzaok
  extends zzeb
  implements zzaoj
{
  public zzaok(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.analytics.internal.IAnalyticsService");
  }
  
  public final void sendHit(Map paramMap, long paramLong, String paramString, List paramList)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    localParcel.writeMap(paramMap);
    localParcel.writeLong(paramLong);
    localParcel.writeString(paramString);
    localParcel.writeTypedList(paramList);
    add(1, localParcel);
  }
  
  public final void zzvr()
    throws RemoteException
  {
    add(2, zzax());
  }
}
