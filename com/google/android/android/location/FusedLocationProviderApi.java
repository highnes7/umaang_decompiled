package com.google.android.android.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.PendingResult;

@Deprecated
public abstract interface FusedLocationProviderApi
{
  @Deprecated
  public static final String KEY_LOCATION_CHANGED = "com.google.android.location.LOCATION";
  public static final String KEY_MOCK_LOCATION = "mockLocation";
  
  public abstract PendingResult flushLocations(GoogleApiClient paramGoogleApiClient);
  
  public abstract Location getLastLocation(GoogleApiClient paramGoogleApiClient);
  
  public abstract LocationAvailability getLocationAvailability(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult removeLocationUpdates(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent);
  
  public abstract PendingResult removeLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationCallback paramLocationCallback);
  
  public abstract PendingResult removeLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationListener paramLocationListener);
  
  public abstract PendingResult requestLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, PendingIntent paramPendingIntent);
  
  public abstract PendingResult requestLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, LocationCallback paramLocationCallback, Looper paramLooper);
  
  public abstract PendingResult requestLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, LocationListener paramLocationListener);
  
  public abstract PendingResult requestLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper);
  
  public abstract PendingResult setMockLocation(GoogleApiClient paramGoogleApiClient, Location paramLocation);
  
  public abstract PendingResult setMockMode(GoogleApiClient paramGoogleApiClient, boolean paramBoolean);
}
