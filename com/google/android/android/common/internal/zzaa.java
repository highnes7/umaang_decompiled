package com.google.android.android.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.android.common.GoogleApiAvailability;
import com.google.android.android.common.Language;
import com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.internal.zzd;
import java.util.Iterator;
import java.util.Set;

public abstract class zzaa<T extends IInterface>
  extends zzd<T>
  implements Api.zze, zzae
{
  public final Account zzduz;
  public final Set<com.google.android.gms.common.api.Scope> zzecm;
  public final AccountInformation zzfkj;
  
  public zzaa(Context paramContext, Looper paramLooper, int paramInt, AccountInformation paramAccountInformation, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, localZzaf, localGoogleApiAvailability, paramInt, paramAccountInformation, paramConnectionCallbacks, (GoogleApiClient.OnConnectionFailedListener)paramOnConnectionFailedListener);
  }
  
  public zzaa(Context paramContext, Looper paramLooper, zzaf paramZzaf, GoogleApiAvailability paramGoogleApiAvailability, int paramInt, AccountInformation paramAccountInformation, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramZzaf, paramGoogleApiAvailability, paramInt, paramConnectionCallbacks, paramOnConnectionFailedListener, paramAccountInformation.zzajv());
    zzfkj = paramAccountInformation;
    zzduz = paramAccountInformation.getAccount();
    paramContext = paramAccountInformation.zzajs();
    paramLooper = getTrustAnchors(paramContext);
    paramZzaf = paramLooper.iterator();
    while (paramZzaf.hasNext()) {
      if (!paramContext.contains((com.google.android.android.common.package_9.Scope)paramZzaf.next())) {
        throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
      }
    }
    zzecm = paramLooper;
  }
  
  public final Account getAccount()
  {
    return zzduz;
  }
  
  public Set getTrustAnchors(Set paramSet)
  {
    return paramSet;
  }
  
  public Language[] zzajh()
  {
    return new Language[0];
  }
  
  public final Set zzajl()
  {
    return zzecm;
  }
  
  public final AccountInformation zzakd()
  {
    return zzfkj;
  }
}
