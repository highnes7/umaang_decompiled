package com.google.android.android.internal;

import android.accounts.Account;
import com.google.android.android.auth.account.WorkAccount;
import com.google.android.android.auth.account.WorkAccountApi;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.PendingResult;
import com.google.android.android.common.package_9.Status;

public final class zzaqy
  implements WorkAccountApi
{
  public static final Status zzdxz = new Status(13);
  
  public zzaqy() {}
  
  public final PendingResult addWorkAccount(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.d(new zzara(this, WorkAccount.IOERR, paramGoogleApiClient, paramString));
  }
  
  public final PendingResult removeWorkAccount(GoogleApiClient paramGoogleApiClient, Account paramAccount)
  {
    return paramGoogleApiClient.d(new zzarc(this, WorkAccount.IOERR, paramGoogleApiClient, paramAccount));
  }
  
  public final void setWorkAuthenticatorEnabled(GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    setWorkAuthenticatorEnabledWithResult(paramGoogleApiClient, paramBoolean);
  }
  
  public final PendingResult setWorkAuthenticatorEnabledWithResult(GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    return paramGoogleApiClient.d(new zzaqz(this, WorkAccount.IOERR, paramGoogleApiClient, paramBoolean));
  }
}
