package com.google.android.android.internal;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class zzdox<T>
  implements Iterable<T>
{
  public final com.google.android.gms.internal.zzdos<T, Void> zzlsm;
  
  public zzdox(zzdos paramZzdos)
  {
    zzlsm = paramZzdos;
  }
  
  public zzdox(List paramList, Comparator paramComparator)
  {
    zzlsm = zzdot.getList(paramList, Collections.emptyMap(), zzdot.zzlsj, paramComparator);
  }
  
  public final boolean contains(Object paramObject)
  {
    return zzlsm.containsKey(paramObject);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzdox)) {
      return false;
    }
    paramObject = (zzdox)paramObject;
    return zzlsm.equals(zzlsm);
  }
  
  public final int hashCode()
  {
    return zzlsm.hashCode();
  }
  
  public final int indexOf(Object paramObject)
  {
    return zzlsm.indexOf(paramObject);
  }
  
  public final boolean isEmpty()
  {
    return zzlsm.isEmpty();
  }
  
  public final Iterator iterator()
  {
    return new zzdoy(zzlsm.iterator());
  }
  
  public final int size()
  {
    return zzlsm.size();
  }
  
  public final Iterator zzaz(Object paramObject)
  {
    return new zzdoy(zzlsm.zzaz(paramObject));
  }
  
  public final zzdox zzbe(Object paramObject)
  {
    paramObject = zzlsm.zzay(paramObject);
    if (paramObject == zzlsm) {
      return this;
    }
    return new zzdox(paramObject);
  }
  
  public final zzdox zzbf(Object paramObject)
  {
    return new zzdox(zzlsm.children(paramObject, null));
  }
  
  public final Object zzbg(Object paramObject)
  {
    return zzlsm.zzba(paramObject);
  }
  
  public final Iterator zzbqf()
  {
    return new zzdoy(zzlsm.zzbqf());
  }
  
  public final Object zzbqh()
  {
    return zzlsm.zzbqd();
  }
  
  public final Object zzbqi()
  {
    return zzlsm.zzbqe();
  }
}
