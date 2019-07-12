package com.google.android.android.auth.dashclock.signin.internal;

import android.os.RemoteException;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.common.package_9.internal.Log;

public final class DiskLruCache
  extends ArrayAdapter
{
  public DiskLruCache(Gson paramGson) {}
  
  public final void close(Status paramStatus)
    throws RemoteException
  {
    zzecx.setResult(paramStatus);
  }
}
