package com.google.android.android.location;

import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.PendingResult;

@Deprecated
public abstract interface SettingsApi
{
  public abstract PendingResult checkLocationSettings(GoogleApiClient paramGoogleApiClient, LocationSettingsRequest paramLocationSettingsRequest);
}
