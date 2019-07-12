package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbd;
import java.util.Map;

public final class zzak
  extends zzga
{
  public static final String cachePath = zzbd.zzju.toString();
  
  public zzak()
  {
    super(cachePath);
  }
  
  public final boolean matches(String paramString1, String paramString2, Map paramMap)
  {
    return paramString1.contains(paramString2);
  }
}
