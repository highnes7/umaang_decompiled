package support.android.asm;

import android.support.transition.Slide.b;
import android.view.View;
import android.view.ViewGroup;

public final class FlurryAdSize
  extends Slide.b
{
  public FlurryAdSize()
  {
    super(null);
  }
  
  public float a(ViewGroup paramViewGroup, View paramView)
  {
    return paramView.getTranslationX() + paramViewGroup.getWidth();
  }
}
