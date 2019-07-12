package f.libs.asm.menu;

import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import l.a.a.a.Log;
import l.a.a.a.f;

public class Context
{
  public final ExecutorService this$0;
  
  public Context(ExecutorService paramExecutorService)
  {
    this$0 = paramExecutorService;
  }
  
  public Object get(Callable paramCallable)
  {
    try
    {
      Object localObject = Looper.getMainLooper();
      Looper localLooper = Looper.myLooper();
      if (localObject == localLooper)
      {
        localObject = this$0;
        paramCallable = ((ExecutorService)localObject).submit(paramCallable);
        localObject = TimeUnit.SECONDS;
        paramCallable = paramCallable.get(4L, (TimeUnit)localObject);
        return paramCallable;
      }
      localObject = this$0;
      paramCallable = ((ExecutorService)localObject).submit(paramCallable).get();
      return paramCallable;
    }
    catch (Exception paramCallable)
    {
      f.get().d("CrashlyticsCore", "Failed to execute task.", paramCallable);
      return null;
      f.get().d("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
      return null;
    }
    catch (RejectedExecutionException paramCallable)
    {
      for (;;) {}
    }
  }
  
  public Future invoke(Runnable paramRunnable)
  {
    ExecutorService localExecutorService = this$0;
    try
    {
      paramRunnable = localExecutorService.submit(new NumberPicker.BeginSoftInputOnLongPressCommand(this, paramRunnable));
      return paramRunnable;
    }
    catch (RejectedExecutionException paramRunnable)
    {
      for (;;) {}
    }
    f.get().d("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
    return null;
  }
  
  public Future invoke(Callable paramCallable)
  {
    ExecutorService localExecutorService = this$0;
    try
    {
      paramCallable = localExecutorService.submit(new SafeAsyncTask.Task.1(this, paramCallable));
      return paramCallable;
    }
    catch (RejectedExecutionException paramCallable)
    {
      for (;;) {}
    }
    f.get().d("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
    return null;
  }
}
