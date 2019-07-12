package com.google.android.android.tasks;

import com.google.android.gms.tasks.zzn;

public class TaskCompletionSource<TResult>
{
  public final zzn<TResult> zzkgh = new ProgressMonitor();
  
  public TaskCompletionSource() {}
  
  public Task getTask()
  {
    return zzkgh;
  }
  
  public void setException(Exception paramException)
  {
    zzkgh.setException(paramException);
  }
  
  public void setResult(Object paramObject)
  {
    zzkgh.setResult(paramObject);
  }
  
  public boolean trySetException(Exception paramException)
  {
    return zzkgh.trySetException(paramException);
  }
  
  public boolean trySetResult(Object paramObject)
  {
    return zzkgh.trySetResult(paramObject);
  }
}
