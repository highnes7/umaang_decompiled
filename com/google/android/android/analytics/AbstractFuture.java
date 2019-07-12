package com.google.android.android.analytics;

import android.util.Log;
import java.util.concurrent.FutureTask;

public final class AbstractFuture
  extends FutureTask<T>
{
  public AbstractFuture(zzj.zza paramZza, Runnable paramRunnable, Object paramObject)
  {
    super(paramRunnable, paramObject);
  }
  
  public final void setException(Throwable paramThrowable)
  {
    Object localObject = zzdlf.zzdle.zzdlc;
    if (localObject != null)
    {
      ((Thread.UncaughtExceptionHandler)localObject).uncaughtException(Thread.currentThread(), paramThrowable);
    }
    else if (Log.isLoggable("GAv4", 6))
    {
      localObject = String.valueOf(paramThrowable);
      StringBuilder localStringBuilder = new StringBuilder(((String)localObject).length() + 37);
      localStringBuilder.append("MeasurementExecutor: job failed with ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.toString();
    }
    super.setException(paramThrowable);
  }
}
