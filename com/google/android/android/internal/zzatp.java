package com.google.android.android.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.android.auth.dashclock.proxy.ProxyRequest;
import com.google.android.android.common.package_9.GoogleApiClient;

public final class zzatp
  extends zzatn
{
  public zzatp(zzato paramZzato, GoogleApiClient paramGoogleApiClient, ProxyRequest paramProxyRequest)
  {
    super(paramGoogleApiClient);
  }
  
  public final void updateInfo(Context paramContext, zzatc paramZzatc)
    throws RemoteException
  {
    paramZzatc.printStackTrace(new zzatq(this), zzebs);
  }
}
