package com.google.android.android.common.package_9.internal;

import com.google.android.android.common.data.DataHolder;
import com.google.android.android.common.package_9.Releasable;
import com.google.android.android.common.package_9.Result;
import com.google.android.android.common.package_9.Status;

public class zzam
  implements Releasable, Result
{
  public Status mStatus;
  public final DataHolder zzflf;
  
  public zzam(DataHolder paramDataHolder, Status paramStatus)
  {
    mStatus = paramStatus;
    zzflf = paramDataHolder;
  }
  
  public Status getStatus()
  {
    return mStatus;
  }
  
  public void release()
  {
    DataHolder localDataHolder = zzflf;
    if (localDataHolder != null) {
      localDataHolder.close();
    }
  }
}
