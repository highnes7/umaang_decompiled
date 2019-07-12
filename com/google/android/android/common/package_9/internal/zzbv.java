package com.google.android.android.common.package_9.internal;

import android.os.Handler;
import android.util.Log;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.internal.Track;
import com.google.android.android.common.internal.zzam;
import com.google.android.android.common.package_9.Api.zze;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.zzh;
import java.util.Map;
import java.util.Set;

public final class zzbv
  implements zzcy, Track
{
  public Set<Scope> zzecm = null;
  public final zzh<?> zzfgs;
  public final Api.zze zzfkh;
  public zzam zzflt = null;
  public boolean zzfof = false;
  
  public zzbv(zzbp paramZzbp, Api.zze paramZze, Msg paramMsg)
  {
    zzfkh = paramZze;
    zzfgs = paramMsg;
  }
  
  private final void zzaid()
  {
    if (zzfof)
    {
      zzam localZzam = zzflt;
      if (localZzam != null) {
        zzfkh.rename(localZzam, zzecm);
      }
    }
  }
  
  public final void ignore(ConnectionResult paramConnectionResult)
  {
    ((zzbr)zzbp.isIgnored(zzfnu).get(zzfgs)).ignore(paramConnectionResult);
  }
  
  public final void notifyProgress(ConnectionResult paramConnectionResult)
  {
    zzbp.access$getMHandler(zzfnu).post(new zzbw(this, paramConnectionResult));
  }
  
  public final void startSession(zzam paramZzam, Set paramSet)
  {
    if ((paramZzam != null) && (paramSet != null))
    {
      zzflt = paramZzam;
      zzecm = paramSet;
      zzaid();
      return;
    }
    Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
    ignore(new ConnectionResult(4));
  }
}
