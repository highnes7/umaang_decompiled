package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbi;
import com.google.android.android.internal.zzbj;
import com.google.android.android.internal.zzbn;
import com.google.android.android.internal.zzbp;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.Map;

public final class zzbq
{
  public static void parseString(DataLayer paramDataLayer, zzbn paramZzbn)
  {
    Object localObject = zzxv;
    if (localObject == null)
    {
      zzdj.zzjss.zzcr("supplemental missing experimentSupplemental");
      return;
    }
    localObject = zzwg;
    int k = localObject.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      paramDataLayer.zzlj(zzgk.toString(localObject[i]));
      i += 1;
    }
    zzbp[] arrayOfZzbp = zzxv.zzwf;
    k = arrayOfZzbp.length;
    i = j;
    while (i < k)
    {
      localObject = zzgk.get(arrayOfZzbp[i]);
      if (!(localObject instanceof Map))
      {
        localObject = String.valueOf(localObject);
        localObject = StringBuilder.append(((String)localObject).length() + 36, "value: ", (String)localObject, " is not a map value, ignored.");
        zzdj.zzjss.zzcr((String)localObject);
        localObject = null;
      }
      else
      {
        localObject = (Map)localObject;
      }
      if (localObject != null) {
        paramDataLayer.push((Map)localObject);
      }
      i += 1;
    }
    serialize(paramDataLayer, zzxv);
  }
  
  public static void serialize(DataLayer paramDataLayer, zzbj paramZzbj)
  {
    zzbi[] arrayOfZzbi = zzwh;
    int j = arrayOfZzbi.length;
    int i = 0;
    while (i < j)
    {
      zzbi localZzbi = arrayOfZzbi[i];
      paramZzbj = name;
      Object localObject;
      if (paramZzbj == null) {
        localObject = zzdj.zzjss;
      }
      for (paramZzbj = "GaExperimentRandom: No key";; paramZzbj = "GaExperimentRandom: random range invalid")
      {
        ((zzdk)localObject).zzcr(paramZzbj);
        break;
        localObject = paramDataLayer.getValue(paramZzbj);
        paramZzbj = (zzbj)localObject;
        if (!(localObject instanceof Number)) {
          localObject = null;
        } else {
          localObject = Long.valueOf(((Number)localObject).longValue());
        }
        long l1 = zzwb;
        long l2 = zzwc;
        if ((!zzwd) || (localObject == null) || (((Long)localObject).longValue() < l1) || (((Long)localObject).longValue() > l2))
        {
          if (l1 <= l2)
          {
            double d1 = Math.random();
            double d2 = l2 - l1;
            Double.isNaN(d2);
            double d3 = l1;
            Double.isNaN(d3);
            paramZzbj = Long.valueOf(Math.round(d1 * d2 + d3));
          }
        }
        else
        {
          paramDataLayer.zzlj(name);
          paramZzbj = DataLayer.valueOf(name, paramZzbj);
          if (zzwe > 0L) {
            if (!paramZzbj.containsKey("gtm"))
            {
              paramZzbj.put("gtm", DataLayer.mapOf(new Object[] { "lifetime", Long.valueOf(zzwe) }));
            }
            else
            {
              localObject = paramZzbj.get("gtm");
              if ((localObject instanceof Map)) {
                ((Map)localObject).put("lifetime", Long.valueOf(zzwe));
              } else {
                zzdj.zzjss.zzcr("GaExperimentRandom: gtm not a map");
              }
            }
          }
          paramDataLayer.push(paramZzbj);
          break;
        }
        localObject = zzdj.zzjss;
      }
      i += 1;
    }
  }
}
