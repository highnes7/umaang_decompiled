package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbp;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class zzbr
{
  public final Set<String> zzjro;
  public final String zzjrp;
  
  public zzbr(String paramString, String... paramVarArgs)
  {
    zzjrp = paramString;
    zzjro = new HashSet(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramVarArgs[i];
      zzjro.add(paramString);
      i += 1;
    }
  }
  
  public final boolean containsAll(Set paramSet)
  {
    return paramSet.containsAll(zzjro);
  }
  
  public abstract zzbp evaluate(Map paramMap);
  
  public abstract boolean zzbcj();
  
  public String zzbdp()
  {
    return zzjrp;
  }
  
  public Set zzbdq()
  {
    return zzjro;
  }
}
