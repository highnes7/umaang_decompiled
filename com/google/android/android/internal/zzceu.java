package com.google.android.android.internal;

import android.os.RemoteException;

public final class zzceu
  implements Runnable
{
  public zzceu(zzceo paramZzceo, zzcas paramZzcas) {}
  
  public final void run()
  {
    Object localObject2 = zziwf;
    Object localObject1 = zzivz;
    if (localObject1 == null)
    {
      ((zzceo)localObject2).zzaul().zzayd().append("Failed to send measurementEnabled to service");
      return;
    }
    localObject2 = zziuj;
    try
    {
      ((zzcbo)localObject1).getAbsoluteUrl((zzcas)localObject2);
      localObject1 = zziwf;
      zzceo.Refresh((zzceo)localObject1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zziwf.zzaul().zzayd().append("Failed to send measurementEnabled to the service", localRemoteException);
    }
  }
}
