package com.google.android.android.common.package_9.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.android.common.internal.zzap;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.Releasable;
import com.google.android.android.common.package_9.ResultTransform;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.common.package_9.TransformedResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.zzu;
import com.google.android.gms.common.api.internal.zzv;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Log<R extends com.google.android.gms.common.api.Result>
  extends PendingResult<R>
{
  public static final ThreadLocal<Boolean> zzfje = new CycleDetectingLockFactory.1();
  public Status mStatus;
  public boolean zzaj;
  public final CountDownLatch zzaof = new CountDownLatch(1);
  public R zzfhr;
  public final Object zzfjf = new Object();
  public zzu<R> zzfjg;
  public WeakReference<com.google.android.gms.common.api.GoogleApiClient> zzfjh;
  public final ArrayList<com.google.android.gms.common.api.PendingResult.zza> zzfji = new ArrayList();
  public com.google.android.gms.common.api.ResultCallback<? super R> zzfjj;
  public final AtomicReference<com.google.android.gms.common.api.internal.zzdm> zzfjk = new AtomicReference();
  public zzv zzfjl;
  public volatile boolean zzfjm;
  public boolean zzfjn;
  public zzap zzfjo;
  public volatile com.google.android.gms.common.api.internal.zzdg<R> zzfjp;
  public boolean zzfjq = false;
  
  public Log()
  {
    zzfjg = new Main.1(Looper.getMainLooper());
    zzfjh = new WeakReference(null);
  }
  
  public Log(Looper paramLooper)
  {
    zzfjg = new Main.1(paramLooper);
    zzfjh = new WeakReference(null);
  }
  
  public Log(com.google.android.android.common.package_9.GoogleApiClient paramGoogleApiClient)
  {
    Looper localLooper;
    if (paramGoogleApiClient != null) {
      localLooper = paramGoogleApiClient.getLooper();
    } else {
      localLooper = Looper.getMainLooper();
    }
    zzfjg = new Main.1(localLooper);
    zzfjh = new WeakReference(paramGoogleApiClient);
  }
  
  public static void clear(com.google.android.android.common.package_9.Result paramResult)
  {
    if ((paramResult instanceof Releasable))
    {
      try
      {
        ((Releasable)paramResult).release();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        StringBuilder localStringBuilder;
        for (;;) {}
      }
      paramResult = String.valueOf(paramResult);
      localStringBuilder = new StringBuilder(paramResult.length() + 18);
      localStringBuilder.append("Unable to release ");
      localStringBuilder.append(paramResult);
      localStringBuilder.toString();
      return;
    }
  }
  
  private final void close(com.google.android.android.common.package_9.Result paramResult)
  {
    zzfhr = paramResult;
    zzfjo = null;
    zzaof.countDown();
    mStatus = zzfhr.getStatus();
    if (zzaj)
    {
      zzfjj = null;
    }
    else if (zzfjj == null)
    {
      if ((zzfhr instanceof Releasable)) {
        zzfjl = new SharedGroup(this, null);
      }
    }
    else
    {
      zzfjg.removeMessages(2);
      zzfjg.onPostExecute(zzfjj, collectAndSendLog());
    }
    paramResult = zzfji;
    int j = paramResult.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramResult.get(i);
      i += 1;
      ((com.google.android.android.common.package_9.PendingResult.zza)localObject).run(mStatus);
    }
    zzfji.clear();
  }
  
  private final com.google.android.android.common.package_9.Result collectAndSendLog()
  {
    Object localObject = zzfjf;
    for (;;)
    {
      try
      {
        if (zzfjm) {
          break label88;
        }
        bool = true;
        zzbp.append(bool, "Result has already been consumed.");
        zzbp.append(isReady(), "Result is not ready.");
        com.google.android.android.common.package_9.Result localResult = zzfhr;
        zzfhr = null;
        zzfjj = null;
        zzfjm = true;
        localObject = (zzdm)zzfjk.getAndSet(null);
        if (localObject != null)
        {
          ((zzdm)localObject).removeTask(this);
          return localResult;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      return localThrowable;
      label88:
      boolean bool = false;
    }
  }
  
  public final com.google.android.android.common.package_9.Result await()
  {
    Object localObject = Looper.myLooper();
    Looper localLooper = Looper.getMainLooper();
    boolean bool2 = false;
    if (localObject != localLooper) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    zzbp.append(bool1, "await must not be called on the UI thread");
    zzbp.append(zzfjm ^ true, "Result has already been consumed");
    boolean bool1 = bool2;
    if (zzfjp == null) {
      bool1 = true;
    }
    zzbp.append(bool1, "Cannot await if then() has been called.");
    localObject = zzaof;
    try
    {
      ((CountDownLatch)localObject).await();
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
    next(Status.zzfhw);
    zzbp.append(isReady(), "Result is not ready.");
    return collectAndSendLog();
  }
  
  public final com.google.android.android.common.package_9.Result await(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool2 = false;
    if ((paramLong > 0L) && (Looper.myLooper() == Looper.getMainLooper())) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    zzbp.append(bool1, "await must not be called on the UI thread when time is greater than zero.");
    zzbp.append(zzfjm ^ true, "Result has already been consumed.");
    boolean bool1 = bool2;
    if (zzfjp == null) {
      bool1 = true;
    }
    zzbp.append(bool1, "Cannot await if then() has been called.");
    CountDownLatch localCountDownLatch = zzaof;
    try
    {
      bool1 = localCountDownLatch.await(paramLong, paramTimeUnit);
      if (bool1) {
        break label108;
      }
      paramTimeUnit = Status.zzfhy;
      next(paramTimeUnit);
    }
    catch (InterruptedException paramTimeUnit)
    {
      label108:
      for (;;) {}
    }
    next(Status.zzfhw);
    zzbp.append(isReady(), "Result is not ready.");
    return collectAndSendLog();
  }
  
  /* Error */
  public void cancel()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 61	com/google/android/android/common/package_9/internal/Log:zzfjf	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 156	com/google/android/android/common/package_9/internal/Log:zzaj	Z
    //   11: ifne +59 -> 70
    //   14: aload_0
    //   15: getfield 197	com/google/android/android/common/package_9/internal/Log:zzfjm	Z
    //   18: ifeq +6 -> 24
    //   21: goto +49 -> 70
    //   24: aload_0
    //   25: getfield 143	com/google/android/android/common/package_9/internal/Log:zzfjo	Lcom/google/android/android/common/internal/zzap;
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull +14 -> 44
    //   33: aload_0
    //   34: getfield 143	com/google/android/android/common/package_9/internal/Log:zzfjo	Lcom/google/android/android/common/internal/zzap;
    //   37: astore_2
    //   38: aload_2
    //   39: invokeinterface 262 1 0
    //   44: aload_0
    //   45: getfield 141	com/google/android/android/common/package_9/internal/Log:zzfhr	Lcom/google/android/android/common/package_9/Result;
    //   48: invokestatic 264	com/google/android/android/common/package_9/internal/Log:clear	(Lcom/google/android/android/common/package_9/Result;)V
    //   51: aload_0
    //   52: iconst_1
    //   53: putfield 156	com/google/android/android/common/package_9/internal/Log:zzaj	Z
    //   56: aload_0
    //   57: aload_0
    //   58: getstatic 267	com/google/android/android/common/package_9/Status:zzfhz	Lcom/google/android/android/common/package_9/Status;
    //   61: invokevirtual 271	com/google/android/android/common/package_9/internal/Log:getSheet	(Lcom/google/android/android/common/package_9/Status;)Lcom/google/android/android/common/package_9/Result;
    //   64: invokespecial 273	com/google/android/android/common/package_9/internal/Log:close	(Lcom/google/android/android/common/package_9/Result;)V
    //   67: aload_1
    //   68: monitorexit
    //   69: return
    //   70: aload_1
    //   71: monitorexit
    //   72: return
    //   73: astore_2
    //   74: aload_1
    //   75: monitorexit
    //   76: aload_2
    //   77: athrow
    //   78: astore_2
    //   79: goto -35 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	Log
    //   4	71	1	localObject	Object
    //   28	11	2	localZzap	zzap
    //   73	4	2	localThrowable	Throwable
    //   78	1	2	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   7	21	73	java/lang/Throwable
    //   24	29	73	java/lang/Throwable
    //   38	44	73	java/lang/Throwable
    //   44	69	73	java/lang/Throwable
    //   70	72	73	java/lang/Throwable
    //   74	76	73	java/lang/Throwable
    //   38	44	78	android/os/RemoteException
  }
  
  public abstract com.google.android.android.common.package_9.Result getSheet(Status paramStatus);
  
  public final void initialized(zzap paramZzap)
  {
    Object localObject = zzfjf;
    try
    {
      zzfjo = paramZzap;
      return;
    }
    catch (Throwable paramZzap)
    {
      throw paramZzap;
    }
  }
  
  public boolean isCanceled()
  {
    Object localObject = zzfjf;
    try
    {
      boolean bool = zzaj;
      return bool;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final boolean isReady()
  {
    return zzaof.getCount() == 0L;
  }
  
  public final void next(Status paramStatus)
  {
    Object localObject = zzfjf;
    try
    {
      if (!isReady())
      {
        setResult(getSheet(paramStatus));
        zzfjn = true;
      }
      return;
    }
    catch (Throwable paramStatus)
    {
      throw paramStatus;
    }
  }
  
  public final void remove(zzdm paramZzdm)
  {
    zzfjk.set(paramZzdm);
  }
  
  public final void set(com.google.android.android.common.package_9.PendingResult.zza paramZza)
  {
    boolean bool;
    if (paramZza != null) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.get(bool, "Callback cannot be null.");
    Object localObject = zzfjf;
    try
    {
      if (isReady()) {
        paramZza.run(mStatus);
      } else {
        zzfji.add(paramZza);
      }
      return;
    }
    catch (Throwable paramZza)
    {
      throw paramZza;
    }
  }
  
  public final void setResult(com.google.android.android.common.package_9.Result paramResult)
  {
    Object localObject = zzfjf;
    for (;;)
    {
      try
      {
        if ((!zzfjn) && (!zzaj))
        {
          isReady();
          bool1 = isReady();
          boolean bool2 = true;
          if (!bool1)
          {
            bool1 = true;
            zzbp.append(bool1, "Results have already been set");
            if (zzfjm) {
              break label97;
            }
            bool1 = bool2;
            zzbp.append(bool1, "Result has already been consumed");
            close(paramResult);
          }
        }
        else
        {
          clear(paramResult);
          return;
        }
      }
      catch (Throwable paramResult)
      {
        throw paramResult;
      }
      boolean bool1 = false;
      continue;
      label97:
      bool1 = false;
    }
  }
  
  public final void setResultCallback(com.google.android.android.common.package_9.ResultCallback paramResultCallback)
  {
    Object localObject = zzfjf;
    if (paramResultCallback == null) {}
    try
    {
      zzfjj = null;
      return;
    }
    catch (Throwable paramResultCallback)
    {
      boolean bool2;
      throw paramResultCallback;
    }
    boolean bool1 = zzfjm;
    bool2 = true;
    if (!bool1)
    {
      bool1 = true;
      zzbp.append(bool1, "Result has already been consumed.");
      if (zzfjp != null) {
        break label116;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      zzbp.append(bool1, "Cannot set callbacks if then() has been called.");
      if (isCanceled()) {
        return;
      }
      if (isReady()) {
        zzfjg.onPostExecute(paramResultCallback, collectAndSendLog());
      } else {
        zzfjj = paramResultCallback;
      }
      return;
      bool1 = false;
      break;
      label116:
      bool1 = false;
    }
  }
  
  public final void setResultCallback(com.google.android.android.common.package_9.ResultCallback paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    Object localObject = zzfjf;
    if (paramResultCallback == null) {}
    try
    {
      zzfjj = null;
      return;
    }
    catch (Throwable paramResultCallback)
    {
      boolean bool2;
      throw paramResultCallback;
    }
    boolean bool1 = zzfjm;
    bool2 = true;
    if (!bool1)
    {
      bool1 = true;
      zzbp.append(bool1, "Result has already been consumed.");
      if (zzfjp != null) {
        break label149;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      zzbp.append(bool1, "Cannot set callbacks if then() has been called.");
      if (isCanceled()) {
        return;
      }
      if (isReady())
      {
        zzfjg.onPostExecute(paramResultCallback, collectAndSendLog());
      }
      else
      {
        zzfjj = paramResultCallback;
        paramResultCallback = zzfjg;
        paramLong = paramTimeUnit.toMillis(paramLong);
        paramResultCallback.sendMessageDelayed(paramResultCallback.obtainMessage(2, this), paramLong);
      }
      return;
      bool1 = false;
      break;
      label149:
      bool1 = false;
    }
  }
  
  public TransformedResult then(ResultTransform paramResultTransform)
  {
    zzbp.append(zzfjm ^ true, "Result has already been consumed.");
    Object localObject = zzfjf;
    for (;;)
    {
      try
      {
        zzdg localZzdg = zzfjp;
        boolean bool2 = false;
        if (localZzdg == null)
        {
          bool1 = true;
          zzbp.append(bool1, "Cannot call then() twice.");
          if (zzfjj != null) {
            break label160;
          }
          bool1 = true;
          zzbp.append(bool1, "Cannot call then() if callbacks are set.");
          bool1 = bool2;
          if (!zzaj) {
            bool1 = true;
          }
          zzbp.append(bool1, "Cannot call then() if result was canceled.");
          zzfjq = true;
          zzfjp = new zzdg(zzfjh);
          paramResultTransform = zzfjp.then(paramResultTransform);
          if (isReady()) {
            zzfjg.onPostExecute(zzfjp, collectAndSendLog());
          } else {
            zzfjj = zzfjp;
          }
          return paramResultTransform;
        }
      }
      catch (Throwable paramResultTransform)
      {
        throw paramResultTransform;
      }
      boolean bool1 = false;
      continue;
      label160:
      bool1 = false;
    }
  }
  
  public final Integer zzafs()
  {
    return null;
  }
  
  public final boolean zzagf()
  {
    Object localObject = zzfjf;
    try
    {
      if (((com.google.android.android.common.package_9.GoogleApiClient)zzfjh.get() == null) || (!zzfjq)) {
        cancel();
      }
      boolean bool = isCanceled();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void zzagg()
  {
    boolean bool;
    if ((!zzfjq) && (!((Boolean)zzfje.get()).booleanValue())) {
      bool = false;
    } else {
      bool = true;
    }
    zzfjq = bool;
  }
}
