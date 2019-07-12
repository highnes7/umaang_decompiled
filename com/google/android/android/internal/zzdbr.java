package com.google.android.android.internal;

import java.util.HashMap;
import java.util.Map;

public final class zzdbr
{
  public zzbp zzjuy;
  public final Map<String, com.google.android.gms.internal.zzbp> zzkec = new HashMap();
  
  public zzdbr() {}
  
  public final zzdbr lookup(String paramString, zzbp paramZzbp)
  {
    zzkec.put(paramString, paramZzbp);
    return this;
  }
  
  public final zzdbr xor(zzbp paramZzbp)
  {
    zzjuy = paramZzbp;
    return this;
  }
  
  public final zzdbq zzbhw()
  {
    return new zzdbq(zzkec, zzjuy, null);
  }
}
