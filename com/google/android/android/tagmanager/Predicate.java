package com.google.android.android.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbe;
import com.google.android.android.internal.zzbp;
import java.util.Map;

public final class Predicate
  extends zzbr
{
  public static final String cachePath = zzbd.zzip.toString();
  public static final String zzjor = zzbe.zznq.toString();
  public static final String zzjos = zzbe.zznt.toString();
  public final Context zzahz;
  
  public Predicate(Context paramContext)
  {
    super(cachePath, new String[] { zzjos });
    zzahz = paramContext;
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    Object localObject1 = (zzbp)paramMap.get(zzjos);
    if (localObject1 == null) {
      return zzgk.zzjwp;
    }
    String str = zzgk.toString((zzbp)localObject1);
    paramMap = (zzbp)paramMap.get(zzjor);
    if (paramMap != null) {
      localObject1 = zzgk.toString(paramMap);
    } else {
      localObject1 = null;
    }
    Context localContext = zzahz;
    Object localObject2 = (String)zzcx.zzjsb.get(str);
    paramMap = (Map)localObject2;
    if (localObject2 == null)
    {
      localObject2 = localContext.getSharedPreferences("gtm_click_referrers", 0);
      paramMap = "";
      if (localObject2 != null) {
        paramMap = ((SharedPreferences)localObject2).getString(str, "");
      }
      zzcx.zzjsb.put(str, paramMap);
    }
    paramMap = zzcx.zzaw(paramMap, (String)localObject1);
    if (paramMap != null) {
      return zzgk.zzah(paramMap);
    }
    return zzgk.zzjwp;
  }
  
  public final boolean zzbcj()
  {
    return true;
  }
}
