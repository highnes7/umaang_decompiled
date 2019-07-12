package support.support.asm;

import b.a.b.a.b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Label
{
  public final int a;
  public final Method b;
  
  public Label(int paramInt, Method paramMethod)
  {
    a = paramInt;
    b = paramMethod;
    b.setAccessible(true);
  }
  
  public void a(d paramD, c paramC, Object paramObject)
  {
    int i = a;
    Method localMethod;
    if (i != 0) {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        localMethod = b;
      }
    }
    try
    {
      localMethod.invoke(paramObject, new Object[] { paramD, paramC });
      return;
    }
    catch (IllegalAccessException paramD)
    {
      throw new RuntimeException(paramD);
    }
    catch (InvocationTargetException paramD)
    {
      throw new RuntimeException("Failed to call observer method", paramD.getCause());
    }
    paramC = b;
    paramC.invoke(paramObject, new Object[] { paramD });
    return;
    paramD = b;
    paramD.invoke(paramObject, new Object[0]);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (a.b.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (Label)paramObject;
      return (a == a) && (b.getName().equals(b.getName()));
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = a;
    return b.getName().hashCode() + i * 31;
  }
}
