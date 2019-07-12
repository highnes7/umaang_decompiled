package com.google.android.android.auth.dashclock.signin.internal;

import android.content.Context;
import b.b.x.b.a;
import com.google.android.gms.common.api.internal.zzcv;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import support.android.v4.content.AsyncTaskLoader;
import support.android.v4.content.Loader;

public final class AccountLoader
  extends a<Void>
  implements zzcv
{
  public Semaphore zzecq = new Semaphore(0);
  public Set<com.google.android.gms.common.api.GoogleApiClient> zzecr;
  
  public AccountLoader(Context paramContext, Set paramSet)
  {
    super(paramContext);
    zzecr = paramSet;
  }
  
  private final Void zzaaj()
  {
    Object localObject = zzecr.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext()) {
      if (((com.google.android.android.common.package_9.GoogleApiClient)((Iterator)localObject).next()).deleteAccount(this)) {
        i += 1;
      }
    }
    localObject = zzecq;
    TimeUnit localTimeUnit = TimeUnit.SECONDS;
    try
    {
      ((Semaphore)localObject).tryAcquire(i, 5L, localTimeUnit);
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
    Thread.currentThread().interrupt();
    return null;
  }
  
  public final void onStartLoading()
  {
    zzecq.drainPermits();
    forceLoad();
  }
  
  public final void zzaak()
  {
    zzecq.release();
  }
}
