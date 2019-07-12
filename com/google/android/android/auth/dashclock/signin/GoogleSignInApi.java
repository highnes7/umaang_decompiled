package com.google.android.android.auth.dashclock.signin;

import android.content.Intent;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.OptionalPendingResult;
import com.google.android.android.common.package_9.PendingResult;

public abstract interface GoogleSignInApi
{
  public static final String EXTRA_SIGN_IN_ACCOUNT = "signInAccount";
  
  public abstract Intent getSignInIntent(GoogleApiClient paramGoogleApiClient);
  
  public abstract GoogleSignInResult getSignInResultFromIntent(Intent paramIntent);
  
  public abstract PendingResult revokeAccess(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult signOut(GoogleApiClient paramGoogleApiClient);
  
  public abstract OptionalPendingResult silentSignIn(GoogleApiClient paramGoogleApiClient);
}
