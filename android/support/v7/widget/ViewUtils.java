package android.support.v7.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import b.b.a.N;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import support.android.v4.view.ViewCompat;

@N({b.b.a.N.a.b})
public class ViewUtils
{
  public static final String TAG = "ViewUtils";
  public static Method sComputeFitSystemWindowsMethod;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    try
    {
      Method localMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[] { Rect.class, Rect.class });
      sComputeFitSystemWindowsMethod = localMethod;
      localMethod = sComputeFitSystemWindowsMethod;
      boolean bool = localMethod.isAccessible();
      if (!bool)
      {
        localMethod = sComputeFitSystemWindowsMethod;
        localMethod.setAccessible(true);
        return;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  public ViewUtils() {}
  
  public static void computeFitSystemWindows(View paramView, Rect paramRect1, Rect paramRect2)
  {
    Method localMethod = sComputeFitSystemWindowsMethod;
    if (localMethod != null) {
      try
      {
        localMethod.invoke(paramView, new Object[] { paramRect1, paramRect2 });
        return;
      }
      catch (Exception paramView) {}
    }
  }
  
  public static boolean isLayoutRtl(View paramView)
  {
    return ViewCompat.getLayoutDirection(paramView) == 1;
  }
  
  public static void makeOptionalFitsSystemWindows(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    try
    {
      Object localObject = paramView.getClass();
      localObject = ((Class)localObject).getMethod("makeOptionalFitsSystemWindows", new Class[0]);
      boolean bool = ((Method)localObject).isAccessible();
      if (!bool) {
        ((Method)localObject).setAccessible(true);
      }
      ((Method)localObject).invoke(paramView, new Object[0]);
      return;
    }
    catch (NoSuchMethodException paramView) {}catch (InvocationTargetException paramView) {}catch (IllegalAccessException paramView) {}
  }
}
