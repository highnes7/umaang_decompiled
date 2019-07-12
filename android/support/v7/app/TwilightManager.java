package android.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import java.util.Calendar;
import support.android.v4.content.PermissionChecker;

public class TwilightManager
{
  public static final int SUNRISE = 6;
  public static final int SUNSET = 22;
  public static final String TAG = "TwilightManager";
  public static TwilightManager sInstance;
  public final Context mContext;
  public final LocationManager mLocationManager;
  public final TwilightState mTwilightState = new TwilightState();
  
  public TwilightManager(Context paramContext, LocationManager paramLocationManager)
  {
    mContext = paramContext;
    mLocationManager = paramLocationManager;
  }
  
  public static TwilightManager getInstance(Context paramContext)
  {
    if (sInstance == null)
    {
      paramContext = paramContext.getApplicationContext();
      sInstance = new TwilightManager(paramContext, (LocationManager)paramContext.getSystemService("location"));
    }
    return sInstance;
  }
  
  private Location getLastKnownLocation()
  {
    int i = PermissionChecker.checkSelfPermission(mContext, "android.permission.ACCESS_COARSE_LOCATION");
    Location localLocation2 = null;
    Location localLocation1;
    if (i == 0) {
      localLocation1 = getLastKnownLocationForProvider("network");
    } else {
      localLocation1 = null;
    }
    if (PermissionChecker.checkSelfPermission(mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
      localLocation2 = getLastKnownLocationForProvider("gps");
    }
    if ((localLocation2 != null) && (localLocation1 != null))
    {
      if (localLocation2.getTime() > localLocation1.getTime()) {
        return localLocation2;
      }
    }
    else if (localLocation2 != null) {
      return localLocation2;
    }
    return localLocation1;
  }
  
  private Location getLastKnownLocationForProvider(String paramString)
  {
    LocationManager localLocationManager = mLocationManager;
    try
    {
      boolean bool = localLocationManager.isProviderEnabled(paramString);
      if (bool)
      {
        localLocationManager = mLocationManager;
        paramString = localLocationManager.getLastKnownLocation(paramString);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  private boolean isStateValid()
  {
    return mTwilightState.nextUpdate > System.currentTimeMillis();
  }
  
  public static void setInstance(TwilightManager paramTwilightManager)
  {
    sInstance = paramTwilightManager;
  }
  
  private void updateState(Location paramLocation)
  {
    TwilightState localTwilightState = mTwilightState;
    long l1 = System.currentTimeMillis();
    TwilightCalculator localTwilightCalculator = TwilightCalculator.getInstance();
    localTwilightCalculator.calculateTwilight(l1 - 86400000L, paramLocation.getLatitude(), paramLocation.getLongitude());
    long l2 = sunset;
    localTwilightCalculator.calculateTwilight(l1, paramLocation.getLatitude(), paramLocation.getLongitude());
    boolean bool;
    if (state == 1) {
      bool = true;
    } else {
      bool = false;
    }
    long l3 = sunrise;
    long l4 = sunset;
    localTwilightCalculator.calculateTwilight(86400000L + l1, paramLocation.getLatitude(), paramLocation.getLongitude());
    long l5 = sunrise;
    if ((l3 != -1L) && (l4 != -1L))
    {
      if (l1 > l4) {
        l1 = 0L + l5;
      } else if (l1 > l3) {
        l1 = 0L + l4;
      } else {
        l1 = 0L + l3;
      }
      l1 += 60000L;
    }
    else
    {
      l1 = 43200000L + l1;
    }
    isNight = bool;
    yesterdaySunset = l2;
    todaySunrise = l3;
    todaySunset = l4;
    tomorrowSunrise = l5;
    nextUpdate = l1;
  }
  
  public boolean isNight()
  {
    TwilightState localTwilightState = mTwilightState;
    if (isStateValid()) {
      return isNight;
    }
    Location localLocation = getLastKnownLocation();
    if (localLocation != null)
    {
      updateState(localLocation);
      return isNight;
    }
    int i = Calendar.getInstance().get(11);
    return (i < 6) || (i >= 22);
  }
  
  private static class TwilightState
  {
    public boolean isNight;
    public long nextUpdate;
    public long todaySunrise;
    public long todaySunset;
    public long tomorrowSunrise;
    public long yesterdaySunset;
    
    public TwilightState() {}
  }
}
