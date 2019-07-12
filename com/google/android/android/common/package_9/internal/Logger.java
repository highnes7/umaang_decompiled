package com.google.android.android.common.package_9.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.Sample;
import com.google.android.android.common.package_9.Status;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zzn;
import com.google.android.gms.common.api.internal.zzs;

public abstract class Logger<R extends Result, A extends com.google.android.gms.common.api.Api.zzb>
  extends zzs<R>
  implements zzn<R>
{
  public final Api<?> zzfdg;
  public final com.google.android.gms.common.api.Api.zzc<A> zzfiv;
  
  public Logger(com.google.android.android.common.package_9.Api.zzc paramZzc, GoogleApiClient paramGoogleApiClient)
  {
    super((GoogleApiClient)paramGoogleApiClient);
    zzbp.append(paramZzc);
    zzfiv = ((com.google.android.android.common.package_9.Api.zzc)paramZzc);
    zzfdg = null;
  }
  
  public Logger(Sample paramSample, GoogleApiClient paramGoogleApiClient)
  {
    super((GoogleApiClient)paramGoogleApiClient);
    zzfiv = paramSample.zzafe();
    zzfdg = paramSample;
  }
  
  private final void log(RemoteException paramRemoteException)
  {
    remove(new Status(1, 8, paramRemoteException.getLocalizedMessage(), null));
  }
  
  public final void debug(com.google.android.android.common.package_9.Api.zzb paramZzb)
    throws DeadObjectException
  {
    try
    {
      registerRenderer(paramZzb);
      return;
    }
    catch (RemoteException paramZzb)
    {
      log(paramZzb);
      return;
    }
    catch (DeadObjectException paramZzb)
    {
      log(paramZzb);
      throw paramZzb;
    }
  }
  
  public abstract void registerRenderer(com.google.android.android.common.package_9.Api.zzb paramZzb)
    throws RemoteException;
  
  public final void remove(Status paramStatus)
  {
    zzbp.get(paramStatus.isSuccess() ^ true, "Failed result must not be success");
    setResult(getSheet(paramStatus));
  }
  
  public final com.google.android.android.common.package_9.Api.zzc zzafe()
  {
    return zzfiv;
  }
  
  public final Sample zzafj()
  {
    return zzfdg;
  }
}
