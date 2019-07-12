package android.support.v4.package_7;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import b.b.a.K;
import support.android.v4.util.Type;

public class ActivityOptionsCompat
{
  public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
  public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";
  
  public ActivityOptionsCompat() {}
  
  public static ActivityOptionsCompat makeBasic()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return new ActivityOptionsCompatImpl(ActivityOptions.makeBasic());
    }
    return new ActivityOptionsCompat();
  }
  
  public static ActivityOptionsCompat makeClipRevealAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return new ActivityOptionsCompatImpl(ActivityOptions.makeClipRevealAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
    }
    return new ActivityOptionsCompat();
  }
  
  public static ActivityOptionsCompat makeCustomAnimation(Context paramContext, int paramInt1, int paramInt2)
  {
    int i = Build.VERSION.SDK_INT;
    return new ActivityOptionsCompatImpl(ActivityOptions.makeCustomAnimation(paramContext, paramInt1, paramInt2));
  }
  
  public static ActivityOptionsCompat makeScaleUpAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = Build.VERSION.SDK_INT;
    return new ActivityOptionsCompatImpl(ActivityOptions.makeScaleUpAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity paramActivity, View paramView, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new ActivityOptionsCompatImpl(ActivityOptions.makeSceneTransitionAnimation(paramActivity, paramView, paramString));
    }
    return new ActivityOptionsCompat();
  }
  
  public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity paramActivity, Type... paramVarArgs)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = null;
      if (paramVarArgs != null)
      {
        Pair[] arrayOfPair = new Pair[paramVarArgs.length];
        int i = 0;
        for (;;)
        {
          localObject = arrayOfPair;
          if (i >= paramVarArgs.length) {
            break;
          }
          arrayOfPair[i] = Pair.create(c, b);
          i += 1;
        }
      }
      return new ActivityOptionsCompatImpl(ActivityOptions.makeSceneTransitionAnimation(paramActivity, localObject));
    }
    return new ActivityOptionsCompat();
  }
  
  public static ActivityOptionsCompat makeTaskLaunchBehind()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new ActivityOptionsCompatImpl(ActivityOptions.makeTaskLaunchBehind());
    }
    return new ActivityOptionsCompat();
  }
  
  public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View paramView, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = Build.VERSION.SDK_INT;
    return new ActivityOptionsCompatImpl(ActivityOptions.makeThumbnailScaleUpAnimation(paramView, paramBitmap, paramInt1, paramInt2));
  }
  
  public Rect getLaunchBounds()
  {
    return null;
  }
  
  public void requestUsageTimeReport(PendingIntent paramPendingIntent) {}
  
  public ActivityOptionsCompat setLaunchBounds(Rect paramRect)
  {
    return this;
  }
  
  public Bundle toBundle()
  {
    return null;
  }
  
  public void update(ActivityOptionsCompat paramActivityOptionsCompat) {}
  
  @K(16)
  public class ActivityOptionsCompatImpl
    extends ActivityOptionsCompat
  {
    public ActivityOptionsCompatImpl() {}
    
    public Rect getLaunchBounds()
    {
      if (Build.VERSION.SDK_INT < 24) {
        return null;
      }
      return ActivityOptionsCompat.this.getLaunchBounds();
    }
    
    public void requestUsageTimeReport(PendingIntent paramPendingIntent)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        ActivityOptionsCompat.this.requestUsageTimeReport(paramPendingIntent);
      }
    }
    
    public ActivityOptionsCompat setLaunchBounds(Rect paramRect)
    {
      if (Build.VERSION.SDK_INT < 24) {
        return this;
      }
      return new ActivityOptionsCompatImpl(setLaunchBounds(paramRect));
    }
    
    public Bundle toBundle()
    {
      return ActivityOptionsCompat.this.toBundle();
    }
    
    public void update(ActivityOptionsCompat paramActivityOptionsCompat)
    {
      if ((paramActivityOptionsCompat instanceof ActivityOptionsCompatImpl))
      {
        paramActivityOptionsCompat = (ActivityOptionsCompatImpl)paramActivityOptionsCompat;
        update(mActivityOptions);
      }
    }
  }
}
