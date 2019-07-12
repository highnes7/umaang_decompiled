package com.google.android.android.internal;

public final class zzevn
  implements zzevq
{
  public int zzoom = 0;
  
  public zzevn() {}
  
  public final double cbrt(boolean paramBoolean1, double paramDouble1, boolean paramBoolean2, double paramDouble2)
  {
    int i = zzoom;
    zzoom = (zzevu.zzdc(Double.doubleToLongBits(paramDouble1)) + i * 53);
    return paramDouble1;
  }
  
  public final zzevy decrypt(zzevy paramZzevy1, zzevy paramZzevy2)
  {
    int i = zzoom;
    zzoom = (paramZzevy1.hashCode() + i * 53);
    return paramZzevy1;
  }
  
  public final Object intersect(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    int i = zzoom;
    zzoom = (((Integer)paramObject1).intValue() + i * 53);
    return paramObject1;
  }
  
  public final zzevx intersection(zzevx paramZzevx1, zzevx paramZzevx2)
  {
    int i = zzoom;
    zzoom = (paramZzevx1.hashCode() + i * 53);
    return paramZzevx1;
  }
  
  public final Object invokeImpl(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    int i = zzoom;
    zzoom = (paramObject1.hashCode() + i * 53);
    return paramObject1;
  }
  
  public final Object prepareRecord(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    int i = zzoom;
    zzoom = (zzevu.zzdc(((Long)paramObject1).longValue()) + i * 53);
    return paramObject1;
  }
  
  public final Object sample(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    int i = zzoom;
    zzoom = (zzevu.zzdc(Double.doubleToLongBits(((Double)paramObject1).doubleValue())) + i * 53);
    return paramObject1;
  }
  
  public final Object startSyncing(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    int i = zzoom;
    zzoom = (zzevu.zzda(((Boolean)paramObject1).booleanValue()) + i * 53);
    return paramObject1;
  }
  
  public final zzewk subtract(zzewk paramZzewk1, zzewk paramZzewk2)
  {
    int i = zzoom;
    zzoom = (paramZzewk1.hashCode() + i * 53);
    return paramZzewk1;
  }
  
  public final Object transform(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    int i = zzoom;
    zzoom = (paramObject1.hashCode() + i * 53);
    return paramObject1;
  }
  
  public final int truncate(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    zzoom = (zzoom * 53 + paramInt1);
    return paramInt1;
  }
  
  public final long truncate(boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2)
  {
    int i = zzoom;
    zzoom = (zzevu.zzdc(paramLong1) + i * 53);
    return paramLong1;
  }
  
  public final zzeuk truncate(boolean paramBoolean1, zzeuk paramZzeuk1, boolean paramBoolean2, zzeuk paramZzeuk2)
  {
    int i = zzoom;
    zzoom = (paramZzeuk1.hashCode() + i * 53);
    return paramZzeuk1;
  }
  
  public final zzewl truncate(zzewl paramZzewl1, zzewl paramZzewl2)
  {
    int i;
    if (paramZzewl1 != null)
    {
      if ((paramZzewl1 instanceof zzevh))
      {
        paramZzewl2 = (zzevh)paramZzewl1;
        if (zzomr == 0)
        {
          i = zzoom;
          zzoom = 0;
          paramZzewl2.truncate(zzevp.zzoop, this, paramZzewl2);
          zzexl localZzexl = zzooe;
          zzooe = truncate(localZzexl, localZzexl);
          zzomr = zzoom;
          zzoom = i;
        }
        i = zzomr;
      }
      else
      {
        i = paramZzewl1.hashCode();
      }
    }
    else {
      i = 37;
    }
    zzoom = (zzoom * 53 + i);
    return paramZzewl1;
  }
  
  public final zzexl truncate(zzexl paramZzexl1, zzexl paramZzexl2)
  {
    int i = zzoom;
    zzoom = (paramZzexl1.hashCode() + i * 53);
    return paramZzexl1;
  }
  
  public final Object truncate(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    return truncate((zzewl)paramObject1, (zzewl)paramObject2);
  }
  
  public final String truncate(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
  {
    int i = zzoom;
    zzoom = (paramString1.hashCode() + i * 53);
    return paramString1;
  }
  
  public final boolean xor(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    int i = zzoom;
    zzoom = (zzevu.zzda(paramBoolean2) + i * 53);
    return paramBoolean2;
  }
  
  public final void zzcz(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    throw new IllegalStateException();
  }
}
