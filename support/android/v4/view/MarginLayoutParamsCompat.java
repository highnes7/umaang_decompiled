package support.android.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

public final class MarginLayoutParamsCompat
{
  public MarginLayoutParamsCompat() {}
  
  public static int getLayoutDirection(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    int i = Build.VERSION.SDK_INT;
    i = paramMarginLayoutParams.getLayoutDirection();
    if ((i != 0) && (i != 1)) {
      return 0;
    }
    return i;
  }
  
  public static int getMarginEnd(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    int i = Build.VERSION.SDK_INT;
    return paramMarginLayoutParams.getMarginEnd();
  }
  
  public static int getMarginStart(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    int i = Build.VERSION.SDK_INT;
    return paramMarginLayoutParams.getMarginStart();
  }
  
  public static boolean isMarginRelative(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    int i = Build.VERSION.SDK_INT;
    return paramMarginLayoutParams.isMarginRelative();
  }
  
  public static void resolveLayoutDirection(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    paramMarginLayoutParams.resolveLayoutDirection(paramInt);
  }
  
  public static void setLayoutDirection(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    paramMarginLayoutParams.setLayoutDirection(paramInt);
  }
  
  public static void setMarginEnd(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    paramMarginLayoutParams.setMarginEnd(paramInt);
  }
  
  public static void setMarginStart(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    paramMarginLayoutParams.setMarginStart(paramInt);
  }
}
