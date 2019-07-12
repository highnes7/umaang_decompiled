package com.google.android.android.internal;

import com.google.android.android.analytics.Log;
import com.google.android.gms.analytics.zzh;
import java.util.HashMap;
import java.util.Map;

public final class zzamg
  extends zzh<com.google.android.gms.internal.zzamg>
{
  public String zzdmr;
  public String zzdnk;
  public String zzdnl;
  
  public zzamg() {}
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("network", zzdnk);
    localHashMap.put("action", zzdmr);
    localHashMap.put("target", zzdnl);
    return Log.getID(localHashMap);
  }
}
