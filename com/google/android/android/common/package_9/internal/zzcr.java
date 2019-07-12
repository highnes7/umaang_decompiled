package com.google.android.android.common.package_9.internal;

import android.os.RemoteException;
import com.google.android.android.tasks.TaskCompletionSource;

public abstract class zzcr<A extends com.google.android.gms.common.api.Api.zzb, L>
{
  public final com.google.android.gms.common.api.internal.zzcj<L> zzfpc;
  
  public zzcr(zzcj paramZzcj)
  {
    zzfpc = paramZzcj;
  }
  
  public abstract void applyUpdate(com.google.android.android.common.package_9.Api.zzb paramZzb, TaskCompletionSource paramTaskCompletionSource)
    throws RemoteException;
  
  public final zzcl zzaik()
  {
    return zzfpc.zzaik();
  }
  
  public final void zzail()
  {
    zzfpc.clear();
  }
}
