package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbe;
import com.google.android.android.internal.zzbp;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzaz
  extends zzgi
{
  public static final String ID = zzbd.zziy.toString();
  public static final String VALUE = zzbe.zzvk.toString();
  public static final String zzjra = zzbe.zznl.toString();
  public final DataLayer zzjpa;
  
  public zzaz(DataLayer paramDataLayer)
  {
    super(ID, new String[] { VALUE });
    zzjpa = paramDataLayer;
  }
  
  public final void doInBackground(Map paramMap)
  {
    Object localObject1 = (zzbp)paramMap.get(VALUE);
    if (localObject1 != null)
    {
      zzgk.zzbff();
      localObject1 = zzgk.get((zzbp)localObject1);
      if ((localObject1 instanceof List))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          if ((localObject2 instanceof Map))
          {
            localObject2 = (Map)localObject2;
            zzjpa.push((Map)localObject2);
          }
        }
      }
    }
    paramMap = (zzbp)paramMap.get(zzjra);
    if (paramMap != null)
    {
      zzgk.zzbff();
      paramMap = zzgk.toString(paramMap);
      if (paramMap != zzgk.zzjwl) {
        zzjpa.zzlj(paramMap);
      }
    }
  }
}
