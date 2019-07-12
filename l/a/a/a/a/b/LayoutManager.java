package l.a.a.a.a.b;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import l.a.a.a.a.c.a.b;
import l.a.a.a.a.c.a.f;
import l.a.a.a.a.c.a.h;

public final class LayoutManager
{
  public static final long b = 2L;
  
  public LayoutManager() {}
  
  public static f a(String paramString, int paramInt, b paramB, h paramH)
  {
    paramB = new f(paramInt, build(paramString), paramB, paramH);
    init(paramString, paramB);
    return paramB;
  }
  
  public static final ThreadFactory build(String paramString)
  {
    return new ModernAsyncTask.1(paramString, new AtomicLong(1L));
  }
  
  public static ScheduledExecutorService get(String paramString)
  {
    ScheduledExecutorService localScheduledExecutorService = Executors.newSingleThreadScheduledExecutor(build(paramString));
    init(paramString, localScheduledExecutorService);
    return localScheduledExecutorService;
  }
  
  public static ExecutorService init(String paramString)
  {
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor(build(paramString));
    init(paramString, localExecutorService);
    return localExecutorService;
  }
  
  public static final void init(String paramString, ExecutorService paramExecutorService)
  {
    start(paramString, paramExecutorService, 2L, TimeUnit.SECONDS);
  }
  
  public static final void start(String paramString, ExecutorService paramExecutorService, long paramLong, TimeUnit paramTimeUnit)
  {
    Runtime.getRuntime().addShutdownHook(new Thread(new MoreExecutors.Application.1(paramString, paramExecutorService, paramLong, paramTimeUnit), StringBuilder.toString("Crashlytics Shutdown Hook for ", paramString)));
  }
}
