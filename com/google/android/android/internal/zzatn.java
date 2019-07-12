package com.google.android.android.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.android.auth.dashclock.DAO;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.internal.Logger;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.internal.zzasz;

public abstract class zzatn
  extends zzm<ProxyApi.ProxyResult, zzasz>
{
  public zzatn(GoogleApiClient paramGoogleApiClient)
  {
    super(DAO._id, paramGoogleApiClient);
  }
  
  public abstract void updateInfo(Context paramContext, zzatc paramZzatc)
    throws RemoteException;
}
