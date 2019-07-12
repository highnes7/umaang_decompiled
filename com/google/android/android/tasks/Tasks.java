package com.google.android.android.tasks;

import com.google.android.android.common.internal.zzbp;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.zzn;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks
{
  public Tasks() {}
  
  public static Object await(Task paramTask)
    throws ExecutionException, InterruptedException
  {
    zzbp.zzgh("Must not be called on the main application thread");
    zzbp.get(paramTask, "Task must not be null");
    if (paramTask.isComplete()) {
      return execute(paramTask);
    }
    zza localZza = new zza();
    createNew(paramTask, localZza);
    localZza.await();
    return execute(paramTask);
  }
  
  public static Object await(Task paramTask, long paramLong, TimeUnit paramTimeUnit)
    throws ExecutionException, InterruptedException, TimeoutException
  {
    zzbp.zzgh("Must not be called on the main application thread");
    zzbp.get(paramTask, "Task must not be null");
    zzbp.get(paramTimeUnit, "TimeUnit must not be null");
    if (paramTask.isComplete()) {
      return execute(paramTask);
    }
    zza localZza = new zza();
    createNew(paramTask, localZza);
    if (localZza.await(paramLong, paramTimeUnit)) {
      return execute(paramTask);
    }
    throw new TimeoutException("Timed out waiting for Task");
  }
  
  public static Task call(Callable paramCallable)
  {
    return call(TaskExecutors.MAIN_THREAD, paramCallable);
  }
  
  public static Task call(Executor paramExecutor, Callable paramCallable)
  {
    zzbp.get(paramExecutor, "Executor must not be null");
    zzbp.get(paramCallable, "Callback must not be null");
    ProgressMonitor localProgressMonitor = new ProgressMonitor();
    paramExecutor.execute(new LayerView.1(localProgressMonitor, paramCallable));
    return localProgressMonitor;
  }
  
  public static void createNew(Task paramTask, zzb paramZzb)
  {
    paramTask.addOnSuccessListener(TaskExecutors.zzkgi, paramZzb);
    paramTask.addOnFailureListener(TaskExecutors.zzkgi, paramZzb);
  }
  
  public static Object execute(Task paramTask)
    throws ExecutionException
  {
    if (paramTask.isSuccessful()) {
      return paramTask.getResult();
    }
    throw new ExecutionException(paramTask.getException());
  }
  
  public static Task forException(Exception paramException)
  {
    ProgressMonitor localProgressMonitor = new ProgressMonitor();
    localProgressMonitor.setException(paramException);
    return localProgressMonitor;
  }
  
  public static Task forResult(Object paramObject)
  {
    ProgressMonitor localProgressMonitor = new ProgressMonitor();
    localProgressMonitor.setResult(paramObject);
    return localProgressMonitor;
  }
  
  public static Task whenAll(Collection paramCollection)
  {
    if (paramCollection.isEmpty()) {
      return forResult(null);
    }
    Object localObject = paramCollection.iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((Task)((Iterator)localObject).next() == null) {
        throw new NullPointerException("null tasks are not accepted");
      }
    }
    localObject = new ProgressMonitor();
    zzc localZzc = new zzc(paramCollection.size(), (ProgressMonitor)localObject);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      createNew((Task)paramCollection.next(), localZzc);
    }
    return localObject;
  }
  
  public static Task whenAll(Task... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return forResult(null);
    }
    return whenAll(Arrays.asList(paramVarArgs));
  }
  
  public final class zza
    implements Tasks.zzb
  {
    public final CountDownLatch zzaof = new CountDownLatch(1);
    
    public zza() {}
    
    public final void await()
      throws InterruptedException
    {
      zzaof.await();
    }
    
    public final boolean await(long paramLong, TimeUnit paramTimeUnit)
      throws InterruptedException
    {
      return zzaof.await(paramLong, paramTimeUnit);
    }
    
    public final void onFailure(Exception paramException)
    {
      zzaof.countDown();
    }
    
    public final void onSuccess(Object paramObject)
    {
      zzaof.countDown();
    }
  }
  
  public abstract interface zzb
    extends OnFailureListener, OnSuccessListener<Object>
  {}
  
  public final class zzc
    implements Tasks.zzb
  {
    public final Object mLock = new Object();
    public final zzn<Void> zzkgh;
    public Exception zzkgm;
    public final int zzkgo;
    public int zzkgp;
    public int zzkgq;
    
    public zzc(ProgressMonitor paramProgressMonitor)
    {
      zzkgo = this$1;
      zzkgh = paramProgressMonitor;
    }
    
    private final void zzbih()
    {
      int i = zzkgp;
      int j = zzkgq;
      int k = zzkgo;
      if (i + j == k)
      {
        if (zzkgm == null)
        {
          zzkgh.setResult(null);
          return;
        }
        ProgressMonitor localProgressMonitor = zzkgh;
        StringBuilder localStringBuilder = new StringBuilder(54);
        localStringBuilder.append(j);
        localStringBuilder.append(" out of ");
        localStringBuilder.append(k);
        localStringBuilder.append(" underlying tasks failed");
        localProgressMonitor.setException(new ExecutionException(localStringBuilder.toString(), zzkgm));
      }
    }
    
    public final void onFailure(Exception paramException)
    {
      Object localObject = mLock;
      try
      {
        zzkgq += 1;
        zzkgm = paramException;
        zzbih();
        return;
      }
      catch (Throwable paramException)
      {
        throw paramException;
      }
    }
    
    public final void onSuccess(Object paramObject)
    {
      paramObject = mLock;
      try
      {
        zzkgp += 1;
        zzbih();
        return;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
  }
}
