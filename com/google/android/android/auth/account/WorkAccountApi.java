package com.google.android.android.auth.account;

import android.accounts.Account;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.PendingResult;
import com.google.android.android.common.package_9.Result;

public abstract interface WorkAccountApi
{
  public abstract PendingResult addWorkAccount(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult removeWorkAccount(GoogleApiClient paramGoogleApiClient, Account paramAccount);
  
  public abstract void setWorkAuthenticatorEnabled(GoogleApiClient paramGoogleApiClient, boolean paramBoolean);
  
  public abstract PendingResult setWorkAuthenticatorEnabledWithResult(GoogleApiClient paramGoogleApiClient, boolean paramBoolean);
  
  public abstract interface AddAccountResult
    extends Result
  {
    public abstract Account getAccount();
  }
}
