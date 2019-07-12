package com.google.android.android.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzewk<K, V>
  extends LinkedHashMap<K, V>
{
  public static final zzewk zzopq;
  public boolean zzomt = true;
  
  static
  {
    zzewk localZzewk = new zzewk();
    zzopq = localZzewk;
    zzomt = false;
  }
  
  public zzewk() {}
  
  public zzewk(Map paramMap)
  {
    super(paramMap);
  }
  
  public static int zzcf(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return zzevu.hashCode((byte[])paramObject);
    }
    if (!(paramObject instanceof zzevv)) {
      return paramObject.hashCode();
    }
    throw new UnsupportedOperationException();
  }
  
  public static zzewk zzcux()
  {
    return zzopq;
  }
  
  private final void zzcuz()
  {
    if (zzomt) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public final void add(zzewk paramZzewk)
  {
    zzcuz();
    if (!paramZzewk.isEmpty()) {
      putAll(paramZzewk);
    }
  }
  
  public final void clear()
  {
    zzcuz();
    super.clear();
  }
  
  public final Set entrySet()
  {
    if (isEmpty()) {
      return Collections.emptySet();
    }
    return super.entrySet();
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      if (this != paramObject)
      {
        if (size() != paramObject.size()) {}
        for (;;)
        {
          i = 0;
          break label165;
          Iterator localIterator = entrySet().iterator();
          boolean bool;
          do
          {
            if (!localIterator.hasNext()) {
              break label163;
            }
            Object localObject2 = (Map.Entry)localIterator.next();
            if (!paramObject.containsKey(((Map.Entry)localObject2).getKey())) {
              break;
            }
            Object localObject1 = ((Map.Entry)localObject2).getValue();
            localObject2 = paramObject.get(((Map.Entry)localObject2).getKey());
            if (((localObject1 instanceof byte[])) && ((localObject2 instanceof byte[]))) {
              bool = Arrays.equals((byte[])localObject1, (byte[])localObject2);
            } else {
              bool = localObject1.equals(localObject2);
            }
          } while (bool);
        }
      }
      label163:
      int i = 1;
      label165:
      if (i != 0) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    Iterator localIterator = entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      int j = zzcf(localEntry.getKey());
      i += (zzcf(localEntry.getValue()) ^ j);
    }
    return i;
  }
  
  public final boolean isMutable()
  {
    return zzomt;
  }
  
  public final Object put(Object paramObject1, Object paramObject2)
  {
    zzcuz();
    zzevu.add(paramObject1);
    zzevu.add(paramObject2);
    return super.put(paramObject1, paramObject2);
  }
  
  public final void putAll(Map paramMap)
  {
    zzcuz();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      zzevu.add(localObject);
      zzevu.add(paramMap.get(localObject));
    }
    super.putAll(paramMap);
  }
  
  public final Object remove(Object paramObject)
  {
    zzcuz();
    return super.remove(paramObject);
  }
  
  public final void zzbhs()
  {
    zzomt = false;
  }
  
  public final zzewk zzcuy()
  {
    if (isEmpty()) {
      return new zzewk();
    }
    return new zzewk(this);
  }
}
