package com.google.android.android.tasks;

import com.google.android.gms.tasks.zzk;
import java.util.concurrent.Executor;

public final class SyncCampaign<TResult>
  implements zzk<TResult>
{
  public final Object mLock = new Object();
  public final Executor zzjqr;
  public com.google.android.gms.tasks.OnSuccessListener<? super TResult> zzkgd;
  
  public SyncCampaign(Executor paramExecutor, OnSuccessListener paramOnSuccessListener)
  {
    zzjqr = paramExecutor;
    zzkgd = paramOnSuccessListener;
  }
  
  public final void cancel()
  {
    Object localObject = mLock;
    try
    {
      zzkgd = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void onComplete(Task paramTask)
  {
    if (paramTask.isSuccessful())
    {
      Object localObject = mLock;
      try
      {
        if (zzkgd == null) {
          return;
        }
        zzjqr.execute(new Notifier(this, paramTask));
        return;
      }
      catch (Throwable paramTask)
      {
        throw paramTask;
      }
    }
  }
}
