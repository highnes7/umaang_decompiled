package com.google.android.android.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.android.common.stats.Connector;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class zzai
  implements ServiceConnection
{
  public int mState;
  public IBinder zzftq;
  public ComponentName zzfuw;
  public final Set<ServiceConnection> zzfvc;
  public boolean zzfvd;
  public final zzag zzfve;
  
  public zzai(zzah paramZzah, zzag paramZzag)
  {
    zzfve = paramZzag;
    zzfvc = new HashSet();
    mState = 2;
  }
  
  public final void bind(ServiceConnection paramServiceConnection, String paramString)
  {
    zzah.bindToService(zzfvf);
    zzah.access$getMApplicationContext(zzfvf);
    zzfvc.remove(paramServiceConnection);
  }
  
  public final void bindToService(ServiceConnection paramServiceConnection, String paramString)
  {
    zzah.bindToService(zzfvf);
    zzah.access$getMApplicationContext(zzfvf);
    zzfve.zzakh();
    zzfvc.add(paramServiceConnection);
  }
  
  public final IBinder getBinder()
  {
    return zzftq;
  }
  
  public final ComponentName getComponentName()
  {
    return zzfuw;
  }
  
  public final int getState()
  {
    return mState;
  }
  
  public final boolean isBound()
  {
    return zzfvd;
  }
  
  public final boolean isTagged(ServiceConnection paramServiceConnection)
  {
    return zzfvc.contains(paramServiceConnection);
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    HashMap localHashMap = zzah.access$getRunning(zzfvf);
    try
    {
      zzah.access$getMHandler(zzfvf).removeMessages(1, zzfve);
      zzftq = paramIBinder;
      zzfuw = paramComponentName;
      Iterator localIterator = zzfvc.iterator();
      while (localIterator.hasNext()) {
        ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
      }
      mState = 1;
      return;
    }
    catch (Throwable paramComponentName)
    {
      throw paramComponentName;
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    HashMap localHashMap = zzah.access$getRunning(zzfvf);
    try
    {
      zzah.access$getMHandler(zzfvf).removeMessages(1, zzfve);
      zzftq = null;
      zzfuw = paramComponentName;
      Iterator localIterator = zzfvc.iterator();
      while (localIterator.hasNext()) {
        ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
      }
      mState = 2;
      return;
    }
    catch (Throwable paramComponentName)
    {
      throw paramComponentName;
    }
  }
  
  public final boolean zzaki()
  {
    return zzfvc.isEmpty();
  }
  
  public final void zzgc(String paramString)
  {
    mState = 3;
    zzfvd = zzah.bindToService(zzfvf).start(zzah.access$getMApplicationContext(zzfvf), paramString, zzfve.zzakh(), this, zzfve.zzakg());
    if (zzfvd)
    {
      paramString = zzah.access$getMHandler(zzfvf).obtainMessage(1, zzfve);
      zzah.access$getMHandler(zzfvf).sendMessageDelayed(paramString, zzah.getMetadataId(zzfvf));
      return;
    }
    mState = 2;
    paramString = zzfvf;
    try
    {
      zzah.bindToService(paramString);
      paramString = zzfvf;
      zzah.access$getMApplicationContext(paramString).unbindService(this);
      return;
    }
    catch (IllegalArgumentException paramString) {}
  }
  
  public final void zzgd(String paramString)
  {
    zzah.access$getMHandler(zzfvf).removeMessages(1, zzfve);
    zzah.bindToService(zzfvf);
    zzah.access$getMApplicationContext(zzfvf).unbindService(this);
    zzfvd = false;
    mState = 2;
  }
}
