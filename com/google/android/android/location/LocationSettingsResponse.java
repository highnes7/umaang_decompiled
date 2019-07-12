package com.google.android.android.location;

public class LocationSettingsResponse
  extends com.google.android.gms.common.api.Response<com.google.android.gms.location.LocationSettingsResult>
{
  public LocationSettingsResponse() {}
  
  public LocationSettingsStates getLocationSettingsStates()
  {
    return ((LocationSettingsResult)getResult()).getLocationSettingsStates();
  }
}
