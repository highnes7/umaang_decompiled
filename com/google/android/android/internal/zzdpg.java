package com.google.android.android.internal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

public final class zzdpg<K, V>
  extends com.google.android.gms.internal.zzdos<K, V>
{
  public Comparator<K> zzlse;
  public com.google.android.gms.internal.zzdpb<K, V> zzlsv;
  
  public zzdpg(zzdpb paramZzdpb, Comparator paramComparator)
  {
    zzlsv = paramZzdpb;
    zzlse = paramComparator;
  }
  
  public static zzdpg all(Map paramMap, Comparator paramComparator)
  {
    return zzdpi.addChildren(new ArrayList(paramMap.keySet()), paramMap, zzdot.zzlsj, paramComparator);
  }
  
  private final zzdpb zzbh(Object paramObject)
  {
    zzdpb localZzdpb = zzlsv;
    while (!localZzdpb.isEmpty())
    {
      int i = zzlse.compare(paramObject, localZzdpb.getKey());
      if (i < 0)
      {
        localZzdpb = localZzdpb.zzbqm();
      }
      else
      {
        if (i == 0) {
          return localZzdpb;
        }
        localZzdpb = localZzdpb.zzbqn();
      }
    }
    return null;
  }
  
  public final zzdos children(Object paramObject1, Object paramObject2)
  {
    return new zzdpg(zzlsv.subtract(paramObject1, paramObject2, zzlse).cross(null, null, zzdpc.zzlsq, null, null), zzlse);
  }
  
  public final boolean containsKey(Object paramObject)
  {
    return zzbh(paramObject) != null;
  }
  
  public final Comparator getComparator()
  {
    return zzlse;
  }
  
  public final int indexOf(Object paramObject)
  {
    zzdpb localZzdpb = zzlsv;
    int i = 0;
    while (!localZzdpb.isEmpty())
    {
      int j = zzlse.compare(paramObject, localZzdpb.getKey());
      if (j == 0) {
        return localZzdpb.zzbqm().size() + i;
      }
      if (j < 0)
      {
        localZzdpb = localZzdpb.zzbqm();
      }
      else
      {
        i += localZzdpb.zzbqm().size() + 1;
        localZzdpb = localZzdpb.zzbqn();
      }
    }
    return -1;
  }
  
  public final boolean isEmpty()
  {
    return zzlsv.isEmpty();
  }
  
  public final Iterator iterator()
  {
    return new zzdow(zzlsv, null, zzlse, false);
  }
  
  public final Object previousKey(Object paramObject)
  {
    paramObject = zzbh(paramObject);
    if (paramObject != null) {
      return paramObject.getValue();
    }
    return null;
  }
  
  public final void saveToFile(zzdpd paramZzdpd)
  {
    zzlsv.saveToFile(paramZzdpd);
  }
  
  public final int size()
  {
    return zzlsv.size();
  }
  
  public final zzdos zzay(Object paramObject)
  {
    if (!containsKey(paramObject)) {
      return this;
    }
    return new zzdpg(zzlsv.subtract(paramObject, zzlse).cross(null, null, zzdpc.zzlsq, null, null), zzlse);
  }
  
  public final Iterator zzaz(Object paramObject)
  {
    return new zzdow(zzlsv, paramObject, zzlse, false);
  }
  
  public final Object zzba(Object paramObject)
  {
    Object localObject1 = zzlsv;
    Object localObject2 = null;
    while (!((zzdpb)localObject1).isEmpty())
    {
      int i = zzlse.compare(paramObject, ((zzdpb)localObject1).getKey());
      if (i == 0)
      {
        if (!((zzdpb)localObject1).zzbqm().isEmpty())
        {
          for (paramObject = ((zzdpb)localObject1).zzbqm(); !paramObject.zzbqn().isEmpty(); paramObject = paramObject.zzbqn()) {}
          return paramObject.getKey();
        }
        if (localObject2 != null) {
          return localObject2.getKey();
        }
        return null;
      }
      if (i < 0)
      {
        localObject1 = ((zzdpb)localObject1).zzbqm();
      }
      else
      {
        localObject2 = localObject1;
        localObject1 = ((zzdpb)localObject1).zzbqn();
      }
    }
    paramObject = String.valueOf(paramObject);
    localObject1 = new StringBuilder(paramObject.length() + 50);
    ((StringBuilder)localObject1).append("Couldn't find predecessor key of non-present key: ");
    ((StringBuilder)localObject1).append(paramObject);
    paramObject = new IllegalArgumentException(((StringBuilder)localObject1).toString());
    throw paramObject;
  }
  
  public final Object zzbqd()
  {
    return zzlsv.zzbqo().getKey();
  }
  
  public final Object zzbqe()
  {
    return zzlsv.zzbqp().getKey();
  }
  
  public final Iterator zzbqf()
  {
    return new zzdow(zzlsv, null, zzlse, true);
  }
}
