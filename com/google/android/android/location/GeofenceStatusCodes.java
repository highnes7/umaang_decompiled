package com.google.android.android.location;

import com.google.android.android.common.package_9.CommonStatusCodes;

public final class GeofenceStatusCodes
  extends CommonStatusCodes
{
  public static final int GEOFENCE_NOT_AVAILABLE = 1000;
  public static final int GEOFENCE_TOO_MANY_GEOFENCES = 1001;
  public static final int GEOFENCE_TOO_MANY_PENDING_INTENTS = 1002;
  
  public GeofenceStatusCodes() {}
  
  public static String getStatusCodeString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return CommonStatusCodes.getStatusCodeString(paramInt);
    case 1002: 
      return "GEOFENCE_TOO_MANY_PENDING_INTENTS";
    case 1001: 
      return "GEOFENCE_TOO_MANY_GEOFENCES";
    }
    return "GEOFENCE_NOT_AVAILABLE";
  }
}
