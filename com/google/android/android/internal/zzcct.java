package com.google.android.android.internal;

import com.google.android.android.common.internal.zzbp;

public final class zzcct
  implements Thread.UncaughtExceptionHandler
{
  public final String zzisl;
  
  public zzcct(zzccr paramZzccr, String paramString)
  {
    zzbp.append(paramString);
    zzisl = paramString;
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      zzism.zzaul().zzayd().append(zzisl, paramThrowable);
      return;
    }
    catch (Throwable paramThread)
    {
      throw paramThread;
    }
  }
}
