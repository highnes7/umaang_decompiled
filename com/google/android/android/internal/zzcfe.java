package com.google.android.android.internal;

public final class zzcfe
  implements Runnable
{
  public zzcfe(zzcfb paramZzcfb, zzcbo paramZzcbo) {}
  
  public final void run()
  {
    zzcfb localZzcfb = zziwp;
    try
    {
      zzcfb.updateButton(zziwp, false);
      if (!zziwp.zziwf.isConnected())
      {
        zziwp.zziwf.zzaul().zzayi().append("Connected to remote service");
        zziwp.zziwf.makeView(zziwq);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
