package com.google.android.android.tagmanager;

import com.google.android.android.common.util.Log;

public final class zzab
  implements zzac
{
  public Long zzjqb;
  
  public zzab(Waypoint paramWaypoint, boolean paramBoolean) {}
  
  public final boolean addLocation(Container paramContainer)
  {
    if (zzjqc)
    {
      long l = paramContainer.getLastRefreshTime();
      if (zzjqb == null) {
        zzjqb = Long.valueOf(Waypoint.getName(zzjqa).zzbcx());
      }
      return zzjqb.longValue() + l >= Waypoint.add(zzjqa).currentTimeMillis();
    }
    return !paramContainer.isDefault();
  }
}
