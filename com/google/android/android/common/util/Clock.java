package com.google.android.android.common.util;

import android.os.SystemClock;

public final class Clock
  implements Log
{
  public static Clock zzfyr = new Clock();
  
  public Clock() {}
  
  public static Log zzalc()
  {
    return zzfyr;
  }
  
  public final long currentTimeMillis()
  {
    return System.currentTimeMillis();
  }
  
  public final long elapsedRealtime()
  {
    return SystemClock.elapsedRealtime();
  }
  
  public final long nanoTime()
  {
    return System.nanoTime();
  }
}
