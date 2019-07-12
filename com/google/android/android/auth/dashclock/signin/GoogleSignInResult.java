package com.google.android.android.auth.dashclock.signin;

import com.google.android.android.common.package_9.Result;
import com.google.android.android.common.package_9.Status;

public class GoogleSignInResult
  implements Result
{
  public Status mStatus;
  public GoogleSignInAccount zzeco;
  
  public GoogleSignInResult(GoogleSignInAccount paramGoogleSignInAccount, Status paramStatus)
  {
    zzeco = paramGoogleSignInAccount;
    mStatus = paramStatus;
  }
  
  public GoogleSignInAccount getSignInAccount()
  {
    return zzeco;
  }
  
  public Status getStatus()
  {
    return mStatus;
  }
  
  public boolean isSuccess()
  {
    return mStatus.isSuccess();
  }
}
