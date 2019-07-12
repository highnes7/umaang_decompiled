package com.google.android.android.common.package_9;

import com.google.android.android.common.package_9.internal.Log;
import com.google.android.gms.common.api.internal.zzs;
import java.util.ArrayList;
import java.util.List;

public final class Batch
  extends zzs<com.google.android.gms.common.api.BatchResult>
{
  public final Object mLock = new Object();
  public int zzfgk;
  public boolean zzfgl;
  public boolean zzfgm;
  public final com.google.android.gms.common.api.PendingResult<?>[] zzfgn;
  
  public Batch(List paramList, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
    zzfgk = paramList.size();
    zzfgn = new PendingResult[zzfgk];
    if (paramList.isEmpty())
    {
      setResult(new BatchResult(Status.zzfhv, zzfgn));
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      paramGoogleApiClient = (PendingResult)paramList.get(i);
      zzfgn[i] = paramGoogleApiClient;
      paramGoogleApiClient.set(new MainActivity.30(this));
      i += 1;
    }
  }
  
  public final void cancel()
  {
    super.cancel();
    PendingResult[] arrayOfPendingResult = zzfgn;
    int j = arrayOfPendingResult.length;
    int i = 0;
    while (i < j)
    {
      arrayOfPendingResult[i].cancel();
      i += 1;
    }
  }
  
  public final BatchResult createFailedResult(Status paramStatus)
  {
    return new BatchResult(paramStatus, zzfgn);
  }
  
  public final class Builder
  {
    public List<com.google.android.gms.common.api.PendingResult<?>> zzfgp = new ArrayList();
    
    public Builder() {}
    
    public final Batch build()
    {
      return new Batch(zzfgp, Batch.this);
    }
    
    public final BatchResultToken setPlaylist(PendingResult paramPendingResult)
    {
      BatchResultToken localBatchResultToken = new BatchResultToken(zzfgp.size());
      zzfgp.add(paramPendingResult);
      return localBatchResultToken;
    }
  }
}
