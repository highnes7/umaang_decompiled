package com.google.android.android.internal;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class zzdos<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  public zzdos() {}
  
  public abstract zzdos children(Object paramObject1, Object paramObject2);
  
  public abstract boolean containsKey(Object paramObject);
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzdos)) {
      return false;
    }
    Object localObject = (zzdos)paramObject;
    if (!getComparator().equals(((zzdos)localObject).getComparator())) {
      return false;
    }
    if (size() != ((zzdos)localObject).size()) {
      return false;
    }
    paramObject = iterator();
    localObject = ((zzdos)localObject).iterator();
    while (paramObject.hasNext()) {
      if (!((Map.Entry)paramObject.next()).equals(((Iterator)localObject).next())) {
        return false;
      }
    }
    return true;
  }
  
  public abstract Comparator getComparator();
  
  public int hashCode()
  {
    int i = getComparator().hashCode();
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      i = i * 31 + ((Map.Entry)localIterator.next()).hashCode();
    }
    return i;
  }
  
  public abstract int indexOf(Object paramObject);
  
  public abstract boolean isEmpty();
  
  public abstract Iterator iterator();
  
  public abstract Object previousKey(Object paramObject);
  
  public abstract void saveToFile(zzdpd paramZzdpd);
  
  public abstract int size();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("{");
    Iterator localIterator = iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (i != 0) {
        i = 0;
      } else {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("(");
      localStringBuilder.append(localEntry.getKey());
      localStringBuilder.append("=>");
      localStringBuilder.append(localEntry.getValue());
      localStringBuilder.append(")");
    }
    localStringBuilder.append("};");
    return localStringBuilder.toString();
  }
  
  public abstract zzdos zzay(Object paramObject);
  
  public abstract Iterator zzaz(Object paramObject);
  
  public abstract Object zzba(Object paramObject);
  
  public abstract Object zzbqd();
  
  public abstract Object zzbqe();
  
  public abstract Iterator zzbqf();
}
