package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbe;
import com.google.android.android.internal.zzbp;
import java.util.Map;

public final class Way
  extends zzbr
{
  public static final String NAME = zzbd.zzho.toString();
  public static final String VALUE = zzbe.zzvk.toString();
  
  public Way()
  {
    super(NAME, new String[] { VALUE });
  }
  
  public static String zzbcl()
  {
    return NAME;
  }
  
  public static String zzbcm()
  {
    return VALUE;
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    return (zzbp)paramMap.get(VALUE);
  }
  
  public final boolean zzbcj()
  {
    return true;
  }
}
