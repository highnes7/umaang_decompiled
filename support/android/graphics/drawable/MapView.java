package support.android.graphics.drawable;

import android.graphics.drawable.Animatable2.AnimationCallback;
import android.graphics.drawable.Drawable;

public class MapView
  extends Animatable2.AnimationCallback
{
  public MapView(View paramView) {}
  
  public void onAnimationEnd(Drawable paramDrawable)
  {
    view.clear(paramDrawable);
  }
  
  public void onAnimationStart(Drawable paramDrawable)
  {
    view.set(paramDrawable);
  }
}
