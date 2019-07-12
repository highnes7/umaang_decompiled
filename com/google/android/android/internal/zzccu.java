package com.google.android.android.internal;

import com.google.android.android.common.internal.zzbp;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

public final class zzccu<V>
  extends FutureTask<V>
  implements Comparable<com.google.android.gms.internal.zzccu>
{
  public final String zzisl;
  public final long zzisn;
  public final boolean zziso;
  
  public zzccu(zzccr paramZzccr, Runnable paramRunnable, boolean paramBoolean, String paramString)
  {
    super(paramRunnable, null);
    zzbp.append(paramString);
    zzisn = zzccr.zzisk.getAndIncrement();
    zzisl = paramString;
    zziso = false;
    if (zzisn == Long.MAX_VALUE) {
      paramZzccr.zzaul().zzayd().append("Tasks index overflow");
    }
  }
  
  public zzccu(zzccr paramZzccr, Callable paramCallable, boolean paramBoolean, String paramString)
  {
    super(paramCallable);
    zzbp.append(paramString);
    zzisn = zzccr.zzisk.getAndIncrement();
    zzisl = paramString;
    zziso = paramBoolean;
    if (zzisn == Long.MAX_VALUE) {
      paramZzccr.zzaul().zzayd().append("Tasks index overflow");
    }
  }
  
  public final void setException(Throwable paramThrowable)
  {
    zzism.zzaul().zzayd().append(zzisl, paramThrowable);
    if ((paramThrowable instanceof zzccs)) {
      Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), paramThrowable);
    }
    super.setException(paramThrowable);
  }
}
