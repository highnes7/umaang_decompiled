package com.google.android.android.internal;

import android.location.Location;
import com.google.android.android.location.LocationBackend.Stub;
import com.google.android.gms.location.LocationListener;

public final class zzbzs
  extends LocationBackend.Stub
{
  public final com.google.android.gms.common.api.internal.zzcj<LocationListener> zzfpc;
  
  public zzbzs(com.google.android.android.common.package_9.internal.zzcj paramZzcj)
  {
    zzfpc = paramZzcj;
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    try
    {
      zzfpc.doToast(new zzbzt(this, paramLocation));
      return;
    }
    catch (Throwable paramLocation)
    {
      throw paramLocation;
    }
  }
  
  public final void release()
  {
    try
    {
      zzfpc.clear();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
