package support.android.asm;

import android.os.Build.VERSION;
import android.support.transition.ChangeBounds;
import android.support.transition.Transition;
import android.view.ViewGroup;

public class p
  extends f
{
  public boolean e = false;
  
  public p(ChangeBounds paramChangeBounds, ViewGroup paramViewGroup) {}
  
  public void a(Transition paramTransition)
  {
    if (!e)
    {
      ViewGroup localViewGroup = a;
      int i = Build.VERSION.SDK_INT;
      MethodWriter.a(localViewGroup, false);
    }
    paramTransition.removeListener(this);
  }
  
  public void b(Transition paramTransition)
  {
    paramTransition = a;
    int i = Build.VERSION.SDK_INT;
    MethodWriter.a(paramTransition, false);
  }
  
  public void c(Transition paramTransition)
  {
    paramTransition = a;
    int i = Build.VERSION.SDK_INT;
    MethodWriter.a(paramTransition, true);
  }
  
  public void d(Transition paramTransition)
  {
    paramTransition = a;
    int i = Build.VERSION.SDK_INT;
    MethodWriter.a(paramTransition, false);
    e = true;
  }
}
