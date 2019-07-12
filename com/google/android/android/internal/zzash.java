package com.google.android.android.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.android.auth.dashclock.Auth;
import com.google.android.android.auth.dashclock.Auth.AuthCredentialsOptions;
import com.google.android.android.auth.dashclock.credentials.Credential;
import com.google.android.android.auth.dashclock.credentials.CredentialRequest;
import com.google.android.android.auth.dashclock.credentials.CredentialsApi;
import com.google.android.android.auth.dashclock.credentials.HintRequest;
import com.google.android.android.auth.dashclock.credentials.PasswordSpecification;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.PendingResult;

public final class zzash
  implements CredentialsApi
{
  public zzash() {}
  
  public final PendingResult delete(GoogleApiClient paramGoogleApiClient, Credential paramCredential)
  {
    return paramGoogleApiClient.d(new zzasl(this, paramGoogleApiClient, paramCredential));
  }
  
  public final PendingResult disableAutoSignIn(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.d(new zzasm(this, paramGoogleApiClient));
  }
  
  public final PendingIntent getHintPickerIntent(GoogleApiClient paramGoogleApiClient, HintRequest paramHintRequest)
  {
    zzbp.get(paramGoogleApiClient.has(Auth.CREDENTIALS_API), "Auth.CREDENTIALS_API must be added to GoogleApiClient to use this API");
    Object localObject = ((zzasp)paramGoogleApiClient.getChange(Auth.zzdyc)).zzaab();
    Context localContext = paramGoogleApiClient.getContext();
    zzbp.get(localContext, "context must not be null");
    zzbp.get(paramHintRequest, "request must not be null");
    if ((localObject != null) && (((Auth.AuthCredentialsOptions)localObject).zzzx() != null)) {
      paramGoogleApiClient = ((Auth.AuthCredentialsOptions)localObject).zzzx();
    } else {
      paramGoogleApiClient = PasswordSpecification.zzeax;
    }
    localObject = new Intent("com.google.android.gms.auth.api.credentials.PICKER").putExtra("com.google.android.gms.credentials.hintRequestVersion", 2).putExtra("com.google.android.gms.credentials.RequestType", "Hints").putExtra("com.google.android.gms.credentials.ClaimedCallingPackage", null);
    zzbcp.sendBroadcast(paramGoogleApiClient, (Intent)localObject, "com.google.android.gms.credentials.PasswordSpecification");
    zzbcp.sendBroadcast(paramHintRequest, (Intent)localObject, "com.google.android.gms.credentials.HintRequest");
    return PendingIntent.getActivity(localContext, 2000, (Intent)localObject, 268435456);
  }
  
  public final PendingResult request(GoogleApiClient paramGoogleApiClient, CredentialRequest paramCredentialRequest)
  {
    return paramGoogleApiClient.get(new zzasi(this, paramGoogleApiClient, paramCredentialRequest));
  }
  
  public final PendingResult save(GoogleApiClient paramGoogleApiClient, Credential paramCredential)
  {
    return paramGoogleApiClient.d(new zzask(this, paramGoogleApiClient, paramCredential));
  }
}
