package com.google.android.android.internal;

import com.google.android.android.common.internal.zzbp;

public final class zzaoe<V>
{
  public final V zzdsq;
  public final com.google.android.gms.internal.zzbbw<V> zzdsr;
  
  public zzaoe(zzbbw paramZzbbw, Object paramObject)
  {
    zzbp.append(paramZzbbw);
    zzdsr = paramZzbbw;
    zzdsq = paramObject;
  }
  
  public static zzaoe create(String paramString, float paramFloat1, float paramFloat2)
  {
    Float localFloat = Float.valueOf(0.5F);
    return new zzaoe(zzbbw.validate(paramString, localFloat), localFloat);
  }
  
  public static zzaoe init(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new zzaoe(zzbbw.setSetting(paramString, paramBoolean2), Boolean.valueOf(paramBoolean1));
  }
  
  public static zzaoe selectStatement(String paramString1, String paramString2, String paramString3)
  {
    return new zzaoe(zzbbw.getSimpleName(paramString1, paramString3), paramString2);
  }
  
  public static zzaoe start(String paramString, int paramInt1, int paramInt2)
  {
    return new zzaoe(zzbbw.id(paramString, Integer.valueOf(paramInt2)), Integer.valueOf(paramInt1));
  }
  
  public static zzaoe start(String paramString, long paramLong1, long paramLong2)
  {
    return new zzaoe(zzbbw.computeFileNameStr_WCS(paramString, Long.valueOf(paramLong2)), Long.valueOf(paramLong1));
  }
  
  public final Object setDoOutput()
  {
    return zzdsq;
  }
}
