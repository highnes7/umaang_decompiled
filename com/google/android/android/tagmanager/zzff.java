package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzdbu;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzff
  implements zzfh
{
  public zzff(zzfc paramZzfc, Map paramMap1, Map paramMap2, Map paramMap3, Map paramMap4) {}
  
  public final void putAll(zzdbu paramZzdbu, Set paramSet1, Set paramSet2, zzer paramZzer)
  {
    List localList = (List)zzjut.get(paramZzdbu);
    zzjuu.get(paramZzdbu);
    if (localList != null)
    {
      paramSet1.addAll(localList);
      paramZzer.zzbdx();
    }
    paramSet1 = (List)zzjuv.get(paramZzdbu);
    zzjuw.get(paramZzdbu);
    if (paramSet1 != null)
    {
      paramSet2.addAll(paramSet1);
      paramZzer.zzbdy();
    }
  }
}
