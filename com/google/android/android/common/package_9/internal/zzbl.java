package com.google.android.android.common.package_9.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.android.common.PingManager;
import com.google.android.android.common.internal.AccountInformation;
import com.google.android.android.common.package_9.Sample;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.internal.zzcps;
import com.google.android.gms.internal.zzcpt;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zzbl
  implements zzcd, BlockingQueue
{
  public final Context mContext;
  public com.google.android.gms.common.api.Api.zza<? extends zzcps, zzcpt> zzfhm;
  public final zzbd zzfju;
  public final Lock zzfke;
  public AccountInformation zzfkj;
  public Map<Api<?>, Boolean> zzfkm;
  public final PingManager zzfko;
  public final Map<Api.zzc<?>, com.google.android.gms.common.api.Api.zze> zzfmn;
  public final Condition zzfna;
  public final zzbn zzfnb;
  public final Map<Api.zzc<?>, com.google.android.gms.common.ConnectionResult> zzfnc = new HashMap();
  public volatile zzbk zzfnd;
  public com.google.android.android.common.ConnectionResult zzfne = null;
  public int zzfnf;
  public final zzce zzfng;
  
  public zzbl(Context paramContext, zzbd paramZzbd, Lock paramLock, Looper paramLooper, PingManager paramPingManager, Map paramMap1, AccountInformation paramAccountInformation, Map paramMap2, com.google.android.android.common.package_9.Api.zza paramZza, ArrayList paramArrayList, zzce paramZzce)
  {
    mContext = paramContext;
    zzfke = paramLock;
    zzfko = paramPingManager;
    zzfmn = paramMap1;
    zzfkj = paramAccountInformation;
    zzfkm = paramMap2;
    zzfhm = paramZza;
    zzfju = paramZzbd;
    zzfng = paramZzce;
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      paramContext = paramArrayList.get(i);
      i += 1;
      ((ByteArrayBuffer)paramContext).append(this);
    }
    zzfnb = new zzbn(this, paramLooper);
    zzfna = paramLock.newCondition();
    zzfnd = new zzbc(this);
  }
  
  public final Logger addTask(Logger paramLogger)
  {
    paramLogger.zzagg();
    return zzfnd.add(paramLogger);
  }
  
  public final boolean addTask(zzcv paramZzcv)
  {
    return false;
  }
  
  public final com.google.android.android.common.ConnectionResult blockingConnect()
  {
    connect();
    for (;;)
    {
      if (!isConnecting()) {
        break label42;
      }
      Object localObject = zzfna;
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
    localObject = zzfne;
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
      paramTimeUnit = zzfna;
    }
    Thread.currentThread().interrupt();
    return new com.google.android.android.common.ConnectionResult(15, null);
    if (isConnected()) {
      return com.google.android.android.common.ConnectionResult.zzfff;
    }
    paramTimeUnit = zzfne;
    if (paramTimeUnit != null) {
      return paramTimeUnit;
    }
    return new com.google.android.android.common.ConnectionResult(13, null);
  }
  
  public final void connect()
  {
    zzfnd.connect();
  }
  
  public final void disconnect()
  {
    if (zzfnd.disconnect()) {
      zzfnc.clear();
    }
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    String str = String.valueOf(paramString).concat("  ");
    paramPrintWriter.append(paramString).append("mState=").println(zzfnd);
    Iterator localIterator = zzfkm.keySet().iterator();
    while (localIterator.hasNext())
    {
      Sample localSample = (Sample)localIterator.next();
      paramPrintWriter.append(paramString).append(localSample.getName()).println(":");
      ((com.google.android.android.common.package_9.Api.zze)zzfmn.get(localSample.zzafe())).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public final void enqueue(zzbm paramZzbm)
  {
    paramZzbm = zzfnb.obtainMessage(1, paramZzbm);
    zzfnb.sendMessage(paramZzbm);
  }
  
  public final com.google.android.android.common.ConnectionResult getConnectionResult(Sample paramSample)
  {
    paramSample = paramSample.zzafe();
    if (zzfmn.containsKey(paramSample))
    {
      if (((com.google.android.android.common.package_9.Api.zze)zzfmn.get(paramSample)).isConnected()) {
        return com.google.android.android.common.ConnectionResult.zzfff;
      }
      if (zzfnc.containsKey(paramSample)) {
        return (com.google.android.android.common.ConnectionResult)zzfnc.get(paramSample);
      }
    }
    return null;
  }
  
  public final void handleResult(com.google.android.android.common.ConnectionResult paramConnectionResult, Sample paramSample, boolean paramBoolean)
  {
    zzfke.lock();
    try
    {
      zzfnd.spawn(paramConnectionResult, paramSample, paramBoolean);
      zzfke.unlock();
      return;
    }
    catch (Throwable paramConnectionResult)
    {
      zzfke.unlock();
      throw paramConnectionResult;
    }
  }
  
  public final boolean isConnected()
  {
    return zzfnd instanceof zzao;
  }
  
  public final boolean isConnecting()
  {
    return zzfnd instanceof zzar;
  }
  
  public final void onConnected(Bundle paramBundle)
  {
    zzfke.lock();
    try
    {
      zzfnd.onConnected(paramBundle);
      zzfke.unlock();
      return;
    }
    catch (Throwable paramBundle)
    {
      zzfke.unlock();
      throw paramBundle;
    }
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    zzfke.lock();
    try
    {
      zzfnd.onConnectionSuspended(paramInt);
      zzfke.unlock();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzfke.unlock();
      throw localThrowable;
    }
  }
  
  public final void onFutureDone(RuntimeException paramRuntimeException)
  {
    paramRuntimeException = zzfnb.obtainMessage(2, paramRuntimeException);
    zzfnb.sendMessage(paramRuntimeException);
  }
  
  public final Logger removeTask(Logger paramLogger)
  {
    paramLogger.zzagg();
    return zzfnd.addCollection(paramLogger);
  }
  
  public final void wakeup(com.google.android.android.common.ConnectionResult paramConnectionResult)
  {
    zzfke.lock();
    try
    {
      zzfne = paramConnectionResult;
      zzfnd = new zzbc(this);
      zzfnd.begin();
      zzfna.signalAll();
      zzfke.unlock();
      return;
    }
    catch (Throwable paramConnectionResult)
    {
      zzfke.unlock();
      throw paramConnectionResult;
    }
  }
  
  public final void zzafp() {}
  
  public final void zzagi()
  {
    if (isConnected()) {
      ((zzao)zzfnd).zzagy();
    }
  }
  
  public final void zzahl()
  {
    zzfke.lock();
    try
    {
      zzfnd = new zzar(this, zzfkj, zzfkm, zzfko, zzfhm, zzfke, mContext);
      zzfnd.begin();
      zzfna.signalAll();
      zzfke.unlock();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzfke.unlock();
      throw localThrowable;
    }
  }
  
  public final void zzahm()
  {
    zzfke.lock();
    try
    {
      zzfju.zzahi();
      zzfnd = new zzao(this);
      zzfnd.begin();
      zzfna.signalAll();
      zzfke.unlock();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzfke.unlock();
      throw localThrowable;
    }
  }
}
