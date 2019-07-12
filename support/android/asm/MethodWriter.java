package support.android.asm;

import android.view.ViewGroup;
import b.b.a.K;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@K(18)
public class MethodWriter
{
  public static Method d;
  public static final String descriptor = "ViewUtilsApi18";
  public static boolean r;
  
  public MethodWriter() {}
  
  public static void a()
  {
    if (!r)
    {
      Object localObject = Boolean.TYPE;
      try
      {
        localObject = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[] { localObject });
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
  
  public static void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    a();
    Method localMethod = d;
    if (localMethod != null) {
      try
      {
        localMethod.invoke(paramViewGroup, new Object[] { Boolean.valueOf(paramBoolean) });
        return;
      }
      catch (IllegalAccessException paramViewGroup) {}catch (InvocationTargetException paramViewGroup) {}
    }
  }
}
