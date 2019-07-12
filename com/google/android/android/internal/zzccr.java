package com.google.android.android.internal;

import android.os.Looper;
import com.google.android.android.common.internal.zzbp;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class zzccr
  extends zzcdu
{
  public static final AtomicLong zzisk = new AtomicLong(Long.MIN_VALUE);
  public ExecutorService zzisa;
  public zzccv zzisb;
  public zzccv zzisc;
  public final PriorityBlockingQueue<FutureTask<?>> zzisd = new PriorityBlockingQueue();
  public final BlockingQueue<FutureTask<?>> zzise = new LinkedBlockingQueue();
  public final Thread.UncaughtExceptionHandler zzisf = new zzcct(this, "Thread death: Uncaught exception on worker thread");
  public final Thread.UncaughtExceptionHandler zzisg = new zzcct(this, "Thread death: Uncaught exception on network thread");
  public final Object zzish = new Object();
  public final Semaphore zzisi = new Semaphore(2);
  public volatile boolean zzisj;
  
  public zzccr(zzccw paramZzccw)
  {
    super(paramZzccw);
  }
  
  private final void enqueue(zzccu paramZzccu)
  {
    Object localObject = zzish;
    try
    {
      zzisd.add(paramZzccu);
      if (zzisb == null)
      {
        zzisb = new zzccv(this, "Measurement Worker", zzisd);
        zzisb.setUncaughtExceptionHandler(zzisf);
        zzisb.start();
      }
      else
      {
        zzisb.zzml();
      }
      return;
    }
    catch (Throwable paramZzccu)
    {
      throw paramZzccu;
    }
  }
  
  public static boolean zzaq()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  public final void e(Runnable paramRunnable)
    throws IllegalStateException
  {
    zzwk();
    zzbp.append(paramRunnable);
    enqueue(new zzccu(this, paramRunnable, false, "Task exception on worker thread"));
  }
  
  public final void enqueue(Runnable paramRunnable)
    throws IllegalStateException
  {
    zzwk();
    zzbp.append(paramRunnable);
    zzccu localZzccu = new zzccu(this, paramRunnable, false, "Task exception on network thread");
    paramRunnable = zzish;
    try
    {
      zzise.add(localZzccu);
      if (zzisc == null)
      {
        zzisc = new zzccv(this, "Measurement Network", zzise);
        zzisc.setUncaughtExceptionHandler(zzisg);
        zzisc.start();
      }
      else
      {
        zzisc.zzml();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final Future get(Callable paramCallable)
    throws IllegalStateException
  {
    zzwk();
    zzbp.append(paramCallable);
    paramCallable = new zzccu(this, paramCallable, true, "Task exception on worker thread");
    if (Thread.currentThread() == zzisb)
    {
      paramCallable.run();
      return paramCallable;
    }
    enqueue(paramCallable);
    return paramCallable;
  }
  
  public final Future getFromLocationName(Callable paramCallable)
    throws IllegalStateException
  {
    zzwk();
    zzbp.append(paramCallable);
    paramCallable = new zzccu(this, paramCallable, false, "Task exception on worker thread");
    if (Thread.currentThread() == zzisb)
    {
      if (!zzisd.isEmpty()) {
        zzaul().zzayf().append("Callable skipped the worker queue.");
      }
      paramCallable.run();
      return paramCallable;
    }
    enqueue(paramCallable);
    return paramCallable;
  }
  
  public final void zzatu()
  {
    zzccw.zzatu();
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void zzatv()
  {
    zzcax.zzawk();
  }
  
  public final void zzatw()
  {
    if (Thread.currentThread() == zzisc) {
      return;
    }
    throw new IllegalStateException("Call expected from network thread");
  }
  
  public final boolean zzays()
  {
    return Thread.currentThread() == zzisb;
  }
  
  public final ExecutorService zzayt()
  {
    Object localObject = zzish;
    try
    {
      if (zzisa == null) {
        zzisa = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
      }
      ExecutorService localExecutorService = zzisa;
      return localExecutorService;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void zzuj()
  {
    if (Thread.currentThread() == zzisb) {
      return;
    }
    throw new IllegalStateException("Call expected from worker thread");
  }
  
  public final void zzuk() {}
}
