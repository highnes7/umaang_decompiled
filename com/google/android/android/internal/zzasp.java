package com.google.android.android.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import b.b.a.G;
import com.google.android.android.auth.dashclock.Auth.AuthCredentialsOptions;
import com.google.android.android.common.internal.AccountInformation;
import com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzasu;

public final class zzasp
  extends com.google.android.gms.common.internal.zzaa<zzasu>
{
  @G
  public final Auth.AuthCredentialsOptions zzebl;
  
  public zzasp(Context paramContext, Looper paramLooper, AccountInformation paramAccountInformation, Auth.AuthCredentialsOptions paramAuthCredentialsOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 68, paramAccountInformation, paramConnectionCallbacks, paramOnConnectionFailedListener);
    zzebl = paramAuthCredentialsOptions;
  }
  
  public final Auth.AuthCredentialsOptions zzaab()
  {
    return zzebl;
  }
  
  public final String zzhc()
  {
    return "com.google.android.gms.auth.api.credentials.service.START";
  }
  
  public final String zzhd()
  {
    return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
  }
  
  public final Bundle zzzu()
  {
    Auth.AuthCredentialsOptions localAuthCredentialsOptions = zzebl;
    if (localAuthCredentialsOptions == null) {
      return new Bundle();
    }
    return localAuthCredentialsOptions.zzzu();
  }
}
