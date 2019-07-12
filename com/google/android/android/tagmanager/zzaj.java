package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbp;
import java.util.Map;

public final class zzaj
  extends zzbr
{
  public static final String cachePath = zzbd.zzhr.toString();
  public final String zzfaa;
  
  public zzaj(String paramString)
  {
    super(cachePath, new String[0]);
    zzfaa = paramString;
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    paramMap = zzfaa;
    if (paramMap == null) {
      return zzgk.zzjwp;
    }
    return zzgk.zzah(paramMap);
  }
  
  public final boolean zzbcj()
  {
    return true;
  }
}
