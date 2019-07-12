package com.google.android.android.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.MergedCells;
import java.util.HashSet;
import java.util.Set;

public final class zzanv
{
  public final zzamu zzdjj;
  public volatile Boolean zzdqo;
  public String zzdqp;
  public Set<Integer> zzdqq;
  
  public zzanv(zzamu paramZzamu)
  {
    zzbp.append(paramZzamu);
    zzdjj = paramZzamu;
  }
  
  public static boolean zzxv()
  {
    return ((Boolean)zzaod.zzdra.setDoOutput()).booleanValue();
  }
  
  public static int zzxw()
  {
    return ((Integer)zzaod.zzdrx.setDoOutput()).intValue();
  }
  
  public static long zzxx()
  {
    return ((Long)zzaod.zzdri.setDoOutput()).longValue();
  }
  
  public static long zzxy()
  {
    return ((Long)zzaod.zzdrl.setDoOutput()).longValue();
  }
  
  public static int zzxz()
  {
    return ((Integer)zzaod.zzdrn.setDoOutput()).intValue();
  }
  
  public static int zzya()
  {
    return ((Integer)zzaod.zzdro.setDoOutput()).intValue();
  }
  
  public static String zzyb()
  {
    return (String)zzaod.zzdrq.setDoOutput();
  }
  
  public static String zzyc()
  {
    return (String)zzaod.zzdrp.setDoOutput();
  }
  
  public static String zzyd()
  {
    return (String)zzaod.zzdrr.setDoOutput();
  }
  
  public static long zzyf()
  {
    return ((Long)zzaod.zzdsf.setDoOutput()).longValue();
  }
  
  public final boolean zzxu()
  {
    if (zzdqo == null) {}
    for (;;)
    {
      try
      {
        if (zzdqo == null)
        {
          Object localObject = zzdjj.getContext().getApplicationInfo();
          String str = MergedCells.zzalk();
          if (localObject != null)
          {
            localObject = processName;
            if ((localObject == null) || (!((String)localObject).equals(str))) {
              break label142;
            }
            bool = true;
            zzdqo = Boolean.valueOf(bool);
          }
          if (((zzdqo == null) || (!zzdqo.booleanValue())) && ("com.google.android.gms.analytics".equals(str))) {
            zzdqo = Boolean.TRUE;
          }
          if (zzdqo == null)
          {
            zzdqo = Boolean.TRUE;
            zzdjj.zzvy().zzdq("My process not in the list of running processes");
          }
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      return zzdqo.booleanValue();
      label142:
      boolean bool = false;
    }
  }
  
  public final Set zzye()
  {
    String str1 = (String)zzaod.zzdsa.setDoOutput();
    Object localObject;
    HashSet localHashSet;
    int j;
    int i;
    if (zzdqq != null)
    {
      localObject = zzdqp;
      if ((localObject != null) && (((String)localObject).equals(str1))) {}
    }
    else
    {
      localObject = TextUtils.split(str1, ",");
      localHashSet = new HashSet();
      j = localObject.length;
      i = 0;
    }
    for (;;)
    {
      String str2;
      if (i < j) {
        str2 = localObject[i];
      }
      try
      {
        localHashSet.add(Integer.valueOf(Integer.parseInt(str2)));
        i += 1;
        continue;
        zzdqp = str1;
        zzdqq = localHashSet;
        return zzdqq;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;) {}
      }
    }
  }
}
