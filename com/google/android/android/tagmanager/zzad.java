package com.google.android.android.tagmanager;

import com.google.android.gms.internal.zzdbm;
import com.google.android.gms.tagmanager.zzdi;

public final class zzad
  implements zzdi<zzdbm>
{
  public zzad(Waypoint paramWaypoint) {}
  
  public final void zzed(int paramInt)
  {
    if (!Waypoint.getVisible(zzjqa)) {
      Waypoint.readData(zzjqa, 0L);
    }
  }
}
