package com.google.android.android.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.android.auth.dashclock.accounttransfer.Launcher.16;
import com.google.android.android.common.internal.AccountInformation;
import com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzarv;

public final class zzarq
  extends com.google.android.gms.common.internal.zzaa<zzarv>
{
  public final Bundle zzdzx;
  
  public zzarq(Context paramContext, Looper paramLooper, AccountInformation paramAccountInformation, Launcher.16 param16, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 128, paramAccountInformation, paramConnectionCallbacks, paramOnConnectionFailedListener);
    if (param16 == null)
    {
      zzdzx = new Bundle();
      return;
    }
    throw new NoSuchMethodError();
  }
  
  public final String zzhc()
  {
    return "com.google.android.gms.auth.api.accounttransfer.service.START";
  }
  
  public final String zzhd()
  {
    return "com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferService";
  }
  
  public final Bundle zzzu()
  {
    return zzdzx;
  }
}
