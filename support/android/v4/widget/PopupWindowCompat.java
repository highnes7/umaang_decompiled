package support.android.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class PopupWindowCompat
{
  public static final String TAG = "PopupWindowCompatApi21";
  public static boolean b;
  public static Method sGetWindowLayoutTypeMethod;
  public static boolean sGetWindowLayoutTypeMethodAttempted;
  public static Method sSetWindowLayoutTypeMethod;
  public static boolean sSetWindowLayoutTypeMethodAttempted;
  public static Field w;
  
  public PopupWindowCompat() {}
  
  public static int getWindowLayoutType(PopupWindow paramPopupWindow)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramPopupWindow.getWindowLayoutType();
    }
    if (!sGetWindowLayoutTypeMethodAttempted) {}
    try
    {
      localMethod = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);
      sGetWindowLayoutTypeMethod = localMethod;
      localMethod = sGetWindowLayoutTypeMethod;
      localMethod.setAccessible(true);
    }
    catch (Exception localException)
    {
      Method localMethod;
      for (;;) {}
    }
    sGetWindowLayoutTypeMethodAttempted = true;
    localMethod = sGetWindowLayoutTypeMethod;
    if (localMethod != null) {}
    try
    {
      paramPopupWindow = localMethod.invoke(paramPopupWindow, new Object[0]);
      paramPopupWindow = (Integer)paramPopupWindow;
      int i = paramPopupWindow.intValue();
      return i;
    }
    catch (Exception paramPopupWindow) {}
    return 0;
    return 0;
  }
  
  public static void init(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      paramPopupWindow.setOverlapAnchor(paramBoolean);
      return;
    }
    if (i >= 21)
    {
      if (!b) {}
      try
      {
        localField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
        w = localField;
        localField = w;
        localField.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;)
        {
          try
          {
            Field localField;
            localField.set(paramPopupWindow, Boolean.valueOf(paramBoolean));
            return;
          }
          catch (IllegalAccessException paramPopupWindow) {}
          localNoSuchFieldException = localNoSuchFieldException;
        }
      }
      b = true;
      localField = w;
      if (localField == null) {}
    }
  }
  
  public static boolean init(PopupWindow paramPopupWindow)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23) {
      return paramPopupWindow.getOverlapAnchor();
    }
    if ((i < 21) || (!b)) {}
    try
    {
      localField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
      w = localField;
      localField = w;
      localField.setAccessible(true);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Field localField;
      for (;;) {}
    }
    b = true;
    localField = w;
    if (localField != null) {}
    try
    {
      paramPopupWindow = localField.get(paramPopupWindow);
      paramPopupWindow = (Boolean)paramPopupWindow;
      boolean bool = paramPopupWindow.booleanValue();
      return bool;
    }
    catch (IllegalAccessException paramPopupWindow)
    {
      for (;;) {}
    }
    return false;
  }
  
  public static void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramPopupWindow.setWindowLayoutType(paramInt);
      return;
    }
    if (!sSetWindowLayoutTypeMethodAttempted) {
      localObject = Integer.TYPE;
    }
    try
    {
      localObject = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[] { localObject });
      sSetWindowLayoutTypeMethod = (Method)localObject;
      localObject = sSetWindowLayoutTypeMethod;
      ((Method)localObject).setAccessible(true);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          ((Method)localObject).invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
          return;
        }
        catch (Exception paramPopupWindow) {}
        localException = localException;
      }
    }
    sSetWindowLayoutTypeMethodAttempted = true;
    Object localObject = sSetWindowLayoutTypeMethod;
    if (localObject != null) {}
  }
  
  public static void showAsDropDown(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Build.VERSION.SDK_INT;
    paramPopupWindow.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
  }
}
