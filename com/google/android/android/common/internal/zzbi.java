package com.google.android.android.common.internal;

import com.google.android.android.common.package_9.PendingResult;
import com.google.android.android.common.package_9.Response;
import com.google.android.android.tasks.Task;
import com.google.android.android.tasks.TaskCompletionSource;

public final class zzbi
{
  public static final zzbo zzfvr = new zzbj();
  
  public static Task f(PendingResult paramPendingResult)
  {
    return f(paramPendingResult, new zzbm());
  }
  
  public static Task f(PendingResult paramPendingResult, zzbn paramZzbn)
  {
    zzbo localZzbo = zzfvr;
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramPendingResult.set(new zzbk(paramPendingResult, localTaskCompletionSource, paramZzbn, localZzbo));
    return localTaskCompletionSource.getTask();
  }
  
  public static Task f(PendingResult paramPendingResult, Response paramResponse)
  {
    return f(paramPendingResult, new zzbl(paramResponse));
  }
}
