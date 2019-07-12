package com.google.android.android.internal;

import android.os.Looper;
import com.google.android.android.analytics.TerminalManager;

public final class zzany
  implements Runnable
{
  public zzany(zzanx paramZzanx) {}
  
  public final void run()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      zzdqu.zzdod.zzwa().d(this);
      return;
    }
    boolean bool = zzdqu.zzdp();
    zzanx localZzanx = zzdqu;
    zzdqt = 0L;
    if (bool) {
      localZzanx.retrieveToken();
    }
  }
}
