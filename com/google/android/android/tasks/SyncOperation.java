package com.google.android.android.tasks;

import com.google.android.gms.tasks.zzk;
import java.util.ArrayDeque;
import java.util.Queue;

public final class SyncOperation<TResult>
{
  public final java.lang.Object mLock = new java.lang.Object();
  public Queue<zzk<TResult>> zzkgf;
  public boolean zzkgg;
  
  public SyncOperation() {}
  
  public final void addKey(Object paramObject)
  {
    java.lang.Object localObject = mLock;
    try
    {
      if (zzkgf == null) {
        zzkgf = new ArrayDeque();
      }
      zzkgf.add(paramObject);
      return;
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
  }
  
  public final void execute(Task paramTask)
  {
    java.lang.Object localObject = mLock;
    try
    {
      if ((zzkgf != null) && (!zzkgg))
      {
        zzkgg = true;
        for (;;)
        {
          localObject = mLock;
          try
          {
            Object localObject1 = (Object)zzkgf.poll();
            if (localObject1 == null)
            {
              zzkgg = false;
              return;
            }
            localObject1.onComplete(paramTask);
          }
          catch (Throwable paramTask)
          {
            throw paramTask;
          }
        }
      }
      return;
    }
    catch (Throwable paramTask)
    {
      throw paramTask;
    }
  }
}
