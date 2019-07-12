package f.g.c.eventbus;

import f.g.c.package_10.Preconditions;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EventHandler
{
  public final Method method;
  public final Object target;
  
  public EventHandler(Object paramObject, Method paramMethod)
  {
    Preconditions.checkNotNull(paramObject, "EventHandler target cannot be null.");
    Preconditions.checkNotNull(paramMethod, "EventHandler method cannot be null.");
    target = paramObject;
    method = paramMethod;
    paramMethod.setAccessible(true);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (EventHandler)paramObject;
    return (method.equals(method)) && (target == target);
  }
  
  public void handleEvent(Object paramObject)
    throws InvocationTargetException
  {
    Method localMethod = method;
    Object localObject = target;
    try
    {
      localMethod.invoke(localObject, new Object[] { paramObject });
      return;
    }
    catch (InvocationTargetException paramObject)
    {
      if ((paramObject.getCause() instanceof Error)) {
        throw ((Error)paramObject.getCause());
      }
      throw paramObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new Error(StringBuilder.toString("Method became inaccessible: ", paramObject), localIllegalAccessException);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new Error(StringBuilder.toString("Method rejected target/argument: ", paramObject), localIllegalArgumentException);
    }
  }
  
  public int hashCode()
  {
    int i = method.hashCode();
    return target.hashCode() + (i + 31) * 31;
  }
  
  public String toString()
  {
    return StringBuilder.append(StringBuilder.append("[wrapper "), method, "]");
  }
}
