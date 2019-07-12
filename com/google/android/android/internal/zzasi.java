package com.google.android.android.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.android.auth.dashclock.credentials.CredentialRequest;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;

public final class zzasi
  extends com.google.android.gms.internal.zzaso<CredentialRequestResult>
{
  public zzasi(zzash paramZzash, GoogleApiClient paramGoogleApiClient, CredentialRequest paramCredentialRequest)
  {
    super(paramGoogleApiClient);
  }
  
  public final void registerRenderer(Context paramContext, zzasu paramZzasu)
    throws RemoteException
  {
    paramZzasu.makeView(new zzasj(this), zzebh);
  }
}
