package com.google.android.android.internal;

import com.google.android.android.analytics.Log;
import com.google.android.gms.analytics.zzh;
import java.util.HashMap;
import java.util.Map;

public final class zzamd
  extends zzh<com.google.android.gms.internal.zzamd>
{
  public String zzdmu;
  public boolean zzdmv;
  
  public zzamd() {}
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("description", zzdmu);
    localHashMap.put("fatal", Boolean.valueOf(zzdmv));
    return Log.getID(localHashMap);
  }
}
