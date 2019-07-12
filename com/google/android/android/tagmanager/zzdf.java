package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbd;
import java.util.Map;

public final class zzdf
  extends zzdz
{
  public static final String cachePath = zzbd.zzjx.toString();
  
  public zzdf()
  {
    super(cachePath);
  }
  
  public final boolean match(zzgj paramZzgj1, zzgj paramZzgj2, Map paramMap)
  {
    return paramZzgj1.compareTo(paramZzgj2) <= 0;
  }
}
