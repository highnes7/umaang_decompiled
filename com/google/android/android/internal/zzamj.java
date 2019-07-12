package com.google.android.android.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.android.analytics.TerminalManager;
import com.google.android.android.common.internal.zzbp;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class zzamj
  extends zzams
{
  public final zzang zzdnv;
  
  public zzamj(zzamu paramZzamu, zzamw paramZzamw)
  {
    super(paramZzamu);
    zzbp.append(paramZzamw);
    zzdnv = new zzang(paramZzamu, paramZzamw);
  }
  
  public final void addKey(zzaob paramZzaob)
  {
    zzwk();
    zzwa().d(new zzamp(this, paramZzaob));
  }
  
  public final long getThreadId(zzamx paramZzamx)
  {
    zzwk();
    zzbp.append(paramZzamx);
    TerminalManager.zzuj();
    long l = zzdnv.insert(paramZzamx, true);
    if (l == 0L) {
      zzdnv.getThreadId(paramZzamx);
    }
    return l;
  }
  
  public final void onServiceConnected()
  {
    TerminalManager.zzuj();
    zzdnv.onServiceConnected();
  }
  
  public final void removeKey(zzaoi paramZzaoi)
  {
    zzbp.append(paramZzaoi);
    zzwk();
    add("Hit delivery requested", paramZzaoi);
    zzwa().d(new zzamn(this, paramZzaoi));
  }
  
  public final void removeKey(String paramString, Runnable paramRunnable)
  {
    zzbp.format(paramString, "campaign param can't be empty");
    zzwa().d(new zzamm(this, paramString, paramRunnable));
  }
  
  public final void setLocalDispatchPeriod(int paramInt)
  {
    zzwk();
    add("setLocalDispatchPeriod (sec)", Integer.valueOf(paramInt));
    zzwa().d(new zzamk(this, paramInt));
  }
  
  public final void start()
  {
    zzdnv.start();
  }
  
  public final void zzuk()
  {
    zzdnv.initialize();
  }
  
  public final void zzvr()
  {
    zzwk();
    zzwa().d(new zzamo(this));
  }
  
  public final void zzvs()
  {
    zzwk();
    Context localContext = getContext();
    if ((zzaou.zzbe(localContext)) && (zzaov.zzbi(localContext)))
    {
      Intent localIntent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
      localIntent.setComponent(new ComponentName(localContext, "com.google.android.gms.analytics.AnalyticsService"));
      localContext.startService(localIntent);
      return;
    }
    addKey(null);
  }
  
  public final boolean zzvt()
  {
    zzwk();
    Future localFuture = zzwa().execute(new zzamq(this));
    TimeUnit localTimeUnit = TimeUnit.SECONDS;
    try
    {
      localFuture.get(4L, localTimeUnit);
      return true;
    }
    catch (TimeoutException localTimeoutException)
    {
      append("syncDispatchLocalHits timed out", localTimeoutException);
      return false;
    }
    catch (ExecutionException localExecutionException)
    {
      toString("syncDispatchLocalHits failed", localExecutionException);
      return false;
    }
    catch (InterruptedException localInterruptedException)
    {
      append("syncDispatchLocalHits interrupted", localInterruptedException);
    }
    return false;
  }
  
  public final void zzvu()
  {
    zzwk();
    TerminalManager.zzuj();
    zzang localZzang = zzdnv;
    TerminalManager.zzuj();
    localZzang.zzwk();
    localZzang.zzdm("Service disconnected");
  }
  
  public final void zzvv()
  {
    TerminalManager.zzuj();
    zzdnv.zzvv();
  }
}
