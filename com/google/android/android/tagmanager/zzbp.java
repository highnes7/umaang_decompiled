package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbd;
import java.util.Map;

public final class zzbp
  extends zzbr
{
  public static final String cachePath = zzbd.zzhz.toString();
  public final zzfc zzjpb;
  
  public zzbp(zzfc paramZzfc)
  {
    super(cachePath, new String[0]);
    zzjpb = paramZzfc;
  }
  
  public final com.google.android.android.internal.zzbp evaluate(Map paramMap)
  {
    paramMap = zzjpb.zzbeo();
    if (paramMap == null) {
      return zzgk.zzjwp;
    }
    return zzgk.zzah(paramMap);
  }
  
  public final boolean zzbcj()
  {
    return false;
  }
}
