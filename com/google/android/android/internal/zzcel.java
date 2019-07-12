package com.google.android.android.internal;

import android.os.Bundle;
import com.google.android.android.measurement.AppMeasurement.zzb;

public final class zzcel
  implements Runnable
{
  public zzcel(zzcek paramZzcek, boolean paramBoolean, AppMeasurement.zzb paramZzb, zzcen paramZzcen) {}
  
  public final void run()
  {
    Object localObject2;
    if (zzivs)
    {
      localObject1 = zzivv;
      localObject2 = zzivj;
      if (localObject2 != null) {
        zzcek.setFollowing((zzcek)localObject1, (zzcen)localObject2);
      }
    }
    Object localObject1 = zzivt;
    if (localObject1 != null)
    {
      long l = zzikp;
      localObject2 = zzivu;
      if ((l == zzikp) && (zzcfw.zzas(zziko, zziko)) && (zzcfw.zzas(zzivt.zzikn, zzivu.zzikn)))
      {
        i = 0;
        break label111;
      }
    }
    int i = 1;
    label111:
    if (i != 0)
    {
      localObject1 = new Bundle();
      zzcek.add(zzivu, (Bundle)localObject1);
      localObject2 = zzivt;
      if (localObject2 != null)
      {
        localObject2 = zzikn;
        if (localObject2 != null) {
          ((Bundle)localObject1).putString("_pn", (String)localObject2);
        }
        ((Bundle)localObject1).putString("_pc", zzivt.zziko);
        ((Bundle)localObject1).putLong("_pi", zzivt.zzikp);
      }
      zzivv.zzatz().put("auto", "_vs", (Bundle)localObject1);
    }
    localObject1 = zzivv;
    zzivj = zzivu;
    ((zzcek)localObject1).zzauc().Refresh(zzivu);
  }
}
