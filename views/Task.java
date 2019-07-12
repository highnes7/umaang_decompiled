package views;

import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task<TResult>
{
  public static final ExecutorService BACKGROUND_EXECUTOR;
  public static final Executor IMMEDIATE_EXECUTOR;
  public static final Executor UI_THREAD_EXECUTOR = namepropertyMap;
  public boolean complete;
  public List<o<TResult, Void>> continuations = new ArrayList();
  public Exception error;
  public final Object lock = new Object();
  public TResult result;
  public boolean state;
  
  static
  {
    AsyncHttpClient localAsyncHttpClient = AsyncHttpClient.log;
    BACKGROUND_EXECUTOR = threadPool;
    IMMEDIATE_EXECUTOR = requestMap;
  }
  
  public Task() {}
  
  public static Task call(long paramLong, ScheduledExecutorService paramScheduledExecutorService)
  {
    if (paramLong <= 0L) {
      return call(null);
    }
    TaskCompletionSource localTaskCompletionSource = create();
    paramScheduledExecutorService.schedule(new JsonHttpResponseHandler.1(localTaskCompletionSource), paramLong, TimeUnit.MILLISECONDS);
    return localTaskCompletionSource.getTask();
  }
  
  public static Task call(Object paramObject)
  {
    TaskCompletionSource localTaskCompletionSource = create();
    localTaskCompletionSource.setResult(paramObject);
    return localTaskCompletionSource.getTask();
  }
  
  public static Task call(Collection paramCollection)
  {
    if (paramCollection.size() == 0) {
      return call(null);
    }
    TaskCompletionSource localTaskCompletionSource = create();
    java.util.concurrent.atomic.AtomicBoolean localAtomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(false);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      ((Task)paramCollection.next()).create(new ListBranchCommand.1(localAtomicBoolean, localTaskCompletionSource));
    }
    return localTaskCompletionSource.getTask();
  }
  
  public static Task call(Callable paramCallable)
  {
    return call(paramCallable, BACKGROUND_EXECUTOR, null);
  }
  
  public static Task call(Callable paramCallable, Executor paramExecutor)
  {
    return call(paramCallable, paramExecutor, null);
  }
  
  public static Task call(Callable paramCallable, Executor paramExecutor, Label paramLabel)
  {
    TaskCompletionSource localTaskCompletionSource = create();
    paramExecutor.execute(new Task.2(paramLabel, localTaskCompletionSource, paramCallable));
    return localTaskCompletionSource.getTask();
  }
  
  public static Task call(Callable paramCallable, Label paramLabel)
  {
    return call(paramCallable, IMMEDIATE_EXECUTOR, paramLabel);
  }
  
  public static void call(TaskCompletionSource paramTaskCompletionSource, Continuation paramContinuation, Task paramTask, Executor paramExecutor, Label paramLabel)
  {
    paramExecutor.execute(new LayerView.1(paramLabel, paramTaskCompletionSource, paramContinuation, paramTask));
  }
  
  public static Task cancelled()
  {
    TaskCompletionSource localTaskCompletionSource = create();
    localTaskCompletionSource.setCancelled();
    return localTaskCompletionSource.getTask();
  }
  
  public static void completeImmediately(TaskCompletionSource paramTaskCompletionSource, Continuation paramContinuation, Task paramTask, Executor paramExecutor, Label paramLabel)
  {
    paramExecutor.execute(new Task.9(paramLabel, paramTaskCompletionSource, paramContinuation, paramTask));
  }
  
  public static TaskCompletionSource create()
  {
    return new TaskCompletionSource(new Task(), null);
  }
  
  public static Task create(Collection paramCollection)
  {
    if (paramCollection.size() == 0) {
      return call(null);
    }
    TaskCompletionSource localTaskCompletionSource = create();
    ArrayList localArrayList = new ArrayList();
    Object localObject = new Object();
    java.util.concurrent.atomic.AtomicInteger localAtomicInteger = new java.util.concurrent.atomic.AtomicInteger(paramCollection.size());
    java.util.concurrent.atomic.AtomicBoolean localAtomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(false);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      ((Task)paramCollection.next()).create(new Notification.1(localObject, localArrayList, localAtomicBoolean, localAtomicInteger, localTaskCompletionSource));
    }
    return localTaskCompletionSource.getTask();
  }
  
  public static Task doInBackground(Collection paramCollection)
  {
    if (paramCollection.size() == 0) {
      return call(null);
    }
    TaskCompletionSource localTaskCompletionSource = create();
    java.util.concurrent.atomic.AtomicBoolean localAtomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(false);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      ((Task)paramCollection.next()).create(new AtomicBoolean(localAtomicBoolean, localTaskCompletionSource));
    }
    return localTaskCompletionSource.getTask();
  }
  
  public static Task forError(Exception paramException)
  {
    TaskCompletionSource localTaskCompletionSource = create();
    localTaskCompletionSource.setError(paramException);
    return localTaskCompletionSource.getTask();
  }
  
  public static Task get(Callable paramCallable, Label paramLabel)
  {
    return call(paramCallable, BACKGROUND_EXECUTOR, paramLabel);
  }
  
  public static Task onSuccess(Collection paramCollection)
  {
    return create(paramCollection).onSuccess(new Logger(paramCollection));
  }
  
  public static Task onSuccess(Callable paramCallable)
  {
    return call(paramCallable, IMMEDIATE_EXECUTOR, null);
  }
  
  private void runContinuations()
  {
    Object localObject = lock;
    try
    {
      Iterator localIterator = continuations.iterator();
      while (localIterator.hasNext())
      {
        Continuation localContinuation = (Continuation)localIterator.next();
        try
        {
          localContinuation.then(this);
        }
        catch (Exception localException)
        {
          throw new RuntimeException(localException);
        }
        catch (RuntimeException localRuntimeException)
        {
          throw localRuntimeException;
        }
      }
      continuations = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static Task save(long paramLong)
  {
    return call(paramLong, logvalue);
  }
  
  public Task call(Continuation paramContinuation)
  {
    return call(paramContinuation, IMMEDIATE_EXECUTOR, null);
  }
  
  public Task call(Continuation paramContinuation, Executor paramExecutor, Label paramLabel)
  {
    TaskCompletionSource localTaskCompletionSource = create();
    Object localObject = lock;
    try
    {
      boolean bool = isCompleted();
      if (!bool) {
        continuations.add(new Task.6(this, localTaskCompletionSource, paramContinuation, paramExecutor, paramLabel));
      }
      if (bool) {
        call(localTaskCompletionSource, paramContinuation, this, paramExecutor, paramLabel);
      }
      return localTaskCompletionSource.getTask();
    }
    catch (Throwable paramContinuation)
    {
      throw paramContinuation;
    }
  }
  
  public Task call(Continuation paramContinuation, Label paramLabel)
  {
    return call(paramContinuation, IMMEDIATE_EXECUTOR, paramLabel);
  }
  
  public Task cast()
  {
    return this;
  }
  
  public Task continueWith(Callable paramCallable, Continuation paramContinuation)
  {
    return continueWith(paramCallable, paramContinuation, IMMEDIATE_EXECUTOR, null);
  }
  
  public Task continueWith(Callable paramCallable, Continuation paramContinuation, Executor paramExecutor)
  {
    return continueWith(paramCallable, paramContinuation, paramExecutor, null);
  }
  
  public Task continueWith(Callable paramCallable, Continuation paramContinuation, Executor paramExecutor, Label paramLabel)
  {
    Capture localCapture = new Capture();
    localCapture.set(new MoreExecutors.2(this, paramLabel, paramCallable, paramContinuation, paramExecutor, localCapture));
    return getTask().getTask((Continuation)localCapture.get(), paramExecutor);
  }
  
  public Task continueWith(Callable paramCallable, Continuation paramContinuation, Label paramLabel)
  {
    return continueWith(paramCallable, paramContinuation, IMMEDIATE_EXECUTOR, paramLabel);
  }
  
  public Task continueWith(Continuation paramContinuation)
  {
    return continueWith(paramContinuation, IMMEDIATE_EXECUTOR);
  }
  
  public Task continueWith(Continuation paramContinuation, Executor paramExecutor)
  {
    return getTask(paramContinuation, paramExecutor, null);
  }
  
  public Task continueWith(Continuation paramContinuation, Executor paramExecutor, Label paramLabel)
  {
    TaskCompletionSource localTaskCompletionSource = create();
    Object localObject = lock;
    try
    {
      boolean bool = isCompleted();
      if (!bool) {
        continuations.add(new Task.5(this, localTaskCompletionSource, paramContinuation, paramExecutor, paramLabel));
      }
      if (bool) {
        completeImmediately(localTaskCompletionSource, paramContinuation, this, paramExecutor, paramLabel);
      }
      return localTaskCompletionSource.getTask();
    }
    catch (Throwable paramContinuation)
    {
      throw paramContinuation;
    }
  }
  
  public Task continueWith(Continuation paramContinuation, Label paramLabel)
  {
    return continueWith(paramContinuation, IMMEDIATE_EXECUTOR, paramLabel);
  }
  
  public Task create(Continuation paramContinuation)
  {
    return continueWith(paramContinuation, IMMEDIATE_EXECUTOR, null);
  }
  
  public boolean get()
  {
    Object localObject = lock;
    try
    {
      boolean bool = state;
      return bool;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public Exception getError()
  {
    Object localObject = lock;
    try
    {
      Exception localException = error;
      return localException;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public Object getResult()
  {
    Object localObject1 = lock;
    try
    {
      Object localObject2 = result;
      return localObject2;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public Task getTask()
  {
    return call(new x(this));
  }
  
  public Task getTask(Continuation paramContinuation, Executor paramExecutor)
  {
    return call(paramContinuation, paramExecutor, null);
  }
  
  public Task getTask(Continuation paramContinuation, Executor paramExecutor, Label paramLabel)
  {
    return getTask(new AtomicInteger(this, paramLabel, paramContinuation), paramExecutor);
  }
  
  public Task getTask(Continuation paramContinuation, Label paramLabel)
  {
    return getTask(paramContinuation, IMMEDIATE_EXECUTOR, paramLabel);
  }
  
  public boolean isCompleted()
  {
    Object localObject = lock;
    try
    {
      boolean bool = complete;
      return bool;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public boolean isFaulted()
  {
    Object localObject = lock;
    for (;;)
    {
      try
      {
        if (error != null)
        {
          bool = true;
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      boolean bool = false;
    }
  }
  
  public Task onSuccess(Continuation paramContinuation)
  {
    return onSuccess(paramContinuation, IMMEDIATE_EXECUTOR, null);
  }
  
  public Task onSuccess(Continuation paramContinuation, Executor paramExecutor)
  {
    return onSuccess(paramContinuation, paramExecutor, null);
  }
  
  public Task onSuccess(Continuation paramContinuation, Executor paramExecutor, Label paramLabel)
  {
    return getTask(new Task.7(this, paramLabel, paramContinuation), paramExecutor);
  }
  
  public Task onSuccess(Continuation paramContinuation, Label paramLabel)
  {
    return onSuccess(paramContinuation, IMMEDIATE_EXECUTOR, paramLabel);
  }
  
  public Task then(Continuation paramContinuation, Executor paramExecutor)
  {
    return continueWith(paramContinuation, paramExecutor, null);
  }
  
  public void waitForCompletion()
    throws InterruptedException
  {
    Object localObject = lock;
    try
    {
      if (!isCompleted()) {
        lock.wait();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public class TaskCompletionSource
  {
    public TaskCompletionSource() {}
    
    public Task getTask()
    {
      return Task.this;
    }
    
    public void setCancelled()
    {
      if (trySetCancelled()) {
        return;
      }
      throw new IllegalStateException("Cannot cancel a completed task.");
    }
    
    public void setError(Exception paramException)
    {
      if (trySetError(paramException)) {
        return;
      }
      throw new IllegalStateException("Cannot set the error on a completed task.");
    }
    
    public void setResult(Object paramObject)
    {
      if (trySetResult(paramObject)) {
        return;
      }
      throw new IllegalStateException("Cannot set the result of a completed task.");
    }
    
    public boolean trySetCancelled()
    {
      Object localObject = Task.access$getLock(Task.this);
      try
      {
        if (Task.access$getComplete(Task.this)) {
          return false;
        }
        Task.access$setComplete(Task.this, true);
        Task.access$setCancelled(Task.this, true);
        Task.access$getLock(Task.this).notifyAll();
        Task.access$getRunContinuations(Task.this);
        return true;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    
    public boolean trySetError(Exception paramException)
    {
      Object localObject = Task.access$getLock(Task.this);
      try
      {
        if (Task.access$getComplete(Task.this)) {
          return false;
        }
        Task.access$setComplete(Task.this, true);
        Task.access$setError(Task.this, paramException);
        Task.access$getLock(Task.this).notifyAll();
        Task.access$getRunContinuations(Task.this);
        return true;
      }
      catch (Throwable paramException)
      {
        throw paramException;
      }
    }
    
    public boolean trySetResult(Object paramObject)
    {
      Object localObject = Task.access$getLock(Task.this);
      try
      {
        if (Task.access$getComplete(Task.this)) {
          return false;
        }
        Task.access$setComplete(Task.this, true);
        Task.access$setResult(Task.this, paramObject);
        Task.access$getLock(Task.this).notifyAll();
        Task.access$getRunContinuations(Task.this);
        return true;
      }
      catch (Throwable paramObject)
      {
        throw paramObject;
      }
    }
  }
}
