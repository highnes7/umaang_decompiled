package com.google.android.android.internal;

import com.google.android.android.analytics.Log;
import com.google.android.gms.analytics.zzh;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzaly
  extends zzh<com.google.android.gms.internal.zzaly>
{
  public Map<Integer, Double> zzdmm = new HashMap(4);
  
  public zzaly() {}
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = zzdmm.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = String.valueOf(localEntry.getKey());
      StringBuilder localStringBuilder = new StringBuilder(str.length() + 6);
      localStringBuilder.append("metric");
      localStringBuilder.append(str);
      localHashMap.put(localStringBuilder.toString(), localEntry.getValue());
    }
    return Log.getID(localHashMap);
  }
  
  public final Map zzux()
  {
    return Collections.unmodifiableMap(zzdmm);
  }
}
