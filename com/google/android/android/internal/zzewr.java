package com.google.android.android.internal;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public final class zzewr<E>
  extends com.google.android.gms.internal.zzeug<E>
{
  public static final com.google.android.gms.internal.zzewr<Object> zzopr;
  public final List<E> zzops;
  
  static
  {
    zzewr localZzewr = new zzewr();
    zzopr = localZzewr;
    localZzewr.zzbhs();
  }
  
  public zzewr()
  {
    zzops = localArrayList;
  }
  
  public zzewr(List paramList)
  {
    zzops = paramList;
  }
  
  public static zzewr zzcva()
  {
    return zzopr;
  }
  
  public final void add(int paramInt, Object paramObject)
  {
    zzcsd();
    zzops.add(paramInt, paramObject);
    modCount += 1;
  }
  
  public final Object get(int paramInt)
  {
    return zzops.get(paramInt);
  }
  
  public final Object remove(int paramInt)
  {
    zzcsd();
    Object localObject = zzops.remove(paramInt);
    modCount += 1;
    return localObject;
  }
  
  public final Object set(int paramInt, Object paramObject)
  {
    zzcsd();
    paramObject = zzops.set(paramInt, paramObject);
    modCount += 1;
    return paramObject;
  }
  
  public final int size()
  {
    return zzops.size();
  }
}
