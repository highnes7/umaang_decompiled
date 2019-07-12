package support.android.v4.view;

import android.view.VelocityTracker;

@Deprecated
public final class VelocityTrackerCompat
{
  public VelocityTrackerCompat() {}
  
  public static float getXVelocity(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return paramVelocityTracker.getXVelocity(paramInt);
  }
  
  public static float getYVelocity(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return paramVelocityTracker.getYVelocity(paramInt);
  }
}
