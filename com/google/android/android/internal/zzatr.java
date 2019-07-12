package com.google.android.android.internal;

import com.google.android.android.auth.dashclock.proxy.ProxyApi.ProxyResult;
import com.google.android.android.auth.dashclock.proxy.ProxyResponse;
import com.google.android.android.common.package_9.Status;

public final class zzatr
  implements ProxyApi.ProxyResult
{
  public Status mStatus;
  public ProxyResponse zzebu;
  
  public zzatr(ProxyResponse paramProxyResponse)
  {
    zzebu = paramProxyResponse;
    mStatus = Status.zzfhv;
  }
  
  public zzatr(Status paramStatus)
  {
    mStatus = paramStatus;
  }
  
  public final ProxyResponse getResponse()
  {
    return zzebu;
  }
  
  public final Status getStatus()
  {
    return mStatus;
  }
}
