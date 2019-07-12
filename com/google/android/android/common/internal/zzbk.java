package com.google.android.android.common.internal;

import com.google.android.android.common.package_9.PendingResult;
import com.google.android.android.common.package_9.PendingResult.zza;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

public final class zzbk
  implements PendingResult.zza
{
  public zzbk(PendingResult paramPendingResult, TaskCompletionSource paramTaskCompletionSource, zzbn paramZzbn, zzbo paramZzbo) {}
  
  public final void run(Status paramStatus)
  {
    if (paramStatus.isSuccess())
    {
      paramStatus = zzfvs.await(0L, TimeUnit.MILLISECONDS);
      zzfvt.setResult(zzfvu.then(paramStatus));
      return;
    }
    zzfvt.setException(zzfvv.newInstance(paramStatus));
  }
}
