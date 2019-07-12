package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbd;
import java.util.Map;

public final class zzbl
  extends zzga
{
  public static final String cachePath = zzbd.zzjt.toString();
  
  public zzbl()
  {
    super(cachePath);
  }
  
  public final boolean matches(String paramString1, String paramString2, Map paramMap)
  {
    return paramString1.endsWith(paramString2);
  }
}
