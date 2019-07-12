package support.android.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

public final class f
{
  public static Method b;
  public static final String t = "ViewConfigCompat";
  
  static
  {
    if (Build.VERSION.SDK_INT == 25) {
      try
      {
        Method localMethod = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
        b = localMethod;
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  public f() {}
  
  public static float a(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramViewConfiguration.getScaledVerticalScrollFactor();
    }
    return b(paramViewConfiguration, paramContext);
  }
  
  public static float b(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    Method localMethod;
    if (Build.VERSION.SDK_INT >= 25)
    {
      localMethod = b;
      if (localMethod == null) {}
    }
    try
    {
      paramViewConfiguration = localMethod.invoke(paramViewConfiguration, new Object[0]);
      paramViewConfiguration = (Integer)paramViewConfiguration;
      int i = paramViewConfiguration.intValue();
      return i;
    }
    catch (Exception paramViewConfiguration)
    {
      for (;;) {}
    }
    paramViewConfiguration = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(16842829, paramViewConfiguration, true)) {
      return paramViewConfiguration.getDimension(paramContext.getResources().getDisplayMetrics());
    }
    return 0.0F;
  }
  
  public static float d(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramViewConfiguration.getScaledHorizontalScrollFactor();
    }
    return b(paramViewConfiguration, paramContext);
  }
  
  public static boolean get(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramViewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
    }
    paramViewConfiguration = paramContext.getResources();
    int i = paramViewConfiguration.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
    return (i != 0) && (paramViewConfiguration.getBoolean(i));
  }
  
  public static int getScaledPagingTouchSlop(ViewConfiguration paramViewConfiguration)
  {
    return paramViewConfiguration.getScaledPagingTouchSlop();
  }
  
  public static boolean hasPermanentMenuKey(ViewConfiguration paramViewConfiguration)
  {
    return paramViewConfiguration.hasPermanentMenuKey();
  }
  
  public static int init(ViewConfiguration paramViewConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramViewConfiguration.getScaledHoverSlop();
    }
    return paramViewConfiguration.getScaledTouchSlop() / 2;
  }
}
