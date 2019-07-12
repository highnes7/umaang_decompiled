package com.google.android.android.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.android.common.ConnectionResult;
import com.google.android.gms.common.internal.zze;

public final class DeviceActivity
  extends zze
{
  public IBinder zzftp;
  
  public DeviceActivity(TaskManager paramTaskManager, int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    super(paramTaskManager, paramInt, paramBundle);
    zzftp = paramIBinder;
  }
  
  public final void startConnection(ConnectionResult paramConnectionResult)
  {
    if (TaskManager.method_5(zzftl) != null) {
      TaskManager.method_5(zzftl).onConnectionFailed(paramConnectionResult);
    }
    zzftl.onConnectionFailed(paramConnectionResult);
  }
  
  public final boolean zzajn()
  {
    Object localObject = zzftp;
    try
    {
      localObject = ((IBinder)localObject).getInterfaceDescriptor();
      if (!zzftl.zzhd().equals(localObject))
      {
        String str = zzftl.zzhd();
        StringBuilder localStringBuilder = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject, f.sufficientlysecure.rootcommands.util.StringBuilder.append(str, 34)));
        localStringBuilder.append("service descriptor mismatch: ");
        localStringBuilder.append(str);
        localStringBuilder.append(" vs. ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.toString();
        return false;
      }
      localObject = zzftl.handleDataMessage(zzftp);
      if ((localObject != null) && ((TaskManager.getString(zzftl, 2, 4, (IInterface)localObject)) || (TaskManager.getString(zzftl, 3, 4, (IInterface)localObject))))
      {
        TaskManager.disconnect(zzftl, null);
        localObject = zzftl.zzaeh();
        if (TaskManager.doToast(zzftl) != null) {
          TaskManager.doToast(zzftl).onConnected((Bundle)localObject);
        }
        return true;
      }
    }
    catch (RemoteException localRemoteException) {}
    return false;
  }
}
