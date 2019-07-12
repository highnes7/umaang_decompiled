package com.google.android.android.common.package_9.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.internal.AccountInformation;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.internal.zzbs;
import com.google.android.android.common.package_9.Api.zze;
import com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.android.internal.zzcpp;
import com.google.android.android.internal.zzcpx;
import com.google.android.android.internal.zzcqf;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzcpt;
import java.util.Set;

public final class zzcw
  extends zzcpx
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  public static com.google.android.gms.common.api.Api.zza<? extends com.google.android.gms.internal.zzcps, zzcpt> zzfpd = zzcpp.zzdwq;
  public final Context mContext;
  public final Handler mHandler;
  public Set<Scope> zzecm;
  public final com.google.android.gms.common.api.Api.zza<? extends com.google.android.gms.internal.zzcps, zzcpt> zzfgf;
  public AccountInformation zzfkj;
  public com.google.android.android.internal.zzcps zzflp;
  public zzcy zzfpe;
  
  public zzcw(Context paramContext, Handler paramHandler, AccountInformation paramAccountInformation)
  {
    this(paramContext, paramHandler, paramAccountInformation, zzfpd);
  }
  
  public zzcw(Context paramContext, Handler paramHandler, AccountInformation paramAccountInformation, com.google.android.android.common.package_9.Api.zza paramZza)
  {
    mContext = paramContext;
    mHandler = paramHandler;
    zzbp.get(paramAccountInformation, "ClientSettings must not be null");
    zzfkj = ((AccountInformation)paramAccountInformation);
    zzecm = paramAccountInformation.zzajr();
    zzfgf = paramZza;
  }
  
  private final void doSync(zzcqf paramZzcqf)
  {
    Object localObject2 = paramZzcqf.zzagd();
    Object localObject1 = localObject2;
    if (((ConnectionResult)localObject2).isSuccess())
    {
      localObject2 = paramZzcqf.zzbcc();
      localObject1 = ((zzbs)localObject2).zzagd();
      paramZzcqf = (zzcqf)localObject1;
      if (!((ConnectionResult)localObject1).isSuccess())
      {
        localObject1 = String.valueOf(localObject1);
        localObject2 = new StringBuilder(((String)localObject1).length() + 48);
        ((StringBuilder)localObject2).append("Sign-in succeeded with resolve account failure: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        Log.wtf("SignInCoordinator", ((StringBuilder)localObject2).toString(), new Exception());
        localObject1 = paramZzcqf;
      }
    }
    else
    {
      zzfpe.ignore((ConnectionResult)localObject1);
    }
    for (;;)
    {
      zzflp.disconnect();
      return;
      zzfpe.startSession(((zzbs)localObject2).zzakl(), zzecm);
    }
  }
  
  public final void enqueue(zzcqf paramZzcqf)
  {
    mHandler.post(new zzcx(this, paramZzcqf));
  }
  
  public final void onConnected(Bundle paramBundle)
  {
    zzflp.getDialog(this);
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zzfpe.ignore(paramConnectionResult);
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    zzflp.disconnect();
  }
  
  public final void quit(zzcy paramZzcy)
  {
    Object localObject = zzflp;
    if (localObject != null) {
      ((Api.zze)localObject).disconnect();
    }
    zzfkj.setUserId(Integer.valueOf(System.identityHashCode(this)));
    localObject = zzfgf;
    Context localContext = mContext;
    Looper localLooper = mHandler.getLooper();
    AccountInformation localAccountInformation = zzfkj;
    zzflp = ((com.google.android.android.internal.zzcps)((com.google.android.android.common.package_9.Api.zza)localObject).getTemplate(localContext, localLooper, localAccountInformation, localAccountInformation.zzajx(), this, this));
    zzfpe = paramZzcy;
    zzflp.connect();
  }
  
  public final com.google.android.android.internal.zzcps zzaic()
  {
    return zzflp;
  }
  
  public final void zzaim()
  {
    com.google.android.android.internal.zzcps localZzcps = zzflp;
    if (localZzcps != null) {
      localZzcps.disconnect();
    }
  }
}
