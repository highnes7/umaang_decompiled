package com.google.android.android.common.package_9.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.android.common.internal.zzbp;

public final class zzcj<L>
{
  public volatile L mListener;
  public final com.google.android.gms.common.api.internal.zzck zzfou;
  public final com.google.android.gms.common.api.internal.zzcl<L> zzfov;
  
  public zzcj(Looper paramLooper, Object paramObject, String paramString)
  {
    zzfou = new zzck(this, paramLooper);
    zzbp.get(paramObject, "Listener must not be null");
    mListener = paramObject;
    zzbp.zzgg(paramString);
    zzfov = new zzcl(paramObject, paramString);
  }
  
  public final void clear()
  {
    mListener = null;
  }
  
  public final void doToast(zzcm paramZzcm)
  {
    zzbp.get(paramZzcm, "Notifier must not be null");
    paramZzcm = zzfou.obtainMessage(1, paramZzcm);
    zzfou.sendMessage(paramZzcm);
  }
  
  public final void setZoomLevel(zzcm paramZzcm)
  {
    Object localObject = mListener;
    if (localObject == null)
    {
      paramZzcm.zzagx();
      return;
    }
    try
    {
      paramZzcm.forceFinished(localObject);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramZzcm.zzagx();
      throw localRuntimeException;
    }
  }
  
  public final zzcl zzaik()
  {
    return zzfov;
  }
}
