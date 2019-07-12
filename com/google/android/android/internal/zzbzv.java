package com.google.android.android.internal;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.android.common.package_9.internal.c;
import com.google.android.android.location.LocationStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzn;

public final class zzbzv
  extends zzbzj
{
  public zzn<Status> zzhzt;
  
  public zzbzv(c paramC)
  {
    zzhzt = paramC;
  }
  
  public final void a(int paramInt, String[] paramArrayOfString)
  {
    if (zzhzt == null)
    {
      Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
      return;
    }
    paramArrayOfString = LocationStatusCodes.zzdr(LocationStatusCodes.zzdq(paramInt));
    zzhzt.setResult(paramArrayOfString);
    zzhzt = null;
  }
  
  public final void setSpeedAdjustmentAlgorithm(int paramInt, PendingIntent paramPendingIntent)
  {
    Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
  }
  
  public final void speak(int paramInt, String[] paramArrayOfString)
  {
    Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
  }
}
