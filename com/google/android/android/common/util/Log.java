package com.google.android.android.common.util;

public abstract interface Log
{
  public abstract long currentTimeMillis();
  
  public abstract long elapsedRealtime();
  
  public abstract long nanoTime();
}
