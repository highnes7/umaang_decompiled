package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzeyn;

public final class zzfi
{
  public com.google.android.gms.tagmanager.zzea<com.google.android.gms.internal.zzbp> zzjux;
  public com.google.android.android.internal.zzbp zzjuy;
  
  public zzfi(zzea paramZzea, com.google.android.android.internal.zzbp paramZzbp)
  {
    zzjux = paramZzea;
    zzjuy = paramZzbp;
  }
  
  public final int getSize()
  {
    int j = ((com.google.android.android.internal.zzbp)zzjux.getObject()).zzcwg();
    com.google.android.android.internal.zzbp localZzbp = zzjuy;
    int i;
    if (localZzbp == null) {
      i = 0;
    } else {
      i = localZzbp.zzcwg();
    }
    return j + i;
  }
  
  public final zzea zzbeq()
  {
    return zzjux;
  }
  
  public final com.google.android.android.internal.zzbp zzber()
  {
    return zzjuy;
  }
}
