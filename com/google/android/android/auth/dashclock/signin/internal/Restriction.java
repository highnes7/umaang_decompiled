package com.google.android.android.auth.dashclock.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.google.android.android.auth.dashclock.signin.GoogleSignInOptions;
import com.google.android.android.auth.dashclock.signin.GoogleSignInOptions.Builder;
import com.google.android.android.common.internal.AccountInformation;
import com.google.android.android.common.internal.TaskManager;
import com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.android.common.package_9.Scope;
import com.google.android.gms.auth.api.signin.internal.zzt;
import java.util.Iterator;
import java.util.Set;

public final class Restriction
  extends com.google.android.gms.common.internal.zzaa<zzt>
{
  public final GoogleSignInOptions zzecs;
  
  public Restriction(Context paramContext, Looper paramLooper, AccountInformation paramAccountInformation, GoogleSignInOptions paramGoogleSignInOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 91, paramAccountInformation, paramConnectionCallbacks, paramOnConnectionFailedListener);
    if (paramGoogleSignInOptions == null) {
      paramGoogleSignInOptions = new GoogleSignInOptions.Builder().build();
    }
    paramContext = paramGoogleSignInOptions;
    if (!paramAccountInformation.zzajs().isEmpty())
    {
      paramContext = new GoogleSignInOptions.Builder(paramGoogleSignInOptions);
      paramLooper = paramAccountInformation.zzajs().iterator();
      while (paramLooper.hasNext()) {
        paramContext.requestScopes((Scope)paramLooper.next(), new Scope[0]);
      }
      paramContext = paramContext.build();
    }
    zzecs = paramContext;
  }
  
  public final boolean zzaal()
  {
    return true;
  }
  
  public final Intent zzaam()
  {
    return AccountManager.create(getContext(), zzecs);
  }
  
  public final GoogleSignInOptions zzaan()
  {
    return zzecs;
  }
  
  public final String zzhc()
  {
    return "com.google.android.gms.auth.api.signin.service.START";
  }
  
  public final String zzhd()
  {
    return "com.google.android.gms.auth.api.signin.internal.ISignInService";
  }
}
