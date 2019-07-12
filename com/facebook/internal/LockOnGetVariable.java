package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

public class LockOnGetVariable<T>
{
  public CountDownLatch initLatch;
  public T value;
  
  public LockOnGetVariable(Object paramObject)
  {
    value = paramObject;
  }
  
  public LockOnGetVariable(final Callable paramCallable)
  {
    initLatch = new CountDownLatch(1);
    FacebookSdk.getExecutor().execute(new FutureTask(new Callable()
    {
      public Void call()
        throws Exception
      {
        try
        {
          value = paramCallable.call();
          initLatch.countDown();
          return null;
        }
        catch (Throwable localThrowable)
        {
          initLatch.countDown();
          throw localThrowable;
        }
      }
    }));
  }
  
  private void waitOnInit()
  {
    CountDownLatch localCountDownLatch = initLatch;
    if (localCountDownLatch == null) {
      return;
    }
    try
    {
      localCountDownLatch.await();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public Object getValue()
  {
    waitOnInit();
    return value;
  }
}
