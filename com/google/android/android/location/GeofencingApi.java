package com.google.android.android.location;

import android.app.PendingIntent;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.PendingResult;
import java.util.List;

@Deprecated
public abstract interface GeofencingApi
{
  public abstract PendingResult addGeofences(GoogleApiClient paramGoogleApiClient, GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent);
  
  public abstract PendingResult addGeofences(GoogleApiClient paramGoogleApiClient, List paramList, PendingIntent paramPendingIntent);
  
  public abstract PendingResult removeGeofences(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent);
  
  public abstract PendingResult removeGeofences(GoogleApiClient paramGoogleApiClient, List paramList);
}
