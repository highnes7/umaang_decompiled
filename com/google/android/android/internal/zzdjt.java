package com.google.android.android.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public final class zzdjt
  extends WeakReference<Throwable>
{
  public final int zzlib;
  
  public zzdjt(Throwable paramThrowable, ReferenceQueue paramReferenceQueue)
  {
    super(paramThrowable, null);
    if (paramThrowable != null)
    {
      zzlib = System.identityHashCode(paramThrowable);
      return;
    }
    throw new NullPointerException("The referent cannot be null");
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      if (paramObject.getClass() != com.google.android.gms.internal.zzdjt.class) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (zzdjt)paramObject;
      if ((zzlib == zzlib) && (get() == paramObject.get())) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    return zzlib;
  }
}
