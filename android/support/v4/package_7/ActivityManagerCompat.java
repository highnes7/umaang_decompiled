package android.support.v4.package_7;

import android.app.ActivityManager;
import android.os.Build.VERSION;

public final class ActivityManagerCompat
{
  public ActivityManagerCompat() {}
  
  public static boolean isLowRamDevice(ActivityManager paramActivityManager)
  {
    int i = Build.VERSION.SDK_INT;
    return paramActivityManager.isLowRamDevice();
  }
}
