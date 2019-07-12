package support.android.v4.asm;

import b.b.a.K;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@K(21)
public class ParceledListSliceAdapterApi21
{
  public static Constructor sConstructor;
  
  static
  {
    try
    {
      Object localObject = Class.forName("android.content.pm.ParceledListSlice");
      localObject = ((Class)localObject).getConstructor(new Class[] { List.class });
      sConstructor = (Constructor)localObject;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}catch (ClassNotFoundException localClassNotFoundException) {}
    ((ReflectiveOperationException)localClassNotFoundException).printStackTrace();
  }
  
  public ParceledListSliceAdapterApi21() {}
  
  public static Object newInstance(List paramList)
  {
    Constructor localConstructor = sConstructor;
    try
    {
      paramList = localConstructor.newInstance(new Object[] { paramList });
      return paramList;
    }
    catch (InvocationTargetException paramList) {}catch (IllegalAccessException paramList) {}catch (InstantiationException paramList) {}
    ((ReflectiveOperationException)paramList).printStackTrace();
    return null;
  }
}
