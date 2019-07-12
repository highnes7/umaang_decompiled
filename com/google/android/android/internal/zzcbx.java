package com.google.android.android.internal;

public final class zzcbx
  implements Runnable
{
  public zzcbx(zzcbw paramZzcbw, String paramString) {}
  
  public final void run()
  {
    zzcch localZzcch = zziqc.zziki.zzaum();
    if (!localZzcch.isInitialized())
    {
      zziqc.add(6, "Persisted config not initialized. Not logging error/warn");
      return;
    }
    zziqo.store(zziqb, 1L);
  }
}
