package com.google.android.android.common.package_9.internal;

import android.os.Looper;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.Releasable;
import com.google.android.android.common.package_9.Status;
import com.google.android.gms.common.api.ResultCallback;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

public final class zzdg<R extends com.google.android.gms.common.api.Result>
  extends com.google.android.gms.common.api.TransformedResult<R>
  implements ResultCallback<R>
{
  public final Object zzfjf = new Object();
  public final WeakReference<com.google.android.gms.common.api.GoogleApiClient> zzfjh;
  public com.google.android.gms.common.api.ResultTransform<? super R, ? extends com.google.android.gms.common.api.Result> zzfph = null;
  public com.google.android.gms.common.api.internal.zzdg<? extends com.google.android.gms.common.api.Result> zzfpi = null;
  public volatile com.google.android.gms.common.api.ResultCallbacks<? super R> zzfpj = null;
  public com.google.android.gms.common.api.PendingResult<R> zzfpk = null;
  public Status zzfpl = null;
  public final com.google.android.gms.common.api.internal.zzdi zzfpm;
  public boolean zzfpn = false;
  
  public zzdg(WeakReference paramWeakReference)
  {
    zzbp.get(paramWeakReference, "GoogleApiClient reference must not be null");
    zzfjh = paramWeakReference;
    paramWeakReference = (com.google.android.android.common.package_9.GoogleApiClient)zzfjh.get();
    if (paramWeakReference != null) {
      paramWeakReference = paramWeakReference.getLooper();
    } else {
      paramWeakReference = Looper.getMainLooper();
    }
    zzfpm = new zzdi(this, paramWeakReference);
  }
  
  private final void add(Status paramStatus)
  {
    Object localObject = zzfjf;
    try
    {
      zzfpl = paramStatus;
      enqueue(zzfpl);
      return;
    }
    catch (Throwable paramStatus)
    {
      throw paramStatus;
    }
  }
  
  private final void enqueue(Status paramStatus)
  {
    Object localObject = zzfjf;
    try
    {
      if (zzfph != null)
      {
        paramStatus = zzfph.onFailure(paramStatus);
        zzbp.get(paramStatus, "onFailure must not return null");
        zzfpi.add(paramStatus);
      }
      else if (zzaip())
      {
        zzfpj.onFailure(paramStatus);
      }
      return;
    }
    catch (Throwable paramStatus)
    {
      throw paramStatus;
    }
  }
  
  public static void parse(com.google.android.android.common.package_9.Result paramResult)
  {
    if ((paramResult instanceof Releasable))
    {
      try
      {
        ((Releasable)paramResult).release();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        StringBuilder localStringBuilder;
        for (;;) {}
      }
      paramResult = String.valueOf(paramResult);
      localStringBuilder = new StringBuilder(paramResult.length() + 18);
      localStringBuilder.append("Unable to release ");
      localStringBuilder.append(paramResult);
      localStringBuilder.toString();
      return;
    }
  }
  
  private final void zzain()
  {
    if ((zzfph == null) && (zzfpj == null)) {
      return;
    }
    Object localObject = (com.google.android.android.common.package_9.GoogleApiClient)zzfjh.get();
    if ((!zzfpn) && (zzfph != null) && (localObject != null))
    {
      ((com.google.android.android.common.package_9.GoogleApiClient)localObject).ensureInitialized(this);
      zzfpn = true;
    }
    localObject = zzfpl;
    if (localObject != null)
    {
      enqueue((Status)localObject);
      return;
    }
    localObject = zzfpk;
    if (localObject != null) {
      ((com.google.android.android.common.package_9.PendingResult)localObject).setResultCallback(this);
    }
  }
  
  private final boolean zzaip()
  {
    com.google.android.android.common.package_9.GoogleApiClient localGoogleApiClient = (com.google.android.android.common.package_9.GoogleApiClient)zzfjh.get();
    return (zzfpj != null) && (localGoogleApiClient != null);
  }
  
  public final void andFinally(com.google.android.android.common.package_9.ResultCallbacks paramResultCallbacks)
  {
    Object localObject = zzfjf;
    for (;;)
    {
      try
      {
        com.google.android.android.common.package_9.ResultCallbacks localResultCallbacks = zzfpj;
        boolean bool2 = true;
        if (localResultCallbacks == null)
        {
          bool1 = true;
          zzbp.append(bool1, "Cannot call andFinally() twice.");
          if (zzfph != null) {
            break label75;
          }
          bool1 = bool2;
          zzbp.append(bool1, "Cannot call then() and andFinally() on the same TransformedResult.");
          zzfpj = paramResultCallbacks;
          zzain();
          return;
        }
      }
      catch (Throwable paramResultCallbacks)
      {
        throw paramResultCallbacks;
      }
      boolean bool1 = false;
      continue;
      label75:
      bool1 = false;
    }
  }
  
  public final void onResult(com.google.android.android.common.package_9.Result paramResult)
  {
    Object localObject = zzfjf;
    try
    {
      if (paramResult.getStatus().isSuccess())
      {
        if (zzfph != null) {
          zzct.zzfnj.submit(new zzdh(this, paramResult));
        } else if (zzaip()) {
          zzfpj.onSuccess(paramResult);
        }
      }
      else
      {
        add(paramResult.getStatus());
        parse(paramResult);
      }
      return;
    }
    catch (Throwable paramResult)
    {
      throw paramResult;
    }
  }
  
  public final void onResultReceived(com.google.android.android.common.package_9.PendingResult paramPendingResult)
  {
    Object localObject = zzfjf;
    try
    {
      zzfpk = paramPendingResult;
      zzain();
      return;
    }
    catch (Throwable paramPendingResult)
    {
      throw paramPendingResult;
    }
  }
  
  public final com.google.android.android.common.package_9.TransformedResult then(com.google.android.android.common.package_9.ResultTransform paramResultTransform)
  {
    Object localObject = zzfjf;
    for (;;)
    {
      try
      {
        com.google.android.android.common.package_9.ResultTransform localResultTransform = zzfph;
        boolean bool2 = true;
        if (localResultTransform == null)
        {
          bool1 = true;
          zzbp.append(bool1, "Cannot call then() twice.");
          if (zzfpj != null) {
            break label93;
          }
          bool1 = bool2;
          zzbp.append(bool1, "Cannot call then() and andFinally() on the same TransformedResult.");
          zzfph = paramResultTransform;
          paramResultTransform = new zzdg(zzfjh);
          zzfpi = paramResultTransform;
          zzain();
          return paramResultTransform;
        }
      }
      catch (Throwable paramResultTransform)
      {
        throw paramResultTransform;
      }
      boolean bool1 = false;
      continue;
      label93:
      bool1 = false;
    }
  }
  
  public final void zzaio()
  {
    zzfpj = null;
  }
}
