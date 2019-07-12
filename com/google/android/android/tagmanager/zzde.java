package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbp;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class zzde
  extends zzbr
{
  public static final String cachePath = zzbd.zzid.toString();
  
  public zzde()
  {
    super(cachePath, new String[0]);
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    paramMap = Locale.getDefault();
    if (paramMap == null) {
      return zzgk.zzjwp;
    }
    paramMap = paramMap.getLanguage();
    if (paramMap == null) {
      return zzgk.zzjwp;
    }
    return zzgk.zzah(paramMap.toLowerCase());
  }
  
  public final boolean zzbcj()
  {
    return false;
  }
  
  public final String zzbdp()
  {
    return zzjrp;
  }
  
  public final Set zzbdq()
  {
    return zzjro;
  }
}
