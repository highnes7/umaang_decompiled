package com.google.android.android.common.package_9.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions;

public final class zzbx<O extends Api.ApiOptions>
  extends com.google.android.gms.common.api.internal.zzan
{
  public final com.google.android.gms.common.api.GoogleApi<O> zzfoh;
  
  public zzbx(com.google.android.android.common.package_9.GoogleApi paramGoogleApi)
  {
    super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
    zzfoh = paramGoogleApi;
  }
  
  public final Logger d(Logger paramLogger)
  {
    return zzfoh.log(paramLogger);
  }
  
  public final void ensureInitialized(zzdg paramZzdg) {}
  
  public final Logger get(Logger paramLogger)
  {
    return zzfoh.create(paramLogger);
  }
  
  public final Context getContext()
  {
    return zzfoh.getApplicationContext();
  }
  
  public final Looper getLooper()
  {
    return zzfoh.getLooper();
  }
  
  public final void removeAccount(zzdg paramZzdg) {}
}
