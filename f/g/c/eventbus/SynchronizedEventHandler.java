package f.g.c.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SynchronizedEventHandler
  extends EventHandler
{
  public SynchronizedEventHandler(Object paramObject, Method paramMethod)
  {
    super(paramObject, paramMethod);
  }
  
  public void handleEvent(Object paramObject)
    throws InvocationTargetException
  {
    try
    {
      super.handleEvent(paramObject);
      return;
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
  }
}
