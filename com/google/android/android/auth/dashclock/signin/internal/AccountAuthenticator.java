package com.google.android.android.auth.dashclock.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.android.auth.dashclock.Auth;
import com.google.android.android.auth.dashclock.signin.GoogleSignInAccount;
import com.google.android.android.auth.dashclock.signin.GoogleSignInApi;
import com.google.android.android.auth.dashclock.signin.GoogleSignInOptions;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.TransactionInput;
import com.google.android.android.common.package_9.Api.ApiOptions.HasOptions;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.GoogleApiClient.Builder;

public final class AccountAuthenticator
  extends IPlayMedia_0_8.Stub
{
  public final Context mContext;
  
  public AccountAuthenticator(Context paramContext)
  {
    mContext = paramContext;
  }
  
  public final void zzaap()
  {
    if (TransactionInput.connect(mContext, Binder.getCallingUid()))
    {
      Phrase localPhrase = Phrase.zzbl(mContext);
      GoogleSignInAccount localGoogleSignInAccount = localPhrase.zzaas();
      localObject = GoogleSignInOptions.DEFAULT_SIGN_IN;
      if (localGoogleSignInAccount != null) {
        localObject = localPhrase.zzaat();
      }
      localObject = new GoogleApiClient.Builder(mContext).addApi(Auth.GOOGLE_SIGN_IN_API, (Api.ApiOptions.HasOptions)localObject).build();
      try
      {
        boolean bool = ((GoogleApiClient)localObject).blockingConnect().isSuccess();
        if (bool) {
          if (localGoogleSignInAccount != null) {
            Auth.GoogleSignInApi.revokeAccess((GoogleApiClient)localObject);
          } else {
            ((GoogleApiClient)localObject).clearDefaultAccountAndReconnect();
          }
        }
        ((GoogleApiClient)localObject).disconnect();
        return;
      }
      catch (Throwable localThrowable)
      {
        ((GoogleApiClient)localObject).disconnect();
        throw localThrowable;
      }
    }
    int i = Binder.getCallingUid();
    Object localObject = new StringBuilder(52);
    ((StringBuilder)localObject).append("Calling UID ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" is not Google Play services.");
    throw new SecurityException(((StringBuilder)localObject).toString());
  }
}
