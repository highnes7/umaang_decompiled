package com.google.android.android.common.package_9;

import com.google.android.android.common.internal.zzbp;
import java.util.concurrent.TimeUnit;

public final class BatchResult
  implements Result
{
  public final Status mStatus;
  public final com.google.android.gms.common.api.PendingResult<?>[] zzfgn;
  
  public BatchResult(Status paramStatus, PendingResult[] paramArrayOfPendingResult)
  {
    mStatus = paramStatus;
    zzfgn = paramArrayOfPendingResult;
  }
  
  public final Status getStatus()
  {
    return mStatus;
  }
  
  public final Result take(BatchResultToken paramBatchResultToken)
  {
    boolean bool;
    if (_capacity < zzfgn.length) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.get(bool, "The result token does not belong to this batch");
    return zzfgn[_capacity].await(0L, TimeUnit.MILLISECONDS);
  }
}
