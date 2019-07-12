package com.google.android.android.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.android.measurement.AppMeasurement.zzb;

public final class zzces
  implements Runnable
{
  public zzces(zzceo paramZzceo, AppMeasurement.zzb paramZzb) {}
  
  public final void run()
  {
    Object localObject2 = zziwf;
    zzcbo localZzcbo = zzivz;
    if (localZzcbo == null)
    {
      ((zzceo)localObject2).zzaul().zzayd().append("Failed to send current screen to service");
      return;
    }
    long l;
    Object localObject1;
    String str;
    if (zziwh == null)
    {
      l = 0L;
      localObject1 = null;
      str = null;
    }
    try
    {
      for (localObject2 = ((zzceo)localObject2).getContext().getPackageName();; localObject2 = ((zzceo)localObject2).getContext().getPackageName())
      {
        localZzcbo.onNetworkStateChanged(l, (String)localObject1, str, (String)localObject2);
        break;
        l = zziwh.zzikp;
        localObject1 = zziwh.zzikn;
        str = zziwh.zziko;
      }
      localObject1 = zziwf;
      zzceo.Refresh((zzceo)localObject1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zziwf.zzaul().zzayd().append("Failed to send current screen to the service", localRemoteException);
    }
  }
}
