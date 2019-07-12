package views;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class AsyncHttpClient
{
  public static final AsyncHttpClient log = new AsyncHttpClient();
  public final Executor requestMap;
  public final ExecutorService threadPool;
  public final ScheduledExecutorService value;
  
  public AsyncHttpClient()
  {
    ExecutorService localExecutorService;
    if (!isAndroidRuntime()) {
      localExecutorService = Executors.newCachedThreadPool();
    } else {
      localExecutorService = ContextBase.getExecutorService();
    }
    threadPool = localExecutorService;
    value = Executors.newSingleThreadScheduledExecutor();
    requestMap = new BoltsExecutors.ImmediateExecutor();
  }
  
  public static Executor access$getRequestMap()
  {
    return logrequestMap;
  }
  
  public static ScheduledExecutorService get()
  {
    return logvalue;
  }
  
  public static ExecutorService getThreadPool()
  {
    return logthreadPool;
  }
  
  public static boolean isAndroidRuntime()
  {
    String str = System.getProperty("java.runtime.name");
    if (str == null) {
      return false;
    }
    return str.toLowerCase(Locale.US).contains("android");
  }
}
