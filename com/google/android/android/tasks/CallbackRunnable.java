package com.google.android.android.tasks;

public final class CallbackRunnable
  implements Runnable
{
  public CallbackRunnable(Event paramEvent, Task paramTask) {}
  
  public final void run()
  {
    Object localObject = zzkgc.mLock;
    try
    {
      if (zzkgc.zzkgb != null) {
        zzkgc.zzkgb.onFailure(zzkfw.getException());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
