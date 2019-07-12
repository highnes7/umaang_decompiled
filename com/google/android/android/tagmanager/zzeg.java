package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbe;
import com.google.android.android.internal.zzbp;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class zzeg
  extends zzbr
{
  public static final String zzjrk = zzbe.zzmn.toString();
  public static final String zzjth = zzbe.zzmo.toString();
  
  public zzeg(String paramString)
  {
    super(paramString, new String[] { zzjrk, zzjth });
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    Object localObject = paramMap.values().iterator();
    boolean bool2;
    do
    {
      bool1 = ((Iterator)localObject).hasNext();
      bool2 = false;
      if (!bool1) {
        break;
      }
    } while ((zzbp)((Iterator)localObject).next() != zzgk.zzjwp);
    boolean bool1 = bool2;
    for (;;)
    {
      return zzgk.zzah(Boolean.valueOf(bool1));
      localObject = (zzbp)paramMap.get(zzjrk);
      zzbp localZzbp = (zzbp)paramMap.get(zzjth);
      bool1 = bool2;
      if (localObject != null) {
        if (localZzbp == null) {
          bool1 = bool2;
        } else {
          bool1 = match((zzbp)localObject, localZzbp, paramMap);
        }
      }
    }
  }
  
  public abstract boolean match(zzbp paramZzbp1, zzbp paramZzbp2, Map paramMap);
  
  public final boolean zzbcj()
  {
    return true;
  }
  
  public final String zzbdp()
  {
    return zzjrp;
  }
  
  public final Set zzbdq()
  {
    return zzjro;
  }
}
