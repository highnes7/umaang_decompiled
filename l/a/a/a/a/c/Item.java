package l.a.a.a.a.c;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Item
  extends ThreadPoolExecutor
{
  public static final int COLUMN = Runtime.getRuntime().availableProcessors();
  public static final int a;
  public static final int c;
  public static final long d = 1L;
  
  static
  {
    int i = COLUMN;
    a = i + 1;
    c = i * 2 + 1;
  }
  
  public Item(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, i paramI, ThreadFactory paramThreadFactory)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, (BlockingQueue)paramI, paramThreadFactory);
    prestartAllCoreThreads();
  }
  
  public static Item get(int paramInt1, int paramInt2)
  {
    return new Item(paramInt1, paramInt2, 1L, TimeUnit.SECONDS, new i(), (ThreadFactory)new s.a(10));
  }
  
  public static Item load(int paramInt)
  {
    return get(paramInt, paramInt);
  }
  
  public static Item newNameType()
  {
    return get(a, c);
  }
  
  public void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    l localL = (l)paramRunnable;
    localL.a(true);
    localL.a(paramThrowable);
    getQueue().a();
    super.afterExecute(paramRunnable, paramThrowable);
  }
  
  public void execute(Runnable paramRunnable)
  {
    if (ClassWriter.get(paramRunnable))
    {
      super.execute(paramRunnable);
      return;
    }
    super.execute(newTaskFor(paramRunnable, null));
  }
  
  public i getQueue()
  {
    return (i)super.getQueue();
  }
  
  public RunnableFuture newTaskFor(Runnable paramRunnable, Object paramObject)
  {
    return (RunnableFuture)new o(paramRunnable, paramObject);
  }
  
  public RunnableFuture newTaskFor(Callable paramCallable)
  {
    return (RunnableFuture)new o(paramCallable);
  }
}
