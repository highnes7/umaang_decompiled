package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbe;
import com.google.android.android.internal.zzbp;
import java.util.Map;

public final class zzej
  extends zzbr
{
  public static final String cachePath = zzbd.zzih.toString();
  public static final String zzjtq = zzbe.zzrl.toString();
  public static final String zzjtr = zzbe.zzrj.toString();
  
  public zzej()
  {
    super(cachePath, new String[0]);
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    Object localObject1 = (zzbp)paramMap.get(zzjtq);
    paramMap = (zzbp)paramMap.get(zzjtr);
    if (localObject1 != null)
    {
      Object localObject2 = zzgk.zzjwp;
      if ((localObject1 != localObject2) && (paramMap != null) && (paramMap != localObject2))
      {
        localObject1 = zzgk.parseNumber((zzbp)localObject1);
        paramMap = zzgk.parseNumber(paramMap);
        localObject2 = zzgk.zzjwk;
        if ((localObject1 != localObject2) && (paramMap != localObject2))
        {
          double d3 = ((zzgj)localObject1).doubleValue();
          d2 = d3;
          double d4 = paramMap.doubleValue();
          d1 = d4;
          if (d3 <= d4) {
            break label122;
          }
        }
      }
    }
    double d2 = 0.0D;
    double d1 = 2.147483647E9D;
    label122:
    return zzgk.zzah(Long.valueOf(Math.round((d1 - d2) * Math.random() + d2)));
  }
  
  public final boolean zzbcj()
  {
    return false;
  }
}
