package com.google.android.android.auth.dashclock.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import com.google.android.android.auth.dashclock.signin.GoogleSignInAccount;
import com.google.android.android.auth.dashclock.signin.GoogleSignInOptions;
import com.google.android.android.auth.dashclock.signin.GoogleSignInResult;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.OptionalPendingResult;
import com.google.android.android.common.package_9.PendingResult;
import com.google.android.android.common.package_9.PendingResults;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.common.package_9.internal.zzcp;
import com.google.android.android.internal.zzbde;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class AccountManager
{
  public static zzbde zzect = new zzbde("GoogleSignInCommon", new String[0]);
  
  public static Intent create(Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzect.append("GoogleSignInCommon", new Object[] { "getSignInIntent()" });
    paramGoogleSignInOptions = new SignInConfiguration(paramContext.getPackageName(), paramGoogleSignInOptions);
    Intent localIntent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
    localIntent.setClass(paramContext, SignInHubActivity.class);
    localIntent.putExtra("config", paramGoogleSignInOptions);
    return localIntent;
  }
  
  public static PendingResult getAccount(GoogleApiClient paramGoogleApiClient, Context paramContext)
  {
    zzect.append("GoogleSignInCommon", new Object[] { "Signing out" });
    zzbk(paramContext);
    return paramGoogleApiClient.d(new Gson(paramGoogleApiClient));
  }
  
  public static OptionalPendingResult getAccounts(GoogleApiClient paramGoogleApiClient, Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    Phrase localPhrase = Phrase.zzbl(paramContext);
    zzect.append("GoogleSignInCommon", new Object[] { "getEligibleSavedSignInResult()" });
    com.google.android.android.common.internal.zzbp.append(paramGoogleSignInOptions);
    paramContext = localPhrase.zzaat();
    if (paramContext != null)
    {
      Account localAccount1 = paramContext.getAccount();
      Account localAccount2 = paramGoogleSignInOptions.getAccount();
      boolean bool;
      if (localAccount1 == null)
      {
        if (localAccount2 == null) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else {
        bool = localAccount1.equals(localAccount2);
      }
      if ((bool) && (!paramGoogleSignInOptions.zzaah()) && ((!paramGoogleSignInOptions.isIdTokenRequested()) || ((paramContext.isIdTokenRequested()) && (paramGoogleSignInOptions.getServerClientId().equals(paramContext.getServerClientId())))) && (new HashSet(paramContext.zzaag()).containsAll(new HashSet(paramGoogleSignInOptions.zzaag()))))
      {
        paramContext = localPhrase.zzaas();
        if ((paramContext != null) && (!paramContext.zzaad()))
        {
          paramContext = new GoogleSignInResult(paramContext, Status.zzfhv);
          break label181;
        }
      }
    }
    paramContext = null;
    label181:
    if (paramContext != null)
    {
      zzect.append("GoogleSignInCommon", new Object[] { "Eligible saved sign in result found" });
      return PendingResults.handleResult(paramContext, paramGoogleApiClient);
    }
    zzect.append("GoogleSignInCommon", new Object[] { "trySilentSignIn()" });
    return new zzcp(paramGoogleApiClient.get(new Model(paramGoogleApiClient, localPhrase, paramGoogleSignInOptions)));
  }
  
  public static PendingResult getAccounts(GoogleApiClient paramGoogleApiClient, Context paramContext)
  {
    zzect.append("GoogleSignInCommon", new Object[] { "Revoking access" });
    zzbk(paramContext);
    return paramGoogleApiClient.d(new TypeToken(paramGoogleApiClient));
  }
  
  public static GoogleSignInResult getSignInResultFromIntent(Intent paramIntent)
  {
    if ((paramIntent != null) && ((paramIntent.hasExtra("googleSignInStatus")) || (paramIntent.hasExtra("googleSignInAccount"))))
    {
      GoogleSignInAccount localGoogleSignInAccount = (GoogleSignInAccount)paramIntent.getParcelableExtra("googleSignInAccount");
      paramIntent = (Status)paramIntent.getParcelableExtra("googleSignInStatus");
      if (localGoogleSignInAccount != null) {
        paramIntent = Status.zzfhv;
      }
      return new GoogleSignInResult(localGoogleSignInAccount, paramIntent);
    }
    return null;
  }
  
  public static void zzbk(Context paramContext)
  {
    Phrase.zzbl(paramContext).zzaau();
    paramContext = GoogleApiClient.zzafo().iterator();
    while (paramContext.hasNext()) {
      ((GoogleApiClient)paramContext.next()).zzafp();
    }
    com.google.android.android.common.package_9.internal.zzbp.zzahp();
  }
}
