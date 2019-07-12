package com.google.android.android.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.android.common.internal.zzbp;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class HttpRequest
  implements ServiceConnection
{
  public boolean zzffd = false;
  public final BlockingQueue<IBinder> zzffe = new LinkedBlockingQueue();
  
  public HttpRequest() {}
  
  public final IBinder getConnection(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, TimeoutException
  {
    zzbp.zzgh("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
    if (!zzffd)
    {
      zzffd = true;
      paramTimeUnit = (IBinder)zzffe.poll(10000L, paramTimeUnit);
      if (paramTimeUnit != null) {
        return paramTimeUnit;
      }
      throw new TimeoutException("Timed out waiting for the service connection");
    }
    throw new IllegalStateException("Cannot call get on this connection more than once");
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    zzffe.add(paramIBinder);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public final IBinder zzaew()
    throws InterruptedException
  {
    zzbp.zzgh("BlockingServiceConnection.getService() called on main thread");
    if (!zzffd)
    {
      zzffd = true;
      return (IBinder)zzffe.take();
    }
    throw new IllegalStateException("Cannot call get on this connection more than once");
  }
}
