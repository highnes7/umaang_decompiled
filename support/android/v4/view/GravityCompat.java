package support.android.v4.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Gravity;

public final class GravityCompat
{
  public static final int END = 8388613;
  public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
  public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
  public static final int START = 8388611;
  
  public GravityCompat() {}
  
  public static void apply(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, int paramInt4, int paramInt5, Rect paramRect2, int paramInt6)
  {
    int i = Build.VERSION.SDK_INT;
    Gravity.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramInt4, paramInt5, paramRect2, paramInt6);
  }
  
  public static void apply(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2, int paramInt4)
  {
    int i = Build.VERSION.SDK_INT;
    Gravity.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2, paramInt4);
  }
  
  public static void applyDisplay(int paramInt1, Rect paramRect1, Rect paramRect2, int paramInt2)
  {
    int i = Build.VERSION.SDK_INT;
    Gravity.applyDisplay(paramInt1, paramRect1, paramRect2, paramInt2);
  }
  
  public static int getAbsoluteGravity(int paramInt1, int paramInt2)
  {
    int i = Build.VERSION.SDK_INT;
    return Gravity.getAbsoluteGravity(paramInt1, paramInt2);
  }
}
