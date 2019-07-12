package com.google.android.android.tagmanager;

import com.google.android.android.common.package_9.Result;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.common.package_9.internal.Log;
import com.google.android.gms.internal.zzbo;
import com.google.android.gms.tagmanager.zzdi;

public final class zzae
  implements zzdi<zzbo>
{
  public zzae(Waypoint paramWaypoint) {}
  
  public final void zzed(int paramInt)
  {
    if (paramInt == zzda.zzjsn) {
      Waypoint.getName(zzjqa).zzbcz();
    }
    Waypoint localWaypoint2 = zzjqa;
    try
    {
      if (!zzjqa.isReady())
      {
        Waypoint localWaypoint1;
        if (Waypoint.addWaypoint(zzjqa) != null) {
          localWaypoint1 = zzjqa;
        }
        for (Object localObject = Waypoint.addWaypoint(zzjqa);; localObject = zzjqa.zzai(Status.zzfhy))
        {
          localWaypoint1.setResult((Result)localObject);
          break;
          localWaypoint1 = zzjqa;
        }
      }
      long l = Waypoint.getName(zzjqa).zzbcy();
      Waypoint.readData(zzjqa, l);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
