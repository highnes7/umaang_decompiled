package com.google.android.android.common.package_9.internal;

import android.os.Handler;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.Result;
import com.google.android.android.common.package_9.ResultTransform;
import java.lang.ref.WeakReference;

public final class zzdh
  implements Runnable
{
  public zzdh(zzdg paramZzdg, Result paramResult) {}
  
  public final void run()
  {
    Object localObject = Log.zzfje;
    GoogleApiClient localGoogleApiClient1;
    try
    {
      ((ThreadLocal)localObject).set(Boolean.valueOf(true));
      localObject = zzfpp.zzfph.onSuccess(zzfpo);
      zzfpp.zzfpm.sendMessage(zzfpp.zzfpm.obtainMessage(0, localObject));
      Log.zzfje.set(Boolean.valueOf(false));
      zzdg.parse(zzfpo);
      localObject = (GoogleApiClient)zzfpp.zzfjh.get();
      if (localObject == null) {
        return;
      }
      ((GoogleApiClient)localObject).removeAccount(zzfpp);
      return;
    }
    catch (Throwable localThrowable) {}catch (RuntimeException localRuntimeException)
    {
      zzfpp.zzfpm.sendMessage(zzfpp.zzfpm.obtainMessage(1, localRuntimeException));
      Log.zzfje.set(Boolean.valueOf(false));
      zzdg.parse(zzfpo);
      localGoogleApiClient1 = (GoogleApiClient)zzfpp.zzfjh.get();
      if (localGoogleApiClient1 == null) {
        return;
      }
    }
    localGoogleApiClient1.removeAccount(zzfpp);
    return;
    Log.zzfje.set(Boolean.valueOf(false));
    zzdg.parse(zzfpo);
    GoogleApiClient localGoogleApiClient2 = (GoogleApiClient)zzfpp.zzfjh.get();
    if (localGoogleApiClient2 != null) {
      localGoogleApiClient2.removeAccount(zzfpp);
    }
    throw localGoogleApiClient1;
  }
}
