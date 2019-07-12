package com.google.android.android.internal;

import android.os.RemoteException;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.common.package_9.internal.zzde;
import com.google.android.gms.common.api.internal.zzdd;
import com.google.android.gms.internal.zzati;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzatm
  extends zzdd<zzati, Void>
{
  public TaskCompletionSource<Void> zzdzc;
  
  public zzatm() {}
  
  public final void createGroup(Status paramStatus)
  {
    zzde.status(paramStatus, null, zzdzc);
  }
  
  public abstract void refreshViews(zzate paramZzate)
    throws RemoteException;
}
