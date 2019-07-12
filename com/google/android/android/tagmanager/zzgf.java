package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbp;
import java.util.Map;

public final class zzgf
  extends zzbr
{
  public static final String cachePath = zzbd.zzin.toString();
  
  public zzgf()
  {
    super(cachePath, new String[0]);
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    return zzgk.zzah(Long.valueOf(System.currentTimeMillis()));
  }
  
  public final boolean zzbcj()
  {
    return false;
  }
}
