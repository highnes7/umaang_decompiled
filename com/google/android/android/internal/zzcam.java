package com.google.android.android.internal;

import android.os.Looper;
import com.google.android.android.common.internal.zzbp;

public final class zzcam
{
  public static Looper getElementValue(Looper paramLooper)
  {
    if (paramLooper != null) {
      return paramLooper;
    }
    return zzatk();
  }
  
  public static Looper zzatk()
  {
    boolean bool;
    if (Looper.myLooper() != null) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.append(bool, "Can't create handler inside thread that has not called Looper.prepare()");
    return Looper.myLooper();
  }
}
