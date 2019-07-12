package com.google.android.android.internal;

import android.os.RemoteException;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.internal.c;
import com.google.android.gms.common.api.internal.zzn;

public final class zzbzx
  extends zzbzn
{
  public zzn<com.google.android.gms.location.LocationSettingsResult> zzhzt;
  
  public zzbzx(c paramC)
  {
    boolean bool;
    if (paramC != null) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.get(bool, "listener can't be null.");
    zzhzt = paramC;
  }
  
  public final void publishUpdate(com.google.android.android.location.LocationSettingsResult paramLocationSettingsResult)
    throws RemoteException
  {
    zzhzt.setResult(paramLocationSettingsResult);
    zzhzt = null;
  }
}
