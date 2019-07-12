package com.google.android.android.common.package_9.internal;

import com.google.android.android.common.package_9.ApiException;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.tasks.Task;
import com.google.android.android.tasks.TaskCompletionSource;

public final class zzde
{
  public static void status(Status paramStatus, Object paramObject, TaskCompletionSource paramTaskCompletionSource)
  {
    if (paramStatus.isSuccess())
    {
      paramTaskCompletionSource.setResult(paramObject);
      return;
    }
    paramTaskCompletionSource.setException(new ApiException(paramStatus));
  }
  
  public static Task then(Task paramTask)
  {
    return paramTask.continueWith(new zzdf());
  }
}
