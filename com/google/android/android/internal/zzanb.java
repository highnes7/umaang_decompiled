package com.google.android.android.internal;

public final class zzanb
  implements Runnable
{
  public zzanb(zzana paramZzana, zzaoj paramZzaoj) {}
  
  public final void run()
  {
    if (!zzdpi.zzdpe.isConnected())
    {
      zzdpi.zzdpe.zzdn("Connected to service after a timeout");
      zzamy.addOrUpdate(zzdpi.zzdpe, zzdph);
    }
  }
}
