package com.google.android.android.location;

import android.app.PendingIntent;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.PendingResult;

@Deprecated
public abstract interface ActivityRecognitionApi
{
  public abstract PendingResult removeActivityUpdates(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent);
  
  public abstract PendingResult requestActivityUpdates(GoogleApiClient paramGoogleApiClient, long paramLong, PendingIntent paramPendingIntent);
}
