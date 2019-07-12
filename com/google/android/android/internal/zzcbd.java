package com.google.android.android.internal;

import android.os.Looper;

public final class zzcbd
  implements Runnable
{
  public zzcbd(zzcbc paramZzcbc) {}
  
  public final void run()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      zzinf.zziki.zzauk().e(this);
      return;
    }
    boolean bool = zzinf.zzdp();
    zzcbc localZzcbc = zzinf;
    zzdqt = 0L;
    if ((bool) && (zzine)) {
      localZzcbc.startSession();
    }
  }
}
