package com.google.android.android.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.android.auth.dashclock.Auth;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.internal.Logger;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.internal.zzasp;

public abstract class zzaso<R extends Result>
  extends zzm<R, zzasp>
{
  public zzaso(GoogleApiClient paramGoogleApiClient)
  {
    super(Auth.CREDENTIALS_API, paramGoogleApiClient);
  }
  
  public abstract void registerRenderer(Context paramContext, zzasu paramZzasu)
    throws DeadObjectException, RemoteException;
}
