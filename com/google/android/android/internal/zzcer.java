package com.google.android.android.internal;

import android.os.RemoteException;

public final class zzcer
  implements Runnable
{
  public zzcer(zzceo paramZzceo, zzcas paramZzcas) {}
  
  public final void run()
  {
    Object localObject2 = zziwf;
    Object localObject1 = zzivz;
    if (localObject1 == null)
    {
      ((zzceo)localObject2).zzaul().zzayd().append("Discarding data. Failed to send app launch");
      return;
    }
    localObject2 = zziuj;
    try
    {
      ((zzcbo)localObject1).bindToService((zzcas)localObject2);
      localObject2 = zziwf;
      zzcas localZzcas = zziuj;
      ((zzceo)localObject2).processData((zzcbo)localObject1, null, localZzcas);
      localObject1 = zziwf;
      zzceo.Refresh((zzceo)localObject1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zziwf.zzaul().zzayd().append("Failed to send app launch to the service", localRemoteException);
    }
  }
}
