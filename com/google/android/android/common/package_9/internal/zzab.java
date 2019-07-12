package com.google.android.android.common.package_9.internal;

import android.os.Bundle;
import com.google.android.android.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

public final class zzab
  implements zzce
{
  public zzab(TaskManager paramTaskManager) {}
  
  public final void removeTask(Bundle paramBundle)
  {
    zzfkg.zzfke.lock();
    try
    {
      zzfkg.zzfkc = ConnectionResult.zzfff;
      TaskManager.removeTask(zzfkg);
      zzfkg.zzfke.unlock();
      return;
    }
    catch (Throwable paramBundle)
    {
      zzfkg.zzfke.unlock();
      throw paramBundle;
    }
  }
  
  public final void removeTask(ConnectionResult paramConnectionResult)
  {
    zzfkg.zzfke.lock();
    try
    {
      zzfkg.zzfkc = paramConnectionResult;
      TaskManager.removeTask(zzfkg);
      zzfkg.zzfke.unlock();
      return;
    }
    catch (Throwable paramConnectionResult)
    {
      zzfkg.zzfke.unlock();
      throw paramConnectionResult;
    }
  }
  
  public final void setSorting(int paramInt, boolean paramBoolean)
  {
    zzfkg.zzfke.lock();
    try
    {
      boolean bool = zzfkg.zzfkd;
      if (bool)
      {
        zzfkg.zzfkd = false;
        TaskManager.setSorting(zzfkg, paramInt, paramBoolean);
        zzfkg.zzfke.unlock();
        return;
      }
      zzfkg.zzfkd = true;
      zzfkg.zzfjv.onConnectionSuspended(paramInt);
      zzfkg.zzfke.unlock();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzfkg.zzfke.unlock();
      throw localThrowable;
    }
  }
}
