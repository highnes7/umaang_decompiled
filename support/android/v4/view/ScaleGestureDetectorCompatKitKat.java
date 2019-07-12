package support.android.v4.view;

import android.os.Build.VERSION;
import android.view.ScaleGestureDetector;

public final class ScaleGestureDetectorCompatKitKat
{
  public ScaleGestureDetectorCompatKitKat() {}
  
  public static boolean isQuickScaleEnabled(ScaleGestureDetector paramScaleGestureDetector)
  {
    int i = Build.VERSION.SDK_INT;
    return paramScaleGestureDetector.isQuickScaleEnabled();
  }
  
  public static boolean isQuickScaleEnabled(Object paramObject)
  {
    return isQuickScaleEnabled((ScaleGestureDetector)paramObject);
  }
  
  public static void setQuickScaleEnabled(ScaleGestureDetector paramScaleGestureDetector, boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    paramScaleGestureDetector.setQuickScaleEnabled(paramBoolean);
  }
  
  public static void setQuickScaleEnabled(Object paramObject, boolean paramBoolean)
  {
    paramObject = (ScaleGestureDetector)paramObject;
    int i = Build.VERSION.SDK_INT;
    paramObject.setQuickScaleEnabled(paramBoolean);
  }
}
