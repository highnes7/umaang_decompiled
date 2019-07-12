package com.google.android.android.internal;

import java.util.Collections;
import java.util.Map;

public final class zzdbq
{
  public final zzbp zzjuy;
  public final Map<String, com.google.android.gms.internal.zzbp> zzkec;
  
  public zzdbq(Map paramMap, zzbp paramZzbp)
  {
    zzkec = paramMap;
    zzjuy = paramZzbp;
  }
  
  public static zzdbr zzbhv()
  {
    return new zzdbr();
  }
  
  public final void put(String paramString, zzbp paramZzbp)
  {
    zzkec.put(paramString, paramZzbp);
  }
  
  public final String toString()
  {
    String str1 = String.valueOf(Collections.unmodifiableMap(zzkec));
    String str2 = String.valueOf(zzjuy);
    int i = str1.length();
    StringBuilder localStringBuilder = new StringBuilder(str2.length() + (i + 32));
    localStringBuilder.append("Properties: ");
    localStringBuilder.append(str1);
    localStringBuilder.append(" pushAfterEvaluate: ");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
  
  public final zzbp zzber()
  {
    return zzjuy;
  }
  
  public final Map zzbhd()
  {
    return Collections.unmodifiableMap(zzkec);
  }
}
