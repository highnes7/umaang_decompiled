package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.Map.Entry;

public final class zzexc
  implements Comparable<com.google.android.gms.internal.zzexc>, Map.Entry<K, V>
{
  public V value;
  public final K zzoqp;
  
  public zzexc(zzewx paramZzewx, Comparable paramComparable, Object paramObject)
  {
    zzoqp = paramComparable;
    value = paramObject;
  }
  
  public zzexc(zzewx paramZzewx, Map.Entry paramEntry)
  {
    zzoqp = localComparable;
    value = paramEntry;
  }
  
  public static boolean equals(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    return (equals(zzoqp, paramObject.getKey())) && (equals(value, paramObject.getValue()));
  }
  
  public final Object getValue()
  {
    return value;
  }
  
  public final int hashCode()
  {
    Object localObject = zzoqp;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    localObject = value;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i ^ j;
  }
  
  public final Object setValue(Object paramObject)
  {
    zzewx.setAnswer(zzoqq);
    Object localObject = value;
    value = paramObject;
    return localObject;
  }
  
  public final String toString()
  {
    String str1 = String.valueOf(zzoqp);
    String str2 = String.valueOf(value);
    int i = str1.length();
    return StringBuilder.append(str2.length() + (i + 1), str1, "=", str2);
  }
}
