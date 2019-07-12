package com.google.android.android.common.package_9.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.android.common.PingManager;
import com.google.android.android.common.internal.AccountInformation;
import com.google.android.android.common.package_9.Api.zza;
import com.google.android.android.common.package_9.Api.zzd;
import com.google.android.android.common.package_9.Api.zze;
import com.google.android.android.common.package_9.GoogleApi;
import com.google.android.android.common.package_9.Sample;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.internal.zzbdy;
import com.google.android.android.tasks.Task;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.api.internal.zzm;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import support.android.v4.util.ArrayMap;

public final class zzad
  implements zzcd
{
  public final Looper zzakg;
  public final zzbp zzfgv;
  public final Lock zzfke;
  public final AccountInformation zzfkj;
  public final Map<com.google.android.gms.common.api.Api.zzc<?>, com.google.android.gms.common.api.internal.zzac<?>> zzfkk = new HashMap();
  public final Map<com.google.android.gms.common.api.Api.zzc<?>, com.google.android.gms.common.api.internal.zzac<?>> zzfkl = new HashMap();
  public final Map<Api<?>, Boolean> zzfkm;
  public final zzbd zzfkn;
  public final PingManager zzfko;
  public final Condition zzfkp;
  public final boolean zzfkq;
  public final boolean zzfkr;
  public final Queue<zzm<?, ?>> zzfks = new LinkedList();
  public boolean zzfkt;
  public Map<zzh<?>, com.google.android.gms.common.ConnectionResult> zzfku;
  public Map<zzh<?>, com.google.android.gms.common.ConnectionResult> zzfkv;
  public zzag zzfkw;
  public com.google.android.android.common.ConnectionResult zzfkx;
  
  public zzad(Context paramContext, Lock paramLock, Looper paramLooper, PingManager paramPingManager, Map paramMap1, AccountInformation paramAccountInformation, Map paramMap2, Api.zza paramZza, ArrayList paramArrayList, zzbd paramZzbd, boolean paramBoolean)
  {
    zzfke = paramLock;
    zzakg = paramLooper;
    zzfkp = paramLock.newCondition();
    zzfko = paramPingManager;
    zzfkn = paramZzbd;
    zzfkm = paramMap2;
    zzfkj = paramAccountInformation;
    zzfkq = paramBoolean;
    paramLock = new HashMap();
    paramPingManager = paramMap2.keySet().iterator();
    while (paramPingManager.hasNext())
    {
      paramMap2 = (Sample)paramPingManager.next();
      paramLock.put(paramMap2.zzafe(), paramMap2);
    }
    paramPingManager = new HashMap();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      paramMap2 = paramArrayList.get(i);
      i += 1;
      paramMap2 = (ByteArrayBuffer)paramMap2;
      paramPingManager.put(zzfdg, paramMap2);
    }
    paramMap1 = paramMap1.entrySet().iterator();
    paramBoolean = true;
    int k = 0;
    j = 1;
    i = 0;
    while (paramMap1.hasNext())
    {
      paramMap2 = (Map.Entry)paramMap1.next();
      paramZzbd = (Sample)paramLock.get(paramMap2.getKey());
      paramArrayList = (Api.zze)paramMap2.getValue();
      if (paramArrayList.zzaff())
      {
        if (!((Boolean)zzfkm.get(paramZzbd)).booleanValue()) {
          i = 1;
        }
        k = 1;
      }
      else
      {
        j = 0;
      }
      paramZzbd = new zzac(paramContext, paramZzbd, paramLooper, paramArrayList, (ByteArrayBuffer)paramPingManager.get(paramZzbd), paramAccountInformation, paramZza);
      zzfkk.put((com.google.android.android.common.package_9.Api.zzc)paramMap2.getKey(), paramZzbd);
      if (paramArrayList.zzaac()) {
        zzfkl.put((com.google.android.android.common.package_9.Api.zzc)paramMap2.getKey(), paramZzbd);
      }
    }
    if ((k == 0) || (j != 0) || (i != 0)) {
      paramBoolean = false;
    }
    zzfkr = paramBoolean;
    zzfgv = zzbp.zzaho();
  }
  
  private final boolean has(zzac paramZzac, com.google.android.android.common.ConnectionResult paramConnectionResult)
  {
    return (!paramConnectionResult.isSuccess()) && (!paramConnectionResult.hasResolution()) && (((Boolean)zzfkm.get(paramZzac.zzafj())).booleanValue()) && (paramZzac.zzagn().zzaff()) && (zzfko.isUserResolvableError(paramConnectionResult.getErrorCode()));
  }
  
  private final boolean remove(Logger paramLogger)
  {
    com.google.android.android.common.package_9.Api.zzc localZzc = paramLogger.zzafe();
    com.google.android.android.common.ConnectionResult localConnectionResult = removeAccount(localZzc);
    if ((localConnectionResult != null) && (localConnectionResult.getErrorCode() == 4))
    {
      paramLogger.remove(new Status(1, 4, null, zzfgv.getIntent(((zzac)zzfkk.get(localZzc)).zzafk(), System.identityHashCode(zzfkn))));
      return true;
    }
    return false;
  }
  
  private final com.google.android.android.common.ConnectionResult removeAccount(com.google.android.android.common.package_9.Api.zzc paramZzc)
  {
    zzfke.lock();
    try
    {
      paramZzc = (zzac)zzfkk.get(paramZzc);
      Map localMap = zzfku;
      if ((localMap != null) && (paramZzc != null))
      {
        paramZzc = (com.google.android.android.common.ConnectionResult)zzfku.get(paramZzc.zzafk());
        zzfke.unlock();
        return paramZzc;
      }
      zzfke.unlock();
      return null;
    }
    catch (Throwable paramZzc)
    {
      zzfke.unlock();
      throw paramZzc;
    }
  }
  
  private final boolean zzago()
  {
    zzfke.lock();
    try
    {
      boolean bool = zzfkt;
      if (bool)
      {
        bool = zzfkq;
        if (bool)
        {
          Iterator localIterator = zzfkl.keySet().iterator();
          do
          {
            bool = localIterator.hasNext();
            if (!bool) {
              break label94;
            }
            com.google.android.android.common.ConnectionResult localConnectionResult = removeAccount((com.google.android.android.common.package_9.Api.zzc)localIterator.next());
            if (localConnectionResult == null) {
              break;
            }
            bool = localConnectionResult.isSuccess();
          } while (bool);
        }
      }
      zzfke.unlock();
      return false;
      label94:
      zzfke.unlock();
      return true;
    }
    catch (Throwable localThrowable)
    {
      zzfke.unlock();
      throw localThrowable;
    }
  }
  
  private final void zzagp()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a7 = a6\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  private final void zzagq()
  {
    while (!zzfks.isEmpty()) {
      addTask((Logger)zzfks.remove());
    }
    zzfkn.removeTask(null);
  }
  
  private final com.google.android.android.common.ConnectionResult zzagr()
  {
    Iterator localIterator = zzfkk.values().iterator();
    Object localObject2 = null;
    Object localObject1 = null;
    int j = 0;
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject3 = (zzac)localIterator.next();
      Sample localSample = ((GoogleApi)localObject3).zzafj();
      localObject3 = ((GoogleApi)localObject3).zzafk();
      localObject3 = (com.google.android.android.common.ConnectionResult)zzfku.get(localObject3);
      if ((!((com.google.android.android.common.ConnectionResult)localObject3).isSuccess()) && ((!((Boolean)zzfkm.get(localSample)).booleanValue()) || (((com.google.android.android.common.ConnectionResult)localObject3).hasResolution()) || (zzfko.isUserResolvableError(((com.google.android.android.common.ConnectionResult)localObject3).getErrorCode()))))
      {
        int k;
        if ((((com.google.android.android.common.ConnectionResult)localObject3).getErrorCode() == 4) && (zzfkq))
        {
          k = localSample.zzafc().getPriority();
          if ((localObject1 == null) || (i > k))
          {
            localObject1 = localObject3;
            i = k;
          }
        }
        else
        {
          k = localSample.zzafc().getPriority();
          if ((localObject2 == null) || (j > k))
          {
            localObject2 = localObject3;
            j = k;
          }
        }
      }
    }
    if ((localObject2 != null) && (localObject1 != null) && (j > i)) {
      return localObject1;
    }
    return localObject2;
  }
  
  public final Logger addTask(Logger paramLogger)
  {
    com.google.android.android.common.package_9.Api.zzc localZzc = paramLogger.zzafe();
    if ((zzfkq) && (remove(paramLogger))) {
      return paramLogger;
    }
    zzfkn.zzfmt.next(paramLogger);
    return ((zzac)zzfkk.get(localZzc)).log(paramLogger);
  }
  
  public final boolean addTask(zzcv paramZzcv)
  {
    zzfke.lock();
    try
    {
      boolean bool = zzfkt;
      if (bool)
      {
        bool = zzago();
        if (!bool)
        {
          zzfgv.zzafw();
          zzfkw = new zzag(this, paramZzcv);
          zzfgv.connect(zzfkl.values()).addOnCompleteListener(new zzbdy(zzakg), zzfkw);
          zzfke.unlock();
          return true;
        }
      }
      zzfke.unlock();
      return false;
    }
    catch (Throwable paramZzcv)
    {
      zzfke.unlock();
      throw paramZzcv;
    }
  }
  
  public final com.google.android.android.common.ConnectionResult blockingConnect()
  {
    connect();
    for (;;)
    {
      if (!isConnecting()) {
        break label42;
      }
      Object localObject = zzfkp;
      try
      {
        ((Condition)localObject).await();
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
    Thread.currentThread().interrupt();
    return new com.google.android.android.common.ConnectionResult(15, null);
    label42:
    if (isConnected()) {
      return com.google.android.android.common.ConnectionResult.zzfff;
    }
    localObject = zzfkx;
    if (localObject != null) {
      return localObject;
    }
    return new com.google.android.android.common.ConnectionResult(13, null);
  }
  
  public final com.google.android.android.common.ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    connect();
    for (paramLong = paramTimeUnit.toNanos(paramLong);; paramLong = paramTimeUnit.awaitNanos(paramLong))
    {
      if ((!isConnecting()) || (paramLong <= 0L)) {}
      try
      {
        disconnect();
        paramTimeUnit = new com.google.android.android.common.ConnectionResult(14, null);
        return paramTimeUnit;
      }
      catch (InterruptedException paramTimeUnit)
      {
        for (;;) {}
      }
      paramTimeUnit = zzfkp;
    }
    Thread.currentThread().interrupt();
    return new com.google.android.android.common.ConnectionResult(15, null);
    if (isConnected()) {
      return com.google.android.android.common.ConnectionResult.zzfff;
    }
    paramTimeUnit = zzfkx;
    if (paramTimeUnit != null) {
      return paramTimeUnit;
    }
    return new com.google.android.android.common.ConnectionResult(13, null);
  }
  
  /* Error */
  public final void connect()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	com/google/android/android/common/package_9/internal/zzad:zzfke	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 279 1 0
    //   9: aload_0
    //   10: getfield 200	com/google/android/android/common/package_9/internal/zzad:zzfkt	Z
    //   13: istore_1
    //   14: iload_1
    //   15: ifeq +13 -> 28
    //   18: aload_0
    //   19: getfield 59	com/google/android/android/common/package_9/internal/zzad:zzfke	Ljava/util/concurrent/locks/Lock;
    //   22: invokeinterface 282 1 0
    //   27: return
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 200	com/google/android/android/common/package_9/internal/zzad:zzfkt	Z
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 176	com/google/android/android/common/package_9/internal/zzad:zzfku	Ljava/util/Map;
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 190	com/google/android/android/common/package_9/internal/zzad:zzfkv	Ljava/util/Map;
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 358	com/google/android/android/common/package_9/internal/zzad:zzfkw	Lcom/google/android/android/common/package_9/internal/zzag;
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 186	com/google/android/android/common/package_9/internal/zzad:zzfkx	Lcom/google/android/android/common/ConnectionResult;
    //   53: aload_0
    //   54: getfield 171	com/google/android/android/common/package_9/internal/zzad:zzfgv	Lcom/google/android/android/common/package_9/internal/zzbp;
    //   57: invokevirtual 351	com/google/android/android/common/package_9/internal/zzbp:zzafw	()V
    //   60: aload_0
    //   61: getfield 171	com/google/android/android/common/package_9/internal/zzad:zzfgv	Lcom/google/android/android/common/package_9/internal/zzbp;
    //   64: aload_0
    //   65: getfield 50	com/google/android/android/common/package_9/internal/zzad:zzfkk	Ljava/util/Map;
    //   68: invokeinterface 319 1 0
    //   73: invokevirtual 362	com/google/android/android/common/package_9/internal/zzbp:connect	(Ljava/lang/Iterable;)Lcom/google/android/android/tasks/Task;
    //   76: new 364	com/google/android/android/internal/zzbdy
    //   79: dup
    //   80: aload_0
    //   81: getfield 61	com/google/android/android/common/package_9/internal/zzad:zzakg	Landroid/os/Looper;
    //   84: invokespecial 367	com/google/android/android/internal/zzbdy:<init>	(Landroid/os/Looper;)V
    //   87: new 419	com/google/android/android/common/package_9/internal/zzaf
    //   90: dup
    //   91: aload_0
    //   92: aconst_null
    //   93: invokespecial 422	com/google/android/android/common/package_9/internal/zzaf:<init>	(Lcom/google/android/android/common/package_9/internal/zzad;Lcom/google/android/android/common/package_9/internal/zzae;)V
    //   96: invokevirtual 373	com/google/android/android/tasks/Task:addOnCompleteListener	(Ljava/util/concurrent/Executor;Lcom/google/android/android/tasks/OnCompleteListener;)Lcom/google/android/android/tasks/Task;
    //   99: pop
    //   100: goto -82 -> 18
    //   103: astore_2
    //   104: aload_0
    //   105: getfield 59	com/google/android/android/common/package_9/internal/zzad:zzfke	Ljava/util/concurrent/locks/Lock;
    //   108: invokeinterface 282 1 0
    //   113: goto +3 -> 116
    //   116: aload_2
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	zzad
    //   13	2	1	bool	boolean
    //   103	14	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   9	14	103	java/lang/Throwable
    //   28	100	103	java/lang/Throwable
  }
  
  public final void disconnect()
  {
    zzfke.lock();
    try
    {
      zzfkt = false;
      zzfku = null;
      zzfkv = null;
      Object localObject = zzfkw;
      if (localObject != null)
      {
        zzfkw.cancel();
        zzfkw = null;
      }
      zzfkx = null;
      for (;;)
      {
        boolean bool = zzfks.isEmpty();
        if (bool) {
          break;
        }
        localObject = (Logger)zzfks.remove();
        ((Log)localObject).remove(null);
        ((Log)localObject).cancel();
      }
      zzfkp.signalAll();
      zzfke.unlock();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzfke.unlock();
      throw localThrowable;
    }
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public final com.google.android.android.common.ConnectionResult getConnectionResult(Sample paramSample)
  {
    return removeAccount(paramSample.zzafe());
  }
  
  public final boolean isConnected()
  {
    zzfke.lock();
    try
    {
      Object localObject = zzfku;
      if (localObject != null)
      {
        localObject = zzfkx;
        if (localObject == null)
        {
          bool = true;
          break label34;
        }
      }
      boolean bool = false;
      label34:
      zzfke.unlock();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      zzfke.unlock();
      throw localThrowable;
    }
  }
  
  public final boolean isConnecting()
  {
    zzfke.lock();
    try
    {
      Map localMap = zzfku;
      if (localMap == null)
      {
        bool = zzfkt;
        if (bool)
        {
          bool = true;
          break label34;
        }
      }
      boolean bool = false;
      label34:
      zzfke.unlock();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      zzfke.unlock();
      throw localThrowable;
    }
  }
  
  public final Logger removeTask(Logger paramLogger)
  {
    if ((zzfkq) && (remove(paramLogger))) {
      return paramLogger;
    }
    if (!isConnected())
    {
      zzfks.add(paramLogger);
      return paramLogger;
    }
    zzfkn.zzfmt.next(paramLogger);
    return ((zzac)zzfkk.get(paramLogger.zzafe())).create(paramLogger);
  }
  
  public final void zzafp()
  {
    zzfke.lock();
    try
    {
      zzfgv.zzafp();
      Object localObject = zzfkw;
      if (localObject != null)
      {
        zzfkw.cancel();
        zzfkw = null;
      }
      localObject = zzfkv;
      if (localObject == null) {
        zzfkv = new ArrayMap(zzfkl.size());
      }
      localObject = new com.google.android.android.common.ConnectionResult(4);
      Iterator localIterator = zzfkl.values().iterator();
      for (;;)
      {
        boolean bool = localIterator.hasNext();
        if (!bool) {
          break;
        }
        zzac localZzac = (zzac)localIterator.next();
        zzfkv.put(localZzac.zzafk(), localObject);
      }
      localObject = zzfku;
      if (localObject != null) {
        zzfku.putAll(zzfkv);
      }
      zzfke.unlock();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzfke.unlock();
      throw localThrowable;
    }
  }
  
  public final void zzagi() {}
}
