package com.google.android.android.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

public final class zzceq
  implements Runnable
{
  public zzceq(zzceo paramZzceo, AtomicReference paramAtomicReference, zzcas paramZzcas) {}
  
  public final void run()
  {
    localAtomicReference2 = zziwg;
    Object localObject1 = zziwf.zzivz;
    if (localObject1 == null) {
      localObject1 = zziwf;
    }
    try
    {
      ((zzceo)localObject1).zzaul().zzayd().append("Failed to get app instance id");
    }
    catch (Throwable localThrowable1) {}catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Object localObject2;
        zzcas localZzcas;
        zziwf.zzaul().zzayd().append("Failed to get app instance id", localRemoteException);
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
    localObject2 = zziwg;
    localZzcas = zziuj;
    ((AtomicReference)localObject2).set(((zzcbo)localObject1).getAttachment(localZzcas));
    localObject1 = zziwg;
    localObject1 = ((AtomicReference)localObject1).get();
    localObject1 = (String)localObject1;
    if (localObject1 != null)
    {
      localObject2 = zziwf;
      ((zzceo)localObject2).zzatz().zzjk((String)localObject1);
      localObject2 = zziwf;
      localObject2 = ((zzceo)localObject2).zzaum();
      localObject2 = zziqv;
      ((zzccm)localObject2).zzjl((String)localObject1);
    }
    localObject1 = zziwf;
    zzceo.Refresh((zzceo)localObject1);
    localObject1 = zziwg;
    localObject1.notify();
    AtomicReference localAtomicReference1;
    return;
    zziwg.notify();
    throw localAtomicReference1;
  }
}
