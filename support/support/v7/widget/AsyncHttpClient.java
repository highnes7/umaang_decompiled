package support.support.v7.widget;

import b.b.a.N;

@N({b.b.a.N.a.b})
public abstract class AsyncHttpClient
{
  public AsyncHttpClient() {}
  
  public void cancel(Runnable paramRunnable)
  {
    if (execute())
    {
      paramRunnable.run();
      return;
    }
    post(paramRunnable);
  }
  
  public abstract void execute(Runnable paramRunnable);
  
  public abstract boolean execute();
  
  public abstract void post(Runnable paramRunnable);
}
