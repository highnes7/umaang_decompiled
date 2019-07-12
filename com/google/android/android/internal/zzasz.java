package com.google.android.android.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.android.auth.dashclock.DAO;
import com.google.android.android.auth.dashclock.Preference;
import com.google.android.android.common.internal.AccountInformation;
import com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzatc;
import java.util.Set;

public final class zzasz
  extends com.google.android.gms.common.internal.zzaa<zzatc>
{
  public final Bundle zzdzx;
  
  public zzasz(Context paramContext, Looper paramLooper, AccountInformation paramAccountInformation, Preference paramPreference, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 16, paramAccountInformation, paramConnectionCallbacks, paramOnConnectionFailedListener);
    if (paramPreference == null)
    {
      zzdzx = new Bundle();
      return;
    }
    throw new NoSuchMethodError();
  }
  
  public final boolean zzaac()
  {
    AccountInformation localAccountInformation = zzakd();
    return (!TextUtils.isEmpty(localAccountInformation.getAccountName())) && (!localAccountInformation.find(DAO._id).isEmpty());
  }
  
  public final String zzhc()
  {
    return "com.google.android.gms.auth.service.START";
  }
  
  public final String zzhd()
  {
    return "com.google.android.gms.auth.api.internal.IAuthService";
  }
  
  public final Bundle zzzu()
  {
    return zzdzx;
  }
}
