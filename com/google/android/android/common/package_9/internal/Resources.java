package com.google.android.android.common.package_9.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.android.common.package_9.Status;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.internal.zza;

public final class Resources<TResult>
  extends zza
{
  public final com.google.android.gms.tasks.TaskCompletionSource<TResult> zzdzc;
  public final com.google.android.gms.common.api.internal.zzdd<Api.zzb, TResult> zzfif;
  public final zzcz zzfig;
  
  public Resources(int paramInt, zzdd paramZzdd, com.google.android.android.tasks.TaskCompletionSource paramTaskCompletionSource, zzcz paramZzcz)
  {
    super(paramInt);
    zzdzc = paramTaskCompletionSource;
    zzfif = paramZzdd;
    zzfig = paramZzcz;
  }
  
  public final void add(Status paramStatus)
  {
    zzdzc.trySetException(zzfig.apply(paramStatus));
  }
  
  public final void add(zzah paramZzah, boolean paramBoolean)
  {
    paramZzah.setPriority(zzdzc, paramBoolean);
  }
  
  public final void add(zzbr paramZzbr)
    throws DeadObjectException
  {
    zzdd localZzdd = zzfif;
    try
    {
      paramZzbr = paramZzbr.zzagn();
      com.google.android.android.tasks.TaskCompletionSource localTaskCompletionSource = zzdzc;
      localZzdd.blur(paramZzbr, localTaskCompletionSource);
      return;
    }
    catch (RemoteException paramZzbr)
    {
      add(Vector.create(paramZzbr));
      return;
    }
    catch (DeadObjectException paramZzbr)
    {
      throw paramZzbr;
    }
  }
}
