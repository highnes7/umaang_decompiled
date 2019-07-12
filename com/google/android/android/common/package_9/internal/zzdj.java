package com.google.android.android.common.package_9.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.android.common.package_9.Status;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.internal.zzs;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzdj
{
  public static final Status zzfpq = new Status(8, "The connection to Google Play services was lost");
  public static final zzs<?>[] zzfpr = new Log[0];
  public final Map<Api.zzc<?>, com.google.android.gms.common.api.Api.zze> zzfmn;
  public final Set<zzs<?>> zzfps = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
  public final zzdm zzfpt = new zzdk(this);
  
  public zzdj(Map paramMap)
  {
    zzfmn = paramMap;
  }
  
  public final void next(Log paramLog)
  {
    zzfps.add(paramLog);
    paramLog.remove(zzfpt);
  }
  
  public final void release()
  {
    Log[] arrayOfLog = (Log[])zzfps.toArray(zzfpr);
    int j = arrayOfLog.length;
    int i = 0;
    while (i < j)
    {
      Log localLog = arrayOfLog[i];
      localLog.remove(null);
      if (localLog.zzafs() == null) {
        if (!localLog.zzagf()) {
          break label169;
        }
      }
      for (;;)
      {
        zzfps.remove(localLog);
        break label169;
        localLog.setResultCallback(null);
        IBinder localIBinder = ((com.google.android.android.common.package_9.Api.zze)zzfmn.get(((Logger)localLog).zzafe())).zzafg();
        zzdl localZzdl;
        if (localLog.isReady())
        {
          localLog.remove(new zzdl(localLog, null, localIBinder));
        }
        else
        {
          if ((localIBinder == null) || (!localIBinder.isBinderAlive())) {
            break label198;
          }
          localZzdl = new zzdl(localLog, null, localIBinder);
          localLog.remove(localZzdl);
        }
        try
        {
          localIBinder.linkToDeath(localZzdl, 0);
        }
        catch (RemoteException localRemoteException)
        {
          label169:
          for (;;) {}
        }
      }
      i += 1;
      continue;
      localLog.cancel();
      localLog.zzafs().intValue();
      throw new NullPointerException("Null throw statement replaced by Soot");
      label198:
      localLog.remove(null);
      localLog.cancel();
      localLog.zzafs().intValue();
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
  }
  
  public final void zzaiq()
  {
    Log[] arrayOfLog = (Log[])zzfps.toArray(zzfpr);
    int j = arrayOfLog.length;
    int i = 0;
    while (i < j)
    {
      arrayOfLog[i].next(zzfpq);
      i += 1;
    }
  }
}
