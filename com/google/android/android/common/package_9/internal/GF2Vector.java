package com.google.android.android.common.package_9.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.android.common.package_9.ApiException;
import com.google.android.android.common.package_9.Status;
import com.google.android.gms.common.api.internal.zza;

public abstract class GF2Vector<T>
  extends zza
{
  public final com.google.android.gms.tasks.TaskCompletionSource<T> zzdzc;
  
  public GF2Vector(int paramInt, com.google.android.android.tasks.TaskCompletionSource paramTaskCompletionSource)
  {
    super(paramInt);
    zzdzc = paramTaskCompletionSource;
  }
  
  public void add(Status paramStatus)
  {
    zzdzc.trySetException(new ApiException(paramStatus));
  }
  
  public void add(zzah paramZzah, boolean paramBoolean) {}
  
  public final void add(zzbr paramZzbr)
    throws DeadObjectException
  {
    try
    {
      multiply(paramZzbr);
      return;
    }
    catch (RemoteException paramZzbr)
    {
      add(Vector.create(paramZzbr));
      return;
    }
    catch (DeadObjectException paramZzbr)
    {
      add(Vector.create(paramZzbr));
      throw paramZzbr;
    }
  }
  
  public abstract void multiply(zzbr paramZzbr)
    throws RemoteException;
}
