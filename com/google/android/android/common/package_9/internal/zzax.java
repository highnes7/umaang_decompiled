package com.google.android.android.common.package_9.internal;

import java.util.ArrayList;

public final class zzax
  extends zzbb
{
  public final ArrayList<com.google.android.gms.common.api.Api.zze> zzfmd;
  
  public zzax(zzar paramZzar, ArrayList paramArrayList)
  {
    super(paramZzar, null);
    zzfmd = paramArrayList;
  }
  
  public final void zzagz()
  {
    Object localObject1 = zzflx;
    zzflh.zzfju.zzfmo = zzar.getSubscriptions((zzar)localObject1);
    localObject1 = zzfmd;
    int j = ((ArrayList)localObject1).size();
    int i = 0;
    while (i < j)
    {
      Object localObject2 = ((ArrayList)localObject1).get(i);
      i += 1;
      localObject2 = (com.google.android.android.common.package_9.Api.zze)localObject2;
      zzar localZzar = zzflx;
      ((com.google.android.android.common.package_9.Api.zze)localObject2).rename(zzflt, zzflh.zzfju.zzfmo);
    }
  }
}
