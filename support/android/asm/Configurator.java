package support.android.asm;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import b.b.a.K;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@K(21)
public class Configurator
  implements b
{
  public static final String NULL = "GhostViewApi21";
  public static boolean configured;
  public static boolean f;
  public static boolean initFailed;
  public static Method nativeGetAlpnNegotiatedProtocol;
  public static Method sendMessageMethod;
  public static Class<?> this$0;
  public final View view;
  
  public Configurator(View paramView)
  {
    view = paramView;
  }
  
  public static b a(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
  {
    configure();
    Method localMethod = nativeGetAlpnNegotiatedProtocol;
    if (localMethod != null) {
      try
      {
        paramView = localMethod.invoke(null, new Object[] { paramView, paramViewGroup, paramMatrix });
        paramView = (View)paramView;
        paramView = new Configurator(paramView);
        return paramView;
      }
      catch (InvocationTargetException paramView)
      {
        throw new RuntimeException(paramView.getCause());
      }
      catch (IllegalAccessException paramView) {}
    }
    return null;
  }
  
  public static void a()
  {
    if (!f)
    {
      try
      {
        Class localClass = Class.forName("android.view.GhostView");
        this$0 = localClass;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;) {}
      }
      f = true;
      return;
    }
  }
  
  public static void configure()
  {
    if (!configured)
    {
      try
      {
        a();
        Object localObject = this$0;
        localObject = ((Class)localObject).getDeclaredMethod("addGhost", new Class[] { View.class, ViewGroup.class, Matrix.class });
        nativeGetAlpnNegotiatedProtocol = (Method)localObject;
        localObject = nativeGetAlpnNegotiatedProtocol;
        ((Method)localObject).setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;) {}
      }
      configured = true;
      return;
    }
  }
  
  public static void configure(View paramView)
  {
    initReflection();
    Method localMethod = sendMessageMethod;
    if (localMethod != null) {
      try
      {
        localMethod.invoke(null, new Object[] { paramView });
        return;
      }
      catch (InvocationTargetException paramView)
      {
        throw new RuntimeException(paramView.getCause());
      }
      catch (IllegalAccessException paramView) {}
    }
  }
  
  public static void initReflection()
  {
    if (!initFailed)
    {
      try
      {
        a();
        Object localObject = this$0;
        localObject = ((Class)localObject).getDeclaredMethod("removeGhost", new Class[] { View.class });
        sendMessageMethod = (Method)localObject;
        localObject = sendMessageMethod;
        ((Method)localObject).setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;) {}
      }
      initFailed = true;
      return;
    }
  }
  
  public void a(ViewGroup paramViewGroup, View paramView) {}
  
  public void setVisibility(int paramInt)
  {
    view.setVisibility(paramInt);
  }
}
