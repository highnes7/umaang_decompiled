package com.google.android.android.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.android.common.internal.AccountInformation;
import com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzarm;

public final class zzarl
  extends com.google.android.gms.common.internal.zzaa<zzarm>
{
  public zzarl(Context paramContext, Looper paramLooper, AccountInformation paramAccountInformation, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 74, paramAccountInformation, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public final String zzhc()
  {
    return "com.google.android.gms.auth.api.accountactivationstate.START";
  }
  
  public final String zzhd()
  {
    return "com.google.android.gms.auth.api.accountactivationstate.internal.IAccountActivationStateService";
  }
}
