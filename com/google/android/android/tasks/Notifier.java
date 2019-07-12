package com.google.android.android.tasks;

public final class Notifier
  implements Runnable
{
  public Notifier(SyncCampaign paramSyncCampaign, Task paramTask) {}
  
  public final void run()
  {
    Object localObject = zzkge.mLock;
    try
    {
      if (zzkge.zzkgd != null) {
        zzkge.zzkgd.onSuccess(zzkfw.getResult());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
