package com.google.android.android.internal;

import com.google.android.android.auth.dashclock.proxy.ProxyApi;
import com.google.android.android.auth.dashclock.proxy.ProxyRequest;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.PendingResult;

public final class zzato
  implements ProxyApi
{
  public zzato() {}
  
  public final PendingResult performProxyRequest(GoogleApiClient paramGoogleApiClient, ProxyRequest paramProxyRequest)
  {
    zzbp.append(paramGoogleApiClient);
    zzbp.append(paramProxyRequest);
    return paramGoogleApiClient.d(new zzatp(this, paramGoogleApiClient, paramProxyRequest));
  }
}
