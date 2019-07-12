package com.google.android.android.analytics;

import android.os.Build.VERSION;
import com.google.android.android.common.internal.zzbp;
import com.google.android.gms.analytics.zzh;
import com.google.android.gms.analytics.zzm;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class PingManager
{
  public final com.google.android.android.common.util.Log zzasc;
  public final DataHandler zzdkk;
  public boolean zzdkl;
  public long zzdkm;
  public long zzdkn;
  public long zzdko;
  public long zzdkp;
  public long zzdkq;
  public boolean zzdkr;
  public final Map<Class<? extends zzh>, zzh> zzdks;
  public final List<zzm> zzdkt;
  
  public PingManager(DataHandler paramDataHandler, com.google.android.android.common.util.Log paramLog)
  {
    zzbp.append(paramDataHandler);
    zzbp.append(paramLog);
    zzdkk = paramDataHandler;
    zzasc = paramLog;
    zzdkp = 1800000L;
    zzdkq = 3024000000L;
    zzdks = new HashMap();
    zzdkt = new ArrayList();
  }
  
  public PingManager(PingManager paramPingManager)
  {
    zzdkk = zzdkk;
    zzasc = zzasc;
    zzdkm = zzdkm;
    zzdkn = zzdkn;
    zzdko = zzdko;
    zzdkp = zzdkp;
    zzdkq = zzdkq;
    zzdkt = new ArrayList(zzdkt);
    zzdks = new HashMap(zzdks.size());
    paramPingManager = zzdks.entrySet().iterator();
    while (paramPingManager.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramPingManager.next();
      Log localLog = newInstance((Class)localEntry.getKey());
      ((Log)localEntry.getValue()).deepCopy(localLog);
      zzdks.put((Class)localEntry.getKey(), localLog);
    }
  }
  
  public static Log newInstance(Class paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredConstructor(new Class[0]);
      paramClass = paramClass.newInstance(new Object[0]);
      return (Log)paramClass;
    }
    catch (Exception paramClass)
    {
      if (!(paramClass instanceof InstantiationException))
      {
        if (!(paramClass instanceof IllegalAccessException))
        {
          int i = Build.VERSION.SDK_INT;
          if ((paramClass instanceof ReflectiveOperationException)) {
            throw new IllegalArgumentException("Linkage exception", paramClass);
          }
          throw new RuntimeException(paramClass);
        }
        throw new IllegalArgumentException("dataType default constructor is not accessible", paramClass);
      }
      throw new IllegalArgumentException("dataType doesn't have default constructor", paramClass);
    }
  }
  
  public final Log getInstance(Class paramClass)
  {
    Log localLog2 = (Log)zzdks.get(paramClass);
    Log localLog1 = localLog2;
    if (localLog2 == null)
    {
      localLog1 = newInstance(paramClass);
      zzdks.put(paramClass, localLog1);
    }
    return localLog1;
  }
  
  public final Log getLogger(Class paramClass)
  {
    return (Log)zzdks.get(paramClass);
  }
  
  public final List getTransports()
  {
    return zzdkt;
  }
  
  public final void init(Log paramLog)
  {
    zzbp.append(paramLog);
    Class localClass = paramLog.getClass();
    if (localClass.getSuperclass() == zzh.class)
    {
      paramLog.deepCopy(getInstance(localClass));
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public final void ping(long paramLong)
  {
    zzdkn = paramLong;
  }
  
  public final PingManager zztx()
  {
    return new PingManager(this);
  }
  
  public final Collection zzty()
  {
    return zzdks.values();
  }
  
  public final long zztz()
  {
    return zzdkm;
  }
  
  public final void zzua()
  {
    zzdkk.zzug().removeEntry(this);
  }
  
  public final boolean zzub()
  {
    return zzdkl;
  }
  
  public final void zzuc()
  {
    zzdko = zzasc.elapsedRealtime();
    long l = zzdkn;
    if (l == 0L) {
      l = zzasc.currentTimeMillis();
    }
    zzdkm = l;
    zzdkl = true;
  }
  
  public final DataHandler zzud()
  {
    return zzdkk;
  }
  
  public final boolean zzue()
  {
    return zzdkr;
  }
  
  public final void zzuf()
  {
    zzdkr = true;
  }
}
