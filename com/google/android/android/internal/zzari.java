package com.google.android.android.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.android.common.internal.AccountInformation;
import com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.auth.account.zzc;

public final class zzari
  extends com.google.android.gms.common.internal.zzaa<zzc>
{
  public zzari(Context paramContext, Looper paramLooper, AccountInformation paramAccountInformation, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 120, paramAccountInformation, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public final String zzhc()
  {
    return "com.google.android.gms.auth.account.workaccount.START";
  }
  
  public final String zzhd()
  {
    return "com.google.android.gms.auth.account.IWorkAccountService";
  }
}
