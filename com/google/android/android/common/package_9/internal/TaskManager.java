package com.google.android.android.common.package_9.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.PingManager;
import com.google.android.android.common.internal.AccountInformation;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.Api.zza;
import com.google.android.android.common.package_9.Api.zze;
import com.google.android.android.common.package_9.Sample;
import com.google.android.android.common.package_9.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import support.android.v4.util.ArrayMap;
import support.android.v4.util.SimpleArrayMap;

public final class TaskManager
  implements zzcd
{
  public final Context mContext;
  public final Looper zzakg;
  public final zzbd zzfju;
  public final zzbl zzfjv;
  public final zzbl zzfjw;
  public final Map<com.google.android.gms.common.api.Api.zzc<?>, com.google.android.gms.common.api.internal.zzbl> zzfjx;
  public final Set<com.google.android.gms.common.api.internal.zzcv> zzfjy = Collections.newSetFromMap(new WeakHashMap());
  public final Api.zze zzfjz;
  public Bundle zzfka;
  public ConnectionResult zzfkb = null;
  public ConnectionResult zzfkc = null;
  public boolean zzfkd = false;
  public final Lock zzfke;
  public int zzfkf = 0;
  
  public TaskManager(Context paramContext, zzbd paramZzbd, Lock paramLock, Looper paramLooper, PingManager paramPingManager, Map paramMap1, Map paramMap2, AccountInformation paramAccountInformation, Api.zza paramZza, Api.zze paramZze, ArrayList paramArrayList1, ArrayList paramArrayList2, Map paramMap3, Map paramMap4)
  {
    mContext = paramContext;
    zzfju = paramZzbd;
    zzfke = paramLock;
    zzakg = paramLooper;
    zzfjz = paramZze;
    zzfjv = new zzbl(paramContext, zzfju, paramLock, paramLooper, paramPingManager, paramMap2, null, paramMap4, null, paramArrayList2, new zzaa(this, null));
    zzfjw = new zzbl(paramContext, zzfju, paramLock, paramLooper, paramPingManager, paramMap1, paramAccountInformation, paramMap3, paramZza, paramArrayList1, new zzab(this, null));
    paramContext = new ArrayMap();
    paramZzbd = paramMap2.keySet().iterator();
    while (paramZzbd.hasNext()) {
      paramContext.put((com.google.android.android.common.package_9.Api.zzc)paramZzbd.next(), zzfjv);
    }
    paramZzbd = paramMap1.keySet().iterator();
    while (paramZzbd.hasNext()) {
      paramContext.put((com.google.android.android.common.package_9.Api.zzc)paramZzbd.next(), zzfjw);
    }
    zzfjx = Collections.unmodifiableMap(paramContext);
  }
  
  public static TaskManager evaluate(Context paramContext, zzbd paramZzbd, Lock paramLock, Looper paramLooper, PingManager paramPingManager, Map paramMap1, AccountInformation paramAccountInformation, Map paramMap2, Api.zza paramZza, ArrayList paramArrayList)
  {
    ArrayMap localArrayMap1 = new ArrayMap();
    ArrayMap localArrayMap2 = new ArrayMap();
    Object localObject2 = paramMap1.entrySet().iterator();
    paramMap1 = null;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject1 = (Api.zze)((Map.Entry)localObject3).getValue();
      if (((Api.zze)localObject1).zzaal()) {
        paramMap1 = (Map)localObject1;
      }
      if (((Api.zze)localObject1).zzaac()) {
        localArrayMap1.put((com.google.android.android.common.package_9.Api.zzc)((Map.Entry)localObject3).getKey(), localObject1);
      } else {
        localArrayMap2.put((com.google.android.android.common.package_9.Api.zzc)((Map.Entry)localObject3).getKey(), localObject1);
      }
    }
    zzbp.append(localArrayMap1.isEmpty() ^ true, "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
    Object localObject1 = new ArrayMap();
    localObject2 = new ArrayMap();
    Object localObject3 = paramMap2.keySet().iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Sample)((Iterator)localObject3).next();
      com.google.android.android.common.package_9.Api.zzc localZzc = ((Sample)localObject4).zzafe();
      if (localArrayMap1.containsKey(localZzc)) {
        ((Map)localObject1).put(localObject4, (Boolean)paramMap2.get(localObject4));
      } else if (localArrayMap2.containsKey(localZzc)) {
        ((Map)localObject2).put(localObject4, (Boolean)paramMap2.get(localObject4));
      } else {
        throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
      }
    }
    paramMap2 = new ArrayList();
    localObject3 = new ArrayList();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      localObject4 = paramArrayList.get(i);
      i += 1;
      localObject4 = (ByteArrayBuffer)localObject4;
      if (((Map)localObject1).containsKey(zzfdg)) {
        paramMap2.add(localObject4);
      } else if (((Map)localObject2).containsKey(zzfdg)) {
        ((ArrayList)localObject3).add(localObject4);
      } else {
        throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
      }
    }
    return new TaskManager(paramContext, paramZzbd, paramLock, paramLooper, paramPingManager, localArrayMap1, localArrayMap2, paramAccountInformation, paramZza, paramMap1, paramMap2, (ArrayList)localObject3, (Map)localObject1, (Map)localObject2);
  }
  
  public static boolean handleError(ConnectionResult paramConnectionResult)
  {
    return (paramConnectionResult != null) && (paramConnectionResult.isSuccess());
  }
  
  private final boolean log(Logger paramLogger)
  {
    paramLogger = paramLogger.zzafe();
    zzbp.get(zzfjx.containsKey(paramLogger), "GoogleApiClient is not configured to use the API required for this call.");
    return ((zzbl)zzfjx.get(paramLogger)).equals(zzfjw);
  }
  
  private final void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = zzfka;
    if (localBundle == null)
    {
      zzfka = paramBundle;
      return;
    }
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
  }
  
  private final void reconnect(ConnectionResult paramConnectionResult)
  {
    int i = zzfkf;
    if (i != 1)
    {
      if (i != 2) {
        Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
      } else {
        zzfju.removeTask(paramConnectionResult);
      }
    }
    else {
      zzagk();
    }
    zzfkf = 0;
  }
  
  private final void setSorting(int paramInt, boolean paramBoolean)
  {
    zzfju.setSorting(paramInt, paramBoolean);
    zzfkc = null;
    zzfkb = null;
  }
  
  private final void zzagj()
  {
    Object localObject;
    if (handleError(zzfkb))
    {
      if ((!handleError(zzfkc)) && (!zzagl()))
      {
        localObject = zzfkc;
        if (localObject != null)
        {
          if (zzfkf == 1)
          {
            zzagk();
            return;
          }
          reconnect((ConnectionResult)localObject);
          zzfjv.disconnect();
        }
      }
      else
      {
        int i = zzfkf;
        if (i != 1)
        {
          if (i != 2) {
            Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
          } else {
            zzfju.removeTask(zzfka);
          }
        }
        else {
          zzagk();
        }
        zzfkf = 0;
      }
    }
    else
    {
      if ((zzfkb != null) && (handleError(zzfkc)))
      {
        zzfjw.disconnect();
        reconnect(zzfkb);
        return;
      }
      localObject = zzfkb;
      if (localObject != null)
      {
        ConnectionResult localConnectionResult = zzfkc;
        if (localConnectionResult != null)
        {
          if (zzfjw.zzfnf < zzfjv.zzfnf) {
            localObject = localConnectionResult;
          }
          reconnect((ConnectionResult)localObject);
        }
      }
    }
  }
  
  private final void zzagk()
  {
    Iterator localIterator = zzfjy.iterator();
    while (localIterator.hasNext()) {
      ((zzcv)localIterator.next()).zzaak();
    }
    zzfjy.clear();
  }
  
  private final boolean zzagl()
  {
    ConnectionResult localConnectionResult = zzfkc;
    return (localConnectionResult != null) && (localConnectionResult.getErrorCode() == 4);
  }
  
  private final PendingIntent zzagm()
  {
    if (zzfjz == null) {
      return null;
    }
    return PendingIntent.getActivity(mContext, System.identityHashCode(zzfju), zzfjz.zzaam(), 134217728);
  }
  
  public final Logger addTask(Logger paramLogger)
  {
    if (log(paramLogger)) {
      if (zzagl())
      {
        paramLogger.remove(new Status(1, 4, null, zzagm()));
        return paramLogger;
      }
    }
    for (zzbl localZzbl = zzfjw;; localZzbl = zzfjv) {
      return localZzbl.addTask(paramLogger);
    }
  }
  
  public final boolean addTask(zzcv paramZzcv)
  {
    zzfke.lock();
    try
    {
      boolean bool = isConnecting();
      if (!bool)
      {
        bool = isConnected();
        if (!bool) {}
      }
      else
      {
        bool = zzfjw.isConnected();
        if (!bool)
        {
          zzfjy.add(paramZzcv);
          int i = zzfkf;
          if (i == 0) {
            zzfkf = 1;
          }
          zzfkc = null;
          zzfjw.connect();
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
  
  public final ConnectionResult blockingConnect()
  {
    throw new UnsupportedOperationException();
  }
  
  public final ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void connect()
  {
    zzfkf = 2;
    zzfkd = false;
    zzfkc = null;
    zzfkb = null;
    zzfjv.connect();
    zzfjw.connect();
  }
  
  public final void disconnect()
  {
    zzfkc = null;
    zzfkb = null;
    zzfkf = 0;
    zzfjv.disconnect();
    zzfjw.disconnect();
    zzagk();
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("authClient").println(":");
    zzfjw.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.append(paramString).append("anonClient").println(":");
    zzfjv.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public final ConnectionResult getConnectionResult(Sample paramSample)
  {
    if (((zzbl)zzfjx.get(paramSample.zzafe())).equals(zzfjw))
    {
      if (zzagl()) {
        return new ConnectionResult(4, zzagm());
      }
      return zzfjw.getConnectionResult(paramSample);
    }
    return zzfjv.getConnectionResult(paramSample);
  }
  
  public final boolean isConnected()
  {
    zzfke.lock();
    try
    {
      boolean bool1 = zzfjv.isConnected();
      boolean bool2 = true;
      if (bool1)
      {
        boolean bool3 = zzfjw.isConnected();
        bool1 = bool2;
        if (bool3) {
          break label69;
        }
        bool3 = zzagl();
        bool1 = bool2;
        if (bool3) {
          break label69;
        }
        int i = zzfkf;
        if (i == 1)
        {
          bool1 = bool2;
          break label69;
        }
      }
      bool1 = false;
      label69:
      zzfke.unlock();
      return bool1;
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
      int i = zzfkf;
      boolean bool;
      if (i == 2) {
        bool = true;
      } else {
        bool = false;
      }
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
    if (log(paramLogger)) {
      if (zzagl())
      {
        paramLogger.remove(new Status(1, 4, null, zzagm()));
        return paramLogger;
      }
    }
    for (zzbl localZzbl = zzfjw;; localZzbl = zzfjv) {
      return localZzbl.removeTask(paramLogger);
    }
  }
  
  public final void zzafp()
  {
    zzfke.lock();
    try
    {
      boolean bool = isConnecting();
      zzfjw.disconnect();
      zzfkc = new ConnectionResult(4);
      if (bool) {
        new Handler(zzakg).post(new LayerView.1(this));
      } else {
        zzagk();
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
  
  public final void zzagi()
  {
    zzfjv.zzagi();
    zzfjw.zzagi();
  }
}
