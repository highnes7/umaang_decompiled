package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbp;
import java.util.Map;

public abstract class zzga
  extends zzeg
{
  public zzga(String paramString)
  {
    super(paramString);
  }
  
  public final boolean match(zzbp paramZzbp1, zzbp paramZzbp2, Map paramMap)
  {
    paramZzbp1 = zzgk.toString(paramZzbp1);
    paramZzbp2 = zzgk.toString(paramZzbp2);
    String str = zzgk.zzjwl;
    if ((paramZzbp1 != str) && (paramZzbp2 != str)) {
      return matches(paramZzbp1, paramZzbp2, paramMap);
    }
    return false;
  }
  
  public abstract boolean matches(String paramString1, String paramString2, Map paramMap);
}
