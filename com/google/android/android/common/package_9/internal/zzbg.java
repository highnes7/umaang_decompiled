package com.google.android.android.common.package_9.internal;

import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.android.common.package_9.Status;

public final class zzbg
  implements GoogleApiClient.OnConnectionFailedListener
{
  public zzbg(zzbd paramZzbd, zzda paramZzda) {}
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zzfmx.setResult(new Status(8));
  }
}
