package com.google.android.android.internal;

import com.google.android.gms.internal.zzevy;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public abstract class zzeug<E>
  extends AbstractList<E>
  implements zzevy<E>
{
  public boolean zzomt = true;
  
  public zzeug() {}
  
  public void add(int paramInt, Object paramObject)
  {
    zzcsd();
    super.add(paramInt, paramObject);
  }
  
  public boolean add(Object paramObject)
  {
    zzcsd();
    return super.add(paramObject);
  }
  
  public boolean addAll(int paramInt, Collection paramCollection)
  {
    zzcsd();
    return super.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection paramCollection)
  {
    zzcsd();
    return super.addAll(paramCollection);
  }
  
  public void clear()
  {
    zzcsd();
    super.clear();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof List)) {
      return false;
    }
    if (!(paramObject instanceof RandomAccess)) {
      return super.equals(paramObject);
    }
    paramObject = (List)paramObject;
    int j = size();
    if (j != paramObject.size()) {
      return false;
    }
    int i = 0;
    while (i < j)
    {
      if (!get(i).equals(paramObject.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public int hashCode()
  {
    int k = size();
    int j = 1;
    int i = 0;
    while (i < k)
    {
      j = j * 31 + get(i).hashCode();
      i += 1;
    }
    return j;
  }
  
  public Object remove(int paramInt)
  {
    zzcsd();
    return super.remove(paramInt);
  }
  
  public boolean remove(Object paramObject)
  {
    zzcsd();
    return super.remove(paramObject);
  }
  
  public boolean removeAll(Collection paramCollection)
  {
    zzcsd();
    return super.removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection paramCollection)
  {
    zzcsd();
    return super.retainAll(paramCollection);
  }
  
  public Object set(int paramInt, Object paramObject)
  {
    zzcsd();
    return super.set(paramInt, paramObject);
  }
  
  public final void zzbhs()
  {
    zzomt = false;
  }
  
  public final boolean zzcsc()
  {
    return zzomt;
  }
  
  public final void zzcsd()
  {
    if (zzomt) {
      return;
    }
    throw new UnsupportedOperationException();
  }
}
