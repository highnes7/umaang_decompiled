package com.google.android.android.tagmanager;

import android.content.Context;
import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbe;
import com.google.android.android.internal.zzbp;
import java.util.Map;

public final class zzcw
  extends zzbr
{
  public static final String cachePath = zzbd.zziu.toString();
  public static final String zzjor = zzbe.zznq.toString();
  public final Context zzahz;
  
  public zzcw(Context paramContext)
  {
    super(cachePath, new String[0]);
    zzahz = paramContext;
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    if ((zzbp)paramMap.get(zzjor) != null) {
      paramMap = zzgk.toString((zzbp)paramMap.get(zzjor));
    } else {
      paramMap = null;
    }
    paramMap = zzcx.zzal(zzahz, paramMap);
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
