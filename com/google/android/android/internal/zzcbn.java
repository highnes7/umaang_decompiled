package com.google.android.android.internal;

import com.google.android.android.common.internal.zzbp;

public final class zzcbn<V>
{
  public final String zzbff;
  public final V zzdsq;
  public final com.google.android.gms.internal.zzbbw<V> zzdsr;
  
  public zzcbn(String paramString, zzbbw paramZzbbw, Object paramObject)
  {
    zzbp.append(paramZzbbw);
    zzdsr = paramZzbbw;
    zzdsq = paramObject;
    zzbff = paramString;
  }
  
  public static zzcbn init(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new zzcbn(paramString, zzbbw.setSetting(paramString, paramBoolean2), Boolean.valueOf(paramBoolean1));
  }
  
  public static zzcbn register(String paramString1, String paramString2, String paramString3)
  {
    return new zzcbn(paramString1, zzbbw.getSimpleName(paramString1, paramString3), paramString2);
  }
  
  public static zzcbn start(String paramString, long paramLong1, long paramLong2)
  {
    return new zzcbn(paramString, zzbbw.computeFileNameStr_WCS(paramString, Long.valueOf(paramLong2)), Long.valueOf(paramLong1));
  }
  
  public static zzcbn string(String paramString, int paramInt1, int paramInt2)
  {
    return new zzcbn(paramString, zzbbw.id(paramString, Integer.valueOf(paramInt2)), Integer.valueOf(paramInt1));
  }
  
  public final Object add(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject;
    }
    return zzdsq;
  }
  
  public final Object get0()
  {
    return zzdsq;
  }
  
  public final String getKey()
  {
    return zzbff;
  }
}
