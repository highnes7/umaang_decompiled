package com.google.android.android.tasks;

import com.google.android.gms.tasks.zzk;
import java.util.concurrent.Executor;

public final class Event<TResult>
  implements zzk<TResult>
{
  public final Object mLock = new Object();
  public final Executor zzjqr;
  public OnFailureListener zzkgb;
  
  public Event(Executor paramExecutor, OnFailureListener paramOnFailureListener)
  {
    zzjqr = paramExecutor;
    zzkgb = paramOnFailureListener;
  }
  
  public final void cancel()
  {
    Object localObject = mLock;
    try
    {
      zzkgb = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void onComplete(Task paramTask)
  {
    if (!paramTask.isSuccessful())
    {
      Object localObject = mLock;
      try
      {
        if (zzkgb == null) {
          return;
        }
        zzjqr.execute(new CallbackRunnable(this, paramTask));
        return;
      }
      catch (Throwable paramTask)
      {
        throw paramTask;
      }
    }
  }
}
