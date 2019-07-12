package com.google.android.android.tagmanager;

import android.os.Build;
import com.google.android.android.internal.zzbp;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.Map;

public final class zzbd
  extends zzbr
{
  public static final String cachePath = com.google.android.android.internal.zzbd.zzht.toString();
  
  public zzbd()
  {
    super(cachePath, new String[0]);
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    String str2 = Build.MANUFACTURER;
    String str1 = Build.MODEL;
    paramMap = str1;
    if (!str1.startsWith(str2))
    {
      paramMap = str1;
      if (!str2.equals("unknown"))
      {
        int i = str2.length();
        paramMap = StringBuilder.append(str1.length() + (i + 1), str2, " ", str1);
      }
    }
    return zzgk.zzah(paramMap);
  }
  
  public final boolean zzbcj()
  {
    return true;
  }
}
