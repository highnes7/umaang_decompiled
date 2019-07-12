package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbe;
import com.google.android.android.internal.zzbp;
import java.util.Map;

public final class zzas
  extends zzbr
{
  public static final String NAME = zzbe.zzrn.toString();
  public static final String URL = zzbd.zzhq.toString();
  public static final String zzjqp = zzbe.zzos.toString();
  public final DataLayer zzjpa;
  
  public zzas(DataLayer paramDataLayer)
  {
    super(URL, new String[] { NAME });
    zzjpa = paramDataLayer;
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    Object localObject = zzjpa.getValue(zzgk.toString((zzbp)paramMap.get(NAME)));
    if (localObject == null)
    {
      paramMap = (zzbp)paramMap.get(zzjqp);
      if (paramMap != null) {
        return paramMap;
      }
      return zzgk.zzjwp;
    }
    return zzgk.zzah(localObject);
  }
  
  public final boolean zzbcj()
  {
    return false;
  }
}
