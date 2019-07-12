package com.google.android.android.internal;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.android.common.package_9.internal.c;
import com.google.android.android.location.LocationStatusCodes;
import com.google.android.gms.common.api.internal.zzn;

public final class zzbzw
  extends zzbzj
{
  public zzn<com.google.android.gms.common.api.Status> zzhzt;
  
  public zzbzw(c paramC)
  {
    zzhzt = paramC;
  }
  
  private final void zzds(int paramInt)
  {
    if (zzhzt == null)
    {
      Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times");
      return;
    }
    com.google.android.android.common.package_9.Status localStatus = LocationStatusCodes.zzdr(LocationStatusCodes.zzdq(paramInt));
    zzhzt.setResult(localStatus);
    zzhzt = null;
  }
  
  public final void a(int paramInt, String[] paramArrayOfString)
  {
    Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult");
  }
  
  public final void setSpeedAdjustmentAlgorithm(int paramInt, PendingIntent paramPendingIntent)
  {
    zzds(paramInt);
  }
  
  public final void speak(int paramInt, String[] paramArrayOfString)
  {
    zzds(paramInt);
  }
}
