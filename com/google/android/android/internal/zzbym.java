package com.google.android.android.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.PendingResult;
import com.google.android.android.location.FusedLocationProviderApi;
import com.google.android.android.location.LocationAvailability;
import com.google.android.android.location.LocationCallback;
import com.google.android.android.location.LocationListener;
import com.google.android.android.location.LocationRequest;
import com.google.android.android.location.LocationServices;

public final class zzbym
  implements FusedLocationProviderApi
{
  public zzbym() {}
  
  public final PendingResult flushLocations(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.d(new zzbyr(this, paramGoogleApiClient));
  }
  
  public final Location getLastLocation(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient = LocationServices.getPrefs(paramGoogleApiClient);
    try
    {
      paramGoogleApiClient = paramGoogleApiClient.getLastLocation();
      return paramGoogleApiClient;
    }
    catch (Exception paramGoogleApiClient)
    {
      for (;;) {}
    }
    return null;
  }
  
  public final LocationAvailability getLocationAvailability(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient = LocationServices.getPrefs(paramGoogleApiClient);
    try
    {
      paramGoogleApiClient = paramGoogleApiClient.zzasw();
      return paramGoogleApiClient;
    }
    catch (Exception paramGoogleApiClient)
    {
      for (;;) {}
    }
    return null;
  }
  
  public final PendingResult removeLocationUpdates(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.d(new zzbyw(this, paramGoogleApiClient, paramPendingIntent));
  }
  
  public final PendingResult removeLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationCallback paramLocationCallback)
  {
    return paramGoogleApiClient.d(new zzbyo(this, paramGoogleApiClient, paramLocationCallback));
  }
  
  public final PendingResult removeLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationListener paramLocationListener)
  {
    return paramGoogleApiClient.d(new zzbyv(this, paramGoogleApiClient, paramLocationListener));
  }
  
  public final PendingResult requestLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.d(new zzbyu(this, paramGoogleApiClient, paramLocationRequest, paramPendingIntent));
  }
  
  public final PendingResult requestLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, LocationCallback paramLocationCallback, Looper paramLooper)
  {
    return paramGoogleApiClient.d(new zzbyt(this, paramGoogleApiClient, paramLocationRequest, paramLocationCallback, paramLooper));
  }
  
  public final PendingResult requestLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, LocationListener paramLocationListener)
  {
    zzbp.get(Looper.myLooper(), "Calling thread must be a prepared Looper thread.");
    return paramGoogleApiClient.d(new zzbyn(this, paramGoogleApiClient, paramLocationRequest, paramLocationListener));
  }
  
  public final PendingResult requestLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper)
  {
    return paramGoogleApiClient.d(new zzbys(this, paramGoogleApiClient, paramLocationRequest, paramLocationListener, paramLooper));
  }
  
  public final PendingResult setMockLocation(GoogleApiClient paramGoogleApiClient, Location paramLocation)
  {
    return paramGoogleApiClient.d(new zzbyq(this, paramGoogleApiClient, paramLocation));
  }
  
  public final PendingResult setMockMode(GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    return paramGoogleApiClient.d(new zzbyp(this, paramGoogleApiClient, paramBoolean));
  }
}
