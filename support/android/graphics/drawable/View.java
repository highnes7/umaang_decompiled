package support.android.graphics.drawable;

import android.graphics.drawable.Animatable2.AnimationCallback;
import android.graphics.drawable.Drawable;

public abstract class View
{
  public Animatable2.AnimationCallback clear;
  
  public View() {}
  
  public Animatable2.AnimationCallback clear()
  {
    if (clear == null) {
      clear = new MapView(this);
    }
    return clear;
  }
  
  public void clear(Drawable paramDrawable) {}
  
  public void set(Drawable paramDrawable) {}
}
