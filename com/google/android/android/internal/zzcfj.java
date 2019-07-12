package com.google.android.android.internal;

import android.os.Build.VERSION;

public final class zzcfj
  implements Runnable
{
  public zzcfj(zzcfi paramZzcfi) {}
  
  public final void run()
  {
    zzcfi localZzcfi = zziws;
    Integer localInteger = zzdtz;
    if (localInteger != null)
    {
      if (((zzcfk)zziwr.zzdtx).callServiceStopSelfResult(localInteger.intValue()))
      {
        zzcax.zzawk();
        zziws.zziru.zzayj().append("Local AppMeasurementService processed last upload request. StartId", zziws.zzdtz);
      }
    }
    else
    {
      zzcax.zzawk();
      if (Build.VERSION.SDK_INT >= 24)
      {
        zziws.zziru.zzayj().append("AppMeasurementJobService processed last upload request.");
        localZzcfi = zziws;
        ((zzcfk)zziwr.zzdtx).makeView(zzduc, false);
      }
    }
  }
}
