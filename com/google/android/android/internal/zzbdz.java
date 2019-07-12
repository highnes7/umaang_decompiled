package com.google.android.android.internal;

import com.google.android.android.common.internal.zzbp;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzbdz
  implements ThreadFactory
{
  public final int mPriority;
  public final String zzfzn;
  public final AtomicInteger zzfzo = new AtomicInteger();
  public final ThreadFactory zzfzp = Executors.defaultThreadFactory();
  
  public zzbdz(String paramString)
  {
    this(paramString, 0);
  }
  
  public zzbdz(String paramString, int paramInt)
  {
    zzbp.get(paramString, "Name must not be null");
    zzfzn = ((String)paramString);
    mPriority = 0;
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = zzfzp.newThread(new zzbea(paramRunnable, 0));
    String str = zzfzn;
    int i = zzfzo.getAndIncrement();
    StringBuilder localStringBuilder = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(str, 13));
    localStringBuilder.append(str);
    localStringBuilder.append("[");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    paramRunnable.setName(localStringBuilder.toString());
    return paramRunnable;
  }
}
