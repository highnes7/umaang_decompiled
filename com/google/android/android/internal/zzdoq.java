package com.google.android.android.internal;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzdoq<K, V>
  extends com.google.android.gms.internal.zzdos<K, V>
{
  public final K[] zzlsc;
  public final V[] zzlsd;
  public final Comparator<K> zzlse;
  
  public zzdoq(Comparator paramComparator)
  {
    zzlsc = new Object[0];
    zzlsd = new Object[0];
    zzlse = paramComparator;
  }
  
  public zzdoq(Comparator paramComparator, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    zzlsc = paramArrayOfObject1;
    zzlsd = paramArrayOfObject2;
    zzlse = paramComparator;
  }
  
  public static Object[] add(Object[] paramArrayOfObject, int paramInt, Object paramObject)
  {
    int i = paramArrayOfObject.length + 1;
    Object[] arrayOfObject = new Object[i];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
    arrayOfObject[paramInt] = paramObject;
    System.arraycopy(paramArrayOfObject, paramInt, arrayOfObject, paramInt + 1, i - paramInt - 1);
    return arrayOfObject;
  }
  
  public static Object[] getKey(Object[] paramArrayOfObject, int paramInt, Object paramObject)
  {
    int i = paramArrayOfObject.length;
    Object[] arrayOfObject = new Object[i];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, i);
    arrayOfObject[paramInt] = paramObject;
    return arrayOfObject;
  }
  
  public static zzdoq getList(List paramList, Map paramMap, zzdov paramZzdov, Comparator paramComparator)
  {
    Collections.sort(paramList, paramComparator);
    int i = paramList.size();
    Object[] arrayOfObject1 = new Object[i];
    Object[] arrayOfObject2 = new Object[i];
    paramList = paramList.iterator();
    i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      arrayOfObject1[i] = localObject;
      arrayOfObject2[i] = paramMap.get(paramZzdov.zzbd(localObject));
      i += 1;
    }
    return new zzdoq(paramComparator, arrayOfObject1, arrayOfObject2);
  }
  
  private final Iterator nextIterator(int paramInt, boolean paramBoolean)
  {
    return new zzdor(this, paramInt, paramBoolean);
  }
  
  public static Object[] removeDupes(Object[] paramArrayOfObject, int paramInt)
  {
    int i = paramArrayOfObject.length - 1;
    Object[] arrayOfObject = new Object[i];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
    System.arraycopy(paramArrayOfObject, paramInt + 1, arrayOfObject, paramInt, i - paramInt);
    return arrayOfObject;
  }
  
  private final int zzbb(Object paramObject)
  {
    int i = 0;
    for (;;)
    {
      Object[] arrayOfObject = zzlsc;
      if ((i >= arrayOfObject.length) || (zzlse.compare(arrayOfObject[i], paramObject) >= 0)) {
        break;
      }
      i += 1;
    }
    return i;
  }
  
  private final int zzbc(Object paramObject)
  {
    Object[] arrayOfObject = zzlsc;
    int k = arrayOfObject.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      Object localObject = arrayOfObject[i];
      if (zzlse.compare(paramObject, localObject) == 0) {
        return j;
      }
      j += 1;
      i += 1;
    }
    return -1;
  }
  
  public final zzdos children(Object paramObject1, Object paramObject2)
  {
    int i = zzbc(paramObject1);
    if (i != -1)
    {
      if ((zzlsc[i] == paramObject1) && (zzlsd[i] == paramObject2)) {
        return this;
      }
      paramObject1 = getKey(zzlsc, i, paramObject1);
      paramObject2 = getKey(zzlsd, i, paramObject2);
      return new zzdoq(zzlse, paramObject1, paramObject2);
    }
    Object localObject = zzlsc;
    if (localObject.length > 25)
    {
      localObject = new HashMap(localObject.length + 1);
      i = 0;
      for (;;)
      {
        Object[] arrayOfObject = zzlsc;
        if (i >= arrayOfObject.length) {
          break;
        }
        ((Map)localObject).put(arrayOfObject[i], zzlsd[i]);
        i += 1;
      }
      ((Map)localObject).put(paramObject1, paramObject2);
      return zzdpg.all((Map)localObject, zzlse);
    }
    i = zzbb(paramObject1);
    paramObject1 = add(zzlsc, i, paramObject1);
    paramObject2 = add(zzlsd, i, paramObject2);
    return new zzdoq(zzlse, paramObject1, paramObject2);
  }
  
  public final boolean containsKey(Object paramObject)
  {
    return zzbc(paramObject) != -1;
  }
  
  public final Comparator getComparator()
  {
    return zzlse;
  }
  
  public final int indexOf(Object paramObject)
  {
    return zzbc(paramObject);
  }
  
  public final boolean isEmpty()
  {
    return zzlsc.length == 0;
  }
  
  public final Iterator iterator()
  {
    return new zzdor(this, 0, false);
  }
  
  public final Object previousKey(Object paramObject)
  {
    int i = zzbc(paramObject);
    if (i != -1) {
      return zzlsd[i];
    }
    return null;
  }
  
  public final void saveToFile(zzdpd paramZzdpd)
  {
    int i = 0;
    for (;;)
    {
      Object[] arrayOfObject = zzlsc;
      if (i >= arrayOfObject.length) {
        break;
      }
      paramZzdpd.append(arrayOfObject[i], zzlsd[i]);
      i += 1;
    }
  }
  
  public final int size()
  {
    return zzlsc.length;
  }
  
  public final zzdos zzay(Object paramObject)
  {
    int i = zzbc(paramObject);
    if (i == -1) {
      return this;
    }
    paramObject = removeDupes(zzlsc, i);
    Object[] arrayOfObject = removeDupes(zzlsd, i);
    return new zzdoq(zzlse, paramObject, arrayOfObject);
  }
  
  public final Iterator zzaz(Object paramObject)
  {
    return new zzdor(this, zzbb(paramObject), false);
  }
  
  public final Object zzba(Object paramObject)
  {
    int i = zzbc(paramObject);
    if (i != -1)
    {
      if (i > 0) {
        return zzlsc[(i - 1)];
      }
      return null;
    }
    throw new IllegalArgumentException("Can't find predecessor of nonexistent key");
  }
  
  public final Object zzbqd()
  {
    Object[] arrayOfObject = zzlsc;
    if (arrayOfObject.length > 0) {
      return arrayOfObject[0];
    }
    return null;
  }
  
  public final Object zzbqe()
  {
    Object[] arrayOfObject = zzlsc;
    if (arrayOfObject.length > 0) {
      return arrayOfObject[(arrayOfObject.length - 1)];
    }
    return null;
  }
  
  public final Iterator zzbqf()
  {
    return new zzdor(this, zzlsc.length - 1, true);
  }
}
