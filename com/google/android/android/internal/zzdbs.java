package com.google.android.android.internal;

import com.google.android.gms.internal.zzdbq;
import com.google.android.gms.internal.zzdbu;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class zzdbs
{
  public final String zzfaa;
  public final List<zzdbu> zzkdz;
  public final Map<String, List<zzdbq>> zzkea;
  public final int zzkeb;
  
  public zzdbs(List paramList, Map paramMap, String paramString, int paramInt)
  {
    zzkdz = Collections.unmodifiableList(paramList);
    zzkea = Collections.unmodifiableMap(paramMap);
    zzfaa = paramString;
    zzkeb = paramInt;
  }
  
  public static zzdbt zzbhx()
  {
    return new zzdbt();
  }
  
  public final String getVersion()
  {
    return zzfaa;
  }
  
  public final String toString()
  {
    String str1 = String.valueOf(zzkdz);
    String str2 = String.valueOf(zzkea);
    int i = str1.length();
    StringBuilder localStringBuilder = new StringBuilder(str2.length() + (i + 17));
    localStringBuilder.append("Rules: ");
    localStringBuilder.append(str1);
    localStringBuilder.append("  Macros: ");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
  
  public final List zzbhb()
  {
    return zzkdz;
  }
  
  public final Map zzbhy()
  {
    return zzkea;
  }
}
