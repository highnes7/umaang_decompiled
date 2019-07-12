package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbd;
import java.util.Map;

public final class zzfz
  extends zzga
{
  public static final String cachePath = zzbd.zzjs.toString();
  
  public zzfz()
  {
    super(cachePath);
  }
  
  public final boolean matches(String paramString1, String paramString2, Map paramMap)
  {
    return paramString1.startsWith(paramString2);
  }
}
