package com.google.android.android.tagmanager;

import android.os.Build.VERSION;
import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbp;
import java.util.Map;

public final class zzfl
  extends zzbr
{
  public static final String cachePath = zzbd.zzil.toString();
  
  public zzfl()
  {
    super(cachePath, new String[0]);
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    return zzgk.zzah(Integer.valueOf(Build.VERSION.SDK_INT));
  }
  
  public final boolean zzbcj()
  {
    return true;
  }
}
