package com.google.android.android.internal;

public final class zzamv
  implements Thread.UncaughtExceptionHandler
{
  public zzamv(zzamu paramZzamu) {}
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    paramThread = zzdou.zzwm();
    if (paramThread != null) {
      paramThread.toString("Job execution failed", paramThrowable);
    }
  }
}
