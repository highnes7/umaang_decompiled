package support.android.asm;

import android.support.transition.Fade;
import android.support.transition.Transition;
import android.view.View;

public class t
  extends f
{
  public t(Fade paramFade, View paramView) {}
  
  public void a(Transition paramTransition)
  {
    View localView = a;
    Frame.a.a(localView, 1.0F);
    localView = a;
    Frame.a.setTitle(localView);
    paramTransition.removeListener(this);
  }
}
