package com.google.android.android.internal;

import android.os.Process;

public final class zzbea
  implements Runnable
{
  public final int mPriority;
  public final Runnable startRunnable;
  
  public zzbea(Runnable paramRunnable, int paramInt)
  {
    startRunnable = paramRunnable;
    mPriority = paramInt;
  }
  
  public final void run()
  {
    Process.setThreadPriority(mPriority);
    startRunnable.run();
  }
}
