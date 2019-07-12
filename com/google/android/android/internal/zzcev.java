package com.google.android.android.internal;

import android.os.RemoteException;
import android.text.TextUtils;

public final class zzcev
  implements Runnable
{
  public zzcev(zzceo paramZzceo, boolean paramBoolean1, boolean paramBoolean2, zzcbk paramZzcbk, zzcas paramZzcas, String paramString) {}
  
  public final void run()
  {
    Object localObject2 = zziwf;
    zzcbo localZzcbo = zzivz;
    if (localZzcbo == null)
    {
      ((zzceo)localObject2).zzaul().zzayd().append("Discarding data. Failed to send event to service");
      return;
    }
    Object localObject1;
    if (zziwi)
    {
      if (zziwj) {
        localObject1 = null;
      } else {
        localObject1 = zziuo;
      }
      ((zzceo)localObject2).processData(localZzcbo, (zzbck)localObject1, zziuj);
    }
    else
    {
      localObject1 = zziah;
      try
      {
        boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
        if (bool)
        {
          localObject1 = zziuo;
          localObject2 = zziuj;
          localZzcbo.trim((zzcbk)localObject1, (zzcas)localObject2);
        }
        else
        {
          localObject1 = zziuo;
          localObject2 = zziah;
          zzceo localZzceo = zziwf;
          localZzcbo.handleResult((zzcbk)localObject1, (String)localObject2, localZzceo.zzaul().zzayk());
        }
      }
      catch (RemoteException localRemoteException)
      {
        zziwf.zzaul().zzayd().append("Failed to send event to the service", localRemoteException);
      }
    }
    zzceo.Refresh(zziwf);
  }
}
