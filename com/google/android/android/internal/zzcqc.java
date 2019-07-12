package com.google.android.android.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.android.auth.dashclock.signin.GoogleSignInAccount;
import com.google.android.android.auth.dashclock.signin.internal.Phrase;
import com.google.android.android.common.internal.AccountInformation;
import com.google.android.android.common.internal.CacheRequest;
import com.google.android.android.common.internal.TaskManager;
import com.google.android.android.common.internal.zzam;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.internal.zzbq;
import com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzcps;

public final class zzcqc
  extends com.google.android.gms.common.internal.zzaa<com.google.android.gms.internal.zzcqa>
  implements zzcps
{
  public final AccountInformation zzfkj;
  public Integer zzftu;
  public final boolean zzjnv = true;
  public final Bundle zzjnw;
  
  public zzcqc(Context paramContext, Looper paramLooper, boolean paramBoolean, AccountInformation paramAccountInformation, Bundle paramBundle, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 44, paramAccountInformation, paramConnectionCallbacks, paramOnConnectionFailedListener);
    zzfkj = paramAccountInformation;
    zzjnw = paramBundle;
    zzftu = paramAccountInformation.zzajy();
  }
  
  public zzcqc(Context paramContext, Looper paramLooper, boolean paramBoolean, AccountInformation paramAccountInformation, zzcpt paramZzcpt, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, true, paramAccountInformation, saveInstanceState(paramAccountInformation), paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public static Bundle saveInstanceState(AccountInformation paramAccountInformation)
  {
    zzcpt localZzcpt = paramAccountInformation.zzajx();
    Integer localInteger = paramAccountInformation.zzajy();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", paramAccountInformation.getAccount());
    if (localInteger != null) {
      localBundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", localInteger.intValue());
    }
    if (localZzcpt != null)
    {
      localBundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", localZzcpt.zzbbw());
      localBundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", localZzcpt.isIdTokenRequested());
      localBundle.putString("com.google.android.gms.signin.internal.serverClientId", localZzcpt.getServerClientId());
      localBundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
      localBundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", localZzcpt.zzbbx());
      localBundle.putString("com.google.android.gms.signin.internal.hostedDomain", localZzcpt.zzbby());
      localBundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", localZzcpt.zzbbz());
      if (localZzcpt.zzbca() != null) {
        localBundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", localZzcpt.zzbca().longValue());
      }
      if (localZzcpt.zzbcb() != null) {
        localBundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", localZzcpt.zzbcb().longValue());
      }
    }
    return localBundle;
  }
  
  public final void connect()
  {
    disconnect(new CacheRequest(this));
  }
  
  public final void getDialog(zzcpy paramZzcpy)
  {
    zzbp.get(paramZzcpy, "Expecting a valid ISignInCallbacks");
    Object localObject1 = zzfkj;
    try
    {
      Object localObject2 = ((AccountInformation)localObject1).zzajp();
      localObject1 = null;
      Object localObject3 = name;
      boolean bool = "<<default account>>".equals(localObject3);
      if (bool) {
        localObject1 = Phrase.zzbl(getContext()).zzaas();
      }
      localObject3 = zzftu;
      localObject1 = new zzbq(2, (Account)localObject2, ((Integer)localObject3).intValue(), (GoogleSignInAccount)localObject1);
      localObject2 = zzajj();
      localObject2 = (zzcqa)localObject2;
      ((zzcqa)localObject2).printStackTrace(new zzcqd(1, (zzbq)localObject1), paramZzcpy);
      return;
    }
    catch (RemoteException localRemoteException) {}
    try
    {
      paramZzcpy.enqueue(new zzcqf(8));
      return;
    }
    catch (RemoteException paramZzcpy)
    {
      for (;;) {}
    }
    Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", localRemoteException);
  }
  
  public final void removeTask(zzam paramZzam, boolean paramBoolean)
  {
    try
    {
      Object localObject = zzajj();
      localObject = (zzcqa)localObject;
      Integer localInteger = zzftu;
      ((zzcqa)localObject).remove(paramZzam, localInteger.intValue(), paramBoolean);
      return;
    }
    catch (RemoteException paramZzam) {}
  }
  
  public final boolean zzaac()
  {
    return zzjnv;
  }
  
  public final void zzbbv()
  {
    try
    {
      Object localObject = zzajj();
      localObject = (zzcqa)localObject;
      Integer localInteger = zzftu;
      ((zzcqa)localObject).zzec(localInteger.intValue());
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  public final String zzhc()
  {
    return "com.google.android.gms.signin.service.START";
  }
  
  public final String zzhd()
  {
    return "com.google.android.gms.signin.internal.ISignInService";
  }
  
  public final Bundle zzzu()
  {
    String str = zzfkj.zzaju();
    if (!getContext().getPackageName().equals(str)) {
      zzjnw.putString("com.google.android.gms.signin.internal.realClientPackageName", zzfkj.zzaju());
    }
    return zzjnw;
  }
}
