package support.android.asm;

import android.view.View;
import b.b.a.K;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@K(22)
public class e
  extends i
{
  public static boolean b = false;
  public static Method c;
  public static final String e = "ViewUtilsApi22";
  
  public e() {}
  
  private void a()
  {
    if (!b)
    {
      Object localObject = Integer.TYPE;
      Class localClass1 = Integer.TYPE;
      Class localClass2 = Integer.TYPE;
      Class localClass3 = Integer.TYPE;
      try
      {
        localObject = View.class.getDeclaredMethod("setLeftTopRightBottom", new Class[] { localObject, localClass1, localClass2, localClass3 });
        c = (Method)localObject;
        localObject = c;
        ((Method)localObject).setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;) {}
      }
      b = true;
      return;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a();
    Method localMethod = c;
    if (localMethod != null) {
      try
      {
        localMethod.invoke(paramView, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
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
