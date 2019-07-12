package com.google.android.android.common.package_9.internal;

import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.package_9.Api.zze;
import java.util.Collections;
import java.util.Map;

public final class zzbw
  implements Runnable
{
  public zzbw(zzbv paramZzbv, ConnectionResult paramConnectionResult) {}
  
  public final void run()
  {
    if (zzfoe.isSuccess())
    {
      zzbv localZzbv = zzfog;
      zzfof = true;
      if (zzfkh.zzaac())
      {
        zzbv.Zip(zzfog);
        return;
      }
      zzfog.zzfkh.rename(null, Collections.emptySet());
      return;
    }
    ((zzbr)zzbp.isIgnored(zzfog.zzfnu).get(zzfog.zzfgs)).onConnectionFailed(zzfoe);
  }
}
