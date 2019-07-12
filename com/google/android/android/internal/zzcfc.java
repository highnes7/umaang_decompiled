package com.google.android.android.internal;

public final class zzcfc
  implements Runnable
{
  public zzcfc(zzcfb paramZzcfb, zzcbo paramZzcbo) {}
  
  public final void run()
  {
    zzcfb localZzcfb = zziwp;
    try
    {
      zzcfb.updateButton(zziwp, false);
      if (!zziwp.zziwf.isConnected())
      {
        zziwp.zziwf.zzaul().zzayj().append("Connected to service");
        zziwp.zziwf.makeView(zziwo);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
