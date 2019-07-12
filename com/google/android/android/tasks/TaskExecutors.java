package com.google.android.android.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class TaskExecutors
{
  public static final Executor MAIN_THREAD = new zza();
  public static final Executor zzkgi = new Threading.2();
  
  public TaskExecutors() {}
  
  public final class zza
    implements Executor
  {
    public final Handler mHandler = new Handler(Looper.getMainLooper());
    
    public zza() {}
    
    public final void execute(Runnable paramRunnable)
    {
      mHandler.post(paramRunnable);
    }
  }
}
