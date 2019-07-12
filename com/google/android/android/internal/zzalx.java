package com.google.android.android.internal;

import com.google.android.android.analytics.Log;
import com.google.android.gms.analytics.zzh;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzalx
  extends zzh<com.google.android.gms.internal.zzalx>
{
  public Map<Integer, String> zzdml = new HashMap(4);
  
  public zzalx() {}
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = zzdml.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = String.valueOf(localEntry.getKey());
      StringBuilder localStringBuilder = new StringBuilder(str.length() + 9);
      localStringBuilder.append("dimension");
      localStringBuilder.append(str);
      localHashMap.put(localStringBuilder.toString(), localEntry.getValue());
    }
    return Log.getID(localHashMap);
  }
  
  public final Map zzuw()
  {
    return Collections.unmodifiableMap(zzdml);
  }
}
