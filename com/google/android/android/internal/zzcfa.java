package com.google.android.android.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

public final class zzcfa
  implements Runnable
{
  public zzcfa(zzceo paramZzceo, AtomicReference paramAtomicReference, zzcas paramZzcas, boolean paramBoolean) {}
  
  public final void run()
  {
    localAtomicReference2 = zziwg;
    Object localObject = zziwf.zzivz;
    if (localObject == null) {
      localObject = zziwf;
    }
    try
    {
      ((zzceo)localObject).zzaul().zzayd().append("Failed to get user properties");
    }
    catch (Throwable localThrowable1) {}catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        AtomicReference localAtomicReference3;
        zzcas localZzcas;
        boolean bool;
        zziwf.zzaul().zzayd().append("Failed to get user properties", localRemoteException);
        localAtomicReference1 = zziwg;
      }
    }
    try
    {
      zziwg.notify();
      return;
    }
    catch (Throwable localThrowable2)
    {
      throw localThrowable2;
    }
    localAtomicReference3 = zziwg;
    localZzcas = zziuj;
    bool = zzivb;
    localAtomicReference3.set(((zzcbo)localObject).getFromLocationName(localZzcas, bool));
    localObject = zziwf;
    zzceo.Refresh((zzceo)localObject);
    localObject = zziwg;
    localObject.notify();
    AtomicReference localAtomicReference1;
    return;
    zziwg.notify();
    throw localAtomicReference1;
  }
}
