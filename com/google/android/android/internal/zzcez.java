package com.google.android.android.internal;

public final class zzcez
  implements Runnable
{
  public zzcez(zzceo paramZzceo, boolean paramBoolean, zzcft paramZzcft, zzcas paramZzcas) {}
  
  public final void run()
  {
    zzceo localZzceo = zziwf;
    zzcbo localZzcbo = zzivz;
    if (localZzcbo == null)
    {
      localZzceo.zzaul().zzayd().append("Discarding data. Failed to set user attribute");
      return;
    }
    zzcft localZzcft;
    if (zziwj) {
      localZzcft = null;
    } else {
      localZzcft = zziup;
    }
    localZzceo.processData(localZzcbo, localZzcft, zziuj);
    zzceo.Refresh(zziwf);
  }
}
