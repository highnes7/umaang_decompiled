package com.google.android.android.internal;

public class zzbbw<T>
{
  public static String READ_PERMISSION = "com.google.android.providers.gsf.permission.READ_GSERVICES";
  public static final Object zzaqd = new Object();
  public static zzbcc zzfpy = null;
  public static int zzfpz = 0;
  public String zzbff;
  public T zzbfg;
  public T zzfqa = null;
  
  public zzbbw(String paramString, Object paramObject)
  {
    zzbff = paramString;
    zzbfg = paramObject;
  }
  
  public static zzbbw computeFileNameStr_WCS(String paramString, Long paramLong)
  {
    return new zzbby(paramString, paramLong);
  }
  
  public static zzbbw getSimpleName(String paramString1, String paramString2)
  {
    return new zzbcb(paramString1, paramString2);
  }
  
  public static zzbbw id(String paramString, Integer paramInteger)
  {
    return new zzbbz(paramString, paramInteger);
  }
  
  public static zzbbw setSetting(String paramString, boolean paramBoolean)
  {
    return new zzbbx(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public static zzbbw validate(String paramString, Float paramFloat)
  {
    return new zzbca(paramString, paramFloat);
  }
}
