package com.google.android.android.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.android.auth.dashclock.credentials.Credential;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.gms.common.api.Status;

public final class zzasl
  extends com.google.android.gms.internal.zzaso<Status>
{
  public zzasl(zzash paramZzash, GoogleApiClient paramGoogleApiClient, Credential paramCredential)
  {
    super(paramGoogleApiClient);
  }
  
  public final void registerRenderer(Context paramContext, zzasu paramZzasu)
    throws RemoteException
  {
    paramZzasu.loadCover(new zzasn(this), new zzasq(zzebj));
  }
}
