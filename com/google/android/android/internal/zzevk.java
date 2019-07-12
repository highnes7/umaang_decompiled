package com.google.android.android.internal;

public final class zzevk
  implements zzevq
{
  public static final zzevk zzooj = new zzevk();
  public static zzevl zzook = new zzevl();
  
  public zzevk() {}
  
  public final double cbrt(boolean paramBoolean1, double paramDouble1, boolean paramBoolean2, double paramDouble2)
  {
    if ((paramBoolean1 == paramBoolean2) && (paramDouble1 == paramDouble2)) {
      return paramDouble1;
    }
    throw zzook;
  }
  
  public final zzevy decrypt(zzevy paramZzevy1, zzevy paramZzevy2)
  {
    if (paramZzevy1.equals(paramZzevy2)) {
      return paramZzevy1;
    }
    throw zzook;
  }
  
  public final Object intersect(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    if ((paramBoolean) && (paramObject1.equals(paramObject2))) {
      return paramObject1;
    }
    throw zzook;
  }
  
  public final zzevx intersection(zzevx paramZzevx1, zzevx paramZzevx2)
  {
    if (paramZzevx1.equals(paramZzevx2)) {
      return paramZzevx1;
    }
    throw zzook;
  }
  
  public final Object invokeImpl(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    if ((paramBoolean) && (paramObject1.equals(paramObject2))) {
      return paramObject1;
    }
    throw zzook;
  }
  
  public final Object prepareRecord(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    if ((paramBoolean) && (paramObject1.equals(paramObject2))) {
      return paramObject1;
    }
    throw zzook;
  }
  
  public final Object sample(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    if ((paramBoolean) && (paramObject1.equals(paramObject2))) {
      return paramObject1;
    }
    throw zzook;
  }
  
  public final Object startSyncing(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    if ((paramBoolean) && (paramObject1.equals(paramObject2))) {
      return paramObject1;
    }
    throw zzook;
  }
  
  public final zzewk subtract(zzewk paramZzewk1, zzewk paramZzewk2)
  {
    if (paramZzewk1.equals(paramZzewk2)) {
      return paramZzewk1;
    }
    throw zzook;
  }
  
  public final Object transform(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    if ((paramBoolean) && (paramObject1.equals(paramObject2))) {
      return paramObject1;
    }
    throw zzook;
  }
  
  public final int truncate(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    if ((paramBoolean1 == paramBoolean2) && (paramInt1 == paramInt2)) {
      return paramInt1;
    }
    throw zzook;
  }
  
  public final long truncate(boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2)
  {
    if ((paramBoolean1 == paramBoolean2) && (paramLong1 == paramLong2)) {
      return paramLong1;
    }
    throw zzook;
  }
  
  public final zzeuk truncate(boolean paramBoolean1, zzeuk paramZzeuk1, boolean paramBoolean2, zzeuk paramZzeuk2)
  {
    if ((paramBoolean1 == paramBoolean2) && (paramZzeuk1.equals(paramZzeuk2))) {
      return paramZzeuk1;
    }
    throw zzook;
  }
  
  public final zzewl truncate(zzewl paramZzewl1, zzewl paramZzewl2)
  {
    if ((paramZzewl1 == null) && (paramZzewl2 == null)) {
      return null;
    }
    if ((paramZzewl1 != null) && (paramZzewl2 != null))
    {
      zzevh localZzevh = (zzevh)paramZzewl1;
      if ((localZzevh != paramZzewl2) && (((zzevh)localZzevh.truncate(zzevp.zzoou, null, null)).getClass().isInstance(paramZzewl2)))
      {
        paramZzewl2 = (zzevh)paramZzewl2;
        localZzevh.truncate(zzevp.zzoop, this, paramZzewl2);
        zzooe = truncate(zzooe, zzooe);
        return paramZzewl1;
      }
    }
    else
    {
      throw zzook;
    }
    return paramZzewl1;
  }
  
  public final zzexl truncate(zzexl paramZzexl1, zzexl paramZzexl2)
  {
    if (paramZzexl1.equals(paramZzexl2)) {
      return paramZzexl1;
    }
    throw zzook;
  }
  
  public final Object truncate(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    if (paramBoolean)
    {
      zzevh localZzevh = (zzevh)paramObject1;
      paramObject2 = (zzewl)paramObject2;
      int i = 1;
      if (localZzevh != paramObject2) {
        if (!((zzevh)localZzevh.truncate(zzevp.zzoou, null, null)).getClass().isInstance(paramObject2))
        {
          i = 0;
        }
        else
        {
          paramObject2 = (zzevh)paramObject2;
          localZzevh.truncate(zzevp.zzoop, this, paramObject2);
          zzooe = truncate(zzooe, zzooe);
        }
      }
      if (i != 0) {
        return paramObject1;
      }
    }
    throw zzook;
  }
  
  public final String truncate(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
  {
    if ((paramBoolean1 == paramBoolean2) && (paramString1.equals(paramString2))) {
      return paramString1;
    }
    throw zzook;
  }
  
  public final boolean xor(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if ((paramBoolean1 == paramBoolean3) && (paramBoolean2 == paramBoolean4)) {
      return paramBoolean2;
    }
    throw zzook;
  }
  
  public final void zzcz(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    throw zzook;
  }
}
