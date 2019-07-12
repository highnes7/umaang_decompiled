package com.google.android.android.tasks;

import android.app.Activity;
import com.google.android.android.common.internal.zzbp;
import com.google.android.gms.tasks.zzl;
import java.util.concurrent.Executor;

public final class ProgressMonitor<TResult>
  extends com.google.android.gms.tasks.Task<TResult>
{
  public final Object mLock = new Object();
  public final zzl<TResult> zzkgj = new SyncOperation();
  public boolean zzkgk;
  public TResult zzkgl;
  public Exception zzkgm;
  
  public ProgressMonitor() {}
  
  private final void zzbie()
  {
    zzbp.append(zzkgk, "Task is not yet complete");
  }
  
  private final void zzbif()
  {
    zzbp.append(zzkgk ^ true, "Task is already complete");
  }
  
  private final void zzbig()
  {
    Object localObject = mLock;
    try
    {
      if (!zzkgk) {
        return;
      }
      zzkgj.execute(this);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final Task addOnCompleteListener(Activity paramActivity, OnCompleteListener paramOnCompleteListener)
  {
    paramOnCompleteListener = new LoginActivity.1(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
    zzkgj.addKey(paramOnCompleteListener);
    zzn.zza.openDocument(paramActivity).notifyListeners(paramOnCompleteListener);
    zzbig();
    return this;
  }
  
  public final Task addOnCompleteListener(OnCompleteListener paramOnCompleteListener)
  {
    return addOnCompleteListener(TaskExecutors.MAIN_THREAD, paramOnCompleteListener);
  }
  
  public final Task addOnCompleteListener(Executor paramExecutor, OnCompleteListener paramOnCompleteListener)
  {
    zzkgj.addKey(new LoginActivity.1(paramExecutor, paramOnCompleteListener));
    zzbig();
    return this;
  }
  
  public final Task addOnFailureListener(Activity paramActivity, OnFailureListener paramOnFailureListener)
  {
    paramOnFailureListener = new Event(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
    zzkgj.addKey(paramOnFailureListener);
    zzn.zza.openDocument(paramActivity).notifyListeners(paramOnFailureListener);
    zzbig();
    return this;
  }
  
  public final Task addOnFailureListener(OnFailureListener paramOnFailureListener)
  {
    return addOnFailureListener(TaskExecutors.MAIN_THREAD, paramOnFailureListener);
  }
  
  public final Task addOnFailureListener(Executor paramExecutor, OnFailureListener paramOnFailureListener)
  {
    zzkgj.addKey(new Event(paramExecutor, paramOnFailureListener));
    zzbig();
    return this;
  }
  
  public final Task addOnSuccessListener(Activity paramActivity, OnSuccessListener paramOnSuccessListener)
  {
    paramOnSuccessListener = new SyncCampaign(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
    zzkgj.addKey(paramOnSuccessListener);
    zzn.zza.openDocument(paramActivity).notifyListeners(paramOnSuccessListener);
    zzbig();
    return this;
  }
  
  public final Task addOnSuccessListener(OnSuccessListener paramOnSuccessListener)
  {
    return addOnSuccessListener(TaskExecutors.MAIN_THREAD, paramOnSuccessListener);
  }
  
  public final Task addOnSuccessListener(Executor paramExecutor, OnSuccessListener paramOnSuccessListener)
  {
    zzkgj.addKey(new SyncCampaign(paramExecutor, paramOnSuccessListener));
    zzbig();
    return this;
  }
  
  public final Task continueWith(Continuation paramContinuation)
  {
    return continueWith(TaskExecutors.MAIN_THREAD, paramContinuation);
  }
  
  public final Task continueWith(Executor paramExecutor, Continuation paramContinuation)
  {
    ProgressMonitor localProgressMonitor = new ProgressMonitor();
    zzkgj.addKey(new LoginActivity.2(paramExecutor, paramContinuation, localProgressMonitor));
    zzbig();
    return localProgressMonitor;
  }
  
  public final Task continueWithTask(Continuation paramContinuation)
  {
    return continueWithTask(TaskExecutors.MAIN_THREAD, paramContinuation);
  }
  
  public final Task continueWithTask(Executor paramExecutor, Continuation paramContinuation)
  {
    ProgressMonitor localProgressMonitor = new ProgressMonitor();
    zzkgj.addKey(new Request(paramExecutor, paramContinuation, localProgressMonitor));
    zzbig();
    return localProgressMonitor;
  }
  
  public final Exception getException()
  {
    Object localObject = mLock;
    try
    {
      Exception localException = zzkgm;
      return localException;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final Object getResult()
  {
    Object localObject1 = mLock;
    try
    {
      zzbie();
      if (zzkgm == null)
      {
        Object localObject2 = zzkgl;
        return localObject2;
      }
      throw new RuntimeExecutionException(zzkgm);
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final Object getResult(Class paramClass)
    throws Throwable
  {
    Object localObject = mLock;
    try
    {
      zzbie();
      if (!paramClass.isInstance(zzkgm))
      {
        if (zzkgm == null)
        {
          paramClass = zzkgl;
          return paramClass;
        }
        throw new RuntimeExecutionException(zzkgm);
      }
      throw ((Throwable)paramClass.cast(zzkgm));
    }
    catch (Throwable paramClass)
    {
      throw paramClass;
    }
  }
  
  public final boolean isComplete()
  {
    Object localObject = mLock;
    try
    {
      boolean bool = zzkgk;
      return bool;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final boolean isSuccessful()
  {
    Object localObject = mLock;
    for (;;)
    {
      try
      {
        if ((zzkgk) && (zzkgm == null))
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
  
  public final void setException(Exception paramException)
  {
    zzbp.get(paramException, "Exception must not be null");
    Object localObject = mLock;
    try
    {
      zzbif();
      zzkgk = true;
      zzkgm = paramException;
      zzkgj.execute(this);
      return;
    }
    catch (Throwable paramException)
    {
      throw paramException;
    }
  }
  
  public final void setResult(Object paramObject)
  {
    Object localObject = mLock;
    try
    {
      zzbif();
      zzkgk = true;
      zzkgl = paramObject;
      zzkgj.execute(this);
      return;
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
  }
  
  public final boolean trySetException(Exception paramException)
  {
    zzbp.get(paramException, "Exception must not be null");
    Object localObject = mLock;
    try
    {
      if (zzkgk) {
        return false;
      }
      zzkgk = true;
      zzkgm = paramException;
      zzkgj.execute(this);
      return true;
    }
    catch (Throwable paramException)
    {
      throw paramException;
    }
  }
  
  public final boolean trySetResult(Object paramObject)
  {
    Object localObject = mLock;
    try
    {
      if (zzkgk) {
        return false;
      }
      zzkgk = true;
      zzkgl = paramObject;
      zzkgj.execute(this);
      return true;
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
  }
}
