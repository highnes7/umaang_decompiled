package com.google.android.android.internal;

import java.util.LinkedHashMap;
import java.util.List;

public final class zzevo
  implements zzevq
{
  public static final zzevo zzoon = new zzevo();
  
  public zzevo() {}
  
  public final double cbrt(boolean paramBoolean1, double paramDouble1, boolean paramBoolean2, double paramDouble2)
  {
    if (paramBoolean2) {
      return paramDouble2;
    }
    return paramDouble1;
  }
  
  public final zzevy decrypt(zzevy paramZzevy1, zzevy paramZzevy2)
  {
    int i = paramZzevy1.size();
    int j = paramZzevy2.size();
    zzevy localZzevy = paramZzevy1;
    if (i > 0)
    {
      localZzevy = paramZzevy1;
      if (j > 0)
      {
        localZzevy = paramZzevy1;
        if (!paramZzevy1.zzcsc()) {
          localZzevy = paramZzevy1.zzks(j + i);
        }
        localZzevy.addAll(paramZzevy2);
      }
    }
    if (i > 0) {
      return localZzevy;
    }
    return paramZzevy2;
  }
  
  public final Object intersect(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    return paramObject2;
  }
  
  public final zzevx intersection(zzevx paramZzevx1, zzevx paramZzevx2)
  {
    int i = paramZzevx1.size();
    int j = paramZzevx2.size();
    zzevx localZzevx = paramZzevx1;
    if (i > 0)
    {
      localZzevx = paramZzevx1;
      if (j > 0)
      {
        localZzevx = paramZzevx1;
        if (!paramZzevx1.zzcsc()) {
          localZzevx = paramZzevx1.zzko(j + i);
        }
        localZzevx.addAll(paramZzevx2);
      }
    }
    if (i > 0) {
      return localZzevx;
    }
    return paramZzevx2;
  }
  
  public final Object invokeImpl(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    return paramObject2;
  }
  
  public final Object prepareRecord(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    return paramObject2;
  }
  
  public final Object sample(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    return paramObject2;
  }
  
  public final Object startSyncing(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    return paramObject2;
  }
  
  public final zzewk subtract(zzewk paramZzewk1, zzewk paramZzewk2)
  {
    zzewk localZzewk = paramZzewk1;
    if (!paramZzewk2.isEmpty())
    {
      localZzewk = paramZzewk1;
      if (!paramZzewk1.isMutable()) {
        localZzewk = paramZzewk1.zzcuy();
      }
      localZzewk.add(paramZzewk2);
    }
    return localZzewk;
  }
  
  public final Object transform(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    return paramObject2;
  }
  
  public final int truncate(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    if (paramBoolean2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public final long truncate(boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2)
  {
    if (paramBoolean2) {
      return paramLong2;
    }
    return paramLong1;
  }
  
  public final zzeuk truncate(boolean paramBoolean1, zzeuk paramZzeuk1, boolean paramBoolean2, zzeuk paramZzeuk2)
  {
    if (paramBoolean2) {
      return paramZzeuk2;
    }
    return paramZzeuk1;
  }
  
  public final zzewl truncate(zzewl paramZzewl1, zzewl paramZzewl2)
  {
    if ((paramZzewl1 != null) && (paramZzewl2 != null)) {
      return paramZzewl1.zzcub().getChange(paramZzewl2).zzcuh();
    }
    if (paramZzewl1 != null) {
      return paramZzewl1;
    }
    return paramZzewl2;
  }
  
  public final zzexl truncate(zzexl paramZzexl1, zzexl paramZzexl2)
  {
    if (paramZzexl2 == zzexl.zzoqy) {
      return paramZzexl1;
    }
    return zzexl.copyOf(paramZzexl1, paramZzexl2);
  }
  
  public final Object truncate(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    if (paramBoolean) {
      return truncate((zzewl)paramObject1, (zzewl)paramObject2);
    }
    return paramObject2;
  }
  
  public final String truncate(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
  {
    if (paramBoolean2) {
      return paramString2;
    }
    return paramString1;
  }
  
  public final boolean xor(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramBoolean3) {
      return paramBoolean4;
    }
    return paramBoolean2;
  }
  
  public final void zzcz(boolean paramBoolean) {}
}
