package support.android.asm;

import android.support.transition.Transition;
import android.support.transition.Transition.e;
import android.view.View;
import java.util.ArrayList;

public class ActionMenuItemView
  implements Transition.e
{
  public ActionMenuItemView(ASN1Integer paramASN1Integer, View paramView, ArrayList paramArrayList) {}
  
  public void a(Transition paramTransition)
  {
    paramTransition.removeListener(this);
    c.setVisibility(8);
    int j = b.size();
    int i = 0;
    while (i < j)
    {
      ((View)b.get(i)).setVisibility(0);
      i += 1;
    }
  }
  
  public void b(Transition paramTransition) {}
  
  public void c(Transition paramTransition) {}
  
  public void d(Transition paramTransition) {}
  
  public void e(Transition paramTransition) {}
}
