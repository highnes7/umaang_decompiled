package com.google.android.android.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.android.auth.dashclock.credentials.Credential;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.gms.common.api.Status;

public final class zzask
  extends com.google.android.gms.internal.zzaso<Status>
{
  public zzask(zzash paramZzash, GoogleApiClient paramGoogleApiClient, Credential paramCredential)
  {
    super(paramGoogleApiClient);
  }
  
  public final void registerRenderer(Context paramContext, zzasu paramZzasu)
    throws RemoteException
  {
    paramZzasu.clear(new zzasn(this), new zzasw(zzebj));
  }
}
