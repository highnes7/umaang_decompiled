package android.support.design.animation;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import b.b.a.N;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import support.android.v4.view.animation.FastOutLinearInInterpolator;
import support.android.v4.view.animation.FastOutSlowInInterpolator;
import support.android.v4.view.animation.LinearOutSlowInInterpolator;

@N({b.b.a.N.a.b})
public class AnimationUtils
{
  public static final TimeInterpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
  public static final TimeInterpolator FAST_OUT_LINEAR_IN_INTERPOLATOR;
  public static final TimeInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR;
  public static final TimeInterpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
  public static final TimeInterpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR;
  
  static
  {
    FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutLinearInInterpolator();
    FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
    LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();
  }
  
  public AnimationUtils() {}
  
  public static float lerp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return StringBuilder.append(paramFloat2, paramFloat1, paramFloat3, paramFloat1);
  }
  
  public static int lerp(int paramInt1, int paramInt2, float paramFloat)
  {
    return Math.round(paramFloat * (paramInt2 - paramInt1)) + paramInt1;
  }
}
