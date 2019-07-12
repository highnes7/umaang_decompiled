package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbe;
import com.google.android.android.internal.zzbp;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public final class zzel
  extends zzbr
{
  public static final String cachePath = zzbd.zzix.toString();
  public static final String zzjts = zzbe.zzmn.toString();
  public static final String zzjtt = zzbe.zzmo.toString();
  public static final String zzjtu = zzbe.zzql.toString();
  public static final String zzjtv = zzbe.zzqe.toString();
  
  public zzel()
  {
    super(cachePath, new String[] { zzjts, zzjtt });
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    Object localObject = (zzbp)paramMap.get(zzjts);
    zzbp localZzbp1 = (zzbp)paramMap.get(zzjtt);
    int i;
    int j;
    if (localObject != null)
    {
      zzbp localZzbp2 = zzgk.zzjwp;
      if ((localObject != localZzbp2) && (localZzbp1 != null) && (localZzbp1 != localZzbp2))
      {
        i = 64;
        if (zzgk.valueOf((zzbp)paramMap.get(zzjtu)).booleanValue()) {
          i = 66;
        }
        j = 1;
        paramMap = (zzbp)paramMap.get(zzjtv);
        if (paramMap != null)
        {
          paramMap = zzgk.getFileSize(paramMap);
          if (paramMap == zzgk.zzjwi) {
            return zzgk.zzjwp;
          }
          int k = paramMap.intValue();
          j = k;
          if (k < 0) {
            return zzgk.zzjwp;
          }
        }
      }
    }
    try
    {
      paramMap = zzgk.toString((zzbp)localObject);
      localObject = zzgk.toString(localZzbp1);
      localZzbp1 = null;
      localObject = Pattern.compile((String)localObject, i).matcher(paramMap);
      boolean bool = ((Matcher)localObject).find();
      paramMap = localZzbp1;
      if (bool)
      {
        i = ((Matcher)localObject).groupCount();
        paramMap = localZzbp1;
        if (i >= j) {
          paramMap = ((Matcher)localObject).group(j);
        }
      }
      if (paramMap == null) {
        return zzgk.zzjwp;
      }
      paramMap = zzgk.zzah(paramMap);
      return paramMap;
    }
    catch (PatternSyntaxException paramMap)
    {
      for (;;) {}
    }
    return zzgk.zzjwp;
    return zzgk.zzjwp;
  }
  
  public final boolean zzbcj()
  {
    return true;
  }
}
