package f.objectweb.asm;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewManager;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import support.android.v4.view.ViewCompat;

public class b
{
  public b() {}
  
  public static void a(View paramView, Runnable paramRunnable)
  {
    if (a(paramView))
    {
      paramRunnable.run();
      return;
    }
    ViewTreeObserver localViewTreeObserver = paramView.getViewTreeObserver();
    localViewTreeObserver.addOnGlobalLayoutListener(new IonicKeyboard.1(localViewTreeObserver, paramView, paramRunnable));
  }
  
  public static void a(ViewManager paramViewManager, View paramView)
  {
    if (paramViewManager != null)
    {
      if (paramView == null) {
        return;
      }
      try
      {
        paramViewManager.removeView(paramView);
        return;
      }
      catch (Exception paramViewManager) {}
    }
  }
  
  public static boolean a(View paramView)
  {
    return (ViewCompat.isLaidOut(paramView)) && (paramView.getWidth() > 0) && (paramView.getHeight() > 0);
  }
  
  public static void removeOnGlobalLayoutListener(ViewTreeObserver paramViewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    int i = Build.VERSION.SDK_INT;
    paramViewTreeObserver.removeOnGlobalLayoutListener(paramOnGlobalLayoutListener);
  }
}
