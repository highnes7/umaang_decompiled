package com.google.android.android.internal;

import com.google.android.android.location.IOnBufferingUpdateListenerCallback_0_8.Stub;
import com.google.android.android.location.LocationAvailability;
import com.google.android.android.location.LocationResult;
import com.google.android.gms.location.LocationCallback;

public final class zzbzp
  extends IOnBufferingUpdateListenerCallback_0_8.Stub
{
  public final com.google.android.gms.common.api.internal.zzcj<LocationCallback> zzfpc;
  
  public zzbzp(com.google.android.android.common.package_9.internal.zzcj paramZzcj)
  {
    zzfpc = paramZzcj;
  }
  
  public final void onLocationAvailability(LocationAvailability paramLocationAvailability)
  {
    zzfpc.doToast(new zzbzr(this, paramLocationAvailability));
  }
  
  public final void onLocationResult(LocationResult paramLocationResult)
  {
    zzfpc.doToast(new zzbzq(this, paramLocationResult));
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
