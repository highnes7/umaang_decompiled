package com.google.android.android.internal;

import android.accounts.Account;
import com.google.android.android.auth.account.WorkAccountApi.AddAccountResult;
import com.google.android.android.common.package_9.Status;

public final class zzarf
  implements WorkAccountApi.AddAccountResult
{
  public final Status mStatus;
  public final Account zzduz;
  
  public zzarf(Status paramStatus, Account paramAccount)
  {
    mStatus = paramStatus;
    zzduz = paramAccount;
  }
  
  public final Account getAccount()
  {
    return zzduz;
  }
  
  public final Status getStatus()
  {
    return mStatus;
  }
}
