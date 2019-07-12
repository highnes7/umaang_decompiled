package com.google.android.android.common.package_9.internal;

import android.os.RemoteException;
import com.google.android.android.common.package_9.ApiException;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.tasks.TaskCompletionSource;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.internal.zzb;
import com.google.android.gms.common.api.internal.zzdn;
import java.util.Map;

public final class Quaternion
  extends zzb<Void>
{
  public com.google.android.gms.common.api.internal.zzcr<Api.zzb, ?> zzfid;
  public zzdn<Api.zzb, ?> zzfie;
  
  public Quaternion(zzcs paramZzcs, TaskCompletionSource paramTaskCompletionSource)
  {
    super(3, paramTaskCompletionSource);
    zzfid = zzfid;
    zzfie = zzfie;
  }
  
  public final void add(Status paramStatus)
  {
    zzdzc.trySetException(new ApiException(paramStatus));
  }
  
  public final void multiply(zzbr paramZzbr)
    throws RemoteException
  {
    zzfid.applyUpdate(paramZzbr.zzagn(), zzdzc);
    if (zzfid.zzaik() != null) {
      paramZzbr.zzahw().put(zzfid.zzaik(), new zzcs(zzfid, zzfie));
    }
  }
}
