package com.google.android.android.common.package_9;

import com.google.android.gms.common.api.ResultCallback;

public abstract class ResultCallbacks<R extends com.google.android.gms.common.api.Result>
  implements ResultCallback<R>
{
  public ResultCallbacks() {}
  
  public abstract void onFailure(Status paramStatus);
  
  public final void onResult(Result paramResult)
  {
    Object localObject = paramResult.getStatus();
    if (((Status)localObject).isSuccess())
    {
      onSuccess(paramResult);
      return;
    }
    onFailure((Status)localObject);
    if ((paramResult instanceof Releasable))
    {
      try
      {
        ((Releasable)paramResult).release();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;) {}
      }
      paramResult = String.valueOf(paramResult);
      localObject = new StringBuilder(paramResult.length() + 18);
      ((StringBuilder)localObject).append("Unable to release ");
      ((StringBuilder)localObject).append(paramResult);
      ((StringBuilder)localObject).toString();
      return;
    }
  }
  
  public abstract void onSuccess(Result paramResult);
}
