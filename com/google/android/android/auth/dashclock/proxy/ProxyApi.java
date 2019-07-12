package com.google.android.android.auth.dashclock.proxy;

import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.PendingResult;
import com.google.android.android.common.package_9.Result;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract interface ProxyApi
{
  public abstract PendingResult performProxyRequest(GoogleApiClient paramGoogleApiClient, ProxyRequest paramProxyRequest);
  
  @KeepForSdk
  public abstract interface ProxyResult
    extends Result
  {
    public abstract ProxyResponse getResponse();
  }
}
