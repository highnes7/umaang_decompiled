package com.google.android.android.internal;

public final class DefaultRetryPolicy
  implements RetryPolicy
{
  public final float mBackoffMultiplier = 1.0F;
  public int mCurrentRetryCount;
  public int mCurrentTimeoutMs = 2500;
  public final int mMaxNumRetries = 1;
  
  public DefaultRetryPolicy()
  {
    this(2500, 1, 1.0F);
  }
  
  public DefaultRetryPolicy(int paramInt1, int paramInt2, float paramFloat) {}
  
  public final int getCurrentRetryCount()
  {
    return mCurrentRetryCount;
  }
  
  public final int getCurrentTimeout()
  {
    return mCurrentTimeoutMs;
  }
  
  public final void retry(zzaa paramZzaa)
    throws zzaa
  {
    int j = mCurrentRetryCount;
    int i = 1;
    mCurrentRetryCount = (j + 1);
    j = mCurrentTimeoutMs;
    float f = j;
    mCurrentTimeoutMs = ((int)(j * mBackoffMultiplier + f));
    if (mCurrentRetryCount > mMaxNumRetries) {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    throw paramZzaa;
  }
}
