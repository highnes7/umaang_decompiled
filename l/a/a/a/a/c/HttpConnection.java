package l.a.a.a.a.c;

import java.util.LinkedList;
import java.util.concurrent.Executor;

public class HttpConnection
  implements Executor
{
  public Runnable listener;
  public final LinkedList<Runnable> pool = new LinkedList();
  
  public HttpConnection() {}
  
  public void execute()
  {
    try
    {
      Runnable localRunnable = (Runnable)pool.poll();
      listener = localRunnable;
      if (localRunnable != null) {
        ModernAsyncTask.executor.execute(listener);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    try
    {
      pool.offer(new AsyncExecutor.1(this, paramRunnable));
      if (listener == null) {
        execute();
      }
      return;
    }
    catch (Throwable paramRunnable)
    {
      throw paramRunnable;
    }
  }
}
