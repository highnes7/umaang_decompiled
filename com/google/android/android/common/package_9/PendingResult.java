package com.google.android.android.common.package_9;

import java.util.concurrent.TimeUnit;

public abstract class PendingResult<R extends com.google.android.gms.common.api.Result>
{
  public PendingResult() {}
  
  public abstract Result await();
  
  public abstract Result await(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract void cancel();
  
  public abstract boolean isCanceled();
  
  public void set(zza paramZza)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void setResultCallback(ResultCallback paramResultCallback);
  
  public abstract void setResultCallback(ResultCallback paramResultCallback, long paramLong, TimeUnit paramTimeUnit);
  
  public TransformedResult then(ResultTransform paramResultTransform)
  {
    throw new UnsupportedOperationException();
  }
  
  public Integer zzafs()
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract interface zza
  {
    public abstract void run(Status paramStatus);
  }
}
