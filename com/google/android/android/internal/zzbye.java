package com.google.android.android.internal;

import android.app.PendingIntent;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.PendingResult;
import com.google.android.android.location.ActivityRecognitionApi;

public final class zzbye
  implements ActivityRecognitionApi
{
  public zzbye() {}
  
  public final PendingResult removeActivityUpdates(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.d(new zzbyg(this, paramGoogleApiClient, paramPendingIntent));
  }
  
  public final PendingResult requestActivityUpdates(GoogleApiClient paramGoogleApiClient, long paramLong, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.d(new zzbyf(this, paramGoogleApiClient, paramLong, paramPendingIntent));
  }
}
