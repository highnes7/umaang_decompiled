package com.google.android.android.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.android.common.internal.AccountInformation;
import com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzbzk;
import com.google.android.gms.internal.zzcae;

public class zzbyi
  extends com.google.android.gms.common.internal.zzaa<zzbzk>
{
  public final String zzhza;
  public final zzcae<zzbzk> zzhzb = new zzbyj(this);
  
  public zzbyi(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, AccountInformation paramAccountInformation)
  {
    super(paramContext, paramLooper, 23, paramAccountInformation, paramConnectionCallbacks, paramOnConnectionFailedListener);
    zzhza = paramString;
  }
  
  public final String zzhc()
  {
    return "com.google.android.location.internal.GoogleLocationManagerService.START";
  }
  
  public final String zzhd()
  {
    return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
  }
  
  public final Bundle zzzu()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("client_name", zzhza);
    return localBundle;
  }
}
