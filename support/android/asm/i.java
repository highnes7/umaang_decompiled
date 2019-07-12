package support.android.asm;

import android.graphics.Matrix;
import android.view.View;
import b.b.a.K;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@K(21)
public class i
  extends h
{
  public static boolean b = false;
  public static Method c;
  public static Method d;
  public static boolean e = false;
  public static Method sSetWindowLayoutTypeMethod;
  public static boolean sSetWindowLayoutTypeMethodAttempted = false;
  public static final String t = "ViewUtilsApi21";
  
  public i() {}
  
  private void a()
  {
    if (!e)
    {
      try
      {
        Method localMethod = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[] { Matrix.class });
        d = localMethod;
        localMethod = d;
        localMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;) {}
      }
      e = true;
      return;
    }
  }
  
  private void b()
  {
    if (!b)
    {
      try
      {
        Method localMethod = View.class.getDeclaredMethod("setAnimationMatrix", new Class[] { Matrix.class });
        c = localMethod;
        localMethod = c;
        localMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;) {}
      }
      b = true;
      return;
    }
  }
  
  private void setWindowLayoutType()
  {
    if (!sSetWindowLayoutTypeMethodAttempted)
    {
      try
      {
        Method localMethod = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[] { Matrix.class });
        sSetWindowLayoutTypeMethod = localMethod;
        localMethod = sSetWindowLayoutTypeMethod;
        localMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;) {}
      }
      sSetWindowLayoutTypeMethodAttempted = true;
      return;
    }
  }
  
  public void a(View paramView, Matrix paramMatrix)
  {
    b();
    Method localMethod = c;
    if (localMethod != null) {
      try
      {
        localMethod.invoke(paramView, new Object[] { paramMatrix });
        return;
      }
      catch (IllegalAccessException paramView)
      {
        throw new RuntimeException(paramView.getCause());
      }
      catch (InvocationTargetException paramView) {}
    }
  }
  
  public void b(View paramView, Matrix paramMatrix)
  {
    a();
    Method localMethod = d;
    if (localMethod != null) {
      try
      {
        localMethod.invoke(paramView, new Object[] { paramMatrix });
        return;
      }
      catch (InvocationTargetException paramView)
      {
        throw new RuntimeException(paramView.getCause());
      }
      catch (IllegalAccessException paramView) {}
    }
  }
  
  public void draw(View paramView, Matrix paramMatrix)
  {
    setWindowLayoutType();
    Method localMethod = sSetWindowLayoutTypeMethod;
    if (localMethod != null) {
      try
      {
        localMethod.invoke(paramView, new Object[] { paramMatrix });
        return;
      }
      catch (InvocationTargetException paramView)
      {
        throw new RuntimeException(paramView.getCause());
      }
      catch (IllegalAccessException paramView) {}
    }
  }
}
