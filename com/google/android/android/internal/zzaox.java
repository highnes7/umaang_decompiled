package com.google.android.android.internal;

import android.os.Build.VERSION;

public final class zzaox
  implements Runnable
{
  public zzaox(zzaow paramZzaow) {}
  
  public final void run()
  {
    zzaow localZzaow = zzdue;
    Integer localInteger = zzdtz;
    if (localInteger != null)
    {
      if (((zzaoy)zzdud.zzdtx).callServiceStopSelfResult(localInteger.intValue())) {
        zzdue.zzdub.zzdm("Local AnalyticsService processed last dispatch request");
      }
    }
    else if (Build.VERSION.SDK_INT >= 24)
    {
      zzdub.zzdm("AnalyticsJobService processed last dispatch request");
      localZzaow = zzdue;
      ((zzaoy)zzdud.zzdtx).makeView(zzduc, false);
    }
  }
}
