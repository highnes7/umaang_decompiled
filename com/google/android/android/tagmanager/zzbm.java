package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbd;
import java.util.Map;

public final class zzbm
  extends zzga
{
  public static final String cachePath = zzbd.zzjv.toString();
  
  public zzbm()
  {
    super(cachePath);
  }
  
  public final boolean matches(String paramString1, String paramString2, Map paramMap)
  {
    return paramString1.equals(paramString2);
  }
}
