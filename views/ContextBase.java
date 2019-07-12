package views;

import android.os.Build.VERSION;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ContextBase
{
  public static final int CORE_POOL_SIZE;
  public static final int CPU_COUNT;
  public static final int MAX_POOL_SIZE;
  public static final long birthTime = 1L;
  public static final ContextBase name = new ContextBase();
  public final Executor propertyMap = new WrappingExecutorService(null);
  
  static
  {
    CPU_COUNT = Runtime.getRuntime().availableProcessors();
    int i = CPU_COUNT;
    CORE_POOL_SIZE = i + 1;
    MAX_POOL_SIZE = i * 2 + 1;
  }
  
  public ContextBase() {}
  
  public static void allowCoreThreadTimeout(ThreadPoolExecutor paramThreadPoolExecutor, boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    paramThreadPoolExecutor.allowCoreThreadTimeOut(paramBoolean);
  }
  
  public static ExecutorService getExecutorService()
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    int i = Build.VERSION.SDK_INT;
    localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    return localThreadPoolExecutor;
  }
  
  public static ExecutorService getExecutorService(ThreadFactory paramThreadFactory)
  {
    paramThreadFactory = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(), paramThreadFactory);
    int i = Build.VERSION.SDK_INT;
    paramThreadFactory.allowCoreThreadTimeOut(true);
    return paramThreadFactory;
  }
  
  public static Executor reset()
  {
    return namepropertyMap;
  }
}
