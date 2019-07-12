package support.android.asm;

import android.view.View;
import b.b.a.K;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@K(19)
public class h
  extends l
{
  public static final String F = "ViewUtilsApi19";
  public static boolean b;
  public static Method c;
  public static Method d;
  public static boolean r;
  
  public h() {}
  
  private void a()
  {
    if (!r)
    {
      Object localObject = Float.TYPE;
      try
      {
        localObject = View.class.getDeclaredMethod("setTransitionAlpha", new Class[] { localObject });
        d = (Method)localObject;
        localObject = d;
        ((Method)localObject).setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;) {}
      }
      r = true;
      return;
    }
  }
  
  private void b()
  {
    if (!b)
    {
      try
      {
        Method localMethod = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
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
  
  public float a(View paramView)
  {
    b();
    Object localObject = c;
    if (localObject != null) {}
    try
    {
      localObject = ((Method)localObject).invoke(paramView, new Object[0]);
      localObject = (Float)localObject;
      float f = ((Float)localObject).floatValue();
      return f;
    }
    catch (InvocationTargetException paramView)
    {
      throw new RuntimeException(paramView.getCause());
      return super.a(paramView);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
  }
  
  public void a(View paramView, float paramFloat)
  {
    a();
    Method localMethod = d;
    if (localMethod != null) {}
    try
    {
      localMethod.invoke(paramView, new Object[] { Float.valueOf(paramFloat) });
      return;
    }
    catch (InvocationTargetException paramView)
    {
      throw new RuntimeException(paramView.getCause());
      paramView.setAlpha(paramFloat);
      return;
    }
    catch (IllegalAccessException paramView) {}
  }
  
  public void b(View paramView) {}
  
  public void setTitle(View paramView) {}
}
