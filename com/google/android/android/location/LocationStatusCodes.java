package com.google.android.android.location;

import com.google.android.android.common.package_9.Status;

@Deprecated
public final class LocationStatusCodes
{
  public static final int ERROR = 1;
  public static final int GEOFENCE_NOT_AVAILABLE = 1000;
  public static final int GEOFENCE_TOO_MANY_GEOFENCES = 1001;
  public static final int GEOFENCE_TOO_MANY_PENDING_INTENTS = 1002;
  public static final int SUCCESS = 0;
  
  public LocationStatusCodes() {}
  
  public static int zzdq(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 1))
    {
      if (1000 <= paramInt)
      {
        if (paramInt <= 1002) {
          return paramInt;
        }
      }
      else {
        return 1;
      }
    }
    else {
      return paramInt;
    }
    return 1;
  }
  
  public static Status zzdr(int paramInt)
  {
    if (paramInt == 1) {
      paramInt = 13;
    }
    return new Status(paramInt);
  }
}
