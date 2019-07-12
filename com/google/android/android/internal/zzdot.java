package com.google.android.android.internal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public final class zzdot
{
  public static final zzdov zzlsj = new zzdou();
  
  public static zzdos all(Map paramMap, Comparator paramComparator)
  {
    if (paramMap.size() < 25) {
      return zzdoq.getList(new ArrayList(paramMap.keySet()), paramMap, zzlsj, paramComparator);
    }
    return zzdpg.all(paramMap, paramComparator);
  }
  
  public static zzdos downTo(Comparator paramComparator)
  {
    return new zzdoq(paramComparator);
  }
  
  public static zzdos getList(List paramList, Map paramMap, zzdov paramZzdov, Comparator paramComparator)
  {
    if (paramList.size() < 25) {
      return zzdoq.getList(paramList, paramMap, paramZzdov, paramComparator);
    }
    return zzdpi.addChildren(paramList, paramMap, paramZzdov, paramComparator);
  }
  
  public static zzdov zzbqg()
  {
    return zzlsj;
  }
}
