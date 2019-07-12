package com.google.android.android.common.package_9.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.GoogleApiAvailability;
import com.google.android.android.common.package_9.Api.zze;
import com.google.android.android.common.package_9.GoogleApi;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.tasks.Task;
import com.google.android.android.tasks.TaskCompletionSource;
import com.google.android.gms.common.api.internal.zzh;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import support.android.v4.util.NodeList;

public final class zzbp
  implements Handler.Callback
{
  public static final Object zzaqd = new Object();
  public static final Status zzfnk = new Status(4, "Sign-out occurred while this API call was in progress.");
  public static final Status zzfnl = new Status(4, "The user must be signed in to make this API call.");
  public static zzbp zzfnn;
  public final Context mContext;
  public final Handler mHandler;
  public final GoogleApiAvailability zzfhl;
  public final Map<zzh<?>, com.google.android.gms.common.api.internal.zzbr<?>> zzfkk = new ConcurrentHashMap(5, 0.75F, 1);
  public long zzfmj = 120000L;
  public long zzfmk = 5000L;
  public long zzfnm = 10000L;
  public int zzfno = -1;
  public final AtomicInteger zzfnp = new AtomicInteger(1);
  public final AtomicInteger zzfnq = new AtomicInteger(0);
  public zzak zzfnr = null;
  public final Set<zzh<?>> zzfns = new NodeList(0);
  public final Set<zzh<?>> zzfnt = new NodeList(0);
  
  public zzbp(Context paramContext, Looper paramLooper, GoogleApiAvailability paramGoogleApiAvailability)
  {
    mContext = paramContext;
    mHandler = new Handler(paramLooper, this);
    zzfhl = paramGoogleApiAvailability;
    paramContext = mHandler;
    paramContext.sendMessage(paramContext.obtainMessage(6));
  }
  
  private final void getSources(GoogleApi paramGoogleApi)
  {
    Msg localMsg = paramGoogleApi.zzafk();
    zzbr localZzbr2 = (zzbr)zzfkk.get(localMsg);
    zzbr localZzbr1 = localZzbr2;
    if (localZzbr2 == null)
    {
      localZzbr1 = new zzbr(this, paramGoogleApi);
      zzfkk.put(localMsg, localZzbr1);
    }
    if (localZzbr1.zzaac()) {
      zzfnt.add(localMsg);
    }
    localZzbr1.connect();
  }
  
  public static zzbp zzaho()
  {
    Object localObject = zzaqd;
    try
    {
      com.google.android.android.common.internal.zzbp.get(zzfnn, "Must guarantee manager is non-null before using getInstance");
      zzbp localZzbp = zzfnn;
      return localZzbp;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static void zzahp()
  {
    Object localObject1 = zzaqd;
    try
    {
      if (zzfnn != null)
      {
        Object localObject2 = zzfnn;
        zzfnq.incrementAndGet();
        localObject2 = mHandler;
        ((Handler)localObject2).sendMessageAtFrontOfQueue(((Handler)localObject2).obtainMessage(10));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private final void zzahr()
  {
    Iterator localIterator = zzfnt.iterator();
    while (localIterator.hasNext())
    {
      Msg localMsg = (Msg)localIterator.next();
      ((zzbr)zzfkk.remove(localMsg)).signOut();
    }
    zzfnt.clear();
  }
  
  public static zzbp zzca(Context paramContext)
  {
    Object localObject1 = zzaqd;
    try
    {
      if (zzfnn == null)
      {
        Object localObject2 = new HandlerThread("GoogleApiHandler", 9);
        ((Thread)localObject2).start();
        localObject2 = ((HandlerThread)localObject2).getLooper();
        zzfnn = new zzbp(paramContext.getApplicationContext(), (Looper)localObject2, GoogleApiAvailability.zzffi);
      }
      paramContext = zzfnn;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public final void cancelTasks(zzak paramZzak)
  {
    Object localObject = zzaqd;
    try
    {
      if (zzfnr == paramZzak)
      {
        zzfnr = null;
        zzfns.clear();
      }
      return;
    }
    catch (Throwable paramZzak)
    {
      throw paramZzak;
    }
  }
  
  public final Task connect(Iterable paramIterable)
  {
    LogItem localLogItem = new LogItem(paramIterable);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = (GoogleApi)paramIterable.next();
      localObject = (zzbr)zzfkk.get(((GoogleApi)localObject).zzafk());
      if ((localObject == null) || (!((zzbr)localObject).isConnected()))
      {
        paramIterable = mHandler;
        paramIterable.sendMessage(paramIterable.obtainMessage(2, localLogItem));
      }
    }
    for (;;)
    {
      return localLogItem.getTask();
      localLogItem.zzafy();
    }
  }
  
  public final PendingIntent getIntent(Msg paramMsg, int paramInt)
  {
    paramMsg = (zzbr)zzfkk.get(paramMsg);
    if (paramMsg == null) {
      return null;
    }
    paramMsg = paramMsg.zzaic();
    if (paramMsg == null) {
      return null;
    }
    return PendingIntent.getActivity(mContext, paramInt, paramMsg.zzaam(), 134217728);
  }
  
  public final boolean handleMessage(android.os.Message paramMessage)
  {
    int i = what;
    long l = 300000L;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    switch (i)
    {
    default: 
      paramMessage = new StringBuilder(31);
      paramMessage.append("Unknown message id: ");
      paramMessage.append(i);
      paramMessage.toString();
      return false;
    case 12: 
      if (zzfkk.containsKey(obj))
      {
        ((zzbr)zzfkk.get(obj)).zzaib();
        return true;
      }
      break;
    case 11: 
      if (zzfkk.containsKey(obj))
      {
        ((zzbr)zzfkk.get(obj)).zzahh();
        return true;
      }
      break;
    case 10: 
      zzahr();
      return true;
    case 9: 
      if (zzfkk.containsKey(obj))
      {
        ((zzbr)zzfkk.get(obj)).resume();
        return true;
      }
      break;
    case 7: 
      getSources((GoogleApi)obj);
      return true;
    case 6: 
      if ((mContext.getApplicationContext() instanceof Application))
      {
        DefaultAppLock.enable((Application)mContext.getApplicationContext());
        DefaultAppLock.zzfis.set(new zzbq(this));
        if (!DefaultAppLock.zzfis.zzbd(true))
        {
          zzfnm = 300000L;
          return true;
        }
      }
      break;
    case 5: 
      i = arg1;
      localObject2 = (ConnectionResult)obj;
      localObject1 = null;
      localObject3 = zzfkk.values().iterator();
      do
      {
        paramMessage = (android.os.Message)localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        paramMessage = (zzbr)((Iterator)localObject3).next();
      } while (paramMessage.getInstanceId() != i);
      if (paramMessage != null)
      {
        localObject1 = zzfhl.getErrorString(((ConnectionResult)localObject2).getErrorCode());
        localObject2 = ((ConnectionResult)localObject2).getErrorMessage();
        localObject3 = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject2, f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject1, 69)));
        ((StringBuilder)localObject3).append("Error resolution was canceled by the user, original error message: ");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(": ");
        ((StringBuilder)localObject3).append((String)localObject2);
        paramMessage.write(new Status(17, ((StringBuilder)localObject3).toString()));
        return true;
      }
      paramMessage = new StringBuilder(76);
      paramMessage.append("Could not find API instance ");
      paramMessage.append(i);
      paramMessage.append(" while trying to fail enqueued calls.");
      Log.wtf("GoogleApiManager", paramMessage.toString(), new Exception());
      return true;
    case 4: 
    case 8: 
    case 13: 
      localObject2 = (zzcq)obj;
      localObject1 = (zzbr)zzfkk.get(zzfpb.zzafk());
      paramMessage = (android.os.Message)localObject1;
      if (localObject1 == null)
      {
        getSources(zzfpb);
        paramMessage = (zzbr)zzfkk.get(zzfpb.zzafk());
      }
      if ((paramMessage.zzaac()) && (zzfnq.get() != zzfpa))
      {
        zzfoz.add(zzfnk);
        paramMessage.signOut();
        return true;
      }
      paramMessage.handleReceive(zzfoz);
      return true;
    case 3: 
      paramMessage = zzfkk.values().iterator();
    case 2: 
    case 1: 
      while (paramMessage.hasNext())
      {
        localObject1 = (zzbr)paramMessage.next();
        ((zzbr)localObject1).zzahx();
        ((zzbr)localObject1).connect();
        continue;
        localObject1 = (LogItem)obj;
        localObject2 = ((LogItem)localObject1).zzafx().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Msg)((Iterator)localObject2).next();
          paramMessage = (zzbr)zzfkk.get(localObject3);
          if (paramMessage == null)
          {
            ((LogItem)localObject1).setTimestamp((Msg)localObject3, new ConnectionResult(13));
            return true;
          }
          if (paramMessage.isConnected())
          {
            paramMessage = ConnectionResult.zzfff;
          }
          else
          {
            if (paramMessage.zzahy() == null) {
              break label848;
            }
            paramMessage = paramMessage.zzahy();
          }
          ((LogItem)localObject1).setTimestamp((Msg)localObject3, paramMessage);
          continue;
          label848:
          paramMessage.registerCallbacks((LogItem)localObject1);
          continue;
          if (((Boolean)obj).booleanValue()) {
            l = 10000L;
          }
          zzfnm = l;
          mHandler.removeMessages(12);
          paramMessage = zzfkk.keySet().iterator();
          while (paramMessage.hasNext())
          {
            localObject1 = (Msg)paramMessage.next();
            localObject2 = mHandler;
            ((Handler)localObject2).sendMessageDelayed(((Handler)localObject2).obtainMessage(12, localObject1), zzfnm);
          }
        }
      }
    }
    return true;
  }
  
  public final void launch(zzak paramZzak)
  {
    Object localObject = zzaqd;
    try
    {
      if (zzfnr != paramZzak)
      {
        zzfnr = paramZzak;
        zzfns.clear();
        zzfns.addAll(paramZzak.zzagv());
      }
      return;
    }
    catch (Throwable paramZzak)
    {
      throw paramZzak;
    }
  }
  
  public final void notifyError(GoogleApi paramGoogleApi)
  {
    Handler localHandler = mHandler;
    localHandler.sendMessage(localHandler.obtainMessage(7, paramGoogleApi));
  }
  
  public final void onPageChanged(ConnectionResult paramConnectionResult, int paramInt)
  {
    if (!setCurrentTheme(paramConnectionResult, paramInt))
    {
      Handler localHandler = mHandler;
      localHandler.sendMessage(localHandler.obtainMessage(5, paramInt, 0, paramConnectionResult));
    }
  }
  
  public final void output(GoogleApi paramGoogleApi, int paramInt, Logger paramLogger)
  {
    paramLogger = new Message(paramInt, paramLogger);
    Handler localHandler = mHandler;
    localHandler.sendMessage(localHandler.obtainMessage(4, new zzcq(paramLogger, zzfnq.get(), paramGoogleApi)));
  }
  
  public final void playSong(GoogleApi paramGoogleApi, int paramInt, zzdd paramZzdd, TaskCompletionSource paramTaskCompletionSource, zzcz paramZzcz)
  {
    paramZzdd = new Resources(paramInt, paramZzdd, paramTaskCompletionSource, paramZzcz);
    paramTaskCompletionSource = mHandler;
    paramTaskCompletionSource.sendMessage(paramTaskCompletionSource.obtainMessage(4, new zzcq(paramZzdd, zzfnq.get(), paramGoogleApi)));
  }
  
  public final boolean setCurrentTheme(ConnectionResult paramConnectionResult, int paramInt)
  {
    return zzfhl.setCurrentTheme(mContext, paramConnectionResult, paramInt);
  }
  
  public final Task then(GoogleApi paramGoogleApi, zzcl paramZzcl)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramZzcl = new Curve25519FieldElement(paramZzcl, localTaskCompletionSource);
    Handler localHandler = mHandler;
    localHandler.sendMessage(localHandler.obtainMessage(13, new zzcq(paramZzcl, zzfnq.get(), paramGoogleApi)));
    return localTaskCompletionSource.getTask();
  }
  
  public final Task then(GoogleApi paramGoogleApi, zzcr paramZzcr, zzdn paramZzdn)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramZzcr = new Quaternion(new zzcs(paramZzcr, paramZzdn), localTaskCompletionSource);
    paramZzdn = mHandler;
    paramZzdn.sendMessage(paramZzdn.obtainMessage(8, new zzcq(paramZzcr, zzfnq.get(), paramGoogleApi)));
    return localTaskCompletionSource.getTask();
  }
  
  public final void zzafp()
  {
    zzfnq.incrementAndGet();
    Handler localHandler = mHandler;
    localHandler.sendMessage(localHandler.obtainMessage(10));
  }
  
  public final void zzafw()
  {
    Handler localHandler = mHandler;
    localHandler.sendMessage(localHandler.obtainMessage(3));
  }
  
  public final int zzahq()
  {
    return zzfnp.getAndIncrement();
  }
}
