package com.google.android.android.tasks;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.zzk;
import com.google.android.gms.tasks.zzn;
import java.util.concurrent.Executor;

public final class Request<TResult, TContinuationResult>
  implements OnFailureListener, OnSuccessListener<TContinuationResult>, zzk<TResult>
{
  public final Executor zzjqr;
  public final com.google.android.gms.tasks.Continuation<TResult, com.google.android.gms.tasks.Task<TContinuationResult>> zzkfu;
  public final zzn<TContinuationResult> zzkfv;
  
  public Request(Executor paramExecutor, Continuation paramContinuation, ProgressMonitor paramProgressMonitor)
  {
    zzjqr = paramExecutor;
    zzkfu = paramContinuation;
    zzkfv = paramProgressMonitor;
  }
  
  public final void cancel()
  {
    throw new UnsupportedOperationException();
  }
  
  public final void onComplete(Task paramTask)
  {
    zzjqr.execute(new Marker.1(this, paramTask));
  }
  
  public final void onFailure(Exception paramException)
  {
    zzkfv.setException(paramException);
  }
  
  public final void onSuccess(Object paramObject)
  {
    zzkfv.setResult(paramObject);
  }
}
