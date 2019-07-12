package com.google.android.android.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

public final class zzexe
  extends AbstractSet<Map.Entry<K, V>>
{
  public zzexe(zzewx paramZzewx) {}
  
  public final void clear()
  {
    zzoqq.clear();
  }
  
  public final boolean contains(Object paramObject)
  {
    Object localObject = (Map.Entry)paramObject;
    paramObject = zzoqq.get(((Map.Entry)localObject).getKey());
    localObject = ((Map.Entry)localObject).getValue();
    return (paramObject == localObject) || ((paramObject != null) && (paramObject.equals(localObject)));
  }
  
  public final Iterator iterator()
  {
    return new zzexd(zzoqq, null);
  }
  
  public final boolean remove(Object paramObject)
  {
    paramObject = (Map.Entry)paramObject;
    if (contains(paramObject))
    {
      zzoqq.remove(paramObject.getKey());
      return true;
    }
    return false;
  }
  
  public final int size()
  {
    return zzoqq.size();
  }
}
