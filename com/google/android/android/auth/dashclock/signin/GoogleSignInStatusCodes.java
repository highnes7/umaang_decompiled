package com.google.android.android.auth.dashclock.signin;

import com.google.android.android.common.package_9.CommonStatusCodes;

public final class GoogleSignInStatusCodes
  extends CommonStatusCodes
{
  public static final int SIGN_IN_CANCELLED = 12501;
  public static final int SIGN_IN_FAILED = 12500;
  
  public GoogleSignInStatusCodes() {}
  
  public static String getStatusCodeString(int paramInt)
  {
    if (paramInt != 12500) {
      return CommonStatusCodes.getStatusCodeString(paramInt);
    }
    return "A non-recoverable sign in failure occurred";
  }
}
