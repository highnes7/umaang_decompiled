package support.android.graphics.drawable;

import android.graphics.drawable.Animatable;

public abstract interface CircleDrawable
  extends Animatable
{
  public abstract void clearAnimationCallbacks();
  
  public abstract boolean draw(View paramView);
  
  public abstract void start(View paramView);
}
