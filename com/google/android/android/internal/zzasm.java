package com.google.android.android.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.gms.common.api.Status;

public final class zzasm
  extends com.google.android.gms.internal.zzaso<Status>
{
  public zzasm(zzash paramZzash, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
  }
  
  public final void registerRenderer(Context paramContext, zzasu paramZzasu)
    throws RemoteException
  {
    paramZzasu.processParameters(new zzasn(this));
  }
}
