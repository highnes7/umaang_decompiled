package com.google.android.android.common.package_9.internal;

import android.os.Bundle;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.android.internal.zzcps;
import java.util.concurrent.locks.Lock;

public final class zzba
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  public zzba(zzar paramZzar) {}
  
  public final void onConnected(Bundle paramBundle)
  {
    paramBundle = zzflx;
    zzflp.getDialog(new zzay(paramBundle));
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zzflx.zzfke.lock();
    try
    {
      boolean bool = zzar.f(zzflx, paramConnectionResult);
      if (bool)
      {
        zzar.ignore(zzflx);
        zzar.e(zzflx);
      }
      else
      {
        zzar.removeTask(zzflx, paramConnectionResult);
      }
      zzflx.zzfke.unlock();
      return;
    }
    catch (Throwable paramConnectionResult)
    {
      zzflx.zzfke.unlock();
      throw paramConnectionResult;
    }
  }
  
  public final void onConnectionSuspended(int paramInt) {}
}
