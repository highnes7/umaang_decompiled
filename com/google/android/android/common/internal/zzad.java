package com.google.android.android.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.android.common.ConnectionResult;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzad
  implements Handler.Callback
{
  public final Handler mHandler;
  public final Object mLock = new Object();
  public final zzae zzfum;
  public final ArrayList<com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks> zzfun = new ArrayList();
  public ArrayList<com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks> zzfuo = new ArrayList();
  public final ArrayList<com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener> zzfup = new ArrayList();
  public volatile boolean zzfuq = false;
  public final AtomicInteger zzfur = new AtomicInteger(0);
  public boolean zzfus = false;
  
  public zzad(Looper paramLooper, zzae paramZzae)
  {
    zzfum = paramZzae;
    mHandler = new Handler(paramLooper, this);
  }
  
  public final void connect(Bundle paramBundle)
  {
    Object localObject1 = Looper.myLooper();
    Object localObject2 = mHandler.getLooper();
    boolean bool2 = true;
    boolean bool1;
    if (localObject1 == localObject2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    zzbp.append(bool1, "onConnectionSuccess must only be called on the Handler thread");
    localObject1 = mLock;
    for (;;)
    {
      try
      {
        if (!zzfus)
        {
          bool1 = true;
          zzbp.zzbg(bool1);
          mHandler.removeMessages(1);
          zzfus = true;
          if (zzfuo.size() != 0) {
            break label247;
          }
          bool1 = bool2;
          zzbp.zzbg(bool1);
          localObject2 = new ArrayList(zzfun);
          int k = zzfur.get();
          int m = ((ArrayList)localObject2).size();
          int i = 0;
          if (i < m)
          {
            Object localObject3 = ((ArrayList)localObject2).get(i);
            int j = i + 1;
            localObject3 = (com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks)localObject3;
            if ((zzfuq) && (zzfum.isConnected()) && (zzfur.get() == k))
            {
              i = j;
              if (zzfuo.contains(localObject3)) {
                continue;
              }
              ((com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks)localObject3).onConnected(paramBundle);
              i = j;
              continue;
            }
          }
          zzfuo.clear();
          zzfus = false;
          return;
        }
      }
      catch (Throwable paramBundle)
      {
        throw paramBundle;
      }
      bool1 = false;
      continue;
      label247:
      bool1 = false;
    }
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    int i = what;
    if (i == 1)
    {
      com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks)obj;
      paramMessage = mLock;
      try
      {
        if ((zzfuq) && (zzfum.isConnected()) && (zzfun.contains(localConnectionCallbacks))) {
          localConnectionCallbacks.onConnected(zzfum.zzaeh());
        }
        return true;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    Log.wtf("GmsClientEvents", f.sufficientlysecure.rootcommands.util.StringBuilder.add(45, "Don't know how to handle message: ", i), new Exception());
    return false;
  }
  
  public final boolean isConnectionCallbacksRegistered(com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzbp.append(paramConnectionCallbacks);
    Object localObject = mLock;
    try
    {
      boolean bool = zzfun.contains(paramConnectionCallbacks);
      return bool;
    }
    catch (Throwable paramConnectionCallbacks)
    {
      throw paramConnectionCallbacks;
    }
  }
  
  public final boolean isConnectionFailedListenerRegistered(com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzbp.append(paramOnConnectionFailedListener);
    Object localObject = mLock;
    try
    {
      boolean bool = zzfup.contains(paramOnConnectionFailedListener);
      return bool;
    }
    catch (Throwable paramOnConnectionFailedListener)
    {
      throw paramOnConnectionFailedListener;
    }
  }
  
  public final void registerConnectionCallbacks(com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzbp.append(paramConnectionCallbacks);
    Object localObject = mLock;
    try
    {
      if (zzfun.contains(paramConnectionCallbacks))
      {
        String str = String.valueOf(paramConnectionCallbacks);
        StringBuilder localStringBuilder = new StringBuilder(str.length() + 62);
        localStringBuilder.append("registerConnectionCallbacks(): listener ");
        localStringBuilder.append(str);
        localStringBuilder.append(" is already registered");
        localStringBuilder.toString();
      }
      else
      {
        zzfun.add(paramConnectionCallbacks);
      }
      if (zzfum.isConnected())
      {
        localObject = mHandler;
        ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(1, paramConnectionCallbacks));
        return;
      }
    }
    catch (Throwable paramConnectionCallbacks)
    {
      throw paramConnectionCallbacks;
    }
  }
  
  public final void registerConnectionFailedListener(com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzbp.append(paramOnConnectionFailedListener);
    Object localObject = mLock;
    try
    {
      if (zzfup.contains(paramOnConnectionFailedListener))
      {
        paramOnConnectionFailedListener = String.valueOf(paramOnConnectionFailedListener);
        StringBuilder localStringBuilder = new StringBuilder(paramOnConnectionFailedListener.length() + 67);
        localStringBuilder.append("registerConnectionFailedListener(): listener ");
        localStringBuilder.append(paramOnConnectionFailedListener);
        localStringBuilder.append(" is already registered");
        localStringBuilder.toString();
      }
      else
      {
        zzfup.add(paramOnConnectionFailedListener);
      }
      return;
    }
    catch (Throwable paramOnConnectionFailedListener)
    {
      throw paramOnConnectionFailedListener;
    }
  }
  
  public final void show(ConnectionResult paramConnectionResult)
  {
    Object localObject1 = Looper.myLooper();
    Object localObject2 = mHandler.getLooper();
    int i = 0;
    boolean bool;
    if (localObject1 == localObject2) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.append(bool, "onConnectionFailure must only be called on the Handler thread");
    mHandler.removeMessages(1);
    localObject1 = mLock;
    try
    {
      localObject2 = new ArrayList(zzfup);
      int k = zzfur.get();
      int m = ((ArrayList)localObject2).size();
      while (i < m)
      {
        Object localObject3 = ((ArrayList)localObject2).get(i);
        int j = i + 1;
        localObject3 = (com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener)localObject3;
        if ((zzfuq) && (zzfur.get() == k))
        {
          i = j;
          if (zzfup.contains(localObject3))
          {
            ((com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener)localObject3).onConnectionFailed(paramConnectionResult);
            i = j;
          }
        }
        else
        {
          return;
        }
      }
      return;
    }
    catch (Throwable paramConnectionResult)
    {
      throw paramConnectionResult;
    }
  }
  
  public final void unregisterConnectionCallbacks(com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzbp.append(paramConnectionCallbacks);
    Object localObject = mLock;
    try
    {
      if (!zzfun.remove(paramConnectionCallbacks))
      {
        paramConnectionCallbacks = String.valueOf(paramConnectionCallbacks);
        StringBuilder localStringBuilder = new StringBuilder(paramConnectionCallbacks.length() + 52);
        localStringBuilder.append("unregisterConnectionCallbacks(): listener ");
        localStringBuilder.append(paramConnectionCallbacks);
        localStringBuilder.append(" not found");
        localStringBuilder.toString();
      }
      else if (zzfus)
      {
        zzfuo.add(paramConnectionCallbacks);
      }
      return;
    }
    catch (Throwable paramConnectionCallbacks)
    {
      throw paramConnectionCallbacks;
    }
  }
  
  public final void unregisterConnectionFailedListener(com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzbp.append(paramOnConnectionFailedListener);
    Object localObject = mLock;
    try
    {
      if (!zzfup.remove(paramOnConnectionFailedListener))
      {
        paramOnConnectionFailedListener = String.valueOf(paramOnConnectionFailedListener);
        StringBuilder localStringBuilder = new StringBuilder(paramOnConnectionFailedListener.length() + 57);
        localStringBuilder.append("unregisterConnectionFailedListener(): listener ");
        localStringBuilder.append(paramOnConnectionFailedListener);
        localStringBuilder.append(" not found");
        localStringBuilder.toString();
      }
      return;
    }
    catch (Throwable paramOnConnectionFailedListener)
    {
      throw paramOnConnectionFailedListener;
    }
  }
  
  public final void zzake()
  {
    zzfuq = false;
    zzfur.incrementAndGet();
  }
  
  public final void zzakf()
  {
    zzfuq = true;
  }
  
  public final void zzce(int paramInt)
  {
    boolean bool;
    if (Looper.myLooper() == mHandler.getLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.append(bool, "onUnintentionalDisconnection must only be called on the Handler thread");
    mHandler.removeMessages(1);
    Object localObject1 = mLock;
    try
    {
      zzfus = true;
      ArrayList localArrayList = new ArrayList(zzfun);
      int k = zzfur.get();
      int m = localArrayList.size();
      int i = 0;
      while (i < m)
      {
        Object localObject2 = localArrayList.get(i);
        int j = i + 1;
        localObject2 = (com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks)localObject2;
        if ((!zzfuq) || (zzfur.get() != k)) {
          break;
        }
        i = j;
        if (zzfun.contains(localObject2))
        {
          ((com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks)localObject2).onConnectionSuspended(paramInt);
          i = j;
        }
      }
      zzfuo.clear();
      zzfus = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
