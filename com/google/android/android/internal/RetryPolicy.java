package com.google.android.android.internal;

public abstract interface RetryPolicy
{
  public abstract int getCurrentRetryCount();
  
  public abstract int getCurrentTimeout();
  
  public abstract void retry(zzaa paramZzaa)
    throws zzaa;
}
