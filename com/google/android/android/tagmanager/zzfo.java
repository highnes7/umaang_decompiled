package com.google.android.android.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;

public final class zzfo
  extends zzfn
{
  public static final Object zzjvf = new Object();
  public static zzfo zzjvr;
  public boolean connected = true;
  public Context zzjvg;
  public zzcc zzjvh;
  public volatile zzbz zzjvi;
  public int zzjvj = 1800000;
  public boolean zzjvk = true;
  public boolean zzjvl = false;
  public boolean zzjvm = true;
  public zzcd zzjvn = new zzfp(this);
  public zzfr zzjvo;
  public zzdo zzjvp;
  public boolean zzjvq = false;
  
  public zzfo() {}
  
  private final boolean isPowerSaveMode()
  {
    return (zzjvq) || (!connected) || (zzjvj <= 0);
  }
  
  public static zzfo zzbez()
  {
    if (zzjvr == null) {
      zzjvr = new zzfo();
    }
    return zzjvr;
  }
  
  public final void copyToClipboard(Context paramContext, zzbz paramZzbz)
  {
    try
    {
      Context localContext = zzjvg;
      if (localContext != null) {
        return;
      }
      zzjvg = paramContext.getApplicationContext();
      if (zzjvi == null) {
        zzjvi = paramZzbz;
      }
      return;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public final void dispatch()
  {
    try
    {
      if (!zzjvl)
      {
        zzdj.zzjss.append("Dispatch call queued. Dispatch will run once initialization is complete.");
        zzjvk = true;
        return;
      }
      zzjvi.queueEvent(new zzfq(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void notifyDisconnected(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      boolean bool = isPowerSaveMode();
      zzjvq = paramBoolean1;
      connected = paramBoolean2;
      paramBoolean1 = isPowerSaveMode();
      if (paramBoolean1 == bool) {
        return;
      }
      if (isPowerSaveMode())
      {
        zzjvo.cancel();
        zzdj.zzjss.append("PowerSaveMode initiated.");
        return;
      }
      zzjvo.queueNextRefresh(zzjvj);
      zzdj.zzjss.append("PowerSaveMode terminated.");
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void zzbey()
  {
    try
    {
      if (!isPowerSaveMode()) {
        zzjvo.zzbfc();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final zzcc zzbfa()
  {
    Object localObject1 = this;
    try
    {
      Object localObject2 = zzjvh;
      zzfo localZzfo = this;
      if (localObject2 == null)
      {
        localObject1 = localZzfo;
        if (zzjvg != null)
        {
          localObject1 = localZzfo;
          zzjvh = new zzec(zzjvn, zzjvg);
        }
        else
        {
          localObject1 = localZzfo;
          throw new IllegalStateException("Cant get a store unless we have a context");
        }
      }
      localObject1 = localZzfo;
      if (zzjvo == null)
      {
        localObject1 = localZzfo;
        zzjvo = new zzfs(localZzfo);
        localObject1 = localZzfo;
        if (zzjvj > 0)
        {
          localObject1 = localZzfo;
          zzjvo.queueNextRefresh(zzjvj);
        }
      }
      localObject1 = localZzfo;
      zzjvl = true;
      localObject1 = localZzfo;
      if (zzjvk)
      {
        localObject1 = localZzfo;
        localZzfo.dispatch();
        localObject1 = localZzfo;
        zzjvk = false;
      }
      localObject1 = localZzfo;
      if (zzjvp == null)
      {
        localObject1 = localZzfo;
        if (zzjvm)
        {
          localObject1 = localZzfo;
          zzjvp = new zzdo(localZzfo);
          localObject1 = localZzfo;
          localObject2 = zzjvp;
          localObject1 = localZzfo;
          Context localContext = zzjvg;
          localObject1 = localZzfo;
          IntentFilter localIntentFilter = new IntentFilter();
          localObject1 = localZzfo;
          localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
          localObject1 = localZzfo;
          localContext.registerReceiver((BroadcastReceiver)localObject2, localIntentFilter);
          localObject1 = localZzfo;
          localIntentFilter = new IntentFilter();
          localObject1 = localZzfo;
          localIntentFilter.addAction("com.google.analytics.RADIO_POWERED");
          localObject1 = localZzfo;
          localIntentFilter.addCategory(localContext.getPackageName());
          localObject1 = localZzfo;
          localContext.registerReceiver((BroadcastReceiver)localObject2, localIntentFilter);
        }
      }
      localObject1 = localZzfo;
      localObject2 = zzjvh;
      return localObject2;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void zzbv(boolean paramBoolean)
  {
    try
    {
      notifyDisconnected(zzjvq, paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
