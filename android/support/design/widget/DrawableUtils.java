package android.support.design.widget;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import b.b.a.N;
import java.lang.reflect.Method;

@N({b.b.a.N.a.b})
public class DrawableUtils
{
  public static final String LOG_TAG = "DrawableUtils";
  public static Method setConstantStateMethod;
  public static boolean setConstantStateMethodFetched;
  
  public DrawableUtils() {}
  
  public static boolean setContainerConstantState(DrawableContainer paramDrawableContainer, Drawable.ConstantState paramConstantState)
  {
    return setContainerConstantStateV9(paramDrawableContainer, paramConstantState);
  }
  
  public static boolean setContainerConstantStateV9(DrawableContainer paramDrawableContainer, Drawable.ConstantState paramConstantState)
  {
    if (!setConstantStateMethodFetched) {}
    try
    {
      localMethod = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[] { DrawableContainer.DrawableContainerState.class });
      setConstantStateMethod = localMethod;
      localMethod = setConstantStateMethod;
      localMethod.setAccessible(true);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Method localMethod;
      for (;;) {}
    }
    setConstantStateMethodFetched = true;
    localMethod = setConstantStateMethod;
    if (localMethod != null) {}
    try
    {
      localMethod.invoke(paramDrawableContainer, new Object[] { paramConstantState });
      return true;
    }
    catch (Exception paramDrawableContainer) {}
    return false;
    return false;
  }
}
