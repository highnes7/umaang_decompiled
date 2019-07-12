package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbe;
import com.google.android.android.internal.zzbp;
import java.util.Map;

public final class zzgm
  extends zzbr
{
  public static final String cachePath = zzbd.zzja.toString();
  public static final String zzjrk = zzbe.zzmn.toString();
  
  public zzgm()
  {
    super(cachePath, new String[] { zzjrk });
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    return zzgk.zzah(zzgk.toString((zzbp)paramMap.get(zzjrk)).toUpperCase());
  }
  
  public final boolean zzbcj()
  {
    return true;
  }
}
