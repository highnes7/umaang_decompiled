package com.google.android.android.common.package_9.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.internal.zzby;
import com.google.android.android.common.package_9.Api.zzb;
import com.google.android.android.common.package_9.Api.zze;
import com.google.android.android.common.package_9.Sample;
import com.google.android.android.common.package_9.Status;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzao
  implements zzbk
{
  public final zzbl zzflh;
  public boolean zzfli = false;
  
  public zzao(zzbl paramZzbl)
  {
    zzflh = paramZzbl;
  }
  
  public final Logger add(Logger paramLogger)
  {
    Object localObject1 = zzflh.zzfju.zzfmt;
    try
    {
      ((zzdj)localObject1).next(paramLogger);
      Object localObject2 = zzflh.zzfju;
      localObject1 = paramLogger.zzafe();
      localObject2 = zzfmn;
      localObject1 = ((Map)localObject2).get(localObject1);
      localObject1 = (Api.zze)localObject1;
      zzbp.get(localObject1, "Appropriate Api was not requested.");
      boolean bool = ((Api.zze)localObject1).isConnected();
      if (!bool)
      {
        localObject2 = zzflh.zzfnc;
        bool = ((Map)localObject2).containsKey(paramLogger.zzafe());
        if (bool)
        {
          paramLogger.remove(new Status(17));
          return paramLogger;
        }
      }
      if (!(localObject1 instanceof zzby))
      {
        paramLogger.debug((Api.zzb)localObject1);
        return paramLogger;
      }
      zzby.zzako();
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
    catch (DeadObjectException localDeadObjectException)
    {
      for (;;) {}
    }
    zzflh.enqueue(new zzap(this, this));
    return paramLogger;
  }
  
  public final Logger addCollection(Logger paramLogger)
  {
    return add(paramLogger);
  }
  
  public final void begin() {}
  
  public final void connect()
  {
    if (zzfli)
    {
      zzfli = false;
      zzflh.enqueue(new zzaq(this, this));
    }
  }
  
  public final boolean disconnect()
  {
    if (zzfli) {
      return false;
    }
    if (zzflh.zzfju.zzahj())
    {
      zzfli = true;
      Iterator localIterator = zzflh.zzfju.zzfms.iterator();
      while (localIterator.hasNext()) {
        ((zzdg)localIterator.next()).zzaio();
      }
      return false;
    }
    zzflh.wakeup(null);
    return true;
  }
  
  public final void onConnected(Bundle paramBundle) {}
  
  public final void onConnectionSuspended(int paramInt)
  {
    zzflh.wakeup(null);
    zzflh.zzfng.setSorting(paramInt, zzfli);
  }
  
  public final void spawn(ConnectionResult paramConnectionResult, Sample paramSample, boolean paramBoolean) {}
  
  public final void zzagy()
  {
    if (zzfli)
    {
      zzfli = false;
      zzflh.zzfju.zzfmt.release();
      disconnect();
    }
  }
}
