package com.google.android.android.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.android.common.internal.AccountInformation;
import com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzbdc;

public final class zzbcz
  extends com.google.android.gms.common.internal.zzaa<zzbdc>
{
  public zzbcz(Context paramContext, Looper paramLooper, AccountInformation paramAccountInformation, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 39, paramAccountInformation, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public final String zzhc()
  {
    return "com.google.android.gms.common.service.START";
  }
  
  public final String zzhd()
  {
    return "com.google.android.gms.common.internal.service.ICommonService";
  }
}
