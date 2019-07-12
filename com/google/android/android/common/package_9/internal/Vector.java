package com.google.android.android.common.package_9.internal;

import android.os.Build.VERSION;
import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.android.common.package_9.Status;

public abstract class Vector
{
  public int zzecz;
  
  public Vector(int paramInt)
  {
    zzecz = paramInt;
  }
  
  public static Status create(RemoteException paramRemoteException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = Build.VERSION.SDK_INT;
    if ((paramRemoteException instanceof TransactionTooLargeException)) {
      localStringBuilder.append("TransactionTooLargeException: ");
    }
    localStringBuilder.append(paramRemoteException.getLocalizedMessage());
    return new Status(8, localStringBuilder.toString());
  }
  
  public abstract void add(Status paramStatus);
  
  public abstract void add(zzah paramZzah, boolean paramBoolean);
  
  public abstract void add(zzbr paramZzbr)
    throws DeadObjectException;
}
