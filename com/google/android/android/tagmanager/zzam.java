package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbe;
import com.google.android.android.internal.zzbp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzam
  extends zzbr
{
  public static final String cachePath = zzbd.zzia.toString();
  public static final String zzjot = zzbe.zzma.toString();
  public static final String zzjqe = zzbe.zzqd.toString();
  public final zzan zzjqf;
  
  public zzam(zzan paramZzan)
  {
    super(cachePath, new String[] { zzjqe });
    zzjqf = paramZzan;
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    String str = zzgk.toString((zzbp)paramMap.get(zzjqe));
    Object localObject = new HashMap();
    paramMap = (zzbp)paramMap.get(zzjot);
    if (paramMap != null)
    {
      paramMap = zzgk.get(paramMap);
      if (!(paramMap instanceof Map)) {
        zzdj.zzjss.zzcr("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
      }
    }
    for (;;)
    {
      return zzgk.zzjwp;
      paramMap = ((Map)paramMap).entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        ((Map)localObject).put(localEntry.getKey().toString(), localEntry.getValue());
      }
      paramMap = zzjqf;
      try
      {
        paramMap = zzgk.zzah(paramMap.getRawValue(str, (Map)localObject));
        return paramMap;
      }
      catch (Exception paramMap)
      {
        paramMap = paramMap.getMessage();
        localObject = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramMap, f.sufficientlysecure.rootcommands.util.StringBuilder.append(str, 34)));
        ((StringBuilder)localObject).append("Custom macro/tag ");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(" threw exception ");
        ((StringBuilder)localObject).append(paramMap);
        paramMap = ((StringBuilder)localObject).toString();
        zzdj.zzjss.zzcr(paramMap);
      }
    }
  }
  
  public final boolean zzbcj()
  {
    return false;
  }
}
