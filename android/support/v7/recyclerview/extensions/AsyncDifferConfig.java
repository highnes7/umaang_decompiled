package android.support.v7.recyclerview.extensions;

import android.support.v7.util.DiffUtil.ItemCallback;
import b.b.a.F;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class AsyncDifferConfig<T>
{
  @F
  public final Executor mBackgroundThreadExecutor;
  @F
  public final DiffUtil.ItemCallback<T> mDiffCallback;
  @F
  public final Executor mMainThreadExecutor;
  
  public AsyncDifferConfig(Executor paramExecutor1, Executor paramExecutor2, DiffUtil.ItemCallback paramItemCallback)
  {
    mMainThreadExecutor = paramExecutor1;
    mBackgroundThreadExecutor = paramExecutor2;
    mDiffCallback = paramItemCallback;
  }
  
  public Executor getBackgroundThreadExecutor()
  {
    return mBackgroundThreadExecutor;
  }
  
  public DiffUtil.ItemCallback getDiffCallback()
  {
    return mDiffCallback;
  }
  
  public Executor getMainThreadExecutor()
  {
    return mMainThreadExecutor;
  }
  
  public static final class Builder<T>
  {
    public static Executor sDiffExecutor = null;
    public static final Object sExecutorLock = new Object();
    public Executor mBackgroundThreadExecutor;
    public final DiffUtil.ItemCallback<T> mDiffCallback;
    public Executor mMainThreadExecutor;
    
    public Builder(DiffUtil.ItemCallback paramItemCallback)
    {
      mDiffCallback = paramItemCallback;
    }
    
    public AsyncDifferConfig build()
    {
      if (mBackgroundThreadExecutor == null)
      {
        Object localObject = sExecutorLock;
        try
        {
          if (sDiffExecutor == null) {
            sDiffExecutor = Executors.newFixedThreadPool(2);
          }
          mBackgroundThreadExecutor = sDiffExecutor;
        }
        catch (Throwable localThrowable)
        {
          throw localThrowable;
        }
      }
      return new AsyncDifferConfig(mMainThreadExecutor, mBackgroundThreadExecutor, mDiffCallback);
    }
    
    public Builder setBackgroundThreadExecutor(Executor paramExecutor)
    {
      mBackgroundThreadExecutor = paramExecutor;
      return this;
    }
    
    public Builder setMainThreadExecutor(Executor paramExecutor)
    {
      mMainThreadExecutor = paramExecutor;
      return this;
    }
  }
}
