package com.google.android.android.auth.dashclock.signin.internal;

import com.google.android.android.auth.dashclock.Auth;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.internal.Logger;
import com.google.android.gms.auth.api.signin.internal.zzd;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zzm;

public abstract class State<R extends Result>
  extends zzm<R, zzd>
{
  public State(GoogleApiClient paramGoogleApiClient)
  {
    super(Auth.GOOGLE_SIGN_IN_API, paramGoogleApiClient);
  }
}
