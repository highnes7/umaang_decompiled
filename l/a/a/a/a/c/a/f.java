package l.a.a.a.a.c.a;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

public class f
  extends ScheduledThreadPoolExecutor
{
  public final b a;
  public final h e;
  
  public f(int paramInt, ThreadFactory paramThreadFactory, b paramB, h paramH)
  {
    super(paramInt, paramThreadFactory);
    if (paramB != null)
    {
      if (paramH != null)
      {
        a = paramB;
        e = paramH;
        return;
      }
      throw new NullPointerException("backoff must not be null");
    }
    throw new NullPointerException("retry policy must not be null");
  }
  
  public f(int paramInt, b paramB, h paramH)
  {
    this(paramInt, Executors.defaultThreadFactory(), paramB, paramH);
  }
  
  private Future schedule(Callable paramCallable)
  {
    if (paramCallable != null)
    {
      paramCallable = new e(paramCallable, new g(0, e, a), this);
      execute((Runnable)paramCallable);
      return (Future)paramCallable;
    }
    throw new NullPointerException();
  }
  
  public h a()
  {
    return e;
  }
  
  public b n()
  {
    return a;
  }
  
  public Future schedule(Runnable paramRunnable)
  {
    return schedule(Executors.callable(paramRunnable));
  }
  
  public Future setCallback(Callable paramCallable)
  {
    return schedule(paramCallable);
  }
  
  public Future submit(Runnable paramRunnable, Object paramObject)
  {
    return schedule(Executors.callable(paramRunnable, paramObject));
  }
}
