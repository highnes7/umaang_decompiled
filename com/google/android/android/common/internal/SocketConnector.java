package com.google.android.android.common.internal;

import android.os.Bundle;
import com.google.android.android.common.ConnectionResult;
import com.google.android.gms.common.internal.zze;

public final class SocketConnector
  extends zze
{
  public SocketConnector(TaskManager paramTaskManager, int paramInt, Bundle paramBundle)
  {
    super(paramTaskManager, paramInt, null);
  }
  
  public final void startConnection(ConnectionResult paramConnectionResult)
  {
    zzftl.zzfsx.notifyProgress(paramConnectionResult);
    zzftl.onConnectionFailed(paramConnectionResult);
  }
  
  public final boolean zzajn()
  {
    zzftl.zzfsx.notifyProgress(ConnectionResult.zzfff);
    return true;
  }
}
