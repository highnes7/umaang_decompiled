package com.google.android.android.common.package_9;

import android.os.Looper;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.internal.Log;
import com.google.android.android.common.package_9.internal.zzcp;
import com.google.android.android.common.package_9.internal.zzda;
import com.google.android.gms.common.api.internal.zzs;

public final class PendingResults
{
  public PendingResults() {}
  
  public static PendingResult addFiles(Status paramStatus, GoogleApiClient paramGoogleApiClient)
  {
    zzbp.get(paramStatus, "Result must not be null");
    paramGoogleApiClient = new zzda(paramGoogleApiClient);
    paramGoogleApiClient.setResult(paramStatus);
    return paramGoogleApiClient;
  }
  
  public static PendingResult canceledPendingResult()
  {
    zzda localZzda = new zzda(Looper.getMainLooper());
    localZzda.cancel();
    return localZzda;
  }
  
  public static PendingResult canceledPendingResult(Result paramResult)
  {
    zzbp.get(paramResult, "Result must not be null");
    boolean bool;
    if (paramResult.getStatus().getStatusCode() == 16) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.get(bool, "Status code must be CommonStatusCodes.CANCELED");
    paramResult = new zza();
    paramResult.cancel();
    return paramResult;
  }
  
  public static OptionalPendingResult handleResult(Result paramResult, GoogleApiClient paramGoogleApiClient)
  {
    zzbp.get(paramResult, "Result must not be null");
    paramGoogleApiClient = new zzc(paramGoogleApiClient);
    paramGoogleApiClient.setResult(paramResult);
    return new zzcp(paramGoogleApiClient);
  }
  
  public static OptionalPendingResult immediatePendingResult(Result paramResult)
  {
    zzbp.get(paramResult, "Result must not be null");
    zzc localZzc = new zzc(null);
    localZzc.setResult(paramResult);
    return new zzcp(localZzc);
  }
  
  public static PendingResult immediatePendingResult(Status paramStatus)
  {
    zzbp.get(paramStatus, "Result must not be null");
    zzda localZzda = new zzda(Looper.getMainLooper());
    localZzda.setResult(paramStatus);
    return localZzda;
  }
  
  public static PendingResult parse(Result paramResult, GoogleApiClient paramGoogleApiClient)
  {
    zzbp.get(paramResult, "Result must not be null");
    zzbp.get(paramResult.getStatus().isSuccess() ^ true, "Status code must not be SUCCESS");
    paramGoogleApiClient = new zzb(paramGoogleApiClient, paramResult);
    paramGoogleApiClient.setResult(paramResult);
    return paramGoogleApiClient;
  }
  
  public final class zza<R extends com.google.android.gms.common.api.Result>
    extends zzs<R>
  {
    public zza()
    {
      super();
    }
    
    public final Result getSheet(Status paramStatus)
    {
      if (paramStatus.getStatusCode() == getStatus().getStatusCode()) {
        return PendingResults.this;
      }
      throw new UnsupportedOperationException("Creating failed results is not supported");
    }
  }
  
  public final class zzb<R extends com.google.android.gms.common.api.Result>
    extends zzs<R>
  {
    public final R zzfhr;
    
    public zzb(Result paramResult)
    {
      super();
      zzfhr = paramResult;
    }
    
    public final Result getSheet(Status paramStatus)
    {
      return zzfhr;
    }
  }
  
  public final class zzc<R extends com.google.android.gms.common.api.Result>
    extends zzs<R>
  {
    public zzc()
    {
      super();
    }
    
    public final Result getSheet(Status paramStatus)
    {
      throw new UnsupportedOperationException("Creating failed results is not supported");
    }
  }
}
