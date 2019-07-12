package f.objectweb.asm;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

public class w
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public w(PagerSlidingTabStrip paramPagerSlidingTabStrip, f paramF, ViewGroup paramViewGroup, Context paramContext) {}
  
  public void onGlobalLayout()
  {
    if (PagerSlidingTabStrip.a(a)) {
      return;
    }
    a.draw();
    c.a(new MonthByWeekFragment.2(this));
  }
}
