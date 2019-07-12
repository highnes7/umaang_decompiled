package com.google.android.android.common.package_9.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.android.common.internal.zzbp;

public final class zzck
  extends Handler
{
  public zzck(zzcj paramZzcj, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = what;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    zzbp.zzbh(bool);
    zzfow.setZoomLevel((zzcm)obj);
  }
}
