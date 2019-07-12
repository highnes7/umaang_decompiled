package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbe;
import com.google.android.android.internal.zzbp;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public final class zzem
  extends zzga
{
  public static final String cachePath = zzbd.zzjr.toString();
  public static final String zzjtu = zzbe.zzql.toString();
  
  public zzem()
  {
    super(cachePath);
  }
  
  public final boolean matches(String paramString1, String paramString2, Map paramMap)
  {
    int i;
    if (zzgk.valueOf((zzbp)paramMap.get(zzjtu)).booleanValue()) {
      i = 66;
    } else {
      i = 64;
    }
    try
    {
      boolean bool = Pattern.compile(paramString2, i).matcher(paramString1).find();
      return bool;
    }
    catch (PatternSyntaxException paramString1)
    {
      for (;;) {}
    }
    return false;
  }
}
