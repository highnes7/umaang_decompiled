package f.commons.data.general;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;

public final class Util
{
  public Util() {}
  
  public static int dpToPx(Context paramContext, float paramFloat)
  {
    return Math.round(paramFloat * getResourcesgetDisplayMetricsdensity);
  }
  
  public static boolean hasLollipop()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public static boolean isKitKat()
  {
    int i = Build.VERSION.SDK_INT;
    return true;
  }
}
