package com.google.android.android.internal;

import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.PendingResult;
import com.google.android.android.location.LocationSettingsRequest;
import com.google.android.android.location.SettingsApi;

public final class zzcaf
  implements SettingsApi
{
  public zzcaf() {}
  
  public final PendingResult checkLocationSettings(GoogleApiClient paramGoogleApiClient, LocationSettingsRequest paramLocationSettingsRequest)
  {
    return paramGoogleApiClient.get(new zzcag(this, paramGoogleApiClient, paramLocationSettingsRequest, null));
  }
}
