package com.google.android.android.tagmanager;

import android.os.Build.VERSION;
import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbp;
import java.util.Map;

public final class zzeb
  extends zzbr
{
  public static final String cachePath = zzbd.zzif.toString();
  
  public zzeb()
  {
    super(cachePath, new String[0]);
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    return zzgk.zzah(Build.VERSION.RELEASE);
  }
  
  public final boolean zzbcj()
  {
    return true;
  }
}
