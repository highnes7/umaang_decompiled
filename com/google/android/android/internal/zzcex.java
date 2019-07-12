package com.google.android.android.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

public final class zzcex
  implements Runnable
{
  public zzcex(zzceo paramZzceo, AtomicReference paramAtomicReference, String paramString1, String paramString2, String paramString3, zzcas paramZzcas) {}
  
  public final void run()
  {
    localAtomicReference2 = zziwg;
    String str1;
    String str2;
    try
    {
      localObject2 = zziwf.zzivz;
      if (localObject2 == null) {
        localObject1 = zziwf;
      }
    }
    catch (Throwable localThrowable1) {}
    try
    {
      localObject1 = ((zzceo)localObject1).zzaul().zzayd();
      localObject2 = zziah;
      localObject2 = zzcbw.zzjf((String)localObject2);
      str1 = zzium;
      str2 = zziun;
      ((zzcby)localObject1).attribute("Failed to get conditional properties", localObject2, str1, str2);
      localObject1 = zziwg;
      ((AtomicReference)localObject1).set(Collections.emptyList());
    }
    catch (RemoteException localRemoteException)
    {
      zziwf.zzaul().zzayd().attribute("Failed to get conditional properties", zzcbw.zzjf(zziah), zzium, localRemoteException);
      zziwg.set(Collections.emptyList());
      localAtomicReference1 = zziwg;
      break label201;
      return;
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
    Object localObject1 = zziah;
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    Object localObject3;
    if (bool)
    {
      localObject1 = zziwg;
      str1 = zzium;
      str2 = zziun;
      localObject3 = zziuj;
    }
    for (Object localObject2 = ((zzcbo)localObject2).getFromLocationName(str1, str2, (zzcas)localObject3);; localObject2 = ((zzcbo)localObject2).getFromLocationName(str1, str2, (String)localObject3))
    {
      ((AtomicReference)localObject1).set(localObject2);
      break;
      localObject1 = zziwg;
      str1 = zziah;
      str2 = zzium;
      localObject3 = zziun;
    }
    localObject1 = zziwf;
    zzceo.Refresh((zzceo)localObject1);
    localObject1 = zziwg;
    label201:
    localObject1.notify();
    AtomicReference localAtomicReference1;
    zziwg.notify();
    throw localAtomicReference1;
  }
}
