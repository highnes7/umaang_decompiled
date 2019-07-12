package com.google.android.android.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class zzdjs
{
  public final ConcurrentHashMap<com.google.android.gms.internal.zzdjt, List<Throwable>> zzlhz = new ConcurrentHashMap(16, 0.75F, 10);
  public final ReferenceQueue<Throwable> zzlia = new ReferenceQueue();
  
  public zzdjs() {}
  
  public final List get(Throwable paramThrowable, boolean paramBoolean)
  {
    for (;;)
    {
      Reference localReference = zzlia.poll();
      if (localReference == null) {
        break;
      }
      zzlhz.remove(localReference);
    }
    paramThrowable = new zzdjt(paramThrowable, null);
    return (List)zzlhz.get(paramThrowable);
  }
}
