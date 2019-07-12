package com.google.android.android.auth.dashclock.signin.internal;

import android.content.Intent;
import com.google.android.android.auth.dashclock.Auth;
import com.google.android.android.auth.dashclock.signin.GoogleSignInApi;
import com.google.android.android.auth.dashclock.signin.GoogleSignInOptions;
import com.google.android.android.auth.dashclock.signin.GoogleSignInResult;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.OptionalPendingResult;
import com.google.android.android.common.package_9.PendingResult;

public final class SolidColor
  implements GoogleSignInApi
{
  public SolidColor() {}
  
  public static GoogleSignInOptions intersection(GoogleApiClient paramGoogleApiClient)
  {
    return ((Restriction)paramGoogleApiClient.getChange(Auth.zzdye)).zzaan();
  }
  
  public final Intent getSignInIntent(GoogleApiClient paramGoogleApiClient)
  {
    return AccountManager.create(paramGoogleApiClient.getContext(), intersection(paramGoogleApiClient));
  }
  
  public final GoogleSignInResult getSignInResultFromIntent(Intent paramIntent)
  {
    return AccountManager.getSignInResultFromIntent(paramIntent);
  }
  
  public final PendingResult revokeAccess(GoogleApiClient paramGoogleApiClient)
  {
    return AccountManager.getAccounts(paramGoogleApiClient, paramGoogleApiClient.getContext());
  }
  
  public final PendingResult signOut(GoogleApiClient paramGoogleApiClient)
  {
    return AccountManager.getAccount(paramGoogleApiClient, paramGoogleApiClient.getContext());
  }
  
  public final OptionalPendingResult silentSignIn(GoogleApiClient paramGoogleApiClient)
  {
    return AccountManager.getAccounts(paramGoogleApiClient, paramGoogleApiClient.getContext(), intersection(paramGoogleApiClient));
  }
}
