package com.google.android.android.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.android.measurement.AppMeasurement;

public final class zzcco
  implements Runnable
{
  public zzcco(zzccn paramZzccn, zzccw paramZzccw, long paramLong, Bundle paramBundle, Context paramContext, zzcbw paramZzcbw) {}
  
  public final void run()
  {
    Object localObject = zzirr.zzauf().zzah(zzirr.zzaua().getAppId(), "_fot");
    if (localObject != null)
    {
      localObject = mValue;
      if ((localObject instanceof Long))
      {
        l1 = ((Long)localObject).longValue();
        break label58;
      }
    }
    long l1 = 0L;
    label58:
    long l3 = zzirs;
    long l2 = l3;
    if (l1 > 0L) {
      if (l3 < l1)
      {
        l2 = l3;
        if (l3 > 0L) {}
      }
      else
      {
        l2 = l1 - 1L;
      }
    }
    if (l2 > 0L) {
      zzirt.putLong("click_timestamp", l2);
    }
    AppMeasurement.getInstance(zzaoa).logEventInternal("auto", "_cmp", zzirt);
    zziru.zzayj().append("Install campaign recorded");
  }
}
