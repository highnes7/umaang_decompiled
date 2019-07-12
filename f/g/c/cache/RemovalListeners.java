package f.g.c.cache;

import f.g.c.a.a;
import java.util.concurrent.Executor;

@a
public final class RemovalListeners
{
  public RemovalListeners() {}
  
  public static RemovalListener asynchronous(RemovalListener paramRemovalListener, Executor paramExecutor)
  {
    return new RemovalListeners.1(paramExecutor, paramRemovalListener);
  }
}
