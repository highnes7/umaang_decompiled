package com.google.android.android.common.package_9.internal;

import java.util.concurrent.locks.Lock;

public abstract class zzbb
  implements Runnable
{
  public zzbb(zzar paramZzar) {}
  
  public void run()
  {
    zzflx.zzfke.lock();
    try
    {
      boolean bool = Thread.interrupted();
      if (bool)
      {
        zzflx.zzfke.unlock();
        return;
      }
      zzagz();
      zzflx.zzfke.unlock();
      return;
    }
    catch (Throwable localThrowable) {}catch (RuntimeException localRuntimeException)
    {
      zzflx.zzflh.onFutureDone(localRuntimeException);
      zzflx.zzfke.unlock();
      return;
    }
    zzflx.zzfke.unlock();
    throw localRuntimeException;
  }
  
  public abstract void zzagz();
}
