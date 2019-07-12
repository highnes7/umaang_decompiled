package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbp;
import java.util.Map;

public abstract class zzdz
  extends zzeg
{
  public zzdz(String paramString)
  {
    super(paramString);
  }
  
  public final boolean match(zzbp paramZzbp1, zzbp paramZzbp2, Map paramMap)
  {
    paramZzbp1 = zzgk.parseNumber(paramZzbp1);
    paramZzbp2 = zzgk.parseNumber(paramZzbp2);
    zzgj localZzgj = zzgk.zzjwk;
    if ((paramZzbp1 != localZzgj) && (paramZzbp2 != localZzgj)) {
      return match(paramZzbp1, paramZzbp2, paramMap);
    }
    return false;
  }
  
  public abstract boolean match(zzgj paramZzgj1, zzgj paramZzgj2, Map paramMap);
}
