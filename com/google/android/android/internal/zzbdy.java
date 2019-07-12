package com.google.android.android.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class zzbdy
  implements Executor
{
  public final Handler mHandler;
  
  public zzbdy(Looper paramLooper)
  {
    mHandler = new Handler(paramLooper);
  }
  
  public final void execute(Runnable paramRunnable)
  {
    mHandler.post(paramRunnable);
  }
}
