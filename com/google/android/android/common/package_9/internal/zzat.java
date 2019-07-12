package com.google.android.android.common.package_9.internal;

import android.os.Looper;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.internal.Track;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.Sample;
import com.google.android.gms.common.api.Api;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

public final class zzat
  implements Track
{
  public final Api<?> zzfdg;
  public final boolean zzfjs;
  public final WeakReference<com.google.android.gms.common.api.internal.zzar> zzfly;
  
  public zzat(zzar paramZzar, Sample paramSample, boolean paramBoolean)
  {
    zzfly = new WeakReference(paramZzar);
    zzfdg = paramSample;
    zzfjs = paramBoolean;
  }
  
  public final void notifyProgress(ConnectionResult paramConnectionResult)
  {
    zzar localZzar = (zzar)zzfly.get();
    if (localZzar == null) {
      return;
    }
    boolean bool;
    if (Looper.myLooper() == zzflh.zzfju.getLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.append(bool, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
    zzfke.lock();
    try
    {
      bool = zzar.enqueue(localZzar, 0);
      if (!bool)
      {
        zzfke.unlock();
        return;
      }
      bool = paramConnectionResult.isSuccess();
      if (!bool) {
        zzar.spawn(localZzar, paramConnectionResult, zzfdg, zzfjs);
      }
      bool = zzar.enqueue(localZzar);
      if (bool) {
        zzar.e(localZzar);
      }
      zzfke.unlock();
      return;
    }
    catch (Throwable paramConnectionResult)
    {
      zzfke.unlock();
      throw paramConnectionResult;
    }
  }
}
