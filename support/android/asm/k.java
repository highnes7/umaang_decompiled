package support.android.asm;

import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

public class k
{
  public k() {}
  
  public static b a(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return Configurator.a(paramView, paramViewGroup, paramMatrix);
    }
    return PagerSlidingTabStrip.a(paramView, paramViewGroup);
  }
  
  public static void a(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Configurator.configure(paramView);
      return;
    }
    PagerSlidingTabStrip.a(paramView);
  }
}
