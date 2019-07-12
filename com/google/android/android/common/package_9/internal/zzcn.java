package com.google.android.android.common.package_9.internal;

import android.os.Looper;
import com.google.android.android.common.internal.zzbp;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzcn
{
  public final Set<com.google.android.gms.common.api.internal.zzcj<?>> zzeuk = Collections.newSetFromMap(new WeakHashMap());
  
  public zzcn() {}
  
  public static zzcj d(Object paramObject, Looper paramLooper, String paramString)
  {
    zzbp.get(paramObject, "Listener must not be null");
    zzbp.get(paramLooper, "Looper must not be null");
    zzbp.get(paramString, "Listener type must not be null");
    return new zzcj(paramLooper, paramObject, paramString);
  }
  
  public static zzcl d(Object paramObject, String paramString)
  {
    zzbp.get(paramObject, "Listener must not be null");
    zzbp.get(paramString, "Listener type must not be null");
    zzbp.format(paramString, "Listener type must not be empty");
    return new zzcl(paramObject, paramString);
  }
  
  public final void release()
  {
    Iterator localIterator = zzeuk.iterator();
    while (localIterator.hasNext()) {
      ((zzcj)localIterator.next()).clear();
    }
    zzeuk.clear();
  }
  
  public final zzcj setResolution(Object paramObject, Looper paramLooper, String paramString)
  {
    paramObject = d(paramObject, paramLooper, paramString);
    zzeuk.add(paramObject);
    return paramObject;
  }
}
