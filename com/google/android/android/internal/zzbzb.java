package com.google.android.android.internal;

import android.app.PendingIntent;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.PendingResult;
import com.google.android.android.location.GeofencingApi;
import com.google.android.android.location.GeofencingRequest;
import com.google.android.android.location.GeofencingRequest.Builder;
import com.google.android.android.location.zzaa;
import java.util.List;

public final class zzbzb
  implements GeofencingApi
{
  public zzbzb() {}
  
  private final PendingResult d(GoogleApiClient paramGoogleApiClient, zzaa paramZzaa)
  {
    return paramGoogleApiClient.d(new zzbzd(this, paramGoogleApiClient, paramZzaa));
  }
  
  public final PendingResult addGeofences(GoogleApiClient paramGoogleApiClient, GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.d(new zzbzc(this, paramGoogleApiClient, paramGeofencingRequest, paramPendingIntent));
  }
  
  public final PendingResult addGeofences(GoogleApiClient paramGoogleApiClient, List paramList, PendingIntent paramPendingIntent)
  {
    GeofencingRequest.Builder localBuilder = new GeofencingRequest.Builder();
    localBuilder.addGeofences(paramList);
    localBuilder.setInitialTrigger(5);
    return addGeofences(paramGoogleApiClient, localBuilder.build(), paramPendingIntent);
  }
  
  public final PendingResult removeGeofences(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    return d(paramGoogleApiClient, zzaa.getElementValue(paramPendingIntent));
  }
  
  public final PendingResult removeGeofences(GoogleApiClient paramGoogleApiClient, List paramList)
  {
    return d(paramGoogleApiClient, zzaa.a(paramList));
  }
}
