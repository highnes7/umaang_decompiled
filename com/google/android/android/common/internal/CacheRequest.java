package com.google.android.android.common.internal;

import com.google.android.android.common.ConnectionResult;

public final class CacheRequest
  implements Track
{
  public CacheRequest(TaskManager paramTaskManager) {}
  
  public final void notifyProgress(ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.isSuccess())
    {
      paramConnectionResult = zzftl;
      paramConnectionResult.rename(null, paramConnectionResult.zzajl());
      return;
    }
    if (TaskManager.method_5(zzftl) != null) {
      TaskManager.method_5(zzftl).onConnectionFailed(paramConnectionResult);
    }
  }
}
