package com.google.android.android.internal;

import android.os.Bundle;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.Log;
import com.google.android.android.measurement.AppMeasurement.zzb;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import support.android.v4.util.ArrayMap;

public final class zzcan
  extends zzcdt
{
  public final Map<String, Long> zziku = new ArrayMap();
  public final Map<String, Integer> zzikv = new ArrayMap();
  public long zzikw;
  
  public zzcan(zzccw paramZzccw)
  {
    super(paramZzccw);
  }
  
  private final void addResult(String paramString, long paramLong, AppMeasurement.zzb paramZzb)
  {
    if (paramZzb == null)
    {
      zzaul().zzayj().append("Not logging ad unit exposure. No active activity");
      return;
    }
    if (paramLong < 1000L)
    {
      zzaul().zzayj().append("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(paramLong));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("_ai", paramString);
    localBundle.putLong("_xt", paramLong);
    zzcek.add(paramZzb, localBundle);
    zzatz().put("am", "_xu", localBundle);
  }
  
  private final void execute(String paramString, long paramLong)
  {
    zzatv();
    zzuj();
    zzbp.zzgg(paramString);
    Object localObject = (Integer)zzikv.get(paramString);
    if (localObject != null)
    {
      zzcen localZzcen = zzaud().zzazn();
      int i = ((Integer)localObject).intValue() - 1;
      if (i == 0)
      {
        zzikv.remove(paramString);
        localObject = (Long)zziku.get(paramString);
        long l;
        if (localObject == null)
        {
          zzaul().zzayd().append("First ad unit exposure time was never set");
        }
        else
        {
          l = ((Long)localObject).longValue();
          zziku.remove(paramString);
          addResult(paramString, paramLong - l, localZzcen);
        }
        if (zzikv.isEmpty())
        {
          l = zzikw;
          if (l == 0L)
          {
            zzaul().zzayd().append("First ad exposure time was never set");
            return;
          }
          startSession(paramLong - l, localZzcen);
          zzikw = 0L;
        }
      }
      else
      {
        zzikv.put(paramString, Integer.valueOf(i));
      }
    }
    else
    {
      zzaul().zzayd().append("Call to endAdUnitExposure for unknown ad unit id", paramString);
    }
  }
  
  private final void startSession(long paramLong, AppMeasurement.zzb paramZzb)
  {
    if (paramZzb == null)
    {
      zzaul().zzayj().append("Not logging ad exposure. No active activity");
      return;
    }
    if (paramLong < 1000L)
    {
      zzaul().zzayj().append("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(paramLong));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("_xt", paramLong);
    zzcek.add(paramZzb, localBundle);
    zzatz().put("am", "_xa", localBundle);
  }
  
  private final void trim(String paramString, long paramLong)
  {
    zzatv();
    zzuj();
    zzbp.zzgg(paramString);
    if (zzikv.isEmpty()) {
      zzikw = paramLong;
    }
    Integer localInteger = (Integer)zzikv.get(paramString);
    if (localInteger != null)
    {
      zzikv.put(paramString, Integer.valueOf(localInteger.intValue() + 1));
      return;
    }
    if (zzikv.size() >= 100)
    {
      zzaul().zzayf().append("Too many ads visible");
      return;
    }
    zzikv.put(paramString, Integer.valueOf(1));
    zziku.put(paramString, Long.valueOf(paramLong));
  }
  
  private final void zzak(long paramLong)
  {
    Iterator localIterator = zziku.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      zziku.put(str, Long.valueOf(paramLong));
    }
    if (!zziku.isEmpty()) {
      zzikw = paramLong;
    }
  }
  
  public final void beginAdUnitExposure(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      long l = zzvx().elapsedRealtime();
      zzauk().e(new zzcao(this, paramString, l));
      return;
    }
    zzaul().zzayd().append("Ad unit id must be a non-empty string");
  }
  
  public final void endAdUnitExposure(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      long l = zzvx().elapsedRealtime();
      zzauk().e(new zzcap(this, paramString, l));
      return;
    }
    zzaul().zzayd().append("Ad unit id must be a non-empty string");
  }
  
  public final void zzaj(long paramLong)
  {
    zzcen localZzcen = zzaud().zzazn();
    Iterator localIterator = zziku.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      addResult(str, paramLong - ((Long)zziku.get(str)).longValue(), localZzcen);
    }
    if (!zziku.isEmpty()) {
      startSession(paramLong - zzikw, localZzcen);
    }
    zzak(paramLong);
  }
  
  public final void zzatu()
  {
    zzccw.zzatu();
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void zzatv()
  {
    zzcax.zzawk();
  }
}
