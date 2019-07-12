package com.google.android.android.common.package_9.internal;

import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.PingManager;
import com.google.android.android.common.internal.Track;
import com.google.android.android.internal.zzcps;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzau
  extends zzbb
{
  public final Map<com.google.android.gms.common.api.Api.zze, com.google.android.gms.common.api.internal.zzat> zzflz;
  
  public zzau(zzar paramZzar, Map paramMap)
  {
    super(paramZzar, null);
    zzflz = paramMap;
  }
  
  public final void zzagz()
  {
    Object localObject1 = zzflz.keySet().iterator();
    int k = 1;
    int m = 0;
    int i = 0;
    int j = 1;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.google.android.android.common.package_9.Api.zze)((Iterator)localObject1).next();
      if (((com.google.android.android.common.package_9.Api.zze)localObject2).zzaff())
      {
        if (!zzflz.get(localObject2)).zzfjs)
        {
          i = 1;
          break label96;
        }
        i = 1;
      }
      else
      {
        j = 0;
      }
    }
    k = i;
    i = 0;
    label96:
    if (k != 0)
    {
      localObject1 = zzflx;
      m = zzfko.isGooglePlayServicesAvailable(mContext);
    }
    if ((m != 0) && ((i != 0) || (j != 0)))
    {
      localObject1 = new ConnectionResult(m, null);
      localObject2 = zzflx;
      zzflh.enqueue(new zzav(this, (zzbk)localObject2, (ConnectionResult)localObject1));
      return;
    }
    localObject1 = zzflx;
    if (zzflr) {
      zzflp.connect();
    }
    localObject1 = zzflz.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (com.google.android.android.common.package_9.Api.zze)((Iterator)localObject1).next();
      localObject2 = (Track)zzflz.get(localObject3);
      if ((((com.google.android.android.common.package_9.Api.zze)localObject3).zzaff()) && (m != 0))
      {
        localObject3 = zzflx;
        zzflh.enqueue(new zzaw(this, (zzbk)localObject3, (Track)localObject2));
      }
      else
      {
        ((com.google.android.android.common.package_9.Api.zze)localObject3).disconnect((Track)localObject2);
      }
    }
  }
}
