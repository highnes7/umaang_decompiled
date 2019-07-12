package com.google.android.android.tagmanager;

public final class zzcb
  implements Runnable
{
  public zzcb(zzca paramZzca, zzbz paramZzbz, long paramLong, String paramString) {}
  
  public final void run()
  {
    if (zzca.access$getMFormat(zzjrz) == null)
    {
      zzfo localZzfo = zzfo.zzbez();
      localZzfo.copyToClipboard(zzca.access$getMContext(zzjrz), zzjrx);
      zzca.blur(zzjrz, localZzfo.zzbfa());
    }
    zzca.access$getMFormat(zzjrz).format(zzjry, zzbwk);
  }
}
