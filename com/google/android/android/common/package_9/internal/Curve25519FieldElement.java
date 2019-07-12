package com.google.android.android.common.package_9.internal;

import android.os.RemoteException;
import com.google.android.android.common.package_9.ApiException;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.tasks.TaskCompletionSource;
import com.google.android.gms.common.api.internal.zzb;
import java.util.Map;

public final class Curve25519FieldElement
  extends zzb<Boolean>
{
  public com.google.android.gms.common.api.internal.zzcl<?> zzfih;
  
  public Curve25519FieldElement(zzcl paramZzcl, TaskCompletionSource paramTaskCompletionSource)
  {
    super(4, paramTaskCompletionSource);
    zzfih = paramZzcl;
  }
  
  public final void add(Status paramStatus)
  {
    zzdzc.trySetException(new ApiException(paramStatus));
  }
  
  public final void multiply(zzbr paramZzbr)
    throws RemoteException
  {
    zzcs localZzcs = (zzcs)paramZzbr.zzahw().remove(zzfih);
    if (localZzcs != null)
    {
      zzfie.showContextMenu(paramZzbr.zzagn(), zzdzc);
      zzfid.zzail();
      return;
    }
    zzdzc.trySetResult(Boolean.valueOf(false));
  }
}
