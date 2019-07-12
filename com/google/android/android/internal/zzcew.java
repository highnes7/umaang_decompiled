package com.google.android.android.internal;

import android.os.RemoteException;
import android.text.TextUtils;

public final class zzcew
  implements Runnable
{
  public zzcew(zzceo paramZzceo, boolean paramBoolean1, boolean paramBoolean2, zzcav paramZzcav1, zzcas paramZzcas, zzcav paramZzcav2) {}
  
  public final void run()
  {
    Object localObject2 = zziwf;
    zzcbo localZzcbo = zzivz;
    if (localZzcbo == null)
    {
      ((zzceo)localObject2).zzaul().zzayd().append("Discarding data. Failed to send conditional user property to service");
      return;
    }
    Object localObject1;
    if (zziwi)
    {
      if (zziwj) {
        localObject1 = null;
      } else {
        localObject1 = zziwk;
      }
      ((zzceo)localObject2).processData(localZzcbo, (zzbck)localObject1, zziuj);
    }
    else
    {
      localObject1 = zziwl.packageName;
      try
      {
        boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
        if (bool)
        {
          localObject1 = zziwk;
          localObject2 = zziuj;
          localZzcbo.getPackageInfo((zzcav)localObject1, (zzcas)localObject2);
        }
        else
        {
          localObject1 = zziwk;
          localZzcbo.addPackage((zzcav)localObject1);
        }
      }
      catch (RemoteException localRemoteException)
      {
        zziwf.zzaul().zzayd().append("Failed to send conditional user property to the service", localRemoteException);
      }
    }
    zzceo.Refresh(zziwf);
  }
}
