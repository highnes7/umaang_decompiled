package com.google.android.android.common.package_9;

import com.google.android.android.common.internal.zzbp;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zzh;
import com.google.android.gms.common.api.Api.zzi;

public final class Sample<O extends Api.ApiOptions>
{
  public final String mName;
  public final com.google.android.gms.common.api.Api.zza<?, O> zzfgf;
  public final Api.zzh<?, O> zzfgg;
  public final com.google.android.gms.common.api.Api.zzf<?> zzfgh;
  public final Api.zzi<?> zzfgi;
  
  public Sample(String paramString, Api.zza paramZza, Api.zzf paramZzf)
  {
    zzbp.get(paramZza, "Cannot construct an Api with a null ClientBuilder");
    zzbp.get(paramZzf, "Cannot construct an Api with a null ClientKey");
    mName = paramString;
    zzfgf = paramZza;
    zzfgg = null;
    zzfgh = paramZzf;
    zzfgi = null;
  }
  
  public final String getName()
  {
    return mName;
  }
  
  public final Api.zzd zzafc()
  {
    return zzfgf;
  }
  
  public final Api.zza zzafd()
  {
    boolean bool;
    if (zzfgf != null) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.append(bool, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
    return zzfgf;
  }
  
  public final Api.zzc zzafe()
  {
    Api.zzf localZzf = zzfgh;
    if (localZzf != null) {
      return localZzf;
    }
    throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
  }
}
