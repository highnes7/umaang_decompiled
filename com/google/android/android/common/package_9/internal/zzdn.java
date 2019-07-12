package com.google.android.android.common.package_9.internal;

import android.os.RemoteException;
import com.google.android.android.tasks.TaskCompletionSource;

public abstract class zzdn<A extends com.google.android.gms.common.api.Api.zzb, L>
{
  public final com.google.android.gms.common.api.internal.zzcl<L> zzfov;
  
  public zzdn(zzcl paramZzcl)
  {
    zzfov = paramZzcl;
  }
  
  public abstract void showContextMenu(com.google.android.android.common.package_9.Api.zzb paramZzb, TaskCompletionSource paramTaskCompletionSource)
    throws RemoteException;
  
  public final zzcl zzaik()
  {
    return zzfov;
  }
}
