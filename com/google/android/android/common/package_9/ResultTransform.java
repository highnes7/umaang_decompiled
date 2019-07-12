package com.google.android.android.common.package_9;

import com.google.android.android.common.package_9.internal.zzcu;

public abstract class ResultTransform<R extends com.google.android.gms.common.api.Result, S extends com.google.android.gms.common.api.Result>
{
  public ResultTransform() {}
  
  public final PendingResult createFailedResult(Status paramStatus)
  {
    return new zzcu(paramStatus);
  }
  
  public Status onFailure(Status paramStatus)
  {
    return paramStatus;
  }
  
  public abstract PendingResult onSuccess(Result paramResult);
}
