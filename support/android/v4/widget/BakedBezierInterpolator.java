package support.android.v4.widget;

import android.view.animation.Interpolator;

public final class BakedBezierInterpolator
  implements Interpolator
{
  public BakedBezierInterpolator() {}
  
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * paramFloat * paramFloat * paramFloat * paramFloat + 1.0F;
  }
}
